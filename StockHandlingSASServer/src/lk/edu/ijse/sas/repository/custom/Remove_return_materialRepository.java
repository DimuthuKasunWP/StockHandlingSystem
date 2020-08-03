/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom;

import java.util.ArrayList;
import lk.edu.ijse.sas.entity.Remove_Return_Material;
import lk.edu.ijse.sas.repository.SuperRepository;



/**
 *
 * @author dimuthu
 */
public interface Remove_return_materialRepository extends SuperRepository<Remove_Return_Material>{

    @Override
    public default void update(ArrayList<Remove_Return_Material> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default boolean add(Remove_Return_Material dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
