
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tasnya
 */
public class MineSweeperGUI extends JFrame
{
    public static void main(String[] args)
    {
        int frameSize = 700;
        
        JFrame frame = new JFrame();
        frame.setSize(frameSize, frameSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Mine Sweeper is life");
        
        MineSweeper game = new MineSweeper(10);
        MineComponent comp = new MineComponent(game);
        
        frame.add(comp);
	frame.setVisible(true);
    }
}
