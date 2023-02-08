package display;

import java.awt.geom.Rectangle2D;
import java.util.Optional;

import entity.Entity;
import util.Constants;

public class Camera {

	private static Camera Instance;

	private Optional<Entity> objectWithFocus;

	private Rectangle2D.Float viewBounds;

	private float worldX, worldY;

	private Camera() {
		this.worldX = 0;
		this.worldY = 0;
		this.viewBounds = new Rectangle2D.Float(worldX, worldY, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
	}

	public static Camera get() {
		if (Camera.Instance == null)
			Camera.Instance = new Camera();

		return Camera.Instance;
	}

	public static void update() {
		if (get().objectWithFocus.isPresent()) {
			float objectPosX = get().objectWithFocus.get().getWorldX();
			float objectPosY = get().objectWithFocus.get().getWorldY();

			setX(objectPosX - (Constants.SCREEN_WIDTH / 2.0f));
			setY(objectPosY - (Constants.SCREEN_HEIGHT / 2.0f));

			clampWithinBounds();
			calculateViewBounds();
		}
	}

	private static void clampWithinBounds() {
		if (getX() < 0)
			setX(0);
		if (getY() < 0)
			setY(0);

		if (getX() + Constants.SCREEN_WIDTH > Constants.MAP_WIDTH)
			setX(Constants.MAP_WIDTH - Constants.SCREEN_WIDTH);
		if (getY() + Constants.SCREEN_HEIGHT > Constants.MAP_HEIGHT)
			setY(Constants.MAP_HEIGHT - Constants.SCREEN_HEIGHT);
	}

	private static void calculateViewBounds() {
		get().viewBounds = new Rectangle2D.Float(getX(), getY(), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
	}

	public static void focusOn(Entity entity) {
		get().objectWithFocus = Optional.of(entity);
	}

	// Getters and Setters

	public static float getX() {
		return get().worldX;
	}

	public static int getXInt() {
		return (int) get().worldX;
	}

	public static float getY() {
		return get().worldY;
	}

	public static int getYInt() {
		return (int) get().worldY;
	}

	public static void setX(float x) {
		get().worldX = x;
	}

	public static void setY(float y) {
		get().worldY = y;
	}

	public static Entity getObjectWithFocus() {
		return get().objectWithFocus.get();
	}

	public static Rectangle2D.Float getViewBounds() {
		return get().viewBounds;
	}
	
}
