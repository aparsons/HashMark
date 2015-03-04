package com.pearson.hashmark;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang.RandomStringUtils;

public class CredentialsFactory {

    public static List<Credential> generate(int count, int minLength, int maxLength) {
        List<Credential> credentialsList = new ArrayList<>();

        Random random = new Random();
        for (int index = 0; index < count; index++) {
            credentialsList.add(new Credential(RandomStringUtils.random(random.nextInt(maxLength - minLength) + minLength, true, true)));
        }
        
        return credentialsList;
    } 
    
}