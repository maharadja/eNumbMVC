/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Game;
import model.UserList;

import view.Enumb;

/**
 *
 * @author Magnum
 */
public class NewUserListener implements ActionListener
{

    private JTextField firstName, lastName, password, password_2;

    private JButton save, cancel;

    private Enumb main;
    private Parser parser;
    private UserList userlist;
    private Game game;

    public NewUserListener(JTextField firstName, JTextField lastName, JTextField password, JTextField password_2, JButton save, JButton cancel, Enumb main)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.password_2 = password_2;
        this.save = save;
        this.cancel = cancel;
        this.main = main;
        parser = MainFactory.getParser();
        game = parser.getGame();
    }

    public void addNewUser(String first, String last, String pass, String pass2)
    {
        if (!Parser.verifyNoEmptyFields(first, last, pass, pass2))
        {
            JOptionPane.showMessageDialog(null, "Alla fält måste vara ifyllda");
            main.goFromLoginToNewUser();
        }
        else if (!Parser.validateUserInput(first) == true && Parser.validateUserInput(last))
        {
            JOptionPane.showMessageDialog(null, "Fler än 24 tecken är ej tillåtet");
            main.goFromLoginToNewUser();
        }
        else if (!Parser.passwordCheck(pass, pass2))
        {
            JOptionPane.showMessageDialog(null, "Lösenorden måste vara identiska");
            main.goFromLoginToNewUser();
        }
        else if (userlist != null && userlist.getSize() == 0)
        {
            JOptionPane.showMessageDialog(null, "Användaren finns redan");
            main.goFromLoginToNewUser();
        }
        else
        {
            game.addNewUser(first, last, pass, pass2);
            JOptionPane.showMessageDialog(null, "Grattis, du är nu registrerad användare i eNumb");

            main.logOutUser();
        }
    }

    //Behöver kalla på updateList metoden i LogIn,
    // Behöver göra en password check med, sen är nog registerd delen klar
    //main.logOutUser();
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object choice = (e.getSource());
        if (choice == save)
        {
            String first = this.firstName.getText();
            String last = this.lastName.getText();
            String pass = this.password.getText();
            String pass2 = this.password_2.getText();
            addNewUser(first, last, pass, pass2);
            firstName.setText("");
            lastName.setText("");
            password.setText("");
            password_2.setText("");

        }
        else if (choice == cancel)
        {
            main.logOutUser();
        }
    }

}
