/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Frame;
import modelo.Conexion;
import modelo.Fachada;

/**
 *
 * @author PC
 */
public class LoginAgenda extends LoginAbstracto{

    public LoginAgenda(Frame parent, boolean modal) {
        super(parent, modal, "LOGIN AGENDA");
    }

    
    @Override
    public Object llamarLogin(String nom, String pass) {
        return Fachada.getInstancia().loginAgenda(nom, pass);
    }

    @Override
    public void proximoCasoUso(Object obj) {
        new MenuAgenda((Conexion)obj).setVisible(true);
    }
    
}
