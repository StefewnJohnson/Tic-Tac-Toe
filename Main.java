/**
* Johnson_Stefewn_TicTacToe.java
* Description: In this game, the user will have the option to either play against the computer or an opponent. The user would be asked to enter a row and then column to where they want to place there X. When playing against the computer, the program will randomly generate the computer’s move. When playing against the opponent, the program will also ask for a row and column for the opponent to place there O. This program will require the use of several methods, checkRowWin, checkColumnWin, and checkDiagonal to see if the player (or computer) has won. There would also be a method to check if the game is a draw. Have a method that would check the space is available before you populate it. If it is not available, display an appropriate message and ask for a new input.
* Name: Stefewn Johnson
* Date created: June 10, 2021
* Date last modified: June 24, 2021
*/


// importing Scanner
import java.util.Scanner;


// class main
class Main {
// creating Scanner
  static Scanner input = new Scanner(System.in);
 // main method
  public static void main(String[] args) {
  // variables that are declared as strings
    String optionPicked, optionToPlayAgain;
    String playingAgainst = " ";
    String whoWon = " ";

 // an 2d array that is declared as an char
    char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
   // variables that are declared as int
    int totalGamesAgainstComputer = 0, totalGamesAgainstOpponent = 0, totalUserWins = 0, totalComputerWins = 0, totalUser1Wins = 0,totalUser2Wins = 0;
   // variables that are declared as double
    double winPercentageForUser = 0, winPercentageForComputer = 0, winPercentageForUser1 = 0, winPercentageForUser2 = 0;


   // Introducing the user and telling them how to play
   System.out.println("");
    System.out.println("Welcome to my game of Tic Tac Toe!!!");
   System.out.println("");
   System.out.println("To play this game, you would need to either play against a computer or an opponent. Next, you would need to enter an row and column to place your X and then the computer or opponent will choose a row that they would like to select and then a column to place their O. In order to win, you need an X or and O in 3 consecutive spots. For example, 3 consecutive spots that form a staight line that can be vertical, horizontal, or diagonal.");
   System.out.println("");


    do {

      do {
      // asking user what option they would like to play or if there want to quit
        System.out.println("1. Play against computer");
        System.out.println("2. Play against opponent");
        System.out.println("3. Quit");
       System.out.println("");
        System.out.print("Enter 1, 2, or 3: ");
        optionPicked = input.nextLine();

       // will tell the user that their input was invalid
       if(!optionPicked.equals("1") && !optionPicked.equals("2") && !optionPicked.equals("3")){
         System.out.println("Invalid answer.");
         System.out.println("");
       }
       // keep running until user picks option 1, 2, 3
      } while(!optionPicked.equals("1") && !optionPicked.equals("2") && !optionPicked.equals("3"));


     // Sets variable, playingAgainst to type of opponent that player will be facing.
      if(optionPicked.equalsIgnoreCase("1")) {
       // make playAgainst equal to computer
        playingAgainst = "computer";
        // add one to total number of games played against computer
        totalGamesAgainstComputer = totalGamesAgainstComputer + 1;
      }
     // Sets variable, playingAgainst to type of opponent that player will be facing.
      else if(optionPicked.equalsIgnoreCase("2")) {
       // make playAgainst equal to human
        playingAgainst = "human";
       // add one to total number of games played against opponent
        totalGamesAgainstOpponent = totalGamesAgainstOpponent + 1;
      }
     // quits game if option 3 is picked
      else if(optionPicked.equalsIgnoreCase("3")) {
       System.out.println("");
        System.out.println("You have chosen to quit the game. I hope you had a great time.");
        break;
      }
    // draw the board on the screen
    System.out.println("");
      board(board);


      // This do-while loop acts as the "game loop".
      do {
      System.out.println("");
        System.out.println("Player 1 turn:");

       //will break the loop and end game if user input is 4(4 is to quit)
        if(user1(board) == false) {
         // break out of loop
          break;
        }
       System.out.println("");
       // draw board on screen
        board(board);
      // checks if player 1 won
        if(checkRowWin(board) == true || checkColumnWin(board) == true || checkDiagonal(board) == true) {
         // makes whoWon equal to Player 1
          whoWon = "player 1";
         // break out of loop
          break;
        }
       // checks to see if there is a draw
        if(checkDraw(board)) {
         // makes whoWon equal to tie
          whoWon = "tie";
         // break out of loop
          break;
        }


       // if the user is playing against the computer then run computer method
        if(playingAgainst == "computer") {
         System.out.println("");
          System.out.println("*** Generating computer’s move ***");
         System.out.println("");
          computer(board);
        }

        // if the user is playing against a human then run user2 method
        else if(playingAgainst == "human") {
         System.out.println("");
         System.out.println("Player 2 turn");
        //will break the loop and end game if user input is 4(4 is to quit)
          if(user2(board) == false) {
            break;
          }
        }
       System.out.println("");
       // run the board method to show the update board
        board(board);
       // if any method is equal to true then player2 has the won the game
        if(checkRowWin(board) == true || checkColumnWin(board) == true || checkDiagonal(board) == true) {
         // make whoWon equal to player 2
          whoWon = "player 2";
         // break out of loop
          break;
        }
       // check to see if there is a draw
        if(checkDraw(board)){
         // make whoWon equal to tie
          whoWon = "tie";
          break;
        }


      } while(checkDraw(board) == false);
    System.out.println("");
     // if playingAgainst equals computer then run if statement
      if(playingAgainst.equalsIgnoreCase("computer")) {
        // if whoWon equals player 1 then player 1 won the and add one to totalUserWins
        if(whoWon.equalsIgnoreCase("player 1")) {
          System.out.println("Player 1 wins!");

          totalUserWins = totalUserWins + 1;
        }
       // else if whoWon equals computer then computer won the and add one to totalComputerWins
        else if(whoWon.equalsIgnoreCase("player 2")) {
          System.out.println("Computer wins!");

          totalComputerWins = totalComputerWins + 1;
        }
       // else if whoWon equals draw then the game is a draw
        else if(whoWon.equalsIgnoreCase("tie")) {

          System.out.println("It's a tie.");
        }
       // calculations for win percentage for user and computer
        winPercentageForUser = ((double)totalUserWins / totalGamesAgainstComputer) * 100;
        winPercentageForComputer = ((double)totalComputerWins / totalGamesAgainstComputer) * 100;


        System.out.println("Games played against computer: " + totalGamesAgainstComputer);
       System.out.println("");
        System.out.println("Amount of player wins against computer: " + totalUserWins);
        System.out.printf("Percentage of games player won against computer: %.2f%%\n" , winPercentageForUser);
       System.out.println("");
        System.out.println("Computer wins: " + totalComputerWins);
        System.out.printf("Percentage of games computer won: %.2f%%\n" , winPercentageForComputer);
      }

     // else if playingAgainst equals human then run if statement
      else if(playingAgainst.equalsIgnoreCase("human")) {
       // if whoWon equals player 1 then player 1 won the game and add 1 to totalUser1Wins
        if(whoWon.equalsIgnoreCase("player 1")) {
          System.out.println("Player 1 wins!");
          totalUser1Wins = totalUser1Wins + 1;
        }
      // else if whoWon equals player 2 then player 2 won the game and add 1 to totalUser2Wins
        else if(whoWon.equalsIgnoreCase("player 2")) {
          System.out.println("Player 2 wins!");
          totalUser2Wins = totalUser2Wins + 1;
        }
        // else if whoWon equals tie then the game is a draw
        else if(whoWon.equalsIgnoreCase("tie")) {
          System.out.println("It's a tie.");
        }
      // calculations for win percentage for user1 and user2
        winPercentageForUser1 = ((double) totalUser1Wins / totalGamesAgainstOpponent) * 100;
        winPercentageForUser2 = ((double) totalUser2Wins / totalGamesAgainstOpponent) * 100;


        System.out.println("Games played against HUMAN opponent: " + totalGamesAgainstOpponent);
       System.out.println("");
        System.out.println("Player 1 wins: " + totalUser1Wins);
        System.out.printf("Win percentage for player 1: %.2f%%\n" , winPercentageForUser1);
       System.out.println("");
        System.out.println("Player 2 wins: " + totalUser2Wins);
        System.out.printf("Win percentage for player 2: %.2f%%\n" , winPercentageForUser2);

      }
     System.out.println("");
      do {
       // ask the user if they want to play again
        System.out.print("Do you want to play again (yes or no): ");
        optionToPlayAgain = input.next();
        input.nextLine();
     // if yes then run if statement
        if(optionToPlayAgain.equalsIgnoreCase("yes")) {
          System.out.println("Let's play again!");
         System.out.println("");
       // reset the board to the spaces at every element
          for(int row = 0; row < board.length; row++) {
            for(int column = 0; column < board[0]. length; column++) {
              board[row][column] = ' ';
            }
          }


        }
      // else if the user doesn't type yes or no then tell the user that there answer is invalid
        else if(!optionToPlayAgain.equalsIgnoreCase("yes") && !optionToPlayAgain.equalsIgnoreCase("no")) {
          System.out.println("Invalid answer.");
         System.out.println("");
        }
      // keep running do while loop until optionToPlayAgain  equals yes or no
      } while((!optionToPlayAgain.equalsIgnoreCase("yes") && !optionToPlayAgain.equalsIgnoreCase("no")));
      // if optionToPlayAgain equals no then run if statement
     if(optionToPlayAgain.equalsIgnoreCase("no")){
         System.out.println("Thank you for playing. Have a nice day.");
     }
    // run the whole game again if optionToPlayAgain equals yes
    } while(optionToPlayAgain.equalsIgnoreCase("yes"));
  }


