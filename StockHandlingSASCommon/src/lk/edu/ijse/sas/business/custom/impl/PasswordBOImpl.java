/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;

import lk.edu.ijse.sas.service.custom.impl.*;

import java.util.ArrayList;
import lk.edu.ijse.sas.business.custom.PasswordBO;
import lk.edu.ijse.sas.dto.PasswordDTO;

/**
 *
 * @author dimuthu
 */
public class PasswordBOImpl implements PasswordBO{
    
    private PasswordDAO passwordDAO;

    public PasswordBOImpl() {
        
        passwordDAO=(PasswordDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.PASSWORD);
    
    }
    
    
    @Override
    public ArrayList<PasswordDTO> getAll() throws Exception {
        
        return passwordDAO.getAll();
    }

    @Override
    public boolean updatePassword(String userName, String password, String lastName) throws Exception {

        return passwordDAO.updatePassword(userName, password, lastName);
    }
    
}
