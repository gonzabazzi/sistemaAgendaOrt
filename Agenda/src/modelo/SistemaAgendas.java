/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class SistemaAgendas {
    
    private ArrayList<TipoContacto> tiposContacto = new ArrayList();
    private ArrayList<TipoTelefono> tiposTelefono = new ArrayList();

    public ArrayList<TipoContacto> getTiposContacto() {
        return tiposContacto;
    }

    public ArrayList<TipoTelefono> getTiposTelefono() {
        return tiposTelefono;
    }
    
    public void crearTipoContacto(String nombre){
        tiposContacto.add(new TipoContacto(nombre));
    }
     public void crearTipoTelefono(String nombre){
        tiposTelefono.add(new TipoTelefono(nombre));
    }
}
