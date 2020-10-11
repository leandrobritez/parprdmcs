/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.parprdmcs.service;

import java.util.Collection;
import py.una.pol.par.commons.entity.Entity;
import py.una.pol.par.parprdmcs.model.entity.Category;

/**
 *
 * @author justo
 */
public interface CategoryService {
    
    public void add(Category category) throws Exception;

    public void update(Category category) throws Exception;

    public void delete(Integer id) throws Exception;

    public Entity findById(Integer id) throws Exception;

    
    public boolean containsCategory(Integer id) throws Exception;
    
    public Collection<Category> getAll() throws Exception;
}
