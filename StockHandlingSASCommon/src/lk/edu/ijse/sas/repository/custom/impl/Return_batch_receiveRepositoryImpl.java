/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom.impl;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.edu.ijse.sas.entity.Return_Batch_Recieve;
import lk.edu.ijse.sas.repository.custom.Return_batch_receiveRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dimuthu
 */
public class Return_batch_receiveRepositoryImpl implements Return_batch_receiveRepository{

   private Session session;
    
    
    @Override
    public List<Return_Batch_Recieve> getAll() throws Exception {
       List<Return_Batch_Recieve> list = session.createCriteria(Return_Batch_Recieve.class).list();
       return list;
//        String sql="select * from return_batch_receive";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        ArrayList<Return_batch_receiveDTO> list=new ArrayList<>();
//        while(rst.next()){
//            Return_batch_receiveDTO b=new Return_batch_receiveDTO(rst.getString("rbrid"),rst.getString("grid"),rst.getString("mid"),rst.getString("manufacture_date"),rst.getString("expire_date"),rst.getBigDecimal("returned_qty_kg"),rst.getBigDecimal("current_qty_kg"),rst.getBigDecimal("unit_price_1kg"),rst.getBigDecimal("total"));
//            list.add(b);
//        }
//        return list;
    }

    @Override
    public boolean add(ArrayList<Return_Batch_Recieve> dtoList) throws Exception {
        Serializable save=null;
        for (Return_Batch_Recieve return_Batch_Recieve : dtoList) {
            save=session.save(return_Batch_Recieve);
        }
        return save!=null;
//        int res=0;
//        for (Return_batch_receiveDTO return_batch_receiveDTO : dtoList) {
//            String sql="insert into return_batch_receive values(?,?,?,?,?,?,?,?,?)";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(1, return_batch_receiveDTO.getRbrid());
//            stm.setObject(2, return_batch_receiveDTO.getGrid());
//            stm.setObject(3, return_batch_receiveDTO.getMid());
//            stm.setObject(4, return_batch_receiveDTO.getMfd());
//            stm.setObject(5, return_batch_receiveDTO.getExp());
//            stm.setObject(6, return_batch_receiveDTO.getReturned_qty());
//            stm.setObject(7, return_batch_receiveDTO.getCurrent_qty());
//            stm.setObject(8, return_batch_receiveDTO.getUnitPrice());
//            stm.setObject(9, return_batch_receiveDTO.getTotal());
//            
//            res+=stm.executeUpdate();
//        }
//        if(res==dtoList.size()){
//            return true;
//        }
//        return false;
    }

    @Override
    public void update(ArrayList<Return_Batch_Recieve> dtoList) throws Exception {
        for (Return_Batch_Recieve return_Batch_Recieve : dtoList) {
            session.update(return_Batch_Recieve);
        }
//        int res=0;
//        for (Return_batch_receiveDTO return_batch_receiveDTO : dtoList) {
//            
//            String sql="update return_batch_receive set current_qty_kg=? where rbrid=?";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(1, return_batch_receiveDTO.getCurrent_qty());
//            stm.setObject(2, return_batch_receiveDTO.getRbrid());
//            res+=stm.executeUpdate();
//        }
//        if(res==dtoList.size()){
//            return true;
//        }
//        return false;
    }

    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }

    @Override
    public Return_Batch_Recieve getSpecific(String id) throws Exception {
        return (Return_Batch_Recieve) session.createCriteria(Return_Batch_Recieve.class).add(Restrictions.eq("rbrid", id)).list().get(0);
    }

}
