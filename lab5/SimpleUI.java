package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);
    boolean input; 

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
      System.out.println("");
      System.out.println("House Cards: " + "\n" +  this.game.getHouseCards().toString());
      System.out.println("Your Cards:" +  "\n" + this.game.getYourCards().toString());
      System.out.println("NEXT");
    }

  @Override
    public boolean hitMe() {
       
        System.out.println("Would you like a hit? (Please enter 'y' or 'n')");
        
        String inputdata = user.nextLine();
        
        
        if (inputdata.contains("y")){
        
            input = true;
        }
        else if(inputdata.contains("n")){
            
            input = false;
        }
        else{
        System.out.println("Invalid Input, Please enter either 'y' or 'n'");
                hitMe();
        }
     
    return input;
        
    }

  @Override
    public void gameOver() {
       System.out.println("The House Score: " + game.score(game.getHouseCards()));
       System.out.println("Your Cards Score: " + game.score(game.getYourCards()));   
        
        
       int scores = game.score(game.getYourCards());
       int housescore = game.score(game.getHouseCards());
       
       if (scores == housescore){
           System.out.println("You Lose, House wins");
           
       }
       else if (scores > housescore && scores <= 21 && housescore <= 21){
        
           System.out.println("You win, Congratulations!");
       }
       
       else if(scores <= 21 && housescore > 21){
        
           System.out.println("You win, Congratulations!");
     
       }
       
       else if(scores > 21){
           System.out.println("You lose, House wins!");
       }
       else{
           System.out.println("You lose, House wins!");
       }  
    }

}