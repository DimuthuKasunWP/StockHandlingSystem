/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.edu.ijse.sas.service.ServiceFactory;
import lk.edu.ijse.sas.service.SuperService;
import lk.edu.ijse.sas.service.custom.impl.Batch_addServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.Batch_receiveServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.CompanyServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.DateServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.GrnServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.IdServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.MaterialServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.OrdersServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.PasswordServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.ProductServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.Product_orderServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.Purchase_orderServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.QueryServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.Reject_receiveServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.Remove_receive_materialServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.Remove_return_materialServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.Return_batch_receiveServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.Return_orderServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.SectorServiceImpl;
import lk.edu.ijse.sas.service.custom.impl.ValidationServiceImpl;

/**
 *
 * @author dimuthu
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory{
    
    public static ServiceFactory serviceFactory;
    
    private ServiceFactoryImpl() throws RemoteException{
        
    }
    
    public static ServiceFactory getInstance() throws RemoteException{
        if (serviceFactory == null){
            serviceFactory = new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceTypes type) throws Exception {
        switch(type){
            
            case PRODUCT:
                return new ProductServiceImpl();
            case BATCH_ADD:
                return new Batch_addServiceImpl();
            case VALIDATION:
                return new ValidationServiceImpl();
            case PASSWORD:
                return new PasswordServiceImpl();
            case PURCHASE_ORDER:
                return new Purchase_orderServiceImpl();
            case MATERIAL:
                return new MaterialServiceImpl();
            case REMOVE_RECEIVE_MATERIAL:
                return new Remove_receive_materialServiceImpl();
            case REMOVE_RETURN_MATERIAL:
                return new Remove_return_materialServiceImpl();
            case COMPANY:
                return new CompanyServiceImpl();
            case QUARY:
                return new QueryServiceImpl();
            case DATE:
                return new DateServiceImpl();
            case GRN:
                return new GrnServiceImpl();
            case BATCH_RECEIVE:
                return new Batch_receiveServiceImpl();
            case IDGEN:
                return new IdServiceImpl();
            case ORDERS:
                return new OrdersServiceImpl();
            case PRODUCT_ORDER:
                return new Product_orderServiceImpl();
            case SECTOR:
                return new SectorServiceImpl();
            case RETURN_BATCH_RECEIVE:
                return new Return_batch_receiveServiceImpl();
            case REJECT_RECEIVE:
                return new Reject_receiveServiceImpl();
            case RETURN_ORDER:
                return new Return_orderServiceImpl();
            default:
                return null;
            
        }
    }
    
}
