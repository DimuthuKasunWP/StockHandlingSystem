/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;

import lk.edu.ijse.sas.service.custom.impl.*;

import java.util.ArrayList;
import lk.edu.ijse.sas.business.custom.Reject_receiveBO;
import lk.edu.ijse.sas.dto.Reject_receiveDTO;

/**
 *
 * @author dimuthu
 */
public class Reject_receiveBOImpl implements Reject_receiveBO{

    private Reject_receiveDAO rejRecDAO;

    public Reject_receiveBOImpl() {
        rejRecDAO=(Reject_receiveDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.REJECT_RECEIVE);
    }
    
    
    

    @Override
    public boolean add(ArrayList<Reject_receiveDTO> dtoList) throws Exception {

        return rejRecDAO.add(dtoList);
    }


    
}
