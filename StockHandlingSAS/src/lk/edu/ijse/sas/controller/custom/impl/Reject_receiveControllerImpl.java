/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.Reject_receiveController;
import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.Reject_receiveDAO;
import com.sas.kem.edu.ijse.dto.Reject_receiveDTO;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public class Reject_receiveControllerImpl implements Reject_receiveController{

    private Reject_receiveDAO rejRecDAO;

    public Reject_receiveControllerImpl() {
        rejRecDAO=(Reject_receiveDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.REJECT_RECEIVE);
    }
    
    
    @Override
    public ArrayList<Reject_receiveDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(ArrayList<Reject_receiveDTO> dtoList) throws Exception {

        return rejRecDAO.add(dtoList);
    }

    @Override
    public boolean update(ArrayList<Reject_receiveDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Reject_receiveDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
