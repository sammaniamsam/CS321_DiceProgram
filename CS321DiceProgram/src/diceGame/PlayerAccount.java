/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceGame;

/**
 *
 * @author Sam Man
 */
public class PlayerAccount {
    private int total;
    
    public PlayerAccount(int total){
        this.total = total;
    }
    
    public boolean updateAccount(int amount){
        if(this.total + amount > 0){
            this.total += amount;
        }
        else {
            return false;
        }
        return true;
    }
    
    public int getAccountBalance(){
        return this.total;
    }
}
