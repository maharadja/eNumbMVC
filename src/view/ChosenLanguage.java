/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ChosenLanguageListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Viktor
 */
public class ChosenLanguage extends JPanel
{

    private JLabel chooseWeekText, addNewWeekText;
    private JPanel container;
    private JComboBox section;
    private JButton help, addNewSection, back;
    private Enumb main;

    public ChosenLanguage(Enumb jf)
    {

        //Labels
        chooseWeekText = new JLabel("Välj vecka:");
        addNewWeekText = new JLabel("Lägg till ny vecka:");

        //Buttons
        help = new JButton("Hjälp");
        addNewSection = new JButton("Lägg till ny sektion");
        back = new JButton("Tillbaka");

        //Panels
        container = new JPanel(new FlowLayout());

        //ComboBoxes
        section = new JComboBox();

        main = jf;

        //ChosenLanguageListener
        ChosenLanguageListener listener = new ChosenLanguageListener(chooseWeekText, addNewWeekText, section, help, addNewSection, back, main);

        //set Size
        addNewSection.setPreferredSize(new Dimension(400, 30));
        section.setPreferredSize(new Dimension(400, 30));
        container.setPreferredSize(new Dimension(600, 700));

        //set backgrounds
        setBackground(Color.WHITE);
        container.setBackground(Color.WHITE);
        section.setBackground(new Color(255, 255, 255));

        //Adding to ComboBox
        section.addItem("Vecka 1");
        section.addItem("Vecka 2");
        section.addItem("Vecka 3");

        //Addings
        container.add(chooseWeekText);
        container.add(section);
        container.add(Box.createRigidArea(new Dimension(58, 220)));
        container.add(addNewWeekText);
        container.add(addNewSection);
        container.add(Box.createRigidArea(new Dimension(58, 220)));
        container.add(help);
        container.add(Box.createRigidArea(new Dimension(58, 220)));
        container.add(back);
        add(container);// Adding to extended JPanel

        //adding actionListeners
        back.addActionListener(listener);
        help.addActionListener(listener);
        section.addActionListener(listener);

    }

}
