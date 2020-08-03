/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom;

import lk.edu.ijse.sas.controller.SuperController;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import com.sas.kem.edu.ijse.dto.Return_orderDTO;
import com.sas.kem.edu.ijse.dto.Return_order_detailDTO;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public interface Return_orderController extends SuperController<Return_orderDTO>{

    @Override
    public default boolean add(ArrayList<Return_orderDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<Return_orderDTO> dtoList) throws Exception {return true;}
 
    public boolean add(Return_orderDTO ret,ArrayList<Return_order_detailDTO> rlist,ArrayList<Batch_addDTO> blist,ArrayList<ProductDTO> prolist) throws Exception;
}
