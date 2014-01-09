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
import javax.swing.BorderFactory;
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
    private JPanel containerW, containerE, topLine;
    private JLabel topHeading, flagText;
    private Enumb main;

    public Menu(Enumb jf)
    {

        //new Panels
        containerE = new JPanel();
        containerW = new JPanel();
        topLine = new JPanel();

        //new Labels
        topHeading = new JLabel(new ImageIcon("images\\globe5.png"));
        flagText = new JLabel();

        //new Buttons
        addNewLanguage = new JButton("Lägg till nytt språk");
        help = new JButton("Hjälp");
        quit = new JButton("Avsluta");
        next = new JButton("Nästa");
        logOut = new JButton("Logga ut");

        //new ComboBoxes
        chooseLanguage = new JComboBox<ImageIcon>();

        //new Font
        Font font = new Font("century gothic", Font.BOLD, 15);

        main = jf;

        //MenuListern
        MenuListener listener = new MenuListener(chooseLanguage, addNewLanguage, help, quit, next, logOut, containerW, containerE, topLine, topHeading, flagText, main);

        //container.setVisible(false);
        //Size settings.
        setPreferredSize(new Dimension(1290, 890));
        containerE.setPreferredSize(new Dimension(250, 900));
        containerW.setPreferredSize(new Dimension(250, 900));
        topLine.setPreferredSize(new Dimension(1000, 25));
        flagText.setPreferredSize(new Dimension(100, 60));
        chooseLanguage.setPreferredSize(new Dimension(90, 60));
        addNewLanguage.setPreferredSize(new Dimension(200, 40));
        help.setPreferredSize(new Dimension(200, 40));
        quit.setPreferredSize(new Dimension(200, 40));
        next.setPreferredSize(new Dimension(200, 40));
        logOut.setPreferredSize(new Dimension(200, 40));

        //Background settings.
        containerE.setBackground(new Color(17, 54, 56));
        containerW.setBackground(new Color(184, 101, 0));
        flagText.setBackground(new Color(235, 235, 235));
        chooseLanguage.setBackground(new Color(255, 255, 255));
        quit.setBackground(new Color(240, 240, 240));
        help.setBackground(new Color(240, 240, 240));
        addNewLanguage.setBackground(new Color(240, 240, 240));
        logOut.setBackground(new Color(240, 240, 240));
        next.setBackground(new Color(240, 240, 240));

        //Border settings
        quit.setBorder(BorderFactory.createRaisedBevelBorder());
        next.setBorder(BorderFactory.createRaisedBevelBorder());
        chooseLanguage.setBorder(BorderFactory.createRaisedBevelBorder());
        addNewLanguage.setBorder(BorderFactory.createRaisedBevelBorder());
        help.setBorder(BorderFactory.createRaisedBevelBorder());
        logOut.setBorder(BorderFactory.createRaisedBevelBorder());
        containerW.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        containerE.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK));

        //Font settings
        quit.setFont(font);
        help.setFont(font);
        logOut.setFont(font);
        addNewLanguage.setFont(font);
        next.setFont(font);

        //Layout settings.
        setLayout(new BorderLayout());

        //Text settings
        flagText.setFont(new Font("serif", Font.BOLD, 19));
        flagText.setText("Engelska");

        //Adding ActionListeners
        quit.addActionListener(listener);
        next.addActionListener(listener);
        chooseLanguage.addActionListener(listener);
        addNewLanguage.addActionListener(listener);
        help.addActionListener(listener);
        logOut.addActionListener(listener);

        //Adding to ComboBox
        chooseLanguage.addItem(new ImageIcon("images\\ukflag.png"));
        chooseLanguage.addItem(new ImageIcon("images\\spainflag.png"));

        //Adding to WEST container.
        containerW.add(Box.createRigidArea(new Dimension(250, 115)));
        containerW.add(flagText);
        containerW.add(chooseLanguage);
        containerW.add(next);
        containerW.add(Box.createRigidArea(new Dimension(250, 290)));
        containerW.add(addNewLanguage);

        //Adding to EAST container.
        containerE.add(Box.createRigidArea(new Dimension(300, 180)));
        containerE.add(help);
        containerE.add(Box.createRigidArea(new Dimension(300, 265)));
        containerE.add(logOut);
        containerE.add(quit);

        //Adding to main container.
        //container.add(topLine, BorderLayout.PAGE_START);
        add(topHeading, BorderLayout.CENTER);
        add(containerW, BorderLayout.LINE_START);
        add(containerE, BorderLayout.LINE_END);

    }

}
