/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;



import java.sql.SQLException;
import java.util.ArrayList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.OrdersBO;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.dto.OrdersDTO;
import lk.edu.ijse.sas.dto.ProductDTO;
import lk.edu.ijse.sas.dto.Product_orderDTO;
import lk.edu.ijse.sas.service.custom.OrdersService;

/**
 *
 * @author dimuthu
 */
public class OrdersServiceImpl implements OrdersService{
    
    
    
    private OrdersBO ordersBO;
    

    public OrdersServiceImpl() {
        
        
        ordersBO=(OrdersBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDERS);
        
        
    }

    @Override
    public ArrayList<OrdersDTO> getAll() throws Exception {

        return ordersBO.getAll();
    }

    @Override
    public boolean add(OrdersDTO dto, ArrayList<ProductDTO> prolist,ArrayList<Product_orderDTO> plist,ArrayList<Batch_addDTO> blist) throws Exception {
        
        return ordersBO.add(dto, prolist, plist, blist);
    }

    

    @Override
    public boolean update(OrdersDTO dto, ArrayList<ProductDTO> prolist, ArrayList<Product_orderDTO> plist, ArrayList<Batch_addDTO> blist) throws Exception {

        return ordersBO.update(dto, prolist, plist, blist);
    }
    
}
