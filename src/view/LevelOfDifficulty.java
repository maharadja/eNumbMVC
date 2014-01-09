/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.LevelOfDiffucltyListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Hashtable;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolTip;

/**
 *
 * @author Viktor
 */
public class LevelOfDifficulty extends JPanel
{

    private JPanel  centerPanel, leftPanel, rightPanel;
    private JLabel chooseDifficultyText;
    private JSlider slider;
    private JButton back, go;
    private Enumb main;
    private JToolTip toolTipEasy; // Används inte... provar lite för att slippa bakgrunden på tooltipen.

    public LevelOfDifficulty(Enumb jf)
    {

        //new Panels
        //container = new JPanel(new BorderLayout());
        centerPanel = new JPanel(new FlowLayout());
        leftPanel = new JPanel();
        rightPanel = new JPanel();

        //new Labels
        chooseDifficultyText = new JLabel("Välj svårighetsgrad!");

        //new Buttons
        back = new JButton("Tillbaka");
        go = new JButton("Kör!");

        //new Slider
        slider = new JSlider(JSlider.HORIZONTAL, 0, 2, 0);
        
        setLayout(new BorderLayout());
        
        
        //new HashTable
        Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
        labelTable.put(0, new JLabel("Lätt"));
        labelTable.put(1, new JLabel("Medel"));
        labelTable.put(2, new JLabel("Svårt"));
        
        //slider.setMajorTickSpacing(0);
        slider.setPaintTicks(true);
        slider.setLabelTable(labelTable);
        slider.setPaintLabels(true);
        
        main = jf;

        //LevelOfDiffucltyListener
        LevelOfDiffucltyListener listener = new LevelOfDiffucltyListener(chooseDifficultyText, slider, back, go, main, toolTipEasy);

        //Settings for JSlider
         

        
        
        //Size settings
        setPreferredSize(new Dimension(1290,890));
        //container.setPreferredSize(new Dimension(1310, 855));
        slider.setPreferredSize(new Dimension(800, 150));
        centerPanel.setPreferredSize(new Dimension(500,900));
        leftPanel.setPreferredSize(new Dimension(250, 900));
        rightPanel.setPreferredSize(new Dimension(250, 900));

        //Background settings
        setBackground(Color.BLACK);
        //container.setBackground(new Color(15,161,163));
        centerPanel.setBackground(new Color(255, 255, 255));
        leftPanel.setBackground(new Color(163,42,15));
        rightPanel.setBackground(new Color(240,90,40));

        //Font settings
        chooseDifficultyText.setFont(new Font("century gothic", Font.BOLD, 34));

        //add actionListeners and changeListeners
        back.addActionListener(listener);
        go.addActionListener(listener);
        slider.addChangeListener(listener);

        
        //Addings
        centerPanel.add(chooseDifficultyText);
        centerPanel.add(Box.createRigidArea(new Dimension(250, 290)));
        centerPanel.add(slider);
        centerPanel.add(go);
        centerPanel.add(back);
        //container.add(centerPanel, BorderLayout.CENTER);
        //container.add(leftPanel, BorderLayout.LINE_START);
        //container.add(rightPanel, BorderLayout.LINE_END);
        add(centerPanel);
        add(leftPanel, BorderLayout.LINE_START);
        add(rightPanel, BorderLayout.LINE_END);
        //add(container);

    }

}
