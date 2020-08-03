/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom;

import lk.edu.ijse.sas.controller.SuperController;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import com.sas.kem.edu.ijse.dto.OrdersDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import com.sas.kem.edu.ijse.dto.Product_orderDTO;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public interface OrdersController extends SuperController<OrdersDTO>{

    @Override
    public default boolean add(ArrayList<OrdersDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<OrdersDTO> dtoList) throws Exception {return true;}
    
    public boolean add(OrdersDTO dto, ArrayList<ProductDTO> prolist,ArrayList<Product_orderDTO> plist,ArrayList<Batch_addDTO> blist) throws Exception;
    
    public boolean update(OrdersDTO dto, ArrayList<ProductDTO> prolist,ArrayList<Product_orderDTO> plist,ArrayList<Batch_addDTO> blist) throws Exception;
}
