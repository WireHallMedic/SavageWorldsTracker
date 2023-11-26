package SavageWorldsTracker;

import javax.swing.*;
import java.awt.*;

public class SavageWorldsMain extends JFrame
{
   public static final int REGULAR_ROWS = 12;
   private SWTLabelPanel labelPanel;
   private SWTRow[] rowList;
   
   public SavageWorldsMain()
   {
      super();
      setSize(1200, 800);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new GridLayout(REGULAR_ROWS + 2, 1));
      
      labelPanel = new SWTLabelPanel();
      add(labelPanel);
      
      rowList = new SWTRow[REGULAR_ROWS];
      for(int i = 0; i < REGULAR_ROWS; i++)
      {
         rowList[i] = new SWTRow();
         this.add(rowList[i]);
      }
      
      setVisible(true);
   }
   
   public void setSizes()
   {
      labelPanel.placeComponents();
      for(int i = 0; i< rowList.length; i++)
         rowList[i].placeComponents();
   }
   
   public static void main(String[] args)
   {
      SavageWorldsMain swm = new SavageWorldsMain();
      swm.setSizes();
   }
}