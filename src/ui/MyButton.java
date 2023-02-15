package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import input.MouseHandler;

public class MyButton {

    private Font font;
    private String text;
    private float textX, textY;

    private Rectangle bounds;
    private boolean hover;

    public MyButton(String text, int screenX, int screenY, int width, int height) {
        this.text = text;
        this.textX = 0;
        this.textY = 0;
        this.font = new Font("Monospaced", Font.PLAIN, 20);
        this.bounds = new Rectangle(screenX - width / 2, screenY - height / 2, width, height);
    }

    public void update() {
        hover = bounds.contains(MouseHandler.getXScreen(), MouseHandler.getYScreen());
    }

    public void render(Graphics2D g) {
        g.setColor(hover ? Color.darkGray : Color.lightGray);
        g.fill(bounds);

        g.setColor(Color.black);
        g.setStroke(new BasicStroke(3));
        g.draw(bounds);

        g.setColor(hover ? Color.white : Color.black);
        g.setFont(font);
        textX = (float) (bounds.getX()
                + ((bounds.getWidth() / 2.0f) - (g.getFontMetrics().getStringBounds(text, g).getWidth() / 2.0f)));
        textY = (float) (bounds.getY() + (bounds.getHeight() / 2.0f) + (g.getFontMetrics().getHeight() / 2.0f) - 7f);
        g.drawString(text, textX, textY);
    }

    // Getter and Setter

    public boolean isHover() {
        return hover;
    }

}
