import processing.core.PApplet;

public class Spaceship extends Floater
{
    public Spaceship(PApplet applet_)
    {
        super(applet_);
        corners = 3;
        xCorners = new int[corners];
        yCorners = new int[corners];
        xCorners[0] = -10;
        yCorners[0] = -10;
        xCorners[1] = 20;
        yCorners[1] = 0;
        xCorners[2] = -10;
        yCorners[2] = 10;
        myColor = 250;
        myCenterX = 450;
        myCenterY = 450;
        myXspeed = 0;
        myYspeed = 0;
        myPointDirection = 0;

    }


    public void hyperSpace()
    {
        myXspeed = 0;
        myYspeed = 0;
        myPointDirection = Math.random() * 360;
        myCenterX = (Math.random() * 900);
        myCenterY = (Math.random() * 900);

    }

    public double getX()
    {
        return myCenterX;
    }

    public double getY()
    {
        return myCenterY;
    }

    public double getXSpeed()
    {
        return myXspeed;
    }

    public double getYSpeed()
    {
        return myYspeed;
    }

    public void die()
    {
        myColor = 0;
        xCorners[0] = 0;
        yCorners[0] = 0;
        xCorners[1] = 0;
        yCorners[1] = 0;
        xCorners[2] = 0;
        yCorners[2] = 0;
    }

    public double getPointDirection()
    {
        return myPointDirection;
    }
}
//your code here
