/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.BevelBorder;


/**
 *
 * @author Viktor
 */
public class Result extends JPanel {
    private Enumb main;
    private JLabel topLabel, goodResultText, okayResultText, badResultText, resultSummary, percentText, compareResult, fullResultWindow;
    private JPanel leftContainer, rightContainer;
    private JButton menu, help, quit;
    private int correctAnswers, inPercent, comparedToEarlierResult, easyLevelResult, mediumLevelResult, hardLevelResult;
    
    
    public Result(){
    //Bara för att se att skiten funkar.
        easyLevelResult = 6;
        mediumLevelResult = 8;
        hardLevelResult = 10;
        
    //new JLabels
    topLabel = new JLabel("Ditt resultat");
    goodResultText = new JLabel("Jättebra jobbat!");
    okayResultText = new JLabel("Bra, men finns en del kvar att lära.");
    badResultText = new JLabel("Detta behöver du öva mera på.");
    resultSummary = new JLabel("Du svarade rätt på " + correctAnswers + " frågor av 10");
    percentText = new JLabel("Det blir " + inPercent + " totalt!");
    compareResult = new JLabel("Det var " + comparedToEarlierResult + " mer/mindre än ditt bästa resultat.");
    fullResultWindow = new JLabel("<html>Snitt på lätt nivå:<br /></html>" + easyLevelResult + "<html><br/>Snitt på medelnivå:<br/></html>"+ mediumLevelResult + "<html><br/>Snitt på svår nivå:<br/></html>" + hardLevelResult);
        
    
    //new JButtons
    menu = new JButton("Meny");
    help = new JButton("Hjälp");
    quit = new JButton("Avsluta");
    
    //new JPanels
    leftContainer = new JPanel();
    rightContainer = new JPanel();
    
    setLayout(new FlowLayout());
    
    //main = jf;
    
    //Size settings
    setPreferredSize(new Dimension(1290,890));
    goodResultText.setPreferredSize(new Dimension(200, 50));
    resultSummary.setPreferredSize(new Dimension(80,50));
    //okayResultText.setPreferredSize(new Dimension(200, 90));
    //badResultText.setPreferredSize(new Dimension(200, 90));
    menu.setPreferredSize(new Dimension(200, 40));
    topLabel.setPreferredSize(new Dimension(1290,50));
    leftContainer.setPreferredSize(new Dimension(450, 290));
    rightContainer.setPreferredSize(new Dimension(450, 290));
    
    //Font settings
    topLabel.setFont(new Font("century gothic", Font.BOLD, 34));
    topLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
    //Border settings
    leftContainer.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.RED, Color.GRAY));
    rightContainer.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLUE, Color.GRAY));
    topLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GRAY));
    
    
    //addings
    leftContainer.add(goodResultText);
    //leftContainer.add(okayResultText);
    //leftContainer.add(badResultText);
    leftContainer.add(resultSummary);
    leftContainer.add(percentText);
    leftContainer.add(compareResult);
    leftContainer.add(menu);
    
    rightContainer.add(fullResultWindow);
    rightContainer.add(help);
    rightContainer.add(quit);
    
    add(topLabel);
    add(leftContainer);
    add(rightContainer);
    
    

    
    }

   
    
}
