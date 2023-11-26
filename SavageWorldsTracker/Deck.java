package SavageWorldsTracker;

import java.util.*;

public class Deck
{
   public static final String[] SUIT_LIST = {"S", "H", "D", "C"};
   public static final String[] VALUE_LIST = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
   private Vector<String> cardList;
   private int curIndex;
   
   public Deck()
   {
      createCardList();
      shuffle();
   }
   
   public String draw()
   {
      if(curIndex >= cardList.size())
         shuffle();
      curIndex += 1;
      return cardList.elementAt(curIndex - 1);
   }
   
   private void createCardList()
   {
      cardList = new Vector<String>();
      for(String suit : SUIT_LIST)
      for(String value : VALUE_LIST)
      {
         cardList.add(value + suit);
      }
      cardList.add("Red Joker");
      cardList.add("Black Joker");
   }
   
   public void shuffle()
   {
      Vector<String> newList = new Vector<String>();
      while(cardList.size() > 0)
      {
         curIndex = (int)(Math.random() * cardList.size());
         newList.add(cardList.elementAt(curIndex));
         cardList.removeElementAt(curIndex);
      }
      cardList = newList;
   }
   
   public void print()
   {
      for(int i = 0; i < cardList.size(); i++)
      {
         System.out.print(cardList.elementAt(i) + " ");
         if(i % 14 == 0 && i != 0)
            System.out.println("");
      }
   }
   
   public static void main(String[] args)
   {
      Deck d = new Deck();
      System.out.println(d.draw());
      System.out.println(d.draw());
      System.out.println(d.draw());
      d.print();
      d.shuffle();
      System.out.println("");
      System.out.println(d.draw());
      System.out.println(d.draw());
      System.out.println(d.draw());
      d.print();
      for(int i = 0; i < 100; i++)
         d.draw();
   }
}