/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physicstest;

import java.util.ArrayList;

/**
 *
 * @author Joey
 */
public class Universe {
    private ArrayList<Particle> matter;
    private static double G = .1;
    private int len;
    
    public Universe(int N){
        len = N;
        matter =  new ArrayList();
        for(int i =0;i<N;i++){
            int temp1 = (int) (500*Math.random() + 200);
            int temp2 = (int) (500*Math.random() + 200);
            matter.add(i,new Particle(temp1,temp2,1,temp1/100,temp2/100));

           // matter.add(i,new Particle(temp1,temp2,1,0,0));
        }
    }
    public ArrayList<Particle> getParticles(){
        return matter;
    }
    public void Add(int x, int y, int M){
        matter.add(new Particle(x,y,M,0,0));
        len++;
    }
    public double getDist(Particle p1, Particle p2){
        return Math.sqrt(Math.pow(p1.getX()-p2.getX(),2) + Math.pow(p1.getY()-p2.getY(),2));
    }
    public void Update(){
        double fx =0;
        double fy = 0;
        double F =0;
        Particle p1;
        Particle p2;
        for(int i =0;i<len;i++){
            fx = 0;
            fy = 0;
            if(i == len -1){
                System.out.println("ax: " + matter.get(i).getAX());
            }
            for(int j=0;j<len;j++){
                if(j!=i){

                    p1 = matter.get(i);
                    p2 = matter.get(j);
                    double d = getDist(p1,p2);
                    if(d != 0){
                        F = (G * p1.getM() * p2.getM())/Math.pow(d,2);
                    }

                    if(5 < Math.abs(p1.getX() - p2.getX())){
                        fx -= F * (p1.getX() - p2.getX())/d;
                    }
                    else{
                        fx =0;
                    }
                    if(5 < Math.abs(p1.getY()-p2.getY())){
                       fy -= F * (p1.getY()-p2.getY())/d;

                    }
                    else{
                        fy =0;
                    }
                  //  System.out.println("ax: " + fx/p1.getM());


                    p1.setAX( (fx/p1.getM()));                

                    p1.setAY((fy/p1.getM()));
                    
                }
            }
        }
        for(Particle P : matter){
            P.step();
        }
        
    }

    
}
