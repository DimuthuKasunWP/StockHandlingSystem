/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom;

import lk.edu.ijse.sas.controller.SuperController;
import com.sas.kem.edu.ijse.dto.Batch_receiveDTO;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import com.sas.kem.edu.ijse.dto.Reject_receiveDTO;
import com.sas.kem.edu.ijse.dto.Reject_return_receiveDTO;
import com.sas.kem.edu.ijse.dto.Return_batch_receiveDTO;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author dimuthu
 */
public interface MaterialController extends SuperController<MaterialDTO>{
    
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
