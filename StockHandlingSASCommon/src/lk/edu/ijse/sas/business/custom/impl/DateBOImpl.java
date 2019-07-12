/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;

import lk.edu.ijse.sas.service.custom.impl.*;
import lk.edu.ijse.sas.controller.custom.DateController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.DateDAO;
import com.sas.kem.edu.ijse.dto.DateDTO;
import lk.edu.ijse.sas.business.custom.DateBO;

/**
 *
 * @author dimuthu
 */
public class DateBOImpl implements DateBO{
    
    private DateDAO dateDAO;

    public DateBOImpl() {
        
        dateDAO=(DateDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.DATE);
    }
    
    
    @Override
    public DateDTO getDateDetail() throws Exception {
        
        return dateDAO.getDateDetail();
    }
    
}
