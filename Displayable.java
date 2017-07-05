/**
 * Created by zhiha on 2017/7/4.
 */
import javax.swing.*;
import java.awt.*;

import static java.lang.Math.*;

public interface Displayable {
    void paint(Graphics g);
}

class Obstacle implements Displayable {
    private int tlx, tly, brx, bry;

    public Obstacle (int tlx, int tly, int brx, int bry) {
        this.tlx = tlx;
        this.tly = tly;
        this.brx = brx;
        this.bry = bry;
    }

    //暂时没有写move， 之后写
    public void move () {
        this.tlx -= 5;
        this.brx -= 5;
    }
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(this.tlx, this.tly, this.brx - this.tlx, this.bry - this.tly);
    }
}


class Player implements  Displayable {
    private int x, y, radius;
    private JComponent parent;

    public Player (int x, int y, int radius, JComponent parent) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.parent = parent;
    }

    //暂时没有写move， 之后写
    public void move () {

    }

    public Point getPosition() {
        return new Point(this.x + this.radius, this.y + this.radius);
    }

    //先暂定蓝色的player
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(this.x, this.y, 2 * this.radius, 2 * this.radius);
    }
}