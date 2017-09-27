
import diceGame.Dice;
import diceGame.PlayerAccount;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam Man
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Dice dice;
        dice = new Dice(12);
        System.out.println(dice.roll());
        PlayerAccount pa = new PlayerAccount(100);
        System.out.println(pa.updateAccount(-1000));
        System.out.println(pa.getAccountBalance());
    }
    
}
