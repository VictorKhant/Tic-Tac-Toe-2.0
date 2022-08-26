public class GameLogic
{
    private final int size;                 //variable to store the size of the board
    private final int pointConnect;         //pieces need to be connected to win the game
    private final char[][] twod;            //two D array to store the characters of the game

    /**
     * 3args ctor for GameLogic which assign private variables
     * @param twodSize
     * @param pointNeed
     * @param twoD
     */
    GameLogic(int twodSize,int pointNeed, char[][] twoD)
    {
        this.size= twodSize;
        this.pointConnect=pointNeed;
        this.twod=twoD;
    }

    /**
     * method to check either a player is won or not from all direction
     * @return
     */
    public boolean isWin()
    {
        //rows and cols for horizontal check;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size-pointConnect+1;j++)
            {
                int counter1=0;
                for(int k=0;k<pointConnect;k++)                         //looping for the times need to be consecutive to win
                {
                    if((twod[i][j]!=0)&&(twod[i][j]==twod[i][j+k]))
                    {
                        counter1++;
                    }
                }
                if(counter1==pointConnect)                              //counter to check if the pieces are connected enough to win
                {
                    return true;
                }
            }
        }

        //rows and cols for vertical check;
        for(int i=0;i<size-pointConnect+1;i++)
        {
            for(int j=0;j<size;j++)
            {
                int counter2=0;
                for(int k=0;k<pointConnect;k++)                     //looping for the times need to be consecutive to win
                {
                    if((twod[i][j]!=0)&&(twod[i][j]==twod[i+k][j]))
                    {
                        counter2++;
                    }
                }
                if(counter2==pointConnect)                          //counter to check if the pieces are connected enough to win
                {
                    return true;
                }
            }
        }

        //rows and cols for right diagonal
        for(int i=0;i<size-pointConnect+1;i++)
        {
            for(int j=0;j<=size-pointConnect;j++)
            {
                int counter3=0;
                for(int k=0;k<pointConnect;k++)                     //looping for the times need to be consecutive to win
                {
                    if((twod[i][j]!=0)&&(twod[i][j]==twod[i+k][j+k]))
                    {
                        counter3++;
                    }
                }
                if(counter3==pointConnect)                          //counter to check if the pieces are connected enough to win
                {
                    return true;
                }
            }
        }

        //rows and cols for left diagonal
        for(int i=0;i<=size-pointConnect;++i)
        {
            for(int j=size-1;j>=pointConnect-1;--j)
            {
                int counter4=0;
                for(int k=0;k<pointConnect;k++)                     //looping for the times need to be consecutive to win
                {
                    if((twod[i][j]!=0)&&(twod[i][j]==twod[i+k][j-k]))
                    {
                        counter4++;
                    }
                }
                if(counter4==pointConnect)                          //counter to check if the pieces are connected enough to win
                {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * method to check either the game is tie or not
     * @return
     */
    public boolean isTie()
    {
        for(int i=0;i<size;++i)                 //loop to go through all the columns
        {
            for (int j=0;j<size;++j)            //loop to go through all the rows
            {
                if(twod[i][j]==0)
                {
                    return false;               //if any of the slots in empty, return false
                }
            }
        }
        return true;
    }
}
