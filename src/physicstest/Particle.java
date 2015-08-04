/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physicstest;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Joey
 */
public class Particle {
    private double x;
    private double y;
    private double dx;
    private double dy;
    private double ax;
    private double ay;
    private int m;
    private ArrayList<Point> t;
    
    public Particle(int ix, int iy, int im, int idx, int idy){
        x = ix;
        y = iy;
        m = im;
        dx = idx;
        dy = idy;
        ax = 0;
        ay = 0;
        t = new ArrayList();
        t.add(new Point((int)x,(int)y));
    }
    public void step(){
        dx += ax;
        dy += ay;
        x += dx;
        y +=  dy;
        t.add(new Point((int)x,(int)y));
    }
    
    public int getX(){
        return (int)x;
    }
    public int getY(){
        return (int)y;
    }
    public double getDX(){
        return dx;
    }
    public double getDY(){
        return dy;
    }
    public int getM(){
        return m;
    }
    public double getAX(){
        return ax;
    }
    public double getAY(){
        return ay;
    }
    public void setX(int ix){
        x = ix;
    }
    public void setY(int iy){
        y = iy;
    }
    public void setDX(double idx){
        dx = idx;
    }
    public void setDY(double idy){
        dy = idy;
    }
    public void setM(int im){
        m = im;
    }
    public void setAX(double iax){
        ax = iax;
    }
    public void setAY(double iay){
        ay = iay;
    }
    public ArrayList<Point> getTraj(){
        return t;
    }
}
