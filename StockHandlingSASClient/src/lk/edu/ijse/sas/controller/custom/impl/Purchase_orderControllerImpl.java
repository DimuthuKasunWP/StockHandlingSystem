/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.Purchase_orderController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.Purchase_orderDAO;
import com.sas.kem.edu.ijse.dto.Purchase_orderDTO;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class Purchase_orderControllerImpl implements Purchase_orderController{
    
    private Purchase_orderDAO purchaseOrderDAO;

    public Purchase_orderControllerImpl() {
        purchaseOrderDAO=(Purchase_orderDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.PURCHASE_ORDER);
    }
    
    

    @Override
    public ArrayList<Purchase_orderDTO> getAll() throws Exception {
        
        return purchaseOrderDAO.getAll();
    }

    @Override
    public boolean add(Purchase_orderDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
