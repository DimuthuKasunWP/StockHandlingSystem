/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;



import java.sql.SQLException;
import java.util.ArrayList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.Return_orderBO;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.dto.ProductDTO;
import lk.edu.ijse.sas.dto.Return_orderDTO;
import lk.edu.ijse.sas.dto.Return_order_detailDTO;
import lk.edu.ijse.sas.service.custom.Return_orderService;

/**
 *
 * @author dimuthu
 */
public class Return_orderServiceImpl implements Return_orderService{
    
    
    
    private Return_orderBO retOrderBO;
    

    public Return_orderServiceImpl() {
      
        retOrderBO=(Return_orderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RETURN_ORDER);
        
    }
    
    

    

    @Override
    public boolean add(Return_orderDTO ret, ArrayList<Return_order_detailDTO> rlist, ArrayList<Batch_addDTO> blist, ArrayList<ProductDTO> prolist) throws Exception {

        return retOrderBO.add(ret, rlist, blist, prolist);
    }
    
}
