public class Player
{
    private String playerSymbols;       //String to hold unique character of players


    /**
     * default ctor for player class which initialize the string
     */
    public Player()
    {
        this.playerSymbols="";
    }

    /**
     * method to append the unique character of players to the string
     * @param uniqueChar
     */
    public void addChar(char uniqueChar)
    {
        playerSymbols=playerSymbols+uniqueChar;
    }

    /**
     * return true if character c is used by another player
     * @param c
     * @return
     */
    public boolean search(char c)
    {
        for(int i=0;i<playerSymbols.length();i++)               //looping through to check if char c is found in the list already or not
        {
            if(playerSymbols.charAt(i)==c)
            {
                return true;
            }
        }
        return false;
    }
    /**
     * method to return the unique character by using index
     * @param index
     * @return
     */
    public char getChar(int index)
    {
        return playerSymbols.charAt(index-1);                   //return the char at each player
    }


}

