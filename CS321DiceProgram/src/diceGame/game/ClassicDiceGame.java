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
 */
public final class ClassicDiceGame extends AbstractDiceGame {
    public ClassicDiceGame(){
        super(20, 2, 6);
        Map rules = createRules();
        setPayoutRules(rules);
    }
    
    private Map createRules(){
        Map<Integer,Integer> rules = new HashMap<>();
        rules.put(7, 5);
        rules.put(5, -5);
        rules.put(9, -5);
        rules.put(12, 10);
        return rules;
    }
    
    @Override
    protected void setPayoutRules(Map rules){
        this.payoutRules = new PayoutRules(rules);
    }
}
