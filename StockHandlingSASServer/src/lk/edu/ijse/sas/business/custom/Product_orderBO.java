/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.business.SuperBO;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.dto.ProductDTO;
import lk.edu.ijse.sas.dto.Product_orderDTO;
import lk.edu.ijse.sas.service.SuperService;

/**
 *
 * @author dimuthu
 */
public interface Product_orderBO extends SuperBO<Product_orderDTO>{
    
    public boolean delete(String oid) throws Exception;

    @Override
    public default boolean add(Product_orderDTO dto) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<Product_orderDTO> dtoList) throws Exception {return true;}
    
    public boolean update(String oid,ArrayList<ProductDTO> prolist,ArrayList<Batch_addDTO> blist) throws Exception;
}
