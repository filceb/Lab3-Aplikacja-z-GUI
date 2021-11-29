package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Main {

    private static JPanel panel;
    private static JFrame frame;
    private static JLabel labelU, labelP;
    private static JTextField userT;
    private static JPasswordField passwordT;
    private static JButton login, restart;
    private static JMenuBar menuBar;
    private static JMenu menu;
    private static JMenuItem menuLog, menuRes;
    private static Map<String, String> accounts;

    public static void main(String[] args) {
        GUIlogin();
    }

    private static void GUIlogin(){
        accounts = new HashMap();
        accounts.put("123456", "qwerty");
        accounts.put("234567", "asdf");
        accounts.put("1qaz2wsx", "3edc4rfv");
        accounts.put("98765", "zxcvbn");
        accounts.put("8iklo9", "7ujmnhy6");

        frame = new JFrame("Logowanie");
        panel = new JPanel();
        panel.setBackground(Color.lightGray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        panel.setLayout(null);

        labelU = new JLabel("Login");
        labelU.setBounds(70, 20, 80, 25);
        panel.add(labelU);

        userT = new JTextField();
        userT.setBounds(125, 20, 150, 25);
        panel.add(userT);

        labelP = new JLabel("Hasło");
        labelP.setBounds(70, 60, 80, 25);
        panel.add(labelP);

        passwordT = new JPasswordField();
        passwordT.setBounds(125, 60, 150, 25);
        panel.add(passwordT);

        login = new JButton("Zaloguj");
        login.addActionListener(e-> logging());
        login.setBounds(115, 100, 80, 25);
        panel.add(login);

        restart = new JButton("Restart");
        restart.addActionListener(e -> restarting());
        restart.setBounds(205, 100, 80, 25);
        panel.add(restart);

        menuBar=new JMenuBar();
        menu=new JMenu("Menu");
        menuBar.add(menu);

        menuLog = new JMenuItem("Zaloguj");
        menuLog.addActionListener(e -> logging() );
        menu.add(menuLog);

        menuRes = new JMenuItem("Restartuj");
        menuRes.addActionListener(e -> restarting() );
        menu.add(menuRes);
        frame.setJMenuBar(menuBar);


        JToolBar toolBar = new JToolBar("Still draggable");
        JButton loginTB = new JButton(new ImageIcon("images/log-in.png"));
        loginTB.addActionListener(e -> logging());
        toolBar.add(loginTB);
        JButton loginRST = new JButton(new ImageIcon("images/restart.png"));
        loginRST.addActionListener(e -> restarting());
        toolBar.add(loginRST);
        frame.add(toolBar);

        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(toolBar, BorderLayout.PAGE_START);
        frame.add(panel);


        frame.setVisible(true);
    }

    private static void logging() {
        String user = userT.getText();
        String pass = new String(passwordT.getPassword());
        boolean x=false;

        Set<Map.Entry<String, String>> entrySet = accounts.entrySet();

        for(Map.Entry<String, String> entry: entrySet) {
            if(entry.getKey().equals(user) && entry.getValue().equals(pass)){
                panel.setBackground(Color.green);
                x=true;
                break;
            }
        }
        if(!x){
            panel.setBackground(Color.red);
        }

    }

    private static void restarting() {
        userT.setText(null);
        passwordT.setText(null);
        panel.setBackground(Color.lightGray);
    }

}
