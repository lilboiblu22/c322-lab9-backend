package edu.iu.habahram.ducksservice.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class KeyGeneratorUtils {

    private KeyGeneratorUtils() {};

    static KeyPair generateRsaKey() {
        // Generate RSA key pair
        KeyPair keypair;
        try{
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keypair = keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return keypair;
    }
}
