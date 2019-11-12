package GameSession6;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Raquete {
	private static final int Y = 330;
	private static final int LARGURA = 60;
	private static final int ALTURA = 10;
	int x = 0;
	int xa = 0;
	private Game game;

	public Raquete(Game game) {
		this.game = game;
	}

	public void mover() {
		if (x + xa > 0 && x + xa < game.getWidth() - LARGURA)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, LARGURA, ALTURA);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 1;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, Y, LARGURA, ALTURA);
	}

	public int getTopY() {
		return Y;
	}
}