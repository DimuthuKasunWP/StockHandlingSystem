/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import lk.edu.ijse.sas.entity.Dates;
import lk.edu.ijse.sas.repository.custom.DateRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author dimuthu
 */
public class DateRepositoryImpl implements DateRepository{
private Session session;
    @Override
    public Dates getDateDetail() throws Exception {
          Query createQuery = session.createQuery("select dayname(curdate())as one,day(curdate()) as two,monthname(curdate()) as three,date(curdate()) as four");
          Dates get = (Dates) createQuery.list().get(0);
          return get;
//        String sql="select dayname(curdate())as one,day(curdate()) as two,monthname(curdate()) as three,date(curdate()) as four";
//        Connection conn=ConnectionFactory.getInstance().getConnection();
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        DateDTO d=null;
//        if(rst.next()){
//            d=new DateDTO(rst.getString("day(curdate())"),rst.getString("dayname(curdate())"),rst.getString("monthname(curdate())"),rst.getString("date(curdate())"));
//        }
//        return d;
    }

    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }

    
    
}
