/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.edu.ijse.sas.business.custom.Batch_receiveBO;
import lk.edu.ijse.sas.dto.Batch_receiveDTO;

/**
 *
 * @author dimuthu
 */
public class Batch_receiveBOImpl implements Batch_receiveBO{
    
    private Batch_receiveDAO batch_receiveDAO;
    private Return_batch_receiveDAO ret_batch_receiveDAO;
    private MaterialDAO matDAO;
    private Remove_receive_materialDAO remRecDAO;
    private Remove_return_materialDAO remRetDAO;
    private Connection conn;

    public Batch_receiveBOImpl() {
        
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
