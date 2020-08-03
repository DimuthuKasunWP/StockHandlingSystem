/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom;

import java.util.ArrayList;
import java.util.List;
import lk.edu.ijse.sas.entity.Return_Order_Detail;
import lk.edu.ijse.sas.repository.SuperRepository;



/**
 *
 * @author dimuthu
 */
public interface Return_order_detailRepository extends SuperRepository<Return_Order_Detail>{

    @Override
    public default boolean add(Return_Order_Detail dto) throws Exception {return true;}

    @Override
    public default void update(ArrayList<Return_Order_Detail> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default List<Return_Order_Detail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
