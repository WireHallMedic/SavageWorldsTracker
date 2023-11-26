package SavageWorldsTracker;

import javax.swing.*;
import java.awt.*;

public class SavageWorldsMain extends JFrame
{
   public SavageWorldsMain()
   {
      super();
      setSize(1000, 800);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new GridLayout(14, 1));
      setVisible(true);
   }
   
   public static void main(String[] args)
   {
      SavageWorldsMain swm = new SavageWorldsMain();
   }
}