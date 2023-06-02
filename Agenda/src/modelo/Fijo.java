/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PC
 */
public class Fijo extends Telefono{

    public Fijo() {
    }

    
    public Fijo(String numero, TipoTelefono tipo) {
        super(numero, tipo);
    }

    

    @Override
    public void validarFormato() throws AgendaException {
       if(!esNumerico()) throw new AgendaException("El telefono de ser un numero");
       if(getNumero().length()!=8) throw new AgendaException("El telefono de ser de largo 8");
    }

    
    
}
