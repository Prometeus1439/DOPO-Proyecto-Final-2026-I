package domain;
import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

public class TypeA extends Obstacle implements Serializable {

    private Point[] vertices;

    private int currentTarget;

    private double speed;

    public TypeA(int x,
                 int y,
                 int width,
                 int height,
                 int radius,
                 int sides) {
        super(x, y, width, height);
        vertices = new Point[sides];
        for(int i = 0; i < sides; i++) {
            double angle = 2 * Math.PI * i / sides;
            int vx = (int)(x + radius * Math.cos(angle));
            int vy = (int)(y + radius * Math.sin(angle));
            vertices[i] = new Point(vx, vy);
        }
        currentTarget = 0;
        speed = 2;
        color = Color.RED;
    }

    public void move() {
        Point target = vertices[currentTarget];
        double dx = target.x - hitbox.x;
        double dy = target.y - hitbox.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        if(distance < speed) {
            currentTarget++;
            if(currentTarget >= vertices.length) {
                currentTarget = 0;
            }
            return;
        }
        hitbox.x += (dx / distance) * speed;
        hitbox.y += (dy / distance) * speed;
    }
}