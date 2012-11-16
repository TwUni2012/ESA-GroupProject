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
public class InvalidTaskException extends Exception {
    
    private String message;

    public InvalidTaskException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
}
