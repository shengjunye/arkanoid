package arkanoid;

import java.awt.*;

public class Ball {
    private static final int DIAMETER = 10;

    int x = 0;
    int y = 300;
    int xa = 1;
    int ya = 1;
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void move() {
        boolean changeDirection = true;
        if (x + xa < 0)
            xa = game.speed;
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;
        else if (y + ya < 0)
            ya = game.speed;
        else if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        else if (collision()){
            ya = -game.speed;
            game.speed++;
         }

         if(collisionBreak()){
        	 Sound.BALL.play();
             System.out.println(this.y + this.DIAMETER + " <= " + game._break.getY());
             System.out.println(this.y + " <= " + game._break.getUnderY());
            if(this.y + this.DIAMETER - 1 <= game._break.getY()){
                ya = -1;
            }
            else if(this.y + 1 >= game._break.getUnderY()){
                ya = 1;
            }
            else if(this.x + this.DIAMETER - 1 <= game._break.getX()){
                xa = -1;
            }
            else if(this.x + 1 >= game._break.getRightX()){
                xa = 1;
            }
        }

        x = x + xa;
        y = y + ya;


    }

    private boolean collisionBreak(){
        return game._break.getBounds().intersects(getBounds());
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
