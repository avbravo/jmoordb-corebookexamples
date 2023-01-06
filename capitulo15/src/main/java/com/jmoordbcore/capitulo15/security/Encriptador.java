/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmoordbcore.capitulo15.security;

import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

/**
 *
 * @author avbravo
 */
public class Encriptador {

//     byte[] secretKey = "9mng65v8jf4lxn93nabf981m".getBytes();
//        byte[] iv = "a76nb5h9".getBytes();
    
   
    public static String encrypter( String textToEncripter,String key) {
        try {
            byte[] secretKey = key.getBytes();
            byte[] iv = "a76nb5h9".getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "DESede");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher encryptCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivSpec);
            byte[] secretMessagesBytes = textToEncripter.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessagesBytes);
            
            return encryptedMessageBytes.toString();
        } catch (Exception e) {
            System.out.println("encrypter() " + e.getLocalizedMessage());
        }

        return "";
    }
    
    public static String decrypted( String textoEncriptado,String key) {
        try {
             byte[] secretKey = key.getBytes();
            byte[] iv = "a76nb5h9".getBytes();
             SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "DESede");
             IvParameterSpec ivSpec = new IvParameterSpec(iv);
             
              Cipher decryptCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivSpec);
        byte[] decryptedMessageBytes = decryptCipher.doFinal(textoEncriptado.getBytes());
        String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);
return decryptedMessage;
      
        } catch (Exception e) {
            System.out.println("decrypted() " + e.getLocalizedMessage());
        }

        return "";
    }
    
    
    
    
//    // Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
//    private final static String alg = "AES";
//    // Definición del modo de cifrado a utilizar
//    private final static String cI = "AES/CBC/PKCS5Padding";
//   private final static  String iv = "0123456789ABCDEF";

//    public static String encrypt(String key,  String cleartext) throws Exception {
//        
//            Cipher cipher = Cipher.getInstance(cI);
//            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
//            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
//            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
//            byte[] encrypted = cipher.doFinal(cleartext.getBytes());
//            return new String(encodeBase64(encrypted));
//    }
//    
//     public static String decrypt(String key, String encrypted) throws Exception {
//            Cipher cipher = Cipher.getInstance(cI);
//            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
//            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
//            byte[] enc = decodeBase64(encrypted);
//            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
//            byte[] decrypted = cipher.doFinal(enc);
//            return new String(decrypted);
//    }
}
