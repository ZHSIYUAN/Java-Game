
/**
 * An interface that allows an object to receive updates from the object
 * they listen to.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import static java.awt.image.BufferedImage.TYPE_3BYTE_BGR;
import java.awt.event.KeyListener;

//obstical
//aircraft
interface Observer {
    void update(Object observable);

}

class GamePlay extends JComponent implements Observer{
    private int FPS = 30;
    private Timer animationTimer;
    //list of obstacles
    private LinkedList<Displayable> Obstacles = new LinkedList<Displayable>();

    private Player MyPlayer = new Player(400, 300, 50, this);
    private Obstacle Obs1 = new Obstacle(820, 0, 850, 200);
    private Obstacle Obs2 = new Obstacle(900, 300, 920, 600);

    public GamePlay(Model model) {
        super(); 
        //read from files later
        this.Obstacles.add(this.Obs1);
        this.Obstacles.add(this.Obs2);

        //KeyListener
        this.setFocusable(true);
        this.requestFocusInWindow();
        MyKeyListener newKeyListener = new MyKeyListener();
        this.addKeyListener(newKeyListener);

        //Animation Part
        this.animationTimer = new Timer(1000/this.FPS, event -> {
            this.handleAnimation();
            this.repaint(); // note that we call repaint, not paintComponent
        });
        this.animationTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Image dBuff = new BufferedImage(this.getWidth(), this.getHeight(), TYPE_3BYTE_BGR);
        Graphics gBuff = dBuff.getGraphics();
        gBuff.setClip(0, 0, this.getWidth(), this.getHeight());
        gBuff.setColor(Color.ORANGE);
        gBuff.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (Displayable d : this.Obstacles) {
            d.paint(gBuff);
        }
        this.MyPlayer.paint(gBuff);
        g.drawImage(dBuff, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    private void handleAnimation() {
        this.MyPlayer.move();
        this.Obs1.move();
        this.Obs2.move();
    }


    //Implements KeyListener
    public class MyKeyListener implements KeyListener {
        public void keyPressed (KeyEvent e) {
        }
        public void keyReleased (KeyEvent e) {
        }
        public void keyTyped (KeyEvent e) {
        }
    }

    public void update(Object observable) {
        //nothing
    }
}



