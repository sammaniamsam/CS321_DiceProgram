/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceGame;

import java.util.List;
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
    
    public int payout(List<Integer> rolls){
        int total = 0;
        total = rolls.stream().map((roll) -> roll).reduce(total, Integer::sum);
        int payout = rules.get(total);
        return payout;
    }
}
