/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.PasswordController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.PasswordDAO;
import com.sas.kem.edu.ijse.dto.PasswordDTO;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class PasswordControllerImpl implements PasswordController{
    
    private PasswordDAO passwordDAO;

    public PasswordControllerImpl() {
        
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
