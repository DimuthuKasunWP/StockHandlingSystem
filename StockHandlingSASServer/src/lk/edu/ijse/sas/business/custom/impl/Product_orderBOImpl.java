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
import lk.edu.ijse.sas.business.custom.Product_orderBO;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.dto.ProductDTO;
import lk.edu.ijse.sas.dto.Product_orderDTO;

/**
 *
 * @author dimuthu
 */
public class Product_orderBOImpl implements Product_orderBO{
    
    private Product_orderDAO proDAO;
    private ProductDAO pdao;
    private Batch_addDAO batchDAO;
    
    private Connection conn;

    public Product_orderBOImpl() {
    
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
