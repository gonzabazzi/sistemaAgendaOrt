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
public class Fachada extends Observable {
    
    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaAgendas sAgendas = new SistemaAgendas();
    
    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }

    public void agregarUsarioAgenda(String nombre, String pass, String nombreCompleto) {
        sAcceso.agregarUsarioAgenda(nombre, pass, nombreCompleto);
    }

    public Conexion loginAgenda(String nombre, String pass) {
        return sAcceso.loginAgenda(nombre, pass);
    }

    public ArrayList<TipoContacto> getTiposContacto() {
        return sAgendas.getTiposContacto();
    }

    public void crearTipoContacto(String nombre) {
        sAgendas.crearTipoContacto(nombre);
    }

    public void agregarUsarioAdministrador(String nombre, String pass, String nombreCompleto) {
        sAcceso.agregarUsarioAdministrador(nombre, pass, nombreCompleto);
    }

    public UsuarioAdministrador loginAdministrador(String nombre, String pass) {
        return sAcceso.loginAdministrador(nombre, pass);
    }

    public ArrayList<Conexion> getConexiones() {
        return sAcceso.getConexiones();
    }

    public void logout(Conexion c) {
        sAcceso.logout(c);
    }

    public ArrayList<TipoTelefono> getTiposTelefono() {
        return sAgendas.getTiposTelefono();
    }

    public void crearTipoTelefono(String nombre) {
        sAgendas.crearTipoTelefono(nombre);
    }
    
    
    

    
    
    
}
