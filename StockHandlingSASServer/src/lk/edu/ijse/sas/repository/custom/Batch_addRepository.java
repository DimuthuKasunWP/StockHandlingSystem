/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.entity.Batch_Add;
import lk.edu.ijse.sas.repository.SuperRepository;

/**
 *
 * @author dimuthu
 */
public interface Batch_addRepository extends SuperRepository<Batch_Add>{

  

    @Override
    public default boolean add(Batch_Add dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    public void updateAsIncreased(ArrayList<Batch_addDTO> dtoList) throws Exception;
    
    public String getProId(String baid) throws Exception;
    
}
