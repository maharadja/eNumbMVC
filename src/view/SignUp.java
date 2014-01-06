/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.*;
import java.awt.GridLayout;

/**
 *
 * @author Adrian
 */
public class SignUp{
    
        public static void display() {

        JTextField firstname = new JTextField();
        JTextField lastname = new JTextField();
        JTextField username = new JTextField();
        JTextField password = new JPasswordField();
        JTextField password_2 = new JPasswordField();
        
        //new Panels
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        //new Labels and add to Panel
        panel.add(new JLabel("Förnamn:"));
        panel.add(firstname);
        panel.add(new JLabel("Efternamn:"));
        panel.add(lastname);
        panel.add(new JLabel("Användarnamn:"));
        panel.add(username);        
        panel.add(new JLabel("Lösenord:"));
        panel.add(password);       
        panel.add(new JLabel("Repetera Lösenord:"));
        panel.add(password_2);

        
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Ny Användare",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            System.out.println(
                    firstname.getText() + " " + 
                    lastname.getText() + " " + 
                    username.getText() + " " + 
                    password.getText() + " " + 
                    password_2.getText());
        } else {
            System.out.println("Cancelled");
        }
        
    }
    
}