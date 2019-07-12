/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom;


import java.util.ArrayList;
import lk.edu.ijse.sas.entity.Sector;
import lk.edu.ijse.sas.repository.SuperRepository;

/**
 *
 * @author dimuthu
 */
public interface SectorRepository extends SuperRepository<Sector>{

    @Override
    public default boolean add(ArrayList<Sector> dtoList) throws Exception {return true;}

    @Override
    public default void update(ArrayList<Sector> dtoList) throws Exception {}
    
    public boolean remove(String id) throws Exception;
    
    public void rename(String rename,String curName) throws Exception;
    
    public boolean add(String secName) throws Exception;
}
