/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.patterns.builderconsola;

import co.edu.unicauca.patterns.restaurantebuilder.Builder;
import co.edu.unicauca.patterns.restaurantebuilder.Dish;

/**
 *
 * @author Beca98
 */
public class DishBuilder extends Builder {

    @Override
    public Builder setCore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Builder addParts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Builder setSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Dish getDish() {
        return dish;
    }

    @Override
    public void setDish(Dish dish) {
        this.dish = dish;
    }
}
