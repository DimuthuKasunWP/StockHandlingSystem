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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.edu.ijse.sas.entity.Material;
import lk.edu.ijse.sas.repository.custom.MaterialRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author dimuthu
 */
public class MaterialRepositoryImpl implements MaterialRepository{
    
    private Session session;
    
    
    @Override
    public List<Material> getAll() throws Exception {
        return session.createCriteria(Material.class).list();
//        String sql="Select * from material";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        ArrayList<MaterialDTO> mlist=new ArrayList<>();
//        while(rst.next()){
//            
//            MaterialDTO m=new MaterialDTO(rst.getString("mid"),rst.getString("material_name"),rst.getBigDecimal("amount_kg"));
//            mlist.add(m);
//                    
//        }
//        return mlist;
    }

    @Override
    public String getMaterialId(String matName) throws Exception {
        Criteria add = session.createCriteria(Material.class).add(Restrictions.eq("material_name", matName));
        Material get = (Material) add.list().get(0);
        return get.getMid();
//        String sql="select mid from material where material_name=?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, matName);
//        ResultSet rst=stm.executeQuery();
//        String mid=null;
//        if(rst.next()){
//            mid=rst.getString("mid");
//        }
//        return mid;
        
    }

    
    @Override
    public void update(ArrayList<Material> dtoList) throws Exception {
        for (Material material : dtoList) {
            session.update(material);
        }
//        int res=0;
//        
//        for (MaterialDTO materialDTO : dtoList) {
//            
//            String sql="update material set amount_kg=amount_kg+? where mid=?";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(2, materialDTO.getMid());
//            stm.setObject(1, materialDTO.getAmount_kg());
//            res+=stm.executeUpdate();
//            
//        }
//        if(res==dtoList.size()){
//            return true;
//        }
//        return false;
    }

    @Override
    public ObservableList<String> getMatNames(String matName) throws Exception {
        Query createQuery = session.createQuery("select m.material_name from material m where material_name like :matName");
         createQuery.setParameter("matName", matName+"%");
        ObservableList<String> list=FXCollections.observableArrayList();
        List<String> list1 = createQuery.list();
        for (String object : list1) {
            list.add(object);
        }
        return list;
//        String sql="Select material_name from material where material_name like ?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, matName+'%');
//        ResultSet rst=stm.executeQuery();
//        
//        ObservableList<String> list=FXCollections.observableArrayList();
//        while(rst.next()){
//            String name=rst.getString("material_name");
//            list.add(name);
//        }
//        if(list.size()>0){
//            return list;
//        }
//        return null;
    }

    @Override
    public String getMatName(String mid) throws Exception {
        Query createQuery = session.createQuery("select material_name from material where mid=:mid");
        String get = (String) createQuery.list().get(0);
        return get;
//        String sql="Select material_name from material where mid=?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, mid);
//        ResultSet rst=stm.executeQuery();
//        String name=null;
//        if(rst.next()){
//            name=rst.getString("material_name");
//        }
//        return name;
    }

    @Override
    public boolean add(Material dto) throws Exception {
        Serializable save = session.save(dto);
        return save!=null;
//        int res=0;
//        String sql="insert into material values(?,?,?)";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, dto.getMid());
//        stm.setObject(2,dto.getMaterialName());
//        stm.setObject(3,dto.getAmount_kg());
//        res=stm.executeUpdate();
//        
//        if(res>0){
//            return true;
//        }
//        return false;
    }

    @Override
    public void updateAsReduce(ArrayList<Material> matlist) throws Exception {
        for (Material material : matlist) {
            session.update(material);
        }
//        int res=0;
//        
//        for (MaterialDTO materialDTO : matlist) {
//            
//            String sql="update material set amount_kg=amount_kg-? where mid=?";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(2, materialDTO.getMid());
//            stm.setObject(1, materialDTO.getAmount_kg());
//            res+=stm.executeUpdate();
//            
//        }
//        if(res==matlist.size()){
//            return true;
//        }
//        return false;
    }

    @Override
    public boolean updateMatName(String rename,String matName) throws Exception {
        Query createQuery = session.createQuery("update material set material_name=:matFirst where material_name=:matSecond");
        createQuery.setParameter("matFirst",rename);
        createQuery.setParameter("matSecond", matName);
        return createQuery.executeUpdate()>0;
//        String sql="update material set material_name=? where material_name=?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, rename);
//        stm.setObject(2, matName);
//        int res=stm.executeUpdate();
//        if(res>0){
//            return true;
//        }
//        return false;
    }

    @Override
    public boolean remove(String id) throws Exception {
        Query createQuery = session.createQuery("delete from material where mid=:mid");
        createQuery.setParameter("mid", id);
        return createQuery.executeUpdate()>0;
//        String sql="delete from material where mid=?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, id);
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
    public Material getSpecific(String id) throws Exception {
        Material get = (Material) session.createCriteria(Material.class).add(Restrictions.eq("mid", id)).list().get(0);
        return get;
    }
    
}
