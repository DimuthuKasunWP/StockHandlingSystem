/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.GrnController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.Batch_receiveDAO;
import com.sas.kem.edu.ijse.dao.custom.GrnDAO;
import com.sas.kem.edu.ijse.dao.custom.MaterialDAO;
import com.sas.kem.edu.ijse.dao.custom.Return_batch_receiveDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Batch_receiveDTO;
import com.sas.kem.edu.ijse.dto.GrnDTO;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import com.sas.kem.edu.ijse.dto.Return_batch_receiveDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public class GrnControllerImpl implements GrnController{
    
    private GrnDAO grnDAO;
    private MaterialDAO matDAO;
    private Batch_receiveDAO batch_receiveDAO;
    private Return_batch_receiveDAO return_batchDAO;
    
    private Connection conn;

    public GrnControllerImpl() {
        
        grnDAO=(GrnDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.GRN);
        matDAO=(MaterialDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.MATERIAL);
        batch_receiveDAO=(Batch_receiveDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.BATCH_RECEIVE);
        return_batchDAO=(Return_batch_receiveDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.RETURN_BATCH_RECEIVE);
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    
    @Override
    public ArrayList<GrnDTO> getAll() throws Exception {

        return grnDAO.getAll();
    }

    @Override
    public boolean add(GrnDTO grn, ArrayList<MaterialDTO> mlist, ArrayList<Batch_receiveDTO> blist) throws Exception {
        
        try{
            conn.setAutoCommit(false);
            
            boolean isAdd=grnDAO.add(grn);
            if(isAdd){
               
                boolean isUpdate=matDAO.update(mlist);
                if(isUpdate){
                    
                    boolean isAddBatch=batch_receiveDAO.add(blist);
                   
                    if(isAddBatch){
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

    @Override
    public boolean add(GrnDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(GrnDTO grn, ArrayList<MaterialDTO> mlist, ArrayList<Return_batch_receiveDTO> blist) throws Exception {

        try{
            conn.setAutoCommit(false);

            boolean isUpdateGrn=grnDAO.update(grn);
            if(isUpdateGrn){
                boolean isUpdateMat=matDAO.update(mlist);
                if(isUpdateMat){
                    boolean isAdd=return_batchDAO.add(blist);
                    if(isAdd){
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
