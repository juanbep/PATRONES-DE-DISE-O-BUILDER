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
public abstract class DishBuilder {

    protected Dish dish;

    public Dish getDish() {
        return this.dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public DishBuilder init() {
        this.dish = new Dish();
        return this;
    }

    public abstract DishBuilder setCore();

    public abstract DishBuilder addParts();

    public abstract DishBuilder setSize();
    
    public abstract DishBuilder calculatePriceDish();

}
