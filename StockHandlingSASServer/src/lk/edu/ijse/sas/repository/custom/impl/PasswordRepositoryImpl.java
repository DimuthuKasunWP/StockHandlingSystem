/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.edu.ijse.sas.entity.Password;
import lk.edu.ijse.sas.repository.custom.PasswordRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author dimuthu
 */
public class PasswordRepositoryImpl implements PasswordRepository{

    private Session session;
    
    
    @Override
    public List<Password> getAll() throws Exception {
        List<Password> list = session.createCriteria(Password.class).list();
        return list;
//        String sql="select * from password";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        ArrayList<PasswordDTO> passwords=new ArrayList<>();
//        while(rst.next()){
//            PasswordDTO password=new PasswordDTO(rst.getString("user_name"),rst.getString("password"));
//            passwords.add(password);
//        }
//        return passwords;
    }

    @Override
    public void updatePassword(String userName, String password,String lastName) throws Exception {
        Query createQuery = session.createQuery("update password set user_name=:username,password=:password where user_name=:username2");
        createQuery.setParameter("username", lastName);
        createQuery.setParameter("password",password);
        createQuery.setParameter("username2", userName);
        createQuery.executeUpdate();
//        String sql="update password set user_name=?,password=? where user_name=?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, userName);
//        stm.setObject(2, password);
//        stm.setObject(3, lastName);
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
    public Password getSpecific(String id) throws Exception {
        Criteria add = session.createCriteria(Password.class).add(Restrictions.eq("username", id));
        return (Password) add.list().get(0);
        
    }
    

}
