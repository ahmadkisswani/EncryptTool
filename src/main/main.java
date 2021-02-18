package main;

import Util.EncryptUtil.ALGORITHM;
import static Util.EncryptUtil.decrypt;
import static Util.EncryptUtil.encrypt;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    public static void main(String[] args) {
        String content = "Test content, ahmad";
        String password = "password!@#";
        boolean OperationSuccessfully = false;
        OperationSuccessfully = WriteInToFile(content, password, ALGORITHM.AES);
        if (OperationSuccessfully) {
            System.out.println("File saved  Successfully");
        } else {
            System.out.println("File falid to save ");

        }
    }

    public static boolean WriteInToFile(String content, String password, ALGORITHM ALGORITHM) {

        FileWriter outFile = null;
        File dataFile = null;

        try {
            dataFile = new File(System.getProperty("user.dir") + "//src//TextFiles//encryptFile.txt");
            outFile = new FileWriter(dataFile.getAbsolutePath());

            String encrypted = encrypt(content, password, ALGORITHM);
            outFile.write("encrypted txt :" + encrypted);
            outFile.write("\n");
            outFile.write("decrypt txt :" + decrypt(encrypted, password, ALGORITHM));
            outFile.write("\n");
            outFile.write("password txt :" + password);
            outFile.write("\n");
            outFile.write("content txt :" + content);
            outFile.write("\n");
            outFile.write("ALGORITHM : " + ALGORITHM.toString());

            outFile.close();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

}
