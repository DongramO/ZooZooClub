package clinic;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.*;



import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.*;

public class pengame {

	
	
   public static void main(String[] args) {
      new intro();
   }

}

class intro extends JFrame
{
   final int menu = 4;
   public static int character1 = 0;
   Container c1 = getContentPane();
   
   static JPanel c = new JPanel();
   JPanel settingP = new JPanel();
   JPanel ruleP = new JPanel();

   frame f;
  public static Ranking Ran;

   JLabel rule = new JLabel();
   JLabel setting = new JLabel();

   JLabel GSL[] = new JLabel[menu];
   JLabel pen = new JLabel();
   JLabel mon = new JLabel();
   JLabel fox = new JLabel();
   JLabel leo = new JLabel();

   JLabel check = new JLabel();
   JLabel selectchar[] = new JLabel[4];
   JLabel XX[] = new JLabel[menu - 1];
   JLabel select = new JLabel();
   JLabel logo = new JLabel();
   JLabel rulelabel[] = new JLabel[6];

   ImageIcon GS[] = new ImageIcon[menu];
   ImageIcon chGS[] = new ImageIcon[menu];
   ImageIcon character[] = new ImageIcon[4];
   ImageIcon bigcharacter[] = new ImageIcon[4];
   ImageIcon Select = new ImageIcon();
   ImageIcon ruleicon[] = new ImageIcon[6];

   AudioClip clip, clip2, clip3, clip4, clip6, backbgm;
   static AudioClip clip5;

   menulistener menulistener = new menulistener();
   gameruleListener gameruleListener = new gameruleListener();
   settingListener settingListener = new settingListener();
   nulllistener nulllistener = new nulllistener();
   RankingListener RankingListener = new RankingListener();
   rankinglistener1 rankinglistener = new rankinglistener1();
   Button bbb = new Button();
      
   final int x = 640, y = 120; // 메뉴아이콘 위치
   final int xsize = 350, ysize = 120; // 메뉴아이콘크기
   final int cxsize = 1200, cysize = 600; // 화면크기
   final int MOVE = 20; // 캐릭터가 한번 움직이는 거리
   int xpen = 30, ypen = 260; // 캐릭터의 초기좌표
   int xmon = 0, ymon = -50;
   int xfox = 270, yfox = -70;
   int xleo = 1000, yleo = 70;

   int logox = 55, logoy = 0;
   int XXx = 1020, XXy = 130;

   int charpitch = 230;
   int charsizex = 200, charsizey = 250;
   int charx = 150, chary = 230;

   move2 move = new move2();

   public Container getPanel1() {
      return c1;
   }

   intro() {
	  Ran = new Ranking();
      c1.add(c);
      c1.setLayout(null);
      setTitle("ZOO ZOO CLUB");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      c.setLayout(null);
      c.setSize(cxsize, cysize);
      c.setLocation(0, 0);
      c.setBackground(Color.white);

      c1.add(Ran);

      Ran.setVisible(false);

      c.add(settingP);
      settingP.setLayout(null);
      settingP.setSize(cxsize, cysize);
      settingP.setLocation(0, 0);
      settingP.setVisible(false);

      c.add(ruleP);
      ruleP.setLayout(null);
      ruleP.setSize(cxsize, cysize);
      ruleP.setLocation(0, 0);
      ruleP.setVisible(false);

      URL audioURL = getClass().getResource("Up.wav");
      clip = Applet.newAudioClip(audioURL);
      URL audioURL2 = getClass().getResource("coin.wav");
      clip2 = Applet.newAudioClip(audioURL2);
      URL audioURL3 = getClass().getResource("start.wav");
      clip3 = Applet.newAudioClip(audioURL3);
      URL audioURL4 = getClass().getResource("bgm_1.wav");
      backbgm = Applet.newAudioClip(audioURL4);
      backbgm.play();
      URL audioURL5 = getClass().getResource("Swimming.wav");
      clip4 = Applet.newAudioClip(audioURL5);
      URL audioURL6 = getClass().getResource("Stomp.wav");
      clip5 = Applet.newAudioClip(audioURL6);
      URL audioURL7 = getClass().getResource("Throwing fireball.wav");
      clip6 = Applet.newAudioClip(audioURL7);

      ImageIcon logos = new ImageIcon("image/zoozoo.png");

      logo.setIcon(logos);
      c.add(logo);
      logo.setSize(600, 600);
      logo.setLocation(logox, logoy);

      ImageIcon X = new ImageIcon("image/x.png");

      for (int i = 0; i < XX.length; i++)
      {
         XX[i] = new JLabel();
         XX[i].setIcon(X);
         XX[i].setSize(50, 50);
         XX[i].setLocation(XXx, XXy);
      }

      ruleP.add(XX[0]);
      settingP.add(XX[1]);
      Ran.add(XX[2]);
      
      XX[0].addMouseListener(gameruleListener);
      XX[1].addMouseListener(settingListener);

      ImageIcon checking = new ImageIcon("image/check.gif");
      check.setIcon(checking);

      ImageIcon Select = new ImageIcon("image/select.png");
      select.setIcon(Select);
      settingP.add(select);
      select.setSize(800, 81);
      select.setLocation(140, 130);
      
      
      settingP.add(check);
      check.setSize(100, 150);
      check.setLocation(0, 0);
      check.setVisible(false);

      for (int j = 0; j < selectchar.length; j++) {
         character[j] = new ImageIcon("image/character" + (j + 1) + ".png");
         bigcharacter[j] = new ImageIcon("image/bigcharacter" + (j + 1) + ".png");

         selectchar[j] = new JLabel();
         selectchar[j].setIcon(character[j]);
         settingP.add(selectchar[j]);

         selectchar[j].setSize(charsizex, charsizey);
         selectchar[j].setLocation(charx + charpitch * j, chary);

         selectchar[j].addMouseListener(settingListener);
      }

      ImageIcon peng = new ImageIcon("image/minipenupdown.gif");
      ImageIcon monk = new ImageIcon("image/monupdown.gif");
      ImageIcon foxx = new ImageIcon("image/foxupdown.gif");
      ImageIcon leop = new ImageIcon("image/leoupdown.gif");

      pen.setIcon(peng);
      mon.setIcon(monk);
      fox.setIcon(foxx);
      leo.setIcon(leop);

      c.add(pen);
      pen.setSize(400, 400);
      pen.setLocation(xpen, ypen);

      c.add(mon);
      mon.setSize(400, 400);
      mon.setLocation(xmon, ymon);

      c.add(fox);
      fox.setSize(400, 400);
      fox.setLocation(xfox, yfox);

      c.add(leo);
      leo.setSize(400, 400);
      leo.setLocation(xleo, yleo);

      for (int i = 0; i < GSL.length; i++) {

         GS[i] = new ImageIcon("image/GS" + (i + 1) + ".png");
         chGS[i] = new ImageIcon("image/bigGS" + (i + 1) + ".png");

         GSL[i] = new JLabel();
         GSL[i].setIcon(GS[i]);
         c.add(GSL[i]);

         GSL[i].setSize(xsize, ysize);
         if (i % 2 == 1)
            GSL[i].setLocation(x, y * i + 20);
         else
            GSL[i].setLocation(x + 80, y * i + 20);
         GSL[i].addMouseListener(menulistener);

      }

      for (int j = 0; j < rulelabel.length; j++) {
         rulelabel[j] = new JLabel();
         ruleP.add(rulelabel[j]);
         rulelabel[j].addMouseListener(gameruleListener);
      }

      ruleicon[0] = new ImageIcon("image/rule1.png");
      rulelabel[0].setIcon(ruleicon[0]);
      ruleicon[1] = new ImageIcon("image/rule2.png");
      rulelabel[1].setIcon(ruleicon[1]);
      ruleicon[2] = new ImageIcon("image/rule3.png");
      rulelabel[2].setIcon(ruleicon[2]);
      ruleicon[3] = new ImageIcon("image/rule4.png");
      rulelabel[3].setIcon(ruleicon[3]);
      ruleicon[4] = new ImageIcon("image/star.gif");
      rulelabel[4].setIcon(ruleicon[4]);
      ruleicon[5] = new ImageIcon("image/timer.gif");
      rulelabel[5].setIcon(ruleicon[5]);

      ImageIcon settings = new ImageIcon("image/setting.png");
      setting.setIcon(settings);
      settingP.add(setting);

      setting.setSize(1000, 400);
      setting.setLocation(100, 100);

      settingP.addMouseListener(nulllistener);

      ruleP.addMouseListener(nulllistener);

      setSize(cxsize, cysize);
      setVisible(true);

      c.addKeyListener(move);

      c.requestFocus();

      Ran.addKeyListener(RankingListener);
      Ran.p.addMouseListener(rankinglistener);
      Ran.gointro.addMouseListener(rankinglistener);
      Ran.restart.addMouseListener(rankinglistener);
      Ran.btn.addActionListener(bbb);

   }

