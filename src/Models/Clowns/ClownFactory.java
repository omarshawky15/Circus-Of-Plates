package Models.Clowns;

import Models.Logger.GameLogger;
import Models.Stick.StickFactory;
import Models.Utils.Loader;

public class ClownFactory {
    static ClownFactory clownUniqueFactory = new ClownFactory();
    private ClownFactory (){
    }

    public static ClownFactory getInstance(){
        return clownUniqueFactory;
    }

    public Clown getclown(int x,int y, String clownPath,int type){

        StickFactory stickFactory = StickFactory.getInstance();
        Clown clown= new Clown();
        clown.setX(x);
        clown.y = y;
        Loader loader = Loader.getInstance();
        clown.type = type;
        clown.visible = true;
        if(clownPath.contains("1") || clownPath.contains("2")) {
            clown.spriteImages[0] = loader.getImage(clownPath, 0.1);
            clown.stick1 = stickFactory.getstick(clown.getX()-30,clown.getY()+ 12,"Sticks/leftstick_2.png");
            clown.stick2 = stickFactory.getstick(clown.getX()+85,clown.getY()+ 12,"Sticks/rightstick_2.png");
        }
        else {
            clown.spriteImages[0] = loader.getImage(clownPath, 0.15);
            clown.stick1 =  stickFactory.getstick(clown.getX()-37,clown.getY()+66,"Sticks/leftstick_2.png");
            clown.stick2 = stickFactory.getstick(clown.getX()+90,clown.getY() + 66,"Sticks/rightstick_2.png");
        }
        GameLogger logger = GameLogger.getInstance();
        logger.addLog("config", "Clown Created");
        return clown;
    }
}
