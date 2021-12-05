import greenfoot.*; 

public class Metros extends Actor{
    int score = 0;
    Color color = Color.WHITE;
    
    public Metros() // geração do Score inicial do jogo
    {
        setImage(new GreenfootImage (Integer.toString(score) + "m", 30, color, null));
    }
    
    public void act() // atualização do Score
    {
        addScore();
        setImage(new GreenfootImage (Integer.toString(score)+ "m", 30, color, null));
    }
    
    public void addScore() // Soma recursiva indicando os metros percorridos
    {
        score += 1;
    }
}
