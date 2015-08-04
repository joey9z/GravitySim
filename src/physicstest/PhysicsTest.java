/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physicstest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Joey
 */
public class PhysicsTest extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    
    
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("PHYSICS");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Board());
        f.pack();
        f.setSize(1000,1000);
        f.setLocationRelativeTo(null);
        f.setResizable(true);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}

    class Board extends JPanel implements ActionListener {

       private Universe world;
       private Timer tmr;


       public Board(){
           world = new Universe(30);
           world.Add(500, 500, 100000);
           tmr = new Timer(100, this);
           setFocusable(true);
           setLayout(null);
           setDoubleBuffered(true);
           tmr.start();


       }

       @Override
       public void paintComponent(Graphics g){
           super.paintComponent(g);
           Graphics2D g2d = (Graphics2D)g;
           int i =0;
           for (Iterator<Particle> it = world.getParticles().iterator(); it.hasNext();) {
               Particle p = it.next();
               g2d.fillOval(p.getX(), p.getY(), 10, 10);
               g2d.drawLine(p.getX()+ 5, p.getY()+5,(int) (p.getX()+10*p.getDX()+5), (int) (p.getY()+10*p.getDY()+5));
               g2d.drawLine(p.getX()+ 5, p.getY()+5,(int) (p.getX()+100*p.getAX()+5), (int) (p.getY()+100*p.getAY()+5));
               for(Iterator<Point> itr = p.getTraj().iterator();itr.hasNext();){
                   Point pt = itr.next();
                   g2d.drawRect((int) pt.getX(), (int) pt.getY(), 2, 2);
               }
               i++;
           }
           

       }

       @Override
       public void actionPerformed(ActionEvent ae) {
           world.Update();

           this.repaint();
       }

   }