   public void gamestart() {
      c.setVisible(false);

      f = new frame();
      c1.add(f);

      f.setSize(1200, 600);
      f.setLocation(0, 0);
      f.setBackground(Color.white);
      f.setVisible(true);
      f.requestFocus();
      Ran.setSize(1000, 400);
      Ran.setLocation(90, 80);
      Ran.setVisible(true);
      Ran.gointro.setVisible(true);
      Ran.restart.setVisible(true);
      Ran.btn.setVisible(true);
      
      c.setVisible(false);

   }

   public void gamerule() {

      if (ruleP.isShowing())
         ruleP.setVisible(false);
      else
         ruleP.setVisible(true);

      rulelabel[0].setSize(680, 300);
      rulelabel[0].setLocation(220, 150);
      rulelabel[0].setVisible(true);
      rulelabel[1].setSize(130, 130);
      rulelabel[1].setLocation(900, 250);
      rulelabel[1].setVisible(true);

      rulelabel[2].setSize(680, 300);
      rulelabel[2].setLocation(350, 150);
      rulelabel[2].setVisible(false);
      rulelabel[3].setSize(130, 130);
      rulelabel[3].setLocation(190, 250);
      rulelabel[3].setVisible(false);
      rulelabel[4].setSize(100, 100);
      rulelabel[4].setLocation(383, 240);
      rulelabel[4].setVisible(false);
      rulelabel[5].setSize(100, 100);
      rulelabel[5].setLocation(383, 340);
      rulelabel[5].setVisible(false);

      ImageIcon rules = new ImageIcon("image/rule.png");
      rule.setIcon(rules);
      ruleP.add(rule);

      rule.setSize(1000, 400);
      rule.setLocation(100, 100);

   }

   public void gamesetting() {

      if (settingP.isShowing())
         settingP.setVisible(false);
      else
         settingP.setVisible(true);

   }

   public void gameranking() {
      Ran.gointro.setVisible(false);
      Ran.restart.setVisible(false);

      Ran.setSize(1000, 400);
      Ran.setLocation(90, 80);
      c.setVisible(false);
      Ran.setVisible(true);
      Ran.requestFocus();

   }

   class gameruleListener implements MouseListener {
      public void mouseClicked(MouseEvent e) {
         JLabel p1 = (JLabel) e.getSource();
         if (p1.equals(XX[0])) {
            ruleP.setVisible(false);
            clip5.play();
         }
         if (p1.equals(rulelabel[1])) {
            rulelabel[0].setVisible(false);
            rulelabel[1].setVisible(false);
            clip6.play();
            rulelabel[2].setVisible(true);
            rulelabel[3].setVisible(true);
            rulelabel[4].setVisible(true);
            rulelabel[5].setVisible(true);
         }
         if (p1.equals(rulelabel[3])) {
            rulelabel[2].setVisible(false);
            rulelabel[3].setVisible(false);
            rulelabel[4].setVisible(false);
            rulelabel[5].setVisible(false);
            clip6.play();
            rulelabel[0].setVisible(true);
            rulelabel[1].setVisible(true);
         }
      }

      public void mouseEntered(MouseEvent e) {
      }

      public void mouseExited(MouseEvent e) {
      }

      public void mousePressed(MouseEvent e) {
      }

      public void mouseReleased(MouseEvent e) {
      }

   }

   class settingListener implements MouseListener {
      public void mouseClicked(MouseEvent e) {
         JLabel p1 = (JLabel) e.getSource();

         if (p1.equals(XX[1])) {
            settingP.setVisible(false);
            clip5.play();
         }

         else
            for (int i = 0; i < selectchar.length; i++) {
               if (p1.equals(selectchar[i])) {
                  if (i == 0)
                     check.setLocation(selectchar[i].getX() + 80, selectchar[i].getY() + 50);
                  else
                     check.setLocation(selectchar[i].getX() + 65, selectchar[i].getY() + 50);
                  check.setVisible(true);
                  clip4.play();
                  character1 = i;

               }
            }

      }

      public void mouseEntered(MouseEvent e) {
      }

      public void mouseExited(MouseEvent e) {
      }

      public void mousePressed(MouseEvent e) {
      }

      public void mouseReleased(MouseEvent e) {
      }

   }

   class nulllistener implements MouseListener {
      public void mouseClicked(MouseEvent e) {
      }

      public void mouseEntered(MouseEvent e) {
      }

      public void mouseExited(MouseEvent e) {
      }

      public void mousePressed(MouseEvent e) {
      }

      public void mouseReleased(MouseEvent e) {
      }

   }

   class move2 implements KeyListener {
      public void keyPressed(KeyEvent e) {

         int kc = e.getKeyCode();

         switch (kc) {
         case KeyEvent.VK_UP:
            if (ypen < 0)
               ypen = ypen + cysize;
            ypen = ypen - MOVE;
            pen.setLocation(xpen, ypen);
            break;

         case KeyEvent.VK_DOWN:
            if (ypen > cysize)
               ypen = ypen - cysize;
            ypen = ypen + MOVE;
            pen.setLocation(xpen, ypen);
            break;

         case KeyEvent.VK_LEFT:
            if (xpen < 0)
               xpen = xpen + cxsize;
            xpen = xpen - MOVE;
            pen.setLocation(xpen, ypen);
            break;

         case KeyEvent.VK_RIGHT:
            if (xpen > cxsize)
               xpen = xpen - cxsize;
            xpen = xpen + MOVE;
            pen.setLocation(xpen, ypen);
            break;
         }

      }

