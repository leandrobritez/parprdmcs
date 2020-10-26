/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.parprdmcs.service;

import java.util.Collection;
import py.una.pol.par.commons.entity.Entity;
import py.una.pol.par.parprdmcs.model.entity.Product;

/**
 *
 * @author justo
 */
public interface ProductService {
  
    public void add(Product product) throws Exception;

    public void update(Product product) throws Exception;

    public void delete(Integer id) throws Exception;

    public Entity findById(Integer id) throws Exception;

    public Collection<Product> getAll() throws Exception;
    
    public Collection<Product> getAlls() throws Exception;
    
    public Collection<Product> getProductByCategory(String categoryName) throws Exception;
    
    public void addProduct(Product product) throws Exception;
    
    public Entity findByName(String productName) throws Exception;
    
}
