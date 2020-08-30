/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.Remove_receive_materialController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.Remove_receive_materialDAO;
import com.sas.kem.edu.ijse.dto.Remove_receive_materialDTO;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class Remove_receive_materialControllerImpl implements Remove_receive_materialController{

    private Remove_receive_materialDAO matDAO;

    public Remove_receive_materialControllerImpl() {
        
        matDAO=(Remove_receive_materialDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.REMOVE_RECEIVE_MATERIAL);
    }
    
    
    @Override
    public ArrayList<Remove_receive_materialDTO> getAll() throws Exception {

        return matDAO.getAll();
    }

    @Override
    public boolean add(ArrayList<Remove_receive_materialDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ArrayList<Remove_receive_materialDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Remove_receive_materialDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
