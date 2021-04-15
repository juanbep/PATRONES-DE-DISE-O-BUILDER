/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.patterns.builderconsola;

import co.edu.unicauca.patterns.restaurantebuilder.Director;
import co.edu.unicauca.patterns.restaurantebuilder.Dish;

/**
 *
 * @author Beca98
 */
public class DishGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Director director = new Director(); 
        OrientalDishBuilder odb = new OrientalDishBuilder();
        director.setBuilder(odb);
        director.create();
        
        Dish dish = director.getDish();
        System.out.println("Oriental Dish: " + dish);
        System.out.println("Sus partes: " + dish.getParts().toString());
        System.out.println("Precio de las partes: " + dish.calculatePriceParts());
        
        
     
        
    }
    
}
