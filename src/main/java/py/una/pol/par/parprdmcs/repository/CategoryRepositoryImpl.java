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
import javax.annotation.Resource;
import javax.sql.DataSource;
import py.una.pol.par.commons.entity.Entity;
import py.una.pol.par.commons.util.DBUtils;
import py.una.pol.par.parprdmcs.model.entity.Category;


/**
 *
 * @author justo
 */
public class CategoryRepositoryImpl implements CategoryRepository<Category, Integer> {

    private final ArrayList<Category> categories = new ArrayList<>();

    public CategoryRepositoryImpl() {
    }
    @Resource(name = "jdbc/javausecasedb")
    private DataSource ds;
    @Override
    public void add(Category entity) {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("INSERT INTO \"CATEGORIAS\"(\"ID\",\"DESCRIPCION\") values (?,?)");
            pstmt.setInt(1, entity.getId());
            pstmt.setString(2, entity.getName());

         
            pstmt.execute();
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
            pstmt = c.prepareStatement("DELETE FROM \"CATEGORIAS\" WHERE \"ID\" = ?");

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
    public void update(Category entity) {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("UPDATE \"CATEGORIAS\" SET \"DESCRIPCION\" = ? WHERE \"ID\" = ? ");

            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getId());
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
            pstmt = c.prepareStatement("SELECT * FROM \"CATEGORIAS\" WHERE \"ID\" = ? ");

            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue = new Category(rs.getInt("ID"), rs.getString("DESCRIPCION"));
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
            pstmt = c.prepareStatement("SELECT * FROM \"CATEGORIAS\" WHERE \"ID\" = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue = new Category(rs.getInt("ID"), rs.getString("DESCRIPCION"));
            } else {
                retValue = new Category(null,null);
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
    public Collection<Category> getAll() {
        Collection<Category> retValue = new ArrayList();

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM \"CATEGORIAS\"");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retValue.add(new Category(rs.getInt("ID"), rs.getString("DESCRIPCION")));
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
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }

}
