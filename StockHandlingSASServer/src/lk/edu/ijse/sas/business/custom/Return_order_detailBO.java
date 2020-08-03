/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom;

import java.util.ArrayList;
import lk.edu.ijse.sas.business.SuperBO;
import lk.edu.ijse.sas.dto.Return_order_detailDTO;

/**
 *
 * @author dimuthu
 */
public interface Return_order_detailBO extends SuperBO<Return_order_detailDTO>{
    @Override
    public default boolean add(Return_order_detailDTO dto) throws Exception {return true;}

    @Override
    public default ArrayList<Return_order_detailDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default boolean update(ArrayList<Return_order_detailDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
