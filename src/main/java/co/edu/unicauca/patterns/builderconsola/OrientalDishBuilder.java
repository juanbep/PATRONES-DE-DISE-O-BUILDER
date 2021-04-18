/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.patterns.builderconsola;

import co.edu.unicauca.patterns.restaurantebuilder.Component;
import co.edu.unicauca.patterns.restaurantebuilder.DishBuilder;
import co.edu.unicauca.patterns.restaurantebuilder.EnumSize;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        dish.setBase(addComponent("Ingrese la base para el plato"));

        return this;
    }

    @Override
    public DishBuilder addParts() {

        System.out.println("¿Dese agregar mas partes al plato? /n"
                + "1. Si /n"
                + "2. No");
        dish.setParts(listComponents("Ingrese los componentes para el plato: "));
        return this;
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
        int input = 0;
        try {
            System.out.println(message);
            input = br.read();
            validar(input, message);
        } catch (IOException e) {
        }
        if (input == 1) {
            return EnumSize.ALL;
        } else {
            return EnumSize.HALF;
        }
    }

    private List<Component> listComponents(String message) {
        List<Component> listCompts = null;
        int input = 0, nPartes = 0;
        try {
            System.out.println(message);
            input = br.read();
            input = validar(input, message);
            System.out.println("Ingrese el numero de partes que desea agregar: ");
            nPartes = br.read();
            nPartes = validar(nPartes);
        } catch (IOException e) {
        }
        if (input == 1) {
            listCompts = new ArrayList();
            for (int i = 0; i < nPartes; i++) {
                listCompts.add(addComponent("Ingrese los datos para el componente " + (i + 1)));
            }
            return listCompts;
        } else {
            return listCompts;
        }

    }

    private Component addComponent(String message) {
        Component compt = null;
        String id, name;
        int price;
        try {
            System.out.println(message);
            System.out.println("Ingrese un id para el componente /n");
            id = br.readLine();
            System.out.println("Ingrese un nombre para el componente /n");
            name = br.readLine();
            System.out.println("Ingrese un precio para el componente");
            price = br.read();
            compt = new Component(id, name, price);
        } catch (IOException e) {
        }
        return compt;
    }

    private int validar(int input, String message) throws IOException {

        while (input != 1 || input != 2) {
            System.out.println("Numero no corresponde");
            System.out.println(message);
            input = br.read();
        }
        return input;
    }

    private int validar(int nPartes) throws IOException {
        while (nPartes <= 0) {
            System.out.println("Solo numeros mayores que cero");
            System.out.println("Ingrese el numero de partes que desea agregar: ");
            nPartes = br.read();
        }
        return nPartes;
    }
}
