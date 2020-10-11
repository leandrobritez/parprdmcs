/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.parprdmcs.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import py.una.pol.par.commons.entity.Entity;
import py.una.pol.par.commons.util.DBUtils;
import py.una.pol.par.parprdmcs.model.entity.Category;
import py.una.pol.par.parprdmcs.model.entity.Product;

/**
 *
 * @author justo
 */
public class ProductRepositoryImpl implements ProductRepository<Product, Integer>{

    private final ArrayList<Product> products = new ArrayList<>();
    
    @Override
    public void add(Product entity) {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("INSERT INTO \"PRODUCTOS\" (\"ID\",\"DESCRIPCION\",\"ID_CATEGORIA\",\"PRECIO_UNIT\",\"CANTIDAD\") values (?,?,?,?,?)");
            pstmt.setInt(1, entity.getId());
            pstmt.setString(2, entity.getName());
            pstmt.setInt(3, entity.getCategory().getId());
            pstmt.setLong(4, entity.getPrice());
            pstmt.setInt(5, entity.getAmount());
            pstmt.execute();
            pstmt.close();
            DBUtils.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
         
            }
        }
    }

    @Override
    public void remove(Integer id) {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("DELETE FROM \"PRODUCTOS\" WHERE \"ID\" = ?");

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
               
            }
        }
    }

    @Override
    public void update(Product entity) {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("UPDATE \"PRODUCTOS\" SET \"DESCRIPCION\" = ? ,\"ID_CATEGORIA\" = ? ,\"PRECIO_UNIT\" = ? ,\"CANTIDAD\" = ? WHERE \"ID\"= ? ");

            
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getCategory().getId());
            pstmt.setLong(3, entity.getPrice());
            pstmt.setInt(4, entity.getAmount());
            pstmt.setInt(5, entity.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
            
            }
        }
    }

    @Override
    public boolean contains(Integer id) {
        Entity retValue = null;

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM \"PRODUCTOS\" WHERE \"ID\" = ? ");

            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue = new Product(rs.getInt("ID"), rs.getString("DESCRIPCION"));
            } else {
                retValue = null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {

            }
        }

        if (retValue == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Entity get(Integer id) {
       Entity retValue = null;

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM \"PRODUCTOS\" WHERE \"ID\" = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                
                retValue = new Product(rs.getInt("ID"), rs.getString("DESCRIPCION"),new Category(rs.getInt("ID_CATEGORIA"),"") ,rs.getLong("PRECIO_UNIT"), rs.getInt("CANTIDAD"));
            } else {
                retValue = new Product(null,null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
              
            }
        }

        return retValue;
    }

    @Override
    public Collection<Product> getAll() {
        Collection<Product> retValue = new ArrayList();

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM \"PRODUCTOS\"");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retValue.add(new Product(rs.getInt("ID"), rs.getString("DESCRIPCION"), new Category(rs.getInt("ID_CATEGORIA"),"") ,rs.getLong("PRECIO_UNIT"), rs.getInt("CANTIDAD")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
              
            }
        }

        return retValue;
    }
    
}
