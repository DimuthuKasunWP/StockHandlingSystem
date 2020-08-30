/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.Product_orderController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.Batch_addDAO;
import com.sas.kem.edu.ijse.dao.custom.ProductDAO;
import com.sas.kem.edu.ijse.dao.custom.Product_orderDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import com.sas.kem.edu.ijse.dto.Product_orderDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class Product_orderControllerImpl implements Product_orderController{
    
    private Product_orderDAO proDAO;
    private ProductDAO pdao;
    private Batch_addDAO batchDAO;
    
    private Connection conn;

    public Product_orderControllerImpl() {
    
        conn=ConnectionFactory.getInstance().getConnection();
        
        proDAO=(Product_orderDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.PRODUCT_ORDER);
        pdao=(ProductDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.PRODUCT);
        batchDAO=(Batch_addDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.BATCH_ADD);
    }
    
    

    @Override
    public ArrayList<Product_orderDTO> getAll() throws Exception {

        return proDAO.getAll();
    }

    @Override
    public boolean add(ArrayList<Product_orderDTO> dtoList) throws Exception {
        
        return proDAO.add(dtoList);
    }
    
    @Override
    public boolean delete(String oid) throws Exception {

        return proDAO.delete(oid);
    }

    @Override
    public boolean update(String oid, ArrayList<ProductDTO> prolist, ArrayList<Batch_addDTO> blist) throws Exception {
        
        try{
            conn.setAutoCommit(false);
            
            boolean isRemove=proDAO.delete(oid);
            if(isRemove){
                boolean isUpdateProduct=pdao.updateAsIncreased(prolist);
                if(isUpdateProduct){
                    boolean isUpdateBatch=batchDAO.updateAsIncreased(blist);
                    if(isUpdateBatch){
                        conn.commit();
                        return true;
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
