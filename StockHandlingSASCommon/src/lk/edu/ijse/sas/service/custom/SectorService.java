/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.dto.SectorDTO;
import lk.edu.ijse.sas.service.SuperService;

/**
 *
 * @author dimuthu
 */
public interface SectorService extends SuperService<SectorDTO>{

    @Override
    public default boolean add(ArrayList<SectorDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<SectorDTO> dtoList) throws Exception {return true;}
    
    public boolean remove(String id) throws Exception;
    
    public boolean rename(String rename,String curName) throws Exception;
    
    public boolean add(String secName) throws Exception;

    @Override
    public default boolean add(SectorDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
