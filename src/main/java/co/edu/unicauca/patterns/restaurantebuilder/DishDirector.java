/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.patterns.restaurantebuilder;

/**
 *
 * @author Beca98
 */
public class DishDirector {

    private DishBuilder dishbuilder;

    public DishDirector setDishBuilder(DishBuilder builder) {
        this.dishbuilder = builder;
        return this;
    }

    public Dish getDish() {
        return dishbuilder.getDish();
    }

    public void buildDish() {
        dishbuilder
                .init()
                .setCore()
                .addParts()
                .setSize();
    }
}
