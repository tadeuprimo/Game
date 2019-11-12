package  GameSession6;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bola {
	private static final int DIAMETRO = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Game game;

	public Bola(Game game) {
		this.game= game;
	}

	void mover() {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > game.getWidth() - DIAMETRO)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > game.getHeight() - DIAMETRO)
			game.gameOver();
		if (collision()){
			ya = -1;
			y = game.raquete.getTopY() - DIAMETRO;
		}
		x = x + xa;
		y = y + ya;
	}

	private boolean collision() {
		return game.raquete.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETRO, DIAMETRO);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETRO, DIAMETRO);
	}
}