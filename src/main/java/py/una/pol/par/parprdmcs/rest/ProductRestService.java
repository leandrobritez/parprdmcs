/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.parprdmcs.rest;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import py.una.pol.par.parprdmcs.model.entity.Category;
import py.una.pol.par.parprdmcs.model.entity.Product;
import py.una.pol.par.parprdmcs.repository.CategoryRepositoryImpl;
import py.una.pol.par.parprdmcs.repository.ProductRepositoryImpl;
import py.una.pol.par.parprdmcs.service.CategoryServiceImpl;
import py.una.pol.par.parprdmcs.service.ProductServiceImpl;


/**
 *
 * @author justo
 */
@Path("/parprdmcs/v1")
public class ProductRestService {


        private final ProductServiceImpl productService = new ProductServiceImpl(new ProductRepositoryImpl(),new CategoryRepositoryImpl());
        private final CategoryServiceImpl categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());
        
        @GET
        @Path("/categories/products")
        @Produces("application/json")
        public ArrayList<Product> getProducts() throws Exception {
            ArrayList<Product> products = (ArrayList) productService.getAlls();
            return products;
        }
        
        @GET
        @Path("/categories/products/category/{categoryName}")
        @Produces("application/json")
        public ArrayList<Product> getProductsByCategory(@PathParam("categoryName") String categoryName) throws Exception {
           
            ArrayList<Product> products = (ArrayList) productService.getProductByCategory(categoryName);
            
            return products;
        }


        @GET
        @Path("/categories/products/{id}")
        @Produces("application/json")
        public Product getProduct(@PathParam("id") Integer id) {
            Product entity = null;
            try {
                entity = (Product) productService.findById(id);
            } catch (Exception ex) {
                Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return entity;
        }
        
        @GET
        @Path("/categories/products/name/{name}")
        @Produces("application/json")
        public Product getProductByName(@PathParam("name") String name) {
            Product entity = null;
            try {
                entity = (Product) productService.findByName(name);
            } catch (Exception ex) {
                Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return entity;
        }

        @POST
        @Path("/categories/products")
        @Consumes("application/json")
        @Produces("application/json")
        public Product addProduct(Product entity) {
            try {
                productService.add(entity);
            } catch (Exception ex) {
                Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return entity;
        }

        @PUT
        @Path("/categories/products")
        @Consumes("application/json")
        public void updateProduct(Product entity) {
            try {
                productService.update(entity);
            } catch (Exception ex) {
                Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @DELETE
        @Path("/categories/products/{id}")
        public void removeProduct(@PathParam("id") Integer id) {
            try {
                productService.delete(id);
            } catch (Exception ex) {
                Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
        
        
        @GET
        @Path("/categories")
        @Produces("application/json")
        public ArrayList<Category> getCategory() throws Exception {
            ArrayList<Category> categories = (ArrayList) categoryService.getAll();
            return categories;
        }

        @GET
        @Path("/categories/{id}")
        @Produces("application/json")
        public Category getCategory(@PathParam("id") Integer id) {
            Category entity = null;
            try {
                entity = (Category) categoryService.findById(id);
            } catch (Exception ex) {
                Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return entity;
        }

        @POST
        @Path("/categories")
        @Consumes("application/json")
        @Produces("application/json")
        public Category addCategory(Category entity) {
            try {
                categoryService.add(entity);
            } catch (Exception ex) {
                Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return entity;
        }

        @PUT
        @Path("categories")
        @Consumes("application/json")
        public void updateCategory(Category entity) {
            try {
                categoryService.update(entity);
            } catch (Exception ex) {
                Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }

        @DELETE
        @Path("/categories/{id}")
        public void removeCategory(@PathParam("id") Integer id) {
            try {
                categoryService.delete(id);
            } catch (Exception ex) {
                Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
