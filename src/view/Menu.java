/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.MenuListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Viktor
 */
public class Menu extends JPanel
{

    private JComboBox<ImageIcon> chooseLanguage;
    private JButton addNewLanguage, help, quit, next, logOut;
    private JPanel container, containerW, containerE;
    private JLabel topHeading, flagText;
    private Enumb main;

    public Menu(Enumb jf)
    {

        //new Panels
        container = new JPanel();
        containerE = new JPanel();
        containerW = new JPanel();

        //new Labels
        topHeading = new JLabel(new ImageIcon("images\\menuBackground.png"));
        flagText = new JLabel();

        //new Buttons
        addNewLanguage = new JButton("Lägg till nytt språk");
        help = new JButton("Hjälp");
        quit = new JButton("Avsluta");
        next = new JButton("Nästa");
        logOut = new JButton("Logga ut");

        //new ComboBoxes
        chooseLanguage = new JComboBox<ImageIcon>();

        main = jf;

        //MenuListern
        MenuListener listener = new MenuListener(chooseLanguage, addNewLanguage, help, quit, next, logOut, container, containerW, containerE, topHeading, flagText, main);

        //Size settings.
        container.setPreferredSize(new Dimension(1800, 1000));
        containerE.setPreferredSize(new Dimension(300, 7));
        containerW.setPreferredSize(new Dimension(300, 810));
        flagText.setPreferredSize(new Dimension(130, 60));
        //topHeading.setPreferredSize(new Dimension(150,100));
        chooseLanguage.setPreferredSize(new Dimension(90, 60));
        addNewLanguage.setPreferredSize(new Dimension(300, 40));
        help.setPreferredSize(new Dimension(300, 40));
        quit.setPreferredSize(new Dimension(300, 40));
        next.setPreferredSize(new Dimension(300, 40));
        logOut.setPreferredSize(new Dimension(300, 40));

        //container.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        // containerE.setBorder(BorderFactory.createLineBorder(Color.RED));
        //containerW.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //Background settings.
        setBackground(Color.WHITE);
        container.setBackground(Color.WHITE);
        containerE.setBackground(Color.WHITE);
        containerW.setBackground(Color.WHITE);
        flagText.setBackground(Color.white);
        chooseLanguage.setBackground(new Color(255, 255, 255));

        //Layout settings.
        container.setLayout(new BorderLayout());

        //Text settings
        //topHeading.setFont(new Font("century gothic", Font.BOLD, 34));
        flagText.setFont(new Font("serif", Font.BOLD, 19));
        flagText.setText("Engelska");

        //Adding ActionListeners
        quit.addActionListener(listener);
        next.addActionListener(listener);
        chooseLanguage.addActionListener(listener);
        help.addActionListener(listener);
        logOut.addActionListener(listener);

        //Adding to ComboBox
        chooseLanguage.addItem(new ImageIcon("images\\ukflag.png"));
        chooseLanguage.addItem(new ImageIcon("images\\spainflag.png"));

        //Adding to WEST container.
        containerW.add(Box.createRigidArea(new Dimension(300, 230)));
        containerW.add(flagText);
        containerW.add(chooseLanguage);
        containerW.add(next);
        containerW.add(Box.createRigidArea(new Dimension(300, 300)));
        containerW.add(addNewLanguage);

        //Adding to EAST container.
        containerE.add(Box.createRigidArea(new Dimension(300, 290)));
        containerE.add(help);
        containerE.add(Box.createRigidArea(new Dimension(300, 280)));
        containerE.add(quit);
        containerE.add(logOut);

        //Adding to main container.
        container.add(topHeading, BorderLayout.CENTER);
        container.add(containerW, BorderLayout.WEST);
        container.add(containerE, BorderLayout.EAST);
        add(container);//Adding to extended JPanel

    }

}
