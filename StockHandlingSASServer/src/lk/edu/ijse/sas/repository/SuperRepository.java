/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository;

import lk.edu.ijse.sas.business.*;
import java.util.ArrayList;
import java.util.List;
import lk.edu.ijse.sas.dto.SuperDTO;
import org.hibernate.Session;

/**
 *
 * @author dimuthu
 */
public interface SuperRepository <T>{
    public List<T> getAll() throws Exception;
    
    public boolean add(ArrayList<T> dtoList) throws Exception;
    
    public void update(ArrayList<T> dtoList) throws Exception;
    
    public boolean add(T dto)throws Exception;
    
    public void setSession(Session session)throws Exception;
    
    public T getSpecific(String id) throws Exception;
}