      public void keyReleased(KeyEvent arg0) {

      }

      public void keyTyped(KeyEvent arg0) {

      }

   }

   class menulistener implements MouseListener {

      public void mouseClicked(MouseEvent e) {
         JLabel p1 = (JLabel) e.getSource();

         if (p1.equals(GSL[0])) {
            clip3.play();
            gamestart();
            backbgm.stop();
         } else if (p1.equals(GSL[1])) {
            clip.play();
            gamerule();
         } else if (p1.equals(GSL[2])) {
            clip.play();
            gamesetting();

         } else if (p1.equals(GSL[3])) {
            clip.play();
            gameranking();

         }

      }

      public void mouseEntered(MouseEvent e) {
         try {
            JLabel p1 = (JLabel) e.getSource();

            clip2.play();

            for (int i = 0; i < GSL.length; i++) {
               if (p1.equals(GSL[i])) {
                  GSL[i].setIcon(chGS[i]);
                  GSL[i].setSize(xsize + 100, ysize + 50);
                  GSL[i].setLocation(GSL[i].getX(), GSL[i].getY() - 25);
               }
            }
         } catch (Exception E) {

         }
      }

      public void mouseExited(MouseEvent e) {
         try {
            JLabel p1 = (JLabel) e.getSource();

            for (int i = 0; i < GSL.length; i++) {
               if (p1.equals(GSL[i])) {
                  GSL[i].setIcon(GS[i]);
                  GSL[i].setSize(xsize, ysize);
                  GSL[i].setLocation(GSL[i].getX(), GSL[i].getY() + 25);
               }
            }
         } catch (Exception E) {

         }
      }

      public void mousePressed(MouseEvent arg0) {
      }

      public void mouseReleased(MouseEvent arg0) {
      }

   }
   
   class Button extends Ranking implements ActionListener {
      
      
      public void actionPerformed(ActionEvent e)
      {
         // TODO Auto-generated method stub
         
         JButton button = (JButton) e.getSource();
         Ran.scoreinput.setText(Ran.scoreinput.getText());
         
         Ran.input();
         Ran.zero();
         Ran.ranking();
         
      }
   }
   
   class RankingListener implements KeyListener {
      public void keyPressed(KeyEvent e) {
      }

      public void keyReleased(KeyEvent e) {
         int kc = e.getKeyCode();
         switch (kc) {
         case 27:
//            Ran.input();
//            Ran.zero();
            Ran.ranking();
            clip5.play();
            Ran.btn.setVisible(false);
            Ran.setVisible(false);
            c.setVisible(true);
         }
      }

      public void keyTyped(KeyEvent arg0) {

      }
   }

   class rankinglistener1 implements MouseListener {
      public void mouseClicked(MouseEvent e) {
         JLabel p1 = (JLabel) e.getSource();
         if (p1.equals(Ran.p)) {
//            Ran.input();
//            Ran.zero();
            Ran.ranking();
            clip5.play();
            Ran.setVisible(false);
            c.setVisible(true);
            
         } else if (p1.equals(Ran.restart)) {
            gamestart();

         } else if (p1.equals(Ran.gointro)) {
            Ran.setVisible(false);
            c.setVisible(true);

         }

      }

      public void mouseEntered(MouseEvent e) {
      }

      public void mouseExited(MouseEvent e) {
      }

      public void mousePressed(MouseEvent e) {
      }

      public void mouseReleased(MouseEvent e) {
      }

   }
}
class frame extends JPanel implements KeyListener , Runnable
{
	JPanel c;
	Ranking r;
	int f_width;
	int f_height;
	int x,y;
	int k=0;
	int[] cy = {0, 0 ,0, 0, 0 }; // 배경속도 제어
	int[] cr = {0, 0, 0, 0, 0, 0 };
	int bx = 0; // 배경 스크롤 변수
	int ran =-1;
	int ran1 =-1;
	int ran2 =-1;
	int ran3 =-1;
	int type;

	boolean KeyUp = false;
	boolean KeyDown = false;
	boolean KeyLeft = false;
	boolean KeyRight = false;
	boolean KeySpace = false;
	
	AudioClip gameback,gameover,jump,big,getitem,crashitem;
	int missile_Speed;			 // 미사일이 날라가는 속도 조절할 변수
	int fire_Speed; 			// 미사일 연사 속도 조절 변수
	int enemy_speed; 		// 적 이동 속도 설정
	static int game_Score; 			// 게임 점수 계산
	int player_Speed;			// 유저의 캐릭터가 움직이는 속도를 조절할 변수
	int enemy_Speed;
	int enemy_Speed1;
	int jump_Speed; 			// 점프하는 속도 변수
	int player_Status = 0 ; 	//기본 상태를 0으로 지정
	int Item_Speed;
	int cnt;
//	static int game_score;
	int player_hitpoint;
	int Star_Speed;
	long Game_Speed;
	int imagex_size[];
	int imagey_size[];
	int season=0;
	int item_kind=0;
	int jump_term=30;
	final int SNOWS = 20;
	int bigsize=100;
	boolean flag = true; 	 //게임종료시 스레드를 빠져나오기 위한 변수
	
	Image[] Player_img;	Image[] Player_img1;	Image[] Player_img2; 	Image[] Player_img3;
	Image[] Background_img; Image[] LRock_img;	Image[] RRock_img;	Image[] Cloud_img;
	Image[] Crash_img;	Image[] Enemy_img;	Image[] Enemy_img1;	Image[] Enemy_img2;
	Image[] Enemy_img3;	Image[] player_Hitpoint; // 플레이어 캐릭터의 체력
	Image[] Item_img;	Image[] Item_img1;	Image[] Item_img2;	Image[] Back_img;
	Image[] Ground_img;	Image[] Speed_img;
	Image[] show_char = new Image[5];
	Image[] show_enemy = new Image[4];
	Image Gameover;
	int[] arr_x;	int[] arr_y;
	
	ArrayList jump_List = new ArrayList();
	ArrayList<Enemy1> Enemy_List = new ArrayList();
	ArrayList Explosion_List = new ArrayList();
	ArrayList<Item> Item_List = new ArrayList();
	ArrayList<Item> Star_List = new ArrayList();
	ArrayList<Item> Big_List = new ArrayList();
	ArrayList<Image[]> Enemy = new ArrayList();
	Vector<Point> SnowVector = new Vector<Point>();
	ArrayList<Image[]> Character = new ArrayList<Image[]>();
	// 게임 실행에 필요한 각종 객체 선언
	
	 int po_x=100;	 int po_y=100;
	
	Thread th;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image buffImage;
	Graphics buffg;
	Enemy1 en;
	Item item;
	Item item1;
	Item item2;
	Thread ri;
	intro intro;
	
    frame()
   {
      init();
      start();
         
   }
   
