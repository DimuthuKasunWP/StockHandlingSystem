/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.business.SuperBO;
import lk.edu.ijse.sas.dto.PasswordDTO;
import lk.edu.ijse.sas.service.SuperService;

/**
 *
 * @author dimuthu
 */
public interface PasswordBO extends SuperBO<PasswordDTO>{

    @Override
    public default boolean add(ArrayList<PasswordDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<PasswordDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean add(PasswordDTO dto) throws Exception {return true;}
    
    public boolean updatePassword(String userName, String password,String lastName) throws Exception ; 
    
    
    
    
}
