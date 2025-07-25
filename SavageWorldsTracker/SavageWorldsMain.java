package SavageWorldsTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SavageWorldsMain extends JFrame implements ComponentListener
{
   public static final int REGULAR_ROWS = 12;
   private SWTLabelPanel labelPanel;
   private SWTCharacterRow[] characterRowList;
   private SWTGMRow gmRow;
   private SWTControlPanel controlPanel;
   private Deck deck;
   
   public String getDeckSize(){return deck.getSizeString();}
   
   public SavageWorldsMain()
   {
      super();
      setSize(1400, 800);
      setTitle("Savage Worlds Tracker");
      deck = new Deck();
      deck.shuffle();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new GridLayout(REGULAR_ROWS + 3, 1));
      
      labelPanel = new SWTLabelPanel();
      add(labelPanel);
      
      characterRowList = new SWTCharacterRow[REGULAR_ROWS];
      for(int i = 0; i < REGULAR_ROWS; i++)
      {
         characterRowList[i] = new SWTCharacterRow(deck, this);
         add(characterRowList[i]);
      }
      
      gmRow = new SWTGMRow();
      add(gmRow);
      
      controlPanel = new SWTControlPanel(this);
      add(controlPanel);
      addComponentListener(this);
      
      setShuffleButtonText();
      
      setVisible(true);
      setSizes();
   }
   
   public void setSizes()
   {
      labelPanel.placeComponents();
      controlPanel.placeComponents();
      for(int i = 0; i< characterRowList.length; i++)
         characterRowList[i].placeComponents();
      gmRow.placeComponents();
   }
   
   public void setShuffleButtonText()
   {
      controlPanel.setShuffleButtonText();
   }
   
   public void clearActed()
   {
      for(int i = 0; i < REGULAR_ROWS; i++)
         characterRowList[i].clearActed();
   }
   
   public void clearCards()
   {
      for(int i = 0; i < REGULAR_ROWS; i++)
         characterRowList[i].clearCard();
   }
   
   public void drawAll()
   {
      for(int i = 0; i < REGULAR_ROWS; i++)
      {
         if(characterRowList[i].isActive())
            characterRowList[i].draw();
         else
            characterRowList[i].clearCard();
      }
   }
   
   public void shuffle()
   {
      deck.shuffle();
   }
   
   public void componentHidden(ComponentEvent ce){}
   public void componentMoved(ComponentEvent ce){}
   public void componentShown(ComponentEvent ce){}
   public void componentResized(ComponentEvent ce)
   {
      setSizes();
   }
   
   public static void main(String[] args)
   {
      SavageWorldsMain swm = new SavageWorldsMain();
      try
      {
         Thread.sleep(250);
      }
      catch(InterruptedException ex){}
      swm.setSizes();
   }
}