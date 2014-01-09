/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Adrian
 */
public class ErrorMessage {
    
        public static void display(String errorMessage) {
                    
        JOptionPane.showMessageDialog(null, errorMessage, "Felmeddelande",
        JOptionPane.ERROR_MESSAGE);
                        
    }
       
    
}