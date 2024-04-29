import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;import java.util.Timer;import java.util.TimerTask;
import javax.swing.border.*;
import java.net.*;
import java.awt.image.*;

public class Pyramid_cal extends JFrame{
	int nums[] = new int[10];int anss[] = new int[45];JTextField fields[] = new JTextField[45];
	ArrayList<JTextField> list = new ArrayList<JTextField>();boolean clear_bool = false;
	int n;Num nm = new Num();Num on = new Num();//nがピラミッドの段数(10,8,6)どれか
	JPanel pane;
	public Pyramid_cal(String title, int n){
		super(title);this.n=n;
		ImageIcon icon = new ImageIcon("pyramid_pic.jpg");
		setIconImage(icon.getImage());

		this.pane = (JPanel)getContentPane();this.pane.setBackground(Color.white.darker());
//		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(null);
		for(int i = 0; i < this.nums.length; i++){
			this.nums[i] = new Random().nextInt(10);
			while(this.nums[i]==0){
				this.nums[i] = new Random().nextInt(10);
			}
			this.anss[i] = this.nums[i];
		}int nn = 0;
		for(int i = 0; i < n; i++){
			int x = 400; int y = 50;if(n==8){y=100;}else if(n==6){y=150;}x -= i * 50; y += i * 50;
			for(int j = 0; j <= i; j++){
				if(i==n-1){
					JLabel label = new JLabel(""+this.nums[j]);
					label.setFont(new Font("Sefif", Font.BOLD, 43));
					label.setBounds(x+100, y, 100, 50);
					label.setOpaque(true);
					label.setBackground(Color.YELLOW);
					LineBorder border = new LineBorder(Color.BLACK, 2, true);
					label.setBorder(border);
					label.setHorizontalAlignment(JLabel.CENTER);
					pane.add(label);x+=100;
					continue;
				}
				JTextField field = new JTextField();this.fields[nn]=field;
				LineBorder border2 = new LineBorder(Color.BLACK, 2, true);
				field.setBorder(border2);//ここは新しいラベル貼る
				x += 100; field.setFont(new Font("Sefif", Font.PLAIN, 38));
				field.setHorizontalAlignment(JTextField.CENTER);
				field.setBounds(x, y, 100, 50);
				field.setCaretColor(Color.YELLOW); 
				field.setEditable(false);
				if(nn<n-1){this.anss[nn]+=this.anss[nn+1];}
				else if(nn<2*(n-1)-1){this.anss[nn]=this.anss[nn-(n-1)]+this.anss[nn-(n-1)+1];}
				else if(nn<3*(n-1)-3){this.anss[nn]=this.anss[nn-(n-2)]+this.anss[nn-(n-2)+1];}
				else if(nn<4*(n-1)-6){this.anss[nn]=this.anss[nn-(n-3)]+this.anss[nn-(n-3)+1];}
				else if(nn<5*(n-1)-10){this.anss[nn]=this.anss[nn-(n-4)]+this.anss[nn-(n-4)+1];}
				else if(nn<6*(n-1)-15){this.anss[nn]=this.anss[nn-(n-5)]+this.anss[nn-(n-5)+1];}
				else if(nn<7*(n-1)-21){this.anss[nn]=this.anss[nn-(n-6)]+this.anss[nn-(n-6)+1];}
				else if(nn<8*(n-1)-28){this.anss[nn]=this.anss[nn-(n-7)]+this.anss[nn-(n-7)+1];}
				else if(nn<9*(n-1)-36){this.anss[nn]=this.anss[nn-(n-8)]+this.anss[nn-(n-8)+1];}
				nn++;
			}
		}
		for(int i = n-2; i >= 0; i--){
			int sum = 0;
			for(int j = 1; j <= i; j++){sum+=j;}
			for(int k = 0; k <= i; k++){this.list.add(this.fields[sum+k]);}//{System.out.println(sum+k);}
		}
		int jjj = 0;
		for(JTextField fd : list){
			pane.add(fd);jjj++;
		}
		CountMain cm = new CountMain(this, 180, pane);

		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		FuncKey f = new FuncKey("ENTER",  pane, 0, this);
		KeyStroke k = KeyStroke.getKeyStroke("ENTER");
		imap.put(k, f);amap.put(f, f);
	}
	public void delete(){this.pane.remove(0);}
	public void paint(Graphics g){
		super.paint(g);Font fnt = new Font("Serif", Font.PLAIN, 110);Font fnt2 = new Font("Serif", Font.PLAIN, 60);
		Image imgBack = createImage(300, 200);    //背景画像生成
		Image imgBack2 = createImage(320, 320);
		Graphics gBack = imgBack.getGraphics();   //グラフィックコンテキスト取得
		Graphics gBack2 = imgBack2.getGraphics();
		gBack.setColor(Color.white.darker());
		gBack2.setColor(Color.white.darker());//g.setColor(Color.pink.brighter());g.fillRect(0,0,1120,630);
		if(clear_bool){gBack.setColor(Color.pink.brighter());gBack2.setColor(Color.pink.brighter());}//this.pane.setBackground(Color.pink.brighter());}
		gBack.fillRect(0,0,300,200);gBack2.fillRect(0,0,320,320);
		gBack.setColor(Color.BLACK);gBack.setFont(fnt);gBack2.setFont(fnt2);
		String str = ""+on.seeNum();
		if(str.length()==1){gBack.drawString(str, 150, 150);}
		else if(str.length()==2){gBack.drawString(str, 100, 150);}
		else if(str.length()==3){gBack.drawString(str, 50, 150);}
		else if(str.length()==4){gBack.drawString(str, 0, 150);}
		else {System.exit(0);}
		gBack2.setColor(Color.ORANGE);g.drawImage(imgBack, 850, 0, this);
		if(clear_bool){gBack2.fillOval(60,60,250,250);gBack2.setColor(Color.BLUE);String str2 = "CLEAR";gBack2.drawString(str2, 85, 208);g.drawImage(imgBack2, -20, 0, this);}
//		if(clear_bool){gBack2.fillOval(60,60,250,250);gBack2.setColor(Color.BLUE);String str2 = "CLEAR";gBack2.drawString(str2, 85, 200);gBack2.drawImage(imgBack2, 0, 0, this);}//gBack2.drawString(str2, 0, 50);g.drawImage(imgBack2, 0, 50, this);}
	}
	
