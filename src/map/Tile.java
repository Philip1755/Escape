package map;

import java.awt.image.BufferedImage;

public class Tile {

    private BufferedImage sprite;

    private boolean collision;

    public Tile(BufferedImage sprite, boolean collision) {
        this.sprite = sprite;
        this.collision = collision;
    }

    // Getter and Setter

    public BufferedImage getSprite() {
        return sprite;
    }

    public boolean isCollision() {
        return collision;
    }

}