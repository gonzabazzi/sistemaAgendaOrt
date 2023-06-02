/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Conexion {
    private UsuarioAgenda usuario;
    private Date fecha = new Date();

    public Conexion(UsuarioAgenda usuario) {
        this.usuario = usuario;
    }

    public UsuarioAgenda getUsuario() {
        return usuario;
    }

    public Date getFecha() {
        return fecha;
    }
    
}
