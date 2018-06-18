import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePlay extends JPanel implements KeyListener,ActionListener{
	
	private int[] snakexlength = new int[750];
	private int[] snakeylength = new int[750];
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	
	private int lengthofsnake =3;
	private int moves = 0;
	private int scores = 0;
	private Timer timer;
	private int delay = 100;
	
	private int [] enemyxpos = {25,50,75,100,125,150,200,225,250,275,300,325,350,375,400,425,450,475,
			                     500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	private int [] enemyypos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,
            525,550,575,600,625};
	
	
	private ImageIcon enemyimage;
	private ImageIcon snakeimage;
	private ImageIcon titleImage;
	
	Random random = new Random();
	private int xpos = random.nextInt(34);
	private int ypos = random.nextInt(23);
	
	
	public GamePlay(){
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
	}
	public void paint(Graphics g){
		
		if(moves == 0){
			snakexlength[2] = 50;
			snakexlength[1] = 75;
			snakexlength[0] = 100;

			snakeylength[2] = 100;
			snakeylength[1] = 100;
			snakeylength[0] = 100;
		}
		//draw title image border
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		//draw the title image
		
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		//draw the border for gameplay
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		//draw background for gameplay
		g.setColor(Color.black);
		g.fillRect(25, 75,850, 575);
        
		//draw scores
		g.setColor(Color.white);
		g.setFont(new Font("areial",Font.PLAIN,14));
		g.drawString("Scores :"+ scores , 780, 30);
		
		//draw length of snake
		g.setColor(Color.white);
		g.setFont(new Font("areial",Font.PLAIN,14));
		g.drawString("Length :"+ lengthofsnake , 780, 50);
		
		rightmouth = new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
		
		for(int i=0;i<lengthofsnake;i++){
			if(i==0 && right){
				rightmouth = new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
			}
			if(i==0 && left){
				leftmouth = new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
			}
			if(i==0 && down){
				downmouth = new ImageIcon("downmouth.png");
				downmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
			}
			if(i==0 && up){
				upmouth = new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
				
			}
			if(i!=0){
				snakeimage = new ImageIcon("snakeimage.png");
				snakeimage.paintIcon(this, g, snakexlength[i], snakeylength[i]);
			}
		}
		
		enemyimage = new ImageIcon("enemy.png");
		if((enemyxpos[xpos] == snakexlength[0]) && enemyypos[ypos] == snakeylength[0]){
			scores++;
			lengthofsnake++;
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
		}
		enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
		
		for(int k=1;k<lengthofsnake;k++){
			if(snakexlength[k] == snakexlength[0] && snakeylength[k] == snakeylength[0]){
				right = false;
				left = false;
				up = false;
				down = false;
				
				g.setColor(Color.white);
				g.setFont(new Font("arial",Font.BOLD,40));
				g.drawString("Game Over" , 300, 300);
				
				g.setFont(new Font("arial",Font.BOLD,25));
				g.drawString("Space to RESTART" , 350, 340);

			}
		}
		g.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		if(right){
			for(int j=lengthofsnake-1;j>=0;j--){
				snakeylength[j+1] = snakeylength[j];
			}
			for(int j=lengthofsnake;j>=0;j--){
				if(j==0){
				snakexlength[j] = snakexlength[j]+25;
			}
				else{
				 snakexlength[j]=snakexlength[j-1];
				}
			if(snakexlength[j] > 850){
				snakexlength[j] = 25;
			}
			repaint();
		}
		}
		if(left){
			for(int j=lengthofsnake-1;j>=0;j--){
				snakeylength[j+1] = snakeylength[j];
			}
			for(int j=lengthofsnake;j>=0;j--){
				if(j==0){
				snakexlength[j] = snakexlength[j]-25;
			}
				else{
				 snakexlength[j] = snakexlength[j-1];
				}
			if(snakexlength[j] < 25){
				snakexlength[j] = 850;
			}
			repaint();
		}
		}
		
		if(down){
			for(int j=lengthofsnake-1;j>=0;j--){
				snakexlength[j+1] = snakexlength[j];
			}
			for(int j=lengthofsnake;j>=0;j--){
				if(j==0){
				snakeylength[j] = snakeylength[j]+25;
			}
				else{
				 snakeylength[j]=snakeylength[j-1];
				}
			if(snakeylength[j] > 625){
				snakeylength[j] = 75;
			}
			repaint();
		}
		}
		
		if(up){
			for(int j=lengthofsnake-1;j>=0;j--){
				snakexlength[j+1] = snakexlength[j];
			}
			for(int j=lengthofsnake;j>=0;j--){
				if(j==0){
				snakeylength[j] = snakeylength[j]-25;
			}
				else{
				 snakeylength[j]=snakeylength[j-1];
				}
			if(snakeylength[j] < 75){
				snakeylength[j] = 625;
			}
			repaint();
		}
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			moves = 0;
			scores = 0;
			lengthofsnake = 3;
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			moves++;
			right=true;
			if(!left){
				right = true;
			}
			else{
				right = false;
				left = true;
			}
			    up = false;
			    down = false;
		}
	
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			moves++;
			left=true;
			if(!right){
				left = true;
			}
			else{
				left = false;
				right = true;
			}
			    up = false;
			    down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			moves++;
			up=true;
			if(!down){
				up = true;
			}
			else{
				up = false;
				down = true;
			}
			    right = false;
			    left= false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			moves++;
			down=true;
			if(!up){
				down = true;
			}
			else{
				down = false;
				up = true;
			}
			    right = false;
			    left= false;
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
