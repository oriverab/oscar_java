/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import javax.ejb.Stateless;

/**
 *
 * @author SENA
 */
@Stateless
public class usuarioBean {
          String id;
          String cedula;
          String nombres;
          String telefono;
          String email;
          String foto;
          String fotoOld;
   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombre) {
        this.nombres = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
          public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFotoOld() {
        return fotoOld;
    }

    public void setFotoOld(String fotoOld) {
        this.fotoOld = fotoOld;
    }

    public usuarioBean(String id, String cedula, String nombres, String telefono, String email, String foto, String fotoOld) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.telefono = telefono;
        this.email = email;
        this.foto = foto;
        this.fotoOld = fotoOld;
    }

   

    public usuarioBean() {
    }
    
         
    
}
