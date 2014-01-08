/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.GridLayout;
import javax.swing.*;


/**
 *
 * @author Adrian
 */
public class MenuHelp extends JPanel{
    
        public static void display() {
        //new TextAreas
        JTextArea menuHelp = new JTextArea("För att få spela detta spel måste du \n ha en hjärna och inte vara allt för färsk.");
        
        //new Panels
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        //new Labels
        panel.add(new JLabel("Instruktioner:"));

        //Editable settings. 
        menuHelp.setEditable(false);
              
        //Adding to panel.
        panel.add(menuHelp);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Hjälp - Meny",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            System.out.println(menuHelp.getText());
        } else {
            System.out.println("Cancelled");
        }
        
    }
    
}