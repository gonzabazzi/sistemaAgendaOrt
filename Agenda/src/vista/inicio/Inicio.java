/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista.inicio;

import vista.LoginAgenda;
import vista.TestingAplicacion;

/**
 *
 * @author PC
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatosPrueba.cargar();
        //DatosPrueba.probar();
        new TestingAplicacion().setVisible(true);
        
    }
    
}
