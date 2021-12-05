import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SharedResources extends Actor
{
    protected int animationDelay;
    protected int frame;
    
    protected int xSpeed = 4;
    public void act()
    {  
    }
    
    public void moveLeft()
    {
        setLocation(getX() - xSpeed, getY());
    }
}
