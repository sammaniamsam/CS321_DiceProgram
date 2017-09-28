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
 * 
* <h1>Game Selector</h1>
* The Game Selector selects a dice game to create based
* upon user input.
*/
public class GameSelector {
    AbstractDiceGame game;
    
    public GameSelector(){
        int selection = promptUserToSelectGame();
        selectGame(selection);
    }
    
   /**
   * This method is used to select and create the proper
   * game class instance.
   * @param selection User input as an integer type.
   * @return Nothing.
   */
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

   /**
   * This method prompts the user to select a game
   * of their choice
   * @param Nothing.
   * @return int the int is associated to
   * the selected game.
   */
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
    
   /**
   * This method is used to create a custom dice game:
   * 1) Number of dies
   * 2) Number of dice faces
   * 3) Starting amount for a player
   * 4) Rules for the dice game
   */
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
        System.out.print("How much money would you like to start with : ");
        int startingTotal = keyboard.nextInt();
        System.out.println("***************************");
        System.out.println("SET RULES FOR THE GAME YOU'D LIKE TO PLAY");
        System.out.println("Enter a pair of comma separated positive integers");
        System.out.println("Example: 10, 30 --- this means, if your roll(s)");
        System.out.println("total 10 the payout is $30 ");
        System.out.println("Enter your rules then type 'D' for done");
        System.out.println("***************************" + "\n");
        Map<Integer, Integer> rules = new HashMap<>();
        boolean condition = true;
        String input;
        String[] ints;
        keyboard.nextLine();
        while(condition) {
            condition = false;
            System.out.print("Enter a rule or 'D': ");
            input = keyboard.nextLine();
            if(input.length() > 1) {
                ints = input.split(",\\s*");
                int key = Integer.parseInt(ints[0]);
                int val = Integer.parseInt(ints[1]);
                rules.put(key, val);
                condition = true;
            }
        }
        game = new CustomDiceGame(
            startingTotal, numberOfDice, diceFaces, rules);
    }
    
   /**
   * This method calls the playGame() method of
   * the game instance that was created.
   */
    public void runSelectedGame(){
        game.playGame();
    }
}
