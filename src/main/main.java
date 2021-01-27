
package main;

import Util.EncryptUtil.ALGORITHM;
import static Util.EncryptUtil.decrypt;
import static Util.EncryptUtil.digest;
import static Util.EncryptUtil.encrypt;
import static Util.EncryptUtil.md5;


public class main {
      public static void main(String[] args) {
        String content = "Test content, ahmad";
        String password = "password!@#";
        System.out.println("content:" + content + "\n");

        String encrypted = encrypt(content, password);
        System.out.println("AES encrypt:" + encrypted);
        System.out.println("AES decrypt:" + decrypt(encrypted, password) + "\n");

        encrypted = encrypt(content, password, ALGORITHM.DES);
        System.out.println("DES encrypt:" + encrypted);
        System.out.println("DES decrypt:" + decrypt(encrypted, password, ALGORITHM.DES) + "\n");

        System.out.println("md5 hash:" + md5(content));
        System.out.println("sha256 hash:" + digest(content, ALGORITHM.SHA256));
    }
    
}
