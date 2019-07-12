/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.OrdersController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.Batch_addDAO;
import com.sas.kem.edu.ijse.dao.custom.OrdersDAO;
import com.sas.kem.edu.ijse.dao.custom.ProductDAO;
import com.sas.kem.edu.ijse.dao.custom.Product_orderDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import com.sas.kem.edu.ijse.dto.OrdersDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import com.sas.kem.edu.ijse.dto.Product_orderDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public class OrdersControllerImpl implements OrdersController{
    
    private Connection conn;
    
    private OrdersDAO ordersDAO;
    private Product_orderDAO proOrderDAO;
    private Batch_addDAO batch_addDAO;
    private ProductDAO proDAO;

    public OrdersControllerImpl() {
        
        batch_addDAO=(Batch_addDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.BATCH_ADD);
        proDAO=(ProductDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.PRODUCT);
        proOrderDAO=(Product_orderDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.PRODUCT_ORDER);
        ordersDAO=(OrdersDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.ORDERS);
        
        conn=ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public ArrayList<OrdersDTO> getAll() throws Exception {

        return ordersDAO.getAll();
    }

    @Override
    public boolean add(OrdersDTO dto, ArrayList<ProductDTO> prolist,ArrayList<Product_orderDTO> plist,ArrayList<Batch_addDTO> blist) throws Exception {
        
        try{
            conn.setAutoCommit(false);

            boolean isAddOrder=ordersDAO.add(dto);
            if(isAddOrder){

                boolean isUpdatePro=proDAO.update(prolist);
                if(isUpdatePro){
                    
                    boolean isUpdateBatch=batch_addDAO.update(blist);
                    if(isUpdateBatch){
                       
                        boolean isAddProOrder=proOrderDAO.add(plist);
                        if(isAddProOrder){
                            conn.commit();
                            return true;
                        }
                    }
                    
                }
            }
            conn.rollback();
            return false;
        }catch(SQLException ex){
            conn.rollback();
            return false;
        }finally{
            conn.setAutoCommit(true);
        }
    }

    @Override
    public boolean add(OrdersDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(OrdersDTO dto, ArrayList<ProductDTO> prolist, ArrayList<Product_orderDTO> plist, ArrayList<Batch_addDTO> blist) throws Exception {

        try{
            conn.setAutoCommit(false);

            boolean isUpdateOrder=ordersDAO.update(dto);
            if(isUpdateOrder){

                boolean isUpdatePro=proDAO.update(prolist);
                if(isUpdatePro){
                    
                    boolean isUpdateBatch=batch_addDAO.update(blist);
                    if(isUpdateBatch){
                       
                        boolean isAddProOrder=proOrderDAO.add(plist);
                        if(isAddProOrder){
                            conn.commit();
                            return true;
                        }
                    }
                    
                }
            }
            conn.rollback();
            return false;
        }catch(SQLException ex){
            conn.rollback();
            return false;
        }finally{
            conn.setAutoCommit(true);
        }
    }
    
}
