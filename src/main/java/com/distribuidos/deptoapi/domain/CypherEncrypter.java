package com.distribuidos.deptoapi.domain;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;


public class CypherEncrypter {

    private static final String RSA_ALGORITHM = "RSA";
    private static KeyFactory keyFactory;
    private static Cipher cipher;

    public static String encrypt(byte[] data) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException, InvalidKeySpecException {
        return CypherEncrypter.getCipherTextByPublicKey(data);
    }
    private static String getCipherTextByPublicKey(byte[] data)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
        keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, CypherEncrypter.getPublicKey());
        byte[] cipherText = cipher.doFinal(data);
        return encode(cipherText);
    }

    private static RSAPublicKey getPublicKey() throws IOException, InvalidKeySpecException {

        String keyPub = readFile("C:\\public_key.pem");
        String publicKeyPEM = CypherEncrypter.getPublicPem(keyPub);

        byte[] encodedPublicKeyPEM = decode(publicKeyPEM);
        X509EncodedKeySpec keySpecPub = new X509EncodedKeySpec(encodedPublicKeyPEM);

        return (RSAPublicKey) keyFactory.generatePublic(keySpecPub);
    }

    private static String readFile(String path) throws IOException {
        File file = new File(path);
        String fileText = Files.readString(file.toPath(), Charset.defaultCharset());
        return fileText;
    }
    private static String getPublicPem(String strFilePub)
    {
        String publicKeyPEM = strFilePub
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replaceAll(System.lineSeparator(), "")
                .replace("-----END PUBLIC KEY-----", "");
        return publicKeyPEM;
    }
    private static String encode(byte[] data)
    {
        return Base64.getEncoder().encodeToString(data);

    }
    private static byte[] decode(String data)
    {
        return Base64.getDecoder().decode(data);
    }

}