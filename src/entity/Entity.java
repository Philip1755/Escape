package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Entity {

	protected BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, idle1, idle2; 
	protected BufferedImage currentSprite;
	
	protected int spriteCounter;
	protected int spriteNum;
	protected float animationSpeed;
	
	protected float worldX, worldY;
	protected float speed;
	
	protected int xDir, yDir;

	public Entity(float worldX, float worldY, float speed) {
		this.worldX = worldX;
		this.worldY = worldY;
		this.speed = speed;
		this.xDir = 0;
		this.yDir = 0;
		this.spriteCounter = 0;
		this.spriteNum = 1;
		this.animationSpeed = 30f;
	}

	public abstract void update();

	public abstract void render(Graphics2D g);

	// Getter and Setter

	public float getWorldX() {
		return worldX;
	}

	public float getWorldY() {
		return worldY;
	}
	
	public int getWorldXInt() {
		return (int) worldX;
	}

	public int getWorldYInt() {
		return (int) worldY;
	}
}
