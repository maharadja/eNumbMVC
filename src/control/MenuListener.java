/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.AddNewLanguage;
import view.Enumb;
import view.MenuHelp;

/**
 *
 * @author kevin
 */
public class MenuListener implements ActionListener
{

    private JComboBox<ImageIcon> chooseLanguage;
    private JButton addNewLanguage, help, quit, next, logOut;
    private JPanel container, containerW, containerE;
    private JLabel topHeading, flagText;
    private Enumb main;

    public MenuListener(JComboBox<ImageIcon> chooseLanguage, JButton addNewLanguage, JButton help, JButton quit, JButton next, JButton logOut, JPanel container, JPanel containerW, JPanel containerE, JLabel topHeading, JLabel flagText, Enumb main)
    {
        this.chooseLanguage = chooseLanguage;
        this.addNewLanguage = addNewLanguage;
        this.help = help;
        this.quit = quit;
        this.next = next;
        this.logOut = logOut;
        this.container = container;
        this.containerW = containerW;
        this.containerE = containerE;
        this.topHeading = topHeading;
        this.flagText = flagText;
        this.main = main;
    }

    public MenuListener()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object choice = (e.getSource());

        if (chooseLanguage.getSelectedIndex() == 0)
        {
            flagText.setText("Engelska");
        }
        else if (chooseLanguage.getSelectedIndex() == 1)
        {
            flagText.setText("Spanska");
        }

        if (choice == addNewLanguage)
        {
            AddNewLanguage.display();
        }
        else if (choice == quit)
        {
            System.exit(0);
        }
        else if (choice == logOut)
        {
            main.logOutUser();
        }
        else if (choice == next)
        {
            main.goFromMenuToChosenLanguage();
        }
        else if (choice == help)
        {
            MenuHelp.display();
        }
    }

}
