/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom.impl;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.edu.ijse.sas.entity.Reject_Recieve;
import lk.edu.ijse.sas.repository.custom.Reject_receiveRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dimuthu
 */
public class Reject_receiveRepositoryImpl implements Reject_receiveRepository{

    private Session session;
    
    
    

    @Override
    public boolean add(ArrayList<Reject_Recieve> dtoList) throws Exception {
        Serializable save=null;
        for (Reject_Recieve reject_Recieve : dtoList) {
           save= session.save(reject_Recieve);
        }
        return save!=null;
//        int res=0;
//        for (Reject_receiveDTO reject_receiveDTO : dtoList) {
//            String sql="insert into reject_receive values(?,?,?,?)";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(1, reject_receiveDTO.getBrid());
//            stm.setObject(2, reject_receiveDTO.getQty());
//            stm.setObject(3, reject_receiveDTO.getCause());
//            stm.setObject(4, reject_receiveDTO.getRejectDate());
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
    public Reject_Recieve getSpecific(String id) throws Exception {
     return   (Reject_Recieve) session.createCriteria(Reject_Recieve.class).add(Restrictions.eq("brid", id)).list().get(0);
    }

    
}
