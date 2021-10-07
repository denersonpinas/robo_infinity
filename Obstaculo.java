import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Obstaculo extends SharedResources
{   
    GreenfootImage obstaculo01 = new GreenfootImage("nave.png");
    
    public Obstaculo()
    {
        xSpeed = 4;
        setImage(obstaculo01);
    }
    
    public void act()
    {
        moveLeft();
        removePipe();
    }
    
    public void removePipe()
    {
        if(getX() < -getImage().getWidth())
            getWorld().removeObject(this);
    }
}
