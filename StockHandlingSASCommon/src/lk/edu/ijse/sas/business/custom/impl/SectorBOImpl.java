/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;

import lk.edu.ijse.sas.service.custom.impl.*;

import java.util.ArrayList;
import lk.edu.ijse.sas.business.custom.SectorBO;
import lk.edu.ijse.sas.dto.SectorDTO;

/**
 *
 * @author dimuthu
 */
public class SectorBOImpl implements SectorBO{

    private SectorDAO secDAO;

    public SectorBOImpl() {
        
        secDAO=(SectorDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.SECTOR);
    }
    
    
    @Override
    public ArrayList<SectorDTO> getAll() throws Exception {

        return secDAO.getAll();
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
