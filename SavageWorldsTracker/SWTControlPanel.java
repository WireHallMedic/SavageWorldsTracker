package SavageWorldsTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SWTControlPanel extends SWTRow implements SWTConstants, ActionListener
{
   private JButton newTurnB;
   private JButton drawAllB;
   private JButton clearActedB;
   private JButton shuffleB;
   private SavageWorldsMain parent;
   
   public SWTControlPanel(SavageWorldsMain p)
   {
      super();
      parent = p;
      setLayout(new GridLayout(1, 5));
      
      newTurnB = new JButton("New Turn");
      newTurnB.addActionListener(this);
      add(newTurnB);
      
      drawAllB = new JButton("Draw All");
      drawAllB.addActionListener(this);
      add(drawAllB);
      
      clearActedB = new JButton("Clear Acted");
      clearActedB.addActionListener(this);
      add(clearActedB);
      
      shuffleB = new JButton("Shuffle");
      shuffleB.addActionListener(this);
      add(shuffleB);
      
      for(Component c : this.getComponents())
      {
         c.setFocusable(false);
      }
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource() == newTurnB)
      {
         parent.clearActed();
         parent.drawAll();
      }
      if(ae.getSource() == clearActedB)
      {
         parent.clearActed();
      }
      if(ae.getSource() == drawAllB)
      {
         parent.drawAll();
      }
      if(ae.getSource() == shuffleB)
      {
         parent.shuffle();
      }
      setShuffleButtonText();
   }
   
   public void setShuffleButtonText()
   {
      String text = "Shuffle (" + parent.getDeckSize() + ")";
      shuffleB.setText(text);
   }
   
   public void placeComponents()
   {
      resizeFonts();
   }
   
   public void resizeFonts()
   {
      setFontSize(newTurnB);
      setFontSize(drawAllB);
      setFontSize(clearActedB);
      setFontSize(shuffleB);
   }
}