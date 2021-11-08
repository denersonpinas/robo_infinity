import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SharedResources extends Actor
{
    protected int animationDelay;
    protected int frame;
    
    protected int xSpeed = 4;
    static int scoreInterno = 0;
    public void act()
    {  
    }
    
    public void velocity(){
        scoreInterno++;
        // System.out.println(scoreInterno >= 1000 && scoreInterno <= 2000);
        if(scoreInterno >= 1000 && scoreInterno <= 2000){
            xSpeed = 20;
        }
    }
    
    public void moveLeft()
    {
        setLocation(getX() - xSpeed, getY());
    }
}
