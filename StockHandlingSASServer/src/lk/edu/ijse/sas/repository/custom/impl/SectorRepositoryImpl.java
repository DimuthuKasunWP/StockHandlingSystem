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
import lk.edu.ijse.sas.entity.Sector;
import lk.edu.ijse.sas.repository.custom.SectorRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author dimuthu
 */
public class SectorRepositoryImpl implements SectorRepository{
    
    private Session session;
    
    
    @Override
    public List<Sector> getAll() throws Exception {
        List<Sector> list = session.createCriteria(Sector.class).list();
        return list;
//        String sql="select * from sector";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        ArrayList<SectorDTO> list=new ArrayList<>();
//        while(rst.next()){
//            SectorDTO sd=new SectorDTO(rst.getString("sec_name"));
//            list.add(sd);
//        }
//        return list;
    }

    @Override
    public boolean add(Sector dto) throws Exception {
        Serializable save = session.save(dto);
        return save!=null;
//        String sql="insert into sector values(?)";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, dto.getSecName());
//        int res=stm.executeUpdate();
//        if(res>0){
//            return true;
//        }
//        return false;
    }

    @Override
    public boolean remove(String id) throws Exception {
        Query createQuery = session.createQuery("delete from sector where sec_name=:name");
        createQuery.setParameter("name", id); 
        return createQuery.executeUpdate()>0;
//        String sql="delete from sector where sec_name=?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, id);
//        int res=stm.executeUpdate();
//        if(res>0){
//            return true;
//        }
//        return false;
    }

    @Override
    public void rename(String rename, String curName) throws Exception {
        Query createQuery = session.createQuery("update sector set sec_name=:rename where sec_name=:name");
        createQuery.setParameter("rename", rename);
        createQuery.setParameter("name", curName);
        createQuery.executeUpdate();
//        String sql="update sector set sec_name=? where sec_name=?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, rename);
//        stm.setObject(2, curName);
//        int res=stm.executeUpdate();
//        if(res>0){
//            return true;
//        }
//        return false;
    }

    @Override
    public boolean add(String secName) throws Exception {
        Serializable save = session.save(new Sector(secName));
        return save!=null;
//        String sql="insert into sector values(?)";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, secName);
//        int res=stm.executeUpdate();
//        if(res>0){
//            return true;
//        }
//        return false;
    }

    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }

    @Override
    public Sector getSpecific(String id) throws Exception {
        return (Sector) session.createCriteria(Sector.class).add(Restrictions.eq("sec_name", id)).list().get(0);
    }
    
}
