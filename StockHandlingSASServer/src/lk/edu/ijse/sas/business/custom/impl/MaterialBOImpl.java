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
import javafx.collections.ObservableList;
import lk.edu.ijse.sas.business.custom.MaterialBO;
import lk.edu.ijse.sas.dto.Batch_receiveDTO;
import lk.edu.ijse.sas.dto.MaterialDTO;
import lk.edu.ijse.sas.dto.Reject_receiveDTO;
import lk.edu.ijse.sas.dto.Reject_return_receiveDTO;
import lk.edu.ijse.sas.dto.Return_batch_receiveDTO;

/**
 *
 * @author dimuthu
 */
public class MaterialBOImpl implements MaterialBO{
    
    private MaterialDAO matDAO;
    private Reject_receiveDAO rejRecDAO;
    private Reject_return_receiveDAO rejRetDAO;
    private Batch_receiveDAO recDAO;
    private Return_batch_receiveDAO retDAO;
    
    private Connection conn;
    
    public MaterialBOImpl() {
        
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
