package input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

	private static MouseHandler Instance;

	private float xPos, yPos;
	private float deltaX, deltaY;
	private boolean[] mouseButtonPressed = new boolean[3];
	private boolean isDragging;

	private MouseHandler() {
	}

	public static MouseHandler get() {
		if (MouseHandler.Instance == null)
			MouseHandler.Instance = new MouseHandler();

		return MouseHandler.Instance;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() > get().mouseButtonPressed.length)
			return;

		get().mouseButtonPressed[e.getButton() - 1] = true;
		get().xPos = e.getX();
		get().yPos = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() > get().mouseButtonPressed.length)
			return;

		get().mouseButtonPressed[e.getButton() - 1] = false;
		get().isDragging = false;
		get().deltaX = 0;
		get().deltaY = 0;
		get().xPos = e.getX();
		get().yPos = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		get().xPos = e.getX();
		get().yPos = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		get().isDragging = true;
		get().deltaX = e.getX() - get().xPos;
		get().deltaY = e.getY() - get().yPos;
	}

	// Getters and Setters

	public static float getXScreen() {
		return get().xPos;
	}

	public static float getYScreen() {
		return get().yPos;
	}

//	public static float getXWorld() {
//		return get().xPos + Camera.getX();
//	}
//
//	public static float getYWorld() {
//		return get().yPos + Camera.getY();
//	}

	public static float getDeltaX() {
		return get().deltaX;
	}

	public static float getDeltaY() {
		return get().deltaY;
	}

	public static boolean isDragging() {
		return get().isDragging;
	}

	public static boolean mouseButtonDown(int button) {
		if (button > get().mouseButtonPressed.length)
			return false;

		return get().mouseButtonPressed[button - 1];
	}

}