/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;


import java.util.ArrayList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.Reject_receiveBO;
import lk.edu.ijse.sas.dto.Reject_receiveDTO;
import lk.edu.ijse.sas.service.custom.Reject_receiveService;

/**
 *
 * @author dimuthu
 */
public class Reject_receiveServiceImpl implements Reject_receiveService{

    private Reject_receiveBO rejRecBO;

    public Reject_receiveServiceImpl() {
        rejRecBO=(Reject_receiveBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REJECT_RECEIVE);
    }
    
    
    

    @Override
    public boolean add(ArrayList<Reject_receiveDTO> dtoList) throws Exception {

        return rejRecBO.add(dtoList);
    }

    
    
}
