/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom;


import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.dto.ProductDTO;
import lk.edu.ijse.sas.dto.Reject_orderDTO;
import lk.edu.ijse.sas.dto.Reject_order_detailDTO;
import lk.edu.ijse.sas.service.SuperService;

/**
 *
 * @author dimuthu
 */
public interface ProductService extends SuperService<ProductDTO> {
    
    public String getProid(String proName) throws Exception;
    
    public boolean addProductions(ArrayList<ProductDTO> plist,ArrayList<Batch_addDTO> blist) throws Exception;
    
    public ObservableList<String> getProNames(String proName) throws Exception;
    
    public String getProName(String proid) throws Exception;
    
    public boolean updateAsIncreased(ArrayList<ProductDTO> dtoList,ArrayList<Batch_addDTO> batchlist,ArrayList<Reject_order_detailDTO> rejOrderlist,Reject_orderDTO rDto) throws Exception;
    
    public boolean updateAsIncreased(ArrayList<ProductDTO> dtoList) throws Exception;
    
    public boolean update(String rename,String product) throws Exception;
    
    public boolean remove(String id) throws Exception;

    @Override
    public default boolean add(ArrayList<ProductDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
