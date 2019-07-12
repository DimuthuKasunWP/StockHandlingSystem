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
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.entity.Batch_Add;
import lk.edu.ijse.sas.repository.custom.Batch_addRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dimuthu
 */
public class Batch_addRepositoryImpl implements Batch_addRepository{
    
   private Session session;

  
    
    

    @Override
    public List<Batch_Add> getAll() throws Exception {
       List<Batch_Add> list = session.createCriteria(Batch_Add.class).list();
       return list;
       
//        String sql="Select * from batch_add";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        ArrayList<Batch_addDTO> blist=new ArrayList<>();Ba
//        while(rst.next()){
//            Batch_Add b=new Batch_Add(rst.getString("baid"),rst.getString("proid"),rst.getString("manufacture_date"),rst.getString("expire_date"),rst.getInt("product_qty"),rst.getInt("current_qty"),rst.getBigDecimal("unit_price"),rst.getString("add_time"),rst.getString("add_date"));
//            blist.add(b);
//        }
//        return blist;
    }


    @Override
    public boolean add(ArrayList<Batch_Add> dtoList) throws Exception {
        Serializable save=null;
        for (Batch_Add batch_Add : dtoList) {
             save = session.save(batch_Add);
        }
        return save!=null;
//        int res=0;
//        for (Batch_Add batch_addDTO : dtoList) {
//            String sql="insert into batch_add values(?,?,?,?,?,?,?,?,?)";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(1, batch_addDTO.getBaid());
//            stm.setObject(2, batch_addDTO.getProid());
//            stm.setObject(3, batch_addDTO.getMfd());
//            stm.setObject(4, batch_addDTO.getExp());
//            stm.setObject(5, batch_addDTO.getProduct_qty());
//            stm.setObject(6, batch_addDTO.getCurrent_qty());
//            stm.setObject(7, batch_addDTO.getUnitPrice());
//            stm.setObject(8, batch_addDTO.getAddTime());
//            stm.setObject(9, batch_addDTO.getAddDate());
//            
//            res+=stm.executeUpdate();
//        }
//        if(res==dtoList.size()){
//            return true;
//        }
//        return false;
        

    }

    @Override
    public void update(ArrayList<Batch_Add> dtoList) throws Exception {
         for (Batch_Add batch_Add : dtoList) {
            session.update(batch_Add);
        }
        
//        int res=0;
//        
//        for (Batch_Add batch_addDTO : dtoList) {
//            
//            String sql="Update batch_add set current_qty=current_qty-? where baid=?";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(2, batch_addDTO.getBaid());
//            stm.setObject(1, batch_addDTO.getCurrent_qty());
//            res+=stm.executeUpdate();
//            
//        }
//        if(res==dtoList.size()){
//            return true;
//        }
//        return false;
    }

    @Override
    public void updateAsIncreased(ArrayList<Batch_addDTO> dtoList) throws Exception {
        for (Batch_addDTO batch_addDTO : dtoList) {
            session.update(batch_addDTO);
        }
//        int res=0;
//        
//        for (Batch_addDTO batch_addDTO : dtoList) {
//            
//            String sql="Update batch_add set current_qty=current_qty+? where baid=?";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(2, batch_addDTO.getBaid());
//            stm.setObject(1, batch_addDTO.getCurrent_qty());
//            res+=stm.executeUpdate();
//            
//        }
//        if(res==dtoList.size()){
//            return true;
//        }
//        return false;
    }

    @Override
    public String getProId(String baid) throws Exception {
       Batch_Add get = (Batch_Add) session.createCriteria(Batch_Add.class).add(Restrictions.eq("baid", baid)).list().get(0);
       return get.getProid().getPrid();
//        String sql="select proid from batch_add where baid=?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, baid);
//        ResultSet rst=stm.executeQuery();
//        String proid=null;
//        if(rst.next()){
//            proid=rst.getString("proid");
//        }
//        return proid;
    }

    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }

    @Override
    public Batch_Add getSpecific(String id) throws Exception {
     Batch_Add get= (Batch_Add) session.createCriteria(Batch_Add.class).add(Restrictions.eq("baid", id)).list().get(0);
     return get;
    }

    


}
