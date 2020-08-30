/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao;

import com.sas.kem.edu.ijse.dao.custom.impl.Batch_addDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.Batch_receiveDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.CompanyDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.DateDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.GrnDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.IdDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.MaterialDaoImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.OrdersDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.PasswordDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.ProductDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.Product_orderDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.Purchase_orderDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.QuaryDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.Reject_orderDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.Reject_order_detailDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.Reject_receiveDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.Reject_return_receiveDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.Remove_receive_materialDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.Remove_return_materialDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.Return_batch_receiveDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.Return_orderDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.Return_order_detailDAOImpl;
import com.sas.kem.edu.ijse.dao.custom.impl.SectorDAOImpl;

/**
 *
 * @author dimuthu
 */
public class DAOFactory {
    
    private static DAOFactory daoFactory;
    
    private DAOFactory(){
        
    }
    
    public enum daoTypes{
        
        BATCH_ADD,IDGEN,PASSWORD,DATE,BATCH_RECEIVE,COMPANY,SECTOR,QUARY,GRN,MATERIAL,REMOVE_RECEIVE_MATERIAL,REMOVE_RETURN_MATERIAL,ORDERS,PRODUCT,PRODUCT_ORDER,PURCHASE_ORDER,PURCHASE_ORDER_DETAIL,REJECT_ORDER,REJECT_ORDER_DETAIL,REJECT_RECEIVE,REJECT_RETURN_RECEIVE,RETURN_BATCH_RECEIVE,RETURN_ORDER,RETURN_ORDER_DETAIL
        
    }
    public static DAOFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    
    public SuperDAO getDAOTypes(daoTypes types){
        
        switch(types){
            
            case PRODUCT:
                return new ProductDAOImpl();
            case BATCH_ADD:
                return new Batch_addDAOImpl();
            case PASSWORD:
                return new PasswordDAOImpl();
            case PURCHASE_ORDER:
                return new Purchase_orderDAOImpl();
            case MATERIAL:
                return new MaterialDaoImpl();
            case COMPANY:
                return new CompanyDAOImpl();
            case QUARY:
                return new QuaryDAOImpl();
            case DATE:
                return new DateDAOImpl();
            case GRN:
                return new GrnDAOImpl();
            case BATCH_RECEIVE:
                return new Batch_receiveDAOImpl();
            case IDGEN:
                return new IdDAOImpl();
            case ORDERS:
                return new OrdersDAOImpl();
            case PRODUCT_ORDER:
                return new Product_orderDAOImpl();
            case REMOVE_RECEIVE_MATERIAL:
                return new Remove_receive_materialDAOImpl();
            case REMOVE_RETURN_MATERIAL:
                return new Remove_return_materialDAOImpl();
            case SECTOR:
                return new SectorDAOImpl();
            case RETURN_BATCH_RECEIVE:
                return new Return_batch_receiveDAOImpl();
            case REJECT_RECEIVE:
                return new Reject_receiveDAOImpl();
            case REJECT_RETURN_RECEIVE:
                return new Reject_return_receiveDAOImpl();
            case REJECT_ORDER:
                return new Reject_orderDAOImpl();
            case REJECT_ORDER_DETAIL:
                return new Reject_order_detailDAOImpl();
            case RETURN_ORDER:
                return new Return_orderDAOImpl();
            case RETURN_ORDER_DETAIL:
                return new Return_order_detailDAOImpl();
            default:
                return null;
        }
    }
    
}
