package com.pearson.hashmark.tests.impl;

import com.pearson.hashmark.Credential;
import com.pearson.hashmark.tests.Test;
import org.mindrot.jbcrypt.BCrypt;

public class BCryptTest extends Test {

    private final int logRounds;
    
    public BCryptTest(String description, int logRounds) {
        super(description);
        this.logRounds = logRounds;
    }

    @Override
    protected void execute(Credential credential) {
        BCrypt.hashpw(credential.getPassword(), BCrypt.gensalt(logRounds));
    }

}