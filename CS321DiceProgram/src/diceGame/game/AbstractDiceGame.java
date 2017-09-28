/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceGame.game;

import diceGame.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author Sam Man
 * 
* <h1>Abstract Dice Game</h1>
* This is a abstract class that implements functionality that is extended by
* concrete classes.
*/
public abstract class AbstractDiceGame {
    Player player;
    PayoutRules payoutRules;
    LinkedList<Dice> dies;
    
   /**
   * This method sets all the class attributes.
   * @param startingTotal This is the players starting amount of money
   * @param numberOfDice This is the quantity of dies used in the game
   * @param diceFaces This is the number of faces on a die
   */
    public AbstractDiceGame(int startingTotal, int numberOfDice, int diceFaces){
        this.dies = new LinkedList<>();
        while(numberOfDice > 0){
            dies.add(new Dice(diceFaces));
            numberOfDice--;
        }
        this.player = new Player(this.dies, startingTotal);
    }
    
   /**
   * This method is overridden by all the concrete classes that
   * inherit from this abstract class.
   * @param rules This is a Map of the game rules.
   */
    protected abstract void setPayoutRules(Map rules);
    
   /**
   * This method is implements how a game is to be played.
   * And, this implementation of game play is inherited by all
   * concreted classes.
   */
    public void playGame(){
        boolean hasMoneyInAccount = true;
        while(hasMoneyInAccount && doesPlayerWantToContinue()){
            this.player.rollDice(dies);
            printDieValues();
            int payout = this.payoutRules.payout(this.player.getRollTotal());
            hasMoneyInAccount = this.player.updateAccount(payout);
            this.player.seeAccountBalance();
        }
        if(!hasMoneyInAccount){
            System.out.println("Sorry Charlie! You ran outa dough " + "\u2639");
        }
        System.out.println("GAME OVER");
    }
    
   /**
   * This method prompts the user to respond whether or not
   * they would like to continue playing the game.
   * @return boolean
   */
    private boolean doesPlayerWantToContinue(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type the letter 'Q' to quit");
        System.out.print("Type the letter 'R' to roll: ");
        char input = keyboard.next().charAt(0);
        return (input != 'Q') &&  (input != 'q');
    }
    
   /**
   * This method outputs the die values so that the user
   * can view what they have rolled.
   */
    private void printDieValues(){
        System.out.println("***************************");
        System.out.println("Die Values: ");
        dies.forEach((die) -> {
            System.out.println("* " + die.getRollVal());
        });
    }
}
