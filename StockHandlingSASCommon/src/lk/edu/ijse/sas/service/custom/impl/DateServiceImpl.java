/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;


import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.DateBO;
import lk.edu.ijse.sas.dto.DateDTO;
import lk.edu.ijse.sas.service.custom.DateService;

/**
 *
 * @author dimuthu
 */
public class DateServiceImpl implements DateService{
    
    private DateBO dateBO;

    public DateServiceImpl() {
        
        dateBO=(DateBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.DATE);
    }
    
    
    @Override
    public DateDTO getDateDetail() throws Exception {
        
        return dateBO.getDateDetail();
    }
    
}
