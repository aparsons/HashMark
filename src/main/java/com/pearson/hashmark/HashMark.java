package com.pearson.hashmark;

import com.pearson.hashmark.tests.Result;
import com.pearson.hashmark.tests.impl.BCryptScenario;
import com.pearson.hashmark.tests.impl.PBKDF2Scenario;
import java.util.List;

public class HashMark {
    
    private static int PASSWORDS_PER_TEST       = 500;
    
    // Config
    private static int BCRYPT_MAX_LOG_ROUNDS    = 6;
    private static int PBKDF2_INCREMENT_START   = 5000;
    private static int PBKDF2_INCREMENT_STEP    = 10000;
    private static int PBKDF2_INCREMENT_STOP    = 75000;
    
    public static void main(String[] args){
        List<Credential> credentialsList = CredentialsFactory.generate(PASSWORDS_PER_TEST);
        
        bcrypt(credentialsList);
        pbkdf2(credentialsList);

        System.exit(0);
    }
    
    private static void bcrypt(List<Credential> credentialsList) {
        BCryptScenario bcrypt = new BCryptScenario(credentialsList, BCRYPT_MAX_LOG_ROUNDS);
        
        bcrypt.execute();
        
        printResults(bcrypt.getResultsList());
    }
    
    private static void pbkdf2(List<Credential> credentialsList) {
        PBKDF2Scenario pbkdf2 = new PBKDF2Scenario(credentialsList, PBKDF2_INCREMENT_START, PBKDF2_INCREMENT_STEP, PBKDF2_INCREMENT_STOP);
        
        pbkdf2.execute();
        
        printResults(pbkdf2.getResultsList());
    }
    
    private static void printResults(List<Result> resultsList) {
        for (Result result : resultsList) {
            System.out.println(result.toString());
        }
    }
    
}