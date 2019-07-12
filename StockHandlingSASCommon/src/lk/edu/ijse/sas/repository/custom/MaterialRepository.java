/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom;


import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.edu.ijse.sas.entity.Material;
import lk.edu.ijse.sas.repository.SuperRepository;

/**
 *
 * @author dimuthu
 */
public interface MaterialRepository extends SuperRepository<Material>{
    
    public String getMaterialId(String matName) throws Exception;

    @Override
    public default boolean add(ArrayList<Material> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
        public ObservableList<String> getMatNames(String matName) throws Exception;
        
        public String getMatName(String mid) throws Exception;
      
        public void updateAsReduce(ArrayList<Material> matlist) throws Exception;
        
        public boolean updateMatName(String rename,String matName) throws Exception;
        
        public boolean remove(String id) throws Exception;
        
}
