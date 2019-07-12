/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;

import lk.edu.ijse.sas.service.custom.impl.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.edu.ijse.sas.business.custom.OrdersBO;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.dto.OrdersDTO;
import lk.edu.ijse.sas.dto.ProductDTO;
import lk.edu.ijse.sas.dto.Product_orderDTO;

/**
 *
 * @author dimuthu
 */
public class OrdersBOImpl implements OrdersBO{
    
    private Connection conn;
    
    private OrdersDAO ordersDAO;
    private Product_orderDAO proOrderDAO;
    private Batch_addDAO batch_addDAO;
    private ProductDAO proDAO;

    public OrdersBOImpl() {
        
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
