/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;

import lk.edu.ijse.sas.service.custom.impl.*;

import java.util.ArrayList;
import lk.edu.ijse.sas.business.custom.Remove_receive_materialBO;
import lk.edu.ijse.sas.dto.Remove_receive_materialDTO;

/**
 *
 * @author dimuthu
 */
public class Remove_receive_materialBOImpl implements Remove_receive_materialBO{

    private Remove_receive_materialDAO matDAO;

    public Remove_receive_materialBOImpl() {
        
        matDAO=(Remove_receive_materialDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.REMOVE_RECEIVE_MATERIAL);
    }
    
    
    @Override
    public ArrayList<Remove_receive_materialDTO> getAll() throws Exception {

        return matDAO.getAll();
    }

    
}
