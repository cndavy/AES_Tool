package han;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class asetest {
    private Cipher initAESCipher(String passsword, int cipherMode) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher localCipher = null;

            SecretKeySpec localSecretKeySpec = new SecretKeySpec(passsword.getBytes(), "AES");
             localCipher = Cipher.getInstance("AES");
             localCipher.init(cipherMode, localSecretKeySpec);

        return localCipher;
    }

    public boolean decryptFile(String encryptPath, String decryptPath, String mKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        File encryptFile = null;
        File decryptFile = null;
        BufferedOutputStream outputStream = null;
        CipherInputStream inputStream = null;

            encryptFile = new File(encryptPath);
            if(!encryptFile.exists()) {
                throw new NullPointerException("Decrypt file is empty");
            }
            decryptFile = new File(decryptPath);
            Cipher cipher = initAESCipher(mKey, Cipher.DECRYPT_MODE);
            outputStream = new BufferedOutputStream(new FileOutputStream(decryptFile));
            inputStream = new CipherInputStream(new FileInputStream(encryptFile), cipher);

            int bufferLength;
            byte[] buffer = new byte[1024];

            while ((bufferLength = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bufferLength);
            }
            inputStream.close();
            outputStream.close();


        return true;
    }
     public void encryptFile(String encryptPath, String decryptPath, String password) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        {
            FileInputStream localFileInputStream = new FileInputStream(encryptPath);

            {
                FileOutputStream localFileOutputStream = new FileOutputStream(decryptPath);
                SecretKeySpec localSecretKeySpec = new SecretKeySpec(password.getBytes(), "AES");
                Cipher localCipher = Cipher.getInstance("AES");
                localCipher.init(Cipher.ENCRYPT_MODE, localSecretKeySpec);
                CipherOutputStream localCipherOutputStream = new CipherOutputStream(localFileOutputStream, localCipher);
                byte[] arrayOfByte = new byte[1024];
                for (;;)
                {
                    int i = localFileInputStream.read(arrayOfByte);
                    if (i == -1)
                    {
                        localCipherOutputStream.flush();
                        localCipherOutputStream.close();
                        localFileInputStream.close();
                        return;
                    }
                    localCipherOutputStream.write(arrayOfByte, 0, i);
                }

            }


    }


}
    public String encyptWord(String mess,String password) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec localSecretKeySpec = new SecretKeySpec(password.getBytes(), "AES");
        Cipher localCipher = Cipher.getInstance("AES");
        localCipher.init(Cipher.ENCRYPT_MODE, localSecretKeySpec);
        byte[] byteContent = mess.getBytes("utf-8");
        byte[] result=localCipher.doFinal(byteContent);

        return  new String (Base64.getEncoder().encode(result));
    }
    public String decyptWord(String demess,String password) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec localSecretKeySpec = new SecretKeySpec(password.getBytes(), "AES");
        Cipher localCipher = Cipher.getInstance("AES");
        localCipher.init(Cipher.DECRYPT_MODE, localSecretKeySpec);
        byte[] byteContent = Base64.getDecoder().decode(demess);
        byte[] result=localCipher.doFinal(byteContent);

        return  new String (result,"UTF-8");
    }
public static void main(String [] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {

//    String infile="C:\\Users\\han\\Desktop\\新建文件夹\\encrypt";
//    String outfile="C:\\Users\\han\\Desktop\\新建文件夹\\encypted";
//
//        new asetest().decryptFile(infile,outfile,"MyDifficultPassw");


}


}
