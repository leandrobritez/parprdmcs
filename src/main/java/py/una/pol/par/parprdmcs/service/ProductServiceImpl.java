/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.parprdmcs.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import py.una.pol.par.commons.entity.Entity;
import py.una.pol.par.commons.service.BaseService;
import py.una.pol.par.parprdmcs.model.entity.Category;
import py.una.pol.par.parprdmcs.model.entity.Product;
import py.una.pol.par.parprdmcs.repository.CategoryRepository;
import py.una.pol.par.parprdmcs.repository.ProductRepository;

/**
 *
 * @author justo
 */
public class ProductServiceImpl extends BaseService<Product, Integer> implements ProductService {

    private ProductRepository<Product, Integer> productRepository;
    private CategoryRepository<Category, Integer> categoryRepository;

    public ProductServiceImpl(ProductRepository<Product, Integer> productRepository, CategoryRepository<Category, Integer> categoryRepository) {
        super(productRepository);
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void update(Product product) throws Exception {
        productRepository.update(product);
    }

    @Override
    public void delete(Integer id) throws Exception {
        productRepository.remove(id);
    }

    @Override
    public Entity findById(Integer id) throws Exception {
        Product product = (Product) productRepository.get(id);
        product.setCategory((Category) categoryRepository.get(product.getCategory().getId()));

        return product;
    }

    /**
     *
     * @return @throws Exception
     */
    @Override
    public Collection<Product> getAlls() throws Exception {
        List<Product> products = (List<Product>) productRepository.getAll();
        for (int i = 0; i < products.size(); i++) {
            products.get(i).setCategory((Category) categoryRepository.get(products.get(i).getCategory().getId()));
        }

        return products;
    }

    @Override
    public Collection<Product> getProductByCategory(String categoryName) throws Exception {
        List<Product> products = (List<Product>) productRepository.getAll();
        for (int i = 0; i < products.size(); i++) {
            products.get(i).setCategory((Category) categoryRepository.get(products.get(i).getCategory().getId()));
        }
        List<Product> response = new ArrayList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCategory().getName().trim().equals(categoryName)) {
                response.add(products.get(i));
            }

        }
        
          return response;
        
    }

    @Override
    public void addProduct(Product product) throws Exception {
        if (product.getName() == null || "".equals(product.getName())) {
            throw new Exception("El nombre del producto no puede ser nulo o cadena vacia.");
        }

        if (product.getCategory() == null) {
            throw new Exception("La categoria no puede ser Nula");
        }

        if (categoryRepository.contains(product.getCategory().getId())) {
            super.add(product);

        } else {
            throw new Exception("No existe id de categoria");
        }

    }

    @Override
    public Entity findByName(String productName) throws Exception {
        List<Product> products = (List<Product>) productRepository.getAll();
        Product response = new Product();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().trim().equals(productName)) {
                response = products.get(i);
                response.setCategory((Category) categoryRepository.get(response.getCategory().getId()));
            }

        }

        return response;

    }

}
