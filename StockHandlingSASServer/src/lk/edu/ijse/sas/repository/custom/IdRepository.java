/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.dto.SuperDTO;
import lk.edu.ijse.sas.repository.SuperRepository;

/**
 *
 * @author dimuthu
 */
public interface IdRepository extends SuperRepository<SuperDTO>{

    @Override
    public default boolean add(ArrayList<SuperDTO> dtoList) throws Exception {return true;}

    @Override
    public default ArrayList<SuperDTO> getAll() throws Exception {return null;}

    @Override
    public default void update(ArrayList<SuperDTO> dtoList) throws Exception {}
    
    public String getNewId(String tblName,String colName) throws Exception;

    @Override
    public default boolean add(SuperDTO dto) throws Exception {return true;}

    @Override
    public default SuperDTO getSpecific(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
