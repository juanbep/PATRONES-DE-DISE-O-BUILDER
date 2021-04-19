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
public class Component {

    /**
     * Id del componente
     */
    private String id;
    /**
     * nombre del componente
     */
    private String name;
    /**
     * precio del componente
     */
    private int precio;

    /**
     * Constructor por defecto
     */
    public Component() {

    }

    /**
     * Constructor parametrizado
     *
     * @param id
     * @param name
     * @param precio
     */
    public Component(String id, String name, int precio) {
        this.id = id;
        this.name = name;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Component{" + "id=" + id + ", name=" + name + ", precio=" + precio + '}';
    }

}
