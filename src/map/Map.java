package map;

import java.awt.Graphics2D;
import java.util.ArrayList;

import display.Camera;
import util.Constants;
import util.ImageLoader;

public class Map {

    private MapData data;

    private ArrayList<Tile> tiles;

    public Map() {
        data = new MapData();
        tiles = new ArrayList<>();

        loadSprites();
    }

    private void loadSprites() {
        //tiles.add(new Tile(ImageLoader.getSprite("tiles", "placeholder.png"), false));
    }

    public void render(Graphics2D g) {
        int cameraX = Camera.getXInt();
        int cameraY = Camera.getYInt();

        int xStart = Math.max(0, cameraX / Constants.TILE_SIZE - 2);
        int yStart = Math.max(0, cameraY / Constants.TILE_SIZE - 2);
        int xEnd = Math.min(cameraX / Constants.TILE_SIZE + Constants.SCREEN_WIDTH / Constants.TILE_SIZE + 2,
                Constants.MAX_WORLD_COL);
        int yEnd = Math.min(cameraY / Constants.TILE_SIZE + Constants.SCREEN_HEIGHT / Constants.TILE_SIZE + 2,
                Constants.MAX_WORLD_ROW);

        for (int y = yStart; y < yEnd; y++)
            for (int x = xStart; x < xEnd; x++)
                g.fillRect((x * Constants.TILE_SIZE) - Camera.getXInt(), (y * Constants.TILE_SIZE) - Camera.getYInt(), Constants.TILE_SIZE, Constants.TILE_SIZE);
//                g.drawImage(tiles.get(data.get(x, y)).getSprite(), (x * Constants.TILE_SIZE) - Camera.getXInt(),
//                        (y * Constants.TILE_SIZE) - Camera.getYInt(), Constants.TILE_SIZE, Constants.TILE_SIZE, null);
    }

    // Getter and Setter

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public int getData(int col, int row) {
        return data.get(col, row);
    }
}
