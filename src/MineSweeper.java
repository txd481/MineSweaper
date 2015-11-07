import java.util.Random;

public class MineSweeper 
{
	public static final int BOMB = -1;
	public static final int BLANK = 10;
	
	private int[][] board;
	private Random randomInt;
	private int level;
        private int[][] fakeBoard;
        private boolean reset;
        private boolean reveal;
        
/**
 * Creating the game
 * @param level The number of bombs placed on the board
 */	
	public MineSweeper(int level)
	{
		this.level = level;
		randomInt = new Random();
                fakeBoard = new int[10][10];
		board = new int[10][10];
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				board[i][j] = BLANK;
                                fakeBoard[i][j] = BLANK;
			}
		}
                putBombs();
		putNumbers();	
	}
/**
 * Converting the bombs into "X" for the testing file
 * @return 
 */	
	public String toString()
	{	
		int count=0;
		for(int i=0; i<10; i++)
		{
			for(int j=0; j<10; j++)
			{
				if(board[i][j]==BOMB)
				{	
					count++;
                                       
					System.out.print("X ");
				}
				if (board[i][j]!=BOMB)
				{
					System.out.print(board[i][j] + " ");
				}
			} System.out.println("");
		}
		System.out.println("The count is: " + count);
		return " ";
	}
       /**
        * Creating new game
        */
	public void newGame()
	{
                randomInt = new Random();
                fakeBoard = new int[10][10];
		board = new int[10][10];
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				board[i][j] = BLANK;
                                fakeBoard[i][j] = BLANK;
			}
		}
                reveal = false;
                reset = true;
                
		putBombs();
		putNumbers();	
	}
        /**
         * Putting bombs on random places on the board
         */
	public void putBombs()
	{
		System.out.println(level);
		for(int i=0; i<level; i++)
		{
			
			int x = 0;
			int y = 0;
			do
			{
				x = randomInt.nextInt(10);
				y = randomInt.nextInt(10);
			}
			while(board[x][y] == BOMB);
                        
                        //System.out.println("Putting a bomb");
			board[x][y] = BOMB;
			
		}
                
            
	}
	/**
         * Calculating the nearby bombs the sum of which will be placed on the board
         */
	public void putNumbers()
	{
		int count = 0;
		
		for(int i = 0; i<10; i++)
		{
			for(int j = 0; j<10; j++)
			{	
				count = 0;
				if(board[i][j] == BOMB)
				continue;
				if(i==0 && j==0)
				{
					if(board[i][j+1] == BOMB)
					{
						count++;
					}
					if(board[i+1][j] == BOMB)
					{
						count++;
					}
					if(board[i+1][j+1] == BOMB)
					{
						count++;
					}
					board[i][j] = count;
				}
				
				if(i==0 && j>0 && j<9)
				{
					if(board[i][j+1] == BOMB)
					{
						count++;
					}
					if(board[i][j-1] == BOMB)
					{
						count++;
					}
					if(board[i+1][j-1] == BOMB)
					{
						count++;
					}
					if(board[i+1][j] == BOMB)
					{
						count++;
					}
					if(board[i+1][j+1] == BOMB)
					{
						count++;
					}
					board[i][j] = count;
				}
				
				if(i==0 && j==9)
				{
					if(board[i][j-1] == BOMB)
					{
						count++;
					}
					if(board[i+1][j-1] == BOMB)
					{
						count++;
					}
					if(board[i+1][j] == BOMB)
					{
						count++;
					}
					board[i][j] = count;
				}
				
				if(i>0 && i<9 && j==9)
				{
					if(board[i][j-1] == BOMB)
					{
						count++;
					}
					if(board[i-1][j] == BOMB)
					{
						count++;
					}
					if(board[i-1][j-1] == BOMB)
					{
						count++;
					}
					if(board[i+1][j-1] == BOMB)
					{
						count++;
					}
					if(board[i+1][j] == BOMB)
					{
						count++;
					}
					board[i][j] = count;
				}
				
				if(i==9 && j==9)
				{
					if(board[i-1][j] == BOMB)
					{
						count++;
					}
					if(board[i-1][j-1] == BOMB)
					{
						count++;
					}
					if(board[i][j-1] == BOMB)
					{
						count++;
					}
					board[i][j] = count;
				}
				
				if(i==9 && j<9 && j>0)
				{
					if(board[i][j+1] == BOMB)
					{
						count++;
					}
					if(board[i][j-1] == BOMB)
					{
						count++;
					}
					if(board[i-1][j-1] == BOMB)
					{
						count++;
					}
					if(board[i-1][j] == BOMB)
					{
						count++;
					}
					if(board[i-1][j+1] == BOMB)
					{
						count++;
					}
					board[i][j] = count;
				}
				
				if(i==9 && j==0)
				{
					if(board[i][j+1] == BOMB)
					{
						count++;
					}
					if(board[i-1][j] == BOMB)
					{
						count++;
					}
					if(board[i-1][j+1] == BOMB)
					{
						count++;
					}
					board[i][j] = count;
				}
				
				if(i<9 && i>0 && j==0)
				{
					if(board[i][j+1] == BOMB)
					{
						count++;
					}
					if(board[i+1][j] == BOMB)
					{
						count++;
					}
					if(board[i-1][j] == BOMB)
					{
						count++;
					}
					if(board[i+1][j+1] == BOMB)
					{
						count++;
					}
					if(board[i-1][j+1] == BOMB)
					{
						count++;
					}
					board[i][j] = count;
				}
				
				if(i>0 && i<9 && j>0 && j<9)
				{
					if(board[i][j+1] == BOMB)
					{
						count++;
					}
					if(board[i][j-1] == BOMB)
					{
						count++;
					}
					if(board[i-1][j-1] == BOMB)
					{
						count++;
					}
					if(board[i-1][j] == BOMB)
					{
						count++;
					}
					if(board[i-1][j+1] == BOMB)
					{
						count++;
					}
					if(board[i+1][j-1] == BOMB)
					{
						count++;
					}
					if(board[i+1][j] == BOMB)
					{
						count++;
					}
					if(board[i+1][j+1] == BOMB)
					{
						count++;
					}
					board[i][j] = count;
				}
			}
		}
	} 
        /**
         * Getting the content of the cell
         * @param i The x coordinate of the cell
         * @param j The y coordinate of the cell
         * @return The content of the cell
         */
        public int get(int i, int j)
	{
		return board[i][j];
	}
        /**
         * Getting the content of the cell in the second board
         * @param i The x coordinate of the cell
         * @param j The y coordinate of the cell
         * @return The content of the cell
         */
       public int getFakeBoard(int i, int j)
       {
           return fakeBoard[i][j];
       }
       /**
        * Putting the content of the first board into the second
        * @param i The x coordinate of the cell
        * @param j The y coordinate of the cell
       */
       public void turn(int i, int j)
	{
               fakeBoard[i][j] = board[i][j];
	}
       /**
        * Cheching the state of reset
        * @return The state of reset
        */
       public boolean getReset()
       {
           return this.reset;
       }
       /**
        * Putting new level for the game
        * @param level The number of bombs on the board
        */
       public void setLevel(int level)
       {
           this.level = level;
           newGame();
       }
       /**
        * Checking if a cell from the real board is bomb and placing it on the fake board
        */
       public void reveal()
       {
           for(int i = 0; i<10; i++)
           {
               for(int j = 0; j<10; j++)
               {
                   if(board[i][j] == BOMB)
                   {
                        fakeBoard[i][j] = board[i][j];
                   }
               }
           }
           this.reveal = true;
       }
       /**
        * Checking the state of reveal
        * @return The state of reveal
        */
       public boolean getReveal()
       {
           return this.reveal;
       }
       /**
        * Checking the level
        * @return The level
        */
       public int getLevel()
       {
           return this.level;
       }
        
}
