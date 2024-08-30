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
    double price = 2400;
    String ingredients[];
    MainMenu newDish[] = new MainMenu[4];

    public MainMenu() {
    }
    

    public MainMenu(String name, String[] ingredients, double price) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public void createDish(){
        int quant = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese el numero de platos que desea agregar"));
        int quantIngredients;
        for (int i = 0; i < quant; i++) {
        name = JOptionPane.showInputDialog("Ingrese el nombre del plato por favor N° " +(i+1));
        quantIngredients=Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese el numero de Ingredientes que tiene el plato"));
            ingredients=addIngrdients(quantIngredients);
            newDish[i] = new MainMenu(
                    name, 
                    ingredients, 
                    price);
        }
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
    
