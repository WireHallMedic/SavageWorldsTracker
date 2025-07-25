package SavageWorldsTracker;

import javax.swing.*;
import java.awt.*;

public class SWTLabelPanel extends SWTRow implements SWTConstants
{
   private JLabel nameL;
   private JLabel cardsPerTurnL;
   private JLabel drawBL;
   private JLabel cardL;
   private JLabel benniesL;
   private JLabel hasActedL;
   private JLabel shakenL;
   
   public SWTLabelPanel()
   {
      super();
      setLayout(null);
      nameL = new JLabel("Name", SwingConstants.CENTER);
      add(nameL);
      cardsPerTurnL = new JLabel("# Cards", SwingConstants.CENTER);
      add(cardsPerTurnL);
      drawBL = new JLabel("");
      add(drawBL);
      cardL = new JLabel("Card", SwingConstants.CENTER);
      add(cardL);
      benniesL = new JLabel("Bennies", SwingConstants.CENTER);
      add(benniesL);
      hasActedL = new JLabel("Acted", SwingConstants.CENTER);
      add(hasActedL);
      shakenL = new JLabel("Shaken", SwingConstants.CENTER);
      add(shakenL);
      
      for(Component c : this.getComponents())
      {
         c.setFocusable(false);
      }
   }
   
   public void placeComponents()
   {
      int width = getWidth();
      int height = getHeight();
      
      nameL.setSize((int)(NAME_WIDTH * width), height);
      nameL.setLocation((int)(NAME_INSET * width), 0);
      
      cardsPerTurnL.setSize((int)(CARDS_PER_TURN_WIDTH * width), height);
      cardsPerTurnL.setLocation((int)(CARDS_PER_TURN_INSET * width), 0);
      
      drawBL.setSize((int)(DRAW_BUTTON_WIDTH * width), height);
      drawBL.setLocation((int)(DRAW_BUTTON_INSET * width), 0);
      
      cardL.setSize((int)(CARD_WIDTH * width), height);
      cardL.setLocation((int)(CARD_INSET * width), 0);
      
      benniesL.setSize((int)(BENNIES_WIDTH * width), height);
      benniesL.setLocation((int)(BENNIES_INSET * width), 0);
      
      hasActedL.setSize((int)(HAS_ACTED_WIDTH * width), height);
      hasActedL.setLocation((int)(HAS_ACTED_INSET * width), 0);
      
      shakenL.setSize((int)(SHAKEN_WIDTH * width), height);
      shakenL.setLocation((int)(SHAKEN_INSET * width), 0);
      
      resizeFonts();
   }
   
   public void resizeFonts()
   {
      setFontSize(nameL);
      setFontSize(cardsPerTurnL);
      setFontSize(drawBL);
      setFontSize(cardL);
      setFontSize(benniesL);
      setFontSize(hasActedL);
      setFontSize(shakenL);
   }
}