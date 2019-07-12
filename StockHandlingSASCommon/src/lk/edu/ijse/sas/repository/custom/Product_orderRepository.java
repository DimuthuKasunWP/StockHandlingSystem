/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.entity.Product_Order;
import lk.edu.ijse.sas.repository.SuperRepository;

/**
 *
 * @author dimuthu
 */
public interface Product_orderRepository extends SuperRepository<Product_Order>{
    
    public boolean delete(String oid) throws Exception;

    @Override
    public default boolean add(Product_Order dto) throws Exception {return true;}

    @Override
    public default void update(ArrayList<Product_Order> dtoList) throws Exception {}
    
    
}
