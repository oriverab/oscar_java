package Dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.mascotaBean1;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.jdbc.core.JdbcTemplate;


public class Dao_mascotas {
    JdbcTemplate jdbcTemplate;
    Dao con = new Dao();
    private static final String UPLOAD_DIRECTORY ="..\\..\\web\\public\\img\\fotos";
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;

    public  List consultarMAscotasAdop(){
    List datos = new ArrayList();
    this.jdbcTemplate = new JdbcTemplate(con.conDB());
    String sql = "select id ,nombre from mascotas";
    datos = this.jdbcTemplate.queryForList(sql);
    return datos;

    }

    public void accUsuarioSinFoto( mascotaBean1 usu,ArrayList<String> listados){
    this.jdbcTemplate = new JdbcTemplate(con.conDB());
      usu.setNombre(listados.get(0));
      usu.setRaza(listados.get(1));
      usu.setTipo_animal(listados.get(2));
 
      String sql = "update mascotas Set nombre = ?, raza =?, tipo_animal = ? where id=?";
      jdbcTemplate.update(sql, usu.getNombre(),usu.getRaza(),usu.getTipo_animal(),usu.getId());

}
    public void accUsuarioConFoto(mascotaBean1 usu,
        boolean isMultipart,
        HttpServletRequest request,
        List items){
        this.jdbcTemplate = new JdbcTemplate(con.conDB());
        ArrayList<String> listados = new ArrayList<>();
        if(isMultipart){
        DiskFileItemFactory file= new DiskFileItemFactory();
        file.setSizeThreshold(MEMORY_THRESHOLD);
        file.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload fileUpload = new ServletFileUpload(file);
        fileUpload.setFileSizeMax(MAX_FILE_SIZE);
        fileUpload.setSizeMax(MAX_FILE_SIZE);
        String Uploadpath = request.getServletContext().getRealPath("")+ File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(Uploadpath);
        if(!uploadDir.exists()){
          uploadDir.mkdir();
        } 
        for (int i = 0; i< items.size(); i++){
        
        FileItem fileItem = (FileItem) items.get(i);
        
        if(!fileItem.isFormField()){
           String fileName = new File(fileItem.getName()).getName();
           String filePath = Uploadpath + File.separator + "id-" + listados.get(0)+"-"+ fileName;
           File UploadFile = new File(filePath);
           String nameFile= ("public/img/fotos/" + "id-" + listados.get(0)+"-"+ fileName);
        try{
            UploadFile.delete();
            fileItem.write(UploadFile);
            usu.setFotos(nameFile);
        } catch(Exception e){
          System.out.print("escritura"+ e.getMessage());
        } 
        }else{
         listados.add(fileItem.getString());
        }
       } 
      usu.setNombre(listados.get(0));
      usu.setRaza(listados.get(1));
      usu.setTipo_animal(listados.get(2));
     }       
      String sql = "update mascotas Set nombre = ?, raza = ?, tipo_animal= ?, fotos =? where id=?";
      jdbcTemplate.update(sql, usu.getNombre(),usu.getRaza(),usu.getTipo_animal(),usu.getFotos(),usu.getId());

}

    public void borrarImagenactualizada(String foto, String deletepaht){
    final String DELETE_DIRECTORY = "..\\..\\WEB\\";
    String deleteFile = deletepaht + DELETE_DIRECTORY + foto;
    File borrar = new File(deleteFile);
    if(borrar.delete()){
    System.out.println("borrado");
    }else{
    System.out.println("no se pudo borrar..");
    }

}
    public void deleteImg(String fotos, String deletePath, int id) {
        final String DELETE_DIRECTORY = "..\\..\\web\\";
        this.jdbcTemplate = new JdbcTemplate(con.conDB());
        //Ubicación del archivo en el servidor
        String deleteFile = deletePath + DELETE_DIRECTORY + fotos;
        File borrar = new File(deleteFile);
        System.out.println(fotos);
        if (borrar.delete()) {
            String sql = "delete from usuarios where id = ?";
            jdbcTemplate.update(sql, id);
        } else {
            System.out.println("No se pudo eliminar la imagen");
        }
    }





}