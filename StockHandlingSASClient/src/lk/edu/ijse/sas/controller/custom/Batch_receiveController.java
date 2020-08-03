/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom;

import lk.edu.ijse.sas.controller.SuperController;
import com.sas.kem.edu.ijse.dto.Batch_receiveDTO;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import com.sas.kem.edu.ijse.dto.Remove_receive_materialDTO;
import com.sas.kem.edu.ijse.dto.Remove_return_materialDTO;
import com.sas.kem.edu.ijse.dto.Return_batch_receiveDTO;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public interface Batch_receiveController extends SuperController<Batch_receiveDTO>{

    @Override
    public default boolean update(ArrayList<Batch_receiveDTO> dtoList) throws Exception {return true;}
    
    public boolean update_receive_batch(ArrayList<Batch_receiveDTO>recList,ArrayList<Return_batch_receiveDTO> retList,ArrayList<MaterialDTO> matList,ArrayList<Remove_receive_materialDTO> remRecList,ArrayList<Remove_return_materialDTO> remRetList) throws Exception;
    
}
