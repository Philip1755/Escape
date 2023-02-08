package util;

public class Constants {

	public static final int SCALE = 6;
	
	public static final int DEFAULT_TILE_SIZE = 16;
	public static final int TILE_SIZE = DEFAULT_TILE_SIZE * SCALE;
	
	public static final int MAX_SCREEN_COL = 16;
	public static final int MAX_SCREEN_ROW = 9;
	
	public static final int SCREEN_WIDTH = MAX_SCREEN_COL * TILE_SIZE;
	public static final int SCREEN_HEIGHT = MAX_SCREEN_ROW * TILE_SIZE;
	
	public static final int FPS = 120;
    public static final int UPS = 100;

    public static final int MAX_WORLD_COL = 50;
	public static final int MAX_WORLD_ROW = 50;
	
	public static final int MAP_WIDTH = MAX_WORLD_COL * TILE_SIZE;
	public static final int MAP_HEIGHT = MAX_WORLD_ROW * TILE_SIZE;
}
