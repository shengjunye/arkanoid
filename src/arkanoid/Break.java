package arkanoid;

import java.awt.*;

public class Break {

	private int x;
	private int y;
	private int width;
	private int height;
	
	public Break(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(this.x,this.y,this.width,this.height);
	}
	
	public int getUnderY() {
		return this.y + this.height;
	}
	
	public int getRightX() {
		return this.x + this.width;
	}
	
    public void paint(Graphics2D _graphics2D){
        _graphics2D.fillRect(x,y,width,height);
    }
}
