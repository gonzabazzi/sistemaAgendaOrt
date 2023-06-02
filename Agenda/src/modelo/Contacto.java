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
public class Contacto{
    private String nombre;
    private Telefono telefono;
    private TipoContacto tipo;
    private Date fechaCreacion = new Date();
    
    public Contacto(String nombre, String numero, TipoContacto tipoContacto,TipoTelefono tipoTelefono ) {
        this.nombre = nombre;
        this.telefono = crearTelefono(numero,tipoTelefono);//new Telefono(numero);
        this.tipo = tipoContacto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    

    public String getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public TipoContacto getTipo() {
        return tipo;
    }

    public void validar() throws AgendaException {
        validarNombre(nombre);  
        /*if(!telefono.validarFormato()) 
            throw new AgendaException("Formato incorrecto para un telefono " + 
                                      telefono.getTipo().getNombre());*/
        telefono.validarFormato();
        validarTipo(tipo);
    }

    private void validarNombre(String nombre) throws AgendaException {
        if(nombre==null || nombre.trim().isEmpty()) 
            throw new AgendaException("Falta el nombre");
    }
    private void validarTipo(TipoContacto tipo) throws AgendaException {
        if(tipo==null) throw new AgendaException("Falta el tipo de contacto");
    }
    
    @Override
    public boolean equals(Object o){
        Contacto c = (Contacto)o;
        return nombre.equalsIgnoreCase(c.getNombre()) &&
               telefono.getNumero().equals(c.getTelefono().getNumero());
    }
    @Override
    public String toString(){
        return nombre + " - " + telefono;
    }

    /*@Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", telefono=" + telefono + ", tipo=" + tipo + '}';
    }*/

    private Telefono crearTelefono(String numero, TipoTelefono tipoTelefono) {
        if(tipoTelefono.getNombre().equals("Fijo"))
            return new Fijo(numero,tipoTelefono);
        if(tipoTelefono.getNombre().equals("Celular"))
            return new Celular(numero,tipoTelefono);
        if(tipoTelefono.getNombre().equals("Internacional"))
            return new Internacional(numero,tipoTelefono);
        return null;
         
        /*try {
            Class c = Class.forName("logica." + tipoTelefono.getNombre());
            Object o = c.getDeclaredConstructor().newInstance();
            Telefono t = (Telefono)o;
            t.setNumero(numero);
            t.setTipo(tipoTelefono);
            return t;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("No se encontro la clase");
            return null;
        }*/
    }
    
}
