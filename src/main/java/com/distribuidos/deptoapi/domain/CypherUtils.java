package com.distribuidos.deptoapi.domain;

import java.security.*;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class CypherUtils {

    private static PrivateKey privKey;
    private static PublicKey publKey;
    private static Cipher cypher;


    public static byte[] encryptString(String stringToEncrypt) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {



        //Initializing a Cipher object
        cypher.init(Cipher.ENCRYPT_MODE, publKey);

        //Adding data to the cipher
        byte[] input = stringToEncrypt.getBytes();
        cypher.update(input);

        //encrypting the data
        byte[] cipherText = cypher.doFinal();
        System.out.println("se imprime el valor cifrado en cypher utils");
        System.out.println(new String(cipherText));


        return cipherText;
    }
    public static byte[] decrypt(byte[] cipherText) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        //Initializing the same cipher for decryption
        cypher.init(Cipher.DECRYPT_MODE, privKey);

        //Decrypting the text
        byte[] decipheredText = cypher.doFinal(cipherText);

        System.out.println("se imprime el valor decifrado en cypher utils");
        System.out.println(new String(decipheredText));

        return decipheredText;
    }

    public static void generateCypher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        //Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withRSA");

        //Creating a Cipher object
        cypher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    }
    public static void generateKeys() throws NoSuchAlgorithmException {
        //Creating KeyPair generator object
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        //Initializing the key pair generator
        keyPairGen.initialize(512);

        //Generating the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();
        privKey = pair.getPrivate();
        publKey = pair.getPublic();
    }



}
