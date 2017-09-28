/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diceGame;

import diceGame.game.AbstractDiceGame;
import diceGame.game.AdvancedDiceGame;
import diceGame.game.ClassicDiceGame;
import diceGame.game.CustomDiceGame;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Sam Man
 */
public class GameSelector {
    AbstractDiceGame game;
    
    public GameSelector(){
        int selection = promptUserToSelectGame();
        selectGame(selection);
    }
    
    private void selectGame(int selection){
        switch (selection){
            case 1 :
                game = new ClassicDiceGame(); break;
            case 2 :
                game = new AdvancedDiceGame(); break;
            case 3 :
                createCustomGame(); break;
            default :
                System.out.println("!!You entered an incorrect value!!");
                selection = promptUserToSelectGame();
                selectGame(selection);
        }
    }
    
    private int promptUserToSelectGame(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Select the type of game you want");
        System.out.println("by number (type '1', '2', or '3'): ");
        System.out.println("1)--Classic dice game");
        System.out.println("2)--Advanced dice game");
        System.out.println("3)--Custom dice game");
        System.out.print("\nEnter number: ");
        int input = keyboard.nextInt();
        return input;
    }
    
    private void createCustomGame(){
        System.out.println("***************************");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a positive integer (1, 2, 3, etc.)");
        System.out.print("How many die would you like to use: ");
        int numberOfDice = keyboard.nextInt();
        System.out.println("***************************");
        System.out.println("Enter a positive integer (1, 2, 3, etc.)");
        System.out.print("How many faces will the die(s) have: ");
        int diceFaces = keyboard.nextInt();
        System.out.println("***************************");
        System.out.println("Enter a positive integer (10, 20, 30, etc.)");
        System.out.print("How much money woul you like to start with : ");
        int startingTotal = keyboard.nextInt();
        System.out.println("***************************");
        System.out.println("SET RULES FOR THE GAME YOU'D LIKE TO PLAY");
        System.out.println("Enter a pair of comma separated positive integers");
        System.out.println("Example: 10, 30 --- this means, if your roll(s)");
        System.out.println("total 10 the payout is $30 ");
        System.out.print("Enter your rules then type 'D' for done");
        Map<Integer, Integer> rules = new HashMap<>();
        char done = 'a'; //initialized to char other than 'D'
        while(ifNotDone(done)) {
        System.out.print("Enter a rule or 'D': ");
            int key = keyboard.nextInt();
            int val = keyboard.nextInt();
            //done = keyboard.next().charAt(0);
            if(ifNotDone(done)){
                rules.put(key, val);
            }
        }
        game = new CustomDiceGame(
            startingTotal, numberOfDice, diceFaces, rules);
    }
    
    private boolean ifNotDone(char done){
        return done != 'D' && done != 'd';
    }
    
    public void runSelectedGame(){
        game.playGame();
    }
}
