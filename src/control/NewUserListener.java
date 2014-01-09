/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Game;

/**
 *
 * @author Magnum
 */
public class NewUserListener implements ActionListener
{

    private JTextField firstName, lastName;
    private JPasswordField password, password_2;
    private JButton save, cancel;
    private JLabel registerNew, firstNameLabel, lastNameLabel, passwordLabel, passwordLabel_2;
    private JPanel mainPanel;
    private Game game = new Game();

    public NewUserListener(JTextField firstName, JTextField lastName, JPasswordField password, JPasswordField password_2, JButton save, JButton cancel, JLabel registerNew, JLabel firstNameLabel, JLabel lastNameLabel, JLabel passwordLabel, JLabel passwordLabel_2, JPanel mainPanel)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.password_2 = password_2;
        this.save = save;
        this.cancel = cancel;
        this.registerNew = registerNew;
        this.firstNameLabel = firstNameLabel;
        this.lastNameLabel = lastNameLabel;
        this.passwordLabel = passwordLabel;
        this.passwordLabel_2 = passwordLabel_2;
        this.mainPanel = mainPanel;
    }

    public void addNewUser(String firstName, String lastName, String password, String passwordRetype)
    {
        if (game.checkPassword(password, passwordRetype))
        {

            game.addNewUser(firstName, lastName, password, password);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object choice = (e.getSource());
        if (choice == save)
        {

        }
        else if (choice == cancel)
        {

        }
    }

}
