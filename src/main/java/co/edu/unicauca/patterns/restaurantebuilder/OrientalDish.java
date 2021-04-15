/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.patterns.restaurantebuilder;

import java.util.List;

/**
 *
 * @author Beca98
 */
public class OrientalDish extends Dish {

    private String orientalName;

    public OrientalDish(String orientalName, String name, String description, String image, int price, EnumSize size, List<Dish> parts) {
        super(name, description, image, price, size, parts);
        this.orientalName = orientalName;
    }

    public String getOrientalName() {
        return orientalName;
    }

    public void setOrientalName(String orientalName) {
        this.orientalName = orientalName;
    }

}
