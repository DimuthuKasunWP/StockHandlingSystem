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
import lk.edu.ijse.sas.entity.Batch_Recieve;
import lk.edu.ijse.sas.repository.custom.Batch_receiveRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dimuthu
 */
public class Batch_receiveRepositoryImpl implements Batch_receiveRepository{
    
    private Session session;

    
    
    @Override
    public List<Batch_Recieve> getAll() throws Exception {
        List<Batch_Recieve> list = session.createCriteria(Batch_Recieve.class).list();
        return list;
//        String sql="Select * from batch_receive";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        ArrayList<Batch_receiveDTO> blist=new ArrayList<>();
//        
//        while(rst.next()){
//            Batch_receiveDTO b=new Batch_receiveDTO(rst.getString("brid"),rst.getString("grid"),rst.getString("mid"),rst.getString("manufacture_date"),rst.getString("expire_date"),rst.getBigDecimal("received_qty_kg"),rst.getBigDecimal("current_qty_kg"),rst.getBigDecimal("unit_price_1kg"),rst.getBigDecimal("total"));
//            blist.add(b);
//        }
//        return blist;
    }

    @Override
    public boolean add(ArrayList<Batch_Recieve> dtoList) throws Exception {
        Serializable save=null;
        for (Batch_Recieve batch_Recieve : dtoList) {
            save=session.save(batch_Recieve);
        }
        return save!=null;
//        int res=0;
//        
//        for (Batch_receiveDTO batch_receiveDTO : dtoList) {
//            
//            String sql="insert into batch_receive values(?,?,?,?,?,?,?,?,?)";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(1, batch_receiveDTO.getBrid());
//            stm.setObject(2, batch_receiveDTO.getGrid());
//            stm.setObject(3, batch_receiveDTO.getMid());
//            stm.setObject(4, batch_receiveDTO.getMfd());
//            stm.setObject(5, batch_receiveDTO.getExp());
//            stm.setObject(6, batch_receiveDTO.getReceived_qty_kg());
//            stm.setObject(7, batch_receiveDTO.getCurrent_qty_kg());
//            stm.setObject(8, batch_receiveDTO.getUnitPrice_1kg());
//            stm.setObject(9, batch_receiveDTO.getTotal());
//            res+=stm.executeUpdate();
//            
//        }
//        if(res==dtoList.size()){
//            System.out.println("1");
//            return true;
//
//        }
//        System.out.println("2");
//        return false;
    }

    @Override
    public void update(ArrayList<Batch_Recieve> dtoList) throws Exception {
        for (Batch_Recieve batch_Recieve : dtoList) {
            session.update(batch_Recieve);
        }
//        int res=0;
//        for (Batch_receiveDTO batch_receiveDTO : dtoList) {
//            
//            String sql="update batch_receive set current_qty_kg=? where brid=?";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(1, batch_receiveDTO.getCurrent_qty_kg());
//            stm.setObject(2, batch_receiveDTO.getBrid());
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
    public Batch_Recieve getSpecific(String id) throws Exception {
        return new Batch_Recieve();
    }

   

}
