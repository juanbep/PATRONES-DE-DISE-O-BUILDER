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
        dish.setDescription(read("\nIngrese la descripcion del plato oriental: "));
        dish.setImage(read("\nIngrese una imagen para el plato oriental(URL de la imagen)"));
        dish.setPrice(Integer.parseInt(read("\nIngrese el valor del plato: ")));
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

    private EnumSize readEnumSize(String message) {
        String input = "";
        int resp = 0;
        try {
            System.out.println(message);
            input = br.readLine();
            resp = validar(input, message);
        } catch (IOException e) {
        }
        if (resp == 1) {
            return EnumSize.ALL;
        } else {
            return EnumSize.HALF;
        }
    }

    private List<Component> listComponents(String message) {
        List<Component> listCompts = null;
        String input = "";
        int resp = 0, nPartes = 0;
        try {
            System.out.println(message);
            input = br.readLine();
            resp = validar(input, message);
            System.out.println("Ingrese el numero de partes que desea agregar: ");
            input = br.readLine();
            nPartes = validar(input);
        } catch (IOException e) {
        }
        if (resp == 1) {
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
        String id, name, price;
        int priceInt;
        try {
            System.out.println(message);
            System.out.println("\nIngrese un id para el componente");
            id = br.readLine();
            System.out.println("\nIngrese un nombre para el componente");
            name = br.readLine();
            System.out.println("\nIngrese un precio para el componente");
            price = br.readLine();
            priceInt = Integer.parseInt(price);
            compt = new Component(id, name, priceInt);
        } catch (IOException e) {
        }
        return compt;
    }

    private int validar(String input, String message) throws IOException {

        int num = 0;
        num = Integer.parseInt(input);
        while (num != 1 && num != 2) {
            System.out.println("Numero no corresponde");
            System.out.println(message);
            input = br.readLine();
            num = Integer.parseInt(input);
        }
        return num;
    }

    private int validar(String nPartes) throws IOException {
        int num = 0;
        num = Integer.parseInt(nPartes);
        while (num <= 0) {
            System.out.println("Solo numeros mayores que cero");
            System.out.println("Ingrese el numero de partes que desea agregar: ");
            nPartes = br.readLine();
            num = Integer.parseInt(nPartes);
        }
        return num;
    }
}
