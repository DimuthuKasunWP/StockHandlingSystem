/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom;

import lk.edu.ijse.sas.controller.SuperController;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import com.sas.kem.edu.ijse.dto.Product_orderDTO;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public interface Product_orderController extends SuperController<Product_orderDTO>{
    
    public boolean delete(String oid) throws Exception;

    @Override
    public default boolean add(Product_orderDTO dto) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<Product_orderDTO> dtoList) throws Exception {return true;}
    
    public boolean update(String oid,ArrayList<ProductDTO> prolist,ArrayList<Batch_addDTO> blist) throws Exception;
}
