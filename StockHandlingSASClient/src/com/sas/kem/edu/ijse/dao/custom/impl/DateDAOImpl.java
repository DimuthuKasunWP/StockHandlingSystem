/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.DateDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.DateDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Vidura
 */
public class DateDAOImpl implements DateDAO{

    @Override
    public DateDTO getDateDetail() throws Exception {
        
        String sql="select dayname(curdate()),day(curdate()),monthname(curdate()),date(curdate())";
        Connection conn=ConnectionFactory.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        DateDTO d=null;
        if(rst.next()){
            d=new DateDTO(rst.getString("day(curdate())"),rst.getString("dayname(curdate())"),rst.getString("monthname(curdate())"),rst.getString("date(curdate())"));
        }
        return d;
    }
    
}
