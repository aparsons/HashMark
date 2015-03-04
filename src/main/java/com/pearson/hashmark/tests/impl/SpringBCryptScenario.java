package com.pearson.hashmark.tests.impl;

import com.pearson.hashmark.Credential;
import com.pearson.hashmark.tests.Scenario;
import com.pearson.hashmark.tests.Test;
import java.util.ArrayList;
import java.util.List;

public class SpringBCryptScenario extends Scenario {

    private final List<SpringBCryptTest> tests;

    public SpringBCryptScenario(List<Credential> credentialsList, int minLogRounds, int maxLogRounds) {
        super(credentialsList);
        this.tests = generateTests(minLogRounds, maxLogRounds);
    }
    
    @Override
    public List<? extends Test> getTests() {
        return tests;
    }
    
    private List<SpringBCryptTest> generateTests(int minLogRounds, int maxLogRounds) {
        List<SpringBCryptTest> generatedTests = new ArrayList<>(maxLogRounds);
        for (int r = minLogRounds; r <= maxLogRounds; r++) {
            generatedTests.add(new SpringBCryptTest("Spring BCrypt LogRounds=" + r, r));
        }              
        return generatedTests;
    }
    
}
