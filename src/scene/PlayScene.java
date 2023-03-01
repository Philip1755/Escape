package scene;

import display.Camera;
import entity.Player;
import game.Game;
import map.Map;

import java.awt.*;

public class PlayScene extends Scene {

    private Map map;
    private Player player;

    public PlayScene(Game game) {
        super(game);

        map = new Map();
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
        map.render(g);
        player.render(g);
    }
}
