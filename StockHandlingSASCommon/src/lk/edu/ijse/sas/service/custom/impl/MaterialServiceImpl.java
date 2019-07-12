/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.MaterialBO;
import lk.edu.ijse.sas.dto.Batch_receiveDTO;
import lk.edu.ijse.sas.dto.MaterialDTO;
import lk.edu.ijse.sas.dto.Reject_receiveDTO;
import lk.edu.ijse.sas.dto.Reject_return_receiveDTO;
import lk.edu.ijse.sas.dto.Return_batch_receiveDTO;
import lk.edu.ijse.sas.service.custom.MaterialService;

/**
 *
 * @author dimuthu
 */
public class MaterialServiceImpl implements MaterialService{
    
    private MaterialBO matBO;
    
    
    private Connection conn;
    
    public MaterialServiceImpl() {
        
        
        matBO=(MaterialBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.MATERIAL);
    }
    

    @Override
    public ArrayList<MaterialDTO> getAll() throws Exception {
        
        return matBO.getAll();
    }

    @Override
    public String getMaterialId(String matName) throws Exception {
        
        return matBO.getMaterialId(matName);
        
    }


    @Override
    public boolean update(ArrayList<MaterialDTO> dtoList) throws Exception {
        
        return matBO.update(dtoList);
    }

    @Override
    public ObservableList<String> getMatNames(String matName) throws Exception {
        return matBO.getMatNames(matName);
    }

    @Override
    public String getMatName(String mid) throws Exception {
        
        return matBO.getMatName(mid);
    }

    @Override
    public boolean add(MaterialDTO dto) throws Exception {

        return matBO.add(dto);
    }

    @Override
    public boolean updateAsReduce(ArrayList<MaterialDTO> matlist) throws Exception {

        return matBO.updateAsReduce(matlist);
    }

    @Override
    public boolean updateAsReduce(ArrayList<MaterialDTO> matlist, ArrayList<Return_batch_receiveDTO> retList, ArrayList<Batch_receiveDTO> recList, ArrayList<Reject_receiveDTO> rejRecList, ArrayList<Reject_return_receiveDTO> rejRetList) throws Exception {

        return matBO.updateAsReduce(matlist, retList, recList, rejRecList, rejRetList);
    }

    @Override
    public boolean updateMatName(String rename, String matName) throws Exception {

        return matBO.updateMatName(rename, matName);
    }

    @Override
    public boolean remove(String id) throws Exception {

        return matBO.remove(id);
    }
    
}
