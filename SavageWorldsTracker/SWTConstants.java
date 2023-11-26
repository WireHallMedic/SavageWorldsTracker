package SavageWorldsTracker;

public interface SWTConstants
{
   
   public static final double NAME_WIDTH = 0.3;
   public static final double CARDS_PER_TURN_WIDTH =.1;
   public static final double CARD_WIDTH = CARDS_PER_TURN_WIDTH + .1;
   public static final double BENNIES_WIDTH = CARD_WIDTH + .1;
   public static final double BENNIES_MANIPULATION_WIDTH = BENNIES_WIDTH + .05;
   public static final double HAS_ACTED_WIDTH = BENNIES_MANIPULATION_WIDTH + .05;
   
   public static final double NAME_INSET = 0.0;
   public static final double CARDS_PER_TURN_INSET = NAME_INSET + NAME_WIDTH;
   public static final double CARD_INSET = CARDS_PER_TURN_INSET +CARDS_PER_TURN_WIDTH;
   public static final double BENNIES_INSET = CARD_INSET + CARD_WIDTH;
   public static final double BENNIES_MANIPULATION_INSET = BENNIES_INSET + BENNIES_WIDTH;
   public static final double HAS_ACTED_INSET = BENNIES_MANIPULATION_INSET + BENNIES_MANIPULATION_WIDTH;
}