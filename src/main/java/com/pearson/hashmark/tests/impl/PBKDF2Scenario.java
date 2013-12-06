package com.pearson.hashmark.tests.impl;

import com.pearson.hashmark.Credential;
import com.pearson.hashmark.tests.Scenario;
import java.util.List;

public final class PBKDF2Scenario extends Scenario {
    
    private final List<PBKDF2Test> tests = generateTests();
    
    public PBKDF2Scenario(List<Credential> credentialsList) {
        super(credentialsList);
    }

    @Override
    public List<PBKDF2Test> getTests() {
        return tests;
    }
    
    private List<PBKDF2Test> generateTests() {
        return null;
    }

}