/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Frame;
import modelo.Fachada;
import modelo.UsuarioAdministrador;

/**
 *
 * @author PC
 */
public class LoginAdministrador extends LoginAbstracto{

    public LoginAdministrador(Frame parent, boolean modal) {
        super(parent, modal, "LOGIN ADMINISTRADOR");
    }

    
    @Override
    public Object llamarLogin(String nom, String pass) {
        return Fachada.getInstancia().loginAdministrador(nom, pass);
    }

    @Override
    public void proximoCasoUso(Object obj) {
        new MonitorConexiones((UsuarioAdministrador)obj).setVisible(true);
    }
    
}
