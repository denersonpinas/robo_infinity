import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

public class Player extends SharedResources
{
    //private final GreenfootImage PULANDO = new GreenfootImage("Run_robot01       .png");
    //private final GreenfootImage INICIAL = new GreenfootImage("Run_robot01.png");
    
    private double velocity = 0;
    private final double GRAVITY = .4;
    private final double BOOST_SPEED = -7;
    private boolean gameOver = true;
    private int initialDelay;
    
    // Sound
    GreenfootSound robotSound = new GreenfootSound("sounds/Music_Level01.wav"); 
    
    public Player()
    {
        setImage("Run_01.png"); // Setando Imagens
        animationDelay = 4;
    }
    
    public void act()
    {
        initialDelay++;
        animatePlayer();
        startPlaySound();
        if(initialDelay >= 50)
        {
            applyGravity();
            checkKeys();
            checkCollisions();           
        }
    }
    
    public void applyGravity()
    {
        setLocation(getX(), getY() + (int)velocity);
        velocity += GRAVITY;
        animatePlayer();
    }
    
    public void checkKeys()
    {
        Actor Ground = getOneIntersectingObject(Ground.class);
        
        if(Greenfoot.isKeyDown("space") || Greenfoot.mouseClicked(null))
        {            
            //world.flapSound.play();
            if(Ground != null) {
                velocity = BOOST_SPEED;
                Greenfoot.playSound("sounds/jump_06.wav");
            }
        }
        setLocation(getX(), getY() + (int)velocity);
    }
    
    public void animatePlayer()
    {
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
    
    public void checkCollisions()
    {
        Actor Ground = getOneIntersectingObject(Ground.class);
        Actor Obstaculo = getOneIntersectingObject(Obstaculo.class);
        
        if(Obstaculo != null)
        {
            GameOver gameOver = new GameOver();
            getWorld().addObject(gameOver, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            setGameOver(false);
            robotSound.stop();
            Greenfoot.stop();
        } 
        
        
        if(Ground != null) {
            velocity = 0;
        }
    }
    
    public void startPlaySound() {        
        if(isGameOver()){
            robotSound.playLoop();
        }
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
    
    public void setGameOver(boolean fimJogo) {
        gameOver = fimJogo;
    }
}
