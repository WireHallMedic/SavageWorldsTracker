package SavageWorldsTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SWTCharacterRow extends SWTRow implements SWTConstants, ActionListener
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
   private Deck deck;
   private SavageWorldsMain parent;
   
   public SWTCharacterRow(Deck d,SavageWorldsMain p)
   {
      super();
      parent = p;
      deck = d;
      bennies = 0;
      setLayout(null);
      clearB = new JButton("X");
      clearB.addActionListener(this);
      add(clearB);
      nameF = new JTextField();
      nameF.setHorizontalAlignment(SwingConstants.CENTER);
      add(nameF);
      cardsPerTurnDD = new JComboBox<String>(CARDS_PER_TURN_LIST);
      ((JLabel)cardsPerTurnDD.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
      add(cardsPerTurnDD);
      drawB = new JButton("Draw");
      drawB.addActionListener(this);
      add(drawB);
      cardF = new JTextField();
      cardF.setHorizontalAlignment(SwingConstants.CENTER);
      add(cardF);
      benniesF = new JTextField("");
      benniesF.setHorizontalAlignment(SwingConstants.CENTER);
      benniesF.setEditable(false);
      benniesF.setFocusable(false);
      add(benniesF);
      hasActedCB = new JCheckBox("");
      hasActedCB.setHorizontalAlignment(SwingConstants.CENTER);
      add(hasActedCB);
      benniesControlPanel = new JPanel();
      benniesControlPanel.setLayout(new GridLayout(2, 1));
      add(benniesControlPanel);
      incrimentBenniesB = new JButton("+");
      incrimentBenniesB.setFocusable(false);
      incrimentBenniesB.addActionListener(this);
      benniesControlPanel.add(incrimentBenniesB);
      decrimentBenniesB = new JButton("-");
      decrimentBenniesB.setFocusable(false);
      decrimentBenniesB.addActionListener(this);
      benniesControlPanel.add(decrimentBenniesB);
      setBennies();
      
      for(Component c : this.getComponents())
      {
         if(!(c instanceof JTextField))
            c.setFocusable(false);
      }
   }
   
   public boolean isActive()
   {
      return nameF.getText().equals("") == false;
   }
   
   public void setBennies()
   {
      benniesF.setText("" + bennies);
   }
   
   public void clearActed()
   {
      hasActedCB.setSelected(false);
   }
   
   public void clearCard()
   {
      cardF.setText("");
   }
   
   public void draw()
   {
      int draws = cardsPerTurnDD.getSelectedIndex() + 1;
      String str = "";
      for(int i = 0; i < draws; i++)
      {
         str += deck.draw();
         if(i < draws - 1)
            str += ", ";
      }
      cardF.setText(str);
      parent.setShuffleButtonText();
   }
   
   public void clearAll()
   {
      bennies = 0;
      nameF.setText("");
      cardsPerTurnDD.setSelectedIndex(0);
      cardF.setText("");
      hasActedCB.setSelected(false);
      setBennies();
   }
   
   public void clean()
   {
      if(!isActive())
         clearAll();
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
      if(ae.getSource() == clearB)
      {
         clearAll();
      }
      if(ae.getSource() == drawB)
      {
         draw();
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
      
      resizeFonts();
   }
   
   public void resizeFonts()
   {
      setFontSize(clearB);
      setFontSize(nameF);
      setFontSize(cardsPerTurnDD);
      setFontSize(drawB);
      setFontSize(cardF);
      setFontSize(benniesF);
      setFontSize(incrimentBenniesB);
      setFontSize(decrimentBenniesB);
   }
}