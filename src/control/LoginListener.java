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
import javax.swing.JPasswordField;
import view.Enumb;

/**
 *
 * @author kevin
 */
public class LoginListener implements ActionListener
{

    private final JComboBox<String> name;
    private final JLabel whatName, whatPassword;
    private final JPasswordField password;
    private final JButton logIn, newUser;
    private final Enumb main;
    private final JLayeredPane jPane;
    private BufferedImage buttonIcon;

    public LoginListener(JComboBox<String> name, JLabel whatName, JLabel whatPassword, JPasswordField password, JButton logIn, JButton newUser, Enumb main, JLayeredPane jPane)
    {
        this.name = name;
        this.whatName = whatName;
        this.whatPassword = whatPassword;
        this.password = password;
        this.logIn = logIn;
        this.newUser = newUser;
        this.main = main;
        this.jPane = jPane;
    }

    public LoginListener(JComboBox<String> name)
    {
        this.name = name;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateList()
    {
        //Adding items to the username comboBox. Just for show right now...
        name.addItem("Välj användare");

        GetHandler handler = new GetHandler();
        String[] temp = handler.getUserList();

        for (int i = 0; i < temp.length; i++)
        {
            name.addItem(temp[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object choice = (e.getSource());

        if (choice == logIn)
        {
            main.goFromLogin();
        }
        else if (choice == newUser)
        {
            main.goFromLoginToNewUser();

        }
    }
}
