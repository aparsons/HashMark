package com.pearson.hashmark;

import java.util.ArrayList;
import java.util.List;

public class CredentialsFactory {

    public static List<Credential> generate(int count) {
        List<Credential> credentialsList = new ArrayList<>();
        
        credentialsList.add(new Credential("password"));
        credentialsList.add(new Credential("foo"));
        credentialsList.add(new Credential("bar"));
        credentialsList.add(new Credential("love"));
        credentialsList.add(new Credential("sex"));
        credentialsList.add(new Credential("god"));
        
        
        return credentialsList;
    } 
    
}
