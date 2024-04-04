package edu.iu.habahram.ducksservice.security;

import javax.crypto.KeyGenerator;
import java.security.KeyPair;
import com.nimbusds.jose.jwk.RSAKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class Jwks {

    private Jwks() {};

    public static RSAKey generateRSA(){
        KeyPair keyPair = KeyGeneratorUtils.generateRsaKey();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        return new RSAKey.Builder(publicKey)
                .privateKey(privateKey)
                .build();

    }
}