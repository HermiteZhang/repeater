package top.hermite.repeater.pigeon.core.component.util;


import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;


public class StringUtils
{

    public static String digestPassword(String password)
    {
        String salt = String.valueOf(System.currentTimeMillis());
        password += salt;
        byte[] passwordByte = Base64Utils.encode(password.getBytes());
        String md5Password = DigestUtils.md5DigestAsHex(passwordByte);
        return md5Password;
    }
    /**
     * 加密
     *
     * @param datasource
     *            byte[]
     * @param password
     *            String
     * @return byte[]
     */
    public static byte[] encryptDES(byte[] datasource, String password)
    {
        try
        {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象,ENCRYPT_MODE用于将 Cipher 初始化为加密模式的常量
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            // 现在，获取数据并加密
            // 正式执行加密操作
            // 按单部分操作加密或解密数据，或者结束一个多部分操作
            return cipher.doFinal(datasource);
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param src
     *            byte[]
     * @param password
     *            String
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decryptDES(byte[] src, String password)
            throws Exception
    {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        // 创建一个密匙工厂
        // 返回实现指定转换的 Cipher 对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }

    /**
     *
     * @param string
     * @return
     */
    public static String vagueString(String string)
    {
        StringBuffer sb = new StringBuffer();
        int strSize = string.length();
        if (strSize <= 3)
        {
            for (int i = 0; i < strSize; i++ )
            {
                sb.append("*");
            }
            return sb.toString();
        }
        else
        {
            int split = strSize / 3;
            sb.append(string.substring(0, split));
            for (int i = 0; i < split; i++ )
            {
                sb.append("*");
            }
            sb.append(string.substring(split * 2, strSize));
            return sb.toString();
        }
    }
}