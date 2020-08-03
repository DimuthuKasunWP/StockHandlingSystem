/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;


import lk.edu.ijse.sas.service.custom.impl.*;
import java.util.ArrayList;
import lk.edu.ijse.sas.business.custom.Batch_addBO;
import lk.edu.ijse.sas.dto.Batch_addDTO;
import lk.edu.ijse.sas.repository.RepositoryFactory;
import lk.edu.ijse.sas.repository.custom.Batch_addRepository;
import lk.edu.ijse.sas.resource.HibernateUtil;
import lk.edu.ijse.sas.service.custom.Batch_addService;
import org.hibernate.Session;

/**
 *
 * @author dimuthu
 */
public class Batch_addBOImpl implements Batch_addBO{
    
    private Batch_addRepository batch_addRepository;

    public Batch_addBOImpl() {
        batch_addRepository=(Batch_addRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.BATCH_ADD);
    }
    
    

    @Override
    public ArrayList<Batch_addDTO> getAll() throws Exception {
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
        session.beginTransaction();
        batch_addRepository.setSession(session);
        batch_addRepository.get
        
        }
    }

    

    @Override
    public String getProId(String baid) throws Exception {

        return batchDAO.getProId(baid);
    }

}
