/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Dao.Dao;
import Dao.Dao_mascotas;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.adopcion;
import models.mascotaBean1;
import models.mascotaBeanvalidator;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;



/**
 *
 * @author SENA
 */
@Controller

public class Mascota_Controller {
    
     private mascotaBeanvalidator mascotavalidar; 
    private JdbcTemplate JdbcTemplate;
    private static final String UPLOAD_DIRECTORY ="..\\..\\web\\public\\img\\fotos";
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;
    
    
    
    public Mascota_Controller(){
     this.mascotavalidar = new mascotaBeanvalidator();
     Dao con = new Dao();
     JdbcTemplate = new JdbcTemplate(con.conDB());
    }
    
    
    @RequestMapping("listarMascotas.htm")
    
    public ModelAndView formMascota(){
           ModelAndView mav = new ModelAndView();
           String sql = "select * from mascotas";
           List datos = JdbcTemplate.queryForList(sql);
           mav.addObject("mascotas", datos);
           mav.setViewName("views/mascota/listarMascotas");
           return mav;
           
    }

    @RequestMapping(value="agregar_mascota.htm", method = RequestMethod.GET)
    public ModelAndView agregar_mascota(){
    ModelAndView mav = new ModelAndView();
    mav.addObject("mascotaBean1", new mascotaBean1());
    mav.setViewName("views/mascota/agregar_mascota");
    return mav;
    }
    @RequestMapping(value="agregar_mascota.htm", method = RequestMethod.POST)
     public ModelAndView agregar_mascota(  mascotaBean1 masc, HttpServletRequest request){
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
      masc.setFotos(nameFile);
       }catch(Exception e)
      {
       System.out.print("carga" + e.getMessage());      
       }
        masc.setFotos(nameFile);
      } else{
          listados.add(fileItem.getString());
        }  
      } 
            
      masc.setNombre(listados.get(0));
      masc.setRaza(listados.get(1));
      masc.setTipo_animal(listados.get(2));      
      }
       String sql ="insert into mascotas(nombre, raza,tipo_animal,fotos)values(?,?,?,?)  ";
        this.JdbcTemplate.update(sql,masc.getNombre(),masc.getRaza(),masc.getTipo_animal(),masc.getFotos() );
        mov.setViewName("redirect:/listarMascotas.htm");
       
                return mov;
      }
    
        
        
         
    
    @RequestMapping("delete_mascota.htm")
    public ModelAndView borrarMascota(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete  from mascotas where id = ? ";
        JdbcTemplate.update(sql ,id);
        mav.setViewName("redirect:/listarMascotas.htm");
        return mav;
        
    }
    @RequestMapping(value="update_mascota.htm", method = RequestMethod.GET)
    public ModelAndView updateUsuario(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        mascotaBean1 usu = consultarcliente(id);
        String fotoOld = req.getParameter("fotoOld");
        usu.setFotos(fotoOld);
        mav.addObject("mascotas", usu);
        mav.setViewName("views/mascota/updatemascota");
        return mav;
    }

    private mascotaBean1 consultarcliente(int id) {
    mascotaBean1 usu = new mascotaBean1();
    String sql = "select * from mascotas  where id ="+ id;
    return (mascotaBean1)JdbcTemplate.query(
    sql,
    new ResultSetExtractor<mascotaBean1>(){

        @Override
        public mascotaBean1 extractData(ResultSet rs) throws SQLException, DataAccessException {
          if(rs.next()){  
              usu.setId(rs.getString("id"));
              usu.setNombre(rs.getString("nombre"));
              usu.setRaza(rs.getString("raza"));
              usu.setTipo_animal(rs.getString("tipo_animal"));
              }
        return usu;
        }
    
    }
    );
    }
    
    @RequestMapping(value="update_mascota.htm", method = RequestMethod.POST)
   public ModelAndView updateUsuario(mascotaBean1 u, HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        Dao_mascotas masDao = new Dao_mascotas();
        ArrayList<String> listados = new ArrayList<>();
        String uploadPath = req.getServletContext().getRealPath("")+File.separator + UPLOAD_DIRECTORY;
        String deletepath = req.getServletContext().getRealPath("")+File.separator;
        
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        DiskFileItemFactory file = new  DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(file);
        List<FileItem> items= null;
        try{
            
            masDao.borrarImagenactualizada(u.getFotoOld(), deletepath);
            
            items = fileUpload.parseRequest(req);
            for(int i = 0; i < items.size();i++){
                 FileItem fileItem =(FileItem)items.get(i);
                 listados.add(fileItem.getString());
            }
        } catch(FileUploadException ex){
            System.out.print("error en la carga de la imagen"+ex.getMessage());
        }
        if(listados.get(3).isEmpty() || listados.get(3).equals("")|| listados.get(3).equals(null)){
           masDao.accUsuarioSinFoto(u, listados);
        }else{
             masDao.accUsuarioConFoto(u, isMultipart, req, items);
        }
        mav.setViewName("redirect:/listarMascotas.htm");
        return mav;
        }
             
    }  
    
   
    
