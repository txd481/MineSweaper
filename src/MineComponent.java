
import java.awt.BorderLayout;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tasnya
 */
public class MineComponent extends JPanel
{
    /**
     * Creating the component of the game
     * @param mineSweeper The game
     */
    public MineComponent(MineSweeper mineSweeper)
    {
        super();
        MineModel model = new MineModel(mineSweeper);
        BoardView view = new BoardView(model);
        ControlPanel panel = new ControlPanel(model);
        
        model.addObserver(view);
        setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }
    
}
