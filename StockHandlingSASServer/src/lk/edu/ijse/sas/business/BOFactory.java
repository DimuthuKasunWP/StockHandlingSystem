/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business;

import lk.edu.ijse.sas.business.custom.impl.Batch_addBOImpl;
import lk.edu.ijse.sas.business.custom.impl.Batch_receiveBOImpl;
import lk.edu.ijse.sas.business.custom.impl.CompanyBOImpl;
import lk.edu.ijse.sas.business.custom.impl.DateBOImpl;
import lk.edu.ijse.sas.business.custom.impl.GrnBOImpl;
import lk.edu.ijse.sas.business.custom.impl.IdBOImpl;
import lk.edu.ijse.sas.business.custom.impl.MaterialBOImpl;
import lk.edu.ijse.sas.business.custom.impl.OrdersBOImpl;
import lk.edu.ijse.sas.business.custom.impl.PasswordBOImpl;
import lk.edu.ijse.sas.business.custom.impl.ProductBOImpl;
import lk.edu.ijse.sas.business.custom.impl.Product_orderBOImpl;
import lk.edu.ijse.sas.business.custom.impl.Purchase_orderBOImpl;
import lk.edu.ijse.sas.business.custom.impl.QueryBOImpl;
import lk.edu.ijse.sas.business.custom.impl.Reject_receiveBOImpl;
import lk.edu.ijse.sas.business.custom.impl.Remove_receive_materialBOImpl;
import lk.edu.ijse.sas.business.custom.impl.Remove_return_materialBOImpl;
import lk.edu.ijse.sas.business.custom.impl.Return_batch_receiveBOImpl;
import lk.edu.ijse.sas.business.custom.impl.Return_orderBOImpl;
import lk.edu.ijse.sas.business.custom.impl.Return_order_detailBOImpl;
import lk.edu.ijse.sas.business.custom.impl.SectorBOImpl;




/**
 *
 * @author dimuthu
 */
public class BOFactory {
    
    public enum BOTypes{
        BATCH_ADD,DATE,BATCH_RECEIVE,IDGEN,PASSWORD,REMOVE_RECEIVE_MATERIAL,REMOVE_RETURN_MATERIAL,COMPANY,GRN,QUARY,MATERIAL,SECTOR,MATERIAL_REMOVE,ORDERS,PRODUCT,PRODUCT_ORDER,PURCHASE_ORDER,PURCHASE_ORDER_DETAIL,REJECT_ORDER,REJECT_ORDER_DETAIL,REJECT_RECEIVE,REJECT_RETURN_RECEIVE,RETURN_BATCH_RECEIVE,RETURN_ORDER,RETURN_ORDER_DETAIL
    }
    
    private static BOFactory boFactory;
    
    private BOFactory(){
        
    }
    
    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    
    public SuperBO getBO(BOTypes type){
        switch(type){
            
            case PRODUCT:
                return new ProductBOImpl();
            case BATCH_ADD:
                return new Batch_addBOImpl();
            
            case PASSWORD:
                return new PasswordBOImpl();
            case PURCHASE_ORDER:
                return new Purchase_orderBOImpl();
            case MATERIAL:
                return new MaterialBOImpl();
            case REMOVE_RECEIVE_MATERIAL:
                return new Remove_receive_materialBOImpl();
            case REMOVE_RETURN_MATERIAL:
                return new Remove_return_materialBOImpl();
            case COMPANY:
                return new CompanyBOImpl();
            case QUARY:
                return new QueryBOImpl();
            case DATE:
                return new DateBOImpl();
            case GRN:
                return new GrnBOImpl();
            case BATCH_RECEIVE:
                return new Batch_receiveBOImpl();
            case IDGEN:
                return new IdBOImpl();
            case ORDERS:
                return new OrdersBOImpl();
            case PRODUCT_ORDER:
                return new Product_orderBOImpl();
            case SECTOR:
                return new SectorBOImpl();
            case RETURN_BATCH_RECEIVE:
                return new Return_batch_receiveBOImpl();
            case REJECT_RECEIVE:
                return new Reject_receiveBOImpl();
            case RETURN_ORDER:
                return new Return_orderBOImpl();
            case RETURN_ORDER_DETAIL:
                return new Return_order_detailBOImpl();
            default:
                return null;
            
        }
    }
}
