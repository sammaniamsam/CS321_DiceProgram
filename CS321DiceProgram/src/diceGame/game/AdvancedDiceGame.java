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
public final class AdvancedDiceGame extends AbstractDiceGame{
    public AdvancedDiceGame(){
        super(50, 3, 12);
        Map rules = createRules();
        setPayoutRules(rules);
    }
    
    private Map createRules(){
        Map<Integer,Integer> rules = new HashMap<>();
        rules.put(3, -45);
        rules.put(4, -25);
        rules.put(5, -25);
        rules.put(6, -25);
        rules.put(7, -25);
        rules.put(8, -25);
        rules.put(9, 10);
        rules.put(12, 10);
        rules.put(15, 10);
        rules.put(8, 10);
        rules.put(18, -15);
        rules.put(27, 25);
        rules.put(36, 70);
        return rules;
    }
    
    @Override
    protected void setPayoutRules(Map rules){
        this.payoutRules = new PayoutRules(rules);
    }
}
