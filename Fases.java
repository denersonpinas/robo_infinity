import greenfoot.*;
import java.util.Random;

public class Fases extends World
{
    Metros metros = new Metros();
    Robot player = new Robot(true);    
    
    public Fases(int h, int w, int a){  
        super(h, w, a);
        setPaintOrder(Robot.class, BotOne.class, BotTwo.class, BotThree.class, PisoOne.class, PisoTwo.class, PisoThree.class, PisoFour.class);
        
    }
    
    public void addBots(){
        addObject(new BotOne(), getWidth(), 340);       
    }
    
    public void addBots02(){
        int position = (int) (Math.random() * (400 - 65)) + 100;
        addObject(new BotTwo(), getWidth(), position);       
    }
    
    public void addBots03(){
        addObject(new BotThree(), getWidth(), 340);       
    }
    
    // Get para o contador de distância percorrida
    public Metros getMetros(){
        return metros;
    }
    
    public void prepare(){
        Score scoreIMG = new Score();
        addObject(scoreIMG, 300, 200);
        addObject(metros, 150, 60);
        addObject(player, 65, 315);        
    }
}
