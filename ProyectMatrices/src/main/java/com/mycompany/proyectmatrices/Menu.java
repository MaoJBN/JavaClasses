/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectmatrices;

import javax.swing.JOptionPane;


public class Menu {
    String platos[];
    int data[][];
    String dishes="Platos :";
    String week[] =new String[]{"lunes","martes","miercoles","jueves","viernes","sabado"};
    
    public void crearMenu(int cantidad){
        platos = new String[cantidad];
        
        int i =0;
        while (i<cantidad) {            
            platos[i]= JOptionPane.showInputDialog("Ingrese el nombre del plato " + (i+1));
            dishes+=" " + platos[i];
            i++;
        }
    }
    
    public void enterData(){
        data=new int[6][platos.length];
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < platos.length; c++) {
                data[r][c]= Integer.parseInt(JOptionPane.showInputDialog("Ventas para el dia : " + week[r] + " El Plato es: " +platos[c]));
            }
        }
    }

    public String getDishes() {
        return dishes;
    }

    
    
    
}
