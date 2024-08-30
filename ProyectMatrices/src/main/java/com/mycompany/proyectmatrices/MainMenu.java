/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectmatrices;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class MainMenu {
    String name;
    double price;
    double gain;
    double productionPrice;
    String ingredients[];
    MainMenu newDish[];
    int data[][];
    String week[] =new String[]{"lunes","martes","miercoles","jueves","viernes","sabado"};

    public MainMenu() {
    }
    

    public MainMenu(String name, String[] ingredients, double price, double productionPrice, double gain) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        this.productionPrice = productionPrice;
        this.gain = gain;
    }

    public void createDish(){
        int quant = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese el numero de platos que desea agregar"));
        newDish=new MainMenu[quant];
        int quantIngredients;
        for (int i = 0; i < quant; i++) {
        name = JOptionPane.showInputDialog("Ingrese el nombre del plato por favor N° " +(i+1));
        productionPrice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Cuanto le costo hacer el plato por favor N° " +(i+1)));
        price = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del plato por favor N° " +(i+1)));
        gain = price-productionPrice;
        quantIngredients=Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese el numero de Ingredientes que tiene el plato"));
            ingredients=addIngrdients(quantIngredients);
            newDish[i] = new MainMenu(
                    name, 
                    ingredients, 
                    price,
                    productionPrice,
                    gain                );
        }
    }
    public int SoldDishes(){
        int count= 0;
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < newDish.length; c++) {
                count=count + data[r][c];
            }
        }
        return count;
    }
    public void enterData(){
        data=new int[6][newDish.length];
        for (int r = 0; r < 6; r++) {
            int c = 0;
            for (c = 0; c < newDish.length; c++) {
                if (newDish != null) {
                data[r][c]= Integer.parseInt(JOptionPane.showInputDialog("Ventas del dia : " + week[r] + " El Plato es: " +newDish[c].getName()));    
                }
            }
        }
    }
    
    public String ShowSolds(){
        int count;
        String show = "";
        for (int c = 0; c < newDish.length; c++) {
                  count=0;
                for (int r = 0; r < 6; r++) {
                    count=count + data[r][c];
                }
                show+= "El plato de "+ newDish[c].getName()+ " se vendio " + count + " durante la semana //////";
        }
        return show;
    }
    
     public String GainsPerPlate(){
        int count;
        String show = "";
        for (int c = 0; c < newDish.length; c++) {
                  count=0;
                for (int r = 0; r < 6; r++) {
                    count=count + data[r][c];
                }
                show+= "El plato de "+ newDish[c].getName()+ " se vendio " + count + " durante la semana. Su precio de produccion fue " + newDish[c].getProductionPrice() + " Y su ganancia fue de " + newDish[c].getGain()*count + "\n";
        }
        return show;
    }
     
     public void GainsTotal(){
        int count;
        double gainT = 0;
         for (int c = 0; c < newDish.length; c++) {
                  count=0;
                for (int r = 0; r < 6; r++) {
                    count=count + data[r][c];
                }
                gainT = (newDish[c].gain * count) + gainT;
        }
        JOptionPane.showMessageDialog(null, "se gano = "+ gainT + " Pesos");
    }
     
     public String maxDishes(){
        String error = " No hay los suficientes platos para hacer una comparacion";
        String NameDish="";
        int count =0;
        int maxDis=0;
        try {
            if (newDish.length>=2) {
              for (int c = 0; c < newDish.length; c++) {
                  count=0;
            for (int r = 0; r < 6; r++) {
                count=count + data[r][c];
            }
            if (maxDis<count) {
                maxDis =count;
                NameDish = newDish[c].getName();
            }
        }  
            }else{
                throw new Exception("No tiene los suficientes platos para hacer una comparacion");
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No tiene los suficientes platos para hacer una comparacion");
            return error;
        }
        return "El plato mas vendido fue con "+maxDis + " platos de " + NameDish;
    }
    
    public String minDis(){
        String error = " No hay Platos";
        String NameDish="";
        int minDis=Integer.MAX_VALUE;
        int count =0;
    try {
            if (newDish.length>=2) {
              for (int c = 0; c < newDish.length; c++) {
                  count=0;
            for (int r = 0; r < 6; r++) {
                count=count + data[r][c];
            }
            if (minDis > count) {
                minDis =count;
                NameDish = newDish[c].getName();
            }
        }  
            }else{
                throw new Exception("No tiene los suficientes platos para hacer una comparacion");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No tiene los suficientes platos para hacer una comparacion");
            return error;
        }
        return "El plato menos vendido fue con " + minDis + " platos de " + NameDish;
    }
    
    public int AvarageDish(){
        int count= 0;
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < newDish.length; c++) {
                count=count + data[r][c];
            }
        }
        return count/6;
    }

    public double getGain() {
        return gain;
    }

    public void setGain(double gain) {
        this.gain = gain;
    }

    public double getProductionPrice() {
        return productionPrice;
    }

    public void setProductionPrice(double productionPrice) {
        this.productionPrice = productionPrice;
    }
    
    

    public MainMenu[] getNewDish() {
        return newDish;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }


    private String[] addIngrdients(int quantIngredients) {
        String saveingredients[] = new String[quantIngredients];
        for (int i = 0; i < quantIngredients; i++) {
            saveingredients[i] = JOptionPane.showInputDialog("Ingrese el ingrediente N° " + (i+1));
        }
        return saveingredients;
    }
    
    public void Show() {
        for (int i = 0; i < newDish.length; i++) {
                if (newDish[i] != null) {
                            JOptionPane.showMessageDialog(null, 
                           "Plato: " + newDish[i].getName() + 
                           ", Ingredientes: " + Arrays.toString(newDish[i].getIngredients()) + 
                           ", Precio: " + newDish[i].getPrice());
                }
        }
    }
}
    
