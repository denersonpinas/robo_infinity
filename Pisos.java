import greenfoot.*;

public class Pisos extends Actor{
    
    int xSpeed = 4;
    public void act(){
    }
    
    public void moveLeft()
    {
        setLocation(getX() - xSpeed, getY());
    }
    
    public void removeGround(){
        if(getX() < 20)
            getWorld().removeObject(this);
    }
}
