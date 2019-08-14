package com.forewei.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Date: Create By on 2019/8/7
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
public class MD5Util {
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String salt_prefix = "12";
    private static final String salt_suffix = "c3";

    /**
     * 第一次MD5加密，用于网络传输
     *
     * @param inputPass
     * @return
     */
    public static String inputPassToFormPass(String inputPass) {
        //避免在网络传输被截取然后反推出密码，所以在md5加密前先打乱密码
        String str = String.format("%s" + inputPass + "%s", salt_prefix, salt_suffix);
        return md5(str);
    }

    /**
     * 第二次MD5加密，用于存储到数据库
     *
     * @param formPass
     * @param salt
     * @return
     */
    public static String formPassToDBPass(String formPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    //合并
    public static String inputPassToDbPass(String input, String saltDB) {
        String formPass = inputPassToFormPass(input);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToDbPass("123456", "1a2b3c4d"));
    }
}
