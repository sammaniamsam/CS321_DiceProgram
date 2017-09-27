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
 */
public class Dice {
    private final int faces;
    private int rollVal;
    
    public Dice(int faces){
        this.faces = faces;
    }
    
    public void roll(){
        Random rand = new Random();
        this.rollVal = rand.nextInt(this.faces) + 1;
    }
    
    public int getRollVal(){
        return this.rollVal;
    }
    
}
