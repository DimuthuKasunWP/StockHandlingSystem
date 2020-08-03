/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.IdDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Vidura
 */
public class IdDAOImpl implements IdDAO{

    @Override
    public String getNewId(String tblName, String colName) throws Exception {
        
        String query = "SELECT " + colName + " FROM " + tblName + " ORDER BY 1 DESC LIMIT 1";
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(query);
        if(rst.next()) {
            String string = rst.getString(1);
            String substring = string.substring(0);
            System.out.println(substring);
            return string;
        }
        return null;
    }
}
