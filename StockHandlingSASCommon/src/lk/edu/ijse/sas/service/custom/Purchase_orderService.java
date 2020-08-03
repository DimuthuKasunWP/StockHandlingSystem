/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.dto.Purchase_orderDTO;
import lk.edu.ijse.sas.service.SuperService;

/**
 *
 * @author dimuthu
 */
public interface Purchase_orderService extends SuperService<Purchase_orderDTO> {

    @Override
    public default boolean add(ArrayList<Purchase_orderDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<Purchase_orderDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean add(Purchase_orderDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
