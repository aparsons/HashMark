package com.pearson.hashmark.tests.impl;

import com.pearson.hashmark.Credential;
import com.pearson.hashmark.tests.Test;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class SpringBCryptTest extends Test {

    private final int logRounds;

    public SpringBCryptTest(String description, int logRounds) {
        super(description);
        this.logRounds = logRounds;
    }
    
    @Override
    protected void execute(Credential credential) {
        BCrypt.hashpw(credential.getPassword(), BCrypt.gensalt(logRounds));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("logRounds", logRounds)
                .toString();
    }
    
}
