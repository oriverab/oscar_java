/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author SENA
 */
public class adopcion {
    
    int cod;
    String fecha;
    String id_mascota;
    String id_usuario;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(String id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public adopcion(int cod, String fecha, String id_mascota, String id_usuario) {
        this.cod = cod;
        this.fecha = fecha;
        this.id_mascota = id_mascota;
        this.id_usuario = id_usuario;
    }

    public adopcion() {
    }
}
