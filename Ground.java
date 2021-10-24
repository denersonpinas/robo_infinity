import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ground extends SharedResources
{   
    // private GreenfootImage ground = new GreenfootImage("ground.png");
    private GreenfootImage img;
    
    public Ground(GreenfootImage img) // Construtor
    {
        this.img = img;
        xSpeed = 4;
    }
    
    public void act()
    {
        setandoImg(this.img);
        moveLeft();
        removeGround();
    }
    
    public void setandoImg(GreenfootImage img) {
        setImage(img);
    }
    
    public void removeGround()
    {
        if(getX() < -getImage().getWidth() / 2)
            getWorld().removeObject(this);
    }
}
