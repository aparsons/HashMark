package com.pearson.hashmark;

import com.pearson.hashmark.tests.Result;
import com.pearson.hashmark.tests.impl.BCryptScenario;
import java.util.List;

public class HashMark {
    
    private static int PASSWORDS_PER_TEST = 500;
    
    // BCrypt Config
    private static int BCRYPT_MAX_LOG_ROUNDS = 8;
    
    public static void main(String[] args){
        // Generate Credentials
        List<Credential> credentialsList = CredentialsFactory.generate(PASSWORDS_PER_TEST);
        
        // Initialize Scenarios
        BCryptScenario bcryptScenario = new BCryptScenario(credentialsList, BCRYPT_MAX_LOG_ROUNDS);
       // PBKDF2Scenario pbkdf2Scenario = new PBKDF2Scenario(credentialsList);
        
        // Run
        bcryptScenario.execute();
        //pbkdf2Scenario.execute();
        
        // Results
        for (Result result : bcryptScenario.getResultsList()) {
            System.out.println(result.toString());
        }
        
        //for (Result result : pbkdf2Scenario.getResultsList()) {
        //    System.out.println(result.toString());
        //}

        System.exit(0);
    }
    
}