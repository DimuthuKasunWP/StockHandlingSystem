/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.ProductController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.Batch_addDAO;
import com.sas.kem.edu.ijse.dao.custom.ProductDAO;
import com.sas.kem.edu.ijse.dao.custom.Reject_orderDAO;
import com.sas.kem.edu.ijse.dao.custom.Reject_order_detailDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import com.sas.kem.edu.ijse.dto.Reject_orderDTO;
import com.sas.kem.edu.ijse.dto.Reject_order_detailDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author dimuthu
 */
public class ProductControllerImpl implements ProductController{
    
    private ProductDAO productDao;
    private Batch_addDAO batch_addDAO;
    private Reject_orderDAO rejOrderDAO;
    private Reject_order_detailDAO rejOrderDetailDAO;
    
    Connection conn;

    public ProductControllerImpl() {
        
        rejOrderDetailDAO=(Reject_order_detailDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.REJECT_ORDER_DETAIL);
        productDao=(ProductDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.PRODUCT);
        batch_addDAO=(Batch_addDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.BATCH_ADD);
        rejOrderDAO=(Reject_orderDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.REJECT_ORDER);
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    

    @Override
    public ArrayList<ProductDTO> getAll() throws Exception {
        
        return productDao.getAll();
        
    }

    @Override
    public String getProid(String proName) throws Exception {
        
        return productDao.getProid(proName);
        
    }

    @Override
    public boolean addProductions(ArrayList<ProductDTO> plist,ArrayList<Batch_addDTO> blist) throws Exception {
        
        try{
            conn.setAutoCommit(false);
            boolean isUpdate=productDao.updateAsIncreased(plist);
            if(isUpdate){
                boolean isAdd=batch_addDAO.add(blist);
                if(isAdd){
                    conn.commit();
                    return true;
                }
            }
            conn.rollback();
            return false;
        }catch(SQLException ex){
            conn.rollback();
            return false;
        }finally{
            conn.setAutoCommit(true);
        }
    }

    @Override
    public boolean add(ArrayList<ProductDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ArrayList<ProductDTO> dtoList) throws Exception {
        
        return productDao.add(dtoList);
    }

    @Override
    public ObservableList<String> getProNames(String proName) throws Exception {
        
        return productDao.getProNames(proName);
    }

    @Override
    public String getProName(String proid) throws Exception {

        return productDao.getProName(proid);
    }

    @Override
    public boolean add(ProductDTO dto) throws Exception {
        
        return productDao.add(dto);
    }

    @Override
    public boolean updateAsIncreased(ArrayList<ProductDTO> dtoList, ArrayList<Batch_addDTO> batchlist, ArrayList<Reject_order_detailDTO> rejOrderlist, Reject_orderDTO rDto) throws Exception {

        conn.setAutoCommit(false);
        try{
            
            boolean isUpdateProduct=productDao.updateAsIncreased(dtoList);
            if(isUpdateProduct){
                boolean isUpdateBatchAdd=batch_addDAO.updateAsIncreased(batchlist);
                if(isUpdateBatchAdd){
                    boolean isAddRejectOrder=rejOrderDAO.add(rDto);
                    if(isAddRejectOrder){
                        boolean isAddRejectOrderDetail=rejOrderDetailDAO.add(rejOrderlist);
                        if(isAddRejectOrderDetail){
                            conn.commit();
                            return true;
                        }
                    }
                }
            }
            conn.rollback();
            return false;
        }catch(SQLException ex){
            conn.rollback();
            return false;
        }finally{
            conn.setAutoCommit(true);
        }
    }

    @Override
    public boolean update(String rename, String product) throws Exception {

        return productDao.update(rename, product);
    }

    @Override
    public boolean remove(String id) throws Exception {

        return productDao.remove(id);
    }

    @Override
    public boolean updateAsIncreased(ArrayList<ProductDTO> dtoList) throws Exception {

        return productDao.update(dtoList);
    }
    
}
