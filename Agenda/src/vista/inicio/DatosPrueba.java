/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.inicio;

import modelo.AgendaException;
import modelo.Conexion;
import modelo.Fachada;
import modelo.UsuarioAgenda;

/**
 *
 * @author PC
 */
public class DatosPrueba {
    
    private static Fachada fachada = Fachada.getInstancia();
    
    public static void cargar(){
       
        fachada.agregarUsarioAgenda("a", "a", "Ana");
        fachada.agregarUsarioAgenda("b", "b", "Beatriz");
        fachada.agregarUsarioAgenda("c", "c", "Carlos");
        
        fachada.agregarUsarioAdministrador("x", "x", "Ximena");
        fachada.agregarUsarioAdministrador("y", "y", "Yamandu");
        
        fachada.crearTipoContacto("Particular");
        fachada.crearTipoContacto("Familiar");
        fachada.crearTipoContacto("Laboral");
        
         fachada.crearTipoTelefono("Fijo");
         fachada.crearTipoTelefono("Celular");
         fachada.crearTipoTelefono("Internacional");
        
    }
    public static void probar() throws AgendaException{
        Conexion c = fachada.loginAgenda("a","a");
        UsuarioAgenda u = c.getUsuario();
        u.getAgenda().crearContacto("Juan Perez",
                                    "12345678",
                                    fachada.getTiposContacto().get(0),
                                    fachada.getTiposTelefono().get(0));
        
        System.out.println("Nombre completo: " + u.getNombreCompleto());
        System.out.println("Cantidad contactos: " + u.getAgenda().cantidadContactos());
        System.out.println("Contactos:");
        System.out.println(u.getAgenda().getContactos());
    }
}
