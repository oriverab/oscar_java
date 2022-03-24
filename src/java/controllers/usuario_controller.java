/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Dao.Dao;
import Dao.Dao_usuarios;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.adopcion;
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

public class usuario_controller {
    
    
    private JdbcTemplate JdbcTemplate;
    private usuarioBeanvalidator usuariovalidar;
    
    private static final String UPLOAD_DIRECTORY ="..\\..\\web\\public\\img\\fotos";
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;
    
    
    public usuario_controller(){
     Dao con = new Dao();
     JdbcTemplate = new JdbcTemplate(con.conDB());
      this.usuariovalidar = new usuarioBeanvalidator();
    }
    
    
    @RequestMapping("listarClientes.htm")
    
    public ModelAndView formUsuario(){
           ModelAndView mav = new ModelAndView();
           String sql = "select * from usuarios";
           List datos = JdbcTemplate.queryForList(sql);
           mav.addObject("usuarios", datos);
           mav.setViewName("views/usuario/listarClientes");
           return mav;
           
    }

    @RequestMapping(value="agregar_usuario.htm", method = RequestMethod.GET)
    public ModelAndView agregar_usuario(){
    ModelAndView mav = new ModelAndView();
    mav.addObject("usuarioBean", new usuarioBean());
    mav.setViewName("views/usuario/agregar_usuario");
    return mav;
    }
    
    
     @RequestMapping(value="agregar_usuario.htm", method = RequestMethod.POST)
     public ModelAndView agregar_usuario(  usuarioBean user, HttpServletRequest request){
       ModelAndView mov = new ModelAndView();
       String uploadFilePath = request.getSession().getServletContext().getRealPath("../../web/public/img/fotos/");
       String uploadFilePath2 = request.getSession().getServletContext().getRealPath("public/img/fotos/");
       
       boolean isMultipart = ServletFileUpload.isMultipartContent(request);
       ArrayList<String> listados = new ArrayList<>();
       if(isMultipart){
          FileItemFactory file = new DiskFileItemFactory();
          ServletFileUpload fileUpload = new ServletFileUpload(file);
          List<FileItem> items= null;
            try{
                items = fileUpload.parseRequest(request);
            }catch(FileUploadException ex){
            System.out.print("carga"+ ex.getMessage());
            }
            for(int i = 0; i <items.size(); i++){
            FileItem fileItem = (FileItem) items.get(i);
            if(!fileItem.isFormField()){
               File f = new File("/public/img/fotos/" + fileItem.getName());
               String nameFile = ("public/img/fotos/"+ f.getName());
        
               File uploadFile = new File(uploadFilePath, f.getName());
               File uploadFile2 = new File(uploadFilePath2, f.getName());
            try{
      
      fileItem.write(uploadFile);
      fileItem.write(uploadFile2);
      user.setFoto(nameFile);
       }catch(Exception e)
      {
       System.out.print("carga" + e.getMessage());      
       }
        user.setFoto(nameFile); 
      } else{
          listados.add(fileItem.getString());
        }  
      }       
      user.setCedula(listados.get(0));
      user.setNombres(listados.get(1));
      user.setTelefono(listados.get(2));
      user.setEmail(listados.get(3));      
      }
       String sql ="insert into usuarios(cedula, nombres, telefono,email,foto)values(?,?,?,?,?)  ";
        this.JdbcTemplate.update(sql,user.getCedula(),user.getNombres(),user.getTelefono(),user.getEmail(),user.getFoto() );
        mov.setViewName("redirect:/listarClientes.htm");
       
                return mov;
      }
     
    @RequestMapping("delete_usuario.htm")
    public ModelAndView borrarUsuario(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        Dao_usuarios userDao = new Dao_usuarios();
        int id = Integer.parseInt(req.getParameter("id"));
        usuarioBean usu = this.consultarcliente (Integer.parseInt(req.getParameter("id")));
        //Captura la direccion del archivo
        
        String deletePath = req.getServletContext().getRealPath("") + File.separator;
        String foto = req.getParameter("foto");
        //Metodo que borra el cliente y la imagen
        userDao.deleteImg(usu.getFoto(), deletePath, id);
        mav.setViewName("redirect:/listarClientes.htm");
        return mav;
    }
    
    @RequestMapping(value="update_usuario.htm", method = RequestMethod.GET)
    public ModelAndView updateUsuario(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        String fotoOld = req.getParameter("fotoOld");
        usuarioBean usu = consultarcliente(id);
        usu.setFoto(fotoOld);
        mav.addObject("usuarios", usu);
        mav.setViewName("views/usuario/updateusuario");
        return mav;
        
    }

   private usuarioBean consultarcliente(int id) {
    usuarioBean usu = new usuarioBean();
    String sql = "select * from usuarios  where id ="+ id;
    return (usuarioBean)JdbcTemplate.query(
    sql,
    new ResultSetExtractor<usuarioBean>(){

        @Override
        public usuarioBean extractData(ResultSet rs) throws SQLException, DataAccessException {
          if(rs.next()){  
              usu.setId(rs.getString("id"));
              usu.setCedula(rs.getString("cedula"));
              usu.setNombres(rs.getString("nombres"));
              usu.setTelefono(rs.getString("telefono"));
              usu.setEmail(rs.getString("email"));
              usu.setFoto(rs.getString("foto"));
              }
        return usu;
        }
    
    }
    );
    }
    
    @RequestMapping(value="update_usuario.htm", method = RequestMethod.POST)
   public ModelAndView updateUsuario(usuarioBean u, HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        Dao_usuarios usuarioDao = new Dao_usuarios();
        ArrayList<String> listados = new ArrayList<>();
        String uploadPath = req.getServletContext().getRealPath("")+File.separator + UPLOAD_DIRECTORY;
        String deletepath = req.getServletContext().getRealPath("")+File.separator;
        
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        DiskFileItemFactory file = new  DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(file);
        List<FileItem> items= null;
        try{
            
            usuarioDao.borrarImagenactualizada(u.getFotoOld(), deletepath);
            
            items = fileUpload.parseRequest(req);
            for(int i = 0; i < items.size();i++){
                 FileItem fileItem =(FileItem)items.get(i);
                 listados.add(fileItem.getString());
            }
        } catch(FileUploadException ex){
            System.out.print("error en la carga de la imagen"+ex.getMessage());
        }
        if(listados.get(4).isEmpty() || listados.get(4).equals("")|| listados.get(4).equals(null)){
           usuarioDao.accUsuarioSinFoto(u, listados);
        }else{
             usuarioDao.accUsuarioConFoto(u, isMultipart, req, items);
        }
        mav.setViewName("redirect:/listarClientes.htm");
        return mav;
        }
             
    }  
    
    
   
    
    

    
    
    
