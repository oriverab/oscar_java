/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author SENA
 */
public class Dao_adopcion {
    
    JdbcTemplate jdbcTemplate;
    Dao con = new Dao();
    
    
    public  List consultarAdopciones(){
    List datos = new ArrayList();
    this.jdbcTemplate = new JdbcTemplate(con.conDB());
    String sql = "select adopcion.cod,adopcion.fecha, usuarios.nombres, mascotas.nombre, usuarios.foto, mascotas.fotos from usuarios, mascotas, adopcion where mascotas.id= adopcion.id_mascota and  usuarios.id= adopcion.id_usuario;";
    
    datos = this.jdbcTemplate.queryForList(sql);
    return datos;
    
    }
    
   public int consultarIdAdopcion(){
   int cod = 0;
   this.jdbcTemplate = new JdbcTemplate(con.conDB());
   String sql = "select max(cod)+1 as cod from adopcion";
   cod = this.jdbcTemplate.queryForObject(sql, Integer.class);
   return cod;
   }
    
    
}
