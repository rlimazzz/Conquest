package com.example.demo1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Signup implements ActionListener {
    JFrame frame = new JFrame();
    JButton signupButton = new JButton("Sign");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel("Signup your new account");
    JLabel emailLabel = new JLabel("Email:");
    JTextField userEmailField = new JTextField();

    Signup() {
        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75 , 25);
        messageLabel.setBounds(50, 25 , 350 , 75);
        userIDField.setBounds(150, 100, 125, 25);
        userPasswordField.setBounds(150, 150, 125, 25);
        signupButton.setBounds(300, 150, 75, 25);
        emailLabel.setBounds(50, 200, 75, 25);
        userEmailField.setBounds(150, 200, 125, 25);

        //setting our actions
        signupButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(userIDField);
        frame.add(messageLabel);
        frame.add(userPasswordLabel);
        frame.add(userPasswordField);
        frame.add(signupButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setTitle("Conquest");
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