  /**
   * Method, user1 will allow player to input row and column. Method user1 will call other methods to validate user input. Method will return false if player wants to quit game otherwise return true.
   * @param board
   * returns true or false
   */


  public static boolean user1(char[][] board) {


  // variables that are declared as int
    int rowEntered, columnEntered = 0;


    do {
      do {
       // ask user 1 to enter a row and if they want to quit then enter 4
        System.out.print("Enter a row (1, 2, or 3) or enter 4 to quit the game: ");
        rowEntered = input.nextInt();
        input.nextLine();
       // run the checkRow method and if it is false then ask the user the same question
        if(checkRow(rowEntered) == false) {
          System.out.println("Invalid answer");
        }

      } while(checkRow(rowEntered) == false);


      // If variable, rowEntered has a value of 4, break out of the do-while loop.
      if(quit(rowEntered) == true) {
        break;
      }




      do {
       // ask user 1 to enter a column and if they want to quit then enter 4
        System.out.print("Enter a column (1, 2, or 3) or enter 4 to quit the game: ");
        columnEntered = input.nextInt();
        input.nextLine();
       // run the checkColumn method and if it is false then ask the user the same question
        if(checkColumn(columnEntered) == false) {
          System.out.println("Invalid answer");
        }
      } while (checkColumn(columnEntered) == false);


      // If variable, columnEntered has a value of 4, break out of the do-while loop.
      if(quit(columnEntered) == true) {
        break;
      }
    // run the if statement if the spotCheck method returns false
      if(spotCheck(rowEntered, columnEntered, board) == false){
        System.out.println("The spot is already taken. Please select another spot.");
      }
      // continue asking the user1 for row and a column until the spot they choose is avilable
    } while(spotCheck(rowEntered, columnEntered, board) == false);


  // if the rowEntered is between 1 to 3 and columnEntered is between 1 to 3 then run if statement
    if(rowEntered >= 1 && rowEntered <= 3 && columnEntered >= 1 && columnEntered <= 3) {
     // place X on the spot the user 1 wishes to choose and return true
      board[rowEntered - 1][columnEntered - 1] =  'X';
      return true;
    }
  // else return false
    else {
      return false;
    }


  }


