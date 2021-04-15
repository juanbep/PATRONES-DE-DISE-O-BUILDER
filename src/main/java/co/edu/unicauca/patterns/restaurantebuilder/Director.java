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
public class Director {

    private Builder builder;

    public Director setBuilder(Builder builder) {
        this.builder = builder;
        return this;
    }

    public Dish getDish() {
        return builder.getDish();
    }

    public void create() {
        builder
                .init()
                .setCore()
                .addParts()
                .setSize();
    }
}
