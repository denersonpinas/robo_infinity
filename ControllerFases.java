import greenfoot.*;  

public class ControllerFases extends World{
    int newFase;
    int atualScore;
    
    public ControllerFases(int fase, int score){
        super(600, 400, 1);
        newFase = fase;
        atualScore = score;
    }
    
    public void act() {
        if (newFase == 1)
            Greenfoot.setWorld(new FaseOne(atualScore));
        else if (newFase == 2)
            Greenfoot.setWorld(new FaseTwo(atualScore));
        else if (newFase == 3)
            Greenfoot.setWorld(new FaseThree(atualScore));
        else if (newFase == 4)
            Greenfoot.setWorld(new FaseFour(atualScore));
    }
}
