/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.observer;

import java.rmi.Remote;

/**
 *
 * @author dimuthu
 */
public interface Observer extends Remote{
    
    public void update(Object ob)throws Exception;
    
}
