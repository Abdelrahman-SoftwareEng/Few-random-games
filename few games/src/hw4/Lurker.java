package hw4;

import api.GameElement;

/**
 * Moving element associated with a Platform or Elevator. Optionally, a Lurker
 * can be given a nonzero horizontal velocity and it will oscillate between the
 * left and right edges of the Platform or Elevator.
 * 
 * @author Abdelrahman Mohamed
 */
public class Lurker extends Overrider {
	
	/**
	 * when a parent is set, this amount is added to the parent's x-coordinate to
	 * calculate this element's initial x-coordinate
	 */
	private int inOffset;
/**
 * To access the parent of this object
 */
	private MovingElement Parent ;
	
	
	/**
	 * Constructs a new Lurker. Before being added to a parent element such as a
	 * Platform or Elevator, the x and y coordinates are zero. When a parent element
	 * is set, the initial x-coordinate becomes the parent's x-coordinate, plus the
	 * given offset, and the y-coordinate becomes the parent's y-coordinate, minus
	 * this element's height.
	 * 
	 * @param width         element's width
	 * @param height        element's height
	 * @param initialOffset when a parent is set, this amount is added to the
	 *                      parent's x-coordinate to calculate this element's
	 *                      initial x-coordinate
	 */
	public Lurker(int width, int height, int initialOffset) {

		super(0, 0, width, height);
		inOffset = initialOffset;

	}

	/**
	 * Set's this element's parent. This element's x-coordinate becomes the parent's
	 * x-coordinate, plus the initial offset, and the y-coordinate becomes the
	 * parent's y-coordinate, minus this element's height.
	 * 
	 * @param p the parent of this object
	 */


	public void setParent(GameElement p) {

		Parent= (MovingElement) p;
		setBounds(p.getXReal(), p.getXReal() + p.getWidth());
		setPosition(p.getXReal() + inOffset, p.getYReal() - getHeight());

	}

	/**
	 * Updates this element's position to move horizontally according to its
	 * velocity (possibly zero) relative to the parent object, and remain "resting"
	 * on the parent object (provided that a parent has been set). Upon reaching the
	 * left or right boundary of the parent, the horizontal velocity is reversed.
	 */

	@Override
	public void update() {

		setBounds(Parent.getXReal(), Parent.getXReal() + Parent.getWidth());
		setPosition(Parent.getDeltaX() + getXReal(), Parent.getYReal() - getWidth());
		super.update();
		if (getXReal() <= getMin()) {
			setPosition(getMin(), getYReal());
			setVelocity(Math.abs(getDeltaX()), Math.abs(getDeltaY()));
		} else if (getXReal() + getWidth() >= getMax()) {
			setPosition(getMax() - getWidth(), getYReal());
			setVelocity( getDeltaX() *-1,  getDeltaY()*-1);
		}
	
	}

}

