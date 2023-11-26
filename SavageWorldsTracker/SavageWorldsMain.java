package SavageWorldsTracker;

import javax.swing.*;
import java.awt.*;

public class SavageWorldsMain extends JFrame
{
   public static final int REGULAR_ROWS = 12;
   private SWTLabelPanel labelPanel;
   private SWTRow[] rowList;
   private SWTControlPanel controlPanel;
   private Deck deck;
   
   public SavageWorldsMain()
   {
      super();
      setSize(1200, 800);
      deck = new Deck();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new GridLayout(REGULAR_ROWS + 2, 1));
      
      labelPanel = new SWTLabelPanel();
      add(labelPanel);
      
      rowList = new SWTRow[REGULAR_ROWS];
      for(int i = 0; i < REGULAR_ROWS; i++)
      {
         rowList[i] = new SWTRow(deck);
         this.add(rowList[i]);
      }
      
      controlPanel = new SWTControlPanel(this);
      add(controlPanel);
      
      setVisible(true);
   }
   
   public void setSizes()
   {
      labelPanel.placeComponents();
      for(int i = 0; i< rowList.length; i++)
         rowList[i].placeComponents();
   }
   
   public void clearActed()
   {
      for(int i = 0; i < REGULAR_ROWS; i++)
         rowList[i].clearActed();
   }
   
   public void drawAll()
   {
      for(int i = 0; i < REGULAR_ROWS; i++)
      {
         if(rowList[i].isActive())
            rowList[i].draw();
      }
   }
   
   public void shuffle()
   {
      deck.shuffle();
   }
   
   public static void main(String[] args)
   {
      SavageWorldsMain swm = new SavageWorldsMain();
      swm.setSizes();
   }
}