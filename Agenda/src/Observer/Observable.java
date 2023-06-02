/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import java.util.ArrayList;

/**
 *
 * @author gonzalobazzi
 */
public abstract class Observable {
    
    private ArrayList<Observer> observers;
    
    public enum Evento{
        CONEXION_ACTUALIZADA,
        CONTACTO_ACTUALIZADO
    }

    public Observable() {
        this.observers = new ArrayList();
    }
    
    public void subscribir(Observer o) {
        this.observers.add(o);
    }
    
    public void desubscribir(Observer o) {
        this.observers.remove(o);
    }
    
    public void notificar(Observable.Evento e) {
        for(Observer o : observers)
            o.notificar(this, e);
    }
}
