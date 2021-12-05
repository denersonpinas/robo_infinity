import greenfoot.*;
import java.util.Random;

public class FaseThree extends Fases{
    PisoThree piso = new PisoThree();
    int contador = 0;
    
    public FaseThree(int score){
        super(600, 400, 1);
        prepare();
        Greenfoot.setSpeed(52);
        metros.score = score;        
    }
    
    public void act(){
        contador++;
        Random gerador = new Random();
        if(contador == 100) {
            if(gerador.nextInt(10) > 3){
                addBots03();
            }
        } else if(contador == 50) {
            if(gerador.nextInt(10) > 6){
                addBots02();
            }
        }
        if(contador == 100) {
            contador = 0;
        }
        
        createPiso();
        if (metros.score >= 6500){
            Greenfoot.setWorld(new ControllerFases(4, metros.score));
        }
    }
    
    /*
     * Criação do Chao após ser apagado e Mudança de Chão após mudança de nível
     */
    private void createPiso(){        
        
        if(getObjects(PisoThree.class).size() < 3){
           addObject(new PisoThree(), 905, 375);
        }
    }
    
    public void prepare(){        
        super.prepare();
        addObject(piso, 309, 375);
        
    }
}
