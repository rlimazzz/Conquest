package com.example.demo1;

import Todo.App;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton signupButton = new JButton("Sign");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel("Log into your account");

    HashMap<String, String> logging = new HashMap<String, String>();

    LoginPage(HashMap<String, String> loginInfo) {
        logging = loginInfo;

        // bounds to adjust our login menu
        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);
        messageLabel.setBounds(50, 25, 350, 75);
        userIDField.setBounds(150, 100, 125, 25);
        userPasswordField.setBounds(150, 150, 125, 25);
        loginButton.setBounds(300, 100, 75, 25);
        signupButton.setBounds(300, 150, 75, 25);

        // setting our actions
        loginButton.addActionListener(this);
        signupButton.addActionListener(this);

        // removing focus from buttons
        loginButton.setFocusable(false);
        signupButton.setFocusable(false);

        frame.add(userIDLabel);
        frame.add(userIDField);
        frame.add(messageLabel);
        frame.add(userPasswordLabel);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(signupButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setTitle("Conquest");
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (logging.containsKey(userID)) {
                if (logging.get(userID).equals(password)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");

                    App app = new App();
                    frame.dispose();
                }
            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username/password not correct");
            }
        } else if (e.getSource() == signupButton) {
            Signup signup = new Signup();
        }
    }
}
