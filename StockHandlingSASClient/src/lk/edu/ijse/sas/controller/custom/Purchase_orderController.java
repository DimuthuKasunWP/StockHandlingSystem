/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom;

import lk.edu.ijse.sas.controller.SuperController;
import com.sas.kem.edu.ijse.dto.Purchase_orderDTO;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public interface Purchase_orderController extends SuperController<Purchase_orderDTO> {

    @Override
    public default boolean add(ArrayList<Purchase_orderDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<Purchase_orderDTO> dtoList) throws Exception {return true;}
    
    
    
}
