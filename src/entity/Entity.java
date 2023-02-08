package entity;

import java.awt.Graphics2D;

public abstract class Entity {

	protected float worldX, worldY;
	protected float speed;
	
	protected int xDir, yDir;

	public Entity(float worldX, float worldY, float speed) {
		this.worldX = worldX;
		this.worldY = worldY;
		this.speed = speed;
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
