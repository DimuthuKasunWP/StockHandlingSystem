/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.dto.Batch_receiveDTO;
import lk.edu.ijse.sas.dto.GrnDTO;
import lk.edu.ijse.sas.dto.MaterialDTO;
import lk.edu.ijse.sas.dto.Return_batch_receiveDTO;
import lk.edu.ijse.sas.service.SuperService;

/**
 *
 * @author dimuthu
 */
public interface GrnService extends SuperService<GrnDTO>{

    @Override
    public default boolean add(ArrayList<GrnDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<GrnDTO> dtoList) throws Exception {return true;}
    
    public boolean add(GrnDTO grn,ArrayList<MaterialDTO> mlist,ArrayList<Batch_receiveDTO> blist) throws Exception;
    
    public boolean update(GrnDTO grn,ArrayList<MaterialDTO> mlist,ArrayList<Return_batch_receiveDTO> blist) throws Exception;

    @Override
    public default boolean add(GrnDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