	public static void main(String[] args){
		CalcTest_pre cal = new CalcTest_pre(0);int ala=0;
		try{
			Runnable run2 = new Select2("選択画面", cal);
			Thread ta2 = new Thread(run2);
			ta2.start();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}
			cal.setBool(false);ala = cal.getNum();//System.out.println(ala);
			Runnable run1 = new Select("選択画面", cal);
			Thread ta = new Thread(run1);
			ta.start();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
			GameWindow gw = new GameWindow("START", 1120, 630);GameWindow_Start gws = new GameWindow_Start(gw);
			gws.start();gws.join();
		} catch(InterruptedException e2){System.out.println("ssd");}
//		System.out.println("ala:"+ala);
		if(ala==1){
			Pyramid_cal w = new Pyramid_cal("ピラミッド計算", cal.getNum());
			w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			w.setSize(1120, 630);
			w.setLocationRelativeTo(null);
			w.setResizable(false);
			w.setVisible(true);
		} else if(ala==2){
			Pyramid_cal2 w = new Pyramid_cal2("ピラミッド計算", cal.getNum());
			w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			w.setSize(1120, 630);
			w.setLocationRelativeTo(null);
			w.setResizable(false);
			w.setVisible(true);
		}
	}
	class FuncKey extends AbstractAction{
		JPanel pane;JTextField field;int num;Pyramid_cal pc;
		FuncKey(String label, JPanel pane, int num1, Pyramid_cal pc){
			this.pane = pane;this.num = num1;this.field = list.get(this.num);
			putValue(Action.NAME, label);this.pc = pc;
			this.field.setCaretColor(Color.BLACK);
			this.field.setEditable(true);
			this.field.requestFocus();
		}
		public void actionPerformed(ActionEvent e){
			try{
				String label = (String)getValue(Action.NAME);
				if(label.equals("ENTER")){
					if((""+anss[nm.seeNum()]).equals(list.get(nm.seeNum()).getText())){
						list.get(nm.seeNum()).setBackground(Color.YELLOW);
						int tsy = nm.getNum();list.get(tsy-1).setEditable(false);new FuncKey("ENTER",this.pane, tsy, this.pc);
					}else{
						list.get(nm.seeNum()).setText("");
					}
				}
			}catch(IndexOutOfBoundsException e1){
				list.get(list.size()-1).setCaretColor(Color.YELLOW);//try{new Thread().sleep(3000);}catch(InterruptedException e2){System.out.println("fghb");}
				clear_bool = true;//this.pc.delete();
				if(clear_bool){this.pane.setBackground(Color.pink.brighter());}
			}
		}
	}
	class CountMain extends TimerTask{
		private Timer timer = new Timer();
		private Pyramid_cal pc;
		private int count = -1;//\\
		private int i;Num ct;
//		private JPanel pane;
		
		public CountMain(Pyramid_cal pc, int i, JPanel pane){
			super();
			this.pc = pc;
			this.i = i;
//			this.pane = pane;
			this.timer.scheduleAtFixedRate(this, 1000, 1000);
		}
		//int sd=0;for(int i=1;i<=n;i++){sd+=i;}for(int i=0;i<sd;i++){pane.remove(0);/*if(i<sd-2-n){list.remove(0);}*/}//this.pane.add(this.pc.getJLabel());
		public void run(){
			if(this.count==-1){
				list.get(0).requestFocus();
			} else if(clear_bool){list.get(nm.seeNum()-1).setBackground(Color.YELLOW);timer.cancel();
				this.pc.repaint();
				try{new Thread().sleep(6000);this.pc.setVisible(false);execute();}catch(InterruptedException e2){System.out.println("fghb");}
				//pane.remove(0);int sd=0;for(int i=1;i<=n;i++){sd+=i;}for(int i=0;i<sd;i++){pane.remove(0);if(i<sd-n){list.remove(0);}}//this.pane.add(this.pc.getJLabel());
			} else if(this.count==10000){System.exit(0);
			} else {this.pc.repaint();}
			this.count++;on.setNum(this.count);
		}
		public void execute(){
			CalcTest_pre cal = new CalcTest_pre(0);int ala=0;
			try{
				Runnable run2 = new Select2("選択画面", cal);
				Thread ta2 = new Thread(run2);
				ta2.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}
				cal.setBool(false);ala = cal.getNum();//System.out.println(ala);
				Runnable run1 = new Select("選択画面", cal);
				Thread ta = new Thread(run1);
				ta.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
				GameWindow gw = new GameWindow("START", 1120, 630);GameWindow_Start gws = new GameWindow_Start(gw);
				gws.start();gws.join();
			} catch(InterruptedException e2){System.out.println("ssd");}
//		System.out.println("ala:"+ala);
			if(ala==1){
				Pyramid_cal w = new Pyramid_cal("ピラミッド計算", cal.getNum());
				w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				w.setSize(1120, 630);
				w.setLocationRelativeTo(null);
				w.setResizable(false);
				w.setVisible(true);
			} else if(ala==2){
				Pyramid_cal2 w = new Pyramid_cal2("ピラミッド計算", cal.getNum());
				w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				w.setSize(1120, 630);
				w.setLocationRelativeTo(null);
				w.setResizable(false);
				w.setVisible(true);
			}
		}
	}
	class Num{
		int num = 0;//\\
		Num(){}
		int getNum(){this.num++;return this.num;}
		void setNum(int num){this.num = num;}
		int seeNum(){return this.num;}
	}
}
class GameWindow_Start extends Thread{
	private GameWindow gw;
	public GameWindow_Start(GameWindow gw){
		this.gw = gw;
	}
	public void run(){
		try{
			this.gw.add(new DrawCanvas_Start(this.gw.getTitle()));
			this.gw.setVisible(true);
			Thread.sleep(3000);
			this.gw.add(new DrawCanvas_Reset());
			gw.setVisible(false);
			return;
		} catch(InterruptedException e){
			System.out.println("不測の事態発生C");
			return;
		}
	}
}
class GameWindow extends JFrame{
	String title;
	public GameWindow(String title, int width, int height){
		super(title);this.title = title;
		ImageIcon icon = new ImageIcon("pyramid_pic.jpg");
		setIconImage(icon.getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public String getTitle(){return this.title;}
}
class DrawCanvas_Reset extends JPanel{
	public void paintComponent(Graphics g){
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, 1120, 630);
		return;
	}
}
class DrawCanvas_Start extends JPanel{
	String str;
	public DrawCanvas_Start(String str){this.str = str;}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Font fnt = new Font("Dialog", Font.BOLD, 180);
		g.setFont(fnt);
		if(this.str.length() > 5){
		Font fnt2 = new Font("Dialog", Font.BOLD, 50);
		g.setFont(fnt2);}
		FontMetrics fm = getFontMetrics(g.getFont());
		Insets is = getInsets();
		int x = (getWidth() - is.left - is.right - fm.stringWidth(str)) / 2 + is.left;
		int y = (getHeight() - is.top - is.bottom - fm.getHeight()) / 2 + fm.getAscent() + is.top;
		g.drawString(this.str, x, y);
	}
}
