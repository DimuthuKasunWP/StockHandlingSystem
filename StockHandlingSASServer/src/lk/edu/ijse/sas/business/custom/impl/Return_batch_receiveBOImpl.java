/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;

import lk.edu.ijse.sas.service.custom.impl.*;

import java.util.ArrayList;
import lk.edu.ijse.sas.business.custom.Return_batch_receiveBO;
import lk.edu.ijse.sas.dto.Return_batch_receiveDTO;

/**
 *
 * @author dimuthu
 */
public class Return_batch_receiveBOImpl implements Return_batch_receiveBO{

    private Return_batch_receiveDAO batchDAO;

    public Return_batch_receiveBOImpl() {
        
        batchDAO=(Return_batch_receiveDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.RETURN_BATCH_RECEIVE);
    }
    
    
    @Override
    public ArrayList<Return_batch_receiveDTO> getAll() throws Exception {

        return batchDAO.getAll();
    }

    
    
}
