/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.parprdmcs.model.entity;

import py.una.pol.par.commons.entity.BaseEntity;

/**
 *
 * @author justo
 */
public class Category extends BaseEntity<Integer>{

    public Category() {
    }
    
    
    
    public Category(Integer id, String name) {
        super(id, name);
    }
  

    @Override
    public String toString() {
        return "Category{" +"id="+ this.getId() +"name="+ this.getName() + '}';
    }
    
}
