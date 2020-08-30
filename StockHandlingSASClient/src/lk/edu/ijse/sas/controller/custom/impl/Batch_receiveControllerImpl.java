/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.Batch_receiveController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.Batch_receiveDAO;
import com.sas.kem.edu.ijse.dao.custom.MaterialDAO;
import com.sas.kem.edu.ijse.dao.custom.Remove_receive_materialDAO;
import com.sas.kem.edu.ijse.dao.custom.Remove_return_materialDAO;
import com.sas.kem.edu.ijse.dao.custom.Return_batch_receiveDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Batch_receiveDTO;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import com.sas.kem.edu.ijse.dto.Remove_receive_materialDTO;
import com.sas.kem.edu.ijse.dto.Remove_return_materialDTO;
import com.sas.kem.edu.ijse.dto.Return_batch_receiveDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class Batch_receiveControllerImpl implements Batch_receiveController{
    
    private Batch_receiveDAO batch_receiveDAO;
    private Return_batch_receiveDAO ret_batch_receiveDAO;
    private MaterialDAO matDAO;
    private Remove_receive_materialDAO remRecDAO;
    private Remove_return_materialDAO remRetDAO;
    private Connection conn;

    public Batch_receiveControllerImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
        
        matDAO=(MaterialDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.MATERIAL);
        remRecDAO=(Remove_receive_materialDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.REMOVE_RECEIVE_MATERIAL);
        remRetDAO=(Remove_return_materialDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.REMOVE_RETURN_MATERIAL);
        ret_batch_receiveDAO=(Return_batch_receiveDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.RETURN_BATCH_RECEIVE);
        batch_receiveDAO=(Batch_receiveDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.BATCH_RECEIVE);
    }
    
    

    @Override
    public ArrayList<Batch_receiveDTO> getAll() throws Exception {
        
        return batch_receiveDAO.getAll();
    }

    @Override
    public boolean add(ArrayList<Batch_receiveDTO> dtoList) throws Exception {
        
        return batch_receiveDAO.add(dtoList);
    }

    @Override
    public boolean add(Batch_receiveDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update_receive_batch(ArrayList<Batch_receiveDTO> recList, ArrayList<Return_batch_receiveDTO> retList, ArrayList<MaterialDTO> matList, ArrayList<Remove_receive_materialDTO> remRecList, ArrayList<Remove_return_materialDTO> remRetList) throws Exception {

        conn.setAutoCommit(false);
        try{
            boolean isUpdateRecBatch=batch_receiveDAO.update(recList);
            if(isUpdateRecBatch){
                boolean isUpadateRetBatch=ret_batch_receiveDAO.update(retList);
                if(isUpadateRetBatch){
                    boolean isUpdateMat=matDAO.updateAsReduce(matList);
                    if(isUpdateMat){
                        boolean isAddRemRec=remRecDAO.add(remRecList);
                        if(isAddRemRec){
                            boolean isAddRemRet=remRetDAO.add(remRetList);
                            if(isAddRemRet){
                                conn.commit();
                                return true;
                            }
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
