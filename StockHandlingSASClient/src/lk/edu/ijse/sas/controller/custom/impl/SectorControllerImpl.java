/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.SectorController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.SectorDAO;
import com.sas.kem.edu.ijse.dto.SectorDTO;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public class SectorControllerImpl implements SectorController{

    private SectorDAO secDAO;

    public SectorControllerImpl() {
        
        secDAO=(SectorDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.SECTOR);
    }
    
    
    @Override
    public ArrayList<SectorDTO> getAll() throws Exception {

        return secDAO.getAll();
    }

    @Override
    public boolean add(SectorDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(String id) throws Exception {
        
        return secDAO.remove(id);
    }

    @Override
    public boolean rename(String rename, String curName) throws Exception {

        return secDAO.rename(rename, curName);
    }

    @Override
    public boolean add(String secName) throws Exception {

        return secDAO.add(secName);
    }
    
}
