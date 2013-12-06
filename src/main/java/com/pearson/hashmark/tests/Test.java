package com.pearson.hashmark.tests;

import com.pearson.hashmark.Credential;
import org.apache.commons.lang.time.StopWatch;

public abstract class Test {
    
    private final String description;
    private final StopWatch stopwatch;
    
    public Test(String description) {
        this.description = description;
        stopwatch = new StopWatch();
    }
    
    protected abstract void execute(Credential credential);

    public String getDescription() {
        return description;
    }
    
    public long run(Credential credential) {
        stopwatch.reset();
        stopwatch.start();
        execute(credential);
        stopwatch.stop();
        
        return stopwatch.getTime(); // Millis
    }
    
}