    public void init()
	{
		x=550;
		y=400;
		
		player_Speed = 15; 		//유저 캐릭터 움직이는 속도 설정
		
		f_width=1200;
		f_height=600;
		
		Ground_img=new Image[4];
		Ground_img[0] = new ImageIcon("Images/ground_0.gif").getImage();
		Ground_img[1] = new ImageIcon("Images/ground_1.png").getImage();
		Ground_img[2] = new ImageIcon("Images/ground_2.png").getImage();
		Ground_img[3] = new ImageIcon("Images/ground_3.png").getImage();
	
		Enemy_img = new Image[4];
		Enemy_img1 = new Image[4];
		Enemy_img2 = new Image[4];
		Enemy_img3 = new Image[4];
		
		Enemy.add(Enemy_img);
		Enemy.add(Enemy_img1);
		Enemy.add(Enemy_img2);
		Enemy.add(Enemy_img3);
		
		for(int i =0 ; i< Enemy_img.length; ++i)
		{
			Enemy_img[i] = new ImageIcon("Images/1_enemy_"+i+".png").getImage();
			Enemy_img1[i] = new ImageIcon("Images/2_enemy_"+i+".png").getImage();
			Enemy_img2[i] = new ImageIcon("Images/3_enemy_"+i+".png").getImage();
			Enemy_img3[i] = new ImageIcon("Images/4_enemy_"+i+".png").getImage();
		}
			
		Player_img = new Image[5];
		Player_img1 = new Image[5];
		Player_img2 = new Image[5];
		Player_img3 = new Image[5];
		
		Character.add(Player_img);
		Character.add(Player_img1);
		Character.add(Player_img2);
		Character.add(Player_img3);
		
		for(int i=0 ; i < Player_img.length ; ++i)
		{
			Player_img3[i] = new ImageIcon("Images/pen_"+i+".png").getImage();
			Player_img2[i] = new ImageIcon("Images/leo_"+i+".png").getImage();
			Player_img[i] = new ImageIcon("Images/fox_"+i+".png").getImage();
			Player_img1[i] = new ImageIcon("Images/mon_"+i+".png").getImage();
		}
		
		Background_img = new Image[4];
		
		for(int i =0 ; i<Background_img.length; ++i)
		{
			Background_img[i] = new ImageIcon("Images/back_"+i+".png").getImage();
		}
	
		
		LRock_img  = new Image[6];
		RRock_img  = new Image[6];
		Cloud_img = new Image[6];
		player_Hitpoint = new Image[3];
		Item_img = new Image[5];
		Item_img1 = new Image[5];
		Item_img2 = new Image[5];
		imagex_size = new int[5];
		imagey_size = new int[5];
		Back_img = new Image[4];
		Gameover = new ImageIcon("images/gameover.gif").getImage();
		for(int i= 0; i<Item_img.length ; ++i)
		{
			Item_img[i] = new ImageIcon("Images/Item_0.png").getImage();
			Item_img1[i] = new ImageIcon("Images/Item_1.gif").getImage();
			Item_img2[i] = new ImageIcon("Images/Item_2.gif").getImage();
		}
		
		for (int i = 0; i < Cloud_img.length; ++i)
		{
			Cloud_img[i] =	new ImageIcon("Images/cloud_0.png").getImage();
		}
		
		for(int i =0; i < LRock_img.length ; ++i)
		{
			LRock_img[i]= new ImageIcon("Images/LSide_"+i+".gif").getImage();
			RRock_img[i]= new ImageIcon("Images/RSide_"+i+".gif").getImage();
		}
		
		for(int i=0; i< player_Hitpoint.length ; i++)
		{
			player_Hitpoint[i] = new ImageIcon("Images/heart.png").getImage();
		}
		
		Back_img[0] = new ImageIcon("Images/fullback.png").getImage();
		Back_img[1] = new ImageIcon("Images/fullback1.gif").getImage();
		Back_img[2] = new ImageIcon("Images/fullback2.png").getImage();
		Back_img[3] = new ImageIcon("Images/fullback3.png").getImage();
		
		for(int i=0; i<SNOWS ;i++)
		{
			Point p = new Point((int)(Math.random()*1200),(int)(Math.random()*30));
			SnowVector.add(p);	
		}
		for(int i=0 ; i<5 ; i++)
		{
			imagex_size[i]=70	;
			imagey_size[i]=30;
		}
		
		Speed_img = new Image[10];
		for(int i=0; i<Speed_img.length ; ++i)
		{
			Speed_img[i] = new ImageIcon("Images/speedbar.png").getImage();
		}
		
		URL audioURL9 = getClass().getResource("bgm_2.wav");
		gameback = Applet.newAudioClip(audioURL9);
		
		URL audioURL8 = getClass().getResource("Gameover.wav");
		gameover = Applet.newAudioClip(audioURL8);
		
		URL audioURL7 = getClass().getResource("Jump.wav");
		 jump = Applet.newAudioClip(audioURL7);
		
		 URL audioURL6 = getClass().getResource("big.wav");
		 big = Applet.newAudioClip(audioURL6);
		 
		 URL audioURL5 = getClass().getResource("getitem.wav");
		 getitem = Applet.newAudioClip(audioURL5);
		
		 URL audioURL10 = getClass().getResource("crash.wav");
		 crashitem = Applet.newAudioClip(audioURL10);
	   
	    gameback.play();
		
		// 정수형 변수 초기화
//		character = 0;
		game_Score = 0;				//게임 스코어 초기화
		player_hitpoint=3;
		Item_Speed = 5;
		Star_Speed = 20;
		Game_Speed= 50;
		type =0;
		

	}
   public void start()
   {
      addKeyListener(this);
      th = new Thread(this);
      th.start();
   }
   public void run()
   {
      try
      {
         while(flag)
         {
            if(cnt % 50 ==0)
                  Game_Speed -=0.5;
            if(cnt%20 ==0)
               type=0;
            
            if(cnt <3000 && type ==0)
            {
               KeyProcess();
               EnemyProcess(); 
               ItemProcess();
               StarProcess();
               BigProcess();
               repaint(); 
               Thread.sleep(Game_Speed);
            }
            else
            {
               KeyProcess();
               EnemyProcess(); 
               ItemProcess();
               StarProcess();
               repaint(); 
               Thread.sleep(200);
            }
               cnt++;
            game_Score =cnt;
       }
         repaint();
         gameover.play();
         th.sleep(4000);
         
         setVisible(false);
        
         
      }
      catch(Exception e)
      {}
      
   }
   
