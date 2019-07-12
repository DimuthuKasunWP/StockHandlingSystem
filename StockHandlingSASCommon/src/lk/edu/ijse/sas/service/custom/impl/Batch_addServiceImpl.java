/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;


import java.util.ArrayList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.Batch_addBO;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.service.custom.Batch_addService;

/**
 *
 * @author dimuthu
 */
public class Batch_addServiceImpl implements Batch_addService{
    
    private Batch_addBO addBO;

    public Batch_addServiceImpl() {
        addBO=(Batch_addBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.BATCH_ADD);
    }
    
    

    @Override
    public ArrayList<Batch_addDTO> getAll() throws Exception {
        
        return addBO.getAll();
    }

   

    @Override
    public String getProId(String baid) throws Exception {

        return addBO.getProId(baid);
    }

}
