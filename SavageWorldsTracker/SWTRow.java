package SavageWorldsTracker;

import javax.swing.*;
import java.awt.*;

public abstract class SWTRow extends JPanel implements SWTConstants
{   
   public SWTRow()
   {
      super();
   }
   
   protected int calcFontSize(JComponent c){return calcFontSize(c, false);}
   protected int calcFontSize(JComponent c, boolean useSmallFont)
   {
      int pixelSize = Math.min(c.getWidth(), c.getHeight());
      if(useSmallFont)
         pixelSize = (int)(pixelSize * SMALL_FONT_SCALE);
      else
         pixelSize = (int)(pixelSize * FONT_SCALE);
      return pixelSize;
   }
   
   protected void setFontSize(JComponent c){setFontSize(c, false);}
   protected void setFontSize(JComponent c, boolean useSmallFont)
   {
      Font f = new Font("Serif", Font.PLAIN, calcFontSize(c, useSmallFont));
      c.setFont(f);
   }
   
   public abstract void resizeFonts();
}