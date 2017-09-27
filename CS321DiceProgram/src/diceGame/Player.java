/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceGame;

import java.util.LinkedList;

/**
 *
 * @author Sam Man
 */
public class Player {
    PlayerAccount pa;
    LinkedList<Dice> dies;
    
    public Player(LinkedList<Dice> dies, int startingTotal){
        this.dies = dies;
        this.pa = new PlayerAccount(startingTotal);
    }
    
    public void rollDice(LinkedList<Dice> dies){
        dies.forEach((die) -> {die.roll();});
    }
    
    public int getRollTotal(){
        int total = 0;
        total = dies.stream().map((die) -> die.getRollVal())
            .reduce(total, Integer::sum);
        return total;
    }
    
    public boolean updateAccount(int payment){
        boolean val = this.pa.updateAccount(payment);
        return val;
    }
    
    public void seeAccountBalance(){
        System.out.println("***************************");
        System.out.println("ACCOUNT BALANCE: " + this.pa.getAccountBalance());
        System.out.println("***************************");
    }
    
}
