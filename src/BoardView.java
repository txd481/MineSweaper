
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JOptionPane;

public class BoardView extends JPanel implements Observer
{
   private MineModel model; 
   private JButton[][] cell;
   /**
    * Creating the board view of the game
    * @param model The model of the game
    */
   public BoardView (MineModel model)
   {
       super();
       this.model = model;
       cell = new JButton [10][10];
       
       setLayout(new GridLayout(10, 10));
       for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				cell[i][j] = new JButton();
				cell[i][j].addActionListener(new SquareListener(model,i,j));
				add(cell[i][j]);
			}
		}
   }
   /**
    * Repainting the view
    * @param obs
    * @param obj 
    */
   public void update(Observable obs, Object obj)
   {
       int count = 0;
       if (model.getReset())
       {
           for (int i = 0; i < 10; i++)
           {
               for (int j = 0; j < 10; j++) 
               {
                   cell[i][j].setText("");
                  cell[i][j].setEnabled(true);
               }
           }
 
       }
      for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(model.getFakeBoard(i, j) != MineSweeper.BLANK)
                                {
                                    if(model.getFakeBoard(i, j) == MineSweeper.BOMB)
                                    {
                                        for(int g=0; g<10; g++)
                                        {
                                            for(int k=0; k<10; k++)
                                            {   
                                                if(model.get(g, k) == MineSweeper.BOMB) //only clicked cell gets X
                                                {
                                                    cell[g][k].setText("X");
                                                    cell[g][k].setEnabled(false);
                                                }
                                                else
                                                {
                                                    cell[g][k].setText(""+ model.get(g,k));
                                                    cell[g][k].setEnabled(false);
                                                }
                                            }
                                        }
                                    }
                                    else if(model.getFakeBoard(i, j) != MineSweeper.BOMB)
                                    {
                                        cell[i][j].setText("" + model.get(i,j));
                                        cell[i][j].setEnabled(false);
                                        count++;
                                    }
                                }
                                
			}
		}
      if(model.getReveal())
      {
          for(int i=0; i<10; i++)
          {
              for(int j = 0; j<10; j++)
              {
                   if(model.getFakeBoard(i, j) == MineSweeper.BOMB) //only clicked cell gets X
                    {//0,1
                        cell[i][j].setText("X");
                        cell[i][j].setEnabled(true);
                    }
                    else
                    {
                        cell[i][j].setText(""+ model.get(i,j));
                        cell[i][j].setEnabled(false);
                    }
              }
          }
      }
      if(count == 100-model.getLevel())
      {
          JOptionPane.showMessageDialog(null, "Congratulations! You won!");
      }
      
            repaint(); 
   }
}
