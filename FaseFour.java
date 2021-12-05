import greenfoot.*;
import java.util.Random;

public class FaseFour extends Fases{
    PisoFour piso = new PisoFour();
    int contador = 0;
    
    public FaseFour(int score){
        super(600, 400, 1);
        prepare();
        Greenfoot.setSpeed(54);
        metros.score = score;        
    }
    
    public void act(){
        contador++;
        Random gerador = new Random();
        if(contador == 100) {
            if(gerador.nextInt(10) > 2){
                addBots03();
            }
        } else if(contador == 50) {
            if(gerador.nextInt(10) > 5){
                addBots02();
            }
        }
        if(contador == 100) {
            contador = 0;
        }
        
        createPiso();
    }
    
    /*
     * Criação do Chao após ser apagado e Mudança de Chão após mudança de nível
     */
    private void createPiso(){        
        
        if(getObjects(PisoFour.class).size() < 3){
           addObject(new PisoFour(), 905, 375);
        }
    }
    
    public void prepare(){        
        super.prepare();
        addObject(piso, 309, 375);        
    }
}
