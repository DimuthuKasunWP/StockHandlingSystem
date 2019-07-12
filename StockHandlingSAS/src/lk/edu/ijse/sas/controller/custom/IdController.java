/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom;

import lk.edu.ijse.sas.controller.SuperController;
import com.sas.kem.edu.ijse.dto.SuperDTO;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public interface IdController extends SuperController<SuperDTO>{

    @Override
    public default boolean add(ArrayList<SuperDTO> dtoList) throws Exception {return true;}

    @Override
    public default ArrayList<SuperDTO> getAll() throws Exception {return null;}

    @Override
    public default boolean update(ArrayList<SuperDTO> dtoList) throws Exception {return true;}
    
    public String getNewId(String tblName, String colName, String preFix, int digitCount) throws Exception;
    
    public String getNewId(String lastId, String prefix) throws Exception;

    @Override
    public default boolean add(SuperDTO dto) throws Exception {return true;}
    
    
    
}