   public void paint(Graphics g)
   {
      buffImage = createImage(f_width, f_height);
      buffg = buffImage.getGraphics();
      update(g);
   }
   public void update(Graphics g)
   {
	 if(player_Status != 6)
	 {
	      Draw_background();
	      Draw_Enemy();
	      Draw_Item();
	      Draw_Snow();
	      Draw_Star();
	      Draw_full();
	      Draw_Big();
	      Draw_StatusText();
	      Draw_Player(intro.character1);
	    
	 }
	 else
	 {
		  Draw_background();
	      Draw_Enemy();
	      Draw_Item();
	      Draw_Snow();
	      Draw_Star();
	      Draw_full();
	      Draw_Big();
	      Draw_StatusText();
	      Draw_Player(intro.character1);    
	      Draw_over();
	  }
      g.drawImage(buffImage, 0, 0, this);
   }
   public void Draw_Item()
   {
      for (int i = 0; i < Item_List.size(); ++i)
      {
         item = (Item) (Item_List.get(i));
         buffg.drawImage(Item_img[i], item.x, item.y,item.xsize,item.ysize, this);
         item.xsize +=1;
         item.ysize +=1;
      }    
    
   }
   public void Draw_Big()
   {
      for (int i = 0; i < Big_List.size(); ++i)
      {
         item2 = (Item) (Big_List.get(i));
         buffg.drawImage(Item_img2[i], item2.x, item2.y,item2.xsize,item2.ysize, this);
         item2.xsize +=1;
         item2.ysize +=1;
      }    
    
   }
   public void Draw_Star()
   {
      for (int i = 0; i < Star_List.size(); ++i)
      {
         item1 = (Item) (Star_List.get(i));
         buffg.drawImage(Item_img1[i], item1.x, item1.y,item1.xsize,item1.ysize, this);
         item1.xsize +=1;
         item1.ysize +=1;
      }
     
   }
   public void Draw_full()
   {
      for(int i=0; i<SNOWS; i++)
      {
          Point p = SnowVector.get(i);
          int xDir = Math.random() > 0.5 ? 1 : -1; // xDir이 1이면 오른쪽으로, 아니면 왼쪽으로 눈을 이동시킨다.
          int offsetX = (int)(Math.random()*40)*xDir; // x 축으로 이동하는 최대 거리는 3 픽셀이다.
          int offsetY = (int)(Math.random()*20); // y 축으로 이동하는 최대 거리는 7 픽셀이다.
          p.x += offsetX;
          if(p.x < 0) p.x = 0;
          p.y += offsetY;
          if(p.y > getHeight())
          { // 눈이 떨어져서 패널을 벗어나게 되면 다시 패널의 위에서 시작하게 한다.
             p.x = (int)(Math.random()*getWidth());  // 다시 시작하는 x 위치는 패널 내의 랜덤한 위치
             p.y = 5; // 다시 시작하는 y 위치는 패널 내의 5 픽셀 위치
          }
      } 
   }
   public void Draw_Enemy()
      {
	   	if(cnt <200) season =0;
	    if(cnt>200 && cnt <=400) season =1;
	    if(cnt>400 && cnt <=600) season =2;
	   	if(cnt >600) season =3;
	
	   	show_enemy = Enemy.get(season);
	           
	   	for (int i = 0; i < Enemy_List.size(); ++i)
         {
	        en = (Enemy1) (Enemy_List.get(i));
            buffg.drawImage(show_enemy[en.k-1], en.x, en.y,en.xsize,en.ysize, this);
            en.xsize +=2;
            en.ysize +=2;
         }
           
      
      }
   public void Draw_background()
   {
      buffg.clearRect(0, 0, f_width, f_height);
      for(int i =0 ; i < cy.length; ++i)
      {
         if(cy[i] < 300)
         {
            cy[i] +=  i * 0.5;
         }
         else
         {
            cy[i] = 0;
         }
         
         if(i * 250 < 700)
         {
            buffg.drawImage(Cloud_img[i],  10+(i *150)-cy[i] , 50-cy[i], this);
         }
         else
            buffg.drawImage(Cloud_img[i],  i *150+cy[i] , 50-cy[i], this);
      }
      if(cnt <= 200)
    	  {
    	  	buffg.drawImage(Background_img[0], 0 ,0, 1200,200,this);
    	  	buffg.drawImage(Ground_img[0], -100, -90   , 1400, 700,this);
    	    buffg.drawImage(LRock_img[0], 0 , 100, this);
            buffg.drawImage(RRock_img[0], 900 , 100, this);
    	  }
      if(cnt>200 && cnt <=400)
    	  {
    	  	buffg.drawImage(Background_img[1], 0 ,0, 1200,200,this);
    	    buffg.drawImage(Ground_img[1],  0, 200, 1400, 365,this);
    	    buffg.drawImage(LRock_img[1], 0 , 100, 300, 500, this);
            buffg.drawImage(RRock_img[1], 900 , 100, 280, 500, this);
    	  }
      if(cnt>400 && cnt <=600)
    	  {
    	   buffg.drawImage(Background_img[2], 0 ,0, 1200,200,this);
    	   buffg.drawImage(Ground_img[2], 0, 60, 1200, 500,this);
    	   buffg.drawImage(LRock_img[2], 0 , 100, this);
           buffg.drawImage(RRock_img[2], 900 , 100, this);
    	  }
      if( cnt>600 )
	  	  {
    	  	buffg.drawImage(Background_img[3], 0 ,0, 1200,200,this);
    	  	buffg.drawImage(Ground_img[3], 0, 60, 1200, 500,this);
    	    buffg.drawImage(LRock_img[3], 0 , 100, this);
            buffg.drawImage(RRock_img[3], 900 , 100, this);
	  	  }
      
      
 }
   public void Draw_StatusText()
	{
		//상태 체크용  텍스트를 그립니다.
		buffg.setFont(new Font("Defualt", Font.BOLD, 20));
		
		buffg.drawString("SCORE : " + game_Score, 900, 70);
		buffg.drawString("SPEED :" , 900, 100);
		int speedbar = (cnt/30)%10; 
		for(int i=0 ; i < speedbar; ++i)
		{
			buffg.drawImage(Speed_img[i], 980+(i*13) , 83,10,20, this);
			
		}
		for(int i=0; i<player_hitpoint ; i++)
		{
			
			buffg.drawImage(player_Hitpoint[i], 30+(i*40), 50, this);
		
		}
		
		//좌표 x : 1000, y : 90에 플레이어 체력을 표시합니다.
//		buffg.drawString("Enemy Count : " + Enemy_List.size(), 1000, 130);
	
		
	}
   public void Draw_Player(int character)
   {
	  show_char = Character.get(character);
//	  System.out.println(player_Status);
	  switch (player_Status)
      {
    	
    	 case 0: // 평상시
            
            if ((cnt / 5 % 2) == 0)
            {
               buffg.drawImage(show_char[0], x, y,this);
            } 
            else
            {
               buffg.drawImage(show_char[1], x, y, this);
            }
            break;
            
         case 1: // 점프시
          
         buffg.drawImage(show_char[2], x, y, this);
         
          player_Status = 0;
         
            break;
         case 2: // 넘어짐
             buffg.drawImage(show_char[3], x, y, this);
//             player_Status= 0;
             break;
         case 3: // 빠짐
        	  if ((cnt / 5 % 2) == 0)
	              {
	        	    buffg.drawImage(show_char[0], x, y, this);
	              } 
	              else
	              {
	                 buffg.drawImage(show_char[3], x, y, this);
	              }
        	  if(cnt % 20 == 19)
        		  player_Status= 0;
            
             break;
         case 4: // 거대화
            
        	buffg.drawImage(show_char[4], x, (y-130)+50, 250, 250, this);
       
            if(cnt %100 == 99)
            {
            	player_Status=0;
            	bigsize =100;
            }
            break;
            
      }
      
   }
   public void Draw_Snow()

   { // 패널에 눈을 그린다.
      
       for(int i=1; i<SnowVector.size(); i++)
       {      
          Point p = SnowVector.get(i);
          if(cnt<200)
        	  buffg.drawImage(Back_img[0] , p.x,p.y,this);
          if(cnt >=200 && cnt <400)
        	  buffg.drawImage(Back_img[1] , p.x,p.y,27,27,this);
          if(cnt >=400 && cnt <600)
        	  buffg.drawImage(Back_img[2] , p.x,p.y,this);
          if(cnt >=600)
        	  buffg.drawImage(Back_img[3] , p.x,p.y,this);
       }
    }
   public void Draw_over()
   {
	   gameback.stop();
	   buffg.drawImage(Gameover ,100,0, 1000,400,this);
   
   }
   //장애물 충돌 메소드
   
