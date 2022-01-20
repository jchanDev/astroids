import processing.core.PApplet;

import java.util.List;
import java.util.ArrayList;

public class AsteroidsGame extends PApplet
{
    Spaceship ship;
    PApplet applet_;
    Star[] stars = new Star[500];
    List<Asteroid> roys = new ArrayList<>();
    List<Bullet> bullets = new ArrayList<>();
    String s;
    //your variable declarations here

    public static void main(String[] args)
    {
        PApplet.main("AsteroidsGame");
    }

    public void settings()
    {
        size(900, 900);
    }

    public void setup()
    {
        applet_ = new PApplet();
        ship = new Spaceship(this);
        for (int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star();
        }
        for (int i = 0; i < 10; i++)
        {
            roys.add(new Asteroid(this));
        }
        s = "";


    }

    public void draw()
    {
        background(0, 0, 0);
        for (int i = 0; i < stars.length; i++)
        {
            stars[i].show();
        }
        for (int i = 0; i < roys.size(); i++)
        {
            roys.get(i).show();
            roys.get(i).move();
            float distance = dist((float) roys.get(i).getX(), (float) roys.get(i).getY(), (float) ship.getX(), (float) ship.getY());
            if (distance < 40)
            {
                ship.die();
               s = "YOU LOSE";
            }
            else
            {
                for (int i2 = 0; i2 < bullets.size(); i2++)
                {
                    float distance2 = dist((float) roys.get(i).getX(), (float) roys.get(i).getY(), (float) bullets.get(i2).getX(), (float) bullets.get(i2).getY());
                    if (distance2 < 50)
                    {
                        bullets.remove(i2);
                        roys.remove(i);
                        break;
                    }

                }
            }
            textSize(100);
            text(s, 200, 450);

        }

        ship.show();

        for (Bullet cherry : bullets)
        {
            cherry.show();
            cherry.move();
        }

        if (keyPressed)
        {
            if (key == CODED)
            {
                if (keyCode == UP)
                {
                    ship.accelerate(0.1);
                }

                if (keyCode == DOWN)
                {
                    ship.accelerate(-0.1);
                }

                if (keyCode == LEFT)
                {
                    ship.turn(-5);
                }

                if (keyCode == RIGHT)
                {
                    ship.turn(5);
                }
            }

        }


        ship.move();

    }

    public void keyPressed()
    {

        if (keyCode == ENTER || keyCode == RETURN)
        {
            ship.hyperSpace();
        }
        if (key == ' ')
        {
            bullets.add(new Bullet(this, ship));
        }

    }

    public class Star
    {
        private int x, y;

        public Star()
        {
            x += (int) (Math.random() * 900);
            y += (int) (Math.random() * 900);
        }

        public void show()
        {
            int x1 = (int) (Math.random() * 256);
            int y1 = (int) (Math.random() * 256);
            int z1 = (int) (Math.random() * 256);
            fill(x1, y1, z1);
            stroke(x1, y1, z1);
            ellipse(x, y, 2, 2);
        }
    }
}