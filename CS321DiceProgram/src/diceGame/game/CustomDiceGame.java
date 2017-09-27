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
 */
public final class CustomDiceGame extends AbstractDiceGame{
    public CustomDiceGame(
        int startingTotal, int numberOfDice, int diceFaces, Map rules){
        super(startingTotal, numberOfDice, diceFaces);
        setPayoutRules(rules);
    }
    
    @Override
    protected void setPayoutRules(Map rules){
        this.payoutRules = new PayoutRules(rules);
    }
}
