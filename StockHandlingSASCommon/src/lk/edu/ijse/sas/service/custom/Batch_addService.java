/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom;

import java.util.ArrayList;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.service.SuperService;



/**
 *
 * @author dimuthu
 */
public interface Batch_addService extends SuperService<Batch_addDTO>{
    
   public String getProId(String baid) throws Exception;

    @Override
    public default boolean add(ArrayList<Batch_addDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default boolean update(ArrayList<Batch_addDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default boolean add(Batch_addDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
       
}