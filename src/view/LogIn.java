package view;

import control.LoginListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktor
 */
public class LogIn extends JPanel
{

    private final JComboBox<String> name;
    private final JLabel whatName, whatPassword;
    private final JPasswordField password;
    private final JButton logIn, newUser, exitButton;
    private final Enumb main;
    private final JLayeredPane jPane;
    private BufferedImage buttonIcon;

    public LogIn(Enumb jf) throws IOException
    {

        //new Labels
        JLabel background = new JLabel(new ImageIcon("images\\background2new.png"));
        whatName = new JLabel("Vad är ditt namn?");
        whatPassword = new JLabel("Vad är ditt lösenord?");

        //new BufferedImage
        buttonIcon = ImageIO.read(new File("images\\exit.png"));

        //new Buttons
        logIn = new JButton("Logga in");
        newUser = new JButton("Ny användare");
        exitButton = new JButton(new ImageIcon(buttonIcon));

        //new ComboBoxes
        name = new JComboBox<>();

        //new LayeredPane
        jPane = new JLayeredPane();

        //new PasswordFields
        password = new JPasswordField(10);

        main = jf;

        //LoginListener
        LoginListener listener = new LoginListener(name, whatName, whatPassword, password, logIn, newUser, exitButton, main, jPane);

        //set Size
        background.setSize(512, 680);
        jPane.setPreferredSize(new Dimension(512, 680));

        //border settings.
        jPane.setBorder(BorderFactory.createLineBorder(Color.yellow));
        exitButton.setBorder(BorderFactory.createEmptyBorder());

        //location settings.
        password.setBounds(180, 165, 180, 30);
        name.setBounds(180, 130, 180, 30);
        exitButton.setBounds(450, 5, 48, 48);
        logIn.setBounds(180, 200, 180, 30);
        newUser.setBounds(180, 235, 180, 30);
        whatName.setBounds(58, 130, 180, 30);
        whatPassword.setBounds(58, 165, 180, 30);

        //background settings.
        name.setBackground(new Color(255, 255, 255));
        exitButton.setContentAreaFilled(false);

        //adding ActionListeners
        exitButton.addActionListener(listener);
        logIn.addActionListener(listener);
        newUser.addActionListener(listener);

        //Cursor settings.
        name.setCursor(new Cursor(HAND_CURSOR));
        exitButton.setCursor(new Cursor(HAND_CURSOR));
        logIn.setCursor(new Cursor(HAND_CURSOR));
        newUser.setCursor(new Cursor(HAND_CURSOR));

        //Adding items to the username comboBox. Just for show right now...
        name.addItem("Välj användare");
        name.addItem("Svenne");
        name.addItem("Gundeman");
        name.addItem("Jesus");
        name.addItem("Bogdan");
        name.addItem("Mögel-Bert");

        //Adding stuff to the LayeredPane
        jPane.add(background, new Integer(1));
        jPane.add(logIn, new Integer(2));
        jPane.add(name, new Integer(3));
        jPane.add(password, new Integer(4));
        jPane.add(whatName, new Integer(5));
        jPane.add(exitButton, new Integer(6));
        jPane.add(newUser, new Integer(7));
        jPane.add(whatPassword, new Integer(8));

        add(jPane);//Adding to extended JPanel.

    }

}
