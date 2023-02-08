package input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {

	private static KeyHandler Instance;

	private boolean[] keyPressed = new boolean[128];

	private KeyHandler() {
	}

	public static KeyHandler get() {
		if (KeyHandler.Instance == null)
			KeyHandler.Instance = new KeyHandler();

		return KeyHandler.Instance;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() >= get().keyPressed.length)
			return;
		
		get().keyPressed[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() >= get().keyPressed.length)
			return;
		
		get().keyPressed[e.getKeyCode()] = false;
	}

	// Getter and Setter

	public static boolean isKeyPressed(int keyCode) {
		if (keyCode >= get().keyPressed.length)
			return false;
		
		return get().keyPressed[keyCode];
	}
}