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
public interface ValidationController extends SuperController<SuperDTO>{

    @Override
    public default ArrayList<SuperDTO> getAll() throws Exception {return null;}
    
    public boolean setNumberFormat(String text)throws Exception;
    
    public boolean setIntFormat(String text)throws Exception;
    
    public boolean setDateFormat(String text)throws Exception;
    
    public boolean setStringFormat(Object text)throws Exception;
    
    public boolean setTelNoFormat(String text)throws Exception;
    
    public boolean setEmailFormat(Object text)throws Exception;
    
    @Override
    public default boolean add(SuperDTO dto) throws Exception {return true;}
    
    

    @Override
    public default boolean add(ArrayList<SuperDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<SuperDTO> dtoList) throws Exception {return true;}
    
    
    
}
