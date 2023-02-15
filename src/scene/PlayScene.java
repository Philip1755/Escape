package scene;

import display.Camera;
import entity.Player;
import game.Game;

import java.awt.*;

public class PlayScene extends Scene {

    private Player player;

    public PlayScene(Game game) {
        super(game);
    }

    @Override
    protected void init() {
        player = new Player();
        Camera.focusOn(player);
    }

    @Override
    public void update() {
        player.update();

        Camera.update();
    }

    @Override
    public void render(Graphics2D g) {
        player.render(g);
    }
}
