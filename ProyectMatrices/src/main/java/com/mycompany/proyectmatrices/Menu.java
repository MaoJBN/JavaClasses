/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectmatrices;

import javax.swing.JOptionPane;


public class Menu {
    String platos[];
    int data[][];
    String dishes="Platos : ";
    String week[] =new String[]{"lunes","martes","miercoles","jueves","viernes","sabado"};
    
    public void crearMenu(int cantidad){
        platos = new String[cantidad];
        
        int i =0;
        while (i<cantidad) {            
            platos[i]= JOptionPane.showInputDialog("Ingrese el nombre del plato " + (i+1));
            dishes+=" " +platos[i];
            i++;
        }
    }
    
    public void enterData(){
        data=new int[6][platos.length];
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < platos.length; c++) {
                data[r][c]= Integer.parseInt(JOptionPane.showInputDialog("Ventas del dia : " + week[r] + " El Plato es: " +platos[c]));
            }
        }
    }
    public int SoldDishes(){
        int count= 0;
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < platos.length; c++) {
                count=count + data[r][c];
            }
        }
        return count;
    }
    
    public String maxDishes() throws Exception{
        String NameDish="";
        int count =0;
        int maxDis=0;
        try {
            if (platos.length>=2) {
              for (int c = 0; c < platos.length; c++) {
                  count=0;
            for (int r = 0; r < 6; r++) {
                count=count + data[r][c];
            }
            if (maxDis<count) {
                maxDis =count;
                NameDish = platos[c];
            }else{
            
            }
        }  
            }else{
                throw new Exception("No tiene los suficientes platos para hacer una comparacion");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No tiene los suficientes platos para hacer una comparacion");
        }
        return maxDis + " platos de " + NameDish;
    }
    
    public String minDis(){
        String NameDish="";
        int minDis=Integer.MAX_VALUE;
        int count =0;
    try {
            if (platos.length>=2) {
              for (int c = 0; c < platos.length; c++) {
                  count=0;
            for (int r = 0; r < 6; r++) {
                count=count + data[r][c];
            }
            if (minDis > count) {
                minDis =count;
                NameDish = platos[c];
            }
        }  
            }else{
                throw new Exception("No tiene los suficientes platos para hacer una comparacion");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No tiene los suficientes platos para hacer una comparacion");
        }
        return minDis + " platos de " + NameDish;
    }
    
    public int AvarageDish(){
        int count= 0;
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < platos.length; c++) {
                count=count + data[r][c];
            }
        }
        return count/6;
    }
    

    public String getDishes() {
        return dishes;
    }


    
    
    
}
