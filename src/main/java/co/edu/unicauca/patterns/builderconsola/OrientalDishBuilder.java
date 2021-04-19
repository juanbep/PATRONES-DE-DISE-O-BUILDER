/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.patterns.builderconsola;

import co.edu.unicauca.patterns.restaurantebuilder.DishBuilder;
import co.edu.unicauca.patterns.restaurantebuilder.EnumSize;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Beca98
 */
public class OrientalDishBuilder extends DishBuilder {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
        dish.setParts(listComponents("\n¿Dese agregar mas partes al plato? \n"
                + "1. Si \n"
                + "2. No"));

        return this;
    }

    @Override
    public DishBuilder setSize() {
        dish.setSize(readEnumSize("\nIngrese el tamaño del plato: "
                + "\n1. ALL"
                + "\n2. HALF"));

        return this;
    }

    @Override
    public DishBuilder calculatePriceDish() {
        int price = dish.getBase().getPrecio();
        int band = price;
        if (dish.getParts() != null) {
            for (int i = 0; i < dish.getParts().size(); i++) {
                price = band + dish.getParts().get(i).getPrecio();
                band = price;
            }
        }
        if (dish.getSize() == EnumSize.HALF) {
            price = price / 2;
        }
        dish.setPrice(price);

        return this;
    }
}
