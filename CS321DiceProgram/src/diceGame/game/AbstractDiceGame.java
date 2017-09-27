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
 */
public abstract class AbstractDiceGame {
    Player player;
    PayoutRules payoutRules;
    LinkedList<Dice> dies;
    
    public AbstractDiceGame(int startingTotal, int numberOfDice, int diceFaces){
        this.dies = new LinkedList<>();
        while(numberOfDice > 0){
            dies.add(new Dice(diceFaces));
            numberOfDice--;
        }
        this.player = new Player(this.dies, startingTotal);
    }
    
    protected abstract void setPayoutRules(Map rules);
    
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
    
    private boolean doesPlayerWantToContinue(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type the letter 'Q' to quit");
        System.out.print("Type the letter 'R' to roll: ");
        char input = keyboard.next().charAt(0);
        return (input != 'Q') &&  (input != 'q');
    }
    
    private void printDieValues(){
        System.out.println("***************************");
        System.out.println("Die Values: ");
        dies.forEach((die) -> {
            System.out.println("* " + die.getRollVal());
        });
    }
}
