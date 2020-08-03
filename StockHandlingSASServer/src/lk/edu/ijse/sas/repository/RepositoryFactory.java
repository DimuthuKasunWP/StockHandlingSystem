/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository;

import lk.edu.ijse.sas.business.*;
import lk.edu.ijse.sas.repository.custom.impl.Batch_addRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.Batch_receiveRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.CompanyRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.DateRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.GrnRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.IdRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.MaterialRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.OrdersRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.PasswordRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.ProductRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.Product_orderRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.Purchase_orderRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.QueryRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.Reject_receiveRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.Remove_receive_materialRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.Remove_return_materialRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.Return_batch_receiveRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.Return_orderRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.Return_order_detailRepositoryImpl;
import lk.edu.ijse.sas.repository.custom.impl.SectorRepositoryImpl;



/**
 *
 * @author dimuthu
 */
public class RepositoryFactory {
    
    public enum RepositoryTypes{
        BATCH_ADD,DATE,BATCH_RECEIVE,IDGEN,PASSWORD,REMOVE_RECEIVE_MATERIAL,REMOVE_RETURN_MATERIAL,COMPANY,GRN,QUARY,MATERIAL,SECTOR,MATERIAL_REMOVE,ORDERS,PRODUCT,PRODUCT_ORDER,PURCHASE_ORDER,PURCHASE_ORDER_DETAIL,REJECT_ORDER,REJECT_ORDER_DETAIL,REJECT_RECEIVE,REJECT_RETURN_RECEIVE,RETURN_BATCH_RECEIVE,RETURN_ORDER,RETURN_ORDER_DETAIL
    }
    
    private static RepositoryFactory boFactory;
    
    private RepositoryFactory(){
        
    }
    
    public static RepositoryFactory getInstance(){
        if (boFactory == null){
            boFactory = new RepositoryFactory();
        }
        return boFactory;
    }
    
    public SuperRepository getRepository(RepositoryTypes type){
        switch(type){
            
            case PRODUCT:
                return new ProductRepositoryImpl();
            case BATCH_ADD:
                return new Batch_addRepositoryImpl();
            
            case PASSWORD:
                return new PasswordRepositoryImpl();
            case PURCHASE_ORDER:
                return new Purchase_orderRepositoryImpl();
            case MATERIAL:
                return new MaterialRepositoryImpl();
            case REMOVE_RECEIVE_MATERIAL:
                return new Remove_receive_materialRepositoryImpl();
            case REMOVE_RETURN_MATERIAL:
                return new Remove_return_materialRepositoryImpl();
            case COMPANY:
                return new CompanyRepositoryImpl();
            case QUARY:
                return new QueryRepositoryImpl();
            case DATE:
                return new DateRepositoryImpl();
            case GRN:
                return new GrnRepositoryImpl();
            case BATCH_RECEIVE:
                return new Batch_receiveRepositoryImpl();
            case IDGEN:
                return new IdRepositoryImpl();
            case ORDERS:
                return new OrdersRepositoryImpl();
            case PRODUCT_ORDER:
                return new Product_orderRepositoryImpl();
            case SECTOR:
                return new SectorRepositoryImpl();
            case RETURN_BATCH_RECEIVE:
                return new Return_batch_receiveRepositoryImpl();
            case REJECT_RECEIVE:
                return new Reject_receiveRepositoryImpl();
            case RETURN_ORDER:
                return new Return_orderRepositoryImpl();
            case RETURN_ORDER_DETAIL:
                return new Return_order_detailRepositoryImpl();
            default:
                return null;
            
        }
    }
}
