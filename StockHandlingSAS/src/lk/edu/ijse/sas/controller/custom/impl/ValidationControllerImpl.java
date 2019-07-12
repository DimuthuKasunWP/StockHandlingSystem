/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import lk.edu.ijse.sas.controller.custom.ValidationController;

/**
 *
 * @author Vidura
 */
public class ValidationControllerImpl implements ValidationController{

    @Override
    public boolean setNumberFormat(String text) throws Exception {

        char[] number=text.toCharArray();
        int count=0;
        for(int i=0;i<number.length;i++){
            if(number[i]=='1'||number[i]=='2'||number[i]=='3'||number[i]=='4'||number[i]=='5'||number[i]=='6'||number[i]=='7'||number[i]=='8'||number[i]=='9'||number[i]=='0'||number[i]=='.'||number[i]==','|| number[i]==' '){
                count++;
                
            }
        }
        if(count==number.length){
            return true;
        }
        return false;
    }

    @Override
    public boolean setStringFormat(Object text) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setTelNoFormat(String text) throws Exception {
        
        String tel=(String)text;
        if(tel.matches("\\d{3}-\\d{7}")){
            return true;
        }
        return false;
    }

    @Override
    public boolean setEmailFormat(Object text) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setDateFormat(String date) throws Exception {
      
        if(date.matches("\\d{4}-\\d{2}-\\d{2}") ||date.matches("\\d{4}/\\d{2}/\\d{2}")||date.matches("\\d{2}/\\d{2}/\\d{4}")){
           return true;
        }
        return false;
        
    }

    @Override
    public boolean setIntFormat(String text) throws Exception {
        char[] number=text.toCharArray();
        int count=0;
        for(int i=0;i<number.length;i++){
            if(number[i]=='1'||number[i]=='2'||number[i]=='3'||number[i]=='4'||number[i]=='5'||number[i]=='6'||number[i]=='7'||number[i]=='8'||number[i]=='9'||number[i]=='0'|| number[i]==' '){
                count++;
                
            }
        }
        if(count==number.length){
            return true;
        }
        return false;
    }

}
