/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceGame.game;

import diceGame.PayoutRules;
import java.util.Map;

/**
 * 
 * @author Sam Man
 * 
* <h1>Custom Dice Game</h1>
* This is a concrete class that extends the AbstractDiceGame class.
* This class is created using user input.
*/
public final class CustomDiceGame extends AbstractDiceGame{
    public CustomDiceGame(
        int startingTotal, int numberOfDice, int diceFaces, Map rules){
        super(startingTotal, numberOfDice, diceFaces);
        setPayoutRules(rules);
    }
    
    /**
   * This method takes rules specified by the user and creates an
   * instance of the PayourRules class, which contains those rules
   * @param rules This is a Map that contains the rules for the dice game.
   */
    @Override
    protected void setPayoutRules(Map rules){
        this.payoutRules = new PayoutRules(rules);
    }
}
