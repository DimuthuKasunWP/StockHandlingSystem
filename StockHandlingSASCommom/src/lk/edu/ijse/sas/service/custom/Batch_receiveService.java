/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.dto.Batch_receiveDTO;
import lk.edu.ijse.sas.dto.MaterialDTO;
import lk.edu.ijse.sas.dto.Remove_receive_materialDTO;
import lk.edu.ijse.sas.dto.Remove_return_materialDTO;
import lk.edu.ijse.sas.dto.Return_batch_receiveDTO;
import lk.edu.ijse.sas.service.SuperService;

/**
 *
 * @author dimuthu
 */
public interface Batch_receiveService extends SuperService<Batch_receiveDTO>{

    @Override
    public default boolean update(ArrayList<Batch_receiveDTO> dtoList) throws Exception {return true;}
    
    public boolean update_receive_batch(ArrayList<Batch_receiveDTO>recList,ArrayList<Return_batch_receiveDTO> retList,ArrayList<MaterialDTO> matList,ArrayList<Remove_receive_materialDTO> remRecList,ArrayList<Remove_return_materialDTO> remRetList) throws Exception;

    @Override
    public default boolean add(Batch_receiveDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
