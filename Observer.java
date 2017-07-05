
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

//加所有obstical
//加所有飞机
interface Observer {
    void update(Object observable);

}

class GamePlay extends JComponent implements Observer{
    private int FPS = 30;
    private Timer animationTimer;
    //在这里存放list of obstacles
    private LinkedList<Displayable> Obstacles = new LinkedList<Displayable>();

    private Player MyPlayer = new Player(400, 300, 50, this);
    //目前obs是事先定好的
    private Obstacle Obs1 = new Obstacle(820, 0, 850, 200);
    private Obstacle Obs2 = new Obstacle(900, 300, 920, 600);

    public GamePlay(Model model) {
        super(); //作用？？ 最后可以删掉！！！！！！！！！！！！！！！！！！！！！！！！
        //之后改为从file里面读取，决定player和obs的位置
        this.Obstacles.add(this.Obs1);
        this.Obstacles.add(this.Obs2);

        //整个JComponent需要加KeyListener, 暂时先不用controller
        this.setFocusable(true);
        this.requestFocusInWindow();
        MyKeyListener newKeyListener = new MyKeyListener();
        this.addKeyListener(newKeyListener);

        //动画更新part
        this.animationTimer = new Timer(1000/this.FPS, event -> {
            this.handleAnimation();
            this.repaint(); // note that we call repaint, not paintComponent
        });
        this.animationTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // 作用
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
        this.MyPlayer.move();//不知道对不对
        this.Obs1.move();
        this.Obs2.move();
    }


    //加keylistener控制player
    public class MyKeyListener implements KeyListener {
        public void keyPressed (KeyEvent e) {
        }
        public void keyReleased (KeyEvent e) {
        }
        public void keyTyped (KeyEvent e) {
        }
    }

    public void update(Object observable) {
        //什么也不干
    }
}



