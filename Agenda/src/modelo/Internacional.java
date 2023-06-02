/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PC
 */
public class Internacional extends Telefono{

    public Internacional() {
    }

    
    public Internacional(String numero, TipoTelefono tipo) {
        super(numero, tipo);
    }

    
    @Override
    public void validarFormato() throws AgendaException {
        int comienzo = -1;
        if(getNumero().startsWith("+")) comienzo = 1;
        else if(getNumero().startsWith("00")) comienzo = 2;
        if(comienzo==-1) throw new AgendaException("El telefono debe comenzar con 00 o con +");
        char c;
        int digitos=0;
        for(int x=comienzo;x<getNumero().length();x++){
            c=getNumero().charAt(x);
           if(c!=' '  && !Character.isDigit(c))throw new AgendaException("El telefono solo puede tener digitos o espacios"); ;
           if(Character.isDigit(c)) digitos++; 
        }
        if(digitos<10) throw new AgendaException("El telefono debe tener al menos 10 digitos");
    }
    
}
