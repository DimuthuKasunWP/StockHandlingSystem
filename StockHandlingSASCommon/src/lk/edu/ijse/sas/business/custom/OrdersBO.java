/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.business.SuperBO;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.dto.OrdersDTO;
import lk.edu.ijse.sas.dto.ProductDTO;
import lk.edu.ijse.sas.dto.Product_orderDTO;
import lk.edu.ijse.sas.service.SuperService;

/**
 *
 * @author dimuthu
 */
public interface OrdersBO extends SuperBO<OrdersDTO>{

    @Override
    public default boolean add(ArrayList<OrdersDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<OrdersDTO> dtoList) throws Exception {return true;}
    
    public boolean add(OrdersDTO dto, ArrayList<ProductDTO> prolist,ArrayList<Product_orderDTO> plist,ArrayList<Batch_addDTO> blist) throws Exception;
    
    public boolean update(OrdersDTO dto, ArrayList<ProductDTO> prolist,ArrayList<Product_orderDTO> plist,ArrayList<Batch_addDTO> blist) throws Exception;

    @Override
    public default boolean add(OrdersDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
