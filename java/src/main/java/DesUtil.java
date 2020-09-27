package com.fang.transfer.agent.common.tools.utils;

import lombok.val;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;

/**
 * Create by user on 2018-10-17
 */
public class DesUtil {
    public static String bytes2hex(byte[] bytes) {
        final String HEX = "0123456789abcdef";
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            // 取出这个字节的高4位，然后与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
            sb.append(HEX.charAt((b >> 4) & 0x0f));
            // 取出这个字节的低位，与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
            sb.append(HEX.charAt(b & 0x0f));
        }
        return sb.toString();
    }

    public static byte[] encoder(byte[] sourceData, String password) {
        try {
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            IvParameterSpec iv = new IvParameterSpec(password.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);
            return cipher.doFinal(sourceData);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encoderStringToHexString(String sourceData, String password, Charset charsetset) {
        val data = encoder(sourceData.getBytes(charsetset), password);
        if (data == null) {
            return null;
        }
        return bytes2hex(data);
    }

    public static String encoderStringToHexString(String sourceData, String password) {
        return encoderStringToHexString(sourceData, password, Charset.forName("utf-8"));
    }

    /**
     * 解密数据
     *
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static String decrypt(String message, String key) throws Exception {
        byte[] bytesrc = convertHexString(message);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] retByte = cipher.doFinal(bytesrc);
        return new String(retByte);
    }

    /**
     * 加密数据
     *
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(String message, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        return cipher.doFinal(message.getBytes("UTF-8"));
    }

    public static byte[] encryptEncode(String message, String key, String encode) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(encode));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes(encode));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        return cipher.doFinal(message.getBytes(encode));
    }


    public static byte[] convertHexString(String ss) {
        byte[] digest = new byte[ss.length() / 2];
        for (int i = 0; i < digest.length; i++) {
            String byteString = ss.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte) byteValue;
        }
        return digest;
    }

    public static String toHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String plainText = Integer.toHexString(0xff & b[i]);
            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }
        return hexString.toString().toUpperCase();
    }

    /**
     * 进行base64编码
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBase64(String data, String key) throws Exception {
        byte[] bt = encrypt(data, key);

        String strs = Base64.encodeBase64String(bt);
        return strs;
    }

    public static String encryptBase64ToHexString(String data, String key) throws Exception {
        byte[] bt = encrypt(data, key);
        String strs = Base64.encodeBase64String(bt);
        if (strs == null) {
            return null;
        }
        return toHexString(strs.getBytes(Charset.forName("utf-8")));
    }

    /**
     * 加密数据 成 16进制的字符串
     *
     * @param data    加密数据
     * @param key     加密key
     * @param charset 数据编码集
     * @return
     * @throws Exception
     */
    public static String encryptHexString(String data, String key, String charset) throws Exception {
        key = getSecretKey(key);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("gbk"));
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, generateKey(key), iv);
        byte[] b;
        if (StringUtils.isBlank(charset)) {
            //oa系统默认编码集
            b = data.getBytes("gbk");
        } else {
            b = data.getBytes(charset);
        }
        return toHexStringNew(cipher.doFinal(b));
    }

    public static String oaLoginEncrypt(String data,String secretKey) throws Exception {
        IvParameterSpec iv = new IvParameterSpec(secretKey.getBytes("gbk"));
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, generateKey(secretKey), iv);

        byte[] b = cipher.doFinal(data.getBytes());
        return Base64.encodeBase64String(b);
    }

    /**
     * 与APP接口交互加密算法
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static String appEncrypt(String data, String key) throws Exception {
        return encryptHexString(data, key, null);
    }

    /**
     * byte转为16进制
     *
     * @param b
     * @return
     */
    private static String toHexStringNew(byte b[]) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String plainText = Integer.toHexString(0xff & b[i]);
            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }
        String code = "";
        try {
            code = new String(hexString.toString().getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return code;

    }

    /**
     * 16进制的字符串  解密方法
     *
     * @param secretData 密文
     * @param key
     * @param charset    字符集
     * @return
     * @throws Exception
     */
    public static String decryptionHexString(String secretData, String key, String charset) {
        try {
            key = getSecretKey(key);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(key.getBytes("gbk"));
            cipher.init(Cipher.DECRYPT_MODE, generateKey(key), iv);
            byte[] buf = cipher.doFinal(decode(secretData.toCharArray()));
            if (StringUtils.isBlank(charset)) {
                return new String(buf, "gbk");
            }
            return new String(buf, charset);
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 与APP接口约定的解密算法
     *
     * @param secretData
     * @param key
     * @return
     * @throws Exception
     */
    public static String appDecryption(String secretData, String key) {
        return decryptionHexString(secretData, key, null);
    }

    public static byte[] decode(char[] data) throws IllegalArgumentException {
        int len = data.length;
        if ((len & 0x01) != 0) {
            throw new IllegalArgumentException("Odd number of characters.");
        }
        byte[] out = new byte[len >> 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f = f | toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }
        return out;
    }

    public static int toDigit(char ch, int index) throws IllegalArgumentException {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new IllegalArgumentException("Illegal hexadecimal charcter " + ch + " at index " + index);
        }
        return digit;
    }

    /**
     * 获得加密密钥
     *
     * @param secretKey
     * @return
     */
    public static SecretKey generateKey(String secretKey) throws Exception {
        DESKeySpec desKeySpec = new DESKeySpec(secretKey.getBytes("gbk"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        return keyFactory.generateSecret(desKeySpec);
    }

    /**
     * 将密钥长度不足8的倍数位  用0补全
     *
     * @param secretKey
     * @anthor shangwenyu
     * @data 2016-6-2 下午2:28:48
     */
    private static String getSecretKey(String secretKey) {
        if (null != secretKey) {
            int length = secretKey.length();
            if (length > 8) {//不是8
                secretKey = secretKey.substring(length - 8);
            } else if (length < 8) {
                for (int i = 0; i < 8 - length; i++) {
                    secretKey += "0";
                }
            }
        } else {
            secretKey = "00000000";
        }
        return secretKey;
    }

    /**
     * 对称加密方法
     *
     * @param input 要机密的字符串
     * @param key   密钥
     * @return 加密后的字符串
     */
    public static String encryptOA(String input, String key) {
        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            byte[] bytes = cipher.doFinal(input.getBytes("UTF-8"));
            return bytesToHexing(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * byte数组转换为16进制字符串
     *
     * @param bytes byte数组
     * @return 返回16进制字符串
     */
    public static String bytesToHexing(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        if (bytes != null && bytes.length > 0) {
            for (byte b : bytes) {
                String hex = Integer.toHexString(b & 0xff);
                if (hex.length() < 2) {
                    builder.append("0");
                    builder.append(hex.toUpperCase());
                } else {
                    builder.append(hex.toUpperCase());
                }
            }
        }
        return builder.toString();
    }

    public static String HMACSHA256(String data, String key) throws Exception {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");

            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");

            sha256_HMAC.init(secret_key);

            byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();

            for (byte item : array) {

                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));

            }
            return sb.toString().toLowerCase();
        } catch (Exception ex) {
            return "";
        }


    }
}
