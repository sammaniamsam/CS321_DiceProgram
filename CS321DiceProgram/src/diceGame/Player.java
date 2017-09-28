/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceGame;

import java.util.LinkedList;

/**
 * 
 * @author Sam Man
 * 
* <h1>Player</h1>
* This class stores and acts on all information pertaining to the
* amount of points ($cash$) that the player has.
*/
public class Player {
    PlayerAccount pa;
    LinkedList<Dice> dies;
    
   /**
   * This method assigns player account and dies to a player
   * @param dies LinkedList
   * @param startingTotal int
   */
    public Player(LinkedList<Dice> dies, int startingTotal){
        this.dies = dies;
        this.pa = new PlayerAccount(startingTotal);
    }
    
   /**
   * This method calls the roll() method for each Dice the
   * player has.
   * @param dies LinkedList
   */
    public void rollDice(LinkedList<Dice> dies){
        dies.forEach((die) -> {die.roll();});
    }
    
   /**
   * This method produces the roll total for a player
   * @return int
   */
    public int getRollTotal(){
        int total = 0;
        total = dies.stream().map((die) -> die.getRollVal())
            .reduce(total, Integer::sum);
        return total;
    }
    
   /**
   * This method updates a player's account.
   * @param payment int
   * @return boolean
   */
    public boolean updateAccount(int payment){
        boolean val = this.pa.updateAccount(payment);
        return val;
    }
    
   /**
   * This method outputs the player's account balance.
   */
    public void seeAccountBalance(){
        System.out.println("***************************");
        System.out.println("ACCOUNT BALANCE: " + this.pa.getAccountBalance());
        System.out.println("***************************");
    }
    
}
