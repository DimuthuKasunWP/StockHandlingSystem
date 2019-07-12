/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.Batch_receiveBO;
import lk.edu.ijse.sas.business.custom.GrnBO;
import lk.edu.ijse.sas.business.custom.MaterialBO;
import lk.edu.ijse.sas.business.custom.Return_batch_receiveBO;
import lk.edu.ijse.sas.dto.Batch_receiveDTO;
import lk.edu.ijse.sas.dto.GrnDTO;
import lk.edu.ijse.sas.dto.MaterialDTO;
import lk.edu.ijse.sas.dto.Return_batch_receiveDTO;
import lk.edu.ijse.sas.service.custom.GrnService;

/**
 *
 * @author dimuthu
 */
public class GrnServiceImpl implements GrnService{
    
    private GrnBO grnBO;
    private MaterialBO matBO;
    private Batch_receiveBO batch_receiveBO;
    private Return_batch_receiveBO return_batchBO;
    
    private Connection conn;

    public GrnServiceImpl() {
        
        grnBO=(GrnBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.GRN);
        
    }
    
    
    @Override
    public ArrayList<GrnDTO> getAll() throws Exception {

        return grnBO.getAll();
    }

    @Override
    public boolean add(GrnDTO grn, ArrayList<MaterialDTO> mlist, ArrayList<Batch_receiveDTO> blist) throws Exception {
        
        return grnBO.add(grn, mlist, blist);
        
    }

   

    @Override
    public boolean update(GrnDTO grn, ArrayList<MaterialDTO> mlist, ArrayList<Return_batch_receiveDTO> blist) throws Exception {
        return grnBO.update(grn, mlist, blist);
    }
}
