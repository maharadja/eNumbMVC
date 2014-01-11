/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Game;
import view.Enumb;

/**
 *
 * @author kevin
 */
public class LoginListener implements ActionListener
{

    private final JComboBox<String> name;
    private final JLabel whatName, whatPassword;
    private final JTextField password;
    private final JButton logIn, newUser;
    private final Enumb main;
    private final JLayeredPane jPane;
    private BufferedImage buttonIcon;
    private Parser parser;
    private Game game;

    public LoginListener(JComboBox<String> name, JLabel whatName, JLabel whatPassword, JTextField password, JButton logIn, JButton newUser, Enumb main, JLayeredPane jPane)
    {
        this.name = name;
        this.whatName = whatName;
        this.whatPassword = whatPassword;
        this.password = password;
        this.logIn = logIn;
        this.newUser = newUser;
        this.main = main;
        this.jPane = jPane;
        parser = MainFactory.getParser();
        game = parser.getGame();

    }

    public LoginListener()
    {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Verfiys userName and userPassword if match user logs in
     *
     * @param userName chosen username from checkbox
     * @param password enterd password
     */
    public void verifyUserAndPassword(String userName, String password)
    {
        if (Parser.validateUserInput(userName) && Parser.validateUserInput(password) == true)

        {
            if (game.checkPassword(userName, password) == true)
            {
                JOptionPane.showMessageDialog(null, " Klicka för att logga in ");

                main.goFromLogin();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Fel lösenord, försök igen");

            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Något gick fel, försök igen");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object choice = (e.getSource());

        if (choice == logIn)
        {

            String userName = name.getSelectedItem().toString();
            String userPass = password.getText();

            verifyUserAndPassword(userName, userPass);
            password.setText("");

        }
        else if (choice == newUser)
        {
            main.goFromLoginToNewUser();
            password.setText("");

        }
    }
}
