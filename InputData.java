import java.util.Scanner;

public class InputData
{
  private int numOfPlayers;             //variable to store number of players
  private int pointConnect;             //pieces need to be connected to win the game
  private char[][] twod;                //Two d array to store the pieces of players
  private int size;                     //Size of two d array

  private final Player p;               //p object of class Player

    /**
     * default ctor for InputData class
     */
  InputData()
  {
      this.size=0;
      this.numOfPlayers=0;
      this.pointConnect=0;
      this.twod=new char[0][0];
      p=new Player();
  }

    /**
     * method to store characters of place in Player p object
     */
  private void setPlayer()
  {
      Scanner scan=new Scanner(System.in);                                          //scanner to get user input

      do {
          System.out.print("Enter the number of players (between 3-10):");
          if(scan.hasNextInt())                                                     //error handling from putting non integers
          {
              System.out.println();
              numOfPlayers=scan.nextInt();                                          //assigning number of players from user input
              if(numOfPlayers<3 || numOfPlayers>10)
              {
                  System.out.println("You entered invalid number. Try again!");    //error handling for out of the bound error
                  scan.nextLine();
              }
          }
          else
          {
              System.out.println("The item you enter is not an integer. Try again!");
              scan.nextLine();
          }

      }while(numOfPlayers<3 || numOfPlayers>10);

  }

    /**
     * method to get how many pieces needed to be connected to win from user
     */
  private void initializePoints()
  {
      Scanner scan = new Scanner(System.in);
      do
      {
          System.out.print("Enter the number of points need to be connected to win (between 3-" + size + "):");
          if(scan.hasNextInt())                                                                         //error handling from putting non integers
          {
              System.out.println();
              pointConnect=scan.nextInt();                                                              //assigning pieces needed to be connected
              if(pointConnect<3||pointConnect>size)                                                     //error handling for out of the bound error
              {
                  System.out.println("You entered invalid number. Try again!");
                  scan.nextLine();
              }
          }
          else
          {
              System.out.println("The item you enter is not an integer. Try again!");
              scan.nextLine();
          }

      }while (pointConnect<3||pointConnect>size);

  }

    /**
     * method to ask unique characters from user
     */
  private void setChar()
  {
      Scanner scan=new Scanner(System.in);
      for(int i=0;i<numOfPlayers;i++)                                                       //loop thorough to get chars from all players
      {
          System.out.print("Enter a unique character for Player "+(i+1)+":");
          if(!scan.hasNextInt())                                                            //error handling for putting non integer error
          {
              char c=scan.next().charAt(0);
              if(!p.search(c))                                                              //searching if a character is already chosen or not
              {
                  p.addChar(c);
              }
              else
              {
                  System.out.println("The character you chose has been taken. Try again!");
                  i--;
              }
              scan.nextLine();
          }
          else
          {
              System.out.println("You entered a number. Try again!");
              i--;
              scan.nextLine();
          }
      }
  }

    /**
     * method to get the row where the players want to put their characters
     * @return
     */
  public int getRow()
  {
      System.out.print("Please enter the row number: ");
      int num1=0;
      Scanner scan=new Scanner(System.in);
      do
      {
          if(scan.hasNextInt())                                                     //error handling for putting non integer error
          {
              System.out.println();
              num1=scan.nextInt();
              if(num1<1 || num1>size)                                               //error handing for out of bound errors
              {
                  System.out.print("You entered the invalid number. Try again!/nEnter valid row number:");
                  scan.nextLine();
              }
          }
          else {
              System.out.print("You didn't enter a number. Try again!/nEnter valid row number:");
              scan.nextLine();
          }
      }while (num1<1 || num1>size);
      return num1;

  }

    /**
     * method to get the column where the players want to put their characters
     * @return
     */
    public int getCol()
    {
        System.out.print("Please enter the column number: ");
        int num2=0;
        Scanner scan=new Scanner(System.in);
        do
        {
            if(scan.hasNextInt())                                                       //error handling for putting non integer error
            {
                System.out.println();
                num2=scan.nextInt();
                if(num2<1 || num2>size)                                                 ////error handling for out of bound errors
                {
                    System.out.print("You entered the invalid number. Try again! Enter valid column number:");
                    scan.nextLine();
                }
            }
            else {
                System.out.print("You didn't enter a number./nTry again! Enter valid column number:");
                scan.nextLine();
            }
        }while (num2<1 || num2>size);
        return num2;

    }

    /**
     * public method which can be used in tic-tac-toe
     */
    public void inputData()
  {
      boolean isGame=false;
      setPlayer();
      size=numOfPlayers+1;
      twod=new char[size][size];
      setChar();
      initializePoints();
      GameBoard.printGameBoard(twod,size);                                                              //printing game board at the beginning

      while(!isGame)
      {
          for(int i=1;i<=numOfPlayers;i++)                                                              //looping out all the players' turn
          {
              int row;
              int col;
              do {
                  System.out.println("Player "+i+"'s turn (char "+p.getChar(i)+").");
                  row=getRow()-1;
                  col=getCol()-1;
                  if(twod[row][col]!=0)                                                                 //check either the slot is free or not
                  {
                      System.out.println("Row:" + row + " Column: " + col + " is already taken. Try again!");
                  }
              }while
              (twod[row][col]!=0);
              twod[row][col]=p.getChar(i);
              GameBoard.printGameBoard(twod,size);                                                      //print game board after each player's turn
              GameLogic game=new GameLogic(size,pointConnect,twod);

              if(game.isTie()||game.isWin())                                                            //check whether the game is win or tie
              {
                  if(game.isWin()) {
                      System.out.println("Yay. We got the winner, It's player " + i + "! Thanks for playing.");
                  }
                  else {
                      System.out.println("Game over! It is a tie game. Thanks for playing.");
                  }
                  isGame=true;
                  break;                                                                                //stop the loop if the game is win or tie
              }

          }
      }
  }
}
