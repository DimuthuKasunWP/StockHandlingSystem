/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom;

import lk.edu.ijse.sas.entity.Return_Batch_Recieve;
import lk.edu.ijse.sas.repository.SuperRepository;



/**
 *
 * @author dimuthu
 */
public interface Return_batch_receiveRepository extends SuperRepository<Return_Batch_Recieve>{

    @Override
    public default boolean add(Return_Batch_Recieve dto) throws Exception {return true;}
    
}
