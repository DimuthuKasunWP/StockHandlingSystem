/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom;

import java.util.ArrayList;
import lk.edu.ijse.sas.business.SuperBO;
import lk.edu.ijse.sas.dto.Return_batch_receiveDTO;
import lk.edu.ijse.sas.service.SuperService;



/**
 *
 * @author dimuthu
 */
public interface Return_batch_receiveBO extends SuperBO<Return_batch_receiveDTO>{

    @Override
    public default boolean add(ArrayList<Return_batch_receiveDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default boolean update(ArrayList<Return_batch_receiveDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default boolean add(Return_batch_receiveDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
