package game;

import util.Constants;

public class GameLoop implements Runnable {

	private Game game;

	private boolean running = true;

	public GameLoop(Game game) {
		this.game = game;
		new Thread(this).start();
	}

	@Override
	public void run() {

		double renderInterval = 1E9 / Constants.FPS;
		double updateInterval = 1E9 / Constants.UPS;

		double deltaF = 0;
		double deltaU = 0;

		long lastTime = System.nanoTime();
		long currentTime = 0;

		long timer = 0;
		int renderCount = 0;
		int updateCount = 0;

		while (running) {

			currentTime = System.nanoTime();

			deltaF += (currentTime - lastTime) / renderInterval;
			deltaU += (currentTime - lastTime) / updateInterval;
			timer += (currentTime - lastTime);

			lastTime = currentTime;

			if (deltaF >= 1) {
				game.getDisplay().repaint();
				renderCount++;
				deltaF--;
			}
			
			if (deltaU >= 1) {
				game.update();
				updateCount++;
				deltaU--;
			}
			
			if(timer >= 1E9) {
				System.out.println("FPS: " + renderCount + " | UPS: " + updateCount);
				renderCount = 0;
				updateCount = 0;
				timer = 0;
			}
			
		}

	}

}
