/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;

import lk.edu.ijse.sas.service.custom.impl.*;

import java.text.NumberFormat;
import lk.edu.ijse.sas.business.custom.IdBO;

/**
 *
 * @author dimuthu
 */
public class IdBOImpl implements IdBO{
    
    private IdDAO idDAO;

    public IdBOImpl() {
        
        idDAO=(IdDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.IDGEN);
    }
    
    

    @Override
    public String getNewId(String tblName, String colName, String preFix, int digitCount) throws Exception {
        
        String lastId = idDAO.getNewId(tblName, colName);
        if (null != lastId) {
            String[] idArray = lastId.split(preFix);

            int id = Integer.parseInt(idArray[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMinimumIntegerDigits(digitCount);
            numberFormat.setGroupingUsed(false);
            String newId = numberFormat.format(id);
            newId = preFix + "0" + newId ;
            return newId;
        } else {
            String newId = preFix;
            for (int i = 0; i < digitCount - 1; i++) {
                newId += "00";
            }
            newId += "1";
            return newId;
        }

    }

    @Override
    public String getNewId(String lastId, String prefix) throws Exception {
        
        String Id = "";
        char[] reg = lastId.toCharArray();
        for (int i = 1; i < reg.length; i++) {
            Id += reg[i];
        }
        int r = Integer.parseInt(Id);
        if (r < 9) {
            return prefix + "00" + (r + 1);
        } else if (r < 99) {
            return prefix + "0" + (r + 1);
        }
        return prefix + (r + 1);
    }
}
