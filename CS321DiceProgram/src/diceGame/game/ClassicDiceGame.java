/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceGame.game;

import diceGame.PayoutRules;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Sam Man
 * 
* <h1>Classic Dice Game</h1>
* This is a concrete class that extends the AbstractDiceGame class.
* This class is created using hard coded values and rules.
*/
public final class ClassicDiceGame extends AbstractDiceGame {
    public ClassicDiceGame(){
        super(20, 2, 6);
        Map rules = createRules();
        setPayoutRules(rules);
    }

   /**
   * This method creates rules for the Classic Dice Game.
   * @return Map Returns a map containing game rules
   */
    private Map createRules(){
        Map<Integer,Integer> rules = new HashMap<>();
        rules.put(7, 5);
        rules.put(5, -5);
        rules.put(9, -5);
        rules.put(12, 10);
        return rules;
    }
    
   /**
   * This method is to instantiate the PayourRules class
   * with the hard coded rules.
   * @param rules This is a Map of hard coded rules.
   */
    @Override
    protected void setPayoutRules(Map rules){
        this.payoutRules = new PayoutRules(rules);
    }
}
