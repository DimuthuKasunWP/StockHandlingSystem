/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom;

import java.util.ArrayList;
import java.util.List;
import lk.edu.ijse.sas.entity.Reject_Return_Recieve;
import lk.edu.ijse.sas.repository.SuperRepository;



/**
 *
 * @author dimuthu
 */
public interface Reject_return_receiveRepository extends SuperRepository<Reject_Return_Recieve>{

    @Override
    public default void update(ArrayList<Reject_Return_Recieve> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default boolean add(Reject_Return_Recieve dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default List<Reject_Return_Recieve> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
