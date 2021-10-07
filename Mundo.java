import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Mundo extends World
{
    private int score = 0;
    private int contador = 0;
    private double contadorRandom;
    private int speed = 40;
    
    public Mundo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        // Criação do chão inicial
        populate();
        
        // Criação de um novo garçon
        Player garcon = new Player(); 
        
        setPaintOrder(Player.class, Obstaculo.class);
        
               
        // Add Garcon ao mundo
        addObject(garcon, 65, 315);
    }
    
    public void act() {
        // FPS
        Greenfoot.setSpeed(this.speed);
        
        // Criação do chão
        createGround();
        
        setBackground();
        printScore();
        
        createObs();  
    }
    
    public void populate()
    {
        Ground ground = new Ground();
        addObject(ground, 309, getHeight() - 25);
    }    
    
    /*
     * Criação do Chao após ser apagado
     */
    private void createGround()
    {
        if(getObjects(Ground.class).size() < 3)
            addObject(new Ground(), 905, getHeight() - 25);
    } 
    
    /*
     * Calcula a Distância Percorrida pelo usuario
     * e apresenta na tela
     */
    public void printScore() {
        showText(Integer.toString(score), 100,50);
        score++;
    }
    
    public void setBackground() {
        ArrayList<String> imageBG = new ArrayList<>();
        imageBG.add("background02.jpg");
        imageBG.add("background02.jpg");
        
        if(score < 1000){
            setBackground(imageBG.get(0));
        } else if (score < 2000) {
            setBackground(imageBG.get(1));
        }
    }
    
    public void createObs()
    {
        // ScoreCollider scoreCollider = new ScoreCollider();
        
        Obstaculo obstaculo01 = new Obstaculo();
        
        int obstaculoSpacing = 150;
        
        GreenfootImage image = obstaculo01.getImage();
        
        int numOfPipes = Greenfoot.getRandomNumber(10) + 4;
        
        contador++;        
        if(this.score > 0 && this.score < 1000){
            //instância um objeto da classe Random usando o construtor básico
            Random gerador = new Random();
            if(contador == 100) {
                if(getObjects(Obstaculo.class).size() < numOfPipes){
                    if(gerador.nextInt(10) > 5){
                        addObject(obstaculo01, getWidth(), 340);                
                    }
                }
            }
        }else if(this.score > 1001 && this.score < 2000){
            //instância um objeto da classe Random usando o construtor básico
            Random gerador = new Random();
            
            if(contador == 80) {
                if(getObjects(Obstaculo.class).size() < numOfPipes){
                    if(gerador.nextInt(10) > 3){
                        addObject(obstaculo01, getWidth(), 340);                
                    }
                }
                contador = 0;
            }
        } else if(this.score > 2001 && this.score < 3000){
            //instância um objeto da classe Random usando o construtor básico
            Random gerador = new Random();
            
            if(contador == 60) {
                if(getObjects(Obstaculo.class).size() < numOfPipes){
                    if(gerador.nextInt(10) > 1){
                        addObject(obstaculo01, getWidth(), 340);                
                    }
                }
                contador = 0;
            }
        } else if(this.score > 3001 && this.score < 4000){
            //instância um objeto da classe Random usando o construtor básico
            Random gerador = new Random();
            
            if(contador == 50) {
                if(getObjects(Obstaculo.class).size() < numOfPipes){
                    if(gerador.nextInt(10) > 0){
                        addObject(obstaculo01, getWidth(), 340);                
                    }
                }
                contador = 0;
            }
        }
        if(contador == 100) {
            contador = 0;
        }
    }
}
