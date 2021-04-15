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
public abstract class Builder {

    protected Dish dish;

    public Dish getDish() {
        return this.dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Builder init() {
        this.dish = new Dish();
        return this;
    }

    public abstract Builder setCore();

    public abstract Builder addParts();

    public abstract Builder setSize();

}
