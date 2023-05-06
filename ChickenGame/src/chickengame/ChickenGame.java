
package chickengame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChickenGame extends JFrame implements MouseListener, Runnable{
    
    Font font20 = new Font("TimesNewRoman", Font.BOLD, 20);
    Random random = new Random();
    JPanel areaplay = new JPanel(null);
    JLabel vechile = new JLabel();
    
    JPanel contentpanel = new JPanel(null);
    JLabel firecount = new JLabel("Number Of Bullets : ");
    JLabel numberofshoot = new JLabel("30");
    JLabel score = new JLabel("Score : ");
    JLabel numberofscore = new JLabel("0");
    JLabel chickencount = new JLabel("Number Of Chicken : ");
    JLabel numberofchicken = new JLabel("0");
    
    JPanel gameoverpanel = new JPanel(null);
    JLabel gameover = new JLabel("Game Over ! ");
    
    JButton start = new JButton("Start");
    JButton pause = new JButton("Pause");
    JButton End = new JButton("End");
    
    // احداثيات المركبه
    int vechileX = 600, vechileY = 700, vechileWidth = 100, vechileHight = 50;
    
    // احداثيات الطلقات
    int fireX = vechileX + 20, fireY = vechileY -45, fireWidth = 25, fireHight = 40;
    
    // احداثيات الفراخ
    int chickenX = 0, chickenY = -10, chickenWidth = 105, chickenHight = 90;
    
    boolean end = true ;
    
    Vector <JLabel> fire = new Vector();
    Vector <Integer> firepositionX = new Vector();
    Vector <Integer> firepositionY = new Vector();
    
    
    Vector <JLabel> chicken = new Vector();
    Vector <Integer> chickenpositionX = new Vector();
    Vector <Integer> chickenpositionY = new Vector();
    
    
    public ChickenGame(){
        this.setSize(1700, 950);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        try{
            vechile.setIcon(new ImageIcon(getClass().getResource("/Images/vehicle.PNG")));
        }catch(Exception ex){
            System.out.println("vehicle photo lost \n " + ex);
        }
        
        areaplay.setBorder(BorderFactory.createTitledBorder(""));
        areaplay.setBounds(0, 0, 1200, 800);
        vechile.setBounds(vechileX, vechileY, vechileWidth, vechileHight);
        
        contentpanel.setBounds(1250, 350, 400, 450);
        contentpanel.setBorder(BorderFactory.createTitledBorder(""));
        firecount.setBounds(20, 20, 200, 35);
        numberofshoot.setBounds(230, 20, 100, 35);
        score.setBounds(20, 75, 100, 35);
        numberofscore.setBounds(120, 75, 70, 35);
        chickencount.setBounds(20, 130, 250, 35);
        numberofchicken.setBounds(230, 130, 250, 35);
        gameoverpanel.setBounds(400, 400, 500, 150);
        gameoverpanel.setBorder(BorderFactory.createTitledBorder(""));
        gameover.setBounds(100, 50, 300, 35);
        pause.setBounds(1250, 100, 150, 35);
        End.setBounds(1450, 100, 150, 35);
        start.setBounds(1250, 150, 350, 35);
        
        firecount.setFont(font20);
        numberofshoot.setFont(font20);
        score.setFont(font20);
        numberofscore.setFont(font20);
        chickencount.setFont(font20);
        numberofchicken.setFont(font20);
        gameover.setFont(new Font("TimesNewRoman", Font.BOLD, 36));
        
        firecount.setForeground(Color.BLUE);
        numberofshoot.setForeground(Color.BLUE);
        score.setForeground(Color.BLUE);
        numberofscore.setForeground(Color.BLUE);
        chickencount.setForeground(Color.BLUE);
        numberofchicken.setForeground(Color.BLUE);
        gameover.setForeground(Color.RED);
        pause.setForeground(Color.WHITE);
        End.setForeground(Color.WHITE);
        start.setForeground(Color.WHITE);
        
        pause.setBackground(Color.BLACK);
        End.setBackground(Color.BLACK);
        start.setBackground(Color.BLACK);
        
        gameoverpanel.setVisible(false);
        this.getContentPane().setBackground(Color.BLACK);
        areaplay.setBackground(Color.decode("#020147"));
        contentpanel.setBackground(Color.BLACK);
        gameoverpanel.setBackground(Color.decode("020147"));
        gameover.setHorizontalAlignment(JLabel.CENTER);
        
        contentpanel.add(firecount);
        contentpanel.add(numberofshoot);
        contentpanel.add(score);
        contentpanel.add(numberofscore);
        contentpanel.add(chickencount);
        contentpanel.add(numberofchicken);
        
        gameoverpanel.add(gameover);
        
        areaplay.add(vechile);
        
        this.add(gameoverpanel);
        this.add(areaplay);
        this.add(contentpanel);
        this.add(start);
        this.add(End);
        this.add(pause);
        
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                end = false;
            }
        });
        
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pause.getBackground() == Color.BLACK){
                    end = true;
                    pause.setBackground(Color.red);
                }else{
                    end = false;
                    pause.setBackground(Color.BLACK);
                }
            }
        });
        
        End.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        areaplay.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if(end == false){
                    vechileX = e.getX()-15;
                    vechileY = e.getY()-15;
                    if(vechileX >= 0 && vechileX <= 1140 && vechileY >=0 && vechileY <= 750){
                        vechile.setBounds(vechileX, vechileY, vechileWidth, vechileHight);
                    }
                }
            }
        });
        areaplay.addMouseListener(this);
        
        
    }
    
    public void createFire(){
        JLabel fire = new JLabel();
        try{
            fire.setIcon(new ImageIcon(getClass().getResource("/Images/fire.jpg")));
        }catch(Exception ex){ex.printStackTrace();}
        this.fire.add(fire);
        firepositionX.add(fireX);
        firepositionY.add(fireY);
        fire.setBounds(fireX, fireY, fireWidth, fireHight);
        areaplay.add(fire);
        int num = Integer.parseInt(numberofshoot.getText());
        num--;
        numberofshoot.setText(String.valueOf(num));
    }
    
    public void moveFire(){
        for(int i=0; i<fire.size(); i++){
            if(firepositionY.get(i) > 0){
                firepositionY.set(i, firepositionY.get(i) -1 );
                fire.get(i).setBounds(firepositionX.get(i), firepositionY.get(i), fireWidth, fireHight);
            }else{
                fire.get(i).setVisible(false);
                fire.remove(i);
                firepositionX.remove(i);
                firepositionY.remove(i);
            }
        }
    }
    
    public void createChicken(){
        JLabel chicken = new JLabel();
        try{
            chicken.setIcon(new ImageIcon(getClass().getResource("/Images/chicken.PNG")));
        }catch(Exception ex){ex.printStackTrace();}
        this.chicken.add(chicken);
        chickenX = random.nextInt(1100);
        chickenpositionX.add(chickenX);
        chickenpositionY.add(chickenY);
        chicken.setBounds(chickenX, chickenY, chickenWidth, chickenHight);
        areaplay.add(chicken);
        int num = Integer.parseInt(numberofchicken.getText());
        num++;
        numberofchicken.setText(String.valueOf(num));
    }
    
    public void moveChicken(){
        for(int i=0; i<chicken.size(); i++){
            int index = fireAndChicken(i);
            if(chickenpositionY.get(i) <805 && index == -1){
                chickenpositionY.set(i, chickenpositionY.get(i)+1);
                chicken.get(i).setBounds(chickenpositionX.get(i), chickenpositionY.get(i), chickenWidth, chickenHight);
            }else{
                if(index != -1){
                    int num = Integer.parseInt(numberofscore.getText());
                    num++;
                    numberofscore.setText(String.valueOf(num));
                }
                chicken.get(i).setVisible(false);
                chicken.remove(i);
                chickenpositionX.remove(i);
                chickenpositionY.remove(i);
            }
            
        }
    }
    
    public int fireAndChicken(int indexcheck){
        for(int i=0; i<fire.size(); i++){
            if((firepositionX.get(i)>= chickenpositionX.get(indexcheck) &&
                    firepositionX.get(i) <= chickenpositionX.get(indexcheck) + chickenWidth) && 
                    firepositionY.get(i) >= chickenpositionY.get(indexcheck) && 
                    firepositionY.get(i) <= chickenpositionY.get(indexcheck) + chickenHight){
                return indexcheck;
            }
        }
        return -1;
    }
    
    public void endGame(){
        for(int i=0; i<chicken.size(); i++){
            if((vechileX >= chickenpositionX.get(i) && vechileX <= chickenpositionX.get(i) + chickenWidth) &&
                    (vechileY >= chickenpositionY.get(i) && vechileY <= chickenpositionY.get(i) + chickenHight)){
                gameoverpanel.setVisible(true);
                end = true;
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ChickenGame()).run();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == areaplay){
            if(end == false && Integer.parseInt(numberofshoot.getText()) > 0){
                fireX = vechileX +20;
                fireY = vechileY -45;
                createFire();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    int countertocreatechicken = 0, counterrandom = 0, ns = 0;
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            if(!end){
                if(countertocreatechicken >= counterrandom){
                    createChicken();
                    counterrandom = random.nextInt(600);
                    countertocreatechicken = 0;
                }
                if(numberofshoot.getText().equals("0")){
                    ns++;
                    if(ns == 3000){
                        ns = 0;
                        numberofshoot.setText("30");
                    }
                }
                
                countertocreatechicken++;
                moveFire();
                moveChicken();
                endGame();
                try{Thread.sleep(3);}catch(Exception ex){}
            }
        }
    }
    
}