   public boolean Crash(int x1, int y1, int x2, int y2, Image img1, Image img2)
   {
      //x,y 캐릭터위치  x2,y2 적위치  img1 캐릭터 im2 장애물
      //이제 이미지 변수를 바로 받아 해당 이미지의 넓이, 높이값을 바로 계산
      boolean check = false;
         
         if ( (y1 + img1.getHeight(null) / 2) < (y2 + img2.getHeight(null) / 2))
               {
                 //이미지 넓이, 높이값을 바로 받아 계산합니다.
                  if(player_Status == 1) 
                     check = false;  // 점프상태(player_Status =1)이면 충돌하지 않습니다.
                  
                  else
                  {
                	  if (Math.abs((x1 + img1.getWidth(null) / 2)
              				
              				- (x2 + img2.getWidth(null) / 2))
              				
              		< (img2.getWidth(null) / 2 + img1.getWidth(null) / 2)
              				
              				&& Math.abs((y1 + img1.getHeight(null) / 2)
              						
              						- (y2 + img2.getHeight(null) / 2))
              						
              		< (img2.getHeight(null) / 2 + img1.getHeight(null) / 2))
                     {
                		  if(player_Status ==4)
                			  check = false;
                		  else
        			   		  check=true;
                		  
                     }
                     else
                        check=false;
                  }
               }
               else
               {
                  check = false;
               }
   
      
      return check; //check의 값을 메소드에 리턴 시킵니다.
      
   }
   //아이템 습득 메소드
   public boolean ItemCrash(int x1, int y1, int x2, int y2, Image img1, Image img2,int item_kind)
   {
      //x,y 캐릭터위치  x2,y2 적위치  img1 캐릭터 im2 장애물
      //이제 이미지 변수를 바로 받아 해당 이미지의 넓이, 높이값을 바로 계산
      boolean check = false;
         
      if (Math.abs((x1 + img1.getWidth(null) / 2)
				
				- (x2 + img2.getWidth(null) / 2))
				
		< (img2.getWidth(null) / 2 + img1.getWidth(null) / 2)
				
				&& Math.abs((y1 + img1.getHeight(null) / 2)
						
						- (y2 + img2.getHeight(null) / 2))
						
		< (img2.getHeight(null) / 2 + img1.getHeight(null) / 2))
               {
                 //이미지 넓이, 높이값을 바로 받아 계산합니다.
        	 
                  if(player_Status == 1) 
                        check = false;  // 점프상태(player_Status =1)이면 충돌하지 않습니다.
                  
                  else
                  {
                       if(player_hitpoint >0 && player_hitpoint <3 && item_kind==1)
                        {
                        	getitem.play();
                            player_hitpoint++;
                            check= true;
                        }
                        else
                        {
                        	getitem.play();
                        	check =true;
                        }
                 }
               }
         else
         {
         	check = false;
         }
         return check; //check의 값을 메소드에 리턴 시킵니다.
      
   }
   public void ItemProcess()
   {
      
      for (int i = 0; i < Item_List.size(); ++i)
      {
         item = (Item) (Item_List.get(i));
         item.move(item);

         if (item.y > 600)
            {
            
               Item_List.remove(i);
            
            }
         if (ItemCrash(x, y, item.x, item.y, Player_img[0], Item_img[i],1))
         {
            //플레이어와 적의 충돌을 판정하여
            //boolean값을 리턴 받아 true면 아래를 실행합니다. 
            Item_List.remove(i); //적을 제거합니다.
         }
      }
      if(cnt % 20 ==0)
      {
            switch(ran1)
            {
               case 1:
                  item = new Item(460, 200, Item_Speed,1);
                  Item_List.add(item);
               break;
               case 2:   
                  item = new Item(570, 200, Item_Speed,2);
                  Item_List.add(item);
               break;
               case 3:
                  item = new Item(660,200,Item_Speed,3);
                  Item_List.add(item);
               break;
               case 4:
                  item = new Item(720,200,Item_Speed,4);
                  Item_List.add(item);
               break;
            }
               
            }
         ran1 =(int)( Math.random()*50)+1;
      
      }
   public void StarProcess()
   {
   
      for (int i = 0; i < Star_List.size(); ++i)
      {
         item = (Item) (Star_List.get(i));
         item.move(item);

         if (item.y > 800) Star_List.remove(i);
         if (ItemCrash(x, y, item.x, item.y, Player_img[0], Item_img1[i],2))
         {
            type =1;
            //플레이어와 적의 충돌을 판정하여
            //boolean값을 리턴 받아 true면 아래를 실행합니다. 
            Star_List.remove(i); //적을 제거합니다.
         }
      }
      
      
      if(cnt % 20 ==0)
      {
            switch(ran2)
            {
               case 1:
                  item = new Item(430, 200, Star_Speed,1);
                  Star_List.add(item);
               break;
               case 2:   
                  item = new Item(570, 200, Star_Speed,2);
                  Star_List.add(item);
               break;
               case 3:
                  item = new Item(715,200,Star_Speed,3);
                  Star_List.add(item);
               break;
               case 4:
                  item = new Item(740,200,Star_Speed,4);
                  Star_List.add(item);
               break;
            }
         }
      ran2 =(int)( Math.random()*50)+1;
   }
   public void BigProcess()
   {
   
      for (int i = 0; i < Big_List.size(); ++i)
      {
         item = (Item) (Big_List.get(i));
         item.move(item);

         if (item.y > 700) Big_List.remove(i);
         if (ItemCrash(x, y, item.x, item.y, Player_img[0], Item_img2[i],3))
         {
        	 player_Status=4;
        	 big.play();
             Big_List.remove(i); //적을 제거합니다.
         }
      }
      
      
      if(cnt % 20 ==0)
      {
            switch(ran3)
            {
               case 1:
                  item = new Item(430, 200, Star_Speed,1);
                  Big_List.add(item);
               break;
               case 2:   
                  item = new Item(570, 200, Star_Speed,2);
                  Big_List.add(item);
               break;
               case 3:
                  item = new Item(715,200,Star_Speed,3);
                  Big_List.add(item);
               break;
               case 4:
                  item = new Item(740,200,Star_Speed,4);
                  Big_List.add(item);
               break;
            }
         }
      ran3 =(int)( Math.random()*50)+1;
   }
   public void EnemyProcess()
   {
      
      for (int i = 0; i < Enemy_List.size(); ++i)
      {
         en = (Enemy1) (Enemy_List.get(i));
         en.move(en);
       
         if (en.y > 600)
         {
            Enemy_List.remove(i);
            
         }
         if (Crash(x, y, en.x, en.y, Player_img[0], Enemy_img[i]))
         {
        	 Enemy_List.remove(i); 
        	 player_Status =3;
        	 crashitem.play();
        
        
        	//        	 r.nowscoreview.setText(String.valueOf(game_Score));
//        	 if( player_Status == 3)
//        	     	 Draw_Player(player_Status);
//        	 
            //플레이어와 적의 충돌을 판정하여
            //boolean값을 리턴 받아 true면 아래를 실행합니다. 
        	 if(player_Status !=4)
        	 {
        		 player_hitpoint--; //플레이어 체력을 1깍습니다.
        	 	 cnt -= 100;
        	 }
            if(player_hitpoint == 0 )
            {
               flag = false;
               player_Status=6;
               game_Score = cnt;
               intro.Ran.ranking();
        	
            }
           //적을 제거합니다.
         }
      }
      
      enemy_Speed = (int)(Math.random()*20)+5;
      if(cnt % 20 ==0)
      {
            switch(ran)
            {
               case 1:
                  en = new Enemy1(400, 200, enemy_Speed,1);
                  Enemy_List.add(en);
               break;
               
               case 2:   
                  en = new Enemy1(535, 200, enemy_Speed,2);
                  Enemy_List.add(en);
               break;
               
               case 3:
                  en = new Enemy1(695, 200, enemy_Speed,3);
                  Enemy_List.add(en);
               break;
               
               case 4:
                  en = new Enemy1(750, 200, enemy_Speed,4);
                  Enemy_List.add(en);
               break;
            }
               
            }
      ran =(int)( Math.random()*5)+1;
            //적 움직임 속도를 추가로 받아 적을 생성한다.
         }
   public void KeyProcess()
   {   
      if (KeyLeft == true)
      {
         if (x > 150 )
            x -= 30;
      }
      if (KeyRight == true)
      {
         if (x < 950)
            x += 30;
       }
      if(KeySpace == true)
      {
         if(k ==0)
         {
            y -= 100;
            k=1;
         }
         player_Status = 1;
      }
   }
   public void keyPressed(KeyEvent e)
   {
      switch (e.getKeyCode())
      {
         
         case KeyEvent.VK_UP:
               KeyUp = true;
               break;
         case KeyEvent.VK_DOWN:
            KeyDown = true;
            break;
         case KeyEvent.VK_LEFT:
            KeyLeft = true;
            break;
         case KeyEvent.VK_RIGHT:
            KeyRight = true;
            break;
         case KeyEvent.VK_SPACE:
        	if(player_Status ==4)
        		KeySpace = false;
        	else
        	{
        		player_Status =0;
        		KeySpace = true;
        	}
            break;
            
      }
   }
   public void keyReleased(KeyEvent e)
   {
      switch (e.getKeyCode())
      {
         
         case KeyEvent.VK_UP:
            KeyUp = false;
            break;
            
         case KeyEvent.VK_DOWN:
            KeyDown = false;
            break;
            
         case KeyEvent.VK_LEFT:
            KeyLeft = false;
            break;
            
         case KeyEvent.VK_RIGHT:
            KeyRight = false;
            break;
            
         case KeyEvent.VK_SPACE:
            
            if(y < 350)
            {
            	jump.play();
                y+=100;
                k=0;
                player_Status=1 ;
            }
            if(player_Status ==4)
                  	KeySpace = false;
            else
            	player_Status=1 ;
         		KeySpace = false;
            
            break;
      }
   }
   @Override
   public void keyTyped(KeyEvent e)
   {}
}
class Item
{
   int x;
   int y;
   int speed;
   int k;
   int xsize;
   int ysize;
   Item(int x, int y, int speed, int k)
   {
      this.x=x;
      this.y=y;
      this.speed = speed;
      this.k=k;
      xsize=30;
      ysize=25;
   }
   void move(Item en)
   {
      y +=speed;
      if(k==1)   en.x -= 5;
      if(k==2) en.x -= 3;
      if(k==3) en.x += 3;
      if(k==4) en.x += 5;
   }
}
class Enemy1
{
   
