/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;


import java.util.ArrayList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.Purchase_orderBO;
import lk.edu.ijse.sas.dto.Purchase_orderDTO;
import lk.edu.ijse.sas.service.custom.Purchase_orderService;

/**
 *
 * @author dimuthu
 */
public class Purchase_orderServiceImpl implements Purchase_orderService{
    
    private Purchase_orderBO purchaseOrderBO;

    public Purchase_orderServiceImpl() {
        purchaseOrderBO=(Purchase_orderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PURCHASE_ORDER);
    }
    
    

    @Override
    public ArrayList<Purchase_orderDTO> getAll() throws Exception {
        
        return purchaseOrderBO.getAll();
    }

    
}
