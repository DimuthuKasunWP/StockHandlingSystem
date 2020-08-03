/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service;

import java.rmi.Remote;
import java.util.ArrayList;
import lk.edu.ijse.sas.dto.SuperDTO;

/**
 *
 * @author dimuthu
 */
public interface SuperService <T extends SuperDTO>extends Remote  {
    public ArrayList<T> getAll() throws Exception;
    
    public boolean add(ArrayList<T> dtoList) throws Exception;
    
    public boolean update(ArrayList<T> dtoList) throws Exception;
    
    public boolean add(T dto)throws Exception;
}
