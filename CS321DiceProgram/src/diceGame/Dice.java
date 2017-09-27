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
    private final int Faces;
    
    public Dice(int faces){
        this.Faces = faces;
    }
    
    public int roll(){
        Random rand = new Random();
        return rand.nextInt(this.Faces) + 1;
    }
    
}
