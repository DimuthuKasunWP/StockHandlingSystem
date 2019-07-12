/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.dto.ProductDTO;
import lk.edu.ijse.sas.dto.Return_orderDTO;
import lk.edu.ijse.sas.dto.Return_order_detailDTO;
import lk.edu.ijse.sas.service.SuperService;

/**
 *
 * @author dimuthu
 */
public interface Return_orderService extends SuperService<Return_orderDTO>{

    @Override
    public default boolean add(ArrayList<Return_orderDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<Return_orderDTO> dtoList) throws Exception {return true;}
 
    public boolean add(Return_orderDTO ret,ArrayList<Return_order_detailDTO> rlist,ArrayList<Batch_addDTO> blist,ArrayList<ProductDTO> prolist) throws Exception;

    @Override
    public default ArrayList<Return_orderDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default boolean add(Return_orderDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
