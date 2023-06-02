/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Observer.Observable;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class SistemaAcceso {
    
    private ArrayList<UsuarioAgenda> usuariosAgenda = new ArrayList();
    private ArrayList<UsuarioAdministrador> administradores = new ArrayList();
    private ArrayList<Conexion> conexiones = new ArrayList();
    
    public void agregarUsarioAgenda(String nombre,String pass,String nombreCompleto){
        usuariosAgenda.add(new UsuarioAgenda(nombre, pass, nombreCompleto));
        
    }
    public void agregarUsarioAdministrador(String nombre,String pass,String nombreCompleto){
        administradores.add(new UsuarioAdministrador(nombre, pass, nombreCompleto));
        
    }
    public Conexion loginAgenda(String nombre,String pass){
       Usuario u = buscarUsuario(nombre, pass, usuariosAgenda);
       Conexion conexion = null;
       if(u!=null){
           conexion = new Conexion((UsuarioAgenda)u);
           conexiones.add(conexion);
           Fachada.getInstancia().notificar(Observable.Evento.CONEXION_ACTUALIZADA);
       }
       return conexion;
    }
    public UsuarioAdministrador loginAdministrador(String nombre,String pass){
       Usuario u = buscarUsuario(nombre, pass, administradores);
       return (UsuarioAdministrador)u;
    }
    private Usuario buscarUsuario(String nombre,String pass,ArrayList usuarios){
        Usuario u;
        for(Object obj:usuarios){
            u = (Usuario)obj;
            if(u.getNombre().equals(nombre) && u.getPassword().equals(pass)){
                return u;
            }
        }
        return null;
    }

    public ArrayList<Conexion> getConexiones() {
        return conexiones;
    }
    public void logout(Conexion c){
        conexiones.remove(c);
        Fachada.getInstancia().notificar(Observable.Evento.CONEXION_ACTUALIZADA);
    }
}
