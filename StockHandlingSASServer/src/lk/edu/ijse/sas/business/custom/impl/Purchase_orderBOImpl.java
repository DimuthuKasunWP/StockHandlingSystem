/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;

import lk.edu.ijse.sas.service.custom.impl.*;

import java.util.ArrayList;
import lk.edu.ijse.sas.business.custom.Purchase_orderBO;
import lk.edu.ijse.sas.dto.Purchase_orderDTO;

/**
 *
 * @author dimuthu
 */
public class Purchase_orderBOImpl implements Purchase_orderBO{
    
    private Purchase_orderDAO purchaseOrderDAO;

    public Purchase_orderBOImpl() {
        purchaseOrderDAO=(Purchase_orderDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.PURCHASE_ORDER);
    }
    
    

    @Override
    public ArrayList<Purchase_orderDTO> getAll() throws Exception {
        
        return purchaseOrderDAO.getAll();
    }

    
}
