/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Dao.Dao;
import Dao.Dao_adopcion;
import Dao.Dao_mascotas;
import Dao.Dao_usuarios;
import java.io.File;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.adopcion;
import models.adopcionBeanValidator;
import models.mascotaBean1;
import models.usuarioBean;
import models.usuarioBeanvalidator;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SENA
 */
@Controller
public class adoptar_controller {
       private JdbcTemplate JdbcTemplate;
       private adopcionBeanValidator adopcionBeanValidator;
  
    
 public adoptar_controller(){
        Dao con = new Dao();
        JdbcTemplate = new JdbcTemplate(con.conDB());
        this.adopcionBeanValidator = new adopcionBeanValidator();

}
    
    
    
    @RequestMapping(value = "listar_Adopciones.htm", method = RequestMethod.GET )
    public ModelAndView listarAdopcion(){
        ModelAndView mav= new ModelAndView();
        adopcion a = new adopcion();
        Dao_adopcion adopcionDao = new Dao_adopcion();
        List datos = adopcionDao.consultarAdopciones();
        mav.addObject("adopcion", datos);
        mav.setViewName("views/adopcion/listar_Adopciones");
        return mav;
    
    
    }
     @RequestMapping(value = "agregar_Adopciones.htm", method = RequestMethod.GET )
     public ModelAndView agregar_adopcion(){
      ModelAndView mav= new ModelAndView();
      adopcion a = new adopcion();
      Dao_usuarios u = new Dao_usuarios();
      Dao_adopcion Dao_adopcion = new Dao_adopcion();
      Dao_mascotas mas = new Dao_mascotas();
      List datosus = u.consultarUsuariosAdop();
      mav.addObject("listarusuario",datosus);
      List datos = mas.consultarMAscotasAdop();
      mav.addObject("listarMascotas",datos);
      int cod = Dao_adopcion.consultarIdAdopcion();
      a.setCod(cod);
      mav.addObject("listaradopciones",a);
      
      mav.setViewName("views/adopcion/agregar_Adopciones");
      return mav;
    
     }
     
    
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
       @RequestMapping(value="agregar_Adopciones.htm", method = RequestMethod.POST)
     public ModelAndView agregar_adopcion( @ModelAttribute("adopcion") adopcion user,
        BindingResult result,
        SessionStatus status
        ){
       this.adopcionBeanValidator.validate(user, result);
       if(result.hasErrors()){
        ModelAndView mov = new ModelAndView();
        mov.addObject("adopcion", new adopcion());
        mov.setViewName("views/adoptar/agregar_Adopciones");
        return mov;
        }else{ModelAndView mav = new ModelAndView();
        String sql ="insert into adopcion(cod, fecha, id_mascota,id_usuario)values(?,?,?,?)  ";
        this.JdbcTemplate.update(sql,user.getCod(),user.getFecha(),user.getId_mascota(),user.getId_usuario());
        mav.setViewName("redirect:/listar_Adopciones.htm");
       
                return mav;
                
                }    
   }
     
      
    @RequestMapping("delete_Adopcion.htm")
    public ModelAndView borrarMascota(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        int cod = Integer.parseInt(req.getParameter("cod"));
        String sql = "delete  from adopcion where cod = ? ";
        JdbcTemplate.update(sql ,cod);
        mav.setViewName("redirect:/listar_Adopciones.htm");
        return mav;
        
    }
    
     @RequestMapping(value="update_Adopcion.htm", method = RequestMethod.GET)
    public ModelAndView updateAdopcion(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        int cod = Integer.parseInt(req.getParameter("cod"));
        adopcion usu = consultarcliente(cod);
        Dao_usuarios u = new Dao_usuarios();
        Dao_mascotas mas = new Dao_mascotas();
        List datosus = u.consultarUsuariosAdop();
        mav.addObject("listarusuario",datosus);
        List datos = mas.consultarMAscotasAdop();
        mav.addObject("listarMascotas",datos);
        mav.addObject("adopcion", usu);
        mav.setViewName("views/adopcion/updateadopcion");
        return mav;
    }
    private adopcion consultarcliente(int cod) {
    adopcion usu = new adopcion();
    String sql = "select * from adopcion  where cod ="+ cod;
    return (adopcion)JdbcTemplate.query(
    sql,
    new ResultSetExtractor<adopcion>(){

        @Override
        public adopcion extractData(ResultSet rs) throws SQLException, DataAccessException {
          if(rs.next()){  
              usu.setCod(rs.getInt("cod"));
              usu.setFecha(rs.getString("fecha"));
              usu.setId_mascota(rs.getString("id_mascota"));
              usu.setId_usuario(rs.getString("id_usuario"));
              }
        return usu;
        }
    
    }
    );
    }
    
       
    @RequestMapping(value="update_Adopcion.htm", method = RequestMethod.POST)
    public ModelAndView updateUsuario(adopcion u){
        ModelAndView mav = new ModelAndView();
        String sql ="update adopcion set fecha = ?, id_mascota = ?, id_usuario = ? where cod = ?";
        this.JdbcTemplate.update(sql ,u.getFecha(),u.getId_mascota(),u.getId_usuario(),u.getCod());
        mav.setViewName("redirect:/listar_Adopciones.htm");
        return mav;
    }  
}
