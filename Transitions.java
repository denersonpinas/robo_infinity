import greenfoot.*;

public class Transitions extends SharedResources
{
    GreenfootImage transition = new GreenfootImage(600, 400);
    
    int fadeUpperLimit = 255;
    int fadeLowerLimit = 25;
    
    public Transitions(String selection)
    {
        switch(selection)
        {
            case "black":
                xSpeed = 5;
                transition.setColor(Color.BLACK);
                break;
            case "white":
                xSpeed = 3;
                transition.setColor(Color.WHITE);
                break;
        }
        transition.fill();
        setImage(transition);
        transition.setTransparency(fadeUpperLimit);
    }
    
    public void act()
    {
        fadeOut();
    }
    
    private void fadeOut()
    {
        System.out.println(transition.getTransparency());
        transition.setTransparency(transition.getTransparency() - xSpeed);
        if(transition.getTransparency() <= fadeLowerLimit)
            getWorld().removeObject(this);
    }
}
