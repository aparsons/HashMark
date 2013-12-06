package com.pearson.hashmark.tests.impl;

import com.pearson.hashmark.Credential;
import com.pearson.hashmark.tests.Test;
import java.security.SecureRandom;

public class PBKDF2Test extends Test {

    public PBKDF2Test(String description) {
        super(description);
    }

    @Override
    protected void execute(Credential credential) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private byte[] generateSalt() {
        SecureRandom random = null;
        return null;
    }
    
}