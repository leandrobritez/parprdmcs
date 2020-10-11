/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.parprdmcs.service;

import java.util.Collection;
import py.una.pol.par.commons.entity.Entity;
import py.una.pol.par.commons.service.BaseService;
import py.una.pol.par.parprdmcs.model.entity.Category;
import py.una.pol.par.parprdmcs.repository.CategoryRepository;

/**
 *
 * @author justo
 */
public class CategoryServiceImpl extends BaseService<Category, Integer>implements CategoryService {

   private final CategoryRepository<Category, Integer> categoryRepository;

    public CategoryServiceImpl(CategoryRepository<Category, Integer> categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void update(Category category) throws Exception {
        categoryRepository.update(category);
    }

    @Override
    public void delete(Integer id) throws Exception {
        categoryRepository.remove(id);
    }

    @Override
    public Entity findById(Integer id) throws Exception {
        return categoryRepository.get(id);
    }



    @Override
    public void add(Category category) throws Exception {
        if (category.getName() == null || "".equals(category.getName())) {
            throw new Exception("El nombre del usuario no puede ser nulo o cadena vacia.");
        }
        super.add(category);
    }

    @Override
    public boolean containsCategory(Integer id) throws Exception {
        return categoryRepository.contains(id);
    }


    
}
