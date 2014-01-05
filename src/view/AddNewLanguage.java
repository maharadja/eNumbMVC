
package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Viktor
 */
public class AddNewLanguage extends JPanel{

    private JButton saveNewLanguage;
    private JLabel background;
    private Enumb main;

    public AddNewLanguage(Enumb jf) {
        
        setPreferredSize(new Dimension(800,500));       
        saveNewLanguage = new JButton("efoijsfoijseofijef");
        background = new JLabel(new ImageIcon("images\\jonatanadrian.jpg"));
        saveNewLanguage.setBounds(0, 0, 170, 50);
        background.setBounds(0, 0, 300, 500);
        add(background);
        add(saveNewLanguage, new Integer(1), 1);
        main = jf;
         

    }

    

}
