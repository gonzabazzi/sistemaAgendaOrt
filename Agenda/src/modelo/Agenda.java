/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Observer.Observable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Agenda {
    
    private ArrayList<Contacto> contactos = new ArrayList();

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
    public int cantidadContactos(){
        return contactos.size();
    }
    public void crearContacto(String nombre,String numero,TipoContacto tipoContacto,TipoTelefono tipoTelefono) throws AgendaException{
        Contacto nuevo = new Contacto(nombre, numero, tipoContacto,tipoTelefono);
        
        nuevo.validar();
        if(contactos.contains(nuevo)) throw new AgendaException("Ya existe el contacto");

        contactos.add(nuevo);
        Fachada.getInstancia().notificar(Observable.Evento.CONTACTO_ACTUALIZADO);
       
    }

    public ArrayList<Contacto> buscar(String filtro) {
        ArrayList<Contacto> resultado = new ArrayList();
        for(Contacto c:contactos){
            if(c.getNombre().toLowerCase().contains(filtro.toLowerCase()) || c.getTelefono().getNumero().contains(filtro)){
                resultado.add(c);
            }
        }
        return resultado;
    }
    
}
