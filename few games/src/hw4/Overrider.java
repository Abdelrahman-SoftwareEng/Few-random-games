package hw4;

import api.GameElement;
import hw4.MovingElement;

/**
 * 
 * This abstract class is used to avoid duplication and to make it simpler. This
 * class is mostly used to connect both, lurker and the platform, together
 * without duplication.
 *
 * @author Abdelrahman Mohamed
 */

public abstract class Overrider extends MovingElement {
	
	/**
	 * left boundary
	 */
	private double LeftBound;

	/**
	 * right boundary
	 */
	private double RightBound;

	/**
	 * Constructs a MovingElement with a default velocity of zero in both
	 * directions.
	 *
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	public Overrider(double x, double y, int width, int height) {

		super(x, y, width, height);
		LeftBound= Double.NEGATIVE_INFINITY;
		RightBound= Double.POSITIVE_INFINITY;

	}

	/**
	 * Sets the left and right boundaries for this Platform's movement
	 * 
	 * @param min left boundary
	 * @param max right boundary
	 */
	public void setBounds(double min, double max) {
		LeftBound = min;
		RightBound = max;
	}

	/**
	 * Updates this element's position to move horizontally according to its
	 * velocity (possibly zero) relative to the parent object, and remain "resting"
	 * on the parent object (provided that a parent has been set). Upon reaching the
	 * left or right boundary of the parent, the horizontal velocity is reversed.
	 */
	@Override
	public void update() {

		super.update();
	
	}

	/**
	 * Returns the left boundary for this Platform's movement.
	 * 
	 * @return left boundary
	 */
	public double getMin() {
		return LeftBound;
	}

	/**
	 * Returns the right boundary for this Platform's movement.
	 * 
	 * @return right boundary
	 */
	public double getMax() {
		return RightBound;
	}

}

