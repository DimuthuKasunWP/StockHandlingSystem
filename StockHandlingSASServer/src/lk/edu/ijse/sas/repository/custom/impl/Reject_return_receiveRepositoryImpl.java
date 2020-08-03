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
import lk.edu.ijse.sas.entity.Reject_Return_Recieve;
import lk.edu.ijse.sas.repository.custom.Reject_return_receiveRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dimuthu
 */
public class Reject_return_receiveRepositoryImpl implements Reject_return_receiveRepository{

    private Session session;
    
    
   

    @Override
    public boolean add(ArrayList<Reject_Return_Recieve> dtoList) throws Exception {
        Serializable save=null; 
        for (Reject_Return_Recieve reject_Return_Recieve : dtoList) {
            save=session.save(reject_Return_Recieve);
        }
        return save!=null;
//        int res=0;
//        for (Reject_return_receiveDTO reject_return_receiveDTO : dtoList) {
//            String sql="insert into reject_return_receive values(?,?,?,?)";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(1, reject_return_receiveDTO.getRbrid());
//            stm.setObject(2, reject_return_receiveDTO.getQty());
//            stm.setObject(3, reject_return_receiveDTO.getCause());
//            stm.setObject(4, reject_return_receiveDTO.getReject_date());
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
    public Reject_Return_Recieve getSpecific(String id) throws Exception {
       return (Reject_Return_Recieve) session.createCriteria(Reject_Return_Recieve.class).add(Restrictions.eq("rbrid", id)).list().get(0);
    }

    
    
}
