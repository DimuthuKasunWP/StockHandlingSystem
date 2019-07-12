/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom;

import lk.edu.ijse.sas.controller.SuperController;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;

/**
 *
 * @author dimuthu
 */
public interface Batch_addController extends SuperController<Batch_addDTO>{
    
   public String getProId(String baid) throws Exception;
       
}