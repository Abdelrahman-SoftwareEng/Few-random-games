package hw4;

import api.GameElement;

import java.util.ArrayList;

/**
 * A Platform is a GameElement with two distinctive behaviors. First, it can be
 * set up to move horizontally within a fixed set of boundaries. On reaching a
 * boundary, the x-component of its velocity is reversed. Second, it maintains a
 * list of <em>child</em> elements whose basic motion all occurs relative to the
 * Platform.
 * 
 * @author Abdelrahman Mohamed
 */
public class Platform extends Overrider {

	/**
	 * list of children
	 */
	private ArrayList<GameElement> Children;

	/**
	 * Constructs a new Platform. Initially the left and right boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	public Platform(double x, double y, int width, int height) {
		super(x, y, width, height);

		Children = new ArrayList<>();
	}

	/**
	 * Adds a child object to this Platform, and sets this object to be the child's
	 * parent.
	 * 
	 * @param charm a Charm object to become a child of this platform
	 */
	public void addChild(Charm charm) {
		charm.setParent(this);
		Children.add(charm);
	}

	/**
	 * Adds a child object to this Platform, and sets this object to be the child's
	 * parent.
	 * 
	 * @param lurker a Lurker object to become a child of this platform
	 */
	public void addChild(Lurker lurker) {
		lurker.setParent(this);
		Children.add(lurker);
	}

	/**
	 * Returns a list of all this Platform's children.
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
	 * Updates this object's state for a new frame, and additionally calls update on
	 * all its children.
	 */
	@Override
	public void update() {
		
		super.update();
		
		if (getXReal() <= getMin()) {
			setPosition(getMin(), getYReal());
			setVelocity(Math.abs(getDeltaX()), Math.abs(getDeltaY()));
		} else if (getXReal() + getWidth() >= getMax()) {
			setPosition(getMax() - getWidth(), getYReal());
			setVelocity( getDeltaX() *-1,  getDeltaY()*-1);
		}
	
		for (int i = 0; i < Children.size(); i++) {
			Children.get(i).update();
		}
	}

}