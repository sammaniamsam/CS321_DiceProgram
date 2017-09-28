/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceGame;

/**
 * 
 * @author Sam Man
 * 
* <h1>Player Account</h1>
* This class stores and acts on all information pertaining to the
* amount of points ($cash$) that the player has.
*/
public class PlayerAccount {
    private int total;
    
   /**
   * This method assigns the starting total to an account
   * @param total Int that is the amount the player starts with
   */
    public PlayerAccount(int total){
        this.total = total;
    }
    
   /**
   * This method updates an account with a positive or negative amount
   * @param amount the points (dollars) added to the account
   * @return boolean Successful updates return true
   */
    public boolean updateAccount(int amount){
        if(this.total + amount > 0){
            this.total += amount;
        }
        else {
            return false;
        }
        return true;
    }
    
   /**
   * This method outputs the account balance
   * @return int
   */
    public int getAccountBalance(){
        return this.total;
    }
}
