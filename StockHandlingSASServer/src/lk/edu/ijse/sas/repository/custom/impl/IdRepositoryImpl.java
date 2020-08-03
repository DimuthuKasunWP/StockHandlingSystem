/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import lk.edu.ijse.sas.dto.SuperDTO;
import lk.edu.ijse.sas.repository.custom.IdRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author dimuthu
 */
public class IdRepositoryImpl implements IdRepository{
    private Session session;
    @Override
    public String getNewId(String tblName, String colName) throws Exception {
        Query createQuery = session.createQuery("select "+colName+" from "+tblName+"ORDER BY 1 DESC LIMIT 1");
         String get = (String) createQuery.list().get(0);
         return get;
//        String query = "SELECT " + colName + " FROM " + tblName + " ORDER BY 1 DESC LIMIT 1";
//        Connection connection = ConnectionFactory.getInstance().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery(query);
//        if(rst.next()) {
//            String string = rst.getString(1);
//            String substring = string.substring(0);
//            System.out.println(substring);
//            return string;
//        }
//        return null;
    }

    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }

    
}
