/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom;

import lk.edu.ijse.sas.controller.SuperController;
import com.sas.kem.edu.ijse.dto.Batch_receiveDTO;
import com.sas.kem.edu.ijse.dto.GrnDTO;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import com.sas.kem.edu.ijse.dto.Return_batch_receiveDTO;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public interface GrnController extends SuperController<GrnDTO>{

    @Override
    public default boolean add(ArrayList<GrnDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<GrnDTO> dtoList) throws Exception {return true;}
    
    public boolean add(GrnDTO grn,ArrayList<MaterialDTO> mlist,ArrayList<Batch_receiveDTO> blist) throws Exception;
    
    public boolean update(GrnDTO grn,ArrayList<MaterialDTO> mlist,ArrayList<Return_batch_receiveDTO> blist) throws Exception;
    
    
}
