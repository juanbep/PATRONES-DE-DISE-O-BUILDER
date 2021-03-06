/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.patterns.builderconsola;

import co.edu.unicauca.patterns.restaurantebuilder.DishBuilder;

/**
 *
 * @author Beca98
 */
public class ItalianDishBuilder extends DishBuilder {

    @Override
    public DishBuilder setCore() {
        dish.setName(read("Ingrese el nombre del plato oriental: "));
        dish.setDescription(read("\nIngrese la descripcion del plato oriental: "));
        dish.setImage(read("\nIngrese una imagen para el plato oriental(URL de la imagen)"));
        dish.setBase(addComponent("\nIngrese la base para el plato"));

        return this;
    }

    @Override
    public DishBuilder addParts() {
        dish.setParts(listComponents());

        return this;
    }

    @Override
    public DishBuilder setSize() {
        dish.setSize(readEnumSize());

        return this;
    }

    @Override
    public DishBuilder calculatePriceDish() {
        dish.setPrice(calculatePrice());

        return this;
    }

}
