/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;

import lk.edu.ijse.sas.service.custom.impl.*;

import java.util.ArrayList;
import lk.edu.ijse.sas.business.custom.Remove_return_materialBO;
import lk.edu.ijse.sas.dto.Remove_return_materialDTO;

/**
 *
 * @author dimuthu
 */
public class Remove_return_materialBOImpl implements Remove_return_materialBO{

    private Remove_return_materialDAO matDAO;

    public Remove_return_materialBOImpl() {
        matDAO=(Remove_return_materialDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.REMOVE_RETURN_MATERIAL);
    }
    
    
    @Override
    public ArrayList<Remove_return_materialDTO> getAll() throws Exception {
        
        return matDAO.getAll();
    }

    
    
}
