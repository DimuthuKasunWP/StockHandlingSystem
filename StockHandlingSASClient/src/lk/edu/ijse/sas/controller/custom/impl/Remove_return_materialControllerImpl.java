/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.Remove_return_materialController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.Remove_return_materialDAO;
import com.sas.kem.edu.ijse.dto.Remove_return_materialDTO;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public class Remove_return_materialControllerImpl implements Remove_return_materialController{

    private Remove_return_materialDAO matDAO;

    public Remove_return_materialControllerImpl() {
        matDAO=(Remove_return_materialDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.REMOVE_RETURN_MATERIAL);
    }
    
    
    @Override
    public ArrayList<Remove_return_materialDTO> getAll() throws Exception {
        
        return matDAO.getAll();
    }

    @Override
    public boolean add(ArrayList<Remove_return_materialDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ArrayList<Remove_return_materialDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Remove_return_materialDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
