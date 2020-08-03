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
import lk.edu.ijse.sas.entity.Product;
import lk.edu.ijse.sas.repository.custom.ProductRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author dimuthu
 */
public class ProductRepositoryImpl implements ProductRepository {
    
   private Session session;
    
    

    @Override
    public List<Product> getAll() throws Exception {
       List<Product> list = session.createCriteria(Product.class).list();
       return list;
//        String sql="Select * from product";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        ArrayList<ProductDTO> prolist=new ArrayList<>();
//        while(rst.next()){
//            ProductDTO p=new ProductDTO(rst.getString("proid"),rst.getString("product_name"),rst.getBigDecimal("bag_size_kg"),rst.getInt("product_qty_bags"));
//            prolist.add(p);
//        }
//        return prolist;
        
    }

    @Override
    public String getProid(String proName) throws Exception {
       Product get = (Product) session.createCriteria(Product.class).add(Restrictions.eq("product_name", proName)).list().get(0);
       return get.getPrid();
//        String sql="Select proid from product where product_name=?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, proName);
//        ResultSet rst=stm.executeQuery();
//        String proId=null;
//        while(rst.next()){
//            proId=rst.getString("proid");
//        }
//        return proId;   
    }



    @Override
    public void update(ArrayList<Product> dtoList) throws Exception {
        for (Product product : dtoList) {
            session.update(product);
        }
//        int res=0;
//        for (ProductDTO productDTO : dtoList) {
//            
//            String sql="update product set product_qty_bags=product_qty_bags-? where proid=?";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(1, productDTO.getQtyBags());
//            stm.setObject(2, productDTO.getProid());
//            res+=stm.executeUpdate();
//        }
//        if(res==dtoList.size()){
//            return true;
//        }
//        return false;
    }

    @Override
    public ObservableList<String> getProNames(String proName) throws Exception {
       Query createQuery = session.createQuery("select product_name from product where product_name like :name");
       createQuery.setParameter("name", proName+"%");
       List<String> list = createQuery.list();
       ObservableList<String> list1=FXCollections.observableArrayList();
        for (String object : list) {
            list1.add(object);
        }
        return list1;
//        String sql="Select product_name from product where product_name like ?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, proName+'%');
//        ResultSet rst=stm.executeQuery();
//        
//        ObservableList<String> list=FXCollections.observableArrayList();
//        while(rst.next()){
//            String name=rst.getString("product_name");
//            list.add(name);
//        }
//        if(list.size()>0){
//            return list;
//        }
//        return null;
    }

    @Override
    public String getProName(String proid) throws Exception {
       Criteria add = session.createCriteria(Product.class).add(Restrictions.eq("proid", proid));
       Product get = (Product) add.list().get(0);
       return get.getProduct_name();
//        String sql="select product_name from product where proid=?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, proid);
//        ResultSet rst=stm.executeQuery();
//        
//        String name=null;
//        if(rst.next()){
//            name=rst.getString("product_name");
//        }
//        return name;
    }

    @Override
    public boolean add(Product dto) throws Exception {
       Serializable save = session.save(dto);
       return save!=null;
//        int res=0;
//        String sql="insert into product values(?,?,?,?)";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, dto.getProid());
//        stm.setObject(2, dto.getProductName());
//        stm.setObject(3, dto.getBagSize_kg());
//        stm.setObject(4, dto.getQtyBags());
//        res=stm.executeUpdate();
//        if(res>0){
//            return true;
//        }
//        return false;
    }

    @Override
    public void updateAsIncreased(ArrayList<Product> dtoList) throws Exception {
        for (Product product : dtoList) {
            session.update(product);
        }
//        int res=0;
//        for (ProductDTO productDTO : dtoList) {
//            
//            String sql="update product set product_qty_bags=product_qty_bags+? where proid=?";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(1, productDTO.getQtyBags());
//            stm.setObject(2, productDTO.getProid());
//            res+=stm.executeUpdate();
//        }
//        if(res==dtoList.size()){
//            return true;
//        }
//        return false;
    }

    @Override
    public boolean update(String rename, String product) throws Exception {
       Query createQuery = session.createQuery("update product set product_name=:name where product_name=:name2");
       createQuery.setParameter("name",rename);
       createQuery.setParameter("name2",product);
       return createQuery.executeUpdate()>0;
//        String sql="update product set product_name=? where product_name=?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, rename);
//        stm.setObject(2, product);
//        int res=stm.executeUpdate();
//        if(res>0){
//            return true;
//        }
//        return false;
    }

    @Override
    public boolean remove(String id) throws Exception {
       Query createQuery = session.createQuery("delete from product where proid=:proid");
       createQuery.setParameter("proid", id);
       return createQuery.executeUpdate()>0;
//        String sql="delete from product where proid=?";
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
    public Product getSpecific(String id) throws Exception {
       Product get = (Product) session.createCriteria(Product.class).add(Restrictions.eq("proid", id)).list().get(0);
       return get;
    }
    
}
