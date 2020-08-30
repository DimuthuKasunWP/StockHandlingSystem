/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.Return_orderController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.Batch_addDAO;
import com.sas.kem.edu.ijse.dao.custom.ProductDAO;
import com.sas.kem.edu.ijse.dao.custom.Return_orderDAO;
import com.sas.kem.edu.ijse.dao.custom.Return_order_detailDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import com.sas.kem.edu.ijse.dto.Return_orderDTO;
import com.sas.kem.edu.ijse.dto.Return_order_detailDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class Return_orderControllerImpl implements Return_orderController{
    
    private Connection conn;
    
    private Return_orderDAO retOrderDAO;
    private Batch_addDAO batchDAO;
    private ProductDAO proDAO;
    private Return_order_detailDAO retOrderDetailDAO;

    public Return_orderControllerImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
        
        retOrderDAO=(Return_orderDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.RETURN_ORDER);
        batchDAO=(Batch_addDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.BATCH_ADD);
        proDAO=(ProductDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.PRODUCT);
        retOrderDetailDAO=(Return_order_detailDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.RETURN_ORDER_DETAIL);
    }
    
    

    @Override
    public ArrayList<Return_orderDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Return_orderDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
