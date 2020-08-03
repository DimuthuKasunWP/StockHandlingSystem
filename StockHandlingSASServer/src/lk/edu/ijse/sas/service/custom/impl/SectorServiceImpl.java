/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;



import java.util.ArrayList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.SectorBO;
import lk.edu.ijse.sas.dto.SectorDTO;
import lk.edu.ijse.sas.service.custom.SectorService;

/**
 *
 * @author dimuthu
 */
public class SectorServiceImpl implements SectorService{

    private SectorBO secBO;

    public SectorServiceImpl() {
        
        secBO=(SectorBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SECTOR);
    }
    
    
    @Override
    public ArrayList<SectorDTO> getAll() throws Exception {

        return secBO.getAll();
    }

    

    @Override
    public boolean remove(String id) throws Exception {
        
        return secBO.remove(id);
    }

    @Override
    public boolean rename(String rename, String curName) throws Exception {

        return secBO.rename(rename, curName);
    }

    @Override
    public boolean add(String secName) throws Exception {

        return secBO.add(secName);
    }
    
}
