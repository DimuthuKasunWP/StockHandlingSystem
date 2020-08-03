/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom;


import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.edu.ijse.sas.entity.Product;
import lk.edu.ijse.sas.repository.SuperRepository;

/**
 *
 * @author dimuthu
 */
public interface ProductRepository extends SuperRepository<Product>{
    
    public String getProid(String proName) throws Exception;
    
    public ObservableList<String> getProNames(String proName) throws Exception;
    
    public String getProName(String proid) throws Exception;
    
    public void updateAsIncreased(ArrayList<Product> dtoList) throws Exception;
    
    public boolean update(String rename,String product) throws Exception;
    
    public boolean remove(String id) throws Exception;

    @Override
    public default boolean add(ArrayList<Product> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
