package models;

import java.util.Random;

public class Animal {

    Random random = new Random();
    public  boolean isArrived = false;
    private int x = random.nextInt(6) + 2;
    private int y = random.nextInt(6) + 2;
    private int xDirection;
    private int yDirection;
    boolean isMoving;
    private int speed = 1;
    private int timeR = 0;

    public  void targetedMove(int speed, Animal animal, int destinationX, int destinationY) {
//        System.out.println(destinationX+" "+destinationY);
        if (destinationX - animal.x == 0 & destinationY - animal.y == 0) {
            isArrived = true;
            return;
        }
        else if (destinationX - animal.x > 0 && animal.x<6) {
            animal.x += speed;
//            System.out.println(2);
            }
       else if (destinationX - animal.x < 0 && animal.x>1){ animal.x -=  speed;
            System.out.println(1);
       }

        if (destinationY - animal.y < 0 && animal.y>1) {
            animal.y -= speed;
          //  System.out.println(3);
        }
        else if (destinationY - animal.y > 0 && animal.y<6){
            animal.y += speed;
          //  System.out.println(4);
        }

        if (destinationX - animal.x == 0 & destinationY - animal.y == 0) {
            isArrived = true;
            return;
        }
    }

    public static int destination(int x1, int y1, int x2, int y2) {
        int d = (int) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        return d;
    }

    public void move() {
        if (timeR == 0) {
            timeR = random.nextInt(2) + 1;
            xDirection = randomiser(x);
            yDirection = randomiser(y);
            while (xDirection == 0 && yDirection == 0) {
                xDirection = randomiser(x);
                yDirection = randomiser(y);
            }
        } else timeR--;
        x += speed * xDirection;
        y += speed * yDirection;
    }

    public int randomiser(int value) {
        if (value <= speed * (timeR + 1)) {
            return random.nextInt(2);
        } else if (value >= 5 - speed * (timeR + 1)) {
            return random.nextInt(2) - 1;
        } else {
            return random.nextInt(3) - 1;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getxDirection() {
        return xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public int getTimeR() {
        return timeR;
    }

    public Random getRandom() {
        return random;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public void setTimeR(int timeR) {
        this.timeR = timeR;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}