   int x;
   int y;
   int speed; // 적 이동 속도 변수를 추가
   int k;
   int xsize;
   int ysize;
   Enemy1(int x, int y, int speed,int location)
   {
      
      this.x = x;
      this.y = y;
      this.speed = speed;
      this.k =location;
      xsize=50;
      ysize=25;
      // 객체 생성시 속도 값을 추가로 받습니다.
   }
   
   public void move(Enemy1 en)
   {
      y += speed;// 적이동속도만큼 이동
      
      if(k==1) en.x -= 5;
      if(k==2) en.x -= 3;
      if(k==3) en.x += 3;
      if(k==4) en.x += 5;
   }
}
class Ranking extends JPanel {

	   JLabel nowscoreview= new JLabel();
	      JLabel nowscore;
	      JTextField scoreinput = new JTextField("이동수");
	   	  JLabel p;
	   	  JLabel name1 = new JLabel("d");
	      JLabel rank1 =  new JLabel("d");
	      JLabel name2 = new JLabel("d");
	      JLabel rank2 = new JLabel("d");
	      JLabel name3 =  new JLabel("d");
	      JLabel rank3=  new JLabel("d");
	      JLabel name4 =  new JLabel("d");
	      JLabel rank4 = new JLabel("d");
	      JLabel name5=  new JLabel("d");
	      JLabel rank5=  new JLabel("d");
	      JLabel score1=  new JLabel("d");
	      JLabel score2=  new JLabel("d");
	      JLabel score3=  new JLabel("d");
	      JLabel score4=  new JLabel("d");
	      JLabel score5 = new JLabel("d");
	   File file = new File("text.txt");
	   String[] name = new String[100];
	   int[] score = new int[100];
	   intro t;
	   ImageIcon icon;
	   ImageIcon btb = new ImageIcon("images/btb.png");
	   JButton btn = new JButton("등록",btb);
	   JLabel restart = new JLabel();
	   JLabel gointro = new JLabel();
	   ImageIcon res = new ImageIcon("image/restart.png");
	   ImageIcon goi = new ImageIcon("image/gointro.png");
	   frame f;
	 
	  
	   Ranking() {
	   

	      JLabel Crownp = new JLabel();
	      JLabel goldp = new JLabel();
	      JLabel silverp = new JLabel();
	      JLabel bronzep = new JLabel();
	      JLabel background;
	      
	      ranking();
	      background = new JLabel() {
	         public void paintComponent(Graphics g) {
	            g.drawImage(icon.getImage(), 0, 0, null);
	            setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
	            super.paintComponent(g);
	         }
	      };
	      this.add(background);
	      background.setLayout(null);
	      background.setLocation(0, 0);
	      background.setSize(1000, 400);
	      background.setOpaque(true);
	      background.setBackground(Color.blue);
	      ImageIcon rankP = new ImageIcon("image/rank.png");
	      background.setIcon(rankP);

	      ImageIcon X = new ImageIcon("image/x.png");
	      p = new JLabel();
	      p.setLocation(925, 25);
	      p.setSize(50, 50);
	      p.setIcon(X);

	      background.add(p);
	      setSize(1000, 400);

	      restart.setIcon(res);
	      background.add(restart);
	      restart.setSize(300, 150);
	      restart.setLocation(190, 240);
	      gointro.setIcon(goi);
	      background.add(gointro);
	      gointro.setSize(300, 150);
	      gointro.setLocation(560, 240);
	      background.add(btn);
	      btn.setLocation(780,240);
	      btn.setSize(70,26);
	      btn.setText("등록");

	      JLabel rank = new JLabel("RANKING");
	      rank.setBounds(130, 200, 300, 50);
	      rank.setFont(new Font("돋음", Font.BOLD, 30));

	      
	      
	      nowscore = new JLabel("SCORE: ");
	     
	      JButton button = new JButton("등록");
	      Button d = new Button();
//	      button.addActionListener(d);

	      ImageIcon crown = new ImageIcon("images/Crown.png");
	      Crownp.setIcon(crown);
	      background.add(Crownp);
	      Crownp.setSize(160, 160);
	      Crownp.setLocation(120, 50);

	      ImageIcon gold = new ImageIcon("images/gold1.png");
	      goldp.setIcon(gold);
	      background.add(goldp);
	      goldp.setSize(160, 160);
	      goldp.setLocation(450, -5);

	      ImageIcon silver = new ImageIcon("images/Silver.png");
	      silverp.setIcon(silver);
	      background.add(silverp);
	      silverp.setSize(160, 160);
	      silverp.setLocation(450, 25);

	      ImageIcon bronze = new ImageIcon("images/Bronze.png");
	      bronzep.setIcon(bronze);
	      background.add(bronzep);
	      bronzep.setSize(160, 160);
	      bronzep.setLocation(450, 55);

	    
	      rank1.setBounds(500, 50, 100, 50);
	      rank1.setFont(new Font("돋음", Font.BOLD, 20));
	    
	      name1.setBounds(650, 50, 100, 50);
	      name1.setFont(new Font("돋음", Font.BOLD, 20));
	      
	      rank2.setBounds(500, 80, 100, 50);
	      rank2.setFont(new Font("돋음", Font.BOLD, 20));
	    
	      name2.setBounds(650, 80, 100, 50);
	      name2.setFont(new Font("돋음", Font.BOLD, 20));
	     
	      rank3.setBounds(500, 110, 100, 50);
	      rank3.setFont(new Font("돋음", Font.BOLD, 20));
	  
	      name3.setBounds(650, 110, 100, 50);
	      name3.setFont(new Font("돋음", Font.BOLD, 20));
	 
	      rank4.setBounds(500, 140, 100, 50);
	      rank4.setFont(new Font("돋음", Font.BOLD, 20));
	   
	      name4.setBounds(650, 140, 100, 50);
	      name4.setFont(new Font("돋음", Font.BOLD, 20));
	 
	      rank5.setBounds(500, 170, 100, 50);
	      rank5.setFont(new Font("돋음", Font.BOLD, 20));
	    
	      name5.setBounds(650, 170, 100, 50);
	      name5.setFont(new Font("돋음", Font.BOLD, 20));

	  
	      score1.setBounds(800, 50, 100, 50);
	      score1.setFont(new Font("돋음", Font.BOLD, 20));
	  
	      score2.setBounds(800, 80, 100, 50);
	      score2.setFont(new Font("돋음", Font.BOLD, 20));
	   
	      score3.setBounds(800, 110, 100, 50);
	      score3.setFont(new Font("돋음", Font.BOLD, 20));
	      
	      score4.setBounds(800, 140, 100, 50);
	      score4.setFont(new Font("돋음", Font.BOLD, 20));
	     
	      score5.setBounds(800, 170, 100, 50);
	      score5.setFont(new Font("돋음", Font.BOLD, 20));
	      nowscore.setBounds(500, 240, 100, 25);
	      nowscore.setFont(new Font("돋음", Font.BOLD, 20));

	      nowscoreview.setText("0");//String.valueOf(f.game_score));
	      nowscoreview.setBounds(600, 240, 100, 25);
	      nowscoreview.setFont(new Font("돋음", Font.BOLD, 20));

	      scoreinput.setBounds(650, 240, 120, 25);
	      button.setBounds(780, 240, 60, 25);

	      icon = new ImageIcon("image.rank.png");

	      // 배경 Panel 생성후 컨텐츠페인으로 지정
	      background.add(rank);
	      background.add(rank1);
	      background.add(name1);
	      background.add(rank2);
	      background.add(name2);
	      background.add(rank3);
	      background.add(name3);
	      background.add(rank4);
	      background.add(name4);
	      background.add(rank5);
	      background.add(name5);
	      background.add(score1);
	      background.add(score2);
	      background.add(score3);
	      background.add(score4);
	      background.add(score5);
	      background.add(scoreinput);
	      background.add(nowscoreview);
//	      background.add(button);
	      background.add(nowscore);
	      setVisible(true);

	   }
	   
	   
	      void input() {
	         try {

	            FileWriter fw = new FileWriter("text.txt", true);
	            // String data =
	            // fw.write(.getText());
	            
	            name[5] = scoreinput.getText();
	           
	            String a = nowscoreview.getText();
	            score[5] = Integer.parseInt(a);
	            
	            fw.write(name[5] + " " + score[5]);
	            fw.write("\r\n");

	            fw.close();

	            // fw.flush();
	         } catch (IOException ex) {
	          
	         }

	      }

