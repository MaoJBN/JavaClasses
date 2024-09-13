/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listasimple;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-01
 */
public class Listasimple {
    Nodo inicio; 
    Listasimple(){
    inicio=null;
    }
    
    public void insertarInicio(String nombre, int edad, float promedio){
        Nodo nuevo=new Nodo();
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);        
   if(inicio==null){
   JOptionPane.showMessageDialog(null, "La lista esta vacia");   
    inicio=nuevo;      
   }else{       
       nuevo.setEnlace(inicio);
       inicio=nuevo;         
   }}   
    
    public void insertarFinal(String nombre, int edad, float promedio){
        Nodo nuevo=new Nodo();
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);        
   if(inicio==null){
   JOptionPane.showMessageDialog(null, "La lista esta vacia");   
    inicio=nuevo;   
       }
   else{       
       Nodo temporal=inicio;       
       while(temporal.getEnlace()!=null){           
           temporal=temporal.getEnlace();
       
       }
        temporal.setEnlace(nuevo);     
       
   }}   
    
    
    public void addperPosition(int index,String nombre, int edad, float promedio){
    Nodo nuevo = new Nodo();
    nuevo.setNombre(nombre);
    nuevo.setEdad(edad);
    nuevo.setPromedio(promedio);

    if (index == 1) {
        nuevo.setEnlace(inicio);
        inicio = nuevo;
        return;
    }
    Nodo temporal = inicio;
    int save = 0;
    while (temporal != null && save < index - 1) {
        temporal = temporal.getEnlace();
        save++;
    }
    if (temporal == null) {
        System.out.println("Posición fuera del rango.");
        return;
    }

    nuevo.setEnlace(temporal.getEnlace());
    temporal.setEnlace(nuevo);
}
    
    public void delete(int index){
    int count=0;
    Nodo cloneTemp = inicio;
        if (index == 1) {
            cloneTemp.setEnlace(cloneTemp.getEnlace());
        } else {
            while (index-1>count) {            
            cloneTemp = cloneTemp.getEnlace();
            count++;
        }
        cloneTemp.setEnlace(cloneTemp.getEnlace().getEnlace());
        }
        
    }
    
    public void consultar(){    
        Nodo temporal=inicio;        
        if(inicio==null){
   JOptionPane.showMessageDialog(null, "La lista esta vacia");       
        }else{     
            do{            
           JOptionPane.showMessageDialog(null,
                   "Nombre:  "+temporal.getNombre()
                           + " LA EDAD ES : "+temporal.getEdad()
                           + " EL PORMEDIO ES "+temporal.getPromedio());      
           
           temporal=temporal.getEnlace();
                
            }while(temporal!=null);
        
        }
    
        
    }
    
    public void ordenarAlfabeticamente() {
    if (inicio == null || inicio.getEnlace() == null) {
        return; 
    }

    Nodo actual;
    Nodo siguiente;
    boolean huboCambio;

    do {
        huboCambio = false;
        actual = inicio;

        while (actual.getEnlace() != null) {
            siguiente = actual.getEnlace();
            if (actual.getNombre().compareTo(siguiente.getNombre()) > 0) {
                String temp = actual.getNombre();
                actual.setNombre(siguiente.getNombre());
                siguiente.setNombre(temp);
                huboCambio = true;
            }
            actual = siguiente;
        }
    } while (huboCambio);
}
    
    
}
