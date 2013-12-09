package com.pearson.hashmark.tests.impl;

import com.pearson.hashmark.Credential;
import com.pearson.hashmark.tests.Test;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * http://www.javacodegeeks.com/2012/05/secure-password-storage-donts-dos-and.html
 */
public class PBKDF2Test extends Test {

    public enum Algorithm {
        PBKDF2_HMAC_SHA1("PBKDF2WithHmacSHA1", 160);
        
        private final String name;
        private final int derivedKeyLength;
        
        private Algorithm(String name, int derivedKeyLength) {
            this.name = name;
            this.derivedKeyLength = derivedKeyLength;
        }

        public int getDerivedKeyLength() {
            return derivedKeyLength;
        }

        public String getName() {
            return name;
        }
        
        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("name", name)
                    .append("derivedKeyLength", derivedKeyLength)
                    .toString();
        }
        
    }
    
    private final int iterations;
    private final Algorithm algorithm;
    
    public PBKDF2Test(String description, int iterations, Algorithm algorithm) {
        super(description);
        this.iterations = iterations;
        this.algorithm = algorithm;
    }

    @Override
    protected void execute(Credential credential) throws GeneralSecurityException {
        KeySpec spec = new PBEKeySpec(credential.getPassword().toCharArray(), generateSalt(), iterations, algorithm.getDerivedKeyLength());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm.getName());
        keyFactory.generateSecret(spec);
    }

    private byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        
        byte[] salt = new byte[8];
        random.nextBytes(salt);
        
        return salt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("iterations", iterations)
                .append("algorithm", algorithm)
                .toString();
    }
    
}