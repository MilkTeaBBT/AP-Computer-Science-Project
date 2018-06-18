import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class GraphicsEngine extends Component
		implements ActionListener, MouseListener, MouseMotionListener, KeyListener {
	private Timer t;
	private Player p;
	private Enemy e;
	private Gaem loop;
	private Image back, exit;
	private boolean pause = false;

	public GraphicsEngine() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		back = new ImageIcon("src//Pictures//newbackground.jpg").getImage();
		exit = new ImageIcon("src//Pictures//images.png").getImage();
		p = new Player();
		e = new Enemy();
		loop = new Gaem(p, e);
		t = new Timer(10, this);
		t.start();
	}

	private void update() {
		// loop.gameLoop();
		repaint();
	}

	public void paint(Graphics g) {
		// g.fillRect(0, 0, this.getWidth(), this.getHeight());
		/*
		 * switch (loop.checkWin()) {
		 * 
		 * }
		 */
		g.drawImage(back, 0, 0, this.getWidth(), this.getHeight(), null);
		p.drawHand(g, this.getWidth());
		e.paint(g, getWidth());
		if (pause) {
			g.setColor(new Color(50, 50, 50, 150));
			g.fillRect(0, 0, getWidth(), getHeight());
			g.drawImage(exit, getWidth() / 2 - 200, getHeight() / 2 - 50, 400, 100, null);
		}
	}

	public void actionPerformed(ActionEvent e) {
		update();
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		if (!pause)
			p.hovering(e.getX(), e.getY(), this.getWidth());
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		if (pause && e.getX() > getWidth() / 2 - 200 && e.getY() > getHeight() / 2 - 50
				&& e.getX() < getWidth() / 2 + 200 && e.getY() < getHeight() / 2 + 50) {
			System.exit(0);
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (!pause)
			p.select(e.getX(), e.getY(), this.getWidth());
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("KEY");
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			pause = !pause;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
