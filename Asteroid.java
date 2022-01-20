import processing.core.PApplet;

public class Asteroid extends Floater
{

    private double rotSpeed;
    public Asteroid(PApplet applet_)
    {
        super(applet_);
        corners = 7;
        xCorners = new int[corners];
        yCorners = new int[corners];
        xCorners[0] = -40;
        yCorners[0] = -30;
        xCorners[1] = -19;
        yCorners[1] = -40;
        xCorners[2] = 22;
        yCorners[2] = -23;
        xCorners[3] = 28;
        yCorners[3] = 15;
        xCorners[4] = 21;
        yCorners[4] = 25;
        xCorners[5] = -40;
        yCorners[5] = 30;
        xCorners[6] = -50;
        yCorners[6] = 15;
        rotSpeed = (int)(Math.random() * 4) -  2;

        myColor = 250;
        myCenterX = (int)(Math.random() * 900);
        myCenterY = (int)(Math.random() * 900);
        myXspeed = (Math.random() * 4) - 2;
        System.out.println(myXspeed);
        myYspeed = (Math.random() * 4) - 2;

        myPointDirection = (int) (Math.random() * 360);
        if (myPointDirection > 180)
        {
            myXspeed *= -1;
        }

    }

    public void move()
    {

        super.move();
        turn(rotSpeed);
    }

    public void show()
    {

        applet.noFill();
        applet.stroke(myColor);
        //translate the (x,y) center of the ship to the correct position
        applet.translate((float)myCenterX, (float)myCenterY);

        //convert degrees to radians for rotate()
        float dRadians = (float)(myPointDirection * (Math.PI / 180));

        //rotate so that the polygon will be drawn in the correct direction
        applet.rotate(dRadians);

        //draw the polygon
        applet.beginShape();
        for (int i = 0; i < corners; i++)
        {
            applet.vertex(xCorners[i], yCorners[i]);
        }
        applet.endShape(applet.CLOSE);

        //"unrotate" and "untranslate" in reverse order
        applet.rotate(-1 * dRadians);
        applet.translate(-1 * (float)myCenterX, -1 * (float)myCenterY);
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
