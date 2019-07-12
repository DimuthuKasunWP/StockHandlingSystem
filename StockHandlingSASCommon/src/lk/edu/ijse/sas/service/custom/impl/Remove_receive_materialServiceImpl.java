/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;


import java.util.ArrayList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.Remove_receive_materialBO;
import lk.edu.ijse.sas.dto.Remove_receive_materialDTO;
import lk.edu.ijse.sas.service.custom.Remove_receive_materialService;

/**
 *
 * @author dimuthu
 */
public class Remove_receive_materialServiceImpl implements Remove_receive_materialService{

    private Remove_receive_materialBO matBO;

    public Remove_receive_materialServiceImpl() {
        
        matBO=(Remove_receive_materialBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REMOVE_RECEIVE_MATERIAL);
    }
    
    
    @Override
    public ArrayList<Remove_receive_materialDTO> getAll() throws Exception {

        return matBO.getAll();
    }

    
    
}
