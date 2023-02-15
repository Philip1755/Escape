package scene;

import game.Game;

import java.awt.Graphics2D;

public abstract class Scene {

    protected Game game;

    public Scene(Game game) {
        this.game = game;
    }

    public abstract void update();

    public abstract void render(Graphics2D g);
}

