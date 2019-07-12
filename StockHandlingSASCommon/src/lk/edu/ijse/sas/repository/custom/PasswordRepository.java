/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.entity.Password;
import lk.edu.ijse.sas.repository.SuperRepository;

/**
 *
 * @author dimuthu
 */
public interface PasswordRepository extends SuperRepository<Password>{

    @Override
    public default boolean add(ArrayList<Password> dtoList) throws Exception {return true;}

    @Override
    public default void update(ArrayList<Password> dtoList) throws Exception {}

    @Override
    public default boolean add(Password dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void updatePassword(String userName,String password,String lastName) throws Exception;
    
}
