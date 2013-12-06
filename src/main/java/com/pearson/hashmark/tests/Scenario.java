package com.pearson.hashmark.tests;

import com.pearson.hashmark.Credential;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Scenario {
    
    private static final Logger LOG = LoggerFactory.getLogger(Scenario.class);
    
    protected final List<Credential> credentialsList;
    protected final List<Result> resultsList;
    
    public Scenario(List<Credential> credentialsList) {
        this.credentialsList = credentialsList;
        resultsList = new ArrayList<>();
    }

    public void execute() {
        for (Test test : getTests()) {
            LOG.info("Starting " + test.getDescription());
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