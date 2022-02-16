package hw4;

import api.GameElement;

import java.util.ArrayList;

/**
 * An Elevator is a GameElement with two distinctive behaviors. First, it can be
 * set up to move vertically within a fixed set of boundaries. On reaching a
 * boundary, the y-component of its velocity is reversed. Second, it maintains a
 * list of <em>child</em> elements whose basic motion all occurs relative to the
 * Elevator.
 * 
 * @author Abdelrahman Mohamed
 */

public class Elevator extends MovingElement {
	/**
	 * list of children
	 */
	private ArrayList<GameElement> Children;
	/**
	 * upper boundary
	 */
	private double UpperBoundary;

	/**
	 * lower boundary
	 */
	private double LowerBoundary;

	/**
	 * Stores the first given deltaY that was given
	 */
	private double FirstDeltaY;

	/**
	 * Constructs a new Elevator. Initially the upper and lower boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	public Elevator(double x, double y, int width, int height) {
		super(x, y, width, height);
		Children = new ArrayList<>();
		FirstDeltaY = 0;
		UpperBoundary = Double.POSITIVE_INFINITY;
		LowerBoundary = Double.NEGATIVE_INFINITY;
	}

	/**
	 * Adds a child element to this Elevator, and sets this object to be the child's
	 * parent.
	 * 
	 * @param lurker a Lurker object to become a child of this Elevator
	 */
	public void addChild(Lurker lurker) {
		lurker.setParent(this);
		Children.add(lurker);
	}

	/**
	 * Adds a child element to this Elevator, and sets this object to be the child's
	 * parent.
	 * 
	 * @param charm a Charm object to become a child of this Elevator
	 */
	public void addChild(Charm charm) {
		charm.setParent(this);
		Children.add(charm);
	}

	/**
	 * Returns a list of all this Elevator's children.
	 * 
	 * @return list of children
	 */
	public ArrayList<GameElement> getChildren() {
		return Children;
	}

	/**
	 * Deletes all children that have been marked.
	 */
	public void deleteMarkedChildren() {
		for (int i = 0; i < Children.size(); i++) {
			if (Children.get(i).isMarked()) {
				Children.remove(i);
			}
		}

	}

	/**
	 * Sets the upper and lower boundaries for this Elevator's movement
	 * 
	 * @param min lower boundary
	 * @param max upper boundary
	 */
	public void setBounds(double min, double max) {
		UpperBoundary = max;
		LowerBoundary = min;
	}

	@Override
	public void setVelocity(double deltaX, double deltaY) {
		super.setVelocity(deltaX, deltaY);
		this.FirstDeltaY = deltaY;
	}

	/**
	 * Returns the lower boundary for this Elevator's movement.
	 * 
	 * @return lower boundary
	 */
	public double getMin() {
		return LowerBoundary;
	}

	/**
	 * Returns the upper boundary for this Elevator's movement.
	 * 
	 * @return upper boundary
	 */
	public double getMax() {
		return UpperBoundary;
	}

	/**
	 * Updates this element's state for a new frame, and additionally calls update
	 * on all its children.
	 */
	@Override
	public void update() {

		if (super.getYReal() + super.getDeltaY() >= getMax() - getHeight()) {
			super.setVelocity(super.getDeltaX(), getMax() - super.getHeight() - super.getYReal());
			super.update();
			super.setVelocity(super.getDeltaX(), FirstDeltaY * -1);
		} else if (super.getYReal() + super.getDeltaY() <= getMin()) {
			super.setVelocity(super.getDeltaX(), getMin() - super.getYReal());
			super.update();
			super.setVelocity(super.getDeltaX(), FirstDeltaY);
		} else {
			super.update();
		}

		for (int i = 0; i < getChildren().size(); i++) {
			getChildren().get(i).update();
		}
	}

}