/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.GameRunListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Viktor
 */
public class GameRun extends JPanel
{

    private Enumb main;
    private JButton help, menu;
    private JPanel leftPanel, rightPanel, mainContainer, emptyRightPanel, emptyLeftPanel, emptyBottomPanel;
    private JLabel topLabel;
    private JTextField wordToTranslate, translateField, correctNumbersField;
    private JProgressBar progressBar;
    private int wordNumber, correctNumbers;

    public GameRun(Enumb jf)
    {

        //new Labels
        topLabel = new JLabel();

        //new Panels
        mainContainer = new JPanel(new BorderLayout()); //Main container holds left and right panels.
        leftPanel = new JPanel(); // Left panel holds wordToTranslate field and translateField.
        rightPanel = new JPanel(); // Right panel holds progressbar, "correct number"-field and help-menu buttons.
        emptyRightPanel = new JPanel(); //Empty panels to to fill west, east and bottom borderLayout.
        emptyLeftPanel = new JPanel();
        emptyBottomPanel = new JPanel();

        //new TextFields
        wordToTranslate = new JTextField();
        translateField = new JTextField();
        correctNumbersField = new JTextField(correctNumbers);

        //new Buttons
        help = new JButton("Hjälp");
        menu = new JButton("Meny");

        main = jf;

        //GameRunListener
        GameRunListener listener = new GameRunListener(main, help, menu, leftPanel, rightPanel, mainContainer, emptyRightPanel, emptyLeftPanel, emptyBottomPanel, topLabel, wordToTranslate, translateField, correctNumbersField, progressBar, wordNumber, correctNumbers);

        //Adding ActionListeners
        help.addActionListener(listener);
        menu.addActionListener(listener);

        //new Progressbars
        progressBar = new JProgressBar(0, 10);

        //Layout settings.
        setLayout(new BorderLayout());
        leftPanel.setLayout(new FlowLayout());
        rightPanel.setLayout(new FlowLayout());

        //set Size
        leftPanel.setPreferredSize(new Dimension(500, 500));
        translateField.setPreferredSize(new Dimension(500, 50));
        wordToTranslate.setPreferredSize(new Dimension(500, 50));
        rightPanel.setPreferredSize(new Dimension(500, 500));
        progressBar.setPreferredSize(new Dimension(450, 50));
        correctNumbersField.setPreferredSize(new Dimension(80, 40));
        mainContainer.setPreferredSize(new Dimension(1000, 500));

        //background settings.
        setBackground(Color.WHITE);
        leftPanel.setBackground(Color.WHITE);
        wordToTranslate.setBackground(Color.WHITE);
        correctNumbersField.setBackground(Color.WHITE);
        mainContainer.setBackground(Color.WHITE);
        emptyRightPanel.setBackground(Color.WHITE);
        emptyLeftPanel.setBackground(Color.WHITE);
        emptyBottomPanel.setBackground(Color.WHITE);

        //Border settings
        wordToTranslate.setBorder(new TitledBorder("Översätt ordet:"));
        translateField.setBorder(new TitledBorder("Skriv din översättning här:"));
        rightPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.GRAY));
        progressBar.setBorder(new TitledBorder("Tid kvar:"));
        correctNumbersField.setBorder(new TitledBorder("Antal rätt:"));

        wordNumber = 5; // Bara som ett visningsexempel för tillfället.
        correctNumbers = 8; // Bara som ett visningsexempel för tillfället.

        // TopLabel settings.
        topLabel.setText("Spelet är igång! Ord nummer " + wordNumber);
        topLabel.setFont(new Font("century gothic", Font.BOLD, 34));
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //editable settings.
        wordToTranslate.setEditable(false);
        correctNumbersField.setEditable(false);

        //Addings.
        emptyRightPanel.add(Box.createRigidArea(new Dimension(30, 160)));
        emptyLeftPanel.add(Box.createRigidArea(new Dimension(30, 160)));
        emptyBottomPanel.add(Box.createRigidArea(new Dimension(30, 60)));

        leftPanel.add(Box.createRigidArea(new Dimension(300, 160)));
        leftPanel.add(wordToTranslate);
        leftPanel.add(Box.createRigidArea(new Dimension(300, 160)));
        leftPanel.add(translateField);

        rightPanel.add(Box.createRigidArea(new Dimension(500, 160)));
        rightPanel.add(progressBar);
        rightPanel.add(Box.createRigidArea(new Dimension(500, 100)));
        rightPanel.add(correctNumbersField);
        rightPanel.add(Box.createRigidArea(new Dimension(500, 160)));
        rightPanel.add(help);
        rightPanel.add(menu);

        mainContainer.add(leftPanel, BorderLayout.WEST);
        mainContainer.add(rightPanel, BorderLayout.EAST);

        add(topLabel, BorderLayout.PAGE_START);
        add(mainContainer, BorderLayout.CENTER);
        add(emptyLeftPanel, BorderLayout.WEST);
        add(emptyRightPanel, BorderLayout.EAST);
        add(emptyBottomPanel, BorderLayout.SOUTH);

    }

}
