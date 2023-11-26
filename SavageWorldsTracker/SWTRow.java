package SavageWorldsTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SWTRow extends JPanel implements SWTConstants, ActionListener
{
   private static final String[] CARDS_PER_TURN_LIST = {"1", "2", "3"};
   private JButton clearB;
   private JTextField nameF;
   private JComboBox<String> cardsPerTurnDD;
   private JButton drawB;
   private JTextField cardF;
   private JTextField benniesF;
   private JCheckBox hasActedCB;
   private JPanel benniesControlPanel;
   private JButton incrimentBenniesB;
   private JButton decrimentBenniesB;
   private int bennies;
   
   public SWTRow()
   {
      super();
      bennies = 0;
      setLayout(null);
      clearB = new JButton("X");
      add(clearB);
      nameF = new JTextField();
      add(nameF);
      cardsPerTurnDD = new JComboBox<String>(CARDS_PER_TURN_LIST);
      ((JLabel)cardsPerTurnDD.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
      add(cardsPerTurnDD);
      drawB = new JButton("Draw");
      add(drawB);
      cardF = new JTextField();
      add(cardF);
      benniesF = new JTextField("");
      benniesF.setHorizontalAlignment(SwingConstants.CENTER);
      benniesF.setEditable(false);
      add(benniesF);
      hasActedCB = new JCheckBox("");
      hasActedCB.setHorizontalAlignment(SwingConstants.CENTER);
      add(hasActedCB);
      benniesControlPanel = new JPanel();
      benniesControlPanel.setLayout(new GridLayout(2, 1));
      add(benniesControlPanel);
      incrimentBenniesB = new JButton("+");
      incrimentBenniesB.addActionListener(this);
      benniesControlPanel.add(incrimentBenniesB);
      decrimentBenniesB = new JButton("-");
      decrimentBenniesB.addActionListener(this);
      benniesControlPanel.add(decrimentBenniesB);
      setBennies();
   }
   
   public void setBennies()
   {
      benniesF.setText("" + bennies);
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource() == incrimentBenniesB)
      {
         bennies++;
         setBennies();
      }
      if(ae.getSource() == decrimentBenniesB)
      {
         bennies--;
         setBennies();
      }
   }
   
   public void placeComponents()
   {
      int width = getWidth();
      int height = getHeight();
      
      clearB.setSize((int)(CLEAR_WIDTH * width), height);
      clearB.setLocation((int)(CLEAR_INSET * width), 0);
      
      nameF.setSize((int)(NAME_WIDTH * width), height);
      nameF.setLocation((int)(NAME_INSET * width), 0);
      
      cardsPerTurnDD.setSize((int)(CARDS_PER_TURN_WIDTH * width), height);
      cardsPerTurnDD.setLocation((int)(CARDS_PER_TURN_INSET * width), 0);
      
      drawB.setSize((int)(DRAW_BUTTON_WIDTH * width), height);
      drawB.setLocation((int)(DRAW_BUTTON_INSET * width), 0);
      
      cardF.setSize((int)(CARD_WIDTH * width), height);
      cardF.setLocation((int)(CARD_INSET * width), 0);
      
      benniesF.setSize((int)(BENNIES_WIDTH * width), height);
      benniesF.setLocation((int)(BENNIES_INSET * width), 0);
      
      benniesControlPanel.setSize((int)(BENNIES_MANIPULATION_WIDTH * width), height);
      benniesControlPanel.setLocation((int)(BENNIES_MANIPULATION_INSET * width), 0);
      
      hasActedCB.setSize((int)(HAS_ACTED_WIDTH * width), height);
      hasActedCB.setLocation((int)(HAS_ACTED_INSET * width), 0);
   }
}