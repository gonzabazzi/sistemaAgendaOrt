/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.List;
import modelo.Contacto;
import modelo.TipoContacto;
import modelo.TipoTelefono;

/**
 *
 * @author gonzalobazzi
 */
public interface CrearContactoVista {
    public void mostrarTitulo(String titulo);
    public void mostrarContactos(List<Contacto> contactos);
    public void cargarTiposContacto(List<TipoContacto> tipos);
    public void cargarTiposTelefono(List<TipoTelefono> tipos);
    public void mostrarMensaje(String mensaje);
    public void limpiarCampos();
}
