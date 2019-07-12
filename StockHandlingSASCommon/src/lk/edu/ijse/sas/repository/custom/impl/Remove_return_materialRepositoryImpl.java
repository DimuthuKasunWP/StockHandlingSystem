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
import lk.edu.ijse.sas.entity.Remove_Return_Material;
import lk.edu.ijse.sas.repository.custom.Remove_return_materialRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dimuthu
 */
public class Remove_return_materialRepositoryImpl implements Remove_return_materialRepository{
    
    private Session session;
    
    @Override
    public List<Remove_Return_Material> getAll() throws Exception {
        List<Remove_Return_Material> list = session.createCriteria(Remove_Return_Material.class).list();
        return list;
//        String sql="select * from remove_return_material";
//        Statement stm=conn.createStatement();
//        ResultSet rst =stm.executeQuery(sql);
//        ArrayList<Remove_return_materialDTO> list=new ArrayList<>();
//        while(rst.next()){
//            Remove_return_materialDTO m=new Remove_return_materialDTO(rst.getString("mid"),rst.getString("rbrid"),rst.getBigDecimal("qty_Kg"),rst.getString("remove_date"),rst.getString("remove_time"),rst.getString("carry_sector_name"));
//            list.add(m);
//        }
//        return list;
    }

    @Override
    public boolean add(ArrayList<Remove_Return_Material> dtoList) throws Exception {
        Serializable save=null;
        for (Remove_Return_Material remove_Return_Material : dtoList) {
          save=  session.save(remove_Return_Material);
        }
        return save!=null;
//        int res=0;
//        for (Remove_return_materialDTO remove_return_materialDTO : dtoList) {
//            
//            String sql="insert into remove_return_material values(?,?,?,?,?,?)";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(1, remove_return_materialDTO.getMid());
//            stm.setObject(2, remove_return_materialDTO.getRbrid());
//            stm.setObject(3, remove_return_materialDTO.getQty_kg());
//            stm.setObject(4, remove_return_materialDTO.getRemove_date());
//            stm.setObject(5, remove_return_materialDTO.getRemove_time());
//            stm.setObject(6, remove_return_materialDTO.getCarry_sector_name());
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
    public Remove_Return_Material getSpecific(String id) throws Exception {
       return (Remove_Return_Material) session.createCriteria(Remove_Return_Material.class).add(Restrictions.eq("mid", id)).list().get(0);
    }

    
    
}
