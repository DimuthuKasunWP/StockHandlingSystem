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
import lk.edu.ijse.sas.business.custom.GrnBO;
import lk.edu.ijse.sas.dto.Batch_receiveDTO;
import lk.edu.ijse.sas.dto.GrnDTO;
import lk.edu.ijse.sas.dto.MaterialDTO;
import lk.edu.ijse.sas.dto.Return_batch_receiveDTO;

/**
 *
 * @author dimuthu
 */
public class GrnBOImpl implements GrnBO{
    
    private GrnDAO grnDAO;
    private MaterialDAO matDAO;
    private Batch_receiveDAO batch_receiveDAO;
    private Return_batch_receiveDAO return_batchDAO;
    
    private Connection conn;

    public GrnBOImpl() {
        
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
