/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import Observer.Observable;
import Observer.Observer;
import modelo.Agenda;
import modelo.AgendaException;
import modelo.Fachada;
import modelo.TipoContacto;
import modelo.TipoTelefono;
import modelo.UsuarioAgenda;

/**
 *
 * @author gonzalobazzi
 */
public class CrearContactoControlador implements Observer {

    private UsuarioAgenda usuario;
    private CrearContactoVista vista;
    private Agenda agenda;

    public CrearContactoControlador(CrearContactoVista vista, UsuarioAgenda usuario) {
        this.usuario = usuario;
        this.vista = vista;
        this.agenda = usuario.getAgenda();
        Fachada.getInstancia().subscribir(this);
        vista.mostrarContactos(this.agenda.getContactos());
        vista.mostrarTitulo(usuario.getNombreCompleto() + " - " + agenda.cantidadContactos() + " contacto(s)");
        vista.cargarTiposContacto(Fachada.getInstancia().getTiposContacto());
        vista.cargarTiposTelefono(Fachada.getInstancia().getTiposTelefono());
    }

    public void crearContacto(String nombre, String telefono, TipoContacto tcon, TipoTelefono ttel) {
        try {
            agenda.crearContacto(nombre, telefono, tcon, ttel);
            vista.limpiarCampos();

        } catch (AgendaException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }
    
    public void salir() {
        Fachada.getInstancia().desubscribir(this);
    }

    @Override
    public void notificar(Observable origen, Object evento) {
        if (((Observable.Evento) evento).equals(Observable.Evento.CONTACTO_ACTUALIZADO)) {
            vista.mostrarContactos(this.agenda.getContactos());
            vista.mostrarTitulo(usuario.getNombreCompleto() + " - " + agenda.cantidadContactos() + " contacto(s)");
        }
    }

}
