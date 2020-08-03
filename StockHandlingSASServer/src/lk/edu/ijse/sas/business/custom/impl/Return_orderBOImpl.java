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
import lk.edu.ijse.sas.business.custom.Return_orderBO;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.dto.ProductDTO;
import lk.edu.ijse.sas.dto.Return_orderDTO;
import lk.edu.ijse.sas.dto.Return_order_detailDTO;

/**
 *
 * @author dimuthu
 */
public class Return_orderBOImpl implements Return_orderBO{
    
    private Connection conn;
    
    private Return_orderDAO retOrderDAO;
    private Batch_addDAO batchDAO;
    private ProductDAO proDAO;
    private Return_order_detailDAO retOrderDetailDAO;

    public Return_orderBOImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
        
        retOrderDAO=(Return_orderDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.RETURN_ORDER);
        batchDAO=(Batch_addDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.BATCH_ADD);
        proDAO=(ProductDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.PRODUCT);
        retOrderDetailDAO=(Return_order_detailDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.RETURN_ORDER_DETAIL);
    }
    
    

    

    @Override
    public boolean add(Return_orderDTO ret, ArrayList<Return_order_detailDTO> rlist, ArrayList<Batch_addDTO> blist, ArrayList<ProductDTO> prolist) throws Exception {

        try{
            conn.setAutoCommit(false);
            
            boolean isAdd=retOrderDAO.add(ret);
            
            if(isAdd){
                boolean isAddDetail=retOrderDetailDAO.add(rlist);
                
                if(isAddDetail){
                    boolean isUpdateBatch=batchDAO.update(blist);
                    
                    if(isUpdateBatch){
                        boolean isUpdatePro=proDAO.update(prolist);
                        
                        if(isUpdatePro){
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
