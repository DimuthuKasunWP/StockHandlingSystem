/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller;

import lk.edu.ijse.sas.controller.custom.impl.Batch_addControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.Batch_receiveControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.CompanyControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.DateControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.GrnControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.IdControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.MaterialControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.OrdersControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.PasswordControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.ProductControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.Product_orderControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.Purchase_orderControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.QueryControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.Reject_receiveControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.Remove_receive_materialControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.Remove_return_materialControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.Return_batch_receiveControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.Return_orderControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.SectorControllerImpl;
import lk.edu.ijse.sas.controller.custom.impl.ValidationControllerImpl;

/**
 *
 * @author dimuthu
 */
public class ControllerFactory {
    
    private static ControllerFactory controllerFactory;
    
    private ControllerFactory(){
        
    }
    public enum ControllerTypes{
        
        BATCH_ADD,DATE,BATCH_RECEIVE,IDGEN,PASSWORD,REMOVE_RECEIVE_MATERIAL,REMOVE_RETURN_MATERIAL,COMPANY,GRN,QUARY,MATERIAL,SECTOR,MATERIAL_REMOVE,ORDERS,PRODUCT,PRODUCT_ORDER,PURCHASE_ORDER,PURCHASE_ORDER_DETAIL,REJECT_ORDER,REJECT_ORDER_DETAIL,REJECT_RECEIVE,REJECT_RETURN_RECEIVE,RETURN_BATCH_RECEIVE,RETURN_ORDER,RETURN_ORDER_DETAIL,VALIDATION
    }
    
    public static ControllerFactory getInstance(){
        if(controllerFactory==null){
            controllerFactory=new ControllerFactory();
            
        }
        return controllerFactory;
    }
    
    public SuperController getContollerTypes(ControllerTypes types){
        
        switch(types){
            
            case PRODUCT:
                return new ProductControllerImpl();
            case BATCH_ADD:
                return new Batch_addControllerImpl();
            case VALIDATION:
                return new ValidationControllerImpl();
            case PASSWORD:
                return new PasswordControllerImpl();
            case PURCHASE_ORDER:
                return new Purchase_orderControllerImpl();
            case MATERIAL:
                return new MaterialControllerImpl();
            case REMOVE_RECEIVE_MATERIAL:
                return new Remove_receive_materialControllerImpl();
            case REMOVE_RETURN_MATERIAL:
                return new Remove_return_materialControllerImpl();
            case COMPANY:
                return new CompanyControllerImpl();
            case QUARY:
                return new QueryControllerImpl();
            case DATE:
                return new DateControllerImpl();
            case GRN:
                return new GrnControllerImpl();
            case BATCH_RECEIVE:
                return new Batch_receiveControllerImpl();
            case IDGEN:
                return new IdControllerImpl();
            case ORDERS:
                return new OrdersControllerImpl();
            case PRODUCT_ORDER:
                return new Product_orderControllerImpl();
            case SECTOR:
                return new SectorControllerImpl();
            case RETURN_BATCH_RECEIVE:
                return new Return_batch_receiveControllerImpl();
            case REJECT_RECEIVE:
                return new Reject_receiveControllerImpl();
            case RETURN_ORDER:
                return new Return_orderControllerImpl();
            default:
                return null;
            
        }
    }
    
}
