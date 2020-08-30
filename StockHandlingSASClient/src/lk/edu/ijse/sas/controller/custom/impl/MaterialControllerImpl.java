/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.MaterialController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.Batch_receiveDAO;
import com.sas.kem.edu.ijse.dao.custom.MaterialDAO;
import com.sas.kem.edu.ijse.dao.custom.Reject_receiveDAO;
import com.sas.kem.edu.ijse.dao.custom.Reject_return_receiveDAO;
import com.sas.kem.edu.ijse.dao.custom.Return_batch_receiveDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Batch_receiveDTO;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import com.sas.kem.edu.ijse.dto.Reject_receiveDTO;
import com.sas.kem.edu.ijse.dto.Reject_return_receiveDTO;
import com.sas.kem.edu.ijse.dto.Return_batch_receiveDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author dimuthu
 */
public class MaterialControllerImpl implements MaterialController{
    
    private MaterialDAO matDAO;
    private Reject_receiveDAO rejRecDAO;
    private Reject_return_receiveDAO rejRetDAO;
    private Batch_receiveDAO recDAO;
    private Return_batch_receiveDAO retDAO;
    
    private Connection conn;
    
    public MaterialControllerImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
        
        retDAO=(Return_batch_receiveDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.RETURN_BATCH_RECEIVE);
        recDAO=(Batch_receiveDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.BATCH_RECEIVE);
        rejRetDAO=(Reject_return_receiveDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.REJECT_RETURN_RECEIVE);
        rejRecDAO=(Reject_receiveDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.REJECT_RECEIVE);
        matDAO=(MaterialDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.MATERIAL);
    }
    

    @Override
    public ArrayList<MaterialDTO> getAll() throws Exception {
        
        return matDAO.getAll();
    }

    @Override
    public String getMaterialId(String matName) throws Exception {
        
        return matDAO.getMaterialId(matName);
        
    }


    @Override
    public boolean update(ArrayList<MaterialDTO> dtoList) throws Exception {
        
        return matDAO.update(dtoList);
    }

    @Override
    public ObservableList<String> getMatNames(String matName) throws Exception {
        return matDAO.getMatNames(matName);
    }

    @Override
    public String getMatName(String mid) throws Exception {
        
        return matDAO.getMatName(mid);
    }

    @Override
    public boolean add(MaterialDTO dto) throws Exception {

        return matDAO.add(dto);
    }

    @Override
    public boolean updateAsReduce(ArrayList<MaterialDTO> matlist) throws Exception {

        return matDAO.updateAsReduce(matlist);
    }

    @Override
    public boolean updateAsReduce(ArrayList<MaterialDTO> matlist, ArrayList<Return_batch_receiveDTO> retList, ArrayList<Batch_receiveDTO> recList, ArrayList<Reject_receiveDTO> rejRecList, ArrayList<Reject_return_receiveDTO> rejRetList) throws Exception {

        conn.setAutoCommit(false);
        try{
            boolean isReduce=matDAO.updateAsReduce(matlist);
            if(isReduce){
                boolean isUpdateRet=retDAO.update(retList);
                if(isUpdateRet){
                    boolean isUpadteRec=recDAO.update(recList);
                    if(isUpadteRec){
                        boolean isAddRejRec=rejRecDAO.add(rejRecList);
                        if(isAddRejRec){
                            boolean isAddRejRet=rejRetDAO.add(rejRetList);
                            if(isAddRejRet){
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

    @Override
    public boolean updateMatName(String rename, String matName) throws Exception {

        return matDAO.updateMatName(rename, matName);
    }

    @Override
    public boolean remove(String id) throws Exception {

        return matDAO.remove(id);
    }
    
}
