import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;import java.util.Timer;import java.util.TimerTask;
import javax.swing.border.*;
import java.net.*;
import java.awt.image.*;

public class Mass_cal extends JFrame{
	ArrayList<JTextField> list = new ArrayList<JTextField>();ArrayList<Integer> anss = new ArrayList<Integer>();int n = 0;boolean clear_bool = false;
	ArrayList<Integer> nums = new ArrayList<Integer>();ArrayList<Integer> nums2 = new ArrayList<Integer>();String signs[] = {"＋", "×"};
	Color c;int clear_time = 0;
	public Mass_cal(String title,int which, int n, boolean mix){//mixがtrueなら縦横交換可能
		super(title);this.n=n;
		ImageIcon icon = new ImageIcon("devil_pic.jpg");
		setIconImage(icon.getImage());
		if(this.n==10){this.c = Color.cyan.brighter();for(int i = 1; i < 10; i++){nums.add(i);}Collections.shuffle(nums);}
		else if(this.n==8){
			this.c = Color.green.brighter();//nums2に横縦順に入れる(mix=trueの時、横の桁が大きい)
			for(int i = 1; i < 10; i++){nums2.add(i);}Collections.shuffle(nums2);nums2.remove(0);nums2.remove(0);
			for(int i = 0; i < this.n - 1; i++){
				while(true){
					int a = 0;while(a==0){a=(int)(Math.random()*10);}
					int b = (int)(Math.random()*10);int c = 10*a + b;
					for(int j : nums){if(c==j){continue;}}nums.add(c);break;
				}
			}nums2.addAll(nums);if(mix){for(int i = 0; i < this.n-1; i++){int tmp = nums2.get(i);nums2.set(i, nums2.get(nums2.size()/2+i));nums2.set(nums2.size()/2+i, tmp);}}
		} else if(this.n==7){
			this.c = Color.magenta.brighter();
			if(which==0){
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}
						int b = (int)(Math.random()*10);int c = 10*a + b;
						for(int j : nums){if(c==j){continue;}}nums.add(c);break;
					}
				}
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}
						int b = (int)(Math.random()*10);int c = 10*a + b;
						for(int j : nums2){if(c==j){continue;}}nums2.add(c);break;
					}
				}
			} else if(which==1){
				for(int i = 1; i < 10; i++){nums2.add(i);}Collections.shuffle(nums2);nums2.remove(0);nums2.remove(0);nums2.remove(0);
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}int b = (int)(Math.random()*10);int c = (int)(Math.random()*10);
						int d = 100*a + 10*b + c;
						for(int j : nums){if(d==j){continue;}}nums.add(d);break;
					}
				}
			}
			nums2.addAll(nums);if(mix){for(int i = 0; i < this.n-1; i++){int tmp = nums2.get(i);nums2.set(i, nums2.get(nums2.size()/2+i));nums2.set(nums2.size()/2+i, tmp);}}
		} else if(this.n==6){
			this.c = Color.yellow.brighter();
			if(which==1){
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}
						int b = (int)(Math.random()*10);int c = 10*a + b;
						for(int j : nums){if(c==j){continue;}}nums.add(c);break;
					}
				}
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}
						int b = (int)(Math.random()*10);int c = 10*a + b;
						for(int j : nums2){if(c==j){continue;}}nums2.add(c);break;
					}
				}
			} else if(which==0){
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}
						int b = (int)(Math.random()*10);int c = 10*a + b;
						for(int j : nums2){if(c==j){continue;}}nums2.add(c);break;
					}
				}
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}int b = (int)(Math.random()*10);int c = (int)(Math.random()*10);
						int d = 100*a + 10*b + c;
						for(int j : nums){if(d==j){continue;}}nums.add(d);break;
					}
				}
			}
			nums2.addAll(nums);if(mix){for(int i = 0; i < this.n-1; i++){int tmp = nums2.get(i);nums2.set(i, nums2.get(nums2.size()/2+i));nums2.set(nums2.size()/2+i, tmp);}}
		} else if(this.n==5){
			this.c = Color.orange;
			if(which==0){
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}int b = (int)(Math.random()*10);int c = (int)(Math.random()*10);
						int d = 100*a + 10*b + c;
						for(int j : nums){if(d==j){continue;}}nums.add(d);break;
					}
				}
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}int b = (int)(Math.random()*10);int c = (int)(Math.random()*10);
						int d = 100*a + 10*b + c;
						for(int j : nums2){if(d==j){continue;}}nums2.add(d);break;
					}
				}
			} else if(which==1){
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}
						int b = (int)(Math.random()*10);int c = 10*a + b;
						for(int j : nums2){if(c==j){continue;}}nums2.add(c);break;
					}
				}
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}int b = (int)(Math.random()*10);int c = (int)(Math.random()*10);
						int d = 100*a + 10*b + c;
						for(int j : nums){if(d==j){continue;}}nums.add(d);break;
					}
				}
			}
			nums2.addAll(nums);if(mix){for(int i = 0; i < this.n-1; i++){int tmp = nums2.get(i);nums2.set(i, nums2.get(nums2.size()/2+i));nums2.set(nums2.size()/2+i, tmp);}}
		} else if(this.n==4){
			this.c = Color.pink;
			if(which==1){
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}int b = (int)(Math.random()*10);int c = (int)(Math.random()*10);
						int d = 100*a + 10*b + c;
						for(int j : nums){if(d==j){continue;}}nums.add(d);break;
					}
				}
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}int b = (int)(Math.random()*10);int c = (int)(Math.random()*10);
						int d = 100*a + 10*b + c;
						for(int j : nums2){if(d==j){continue;}}nums2.add(d);break;
					}
				}
			} else if(which==0){
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}int b = (int)(Math.random()*10);int c = (int)(Math.random()*10);int d = (int)(Math.random()*10);
						int e = 1000*a + 100*b + 10*c + d;
						for(int j : nums){if(d==j){continue;}}nums.add(e);break;
					}
				}
				for(int i = 0; i < this.n - 1; i++){
					while(true){
						int a = 0;while(a==0){a=(int)(Math.random()*10);}int b = (int)(Math.random()*10);int c = (int)(Math.random()*10);int d = (int)(Math.random()*10);
						int e = 1000*a + 100*b + 10*c + d;
						for(int j : nums2){if(d==j){continue;}}nums2.add(e);break;
					}
				}
			}
			nums2.addAll(nums);
		}
		JPanel pane = (JPanel)getContentPane();int nn = 0;
		pane.setLayout(new GridLayout(this.n,this.n));
		for(int i = 0; i < this.n*this.n; i++){
			JTextField field = new JTextField();
			field.setEditable(false);
			field.setHorizontalAlignment(JTextField.CENTER);
			field.setBorder(new LineBorder(Color.BLACK, 2, true));
			field.setFont(new Font("Sefif", Font.PLAIN, 38));//field.setText(""+i);
			if((i<this.n)||(i%this.n==0)){
				field.setBackground(Color.lightGray);
				if(this.n==10){
					if(i==0){field.setText(signs[which]);list.add(field);pane.add(field);continue;}else if((i>0)&&(i<this.n)){field.setText(""+nums.get(nn));nn++;}
					else if(i==this.n){Collections.shuffle(nums);nn-=this.n-1;}
					if(i>=this.n){field.setText(""+nums.get(nn));nn++;}
					nums2.add(Integer.parseInt(field.getText()));
				} else {
					if(i==0){field.setText(signs[which]);list.add(field);pane.add(field);continue;}else if((i>0)&&(i<this.n)){field.setText(""+nums2.get(nn));}
					if(i>=this.n){field.setText(""+nums2.get(nn));}nn++;
				}
			}
			list.add(field);pane.add(field);
		}
		if(which==0){
			for(int i = 0; i < this.n-1; i++){
				for(int j = 0; j < this.n-1; j++){
					anss.add(nums2.get(j)+nums2.get(nums2.size()/2+i));
				}
			}
		} else if(which==1){
			for(int i = 0; i < this.n-1; i++){
				for(int j = 0; j < this.n-1; j++){
					anss.add(nums2.get(j)*nums2.get(nums2.size()/2+i));
				}
			}
		}
		new CountMain(this);
		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		FuncKey f = new FuncKey("ENTER",  pane, this.n+1, this);
		KeyStroke k = KeyStroke.getKeyStroke("ENTER");
		imap.put(k, f);amap.put(f, f);

	}
	public static void main(String[] args){
		int which = 0;int choose = 0;boolean mix = false;//which,chose,mixに関しては選択画面を作る
		CalcTest_pre cal = new CalcTest_pre(0);
		try{
			Runnable run2 = new Select2("選択画面", cal);
			Thread ta2 = new Thread(run2);
			ta2.start();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}which = cal.getNum();//System.out.println(cal.getNum());
			cal.setBool(false);
			if(which==0){
				Runnable run1 = new Select("選択画面", cal);
				Thread ta = new Thread(run1);
				ta.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
			} else if(which==1){
				Runnable run1 = new Select1b("選択画面", cal);
				Thread ta = new Thread(run1);
				ta.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
			}choose=cal.getNum();
			if(choose==8||(which==1&&choose==7)||(which==0&&choose==6)||(which==1&&choose==5)){
				cal.setBool(false);
				Runnable run3 = new Select2b("選択画面", cal);
				Thread ta3 = new Thread(run3);
				ta3.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}
				if(cal.getNum()==100){mix=true;}
			}
			GameWindow gw = new GameWindow("START", 1120, 630);GameWindow_Start gws = new GameWindow_Start(gw);
			gws.start();gws.join();
		} catch(InterruptedException e2){System.out.println("ssd");}
		Mass_cal w = new Mass_cal("鬼マス計算", which, choose, mix);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(1120, 630);
		w.setLocationRelativeTo(null);
		w.setVisible(true);
	}
	class CountMain extends TimerTask{
		private Timer timer = new Timer();
		private int count = -1;Mass_cal mc;
		public CountMain(Mass_cal mc){
			super();this.mc = mc;this.timer.scheduleAtFixedRate(this, 1000, 1000);
		}
		public void run(){//this.count-1がクリアタイム
			if(clear_bool){timer.cancel();clear_time = this.count - 1;Dungeon_pre dp = new Dungeon_pre("RESULT", clear_time, this.mc);}
			if(this.count==-1){
				list.get(n+1).requestFocus();
			} else if(this.count==10000){System.exit(0);}
			this.count++;
		}
	}
	class FuncKey extends AbstractAction{
		JPanel pane;JTextField field;int num;Mass_cal mc;
		FuncKey(String label, JPanel pane, int num1, Mass_cal mc){
			this.pane = pane;this.num = num1;this.field = list.get(this.num);
			putValue(Action.NAME, label);this.mc = mc;
			this.field.setCaretColor(Color.BLACK);
			this.field.setEditable(true);
			this.field.requestFocus();
		}
		public void actionPerformed(ActionEvent e){
			try{
				String label = (String)getValue(Action.NAME);
				if(label.equals("ENTER")){
					if((""+anss.get(0)).equals(list.get(this.num).getText())){
						anss.remove(0);
						list.get(this.num).setBackground(c);
						list.get(this.num).setEditable(false);
						this.num++;if(this.num%n==0){this.num++;}
						new FuncKey("ENTER",this.pane, this.num, this.mc);
					}else{
						list.get(this.num).setText("");
					}
				}
			}catch(IndexOutOfBoundsException e1){
				list.get(list.size()-1).setCaretColor(c);
				clear_bool = true;
			}
		}
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
		ImageIcon icon = new ImageIcon("devil_pic.jpg");
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
class Dungeon_pre extends JFrame{
	int count = 0;JPanel pane;Mass_cal mc;
	public Dungeon_pre(String title, int num, Mass_cal mc){
		super(title);this.mc = mc;
		ImageIcon icon = new ImageIcon("devil_pic.jpg");
		setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1120, 630);this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.pane = new JPanel();
		JLabel label = new JLabel("タイム: "+ num);label.setPreferredSize(new Dimension(900, 335));
		label.setFont(new Font("Dialog", Font.BOLD, 150));
		JLabel label2 = this.getJLabel();//this.pane.add(label);this.pane.add(label2);
		this.pane.add(label, BorderLayout.WEST);
		this.pane.add(this.getJLabel(), BorderLayout.CENTER);
		this.add(this.pane);
		this.setVisible(true);
		try{
			new Thread().sleep(6000);
			this.add(this.pane);this.setVisible(false);
			new Thread().sleep(1000);this.mc.setVisible(false);execute();
		}catch(InterruptedException e){
			System.out.println("asd2");
		}
	}
	public void execute(){
		int which = 0;int choose = 0;boolean mix = false;//which,chose,mixに関しては選択画面を作る
		CalcTest_pre cal = new CalcTest_pre(0);
		try{
			Runnable run2 = new Select2("選択画面", cal);
			Thread ta2 = new Thread(run2);
			ta2.start();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}which = cal.getNum();//System.out.println(cal.getNum());
			cal.setBool(false);
			if(which==0){
				Runnable run1 = new Select("選択画面", cal);
				Thread ta = new Thread(run1);
				ta.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
			} else if(which==1){
				Runnable run1 = new Select1b("選択画面", cal);
				Thread ta = new Thread(run1);
				ta.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
			}choose=cal.getNum();
			if(choose==8||(which==1&&choose==7)||(which==0&&choose==6)||(which==1&&choose==5)){
				cal.setBool(false);
				Runnable run3 = new Select2b("選択画面", cal);
				Thread ta3 = new Thread(run3);
				ta3.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}
				if(cal.getNum()==100){mix=true;}
			}
			GameWindow gw = new GameWindow("START", 1120, 630);GameWindow_Start gws = new GameWindow_Start(gw);
			gws.start();gws.join();
		} catch(InterruptedException e2){System.out.println("ssd");}
		Mass_cal w = new Mass_cal("鬼マス計算", which, choose, mix);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(1120, 630);
		w.setLocationRelativeTo(null);
		w.setVisible(true);
	}

//	public static void main(String[] args){
//		Dungeon_pre dp = new Dungeon_pre("Anime Gif", "b");
//	}

//GIFアニメ表示
	public JLabel getJLabel() {
		Image im=null;
//		URL url=this.getClass().getResource("/img/otsu2.gif");
		URL url=this.getClass().getResource("otsu2.gif");
		System.out.println(url);
		try {
			im=this.createImage((ImageProducer)url.getContent());
		}catch(Exception ex){
			System.out.println("Resource Error!");
		}
		ImageIcon ii = new ImageIcon(im);
		JLabel jLabel = new JLabel(ii);
		//GIFアニメを表示
		jLabel.setVisible(true);
		return jLabel;
	}
}
class CalcTest_pre{
	private int num;
	private boolean bool = false;
	public CalcTest_pre(int num){
		this.num = num;
	}
	public void setNum(int num){
		this.num = num;
	}
	public int getNum(){
		return this.num;
	}
	public void setBool(boolean bool){
		this.bool = bool;
	}
	public boolean getBool(){
		return this.bool;
	}
}