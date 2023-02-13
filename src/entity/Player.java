package entity;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import display.Camera;
import input.KeyHandler;
import util.Constants;
import util.ImageLoader;

public class Player extends Entity {

	public Player() {
		super(500, 500, 3.5f);

		loadSprites();
		currentSprite = idle1;
	}

	private void loadSprites() {
		up1 = ImageLoader.getSprite("player", "up_1.png");
		up2 = ImageLoader.getSprite("player", "up_2.png");
		down1 = ImageLoader.getSprite("player", "down_1.png");
		down2 = ImageLoader.getSprite("player", "down_2.png");
		left1 = ImageLoader.getSprite("player", "left_1.png");
		left2 = ImageLoader.getSprite("player", "left_2.png");
		right1 = ImageLoader.getSprite("player", "right_1.png");
		right2 = ImageLoader.getSprite("player", "right_2.png");
		idle1 = ImageLoader.getSprite("player", "idle_1.png");
		idle2 = ImageLoader.getSprite("player", "idle_2.png");
	}

	@Override
	public void update() {
		updatePosition();
		updateCurrentSprite();
	}

	private void updateCurrentSprite() {

		if (spriteCounter >= animationSpeed) {
			spriteNum = spriteNum == 1 ? 2 : 1;
			spriteCounter = 0;
		} else
			spriteCounter++;

		currentSprite = spriteNum == 1 ? idle1 : idle2;

		if (yDir < 0)
			currentSprite = spriteNum == 1 ? up1 : up2;
		if (yDir > 0)
			currentSprite = spriteNum == 1 ? down1 : down2;
		if (xDir < 0)
			currentSprite = spriteNum == 1 ? left1 : left2;
		if (xDir > 0)
			currentSprite = spriteNum == 1 ? right1 : right2;

	}

	private void updatePosition() {
		xDir = 0;
		yDir = 0;

		if (KeyHandler.isKeyPressed(KeyEvent.VK_W))
			yDir--;
		if (KeyHandler.isKeyPressed(KeyEvent.VK_A))
			xDir--;
		if (KeyHandler.isKeyPressed(KeyEvent.VK_S))
			yDir++;
		if (KeyHandler.isKeyPressed(KeyEvent.VK_D))
			xDir++;

		speed = xDir != 0 && yDir != 0 ? diagonalSpeed : normalSpeed;

		worldX += xDir * speed;
		worldY += yDir * speed;
		clampPosition();
	}

	private void clampPosition() {
		if (worldX - Constants.TILE_SIZE / 2 < 0)
			worldX = Constants.TILE_SIZE / 2;
		if (worldY - Constants.TILE_SIZE / 2 < 0)
			worldY = Constants.TILE_SIZE / 2;

		if (worldX + Constants.TILE_SIZE / 2 > Constants.MAP_WIDTH)
			worldX = Constants.MAP_WIDTH - Constants.TILE_SIZE / 2;
		if (worldY + Constants.TILE_SIZE / 2 > Constants.MAP_HEIGHT)
			worldY = Constants.MAP_HEIGHT - Constants.TILE_SIZE / 2;
	}

	@Override
	public void render(Graphics2D g) {
		renderPlayer(g);
	}

	private void renderPlayer(Graphics2D g) {
		g.drawImage(currentSprite, getWorldXInt() - Camera.getXInt() - Constants.TILE_SIZE / 2,
				getWorldYInt() - Camera.getYInt() - Constants.TILE_SIZE / 2, Constants.TILE_SIZE, Constants.TILE_SIZE,
				null);
	}

}
