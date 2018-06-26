package han;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MainJF {
    private JTextArea 明文;
    private JTextArea 密文;
    private JButton 浏览密文件Button;
    private JButton 浏览源文件Button;
    private JButton 解密文件Button;
    private JTextField inFile;
    private JButton 开始加密Button;
    private JButton 开始解密Button;
    private JTextField 秘钥;
    private JPanel j1;
    private JTabbedPane jt1;
    private JPanel jt1_1;
    private JPanel j_b;
    private JPanel jb_1;
    private JPanel Jb_2;
    private JPanel J_m;
    private JPanel Jm_1;
    private JPanel jm_2;
    private JPanel jt;
    private JPanel jt_1;
    private JPanel j_file;
    private JPanel j_la;
    private JLabel jl_1;
    private JLabel Jl_2;
    private JLabel Jl_3;
    private JPanel j_f_b_1;
    private JPanel j_f_f;
    private JTextField outFile;
    private JTextField myDifficultPasswTextField;
    private JButton 加密文件Button;

    public MainJF() {
        开始加密Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                try {
                    密文.setText(new asetest().encyptWord(明文.getText(),秘钥.getText()));
                } catch (NoSuchPaddingException e1) {
                    e1.printStackTrace();
                } catch (NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                } catch (InvalidKeyException e1) {
                    e1.printStackTrace();
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                } catch (BadPaddingException e1) {
                    e1.printStackTrace();
                } catch (IllegalBlockSizeException e1) {
                    e1.printStackTrace();
                }
            }
        });
        开始解密Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                try {
                    明文.setText(new asetest().decyptWord(密文.getText(),秘钥.getText()));
                } catch (NoSuchPaddingException e1) {
                    e1.printStackTrace();
                } catch (NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                } catch (InvalidKeyException e1) {
                    e1.printStackTrace();
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                } catch (BadPaddingException e1) {
                    e1.printStackTrace();
                } catch (IllegalBlockSizeException e1) {
                    e1.printStackTrace();
                }
            }
        });


        解密文件Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                try {
                    if (new File(outFile.getText()).exists()){
                        int overwriteSelect = JOptionPane.showConfirmDialog(jt1,
                                "文件" + new File(outFile.getText()).getName() + "已存在，是否覆盖?",
                                "是否覆盖?",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE);
                        if (overwriteSelect == JOptionPane.YES_OPTION)
                        {
                            new asetest().decryptFile(inFile.getText(),outFile.getText(),秘钥.getText());
                        }

                    }

                } catch (NoSuchPaddingException e1) {
                    e1.printStackTrace();
                } catch (NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                } catch (InvalidKeyException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        浏览源文件Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                JFileChooser jf=new JFileChooser();
                jf.setCurrentDirectory(new File(inFile.getText()).getAbsoluteFile());
                if  (jf.showOpenDialog(jt1)==JFileChooser.APPROVE_OPTION){
                    inFile.setText(jf.getSelectedFile().getAbsolutePath());
                }

            }
        });
        浏览密文件Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                JFileChooser jf=new JFileChooser();
                jf.setCurrentDirectory(new File(inFile.getText()).getAbsoluteFile());
                if  (jf.showSaveDialog(jt1)==JFileChooser.APPROVE_OPTION){
                    outFile.setText(jf.getSelectedFile().getAbsolutePath());
                }
            }
        });
        加密文件Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                try{
                    if (new File(outFile.getText()).exists()){
                        int overwriteSelect = JOptionPane.showConfirmDialog(jt1,
                                "文件" + new File(outFile.getText()).getName() + "已存在，是否覆盖?",
                                "是否覆盖?",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE);
                        if (overwriteSelect == JOptionPane.YES_OPTION)
                        {
                            new asetest().encryptFile(inFile.getText(),outFile.getText(),秘钥.getText());
                        }

                    }


                } catch (NoSuchPaddingException e1) {
                    e1.printStackTrace();
                } catch (NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                } catch (InvalidKeyException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (BadPaddingException e1) {
                    e1.printStackTrace();
                } catch (IllegalBlockSizeException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ASE 加解密工具 --madeby 韩同超 QQ：50612");
        frame.setContentPane(new MainJF().j1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
