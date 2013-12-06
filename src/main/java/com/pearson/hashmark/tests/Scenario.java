package com.pearson.hashmark.tests;

import com.pearson.hashmark.Credential;
import java.util.ArrayList;
import java.util.List;

public abstract class Scenario {
    
    protected final List<Credential> credentialsList;
    protected final List<Result> resultsList;
    
    public Scenario(List<Credential> credentialsList) {
        this.credentialsList = credentialsList;
        resultsList = new ArrayList<>();
    }

    public void execute() {
        for (Test test : getTests()) {
            Result result = new Result(test.getDescription());
            for (Credential credential : credentialsList) {
                result.addTime(test.run(credential));
            }
            resultsList.add(result);
        }
    }

    public List<Result> getResultsList() {
        return resultsList;
    }

    public abstract List<? extends Test> getTests();
    
    public List<Credential> getCredentialsList() {
        return credentialsList;
    }
    
}