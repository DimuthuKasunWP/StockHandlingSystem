/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao;

import com.sas.kem.edu.ijse.dto.SuperDTO;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public interface SuperDAO<T extends SuperDTO> {
    
    public ArrayList<T> getAll() throws Exception;
    
    public boolean add(ArrayList<T> dtoList) throws Exception;
    
    public boolean update(ArrayList<T> dtoList) throws Exception;
    
    public boolean add(T dto) throws Exception;
}
