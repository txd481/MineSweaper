
import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class ControlPanel extends JPanel {
    protected JButton exitButton = null;
    protected JButton resetGame = null;
    protected JRadioButton rbButtonLevelEasy = null;
    protected JRadioButton rbButtonLevelMed = null;
    protected JRadioButton rbButtonLevelHard = null;
    protected JPanel radioButtonsContainer = null;
    protected JButton revealBombs = null;
    protected MineModel model = null;
    protected JLabel ifWon = null;
    /**
     * Creating the buttons on the frame and the appropriate actions
     * @param model The model of the game
     */
    public ControlPanel(MineModel model){
        super();
        this.model = model;
        
        this.exitButton = new JButton("Exit");
        this.exitButton.addActionListener(e -> System.exit(0));
        
        this.resetGame = new JButton("New Game") ;
        this.resetGame.addActionListener(e->model.newGame());
        this.radioButtonsContainer = new JPanel();
        
        this.revealBombs = new JButton("Reveal");
        this.revealBombs.addActionListener(e -> model.reveal());
        
        this.rbButtonLevelEasy = new JRadioButton("easy");
        this.rbButtonLevelEasy.addActionListener(e->model.setLevel(10));
        this.rbButtonLevelMed = new JRadioButton("medium");
        this.rbButtonLevelMed.addActionListener(e->model.setLevel(15));
        this.rbButtonLevelHard = new JRadioButton("hard"); 
        this.rbButtonLevelHard.addActionListener(e->model.setLevel(20));
        
     
        ButtonGroup group = new ButtonGroup();
        group.add(rbButtonLevelEasy);
        group.add(rbButtonLevelMed);
        group.add(rbButtonLevelHard);
        
        add(resetGame);
        add(exitButton);
        add(revealBombs);
        add(rbButtonLevelEasy);
        add(rbButtonLevelMed);
        add(rbButtonLevelHard);
        

       
        
        
        
        
    }

    
    
}
