import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SharedResources extends Actor
{
    protected int animationDelay;
    protected int frame;
    
    protected int xSpeed = 0;
    public void act()
    {
        // Add your action code here.
    }
    
    public void moveLeft()
    {
        setLocation(getX() - xSpeed, getY());
    }
}
