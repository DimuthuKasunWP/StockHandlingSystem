/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service;

import java.rmi.Remote;

/**
 *
 * @author dimuthu
 */
public interface ServiceFactory extends Remote{
    public enum ServiceTypes{
            BATCH_ADD,DATE,BATCH_RECEIVE,IDGEN,PASSWORD,REMOVE_RECEIVE_MATERIAL,REMOVE_RETURN_MATERIAL,COMPANY,GRN,QUARY,MATERIAL,SECTOR,MATERIAL_REMOVE,ORDERS,PRODUCT,PRODUCT_ORDER,PURCHASE_ORDER,PURCHASE_ORDER_DETAIL,REJECT_ORDER,REJECT_ORDER_DETAIL,REJECT_RECEIVE,REJECT_RETURN_RECEIVE,RETURN_BATCH_RECEIVE,RETURN_ORDER,RETURN_ORDER_DETAIL,VALIDATION
    }
    
    public SuperService getService(ServiceTypes type) throws Exception;
}
