import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;import java.util.Timer;import java.util.TimerTask;
import javax.swing.border.*;

public class NumGame extends JFrame{
	JTextField field;String[] fruits = {"a","b","c","d","e"};
	int aa = 0;int bb = 0;int answer = 0;int count;int chn;
	public NumGame(int i){
//		int select = 3;//(1,2,3,4)=かぞえる、あわせる、くらべる、おかね
		ImageIcon icon = new ImageIcon("number_pic.jpg");
		setIconImage(icon.getImage());

		CalcTest_pre cal = new CalcTest_pre(0);
		try{
			Runnable run1 = new Select("選択画面", cal);
			Thread ta = new Thread(run1);
			ta.start();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
		} catch(InterruptedException e2){System.out.println("ssd");}

		int select = cal.getNum();
//		System.out.println(select);
		if(select==4){
			
			cal.setBool(false);cal.setNum(0);
			try{
				Runnable run3 = new Select3("選択画面", cal);
				Thread ta3 = new Thread(run3);
				ta3.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
			} catch(InterruptedException e2){System.out.println("ssd");}

			int choice = cal.getNum();
//			System.out.println(choice);
			
			cal.setBool(false);cal.setNum(0);
			try{
				Runnable run4 = new Select4("選択画面", cal);
				Thread ta4 = new Thread(run4);
				ta4.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
			} catch(InterruptedException e2){System.out.println("ssd");}
			
			int which = cal.getNum();
//			System.out.println(which);
			
			cal.setBool(false);cal.setNum(0);
			try{
				Runnable run2 = new Select2("選択画面", cal);
				Thread ta2 = new Thread(run2);
				ta2.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
			} catch(InterruptedException e2){System.out.println("ssd");}

			int problem = cal.getNum();
//			System.out.println(problem);
			
			MoneyGame frame = new MoneyGame(problem,choice,which);
			//A(何問だすか)  B(1,2,3)=やさしい、ふつう、むずかしい
			//C(1,2)=かんたん、ばらばら
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1120,630);
			frame.setLocationRelativeTo(null);
			frame.setTitle("かずあそび");
			frame.setVisible(true);
			frame.setResizable(false);
		} else {
			cal.setBool(false);cal.setNum(0);
			try{
				Runnable run2 = new Select2("選択画面", cal);
				Thread ta2 = new Thread(run2);
				ta2.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
			} catch(InterruptedException e2){System.out.println("ssd");}

			int problem = cal.getNum();
//			System.out.println(problem);
			
			NumGame frame = new NumGame(problem, select);
			//NumGame( 何問だすか, select)
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1120,630);
			frame.setLocationRelativeTo(null);
			frame.setTitle("かずあそび");
			frame.setVisible(true);
			frame.setResizable(false);
		}

	}
	public static void main(String[] args){
		new NumGame(0);
//		int select = 3;//(1,2,3,4)=かぞえる、あわせる、くらべる、おかね
		
/*		CalcTest_pre cal = new CalcTest_pre(0);
		try{
			Runnable run1 = new Select("選択画面", cal);
			Thread ta = new Thread(run1);
			ta.start();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
		} catch(InterruptedException e2){System.out.println("ssd");}

		int select = cal.getNum();
//		System.out.println(select);
		if(select==4){
			
			cal.setBool(false);cal.setNum(0);
			try{
				Runnable run3 = new Select3("選択画面", cal);
				Thread ta3 = new Thread(run3);
				ta3.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
			} catch(InterruptedException e2){System.out.println("ssd");}

			int choice = cal.getNum();
//			System.out.println(choice);
			
			cal.setBool(false);cal.setNum(0);
			try{
				Runnable run4 = new Select4("選択画面", cal);
				Thread ta4 = new Thread(run4);
				ta4.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
			} catch(InterruptedException e2){System.out.println("ssd");}
			
			int which = cal.getNum();
//			System.out.println(which);
			
			cal.setBool(false);cal.setNum(0);
			try{
				Runnable run2 = new Select2("選択画面", cal);
				Thread ta2 = new Thread(run2);
				ta2.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
			} catch(InterruptedException e2){System.out.println("ssd");}

			int problem = cal.getNum();
//			System.out.println(problem);
			
			MoneyGame frame = new MoneyGame(problem,choice,which);
			//A(何問だすか)  B(1,2,3)=やさしい、ふつう、むずかしい
			//C(1,2)=かんたん、ばらばら
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1120,630);
			frame.setLocationRelativeTo(null);
			frame.setTitle("かずあそび");
			frame.setVisible(true);
			frame.setResizable(false);
		} else {
			cal.setBool(false);cal.setNum(0);
			try{
				Runnable run2 = new Select2("選択画面", cal);
				Thread ta2 = new Thread(run2);
				ta2.start();
				while(true){
					new Thread().join();
					if(cal.getBool()){
						break;
					}
				}//System.out.println(cal.getNum());System.out.println("ala:"+ala);
			} catch(InterruptedException e2){System.out.println("ssd");}

			int problem = cal.getNum();
//			System.out.println(problem);
			
			NumGame frame = new NumGame(problem, select);
			//NumGame( 何問だすか, select)
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1120,630);
			frame.setLocationRelativeTo(null);
			frame.setTitle("かずあそび");
			frame.setVisible(true);
			frame.setResizable(false);
		}
*/	}

	public NumGame(int count, int chn){
		this.chn = chn;//かぞえる、あわせる、くらべる、おかね//なんばんめ
		ImageIcon icon = new ImageIcon("number_pic.jpg");
		setIconImage(icon.getImage());
		JPanel p1 = new JPanel();this.count = count;
		p1.setLayout(null);int[] nums=new int[2];
		if(this.chn==3){
			aa = new Random().nextInt(20)+1;
			bb = new Random().nextInt(20)+1;
			while(aa==bb){bb = new Random().nextInt(20)+1;}
		} else {
			aa = new Random().nextInt(10)+1;
			bb = new Random().nextInt(10)+1;
		}
		int[] ab = {aa,bb};
		for(int i = 0; i < 2; i++){
			nums[i] = new Random().nextInt(5);
			if(i==1){while(nums[1]==nums[0]){nums[1]=new Random().nextInt(5);}}
		}
		String fruit = fruits[nums[0]];String fruit2 = fruits[nums[1]];
		JLabel f1a = new JLabel(new ImageIcon("fruit_"+fruit+"_"+aa+".jpg"));
		JLabel f1b = new JLabel(new ImageIcon("fruit_"+fruit2+"_"+bb+".jpg"));
		f1a.setBounds(0,0,560,300);f1b.setBounds(560,0,560,300);
		p1.add(f1a);p1.add(f1b);
		
		JPanel p2 = new JPanel();
		JPanel p2a = new JPanel();JPanel p2b = new JPanel();
		JPanel p2a_1 = new JPanel();JPanel p2a_2 = new JPanel();
		
		
		p2.setLayout(new GridLayout(2,1));
		p2a.setLayout(new GridLayout(1,2));
		p2a_1.setLayout(new GridLayout(1,3));
		p2b.setLayout(new GridLayout(1,2));
		
		
		int nnn = new Random().nextInt(2);
		int nnnn = 0;
		if(nnn==0){nnnn=1;}
		int nn = nums[nnn];
		int nn2 = nums[nnnn];
		
		if(this.chn==1){
			p2a_1.add(new JLabel(new ImageIcon("fruit_nothing.jpg")));
			p2a_1.add(new JLabel(new ImageIcon("fruit_"+fruits[nn]+".jpg")));
			p2a_1.add(new JLabel(new ImageIcon("fruit_nothing.jpg")));
		} else if(this.chn==2){
			p2a_1.add(new JLabel(new ImageIcon("fruit_"+fruit+".jpg")));
			p2a_1.add(new JLabel(new ImageIcon("and.jpg")));//"equal.jpg"
			p2a_1.add(new JLabel(new ImageIcon("fruit_"+fruit2+".jpg")));
		} else if(this.chn==3){
			p2a_1.add(new JLabel(new ImageIcon("fruit_"+fruits[nn]+".jpg")));
			p2a_1.add(new JLabel(new ImageIcon("equal.jpg")));//"equal.jpg"
			p2a_1.add(new JLabel(new ImageIcon("fruit_"+fruits[nn2]+".jpg")));
		}

		JTextField field = new JTextField();
		field.setBackground(Color.WHITE);
		field.setBorder(new LineBorder(Color.WHITE, 1, false));
		field.setPreferredSize(new Dimension(560,156));
		field.setFont(new Font("Dialog", Font.BOLD, 90));
		String str1[] = {" は,ぜんぶで"," は,あわせて"," よりも"};
		
		
		field.setText(str1[chn-1]);field.setEditable(false);
		p2a_2.add(field);p2a_1.setBackground(Color.WHITE);p2a_2.setBackground(Color.WHITE);
		p2a.add(p2a_1);p2a.add(p2a_2);
		p2.add(p2a);p2.add(p2b);
		
		int cc = this.chn;
		if(this.chn==2){cc--;}
		
		JTextField field2 = new JTextField();
		field2.setBackground(Color.WHITE);
		field2.setBorder(new LineBorder(Color.GRAY, 8, false));
		field2.setCaretColor(Color.BLACK);
		field2.setPreferredSize(new Dimension(560,156));
		field2.setFont(new Font("Dialog", Font.BOLD, 150));
		field2.setHorizontalAlignment(JTextField.CENTER);
		p2b.add(field2);this.field = field2;
		new CountMain();
		
		InputMap imap = p2b.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = p2b.getActionMap();
		FuncKey f = new FuncKey("ENTER",  p2b, this, field2);
		KeyStroke k = KeyStroke.getKeyStroke("ENTER");
		imap.put(k, f);amap.put(f, f);

		if(this.chn==1){
			this.answer = ab[nnn];
		} else if(this.chn==2){
			this.answer = ab[0]+ab[1];
		}else if(this.chn==3){
			this.answer = ab[nnn] - ab[nnnn];
			if(this.answer<0){this.answer*=-1;}
			else{cc--;}
		}

		
		String str2[] = {" こ  あります", " こ  おおい", " こ  すくない"};
		JTextField field3 = new JTextField();
		field3.setBackground(Color.WHITE);
		field3.setBorder(new LineBorder(Color.WHITE, 1, false));
		field3.setPreferredSize(new Dimension(560,156));
		field3.setFont(new Font("Dialog", Font.BOLD, 90));
		field3.setText(str2[cc-1]);field3.setEditable(false);
		p2b.add(field3);p2b.setBackground(Color.WHITE);//" こ  あります"
		
		setLayout(new GridLayout(2,1,3,3));
		JPanel pp = (JPanel)getContentPane();
		pp.setBackground(Color.BLACK);
		getContentPane().add(p1);
		getContentPane().add(p2);
		
		//System.out.println(this.answer);
	}
	
	
	class CountMain extends TimerTask{
		private Timer timer = new Timer();int i = 0;
		public CountMain(){
			super();
			this.timer.scheduleAtFixedRate(this, 1000, 1000);
		}
		public CountMain(int i){
			super();this.i=i;
			this.timer.scheduleAtFixedRate(this, 1000, 1000);
		}
		public void run(){
			if(this.i==0){field.requestFocus();}
			else{new NumGame(0);}
			timer.cancel();
		}
	}
	class FuncKey extends AbstractAction{
		JPanel pane;int num;NumGame ng;JTextField field;int jj = 0;
		FuncKey(String label, JPanel pane, NumGame ng, JTextField field){
			this.pane = pane;this.field = field;
			putValue(Action.NAME, label);this.ng = ng;
		}
		public void actionPerformed(ActionEvent e){
			String label = (String)getValue(Action.NAME);
			if(label.equals("ENTER")){
				if((field.getText()).equals(""+answer)&&jj==0){
					this.field.setBackground(Color.cyan.brighter());
					this.field.setCaretColor(Color.cyan.brighter());
					try{new Thread().sleep(250);}catch(InterruptedException e2){}field.setText("OK!");field.setEditable(false);//"OK!"
				} else if(((field.getText()).equals("OK!")||(field.getText()).equals(""+answer))&&jj>0){
					count--;
					if(count==0){
						//System.out.println("finish");//System.exit(0);
						this.ng.setVisible(false);new CountMain(1);return;
					}
					this.ng.setVisible(false);
					NumGame frame = new NumGame(count, chn);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setSize(1120,630);
					frame.setLocationRelativeTo(null);
					frame.setTitle("かずあそび");
					frame.setVisible(true);
					frame.setResizable(false);

				} else {
					this.field.setBackground(Color.PINK);
					this.field.setCaretColor(Color.PINK);
					try{new Thread().sleep(250);}catch(InterruptedException e2){}
					if(this.jj==0){field.setText("(´-ω-`)");}else{field.setText(""+answer);}field.setEditable(false);
				}this.jj++;
			}
		}
	}
}
