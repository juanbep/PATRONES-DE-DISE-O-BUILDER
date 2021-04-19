/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.patterns.restaurantebuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beca98
 */
public abstract class DishBuilder {

    protected Dish dish;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

    /**
     * Metodo abstracto para armar la parte principal del plato.
     *
     * @return
     */
    public abstract DishBuilder setCore();

    /**
     * Metodo abstracto para agregar partes extra al plato.
     *
     * @return
     */
    public abstract DishBuilder addParts();

    /**
     * Metodo abstracto para agregar el tamaño del plato(ALL o HALF)
     *
     * @return
     */
    public abstract DishBuilder setSize();

    /**
     * Metodo abstracto para calcular el precio del plato dependiendo del numero
     * de partes añadidas y del tamaño del plato.
     *
     * @return
     */
    public abstract DishBuilder calculatePriceDish();

    public String read(String message) {
        String input = "";
        try {
            System.out.println(message);
            input = br.readLine();
        } catch (IOException e) {
        }
        return input;
    }

    /**
     * Este metodo permite elegir al usuario el tamaño de su plato. puede
     * ingresar el numero 1 para tamaño ALL o el numero 2 para tamaño HALF.
     *
     * @return
     */
    public EnumSize readEnumSize() {
        String input = "";
        String message = "\nIngrese el tamaño del plato: "
                + "\n1. ALL"
                + "\n2. HALF";
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

    /**
     * Este metodo se encarga de agregar los componentes extras a un plato, el
     * usuario puede agregar varios por lo que se guardan en una lista de
     * componentes.
     *
     * @return una lista de componentes
     */
    public List<Component> listComponents() {
        List<Component> listCompts = null;
        String input = "";
        String message = "\n¿Dese agregar mas partes al plato? \n"
                + "1. Si \n"
                + "2. No";
        int resp = 0, nPartes = 0;
        try {
            System.out.println(message);
            input = br.readLine();
            resp = validar(input, message);
            if (resp == 1) {
                System.out.println("Ingrese el numero de partes que desea agregar: ");
                input = br.readLine();
                nPartes = validar(input);
                listCompts = new ArrayList();
                for (int i = 0; i < nPartes; i++) {
                    listCompts.add(addComponent("\nIngrese los datos para el componente " + (i + 1)));
                }
                return listCompts;
            }
        } catch (IOException e) {
        }
        return listCompts;
    }

    /**
     * Este metodo se encarga de agregar un componente al plato.
     *
     * @param message
     * @return un objeto de tipo componente
     */
    public Component addComponent(String message) {
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

    /**
     * Este método se encarga de validar que un numero que llega por parametro
     * corresponda a las opciones 1 o 2,1 para ALL y 2 para HALF, de lo
     * contrario se vuelve a pedir al usuario que ingrese una opcion correcta.
     *
     * @param input
     * @param message
     * @return
     * @throws IOException
     */
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

    /**
     * Este metodo se encarga de validar que el numero de componentes que el
     * usario desea agregar al plato sea mayor que cero, de lo contrario se
     * vuelve a pedir al usuario que ingrese un valor valido.
     *
     * @param nPartes
     * @return
     * @throws IOException
     */
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
