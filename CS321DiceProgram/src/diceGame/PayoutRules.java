/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceGame;

import java.util.Map;

/**
 * 
 * @author Sam Man
 * 
* <h1>Payout Rules</h1>
* This class stores the rules of a dice game.
*/
public class PayoutRules {
    private final Map<Integer,Integer> rules;
    
   /**
   * This method assigns rules to the PayoutRules.
   * @param rules Map
   */
    public PayoutRules(Map rules){
        this.rules = rules;
    }
    
   /**
   * This method determines how much a player will be
   * paid (positive or negative) based upon the rules
   * @param total int
   * @return int
   */ 
    public int payout(int total){
        int payout = rules.get(total) == null ? 0 : rules.get(total);
        return payout;
    }
}
