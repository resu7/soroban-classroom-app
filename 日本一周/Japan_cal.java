import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Japan_cal extends JFrame{
	private String[] yn = {"", "(-.-;)", "(^o^)"};
	private String[] jp = {"北海道","青森県","岩手県","宮城県","秋田県","山形県","福島県","茨城県","栃木県","群馬県","埼玉県","千葉県","東京都","神奈川県","新潟県","富山県","石川県","福井県","山梨県","長野県","岐阜県","静岡県","愛知県","三重県","滋賀県","京都府","大阪府","兵庫県","奈良県","和歌山県","鳥取県","島根県","岡山県","広島県","山口県","徳島県","香川県","愛媛県","高知県","福岡県","佐賀県","長崎県","熊本県","大分県","宮崎県","鹿児島県","沖縄県"};
	private String[] jp2 = {"ほっかいどう","あおもり","いわて","みやぎ","あきた","やまがた","ふくしま","いばらき","とちぎ","ぐんま","さいたま","ちば","とうきょう","かながわ","にいがた","とやま","いしかわ","ふくい","やまなし","ながの","ぎふ","しずおか","あいち","みえ","しが","きょうと","おおさか","ひょうご","なら","わかやま","とっとり","しまね","おかやま","ひろしま","やまぐち","とくしま","かがわ","えひめ","こうち","ふくおか","さが","ながさき","くまもと","おおいた","みやざき","かごしま","おきなわ"};
	private Num ct = new Num();//乱数(int)(Math.random() * 10);
	private Num qqq = new Num();
	private String[] jjpp = new String[47];int b=-1;CountMain cm;int chn;String[] chs = {"a", "b", "c", "d", "e"};
	private String[] quiz = new String[47];boolean yy = false;boolean yy2 = false;
	private Graphics g;private int ccc = 0;int bbb = 0;
	private Word wd1 = new Word(jjpp);
	private Word wd2 = new Word(quiz);
	private Word wd3 = new Word(yn);
	private JTextField field = new JTextField();
	private JTextField field2 = new JTextField();
	public Japan_cal(String title, int chn){
		super(title);
		ImageIcon icon = new ImageIcon("japan_pic.jpg");
		setIconImage(icon.getImage());

		if(chn==5){this.ccc++;chn--;}this.chn = chn;
		for(int i = 0; i < this.jjpp.length; i++){
			this.jjpp[i] = this.jp[i] + "(" + this.jp2[i] + ")";
		}
		ArrayList<String> list = new ArrayList<String>();

//ここから思考が必要
		if(this.chn == 0){
			for(int i = 1; i < 10; i++){
				for(int j = 1; j < 10; j++){
					list.add(i + "＋" + j);
				}
			}
		} else if(this.chn == 1){
			for(int i = 1; i < 10; i++){
				for(int j = 1; j < 10; j++){
					int k = i + j;
					list.add(k + "－" + i);
				}
			}
		} else if(this.chn == 2){
			for(int i = 1; i < 10; i++){
				for(int j = 1; j < 10; j++){
					list.add(i + "×" + j);
				}
			}
		} else if(this.chn == 3){
			for(int i = 1; i < 10; i++){
				for(int j = 1; j < 10; j++){
					int k = i * j;
					list.add(k + "÷" + i);
				}
			}
		} else if(this.chn == 4){
			for(int i = 1; i < 10; i++){
				for(int j = 1; j < 10; j++){
					for(int k = 1; k < i; k++){
						int l = i * j;
						l += k;
						if(l >= i * 10){break;}
						list.add(l + "÷" + i);
//						System.out.println("l÷i:" + l + "÷" + i + ", j:" + j + ", k:" + k);//
					}
				}
			}
		} else if(this.chn == 6){
			for(int i = 0; i < 10; i++){
				for(int j = 0; j < 10; j++){
					if((i+j)>10)continue;
					list.add(i + "＋" + j);
				}
			}
			this.chn = 0;
		} else if(this.chn == 7){
			for(int i = 0; i < 10; i++){
				for(int j = 0; j <= 10; j++){
					int k = i + j;
					if(k>10)continue;
					list.add(k + "－" + i);
				}
			}
			this.chn = 1;
			bbb++;
		}

		Collections.shuffle(list);
		
//		System.out.println(list.size());
//		for(String atx:list)System.out.println(atx);
		
		for(int i = 0; i < 47; i++){this.quiz[i] = list.get(i);}

		//System.out.println(Arrays.toString(this.quiz));

		JPanel pane = (JPanel)getContentPane();
		JLabel map = new JLabel(new ImageIcon("first1_" + this.chs[this.chn] + ".jpg"));
		field.setFont(new Font("Sefif", Font.PLAIN, 180));
		if(this.chn == 4){
			field2.setFont(new Font("Sefif", Font.PLAIN, 180));
			field.setBounds(638, 400, 135, 180);
			field2.setBounds(943, 400, 135, 180);
			if(ccc==1){field2.setBackground(Color.BLACK);field2.setEditable(false);}//field2.setEnabled(false);}
			pane.add(field);
			pane.add(field2);
		} else {
			field.setBounds(650, 400, 220, 180);
			pane.add(field);
		}

		map.setBounds(-40, -10, 600, 600);
		pane.setLayout(null);
		pane.add(map);
		CountMain cm = new CountMain(this.ct, this, 180, pane);//\\
		
		InputMap imap = field.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = field.getActionMap();
		FuncKey f1 = new FuncKey("ENTER", this.wd1, this.wd2, this.wd3, pane);
		KeyStroke k1 = KeyStroke.getKeyStroke("ENTER");
		imap.put(k1, f1);
		amap.put(f1, f1);

		if(this.chn == 4){
			field.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					String s = field.getText();
					String s2 = field2.getText();
					if(ccc==0&&s.length()==1&&(!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE||evt.getKeyChar()==KeyEvent.VK_LEFT||evt.getKeyChar()==KeyEvent.VK_RIGHT))){
						field2.requestFocus();
					}
				}
			});
			field2.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					String s = field.getText();
					String s2 = field2.getText();
					if(ccc==0&&s2.length()==1&&(!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE||evt.getKeyChar()==KeyEvent.VK_LEFT||evt.getKeyChar()==KeyEvent.VK_RIGHT))){
						field.requestFocus();
					}
				}
			});
		}
		
	}
	public void update(Graphics g){
		paint(g);
	}
	public void paint(Graphics g){
		super.paint(g);
		try{
			this.g = g;
			Image imgBack = createImage(600, 410);    //背景画像生成
			Graphics gBack = imgBack.getGraphics();   //グラフィックコンテキスト取得
			Font fnt = new Font("Dialog", Font.BOLD, 180);
			Font fnt2 = new Font("Dialog", Font.BOLD, 50);
			Font fnt3 = new Font("Dialog", Font.PLAIN, 50);
			Font fnt4 = new Font("Serif", Font.PLAIN, 130);
			Font fnt5 = new Font("Dialog", Font.PLAIN, 100);
//int x = (getWidth() - is.left - is.right - fm.stringWidth(str)) / 2 + is.left - 100;//		int y = (getHeight() - is.top - is.bottom - fm.getHeight()) / 2 + fm.getAscent() + is.top - 100;
			String str0 = this.wd1.getWord();
			String str1 = this.wd2.getWord();//＋－×÷＝
			String str2 = "＝";
			String str3 = this.wd3.getWord();//"YES!"と"(-.-;)"
			gBack.setFont(fnt);
			
			if(str1.length() == 3){
				gBack.drawString(str1, 60, 405);
			} else if(str1.length() == 4){
				gBack.drawString(str1, 25, 405);
			}
			gBack.setFont(fnt2);
			gBack.drawString("のこり",120, 115);
			gBack.setFont(fnt3);
			gBack.drawString(str0, 30, 230);
			gBack.setFont(fnt4);
			gBack.drawString("" + this.ct.getNum(), 300, 150);
			g.drawImage(imgBack, 540, 0, this);
			
			Image imgBack2 = createImage(123, 200);
			Graphics gBack2 = imgBack2.getGraphics();
			gBack2.setFont(fnt5);
			gBack2.drawString(str2, 13, 130);
			g.drawImage(imgBack2, 520, 420, this);
			
			if(this.chn == 4){
				Image imgBack3 = createImage(145, 200);
				Graphics gBack3 = imgBack3.getGraphics();
				gBack3.setFont(fnt3);
				gBack3.drawString("あまり", 5, 130);
				g.drawImage(imgBack3, 780, 420, this);
			} else {
				Image imgBack3 = createImage(220, 200);
				Graphics gBack3 = imgBack3.getGraphics();
				gBack3.setFont(fnt5);
				if(str3.length()==5){gBack3.drawString(str3, 0, 130);
				} else {gBack3.drawString(str3, 10, 130);}
				g.drawImage(imgBack3, 885, 420, this);
			}
			g.setFont(fnt3);
			String str;String str_2;String str_3;
			if(yy){str = "これからもガンバロー";Image imgBack4 = createImage(600, 630);Graphics gBack4 = imgBack4.getGraphics();FontMetrics fm = getFontMetrics(g.getFont());Insets is = getInsets();int x = (getWidth() - is.left - is.right - fm.stringWidth(str)) / 2 + is.left;int y = (getHeight() - is.top - is.bottom - fm.getHeight()) / 2 + fm.getAscent() + is.top;g.drawImage(imgBack4, 540, 0, this);g.drawString(str, x + 260, y);}/*g.fillRect(540,0,1120,630);*///(540,0,1120,630)
			if(yy2){str = "クリアおめでとう";str_2 = "ゴールタイム";str_3 = (180 - qqq.getNum()) + " (びょう)";Image imgBack5 = createImage(600, 630);Graphics gBack5 = imgBack5.getGraphics();FontMetrics fm = getFontMetrics(gBack5.getFont());Insets is = getInsets();int x = (getWidth() - is.left - is.right - fm.stringWidth(str)) / 2 + is.left;int x2 = (getWidth() - is.left - is.right - fm.stringWidth(str_2)) / 2 + is.left;int x3 = (getWidth() - is.left - is.right - fm.stringWidth(str_3)) / 2 + is.left;int y = (getHeight() - is.top - is.bottom - fm.getHeight()) / 2 + fm.getAscent() + is.top;g.drawImage(imgBack5, 540, 0, this);g.drawString(str, x+100, y-100);g.drawString(str_2,x2+100,y);g.drawString(str_3,x3+100,y+100);}
		} catch(Exception e1){//\\
			try{//System.out.println("クリア");
		//	System.out.println(b);
			yy = true;cm.run();System.out.println("eeee");}catch(NullPointerException e2){Font fnt3 = new Font("Dialog", Font.PLAIN, 50);g.setFont(fnt3);String str;String str_2;String str_3;str = "クリアおめでとう";str_2 = "ゴールタイム";str_3 = (180 - qqq.getNum()) + " (びょう)";Image imgBack5 = createImage(600, 630);Graphics gBack5 = imgBack5.getGraphics();FontMetrics fm = getFontMetrics(gBack5.getFont());Insets is = getInsets();int x = (getWidth() - is.left - is.right - fm.stringWidth(str)) / 2 + is.left;int x2 = (getWidth() - is.left - is.right - fm.stringWidth(str_2)) / 2 + is.left;int x3 = (getWidth() - is.left - is.right - fm.stringWidth(str_3)) / 2 + is.left;int y = (getHeight() - is.top - is.bottom - fm.getHeight()) / 2 + fm.getAscent() + is.top;g.drawImage(imgBack5, 540, 0, this);g.drawString(str, x+100, y-100);g.drawString(str_2,x2+100,y);g.drawString(str_3,x3+100,y+100);}
		}
	}
	class CountMain extends TimerTask{
		private Timer timer = new Timer();
		private Japan_cal jc;
		private Num ct;
		private int count = 181;//\\
		private int i;
		private JPanel pane;
		
		public CountMain(Num ct, Japan_cal jc, int i, JPanel pane){
			super();
			this.ct = ct;
			this.jc = jc;
			this.i = i;
			this.pane = pane;
			this.timer.scheduleAtFixedRate(this, 1000, 1000);
		}
		public void execute(){
			try{
				CalcTest_pre cal = new CalcTest_pre(0);
				Runnable run1 = new Select("選択画面", cal);
				Thread ta = new Thread(run1);
				ta.run();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}
				if(cal.getNum() == 4){
					cal.setBool(false);
					Runnable run2 = new Select2("選択画面", cal);
					Thread tb = new Thread(run2);
					tb.start();
					while(true){
						new Thread().join();
						if(cal.getBool()){
							break;
						}
					}
				}
				if(cal.getNum() == 5){
					cal.setBool(false);
					Runnable run3 = new Select3("選択画面", cal);
					Thread tc = new Thread(run3);
					tc.start();
					while(true){
						new Thread().join();
						if(cal.getBool()){
							break;
						}
					}
				}
				
			if(cal.getNum() == 1){
				cal.setBool(false);
				Runnable run4 = new Select4("選択画面", cal);
				Thread tc = new Thread(run4);
				tc.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}
				if(cal.getNum() == 5){
					cal.setNum(1);
				}
			}
			
			if(cal.getNum() == 2){
				cal.setBool(false);
				Runnable run5 = new Select4("選択画面", cal);
				Thread tc = new Thread(run5);
				tc.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}
				if(cal.getNum() == 5){
					cal.setNum(2);
				} else if(cal.getNum() == 7){
					cal.setNum(8);
				}
			}
				
				int n = cal.getNum() - 1;
				GameWindow gw = new GameWindow("START", 1120, 630);GameWindow_Start gws = new GameWindow_Start(gw);
				gws.start();gws.join();
				Japan_cal w = new Japan_cal("日本一周", n);
				w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				w.setSize(1120, 630);
				w.setLocationRelativeTo(null);
				w.setResizable(false);
				w.setVisible(true);
			}catch(InterruptedException e){
			//	System.out.println("asd");
			}
		}

		public void run(){
			if(this.count > 0){
				this.count--;
				if(this.count < 0){
				//	System.out.println("finish");
				} else if(b == 46){
					timer.cancel();
					try{GameWindow gww3 = new GameWindow(jjpp[b]+"にキター！", 1120, 630);GameWindow_Start gwws3 = new GameWindow_Start(gww3);
					gwws3.start();gwws3.sleep(3000);if(chn==4){this.pane.remove(0);this.pane.remove(0);}else{this.pane.remove(0);}qqq.setNum(this.count + 1);yy2 = true;this.jc.repaint();this.jc.setVisible(true);gwws3.sleep(4500);}catch(InterruptedException e){/*System.out.println("asd3");*/}
					/*System.out.println("CLEAR");*/this.jc.setVisible(false);//System.exit(0);
					execute();
				} else {
				//	System.out.println(this.count);
					this.ct.setNum(this.count);
					if(this.count == this.i){
						this.jc.repaint();
						this.i--;
					}
				}
			} else {
				timer.cancel();
	//			System.out.println("タイムアップ");
	//			System.out.println(b);
				try{if(b==-1){
					GameWindow gww = new GameWindow("ファイト！", 1120, 630);GameWindow_Start gwws = new GameWindow_Start(gww);
					gwws.start();gwws.sleep(3000);if(chn==4){this.pane.remove(0);this.pane.remove(0);}else{this.pane.remove(0);}yy = true;this.jc.repaint();this.jc.setVisible(true);gwws.sleep(4500);}
					else{GameWindow gww2 = new GameWindow(jjpp[b]+"にキター！", 1120, 630);GameWindow_Start gwws2 = new GameWindow_Start(gww2);
					gwws2.start();gwws2.sleep(3000);if(chn==4){this.pane.remove(0);this.pane.remove(0);}else{this.pane.remove(0);}yy = true;this.jc.repaint();this.jc.setVisible(true);gwws2.sleep(4500);}
				}catch(InterruptedException e){System.out.println("asd2");}
				/*System.out.println("finish");*/this.jc.setVisible(false);//System.exit(0);
				execute();
			}
		}
	}
	
	class Num{
		int num = 180;//\\
		int num2 = 0;
		Num(){}
		boolean getEq(Num nm){if((nm.getNum()==this.num)&&(nm.getNum2()==this.num2)){return false;}else{return true;}}
		void setNums(int num, int num2){this.num = num; this.num2 = num2;}
		int getNum(){return this.num;}
		int getNum2(){return this.num2;}
		void setNum(int num){this.num = num;}
	}
	class Word{
		int num = 0;String[] strs;
		Word(String[] strs){this.strs = strs;}
		String getWord(){try{return this.strs[this.num];}catch(Exception e){return null;}}
		void setWord(int num){this.num = num;}
		int getNum(){return this.num;}
	}
	
	class FuncKey extends AbstractAction /*implements Runnable*/{
		Word wd1;
		Word wd2;
		Word wd3;
		int a = 0;
		JPanel pane;
		FuncKey(String label, Word wd1, Word wd2, Word wd3, JPanel pane){
			this.wd1 = wd1;
			this.wd2 = wd2;
			this.wd3 = wd3;
			this.pane = pane;
			putValue(Action.NAME, label);
		}
//		public void run(){Thread t2 = new Thread(this);try{t2.sleep(200);this.wd3.setWord(0);}catch(InterruptedException e1){System.out.println("eeee");}}
		public void actionPerformed(ActionEvent e){
		try{
			String label = (String)getValue(Action.NAME);
			String s = this.wd2.getWord();
			String[] ss = s.split("");
			int num = Integer.parseInt(ss[0]);
			int ans = 0;int ans2 = 0;
			if(chn==0){
				int num2 = Integer.parseInt(ss[2]);
				ans = num + num2;
			} else if(chn==1){
				if(num==1&&bbb==0){
					int num2 = Integer.parseInt(ss[1]);int num3 = Integer.parseInt(ss[3]);
					ans = 10 + num2 - num3;
				} else if(num!=1&&bbb==0){
					int num2 = Integer.parseInt(ss[2]);
					ans = num - num2;
				} else if(ss.length==4&&bbb==1){
					int num2 = Integer.parseInt(ss[3]);
					ans = 10 - num2;
				} else if(ss.length==3&&bbb==1){
					int num2 = Integer.parseInt(ss[2]);
					ans = num - num2;
				}
				//System.out.println(ans);
			} else if(chn==2){
				int num2 = Integer.parseInt(ss[2]);
				ans = num * num2;
			} else if(chn==3){
				if(ss[2].equals("÷")){
					int num2 = Integer.parseInt(ss[1]);int num3 = Integer.parseInt(ss[3]);
					ans = ( num * 10 + num2 ) / num3;
				} else {
					int num2 = Integer.parseInt(ss[2]);
					ans = num / num2;
				}
			} else if(chn==4){
				if(ss[2].equals("÷")){
					int num2 = Integer.parseInt(ss[1]);int num3 = Integer.parseInt(ss[3]);
					int number = num * 10 + num2;
					ans2 = number % num3;
					number -= ans2; ans = number / num3;
				} else {
					int num2 = Integer.parseInt(ss[2]);
					ans2 = num % num2; num -= ans2; ans = num / num2;
				}
			}
			
			if(label.equals("ENTER")){
				
//				System.out.println("商:" + ans + " あまり:" + ans2);
				
				if(chn == 4){
					if(ccc==1&&("" + ans).equals(field.getText())){
						field2.setText("" + ans2);//new Thread().sleep(2000);
					}
					if(("" + ans).equals(field.getText())&&("" + ans2).equals(field2.getText())){
						a++;b++;
						this.wd1.setWord(a);
						this.wd2.setWord(a);
						this.pane.remove(2);
						JLabel map2 = new JLabel(new ImageIcon("first" + (a + 1) + "_" + chs[chn] + ".jpg"));
						map2.setBounds(-40, -10, 600, 600);
						this.pane.add(map2);
					}
					field.requestFocus();//new Thread().sleep(2000);
					field.setText("");field2.setText("");
				} else if(("" + ans).equals(field.getText())){
					a++;b++;
					this.wd1.setWord(a);
					this.wd2.setWord(a);
/**/				this.wd3.setWord(2);
					this.pane.remove(1);
					JLabel map2 = new JLabel(new ImageIcon("first" + (a + 1) + "_" + chs[chn] + ".jpg"));
					map2.setBounds(-40, -10, 600, 600);
					this.pane.add(map2);
				} else {
					this.wd3.setWord(1);
//					Thread t1 = new Thread(this);
//					t1.start();
				}
				field.setText("");
			}
		} catch(NullPointerException e1){
		} //catch(InterruptedException e2){}
		}
	}
	public static void main(String[] args){
//cal = n-1フラッシュ暗算と同じ選択画面から(1,2,3,4)=(加,減,乗,除)でint型変数nnnをえらんでもらう
//nは(0,1,2,3)=(加,減,乗,除)
		try{
			CalcTest_pre cal = new CalcTest_pre(0);
			Runnable run1 = new Select("選択画面", cal);
			Thread ta = new Thread(run1);
			ta.start();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}
			if(cal.getNum() == 4){
				cal.setBool(false);
				Runnable run2 = new Select2("選択画面", cal);
				Thread tb = new Thread(run2);
				tb.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}
			}
			if(cal.getNum() == 5){
				cal.setBool(false);
				Runnable run3 = new Select3("選択画面", cal);
				Thread tc = new Thread(run3);
				tc.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}
			}
			
			if(cal.getNum() == 1){
				cal.setBool(false);
				Runnable run4 = new Select4("選択画面", cal);
				Thread tc = new Thread(run4);
				tc.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}
				if(cal.getNum() == 5){
					cal.setNum(1);
				}
			}
			
			if(cal.getNum() == 2){
				cal.setBool(false);
				Runnable run5 = new Select4("選択画面", cal);
				Thread tc = new Thread(run5);
				tc.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}
				if(cal.getNum() == 5){
					cal.setNum(2);
				} else if(cal.getNum() == 7){
					cal.setNum(8);
				}
			}
			
			int n = cal.getNum() - 1;
			GameWindow gw = new GameWindow("START", 1120, 630);GameWindow_Start gws = new GameWindow_Start(gw);
			gws.start();gws.join();
			Japan_cal w = new Japan_cal("日本一周", n);
			w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			w.setSize(1120, 630);
			w.setLocationRelativeTo(null);
			w.setResizable(false);
			w.setVisible(true);
		}catch(InterruptedException e){System.out.println("asd");}
	}
}

class GameWindow extends JFrame{
	String title;
	public GameWindow(String title, int width, int height){
		super(title);this.title = title;
		ImageIcon icon = new ImageIcon("japan_pic.jpg");
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

