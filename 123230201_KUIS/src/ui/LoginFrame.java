/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    
    public LoginFrame(){
        setTitle("Frame Login");
        setSize (300,200);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,2,5,5));
        
        
        //komponen UI
        
        add(new JLabel ("Username :"));
        usernameField = new JTextField();
        add(usernameField);
        
        add(new JLabel ("Password :"));
        usernameField = new JPasswordField ();
        add(passwordField);
        
        loginButton = new JButton ("Login");
        add(loginButton);
        
        
        //EVENT LISTENER
        
        loginButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String (passwordField.getPassword());
                
                if (!username.isEmpty() && !password.isEmpty()){
                    dispose(); // Tutup Frame Login
                   
                } else {
                    JOptionPane.showMessageDialog(null,"Masukkan username dan Password ");
                }
                
            }
                
            });
        setVisible(true);
        }
        
}
        
        
        
    
    
    
    
    
    
