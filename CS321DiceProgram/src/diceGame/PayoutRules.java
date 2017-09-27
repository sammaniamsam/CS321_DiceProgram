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
 */
public class PayoutRules {
    private final Map<Integer,Integer> rules;
    
    public PayoutRules(Map rules){
        this.rules = rules;
    }
    
    public int payout(int total){
        int payout = rules.get(total) == null ? 0 : rules.get(total);
        return payout;
    }
}
