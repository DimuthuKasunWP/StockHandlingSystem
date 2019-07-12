/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;




import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.edu.ijse.sas.business.custom.Return_order_detailBO;
import lk.edu.ijse.sas.dto.Return_order_detailDTO;


/**
 *
 * @author Vidura
 */
public class Return_order_detailBOImpl implements Return_order_detailBO{
    
   
    
    

    

    @Override
    public boolean add(ArrayList<Return_order_detailDTO> dtoList) throws Exception {

        int res=0;
        for (Return_order_detailDTO return_order_detailDTO : dtoList) {
            String sql="insert into return_order_detail values(?,?,?,?)";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, return_order_detailDTO.getRnid());
            stm.setObject(2, return_order_detailDTO.getBaid());
            stm.setObject(3, return_order_detailDTO.getOid());
            stm.setObject(4, return_order_detailDTO.getQty());
            res+=stm.executeUpdate();
            
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
    }

    

    
}
