/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;


import java.util.ArrayList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.Remove_return_materialBO;
import lk.edu.ijse.sas.dto.Remove_return_materialDTO;
import lk.edu.ijse.sas.service.custom.Remove_return_materialService;

/**
 *
 * @author dimuthu
 */
public class Remove_return_materialServiceImpl implements Remove_return_materialService{

    private Remove_return_materialBO matBO;

    public Remove_return_materialServiceImpl() {
        matBO=(Remove_return_materialBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REMOVE_RETURN_MATERIAL);
    }
    
    
    @Override
    public ArrayList<Remove_return_materialDTO> getAll() throws Exception {
        
        return matBO.getAll();
    }

   
    
}
