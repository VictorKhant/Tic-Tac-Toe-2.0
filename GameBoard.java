public class GameBoard
{
    /**
     * method to print out the tic-tac-toe board
     * @param  twod
     * @param size
     */
    public static void printGameBoard(char [][] twod, int size)        //I used static to call easily in main multiple times
    {
        System.out.print("    ");                        //get some space for first line
        for(int i=1;i<=size;i++)                        //looping to print out columns
        {
            if(i>10)
            {
                System.out.print(i+"  ");
            }
            else
            {
                System.out.print(" " + i + "  ");
            }
        }
        System.out.println();

        for(int i=0;i<(size+1)*4;i++)                   //printing out boarder between each line
        {
            System.out.print("-");
        }
        System.out.println();
        for(int i=1;i<=size;i++)
        {
            if(i>=10)
            {
                System.out.print(i+" |");               //printing out the row numbers
            }
            else
            {
                System.out.print(" " + i + " |");
            }
            for(int j=0;j<size;j++)                     //print out the characters if any of the players chose
            {
                if( twod[i-1][j]!=0)
                {
                    System.out.print(" "+ twod[i-1][j]+" |");
                }
                else
                {
                    System.out.print("   |");           //print the space if the slot is empty
                }
            }
            System.out.println();
            for(int k=0;k<(size+1)*4;k++)
            {
                System.out.print("-");                  //printing out boarder between each line
            }
            System.out.println();
        }
    }
}
