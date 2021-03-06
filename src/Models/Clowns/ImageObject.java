package Models.Clowns;

import Models.Utils.ArrayListIterator;
import Models.Utils.Loader;
import Models.Stick.Observer;
import View.game.GameObject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ImageObject implements GameObject,Cloneable {
    public BufferedImage[] spriteImages = new BufferedImage[1];
    public ArrayList observers = new ArrayList();
    Loader loader;
    public int x;
    int y;
    public boolean visible = true;
    public int type;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int mX) {
        this.x = mX;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int mY) {
        this.y = mY;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }


    @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public boolean notifyObservers(int diff) {
        ArrayListIterator iterator = new ArrayListIterator(observers);
        while (iterator.hasNext()){
            Observer observer = (Observer)iterator.next();
            observer.update(diff);
        }
        return true;
    }
    public Object clone() throws
            CloneNotSupportedException
    {
        return super.clone();
    }
}
