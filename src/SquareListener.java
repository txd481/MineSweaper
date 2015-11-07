
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SquareListener implements ActionListener
{
    private MineModel model;
    private int row;
    private int col;
    /**
     * Listenes for the changes on the board
     * @param model The model of the game 
     * @param row The x coordinate of the cell
     * @param col The y coordinate of the cell
     */
    public SquareListener(MineModel model, int row, int col)
    {
        this.model = model;
        this.col = col;
        this.row = row;
    }
    /**
     * Performing the action
     * @param e 
     */
    public void actionPerformed(ActionEvent e)
    {
        model.turn(row, col);
    }
}


