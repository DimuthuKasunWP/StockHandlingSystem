/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.ProductBO;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.dto.ProductDTO;
import lk.edu.ijse.sas.dto.Reject_orderDTO;
import lk.edu.ijse.sas.dto.Reject_order_detailDTO;
import lk.edu.ijse.sas.service.custom.ProductService;

/**
 *
 * @author dimuthu
 */
public class ProductServiceImpl implements ProductService{
    
    private ProductBO productBO;
    
    
    

    public ProductServiceImpl() {
        
        
        productBO=(ProductBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PRODUCT);
        
        
        
    }
    
    

    @Override
    public ArrayList<ProductDTO> getAll() throws Exception {
        
        return productBO.getAll();
        
    }

    @Override
    public String getProid(String proName) throws Exception {
        
        return productBO.getProid(proName);
        
    }

    @Override
    public boolean addProductions(ArrayList<ProductDTO> plist,ArrayList<Batch_addDTO> blist) throws Exception {
        
        return productBO.addProductions(plist, blist);
    }

   

    @Override
    public boolean update(ArrayList<ProductDTO> dtoList) throws Exception {
        
        return productBO.add(dtoList);
    }

    @Override
    public ObservableList<String> getProNames(String proName) throws Exception {
        
        return productBO.getProNames(proName);
    }

    @Override
    public String getProName(String proid) throws Exception {

        return productBO.getProName(proid);
    }

    @Override
    public boolean add(ProductDTO dto) throws Exception {
        
        return productBO.add(dto);
    }

    @Override
    public boolean updateAsIncreased(ArrayList<ProductDTO> dtoList, ArrayList<Batch_addDTO> batchlist, ArrayList<Reject_order_detailDTO> rejOrderlist, Reject_orderDTO rDto) throws Exception {

        return productBO.updateAsIncreased(dtoList, batchlist, rejOrderlist, rDto);
    }

    @Override
    public boolean update(String rename, String product) throws Exception {

        return productBO.update(rename, product);
    }

    @Override
    public boolean remove(String id) throws Exception {

        return productBO.remove(id);
    }

    @Override
    public boolean updateAsIncreased(ArrayList<ProductDTO> dtoList) throws Exception {

        return productBO.update(dtoList);
    }
    
}
