package com.pearson.hashmark.tests.impl;

import com.pearson.hashmark.Credential;
import com.pearson.hashmark.tests.Scenario;
import com.pearson.hashmark.tests.impl.PBKDF2Test.Algorithm;
import java.util.ArrayList;
import java.util.List;

public final class PBKDF2Scenario extends Scenario {
    
    private final List<PBKDF2Test> tests;
    
    public PBKDF2Scenario(List<Credential> credentialsList, int incrementStart, int incrementStep, int incrementStop) {
        super(credentialsList);
        this.tests = generateTests(incrementStart, incrementStep, incrementStop);
    }

    @Override
    public List<PBKDF2Test> getTests() {
        return tests;
    }
    
    private List<PBKDF2Test> generateTests(int start, int step, int stop) {
        List<PBKDF2Test> generatedTests = new ArrayList<>();
        
        for (int iterations = start; iterations <= stop; iterations += step) {
            for (Algorithm algorithm : Algorithm.values()) {
                generatedTests.add(new PBKDF2Test("PBKDF2 Iterations=" + iterations + " Algorithm=" + algorithm.getName(), iterations, algorithm));
            }
        }
        
        return generatedTests;
    }

}