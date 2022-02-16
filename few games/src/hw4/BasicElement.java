package hw4;

import java.awt.Rectangle;

import api.GameElement;

/**
 * Minimal concrete extension of GameElement. The <code>update</code> method in
 * this implementation just increments the frame count.
 */

/**
 * My way to do this assignment is to keep it simple as possible. I tried my
 * best to extend as much classes as possible to avoid duplication. I overrode
 * methods that had to be overridden to avoid complication. I also created an
 * abstracted class to keep it as simple as possible.
 * 
 * @author Abdelrahman Mohamed
 *
 */
public class BasicElement extends GameElement {
	/**
	 *   x-coordinate of upper left corner
	 */
	private double x;
	/**
	 * y-coordinate of upper left corner
	 */
	private double y;
	/**
	 * element's width
	 */
	private int Width;
	/**
	 * element's height
	 */
	private int Height;
	/**
	 *  number of frames
	 */
	private int frameCount;
	/**
	 * true if this element has been marked for deletion
	 */
	private boolean isMark;

	/**
	 * Constructs a new BasicElement.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */

	public BasicElement(double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		Width = width;
		Height = height;
		isMark = false;
	}

	@Override
	public int getXInt() {

		return (int) Math.round(x);
	}

	@Override
	public int getYInt() {

		return (int) Math.round(y);
	}

	@Override
	public int getWidth() {

		return Width;
	}

	@Override
	public int getHeight() {

		return Height;
	}

	@Override
	public Rectangle getRect() {

		Rectangle rec = new Rectangle(getXInt(), getYInt(), Width, Height);

		return rec;
	}

	@Override
	public void setPosition(double newX, double newY) {

		x = newX;
		y = newY;

	}

	@Override
	public double getXReal() {

		return x;
	}

	@Override
	public double getYReal() {

		return y;
	}

	@Override
	public void update() {

		++frameCount;
	}

	@Override
	public boolean isMarked() {

		return isMark;
	}

	@Override
	public void markForDeletion() {

		isMark = true;

	}

	@Override
	public boolean collides(GameElement other) {

		return getRect().intersects(other.getRect());
	}

	@Override
	public int getFrameCount() {

		return frameCount;
	}

}
