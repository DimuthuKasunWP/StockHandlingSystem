/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;


import java.util.ArrayList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.PasswordBO;
import lk.edu.ijse.sas.dto.PasswordDTO;
import lk.edu.ijse.sas.service.custom.PasswordService;

/**
 *
 * @author dimuthu
 */
public class PasswordServiceImpl implements PasswordService{
    
    private PasswordBO passwordBO;

    public PasswordServiceImpl() {
        
        passwordBO=(PasswordBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PASSWORD);
    
    }
    
    
    @Override
    public ArrayList<PasswordDTO> getAll() throws Exception {
        
        return passwordBO.getAll();
    }

    @Override
    public boolean updatePassword(String userName, String password, String lastName) throws Exception {

        return passwordBO.updatePassword(userName, password, lastName);
    }
    
}
