package com.distribuidos.deptoapi.domain;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";

    public static byte[] md5(String input) {
        return digest(input.getBytes(UTF_8), "MD5");
    }

    public static byte[] sha256(String input) {
        return digest(input.getBytes(UTF_8), "SHA-256");
    }

    public static byte[] sha3_256(String input) {
        return digest(input.getBytes(UTF_8), "SHA3-256");
    }

    private static byte[] digest(byte[] input, String algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }

    private static byte[] checksum(String fileName) throws IOException, NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        try (
                InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(fileName);
                DigestInputStream dis = new DigestInputStream(is, md)) {
            while (dis.read() != -1) ; //empty loop to clear the data
            md = dis.getMessageDigest();
        }
        return md.digest();
    }

}
