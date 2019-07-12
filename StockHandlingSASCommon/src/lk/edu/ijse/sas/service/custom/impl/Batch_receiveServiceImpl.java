/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.Batch_receiveBO;
import lk.edu.ijse.sas.business.custom.MaterialBO;
import lk.edu.ijse.sas.business.custom.Remove_receive_materialBO;
import lk.edu.ijse.sas.business.custom.Remove_return_materialBO;
import lk.edu.ijse.sas.business.custom.Return_batch_receiveBO;
import lk.edu.ijse.sas.dto.Batch_receiveDTO;
import lk.edu.ijse.sas.dto.MaterialDTO;
import lk.edu.ijse.sas.dto.Remove_receive_materialDTO;
import lk.edu.ijse.sas.dto.Remove_return_materialDTO;
import lk.edu.ijse.sas.dto.Return_batch_receiveDTO;
import lk.edu.ijse.sas.service.custom.Batch_receiveService;

/**
 *
 * @author dimuthu
 */
public class Batch_receiveServiceImpl implements Batch_receiveService{
    
    private Batch_receiveBO batch_receiveBO;
    private Return_batch_receiveBO ret_batch_receiveBO;
    private MaterialBO matBO;
    private Remove_receive_materialBO remRecBO;
    private Remove_return_materialBO remRetBO;
    

    public Batch_receiveServiceImpl() {
        
        
        
        matBO=(MaterialBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.MATERIAL);
        remRecBO=(Remove_receive_materialBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REMOVE_RECEIVE_MATERIAL);
        remRetBO=(Remove_return_materialBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REMOVE_RETURN_MATERIAL);
        ret_batch_receiveBO=(Return_batch_receiveBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RETURN_BATCH_RECEIVE);
        batch_receiveBO=(Batch_receiveBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.BATCH_RECEIVE);
    }
    
    

    @Override
    public ArrayList<Batch_receiveDTO> getAll() throws Exception {
        
        return batch_receiveBO.getAll();
    }

    @Override
    public boolean add(ArrayList<Batch_receiveDTO> dtoList) throws Exception {
        
        return batch_receiveBO.add(dtoList);
    }


    @Override
    public boolean update_receive_batch(ArrayList<Batch_receiveDTO> recList, ArrayList<Return_batch_receiveDTO> retList, ArrayList<MaterialDTO> matList, ArrayList<Remove_receive_materialDTO> remRecList, ArrayList<Remove_return_materialDTO> remRetList) throws Exception {


        return batch_receiveBO.update_receive_batch(recList, retList, matList, remRecList, remRetList);
    }

    
}
