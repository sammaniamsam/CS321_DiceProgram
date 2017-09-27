
import diceGame.game.AdvancedDiceGame;
import diceGame.game.ClassicDiceGame;




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
        ClassicDiceGame cdg = new ClassicDiceGame();
        cdg.playGame();
        AdvancedDiceGame adg = new AdvancedDiceGame();
        adg.playGame();
    }
    
}
