/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom;


import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.edu.ijse.sas.dto.Batch_receiveDTO;
import lk.edu.ijse.sas.dto.MaterialDTO;
import lk.edu.ijse.sas.dto.Reject_receiveDTO;
import lk.edu.ijse.sas.dto.Reject_return_receiveDTO;
import lk.edu.ijse.sas.dto.Return_batch_receiveDTO;
import lk.edu.ijse.sas.service.SuperService;

/**
 *
 * @author dimuthu
 */
public interface MaterialService extends SuperService<MaterialDTO>{
    
    public String getMaterialId(String matName) throws Exception;

    @Override
    public default boolean add(ArrayList<MaterialDTO> dtoList) throws Exception {return true;}
    
    public ObservableList<String> getMatNames(String matName) throws Exception;
    
    public String getMatName(String mid) throws Exception;
    
    public boolean updateAsReduce(ArrayList<MaterialDTO> matlist) throws Exception;
    
    public boolean updateAsReduce(ArrayList<MaterialDTO> matlist,ArrayList<Return_batch_receiveDTO> retList,ArrayList<Batch_receiveDTO> recList,ArrayList<Reject_receiveDTO> rejRecList,ArrayList<Reject_return_receiveDTO> rejRetList) throws Exception;
    
    public boolean updateMatName(String rename,String matName) throws Exception;
    
    public boolean remove(String id) throws Exception;
    
}
