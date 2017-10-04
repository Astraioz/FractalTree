package main;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static main.Settings.*;

public class Fractal extends JPanel {
    
    private JFrame jf;
    private FractalThread thread;

    public Fractal() {
        super();
        jf = new JFrame();
        jf.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        jf.getContentPane().add(this);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
        
        thread = new FractalThread(this);
    }
    
    public void start() {
        thread.start();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        // empty
    }
    
    public void nextStep() {
        
    }
    
    public boolean isDone() {
        return true;
    }
    
    

    
}
