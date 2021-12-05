import greenfoot.*;
import java.util.ArrayList;

public class BotThree extends Bots
{
    ArrayList<String> imageBot = new ArrayList<>();
    private int frame = 0;
    
    public BotThree(){
        setArrayImg();
        int xSpeed = 6;
    }
    
    public void act()
    {
        moveLeft();
        removeBots();
        animateBot();
    }
    
    public void setArrayImg(){
        imageBot.add("bots03_01.png");
        imageBot.add("bots03_02.png");
        imageBot.add("bots03_03.png");
        imageBot.add("bots03_04.png");
        imageBot.add("bots03_05.png");
        imageBot.add("bots03_06.png");
        imageBot.add("bots03_07.png");
        imageBot.add("bots03_08.png");
        imageBot.add("bots03_09.png");
        imageBot.add("bots03_10.png");
        imageBot.add("bots03_11.png");
        imageBot.add("bots03_12.png");
        imageBot.add("bots03_13.png");
        imageBot.add("bots03_14.png");
        imageBot.add("bots03_15.png");
        imageBot.add("bots03_16.png");
        imageBot.add("bots03_17.png");
    }
    
    public void animateBot(){
        frame++;        
        if(frame < 17){
            if(frame % 2 == 0){
                setImage(imageBot.get(frame));
            }
        } else {
            frame = 0;
        }
    }
}
