import greenfoot.*;
import java.util.Random;

public class FaseTwo extends Fases
{
    PisoTwo piso = new PisoTwo();
    int contador = 0;
    
    public FaseTwo(int score){
        super(600, 400, 1);
        prepare();
        Greenfoot.setSpeed(50);
        metros.score = score;
    }
    
    public void act(){
        contador++;
        Random gerador = new Random();
        if(contador == 100) {
            if(gerador.nextInt(10) > 4){
                addBots();
            }
        } else if(contador == 50) {
            if(gerador.nextInt(10) > 7){
                addBots02();
            }
        }
        if(contador == 100) {
            contador = 0;
        }
        
        
        
        createPiso();
        if (metros.score >= 3500){
            Greenfoot.setWorld(new ControllerFases(3, metros.score));
        }
    }
    
    /*
     * Criação do Chao após ser apagado e Mudança de Chão após mudança de nível
     */
    private void createPiso(){        
        
        if(getObjects(PisoTwo.class).size() < 3){
           addObject(new PisoTwo(), 905, 375);
        }
    }
    
    public void prepare(){
        super.prepare();
        addObject(piso, 309, 375);
    }
}
