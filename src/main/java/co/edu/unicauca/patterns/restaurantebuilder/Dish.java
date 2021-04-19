/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.patterns.restaurantebuilder;

import java.util.List;

/**
 *
 * @author Beca98
 */
public class Dish {

    private String name;
    private String description;
    private String image;
    private int price;
    private Component base;
    private List<Component> parts;
    private EnumSize size;

    public int calculatePriceParts() {

        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public EnumSize getSize() {
        return size;
    }

    public void setSize(EnumSize size) {
        this.size = size;
    }

    public Component getBase() {
        return base;
    }

    public void setBase(Component base) {
        this.base = base;
    }

    public List<Component> getParts() {
        return parts;
    }

    public void setParts(List<Component> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "Dish{" + "name=" + name + ", description=" + description + ", image=" + image + ", price=" + price + ", base=" + base + ", size=" + size + '}';
    }
 
}
