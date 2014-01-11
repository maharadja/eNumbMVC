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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Viktor
 */
public class GameRun extends JPanel
{

    private Enumb main;
    private JButton help, menu, choiceNr1, choiceNr2, choiceNr3, choiceNr4, fulKnappSomTasBort;
    private JPanel leftPanel, rightPanel, emptyRightPanel, emptyLeftPanel, emptyBottomPanel;
    private JLabel topLabel, choiceButtonLabel;
    private JTextField wordToTranslate, translateField, correctNumbersField;
    private JProgressBar progressBar;
    private int wordNumber, correctNumbers;
    private Timer timer;

    public GameRun(Enumb jf, int level)
    {

        //new Labels
        topLabel = new JLabel();
        choiceButtonLabel = new JLabel();

        //new Panels
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
        choiceNr1 = new JButton("Alternativ 1");
        choiceNr2 = new JButton("Alternativ 2");
        choiceNr3 = new JButton("Alternativ 3");
        choiceNr4 = new JButton("Alternativ 4");
        fulKnappSomTasBort = new JButton("TAS BORT");

        main = jf;

        //GameRunListener
        GameRunListener listener = new GameRunListener(main, help, menu, fulKnappSomTasBort, leftPanel, rightPanel, emptyRightPanel, emptyLeftPanel, emptyBottomPanel, topLabel, wordToTranslate, translateField, correctNumbersField, progressBar, wordNumber, correctNumbers);

        //Adding ActionListeners
        help.addActionListener(listener);
        menu.addActionListener(listener);
        fulKnappSomTasBort.addActionListener(listener);

        //new Progressbars
        progressBar = new JProgressBar(0, 20);
        progressBar.setStringPainted(true);

        //Layout settings.
        setLayout(new BorderLayout());
        choiceButtonLabel.setLayout(new FlowLayout());
        leftPanel.setLayout(new FlowLayout());
        rightPanel.setLayout(new FlowLayout());

        //Size settings
        setPreferredSize(new Dimension(1290, 890));
        choiceNr1.setPreferredSize(new Dimension(200, 50));
        choiceNr2.setPreferredSize(new Dimension(200, 50));
        choiceNr3.setPreferredSize(new Dimension(200, 50));
        choiceNr4.setPreferredSize(new Dimension(200, 50));
        choiceButtonLabel.setPreferredSize(new Dimension(700, 500));
        topLabel.setPreferredSize(new Dimension(700, 50));
        topLabel.setBorder(new TitledBorder(""));
        emptyLeftPanel.setPreferredSize(new Dimension(150, 900));
        leftPanel.setPreferredSize(new Dimension(500, 900));
        rightPanel.setPreferredSize(new Dimension(250, 900));
        translateField.setPreferredSize(new Dimension(700, 50));
        wordToTranslate.setPreferredSize(new Dimension(700, 50));
        progressBar.setPreferredSize(new Dimension(245, 50));
        correctNumbersField.setPreferredSize(new Dimension(80, 40));

        //background settings.
        wordToTranslate.setBackground(Color.WHITE);
        correctNumbersField.setBackground(Color.WHITE);

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
        choiceButtonLabel.add(Box.createRigidArea(new Dimension(500, 50)));
        choiceButtonLabel.add(choiceNr1);
        choiceButtonLabel.add(Box.createRigidArea(new Dimension(60, 90)));
        choiceButtonLabel.add(choiceNr2);
        choiceButtonLabel.add(Box.createRigidArea(new Dimension(60, 40)));
        choiceButtonLabel.add(choiceNr3);
        choiceButtonLabel.add(Box.createRigidArea(new Dimension(60, 40)));
        choiceButtonLabel.add(choiceNr4);
        choiceButtonLabel.add(Box.createRigidArea(new Dimension(60, 40)));

        leftPanel.add(Box.createRigidArea(new Dimension(300, 60)));
        leftPanel.add(topLabel);
        leftPanel.add(Box.createRigidArea(new Dimension(300, 160)));
        leftPanel.add(wordToTranslate);
        leftPanel.add(Box.createRigidArea(new Dimension(300, 160)));
        leftPanel.add(translateField);

        //Adds or removes components in GameRun panel(Don't you dare move it from this place!)
        if (level == 0)
        {
            leftPanel.add(choiceButtonLabel);
            progressBar.setVisible(false);
            translateField.setVisible(false);
            updateUI();

        }
        else if (level == 1)
        {
            leftPanel.add(choiceButtonLabel);
            translateField.setVisible(false);
            updateUI();

        }
        else if (level == 2)
        {
            updateUI();
        }

        rightPanel.add(Box.createRigidArea(new Dimension(500, 160)));
        rightPanel.add(progressBar);
        rightPanel.add(Box.createRigidArea(new Dimension(500, 100)));
        rightPanel.add(correctNumbersField);
        rightPanel.add(Box.createRigidArea(new Dimension(500, 160)));
        rightPanel.add(help);
        rightPanel.add(menu);
        rightPanel.add(fulKnappSomTasBort);

        add(rightPanel, BorderLayout.LINE_END);
        add(leftPanel, BorderLayout.CENTER);
        add(emptyLeftPanel, BorderLayout.LINE_START);

    }

    public void CountDownProgressBar()
    {
        ActionListener listener = new ActionListener()
        {
            int counter = 20;

            @Override
            public void actionPerformed(ActionEvent ae)
            {
                counter--;
                progressBar.setValue(counter);
                System.out.println(counter);
                if (counter < 1)
                {
                    JOptionPane.showMessageDialog(null, "Tiden ute!");
                    timer.stop();
                }
            }

        };
        timer = new Timer(1000, listener);
        timer.start();
    }

}
