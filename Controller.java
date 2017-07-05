/**
 * Created by zhiha on 2017/7/5.
 */

import java.awt.event.*;

class Controller implements MouseListener, KeyListener {

    Model model;

    Controller(Model model) {
        this.model = model;
    }

    // MouseListener Part
    public void mouseClicked(MouseEvent e) {
        System.exit(1);

    }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }

    // KeyListener Part
    public void keyPressed (KeyEvent e) {}
    public void keyReleased (KeyEvent e) {}
    public void keyTyped (KeyEvent e) {}
}
