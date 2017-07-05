import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class MainView extends JFrame implements Observer {

    private Model model;
    /**
     * Create a new View.
     */
    public MainView(Model model) {
        // Set up the window.
        this.setTitle("Siyuan's Game");
        this.setMinimumSize(new Dimension(128, 128));
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel amd button
        JPanel panel = new JPanel();
        JButton button = new JButton("Start New Game");

        //button mouse event
         MyMouseAdapter newMouseAdapter = new MyMouseAdapter(model); 
        button.addMouseListener(newMouseAdapter);
        //button.addMouseMotionListener(newAdapter); 

        // add panel to the window
        panel.add(button);
        this.add(panel);

        // Hook up this observer so that it will be notified when the model
        // changes.
        this.model = model;
        model.addObserver(this);
        setVisible(true);
    }



    //create a custom adapter from MouseAdapter base class
    static class MyMouseAdapter extends MouseAdapter {
        Model model;
        MyMouseAdapter(Model model) {
            this.model = model;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            //System.exit(1);
            //MyMap GameMap = new MyMap();
            GamePlay c = new GamePlay(this.model);
            JFrame frame = new JFrame("Game Play View");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(1,1));
            frame.setContentPane(c);
            frame.setSize(800, 600);
            frame.setVisible(true);
        }
    }

    //Update with data from the model.
    public void update(Object observable) {
        // XXX Fill this in with the logic for updating the view when the model changes.
        //System.out.println("Model changed! Siyuan Updates the View in MainView.java");
    }
}

