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
import lk.edu.ijse.sas.entity.Remove_Recieve_Material;
import lk.edu.ijse.sas.repository.custom.Remove_receive_materialRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dimuthu
 */
public class Remove_receive_materialRepositoryImpl implements Remove_receive_materialRepository{
    
    private Session session;
    
    

    @Override
    public List<Remove_Recieve_Material> getAll() throws Exception {
        List<Remove_Recieve_Material> list = session.createCriteria(Remove_Recieve_Material.class).list();
        return list;
//        String sql="Select * from remove_receive_material";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        ArrayList<Remove_receive_materialDTO> mlist=new ArrayList<>();
//        
//        while(rst.next()){
//            
//            Remove_receive_materialDTO m=new Remove_receive_materialDTO(rst.getString("mid"),rst.getString("brid"),rst.getBigDecimal("qty_Kg"),rst.getString("remove_date"),rst.getString("remove_time"),rst.getString("carry_sector_name"));
//            mlist.add(m);
//        }
//        
//        return mlist;
    }

    @Override
    public boolean add(ArrayList<Remove_Recieve_Material> dtoList) throws Exception {
        Serializable save=null;
        for (Remove_Recieve_Material remove_Recieve_Material : dtoList) {
           save= session.save(remove_Recieve_Material);
        }
        return save!=null;
//        int res=0;
//        for (Remove_receive_materialDTO remove_receive_materialDTO : dtoList) {
//            
//            String sql="insert into remove_receive_material values(?,?,?,?,?,?)";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(1, remove_receive_materialDTO.getMid());
//            stm.setObject(2, remove_receive_materialDTO.getBrid());
//            stm.setObject(3, remove_receive_materialDTO.getQty_kg());
//            stm.setObject(4, remove_receive_materialDTO.getRemove_date());
//            stm.setObject(5, remove_receive_materialDTO.getRemove_time());
//            stm.setObject(6, remove_receive_materialDTO.getCarry_sector_name());
//            
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
    public Remove_Recieve_Material getSpecific(String id) throws Exception {
       return (Remove_Recieve_Material) session.createCriteria(Remove_Recieve_Material.class).add(Restrictions.eq("mid", id)).list().get(0);
    }

    
    
}
