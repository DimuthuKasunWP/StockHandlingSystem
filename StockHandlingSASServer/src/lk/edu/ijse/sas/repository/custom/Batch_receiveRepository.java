/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom;

import java.util.ArrayList;
import lk.edu.ijse.sas.dto.Batch_receiveDTO;
import lk.edu.ijse.sas.entity.Batch_Recieve;
import lk.edu.ijse.sas.repository.SuperRepository;



/**
 *
 * @author dimuthu
 */
public interface Batch_receiveRepository extends SuperRepository<Batch_Recieve>{

    @Override
    public default boolean add(Batch_Recieve dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default void update(ArrayList<Batch_Recieve> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

 
    
}
