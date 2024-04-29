import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

public class DungeonMain extends JFrame{
	int lll = 0;//1:珠を読む, 2:珠で計算(足し算), 3:珠で計算(引き算)
	int ln = 0;//最高桁(9ケタまで)//1:初級,2:中級,3:上級,4:名人級
	int limit = 0;int opn = 1;//1:どちらも珠, 2:左だけ珠, 3:右だけ珠
	int ans = 0;int tt = 0;int dd = 0;JTextField field = new JTextField();int ads = 0; int gfd = 0;int sag = 0;
	boolean result = false;boolean see = true;int result2 = 0;int count = 0;JPanel pane;
	ArrayList<Integer> nums = new ArrayList<Integer>();
	ArrayList<Integer> nums2 = new ArrayList<Integer>();
	public static void main(String[] args){
		CalcTest_pre cal = new CalcTest_pre(0);int lll = 0, ln = 0, limit = 0, opn = 1, tt = 0;
		try{
			Runnable run1 = new Select("選択画面", cal);
			Thread ta1 = new Thread(run1);
			ta1.start();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}lll = cal.getNum();
			cal.setBool(false);cal.setNum(0);
			Runnable run2 = new Select2("選択画面", cal, lll);
			Thread ta2 = new Thread(run2);
			ta2.start();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}ln = cal.getNum();
			cal.setBool(false);cal.setNum(0);
			Runnable run3 = new Select3("表示時間選択画面", cal);
			Thread ta3 = new Thread(run3);
			ta3.start();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}limit = cal.getNum();
			if(lll!=1){
				cal.setBool(false);cal.setNum(0);
				Runnable run4 = new Select4("選択画面", cal);
				Thread ta4 = new Thread(run4);
				ta4.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}opn = cal.getNum();
			}
			cal.setBool(false);cal.setNum(0);
			Runnable run5 = new Select5("題数選択画面", cal);
			Thread ta5 = new Thread(run5);
			ta5.start();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}tt=cal.getNum();

		} catch(InterruptedException e2){}

		DungeonMain w = new DungeonMain("ソロメージ", lll, ln, limit, opn, tt);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setResizable(false);
		w.setSize(1120,630);
		w.setLocationRelativeTo(null);
		w.setVisible(true);
	}
	public DungeonMain(String title, int lll, int ln, int limit, int opn, int tt){
		super(title);
		this.lll = lll; this.ln = ln; this.limit = limit; this.opn = opn; this.tt = tt;
		ImageIcon icon = new ImageIcon("soroban_pic.jpg");
		setIconImage(icon.getImage());
		
		this.pane = (JPanel)getContentPane();
		pane.setLayout(null);
		Insets is = getInsets();
		int x = 80;int y = 75;int num_1 = 0;x+=40;
		int rr = 0;
		if(lll==3){
			for(int i = 0; i < ln+1; i++){
				int num = new Random().nextInt(10);
				if(i==0&&num%2==0){num = 0;num_1 = 0;} else if(i==0&&num%2==1){num = 1;num_1 = 1;}
				if(i==1&&num_1==0){
					while(num==0){
						num = new Random().nextInt(10);
					}
				}
				nums.add(num);
				ads += nums.get(i) * Math.pow(10, ln - 1 - i);
			}
		} else {
			for(int i = 0; i < ln; i++){
				int num = new Random().nextInt(10);
				while(i==0&&num==0){
					num = new Random().nextInt(10);
				}
				nums.add(num);
				ads += nums.get(i) * Math.pow(10, ln - 1 - i);
			}
		}
		if(lll==2){
			for(int i = 0; i < ln; i++){
				int num = new Random().nextInt(10);
				while(i==0&&num==0){
					num = new Random().nextInt(10);
				}
				nums2.add(num);
				gfd += nums2.get(i) * Math.pow(10, ln - 1 - i);
			}
			gfd *= -1;
		} else if(lll==3){
			sag = ads;
			for(int i = 0; i < ln + 1; i++){
				ads += nums.get(i) * Math.pow(10, ln - i);
			}
			for(int i = 0; i < ln; i++){
				int num = new Random().nextInt(10);
				while(i==0&&num==0){
					num = new Random().nextInt(10);
					if(i==0&&nums.get(0)==0&&(num>nums.get(1))){num=0;continue;}
				}
				nums2.add(num);
				gfd += nums2.get(i) * Math.pow(10, ln - 1 - i);
				if(i==ln-1&&gfd>ads-sag){nums2.clear();i-=ln;gfd=0;continue;}
			}
		}
		this.ans = ads - gfd - sag;
//		System.out.println(this.ans);
		try{GameWindow gw = new GameWindow("START", 1120, 630);GameWindow_Start gws = new GameWindow_Start(gw);
		gws.start();gws.join();}catch(InterruptedException ee){}
		for(int j = 0; j < 2; j++){//jは足し算・引き算の前の数
			if(lll==3&&j==0){ln++;}
			else if(lll==3&&j==1){ln--;}
			if(lll==1){}
			else if(ln==4&&j==0){x+=70;}
			else if(ln==3&&j==0){x+=120;}
			else if(ln==2&&j==0){x+=180;}
			else if(ln==1&&j==0){x+=240;}
			ArrayList<Integer> list = new ArrayList<Integer>();
			if(j==0){list=nums;}else if(j==1){list=nums2;}
			if(lll==1){x+=43*(10-ln);}else{x+=43*(10-ln-5);}
			if((lll==2||lll==3)&&j==0){x/=2;x-=44;y=75;}
			else if((lll==2||lll==3)&&j==1){x=560+rr;}
			if(lll==3&&j==1&&(ln==4||ln==5)){x+=40;}
			JLabel bar = new JLabel(new ImageIcon("soro10.jpg"));
			bar.setBounds(x, y, 44, 282);
			pane.add(bar);x+=44;count++;
			for(int i = 0; i < list.size(); i++){
				String str = "a";
				if((list.size()-i)%3==1){str="b";}
				JLabel soro = new JLabel(new ImageIcon("soro_"+str+list.get(i)+".jpg"));
				soro.setBounds(x, y, 87, 282);
				pane.add(soro);x+=86;count++;
			}
			JLabel bar2 = new JLabel(new ImageIcon("soro10.jpg"));
			bar2.setBounds(x, y, 44, 282);
			pane.add(bar2);rr = 560 - x -44;count++;
			if(lll==1||opn==2){if(lll==3){ln--;}break;}
			else if(j==0&&opn==3){for(int i = 0; i < count; i++){pane.remove(0);}count=0;}
		}
		field.setFont(new Font("Sefif", Font.PLAIN, 130));
		field.setBounds(295, 390, 780, 175);
		if(limit==0){field.setEnabled(true);}else{field.setEnabled(false);field.setBackground(Color.BLACK);}
		pane.add(field);
		
		Font fnt0 = new Font("Dialog", Font.BOLD, 110);
		JLabel equal = new JLabel("＝");
		equal.setFont(fnt0);
		equal.setBounds(100, 390, 125, 175);
		pane.add(equal);
		
		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		FuncKey f = new FuncKey(this, "ENTER",  pane, field);
		KeyStroke k = KeyStroke.getKeyStroke("ENTER");
		imap.put(k, f);amap.put(f, f);
	}
	public void paint(Graphics g){
		super.paint(g);
		Font fnt = new Font("Dialog", Font.BOLD, 150);
		Font fnt2 = new Font("Dialog", Font.BOLD, 80);
		Font fnt3 = new Font("Dialog", Font.BOLD, 60);
		Font fnt4 = new Font("Serif", Font.PLAIN, 150);
		Font fnt5 = new Font("Century", Font.ITALIC, 180);
		Font fnt6 = new Font("Dialog", Font.BOLD, 130);
		JLabel label = new JLabel("Ans:");
		JLabel label2 = new JLabel(""+ans);
		JLabel label3 = new JLabel("OK!");//(^o^)
		JLabel label4 = new JLabel("(*_*)");
		label.setFont(fnt6);//label.setVisible(false);
		label.setBounds(170, 50, 400, 130);
		label2.setFont(fnt6);
		label2.setBounds(295, 230, 800, 130);
		label3.setFont(fnt5);
		label3.setBounds(570, 10, 400, 180);
		label4.setFont(fnt4);
		label4.setBounds(570, 10, 400, 180);
		pane.add(label);pane.add(label2);pane.add(label3);pane.add(label4);
		label.setVisible(false);label2.setVisible(false);label3.setVisible(false);label4.setVisible(false);
		String strr = "";String str = "";
		int a = 520;int b = 300;
		if(lll==2){
			if(ln==4){g.setFont(fnt2);}
			else{g.setFont(fnt);a=485;b = 315;}
		} else if(lll==3){
			if(ln==3||(ln==4&&opn==3)){g.setFont(fnt2);}
			else if(ln==4){g.setFont(fnt3);a = 550;}
			else{g.setFont(fnt);a = 485;b = 315;}
		}
		if(lll!=3){gfd*=-1;}
		if(opn==3){strr = ""+(ads-sag);}else if(opn==2){strr = ""+gfd;}
		if(lll==2){str = "＋";}else if(lll==3){str = "－";}
		JLabel equal = new JLabel(str);
		
		if(limit==0&&result){
			for(int i = 0; i < count; i++){this.pane.remove(0);}
			this.pane.remove(6);this.pane.remove(equal);
			pane.setVisible(false);
			pane.setVisible(true);
		}
		if(limit==0&&!result){
			if(opn==3){
				equal = new JLabel(strr+" "+str);
				equal.setFont(new Font("Serif", Font.PLAIN, 100));
				equal.setBounds(250, 150, 1000, 160);
				pane.add(equal);
			} else if(opn==2){
				equal = new JLabel(str+" "+strr);
				equal.setFont(new Font("Serif", Font.PLAIN, 100));
				equal.setBounds(550, 150, 1000, 160);
				pane.add(equal);
			} else if(opn==1){
				equal.setFont(new Font("Serif", Font.PLAIN, 100));
				equal.setBounds(510, 146, 1000, 160);
				pane.add(equal);
			}
		}
		if(result2==1){
			label.setVisible(true);label2.setVisible(true);label3.setVisible(true);
			return;
		} else if(result2==2){
			label.setVisible(true);label2.setVisible(true);label4.setVisible(true);
			return;
		}
		if(result){
			for(int i = 0; i < count; i++){this.pane.remove(0);}
			pane.setVisible(false);
			pane.setVisible(true);
			return;
		}
		String str2 = "＝";//→
		if(lll==2||lll==3){
			if(limit==0){
			}else{
				g.drawString(str, a, b);
			}
		}
		g.setFont(fnt4);
		if(opn==3){
			if(limit==0){}else{g.drawString(strr, a - 430 + 50 * (5 - strr.length()), 310);}//System.out.println(ads-sag);
		}else if(opn==2){
			if(limit==0){
			}else{
				g.drawString(strr, a + 75 + 50 * (5 - strr.length()), 315);
			}
		}
		if(limit==0){see=false;
			field.requestFocus();return;
		}else{
			try{new Thread().sleep(limit);this.result=true;repaint();field.setEnabled(true);field.setBackground(Color.WHITE);field.requestFocus();}catch(InterruptedException e){}
		}
	}
	class FuncKey extends AbstractAction implements Runnable{
		JPanel pane;JTextField field;DungeonMain dm;
		FuncKey(DungeonMain dm, String label, JPanel pane, JTextField field){
			this.pane = pane;this.field = field;this.dm = dm;
			putValue(Action.NAME, label);
		}
		FuncKey(DungeonMain dm){this.dm = dm;}
		public void actionPerformed(ActionEvent e){
			String label = (String)getValue(Action.NAME);
			if(label.equals("ENTER")&&dd==0){
				if((field.getText()).equals(""+ans)){
					result2++;
				} else {
					result2+=2;
				}
				field.setBackground(Color.white);
				field.setCaretColor(Color.white);
				field.setEditable(false);if(limit==0){result=true;}repaint();dd++;
				Runnable run1 = new FuncKey(this.dm);
				new Thread(run1).start();
			}
		}
		public void run(){
			
/*			System.out.println("lll:"+lll);
			System.out.println("ln:"+ln);
			System.out.println("limit:"+limit);
			System.out.println("opn:"+opn);
			System.out.println("tt:"+tt);
*/			
			try{

				int tp = 3000;
				if((lll==1&&ln==1)||(lll==1&&ln==2)){tp=1800;}
				else if((lll==1&&ln==7)||(lll==1&&ln==8)||(lll==1&&ln==9)){tp=4200;}
				new Thread().sleep(tp);this.dm.setVisible(false);

				if(tt==0){
					CalcTest_pre cal = new CalcTest_pre(0);int lll = 0, ln = 0, limit = 0, opn = 1, tt = 0;
					Runnable run1 = new Select("選択画面", cal);
					Thread ta1 = new Thread(run1);
					ta1.start();
					while(true){
						new Thread().join();
					if(cal.getBool()){
							break;
						}
					}lll = cal.getNum();
					cal.setBool(false);cal.setNum(0);
					Runnable run2 = new Select2("選択画面", cal, lll);
					Thread ta2 = new Thread(run2);
					ta2.start();
					while(true){
						new Thread().join();
						if(cal.getBool()){
							break;
						}
					}ln = cal.getNum();
					cal.setBool(false);cal.setNum(0);
					Runnable run3 = new Select3("選択画面", cal);
					Thread ta3 = new Thread(run3);
					ta3.start();
					while(true){
						new Thread().join();
						if(cal.getBool()){
							break;
						}
					}limit = cal.getNum();
					if(lll!=1){
						cal.setBool(false);cal.setNum(0);
						Runnable run4 = new Select4("選択画面", cal);
						Thread ta4 = new Thread(run4);
						ta4.start();
						while(true){
							new Thread().join();
							if(cal.getBool()){
								break;
							}
						}opn = cal.getNum();
					}
					cal.setBool(false);cal.setNum(0);
					Runnable run5 = new Select5("題数選択画面", cal);
					Thread ta5 = new Thread(run5);
					ta5.start();
					while(true){
						new Thread().join();
						if(cal.getBool()){
							break;
						}
					}tt=cal.getNum();
					
					DungeonMain w = new DungeonMain("ソロメージ", lll, ln, limit, opn, tt);
					w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					w.setResizable(false);
					w.setSize(1120,630);
					w.setLocationRelativeTo(null);
					w.setVisible(true);return;
				} else {tt--;}
				DungeonMain w = new DungeonMain("ソロメージ", lll, ln, limit, opn, tt);
				w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				w.setResizable(false);
				w.setSize(1120,630);
				w.setLocationRelativeTo(null);
				w.setVisible(true);//new Thread().sleep(1000);
			} catch(InterruptedException e2){}
		}
	}
}

class GameWindow extends JFrame{
	String title;
	public GameWindow(String title, int width, int height){
		super(title);this.title = title;
		ImageIcon icon = new ImageIcon("soroban_pic.jpg");
		setIconImage(icon.getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public String getTitle(){return this.title;}
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
			Thread.sleep(2000);
			this.gw.add(new DrawCanvas_Reset());
			gw.setVisible(false);
			return;
		} catch(InterruptedException e){
			System.out.println("不測の事態発生C");
			return;
		}
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
class DrawCanvas_Reset extends JPanel{
	public void paintComponent(Graphics g){
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, 1120, 630);
		return;
	}
}