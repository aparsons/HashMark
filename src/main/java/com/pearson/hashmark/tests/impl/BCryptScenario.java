package com.pearson.hashmark.tests.impl;

import com.pearson.hashmark.Credential;
import com.pearson.hashmark.tests.Scenario;
import java.util.ArrayList;
import java.util.List;

public final class BCryptScenario extends Scenario {

    private final static int MINUMUM_LOG_ROUNDS = 4;
    
    private final List<BCryptTest> tests;
    
    public BCryptScenario(List<Credential> credentialsList, int maxLogRounds) {
        super(credentialsList);
        tests = generateTests(maxLogRounds);
    }

    @Override
    public List<BCryptTest> getTests() {
        return tests;
    }

    private List<BCryptTest> generateTests(int maxLogRounds) {
        List<BCryptTest> generatedTests = new ArrayList<>(maxLogRounds);
        for (int r = MINUMUM_LOG_ROUNDS; r <= maxLogRounds; r++) {
            generatedTests.add(new BCryptTest("BCrypt LogRounds=" + r, r));
        }              
        return generatedTests;
    }
    
}