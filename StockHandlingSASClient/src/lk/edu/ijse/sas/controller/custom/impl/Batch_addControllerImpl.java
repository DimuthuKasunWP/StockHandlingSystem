/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.Batch_addController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.Batch_addDAO;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class Batch_addControllerImpl implements Batch_addController{
    
    private Batch_addDAO batchDAO;

    public Batch_addControllerImpl() {
        batchDAO=(Batch_addDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.BATCH_ADD);
    }
    
    

    @Override
    public ArrayList<Batch_addDTO> getAll() throws Exception {
        
        return batchDAO.getAll();
    }

    @Override
    public boolean add(ArrayList<Batch_addDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ArrayList<Batch_addDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Batch_addDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getProId(String baid) throws Exception {

        return batchDAO.getProId(baid);
    }

}
