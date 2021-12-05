import greenfoot.*;
import java.util.Random;

public class FaseOne extends Fases
{    
    PisoOne piso = new PisoOne();
    int contador = 0;
    
    public FaseOne(int score){
        super(600, 400, 1);
        prepare();
        Greenfoot.setSpeed(48);
        metros.score = score;        
    }
    
    // Faz a implementação do piso das chamadas dos bots e verificação de level up
    public void act(){
        /*
         * Temos a incrementação do contador e a cada 100, existe uma verificação do gerador random e se for maior
         * que o valor estabelecido em cada nivel, adicionamos um obstaculo.
         */
        contador++;
        //instância um objeto da classe Random usando o construtor básico
        Random gerador = new Random();
        if(contador == 100) {
            if(gerador.nextInt(10) > 5){
                addBots();
            }
        }
        if(contador == 100) {
            contador = 0;
        }
        
        
        createPiso();
        
        if (metros.score >= 1500){
            Greenfoot.setWorld(new ControllerFases(2, metros.score));
        }
    }
    
    /*
     * Criação do Chao após ser apagado e Mudança de Chão após mudança de nível
     */
    private void createPiso(){
        if(getObjects(PisoOne.class).size() < 3){
           addObject(new PisoOne(), 905, 375);
        }
    }
    
    public void createObs()
    {   
        
    }
    
    public void prepare(){        
        super.prepare();
        addObject(piso, 309, 375);
        
    }
}