	      void zero() {
	      
	         for (int i = 0; i < 100; i++)
	         {
	        	score[i] = 0;
	            name[i] = null;

	         }
	         
	      }

	      void ranking()
	      {
	    	  nowscoreview.setText(Integer.toString(f.game_Score));
	    	  
	         HashMap<String, Integer> map = new HashMap<String, Integer>();
	         try {

	        	 
	        	 
	            Scanner sc = new Scanner(new FileInputStream(file));
	            FileReader m_reader = new FileReader(file);

	            String[] s = new String[100];

	            int i = 0;

	            while (sc.hasNext()) {

	               s[i] = sc.nextLine();
	               StringTokenizer st = new StringTokenizer(s[i], " ");
	               name[i] = st.nextToken();
	               score[i] = Integer.parseInt(st.nextToken());

	               int j, k = 0;
	               int temp1 = 0;
	               String temp = new String();
	        
	               
	                  for (j = 0; j < name.length; j++) {
	                     for (k = 0; k < name.length; k++) {
	                        if (score[j] > score[k]) {
	                           temp = name[j];
	                           name[j] = name[k];
	                           name[k] = temp;

	                           temp1 = score[j];
	                           score[j] = score[k];
	                           score[k] = temp1;
	                        }
	                     }
	                  }
	                  i++;
	               }
	            name1.setText(name[0]);
	            name2.setText(name[1]);
	            name3.setText(name[2]);
	            name4.setText(name[3]);
	            name5.setText(name[4]);
	            score1.setText(Integer.toString(score[0]));
	            score2.setText(Integer.toString(score[1]));
	            score3.setText(Integer.toString(score[2]));
	            score4.setText(Integer.toString(score[3]));
	            score5.setText(Integer.toString(score[4]));
	            m_reader.close();
	         } catch (FileNotFoundException e) {
	            e.printStackTrace();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }

	      }

	      void inputscore() {

	         for (int i = 0; i < 6; i++) {
	            if (name[i] == null) {
	               name[i] = scoreinput.getText();
	               String a = nowscoreview.getText();
	               score[i] = Integer.parseInt(a);

	            }
	            else
	            {
	               name[5] = scoreinput.getText();
	               String a = nowscoreview.getText();
	               score[5] = Integer.parseInt(a);
	            }

	         }

	      }

	   }