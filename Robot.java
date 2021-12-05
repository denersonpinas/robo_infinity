import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class Robot extends Actor{    
    private double velocity = 0;
    private final double GRAVITY = .4;
    private final double BOOST_SPEED = -7;
    private boolean gameOver = true;
    private int frame = 0;
    
    private int initialDelay;        
    private int animationDelay;
    private boolean animation;
    
    // Sound
    static GreenfootSound robotSound = new GreenfootSound("sounds/Music_Level01.wav");
    
    public Robot(boolean verific)
    {
        setAnimation(verific);
        if (verific) {
            setImage("Run_01.png"); // Setando Imagens
        } else {
            setImage("g01.png"); // Setando Imagens
        }        
    }
    
    public void act()
    {
        if(getAnimation()){
            animatePlayerOne();
            initialDelay++;     
            startPlaySound();
            if(initialDelay >= 50)
            {
                applyGravity();
                checkKeys();
                checkCollisions();
                gameOver();
            }
        } else {
            animationPlayerTwo();
        }
    }
    
    public static void startPlaySound() {
            robotSound.playLoop();
    }
    
    public void animatePlayerOne(){ // Animação correndo
        ArrayList<String> imagePlayer = new ArrayList<>();
        imagePlayer.add("Run_01.png");
        imagePlayer.add("Run_02.png");
        imagePlayer.add("Run_03.png");
        imagePlayer.add("Run_04.png");
        imagePlayer.add("Run_05.png");
        imagePlayer.add("Run_06.png");
        imagePlayer.add("Run_07.png");
        imagePlayer.add("Run_08.png");
        
        
        frame++;        
        if(frame < 6){
            if(frame % 2 == 0){
                setImage(imagePlayer.get(frame));
            }
        } else {
            frame = 0;
        }
    }
    
    public void animationPlayerTwo(){
        ArrayList<String> imagePlayer = new ArrayList<>();
        imagePlayer.add("g01.png");
        imagePlayer.add("g02.png");       
        
        frame++;        
        if(frame < 50){            
                setImage(imagePlayer.get(0));
        } else {
            frame = 0;
            setImage(imagePlayer.get(1));
        }
    }
    
    public void checkCollisions()
    {      
        Actor piso1 = getOneIntersectingObject(PisoOne.class);
        Actor piso2 = getOneIntersectingObject(PisoTwo.class);
        Actor piso3 = getOneIntersectingObject(PisoThree.class);
        Actor piso4 = getOneIntersectingObject(PisoFour.class);
        
        if((piso1 != null) || (piso2 != null) || (piso3 != null) || (piso4 != null)) {
            velocity = 0;
        }
    }
    
    public void applyGravity()
    {
        setLocation(getX(), getY() + (int)velocity);
        velocity += GRAVITY;
    }
    
    public void checkKeys()
    {
        Actor piso1 = getOneIntersectingObject(PisoOne.class);
        Actor piso2 = getOneIntersectingObject(PisoTwo.class);
        Actor piso3 = getOneIntersectingObject(PisoThree.class);
        Actor piso4 = getOneIntersectingObject(PisoFour.class);
        
        if(Greenfoot.isKeyDown("space") || Greenfoot.mouseClicked(null))
        { 
            if((piso1 != null) || (piso2 != null) || (piso3 != null) || (piso4 != null)) {
                velocity = BOOST_SPEED;
                Greenfoot.playSound("sounds/jump_06.wav");
            }
        }
        setLocation(getX(), getY() + (int)velocity);
    }
    
    public void gameOver(){
        Actor botOne = getOneIntersectingObject(BotOne.class);
        
        if(botOne != null)
        {
            GameOver gameOver = new GameOver();
            getWorld().addObject(gameOver, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            setGameOver(false);
            robotSound.stop();
            Greenfoot.stop();
        }
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
    
    public void setGameOver(boolean fimJogo) {
        gameOver = fimJogo;
    }
    
    public boolean getAnimation(){
        return this.animation;
    }
    public void setAnimation(boolean animation){
        this.animation = animation;
    }
}
