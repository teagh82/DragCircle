import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DragCircle extends JFrame{
	ImageIcon i = new ImageIcon("images/tangled.jpg");
    Image img = i.getImage();
    int x = 50;
    int y = 50;
    
    public DragCircle(){
        setTitle("마우스 드래깅 시 원 이동하는 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyPanel panel = new MyPanel();
        panel.setLayout(null);
        panel.addMouseMotionListener(new MyMouseAdapter());
        
        add(panel);
        setSize(400,400);
        setVisible(true);
    }
    
    class MyMouseAdapter extends MouseAdapter {            
        public void mouseDragged(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            repaint();
        }   
    }
    
    class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            g.setColor(Color.GREEN);
            g.fillOval(x, y, 40, 40);
        }
    }
    
    public static void main(String[] args) {
        new DragCircle();
    }
}


    