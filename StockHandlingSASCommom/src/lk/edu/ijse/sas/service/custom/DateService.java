/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.dto.DateDTO;
import lk.edu.ijse.sas.service.SuperService;

/**
 *
 * @author dimuthu
 */
public interface DateService extends SuperService<DateDTO>{

    @Override
    public default ArrayList<DateDTO> getAll() throws Exception {return null;}
    
    public DateDTO getDateDetail() throws Exception;

    @Override
    public default boolean add(ArrayList<DateDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<DateDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean add(DateDTO dto) throws Exception {return true;}
    
    
    
}
