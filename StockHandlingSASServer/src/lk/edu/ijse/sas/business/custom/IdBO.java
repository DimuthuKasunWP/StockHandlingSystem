/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.business.SuperBO;
import lk.edu.ijse.sas.dto.SuperDTO;
import lk.edu.ijse.sas.service.SuperService;

/**
 *
 * @author dimuthu
 */
public interface IdBO extends SuperBO<SuperDTO>{

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
