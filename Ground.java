import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ground extends SharedResources
{   
    private GreenfootImage ground = new GreenfootImage("ground.png");

    public Ground() // Construtor
    {
        setImage(ground);
        xSpeed = 4;
    }
    
    public void act()
    {
        moveLeft();
        removeGround();
    }
    
    public void removeGround()
    {
        if(getX() < -getImage().getWidth() / 2)
            getWorld().removeObject(this);
    }
}
