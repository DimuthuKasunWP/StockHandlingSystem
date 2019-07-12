/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.Return_batch_receiveController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.Return_batch_receiveDAO;
import com.sas.kem.edu.ijse.dto.Return_batch_receiveDTO;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public class Return_batch_receiveControllerImpl implements Return_batch_receiveController{

    private Return_batch_receiveDAO batchDAO;

    public Return_batch_receiveControllerImpl() {
        
        batchDAO=(Return_batch_receiveDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.RETURN_BATCH_RECEIVE);
    }
    
    
    @Override
    public ArrayList<Return_batch_receiveDTO> getAll() throws Exception {

        return batchDAO.getAll();
    }

    @Override
    public boolean add(ArrayList<Return_batch_receiveDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ArrayList<Return_batch_receiveDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Return_batch_receiveDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
