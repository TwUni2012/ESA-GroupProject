/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webinfofrontend;

import javax.ejb.ApplicationException;

/**
 *
 * @author Vylyb
 */
@ApplicationException(rollback=true)
public class InvalidDateException extends Exception {
    
    private String message;
    private int invalidDate;

    public InvalidDateException(String message, int invalidDate) {
        this.message = message;
        this.invalidDate = invalidDate;
    }

    @Override
    public String getMessage() {
        return message+":\t"+invalidDate;
    }
    
}
