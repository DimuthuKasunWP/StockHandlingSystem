/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;



import java.sql.SQLException;
import java.util.ArrayList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.Product_orderBO;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.dto.ProductDTO;
import lk.edu.ijse.sas.dto.Product_orderDTO;
import lk.edu.ijse.sas.service.custom.Product_orderService;

/**
 *
 * @author dimuthu
 */
public class Product_orderServiceImpl implements Product_orderService{
    
    private Product_orderBO proBO;
    

    public Product_orderServiceImpl() {
    
        
        
        proBO=(Product_orderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PRODUCT_ORDER);
        
    }
    
    

    @Override
    public ArrayList<Product_orderDTO> getAll() throws Exception {

        return proBO.getAll();
    }

    @Override
    public boolean add(ArrayList<Product_orderDTO> dtoList) throws Exception {
        
        return proBO.add(dtoList);
    }
    
    @Override
    public boolean delete(String oid) throws Exception {

        return proBO.delete(oid);
    }

    @Override
    public boolean update(String oid, ArrayList<ProductDTO> prolist, ArrayList<Batch_addDTO> blist) throws Exception {
        
        return proBO.update(oid, prolist, blist);
    }
    
}
