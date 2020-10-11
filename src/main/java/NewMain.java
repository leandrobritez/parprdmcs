
import java.util.ArrayList;
import py.una.pol.par.parprdmcs.model.entity.Category;
import py.una.pol.par.parprdmcs.model.entity.Product;
import py.una.pol.par.parprdmcs.repository.CategoryRepositoryImpl;
import py.una.pol.par.parprdmcs.repository.ProductRepository;
import py.una.pol.par.parprdmcs.repository.ProductRepositoryImpl;
import py.una.pol.par.parprdmcs.service.CategoryServiceImpl;
import py.una.pol.par.parprdmcs.service.ProductServiceImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *

 */
public class NewMain {
    
    private static ProductRepositoryImpl dao = new ProductRepositoryImpl();
   
    private static CategoryRepositoryImpl daoC = new CategoryRepositoryImpl();
    private static CategoryServiceImpl serviceC = new CategoryServiceImpl(daoC);
    private static ProductServiceImpl service = new ProductServiceImpl(dao,daoC);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //pruebas de services
        
        Category c =  new Category(1,"Aires");
//        serviceC.add(c);
//        System.out.println(daoC.getAll());
          serviceC.update(c);
//        System.out.println(daoC.contains(2));
//        System.out.println(daoC.contains(1));
//        Product p = new Product(4,"subaru",c,Long.valueOf("5000"),4);
//      
//        service.delete(3);
//        service.add(p);
//        System.out.println(serviceC.getAll());;

        
       
        
    }

//    private static void printUsers() {
//        ArrayList<User> users = (ArrayList<User>) imur.getAll();
//        for (User user : users) {
//            System.out.println("Usuario: " + user);
//        }
//    }

}
