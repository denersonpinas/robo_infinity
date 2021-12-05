import greenfoot.*;

public class Bots extends Actor{
    
    int xSpeed = 4;
    public void act()
    {
    }
    
    public void moveLeft()
    {
        setLocation(getX() - xSpeed, getY());
    }
    
    public void removeBots()
    {
        if(getX() < 20)
            getWorld().removeObject(this);
    }
}
