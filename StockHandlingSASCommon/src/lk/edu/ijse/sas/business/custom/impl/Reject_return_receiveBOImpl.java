/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.edu.ijse.sas.business.custom.Reject_return_receiveBO;
import lk.edu.ijse.sas.dto.Reject_return_receiveDTO;

/**
 *
 * @author Vidura
 */
public class Reject_return_receiveBOImpl implements Reject_return_receiveBO{

    private Connection conn;

    public Reject_return_receiveBOImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    
    

    @Override
    public boolean add(ArrayList<Reject_return_receiveDTO> dtoList) throws Exception {

        int res=0;
        for (Reject_return_receiveDTO reject_return_receiveDTO : dtoList) {
            String sql="insert into reject_return_receive values(?,?,?,?)";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, reject_return_receiveDTO.getRbrid());
            stm.setObject(2, reject_return_receiveDTO.getQty());
            stm.setObject(3, reject_return_receiveDTO.getCause());
            stm.setObject(4, reject_return_receiveDTO.getReject_date());
            res+=stm.executeUpdate();
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
    }

   
    
}
