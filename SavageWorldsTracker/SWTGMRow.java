package SavageWorldsTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SWTGMRow extends SWTRow implements SWTConstants, ActionListener
{
   private JTextField nameF;
   private JTextField benniesF;
   private JPanel benniesControlPanel;
   private JButton incrimentBenniesB;
   private JButton decrimentBenniesB;
   private int bennies;
   
   public SWTGMRow()
   {
      super();
      bennies = 0;
      setLayout(null);
      nameF = new JTextField("GM");
      nameF.setHorizontalAlignment(SwingConstants.CENTER);
      nameF.setEditable(false);
      add(nameF);
      benniesF = new JTextField("");
      benniesF.setHorizontalAlignment(SwingConstants.CENTER);
      benniesF.setEditable(false);
      add(benniesF);
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
      
      for(Component c : this.getComponents())
      {
         c.setFocusable(false);
      }
      incrimentBenniesB.setFocusable(false);
      decrimentBenniesB.setFocusable(false);
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
      
      nameF.setSize((int)(NAME_WIDTH * width), height);
      nameF.setLocation((int)(NAME_INSET * width), 0);
      
      benniesF.setSize((int)(BENNIES_WIDTH * width), height);
      benniesF.setLocation((int)(BENNIES_INSET * width), 0);
      
      benniesControlPanel.setSize((int)(BENNIES_MANIPULATION_WIDTH * width), height);
      benniesControlPanel.setLocation((int)(BENNIES_MANIPULATION_INSET * width), 0);
      
      resizeFonts();
   }
   
   public void resizeFonts()
   {
      setFontSize(nameF);
      setFontSize(benniesF);
      setFontSize(incrimentBenniesB);
      setFontSize(decrimentBenniesB);
   }
}