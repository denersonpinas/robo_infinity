import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Mundo extends World
{
    protected int score = 0;
    private int contador = 0;
    private double contadorRandom;
    private int speed = 40;
    
    private GreenfootImage bg_01 = new GreenfootImage("bg.jpg");
    private GreenfootImage bg_02 = new GreenfootImage("bg_desert.png");
    private GreenfootImage bg_03 = new GreenfootImage("bg_jungle.png");
    private GreenfootImage bg_04 = new GreenfootImage("bg_snow.png");
    
    private GreenfootImage gr_01 = new GreenfootImage("ground.png");
    private GreenfootImage gr_02 = new GreenfootImage("ground_desert.png");
    private GreenfootImage gr_03 = new GreenfootImage("ground_jungle.png");
    private GreenfootImage gr_04 = new GreenfootImage("ground_snow.png");
    
    Ground ground = new Ground(gr_01);
    
    public Mundo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        // Criação do chão inicial
        populate();
        
        // Criação de um novo garçon
        Player robot = new Player();
        
        // Criação do score
        Score scoreImg = new Score();
        
        setPaintOrder(Transitions.class, Score.class, Player.class, Obstaculo.class);
               
        // Add Garcon ao mundo
        addObject(robot, 65, 315); 
               
        // Add ScoreImg ao mundo
        addObject(scoreImg, 300, 200);
    }
    
    public void act() {        
        Greenfoot.setSpeed(this.speed); // FPS
        
        createGround(); // Criação do chão        
        
        setBackground(); // Criação do background        
        
        printScore(); // Printando scores na tela        
        
        createObs();  // Criação do obstaculo
    }
    
    public void populate()
    {        
        addObject(ground, 309, getHeight() - 25);
    }    
    
    /*
     * Criação do Chao após ser apagado e Mudança de Chão após mudança de nível
     */
    private void createGround()
    {
        if(getObjects(Ground.class).size() < 3){
            if(this.score > 0 && this.score < 1000){
                addObject(new Ground(gr_01), 905, getHeight() - 25);           
            } else if (this.score > 1001 && this.score < 2000) {
                addObject(new Ground(gr_02), 905, getHeight() - 25);
            }
        }
    } 
    
    /*
     * Calcula a Distância Percorrida pelo usuario
     * e apresenta na tela
     */
    public void printScore() { 
        String metros = score + " m";
        showText(metros, 150,60);
        score++;
    }
    
    public void setBackground() {        
        if(this.score > 0 && this.score < 1000){
            setBackground(bg_01);            
        } else if (this.score > 1001 && this.score < 2000) {
            setBackground(bg_02);
            this.speed = 45; // Passagem de nível, ou seja, aumento de velocidade
        }
    }
    
    public void createObs()
    {   
        /*
         * Temos a incrementação do contador e a cada 100 existe uma verificação do gerador random e se for maior
         * que o valor estabelecido em cada nivel, adicionamos um obstaculo.
         */
        Obstaculo obstaculo01 = new Obstaculo();
        
        contador++;        
        if(this.score > 0 && this.score < 1000){            
            
            //instância um objeto da classe Random usando o construtor básico
            Random gerador = new Random();
            if(contador == 100) {
                if(gerador.nextInt(10) > 5){
                    addObject(obstaculo01, getWidth(), 340);                
                }
            }
        } else if (this.score > 1001 && this.score < 2000) {
            
            //instância um objeto da classe Random usando o construtor básico
            Random gerador = new Random();
            if(contador == 100) {
                if(gerador.nextInt(10) > 3){
                    addObject(obstaculo01, getWidth(), 340);                
                }
            }
        }
        if(contador == 100) {
            contador = 0;
        }
    }
}
