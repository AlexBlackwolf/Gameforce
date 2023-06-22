package Utils;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DataEncryption {
    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = "/A?D(G+KaPdSgVkYp3s6v9y$B&E)H@Fg".getBytes();

    public static String encrypt(String data) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Key key = new SecretKeySpec(KEY, ALGORITHM);
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    public static String decrypt(String encryptedData) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        Key key = new SecretKeySpec(KEY, ALGORITHM);
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decValue = c.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decValue);
    }
}