import greenfoot.*;

/**
 * Robot Ifinity.
 * 
 * @author (Dênerson P.; João; Marcos) 
 * @version (1.0.1)
 */
public class App extends World{
    // Classe inicial do Game, aqui onde tudo se inicia
    
    private BtnPlay btnPlay;
    
    

    public App(){    
        super(600, 400, 1);
        prepare();
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(btnPlay)){            
            Greenfoot.setWorld(new ControllerFases(1, 0));
        }
    }
    
    public void prepare(){
        Robot player = new Robot(false);
        addObject(player, 65, 315);
        
        BtnPlay play = new BtnPlay();
        addObject(play, 300, 200);
        btnPlay = play;
    }
}
