package SavageWorldsTracker;

public interface SWTConstants
{
   public static final double CLEAR_WIDTH = .05;
   public static final double NAME_WIDTH = 0.3;
   public static final double BENNIES_WIDTH = .1;
   public static final double BENNIES_MANIPULATION_WIDTH = .04;
   public static final double CARDS_PER_TURN_WIDTH =.1;
   public static final double DRAW_BUTTON_WIDTH = .1;
   public static final double CARD_WIDTH = .2;
   public static final double HAS_ACTED_WIDTH = .1;
   
   public static final double CLEAR_INSET = 0.0;
   public static final double NAME_INSET = CLEAR_INSET + CLEAR_WIDTH;
   public static final double BENNIES_INSET = NAME_INSET + NAME_WIDTH;
   public static final double BENNIES_MANIPULATION_INSET = BENNIES_INSET + BENNIES_WIDTH;
   public static final double CARDS_PER_TURN_INSET = BENNIES_MANIPULATION_INSET + BENNIES_MANIPULATION_WIDTH;
   public static final double DRAW_BUTTON_INSET = CARDS_PER_TURN_INSET + CARDS_PER_TURN_WIDTH;
   public static final double CARD_INSET = DRAW_BUTTON_INSET + DRAW_BUTTON_WIDTH;
   public static final double HAS_ACTED_INSET = CARD_INSET + CARD_WIDTH;
   
   public static final double FONT_SCALE = .6;
   public static final double SMALL_FONT_SCALE = .5;
}

