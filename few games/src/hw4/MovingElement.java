package hw4;

import api.GameElement;

/**
 * Concrete implementation of GameElement in which the <code>update</code>
 * method updates the position each frame according to a <em>velocity</em> 
 * vector (deltaX, deltaY).  The units are assumed to be "pixels per frame".
 * 
 * @author Abdelrahman Mohamed
 */

public class MovingElement extends BasicElement
{
	/*
	 * horizontal velocity
	 */
	private double dX;
	
	/*
	 * vertical velocity
	 */
	private double dY;
	

  /**
   * Constructs a MovingElement with a default velocity of zero in
   * both directions.
   * @param x
   *   x-coordinate of upper left corner
   * @param y
   *   y-coordinate of upper left corner
   * @param width
   *   object's width
   * @param height
   *   object's height
   */
  public MovingElement(double x, double y, int width, int height) 
  {
	  
 super(x,y,width,height);

  }
  
  /**
   * Sets the velocity for this element, but does nothing if the element is currently ballistic.
   * 
   * @param deltaX
   * new horizontal velocity
   * 
   * @param deltaY
   * new vertical velocity
   */
  public void setVelocity(double deltaX, double deltaY) {
	 
	  dX=deltaX;
	  dY=deltaY;
	  
  }
 

  /**
   * Returns the x-component of this object's velocity.
   * 
   * @return
   * horizontal velocity
   */
  public double getDeltaX() {
	  
	  return dX;
  }
  
  /**
   * Returns the y-component of this object's velocity.
   * 
   * @return
   * vertical velocity
   */
 public double getDeltaY() {
	  
	  return dY;
  }
 
 
/**
 * Update method adds (deltaX, deltaY) to the current position.
 */
@Override
 public void update() {
	
	super.update();
	setPosition(getXReal()+dX,getYReal()+dY);
	
}
 
}
