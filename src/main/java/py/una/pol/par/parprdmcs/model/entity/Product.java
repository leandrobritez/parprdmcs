/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.parprdmcs.model.entity;

import py.una.pol.par.commons.entity.BaseEntity;

/**
 *
 * @author Justo
 */
public class Product extends BaseEntity<Integer> {

    private Category category;
    private Long price;
    private Integer amount;

    
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    

    public Product(Integer id, String name) {
        super(id, name);
    }

    public Product(Integer id, String name,Category category, Long price,Integer amount ) {
        super(id, name);
        this.category = category;
        this.price = price;
        this.amount = amount;
    }

    public Product(Integer id, String name, Long price,Integer amount ) {
        super(id, name);
        this.category = category;
        this.price = price;
        this.amount = amount;
    }

    public Product(Long price) {
        this.price = price;
    }

    public Product() {
    }

   
    


    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{"+"id = "+ this.getId() +", name = "+this.getName() + ", price = " + price + ", category = " + this.getCategory() + ", amount = " + amount + '}';
    }

    
    
}
