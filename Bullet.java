import processing.core.PApplet;

public class Bullet extends Floater
{
    public Bullet(PApplet applet_, Spaceship theShip)
    {
        super(applet_);
        myCenterX = theShip.getX();
        myCenterY = theShip.getY();
        myXspeed = theShip.getXSpeed();
        myYspeed = theShip.getYSpeed();
        myPointDirection = theShip.getPointDirection();
        myColor = 250;
        this.accelerate(6);
    }
    @Override
    public void show()
    {
        super.show();
        applet.ellipse((float)myCenterX, (float)myCenterY, 10, 10);
    }

    public double getX()
    {
        return myCenterX;
    }

    public double getY()
    {
        return myCenterY;
    }
}