 /**
   * Method, checkRow will check if the row is valid.  Method will return true if the row is valid otherwise return false.
   * @param rowEntered
   * returns true or false
   */


  public static boolean checkRow(int rowEntered){


// if the rowEntered is between 1 and 4 return true
    if(rowEntered >= 1 && rowEntered <= 4) {
      return true;
    }
  // else return false
    else {
      return false;
    }
  }


/**
   * Method, checkRowWin will check if the row is filled with the same symbols. Method will return true if the row is filled with the same symbols otherwise return false.
   * @param board
   * returns true or false
   */
  public static boolean checkRowWin(char[][] board) {
// variables that are declared as boolean
    boolean valid = false;
  // For loop used to access all elements of the array to check if a row has been filled with the same symbols
    for(int row = 0; row < board.length; row++) {
     // checks if row is filled with X symbols
      if(board[row][0] == 'X' && board[row][1] == 'X' && board[row][2] == 'X') {
        valid = true;
      }
     // checks if row is filled with O symbols
      if(board[row][0] == 'O' && board[row][1] == 'O' && board[row][2] == 'O') {
        valid = true;
      }
    }

    return valid;


  }




/**
   * Method, checkColumn will check if the column is valid.  Method will return true if the column is valid otherwise return false.
   * @param columnEntered
   * returns true or false
   */
  public static boolean checkColumn(int columnEntered) {


// if the columnEntered is between 1 and 4 return true
    if(columnEntered >= 1 && columnEntered <= 4) {
      return true;
    }
 // else return false
    else {
      return false;
    }


  }


/**
   * Method, checkColumnWin will check if the column is filled with the same symbols. Method will return true if the column is filled with the same symbols otherwise return false.
   * @param board
   * returns true or false
   */
  public static boolean checkColumnWin(char[][] board){


  // variables that are declared as boolean
    boolean valid = false;


  // For loop used to access all elements of the array to check if a column has been filled with the same symbols
    for(int column = 0; column < board[0].length; column++) {


    // checks if column is filled with X symbols
      if(board[0][column] == 'X' && board[1][column] == 'X' && board[2][column] == 'X') {
        valid = true;
      }
    // checks if column is filled with O symbols
      if(board[0][column] == 'O' && board[1][column] == 'O' && board[2][column] == 'O') {
        valid = true;
      }
    }
    return valid;
  }


/**
   * Method, checkDiagonal will check if the diagonal is filled with the same symbols. Method will return true if the diagonal is filled with the same symbols otherwise return false.
   * @param board
   * returns true or false
   */
  public static boolean checkDiagonal(char[][] board) {


    // if statements used to determine if a diagonal is filled with the same symbols (X or O), returns true if the diagonal is filled with the same symbols
    if(board[0][0] == 'X' &&  board[1][1] == 'X' && board[2][2] == 'X') {
      return true;
    }

    else if(board[2][0] == 'X' &&  board[1][1] == 'X' && board[0][2] == 'X') {
      return true;
    }

    else if(board[0][0] == 'O' &&  board[1][1] == 'O' && board[2][2] == 'O') {
      return true;
    }


    else if(board[2][0] == 'O' &&  board[1][1] == 'O' && board[0][2] == 'O') {
      return true;
    }


    else {
      return false;
    }


  }


/**
   * Method, spotCheck will check if the spot is avilable on the board. Method will return true if the spot is avilable otherwise return false.
   * @param rowEntered, columnEntered
   * returns true or false
   */
  public static boolean spotCheck(int rowEntered, int columnEntered, char[][] board) {


  // will check spot by going into the array and checking if that element in the array has a space that is avilable for the user to pick and will return true
    if(board[rowEntered - 1][columnEntered - 1] == ' ') {
      return true;
    }
  // else return false
    else {
      return false;
    }


  }


/**
   * Method, board will draw the board to the screen. Accesses array board to place symbols on board. Method will return nothing.
   * @param board
   * returns void
   */
  public static void board(char[][] board) {
   // prints the board and places the value of each element on it
    System.out.println("  1   2   3");
    System.out.println("1 "+ board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
    System.out.println(" ---|---|---");
    System.out.println("2 "+ board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
    System.out.println(" ---|---|---");
    System.out.println("3 "+ board[2][0] + " | " + board[2][1] + " | " + board[2][2]);


  }


/**
   * Method, user2 will allow player to input row and column. Method user2 will call other methods to validate user input. Method will return false if player wants to quit game otherwise return true.
   * @param board
   * returns true or false
   */


  public static boolean user2(char[][] board) {


   // variables that are declared as int
    int rowEntered, columnEntered = 0;


   // variables that are declared as boolean
    boolean rowCheck = true, columnCheck = true, spotCheck = true;


    do {
      do {
       // ask user 2 to enter a row and if they want to quit then enter 4
        System.out.print("Enter a row (1, 2, or 3) or enter 4 to quit the game: ");
        rowEntered = input.nextInt();
        input.nextLine();
       // run the checkRow method and if it is false then ask the user the same question
        if(rowCheck != checkRow(rowEntered)) {
          System.out.println("Invalid answer");
        }
      } while(rowCheck != checkRow(rowEntered));


    // If variable, rowEntered has a value of 4, break out of the do-while loop.
      if(quit(rowEntered) == true) {
        break;
      }


      do {
       // ask user 2 to enter a column and if they want to quit then enter 4
        System.out.print("Enter a column (1, 2, or 3) or enter 4 to quit the game: ");
        columnEntered = input.nextInt();
        input.nextLine();
       // run the checkColumn method and if it is false then ask the user the same question
        if(columnCheck != checkColumn(columnEntered)) {
          System.out.println("Invalid answer");
        }
      } while (columnCheck != checkColumn(columnEntered));


     // If variable, columnEntered has a value of 4, break out of the do-while loop.
      if(quit(columnEntered) == true) {
        break;
      }
   // run the if statement if the spotCheck method returns false
      if(spotCheck != spotCheck( rowEntered,  columnEntered, board)) {
        System.out.println("The spot is already taken. Please select another spot.");
      }
    // continue asking the user2 for row and a column until the spot they choose is avilable
    } while (spotCheck != spotCheck( rowEntered,  columnEntered, board));
  // if the rowEntered is between 1 to 3 and columnEntered is between 1 to 3 then run if statement
    if(rowEntered >= 1 && rowEntered <= 3 && columnEntered >= 1 && columnEntered <= 3) {
     // place O on the spot user  2 wishes to choose and return true
      board[rowEntered - 1][columnEntered - 1] =  'O';
      return true;
    }
 // else return false
    else {
      return false;
    }


  }


/**
   * Method, computer will allow computer to generate row and column. Method computer will call method spotCheck to validate computer input. Method will return nothing.
   * @param board
   * returns void
   */
  public static void computer(char[][] board) {


 // variables that are declared as int
    int rowGenerated, columnGenerated;

   // variables that are declared as boolean
    boolean rowCheck = true, columnCheck = true, spotCheck = true;


    do {
      do {
       // generates a random number between 1 to 3 and stores it into the variable rowGenerated
      rowGenerated = (int)((3 - 1 + 1)* Math.random() + 1);
      } while(rowGenerated < 1 || rowGenerated > 3);


      do {
       // generates a random number between 1 to 3 and stores it into the variable columnGenerated
        columnGenerated = (int)((3 - 1 + 1)* Math.random() + 1);
      } while (columnGenerated < 1 || columnGenerated > 3);
   // do while loop will keep generating a rowGenerated and columnGenerated until the spot is availableon the board by running the spotCheck method
    } while (spotCheck != spotCheck( rowGenerated,  columnGenerated, board));

    // will place an O on spot the computer would like to go
    board[rowGenerated - 1][columnGenerated - 1] =  'O';


  }


/**
   * Method, checkDraw will determine if the board is filled with symbols and if true then make the game draw and return true otherwise return false.
   * @param board
   * returns true or false
   */
  public static boolean checkDraw(char[][] board) {
   // variables that are declared as int
    int numSpaces = 0;
    // loop until row is not less then the board length
    for(int row = 0; row < board.length; row++) {
    // loop until column is not less then the board[0] length
      for(int column = 0; column < board[0].length; column++) {
      // if there is a space when checking the element then add 1 to numspaces
        if(board[row][column] == ' ') {
          numSpaces = numSpaces + 1;
        }
      }
    }
   // if the numSpaces in the board equals to zero then return true
    if(numSpaces == 0) {
      return true;
    }
   // else return false
    else {
      return false;
    }


  }
/**
   * Method, quit is used to determine if the user wants to quit the game. Returns true if user wants to quit game otherwise return false.
   * @param quit
   * returns true or false
   */
  public static boolean quit(int quit) {


 // if quit is equal to 4 then return true
    if(quit == 4) {
      return true;
    }
 // else return false
    else {
      return false;
    }
  }


}









