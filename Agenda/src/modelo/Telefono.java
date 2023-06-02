/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PC
 */
public abstract class Telefono {
    private String numero;
    private TipoTelefono tipo;

    public Telefono(String numero, TipoTelefono tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public Telefono() {
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTipo(TipoTelefono tipo) {
        this.tipo = tipo;
    }
    
    
    public String getNumero() {
        return numero;
    }

    public TipoTelefono getTipo() {
        return tipo;
    }
    

    @Override
    public String toString() {
        return  numero ;
    }
    
    public boolean esNumerico() {
        try{
            Double.parseDouble(numero);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    public abstract void validarFormato() throws AgendaException;
    
           
}
