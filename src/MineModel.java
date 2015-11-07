
import java.util.Observable;

public class MineModel extends Observable
{
    private MineSweeper game;
    /**
     * Creating a model of the game
     * @param game The game
     */
    public MineModel(MineSweeper game)
    {
        super();
        this.game = game;
    }
    /**
 * Converting the bombs into "X" for the testing file
 * @return 
 */
    public String toString()
    {
        return game.toString();
    }
    /**
        * Creating new game
        */
    public void newGame()
    {
        game.newGame();
        setChanged();
	notifyObservers();
    }
    /**
         * Putting bombs on random places on the board
         */
    public void putBombs()
    {
        game.putBombs();
    }
        /**
         * Calculating the nearby bombs the sum of which will be placed on the board
         */
    public void putNumbers()
    {
        game.putNumbers();
    }
     /**
         * Getting the content of the cell
         * @param i The x coordinate of the cell
         * @param j The y coordinate of the cell
         * @return The content of the cell
         */
    public int get(int i, int j)
    {
        return game.get(i, j);
    }
      /**
         * Getting the content of the cell in the second board
         * @param i The x coordinate of the cell
         * @param j The y coordinate of the cell
         * @return The content of the cell
         */
    public int getFakeBoard(int i, int j)
    {
           return game.getFakeBoard(i, j);
    }
    
     /**
        * Putting the content of the first board into the second
        * @param i The x coordinate of the cell
        * @param j The y coordinate of the cell
       */
     public void turn(int i, int j)
    {
               game.turn(i, j);
               setChanged();
               notifyObservers();
    }
     /**
        * Cheching the state of reset
        * @return The state of reset
        */
    public boolean getReset(){
        return game.getReset();
    }
     /**
        * Putting new level for the game
        * @param level The number of bombs on the board
        */
     public void setLevel(int level)
       {
           game.setLevel(level);
           newGame();
       }
     /**
        * Checking if a cell from the real board is bomb and placing it on the fake board
        */
     public void reveal()
     {
         game.reveal();
         setChanged();
         notifyObservers();
     }
      /**
        * Checking the state of reveal
        * @return The state of reveal
        */
     public boolean getReveal()
     {
         return game.getReveal();
     }
      /**
        * Checking the level
        * @return The level
        */
      public int getLevel()
      {
          return game.getLevel();
      }
}
