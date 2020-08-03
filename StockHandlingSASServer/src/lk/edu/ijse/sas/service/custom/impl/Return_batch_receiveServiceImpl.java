/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;


import java.util.ArrayList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.Return_batch_receiveBO;
import lk.edu.ijse.sas.dto.Return_batch_receiveDTO;
import lk.edu.ijse.sas.service.custom.Return_batch_receiveService;

/**
 *
 * @author dimuthu
 */
public class Return_batch_receiveServiceImpl implements Return_batch_receiveService{

    private Return_batch_receiveBO batchBO;

    public Return_batch_receiveServiceImpl() {
        
        batchBO=(Return_batch_receiveBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RETURN_BATCH_RECEIVE);
    }
    
    
    @Override
    public ArrayList<Return_batch_receiveDTO> getAll() throws Exception {

        return batchBO.getAll();
    }

   
    
}
