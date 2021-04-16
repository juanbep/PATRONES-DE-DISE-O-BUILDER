/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.patterns.builderconsola;

import co.edu.unicauca.patterns.restaurantebuilder.DishBuilder;
import co.edu.unicauca.patterns.restaurantebuilder.EnumSize;
import java.io.BufferedReader;
import java.io.IOException;
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
        dish.setDescription(read("Ingrese la descripcion del plato oriental: "));
        dish.setImage(read("Ingrese una imagen para el plato oriental(URL de la imagen)"));
        dish.setPrice(readPrice("Ingrese el valor del plato: "));

        return this;
    }

    @Override
    public DishBuilder addParts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DishBuilder setSize() {
        dish.setSize(readEnumSize("Ingrese el tamaño del plato: /n"
                + "1. ALL /n"
                + "2. HALF"));
        return this;
    }

    private String read(String message) {
        String input = "";
        try {
            System.out.println(message);
            input = br.readLine();
        } catch (IOException e) {
        }
        return input;
    }

    private int readPrice(String message) {
        int input = 0;
        try {
            System.out.println(message);
            input = br.read();
        } catch (IOException e) {
        }
        return input;
    }

    private EnumSize readEnumSize(String message) {
        String input = "";
        try {
            System.out.println(message);
            input = br.readLine();
            if ("1".equals(input)) {
                return EnumSize.ALL;
            }
        } catch (IOException e) {
        }
        return EnumSize.HALF;
    }

}
