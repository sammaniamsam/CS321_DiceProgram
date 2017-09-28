/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceGame;

import java.util.Random;


/**
 * 
 * @author Sam Man
 * 
* <h1>Dice</h1>
* The Dice class has the ability to roll and store its face
* and roll values.
*/
public class Dice {
    private final int faces;
    private int rollVal;

   /**
   * This method is used to select and create the proper
   * game class instance.
   * @param faces This is an int that is the # of dice faces
   */
    public Dice(int faces){
        this.faces = faces;
    }
    
   /**
   * This method is used to roll the dice
   * and generate a random roll value.
   */
    public void roll(){
        Random rand = new Random();
        this.rollVal = rand.nextInt(this.faces) + 1;
    }
    
   /**
   * This method returns the most recent roll value
   * @return int Will be between 1 and face value.
   */
    public int getRollVal(){
        return this.rollVal;
    }
    
}
