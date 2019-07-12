/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom;

import lk.edu.ijse.sas.controller.SuperController;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import com.sas.kem.edu.ijse.dto.Reject_orderDTO;
import com.sas.kem.edu.ijse.dto.Reject_order_detailDTO;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author dimuthu
 */
public interface ProductController extends SuperController<ProductDTO> {
    
    public String getProid(String proName) throws Exception;
    
    public boolean addProductions(ArrayList<ProductDTO> plist,ArrayList<Batch_addDTO> blist) throws Exception;
    
    public ObservableList<String> getProNames(String proName) throws Exception;
    
    public String getProName(String proid) throws Exception;
    
    public boolean updateAsIncreased(ArrayList<ProductDTO> dtoList,ArrayList<Batch_addDTO> batchlist,ArrayList<Reject_order_detailDTO> rejOrderlist,Reject_orderDTO rDto) throws Exception;
    
    public boolean updateAsIncreased(ArrayList<ProductDTO> dtoList) throws Exception;
    
    public boolean update(String rename,String product) throws Exception;
    
    public boolean remove(String id) throws Exception;
    
}
