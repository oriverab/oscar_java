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
public class mascotaBean1 {
          String id;
          String nombre;
          String raza;
          String tipo_animal;
          String fotos;
          String fotoOld;
          Boolean estado; 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo_animal() {
        return tipo_animal;
    }

    public void setTipo_animal(String tipo_animal) {
        this.tipo_animal = tipo_animal;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public String getFotoOld() {
        return fotoOld;
    }

    public void setFotoOld(String fotoOld) {
        this.fotoOld = fotoOld;
    }

    public Boolean isEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

   
    

    public mascotaBean1() {
    }

    public mascotaBean1(String id, String nombre, String raza, String tipo_animal, String fotos, String fotoOld, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.tipo_animal = tipo_animal;
        this.fotos = fotos;
        this.fotoOld = fotoOld;
        this.estado = estado;
    }



    

   
          
          
          
    
}
