/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.Enumb;
import view.Help;

/**
 *
 * @author kevin
 */
public class ChosenLanguageListener implements ActionListener
{

    private JLabel chooseWeekText, addNewWeekText;
    private JPanel container;
    private JComboBox section;
    private JButton help, addNewSection, back;
    private Enumb main;

    public ChosenLanguageListener(JLabel chooseWeekText, JLabel addNewWeekText, JComboBox section, JButton help, JButton addNewSection, JButton back, Enumb main)
    {
        this.chooseWeekText = chooseWeekText;
        this.addNewWeekText = addNewWeekText;
        this.section = section;
        this.help = help;
        this.addNewSection = addNewSection;
        this.back = back;
        this.main = main;
    }

    public ChosenLanguageListener()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        Object choice = (e.getSource());
        if (choice == help)
        {
            Help.display("ChosenLanguage");
        }
        else if (choice == back)
        {
            main.goFromLogin();
        }
        else if (choice == section)
        {
            main.goFromChosenLanguageToAddNewSection();

        }
    }

}
