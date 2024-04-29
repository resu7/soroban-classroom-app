import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.applet.Applet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

class Anzan_pre extends Thread{
	private int[] numbers;
	private int delay;
	private int count;
	private int digit;
	private boolean bool;
	private GameWindow gw;
	private int answer;
//	public Anzan_pre(int[] numbers, int delay, GameWindow gw){
	public Anzan_pre(int delay, GameWindow gw,int count, int digit, boolean bool){
//		this.numbers = numbers;
		this.delay = delay;
		this.gw = gw;
		this.count = count;
		this.digit = digit;
		this.bool = bool;
	}
	public int getAnswer(){return this.answer;}
	public void run(){
		try{
			int number = 0;
			this.answer = 0;
			this.numbers = new int[this.count];//出力する全ての数配列
			this.numbers[0] = 0;
			for(int i = 0; i < this.count; i++){
				while(true){
					int[] nums = {(int)(Math.random() * 10), (int)(Math.random() * 10), (int)(Math.random() * 10), (int)(Math.random() * 10), (int)(Math.random() * 10)};
					while(nums[0] == 0){
						nums[0] = (int)(Math.random() * 10);
					}
					if(digit == 1){
						number = nums[0];
					} else if(digit == 2){
						number = nums[0] * 10 + nums[1];
						if(bool && (nums[4] % 2 == 0)){
							number -= nums[0] * 10;
						}
					} else if(digit == 3){
						number = nums[0] * 100 + nums[1] * 10 + nums[2];
						if(bool && (nums[4] % 2 == 0)){
							number -= nums[0] * 100;
						}
					} else if(digit == 4){
						number = nums[0] * 1000 + nums[1] * 100 + nums[2] * 10 + nums[3];
						if(bool && (nums[4] % 2 == 0)){
							number -= nums[0] * 1000;
						}
					} else if(digit == 5){
						number = nums[0] * 10000 + nums[1] * 1000 + nums[2] * 100 + nums[3] * 10 + nums[4];
						if(bool && (nums[4] % 2 == 0)){
							number -= nums[0] * 10000;
						}
					}
					if((i == 0) && (number > 0)){
						break;
					} else if((number != numbers[i - 1]) && (number > 0)){
						break;
					}
				}
				numbers[i] = number;
			}
			for(int num : numbers){
				answer += num;
			}

			for(int i = 0; i < this.numbers.length; i++){
				this.gw.add(new DrawCanvas(this.numbers, i));
				this.gw.setVisible(true);
				Thread.sleep(this.delay);
				if(i == this.numbers.length - 1){
					this.gw.setVisible(false);
				}
				this.gw.setVisible(true);
			}
		} catch(InterruptedException e){
			System.out.println("不測の事態発生A");
			return; //スレッドを終了させる
		}
	}
	public static void main(String[] args){
		try{
			CalcTest_pre cal = new CalcTest_pre(0);
			Runnable run1 = new AnzanMain("選択画面1", cal);
			Thread ta = new Thread(run1);
			ta.run();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}
			CalcTest_pre cal2 = new CalcTest_pre(0);
			Runnable run2 = new CountMain("選択画面2", cal2);
			Thread tb = new Thread(run2);
			tb.run();
			while(true){
				new Thread().join();
				if(cal2.getBool()){	
					break;
				}
			}
			int count = cal2.getNum();//口数
if(count==-1){
			CalcTest_pre cal2_1 = new CalcTest_pre(0);
			Runnable run2_1 = new CountMain2("選択画面2", cal2_1);
			Thread tb2_1 = new Thread(run2_1);
			tb2_1.run();
			while(true){
				new Thread().join();
				if(cal2_1.getBool()){
					break;
				}
			}
count = cal2_1.getNum();
}

if(count==-1){
			CalcTest_pre cal2_2 = new CalcTest_pre(0);
			Runnable run2_2 = new CountMain3("選択画面2", cal2_2);
			Thread tb2_2 = new Thread(run2_2);
			tb2_2.run();
			while(true){
				new Thread().join();
				if(cal2_2.getBool()){
					break;
				}
			}
count = cal2_2.getNum();
}
			
			CalcTest_pre cal3 = new CalcTest_pre(0);
			Runnable run3 = new DelayMain("選択画面3", cal3);
			Thread tc = new Thread(run3);
			tc.run();
			while(true){
				new Thread().join();
				if(cal3.getBool()){
					break;
				}
			}
			int delay = cal3.getNum();//時間間隔
if(delay==-1){
			CalcTest_pre cal3_1 = new CalcTest_pre(0);
			Runnable run3_1 = new DelayMain2("選択画面2", cal3_1);
			Thread tb3_1 = new Thread(run3_1);
			tb3_1.run();
			while(true){
				new Thread().join();
				if(cal3_1.getBool()){
					break;
				}
			}
delay = cal3_1.getNum();
}

if(delay==-2){
			CalcTest_pre cal3_2 = new CalcTest_pre(0);
			Runnable run3_2 = new DelayMain3("選択画面2", cal3_2);
			Thread tb3_2 = new Thread(run3_2);
			tb3_2.run();
			while(true){
				new Thread().join();
				if(cal3_2.getBool()){
					break;
				}
			}
delay = cal3_2.getNum();
}
			CalcTest_pre cal4 = new CalcTest_pre(0);
			Runnable run4 = new Select2("選択画面4", cal4);
			Thread ta4 = new Thread(run4);
			ta4.run();
			while(true){
				new Thread().join();
				if(cal4.getBool()){
					break;
				}
			}

			int first = cal.getNum();
			int digit = 0;//桁数(5桁まで)
			int problem = cal4.getNum();//問題数
			boolean bool = false;//バラバラか否か
			if(first == 1){
				digit = 1;
			} else if(first == 2){
				digit = 2;
			} else if(first == 3){
				digit = 3;
			} else if(first == 4){
				digit = 4;
			} else if(first == 5){
				digit = 5;
			} else if(first == 6){
				digit = 2;
				bool = true;
			} else if(first == 7){
				digit = 3;
				bool = true;
			} else if(first == 8){
				digit = 4;
				bool = true;
			} else if(first == 9){
				digit = 5;
				bool = true;
			}

			System.out.println(problem);
			System.out.println(count);
			System.out.println(digit);
			System.out.println(delay);
			System.out.println();

			GameWindow gw = new GameWindow("フラッシュ暗算", 1120, 630);//1600, 900だった, 16:9の＊70
			GameWindow_Start gws = new GameWindow_Start(gw);
			gws.start();
			gws.join();
//			Anzan_pre ap = new Anzan_pre(numbers, delay, gw);
			Anzan_pre ap = new Anzan_pre(delay, gw,count,digit,bool);

			ap.start();
			ap.join();
			CalcTest_pre calc4 = new CalcTest_pre(0);
//			Runnable calc = new CalcTest01("CalcTest00", gw, answer, calc4);
			Runnable calc = new CalcTest01("CalcTest00", gw, ap.getAnswer(),calc4, problem,count,digit,bool,delay);
			Thread t1 = new Thread(calc);
			t1.start();
			//new Thread(new AnzanMain("選択画面1", cal)).start();
		} catch(InterruptedException e){
			System.out.println("不測の事態発生B");
			return; //スレッドを終了させる
		}
	}
}

class GameWindow extends JFrame{
	public GameWindow(String title, int width, int height){
		super(title);
		ImageIcon icon = new ImageIcon("flush_pic.jpg");
		setIconImage(icon.getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class DrawCanvas extends JPanel{
	private int number;
	public DrawCanvas(int[] numbers, int i){
		this.number = numbers[i];
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);//"HGP創英角ﾎﾟｯﾌﾟ体"も良いかも
		Font font = new Font("Serif", Font.ITALIC, 350);//500
		g.setFont(font);
		String str = "" + this.number;
		int size = str.length();
		if(size == 1){
			g.drawString( str, 455, 406);// 650, 580
		} else if(size == 2){
			g.drawString( str, 350, 406);//500, 580
		} else if(size == 3){
			g.drawString( str, 280, 406);//400, 580
		} else if(size == 4){
			g.drawString( str, 196, 406);//280, 580
		} else if(size == 5){
			g.drawString( str, 112, 406);//160, 580
		}
	}
}

class DrawCanvas_Reset extends JPanel{
	public void paintComponent(Graphics g){
		Paint.painting(g);
		return;
	}
}

class GameWindow_Start extends Thread{
	private GameWindow gw;
	public GameWindow_Start(GameWindow gw){
		this.gw = gw;
	}
	public void run(){
		try{
			this.gw.add(new DrawCanvas_Start());
			this.gw.setVisible(true);
			Thread.sleep(3000);
			this.gw.add(new DrawCanvas_Reset());
			gw.setVisible(true);
			return;
		} catch(InterruptedException e){
			System.out.println("不測の事態発生C");
			return;
		}
	}
}

class DrawCanvas_Start extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Font font = new Font("Arial", Font.PLAIN, 210);//Font.BOLD | Font.ITALICは太字斜体//300
		g.setFont(font);
		g.drawString("START", 210, 385);//300, 550
	}
}

class GameWindow_Answer extends Thread{
	private GameWindow gw;
	private int answer;
	private String input;
	public GameWindow_Answer(GameWindow gw, int answer, String input){
		this.gw = gw;
		this.answer = answer;
		this.input = input;
	}
	public void run(){
		this.gw.add(new DrawCanvas_Answer(this.answer, this.input));
		this.gw.setVisible(true);
	}
}

class DrawCanvas_Answer extends JPanel{
	private int answer;
	private String input;
	public DrawCanvas_Answer(int answer, String input){
		this.answer = answer;
		this.input = input;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Font font = new Font("Arial", Font.PLAIN, 105);//Font.BOLD | Font.ITALICは太字斜体//150
		g.setFont(font);
		String str = "" + this.answer;
		int size = str.length();
		if(size == 1){
			g.drawString("Ans:" + str, 395, 245);//565, 350、きりすて
			g.drawString("You:" + this.input, 395, 455);//565, 650
		} else if(size == 2){
			g.drawString("Ans:" + str, 385, 245);//550, 350
			g.drawString("You:" + this.input, 385, 455);
		} else if(size == 3){
			g.drawString("Ans:" + str, 375, 245);//535, 350、きりあげ
			g.drawString("You:" + this.input, 375, 455);
		} else if(size == 4){
			g.drawString("Ans:" + str, 350, 245);//500, 350
			g.drawString("You:" + this.input, 350, 455);
		} else if(size == 5){
			g.drawString("Ans:" + str, 322, 245);//460, 350
			g.drawString("You:" + this.input, 322, 455);
		} else if(size == 6){
			g.drawString("Ans:" + str, 301, 245);//430, 350
			g.drawString("You:" + this.input, 301, 455);
		} else if(size == 7){
			g.drawString("Ans:" + str, 280, 245);//400, 350
			g.drawString("You:" + this.input, 280, 455);
		}
	}
}

class Paint extends Applet{
	public static void painting(Graphics g){
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, 600, 300);
	}
}
class GameWindow_Yes extends Thread{
	private GameWindow gw;
	public GameWindow_Yes(GameWindow gw){
		this.gw = gw;
	}
	public void run(){
		this.gw.add(new DrawCanvas_Yes());
		this.gw.setVisible(true);
	}
}

class DrawCanvas_Yes extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Font font = new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.PLAIN, 350);//Font.BOLD | Font.ITALICは太字斜体//500
		g.setFont(font);
		g.drawString("YES!", 210, 441);//300, 630
	}
}
class GameWindow_No extends Thread{
	private GameWindow gw;
	public GameWindow_No(GameWindow gw){
		this.gw = gw;
	}
	public void run(){
		this.gw.add(new DrawCanvas_No());
		this.gw.setVisible(true);
	}
}

class DrawCanvas_No extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Font font = new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.PLAIN, 350);//Font.BOLD | Font.ITALICは太字斜体//500
		g.setFont(font);
		g.drawString("(-.-;)", 140, 441);//200, 630
	}
}

class abc implements Runnable{
	private GameWindow gw;
	private int answer;
	private String input_answer;
	private CalcTest_pre cap;
	private int problem;

	private int delay;
	private int count;
	private int digit;
	private boolean bool;
	
public abc(GameWindow gw, int answer, String input_answer, CalcTest_pre cap, int problem,int count,int digit,boolean bool,int delay){
		this.gw = gw;
		this.answer = answer;
		this.input_answer = input_answer;
		this.cap = cap;
		this.problem = problem;
		this.count = count;
		this.digit = digit;
		this.bool = bool;
		this.delay = delay;
	}
	public void run(){
		try{
			GameWindow gw1 = new GameWindow("正誤判定", 1120, 630);//1600,900だった
			GameWindow_Yes gwn = new GameWindow_Yes(gw1);
			gwn.start();
			gwn.sleep(2000);
			GameWindow_Answer gwa = new GameWindow_Answer(gw1, this.answer, this.input_answer);
			gwa.start();
			gwa.sleep(3500);
			this.gw.setVisible(false);
			gw1.setVisible(false);
			execute();
		} catch(InterruptedException e){
			System.out.println("不測の事態発生F");
		}
	}
	public void execute(){
		try{
if(this.problem==0){
			CalcTest_pre cal = new CalcTest_pre(0);
			Runnable run1 = new AnzanMain("選択画面1", cal);
			Thread ta = new Thread(run1);
			ta.run();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}
			CalcTest_pre cal2 = new CalcTest_pre(0);
			Runnable run2 = new CountMain("選択画面2", cal2);
			Thread tb = new Thread(run2);
			tb.run();
			while(true){
				new Thread().join();
				if(cal2.getBool()){
					break;
				}
			}
			count = cal2.getNum();//口数
if(count==-1){
			CalcTest_pre cal2_1 = new CalcTest_pre(0);
			Runnable run2_1 = new CountMain2("選択画面2", cal2_1);
			Thread tb2_1 = new Thread(run2_1);
			tb2_1.run();
			while(true){
				new Thread().join();
				if(cal2_1.getBool()){
					break;
				}
			}
count = cal2_1.getNum();
}

if(count==-1){
			CalcTest_pre cal2_2 = new CalcTest_pre(0);
			Runnable run2_2 = new CountMain3("選択画面2", cal2_2);
			Thread tb2_2 = new Thread(run2_2);
			tb2_2.run();
			while(true){
				new Thread().join();
				if(cal2_2.getBool()){
					break;
				}
			}
count = cal2_2.getNum();
}
			
			CalcTest_pre cal3 = new CalcTest_pre(0);
			Runnable run3 = new DelayMain("選択画面3", cal3);
			Thread tc = new Thread(run3);
			tc.run();
			while(true){
				new Thread().join();
				if(cal3.getBool()){
					break;
				}
			}
			delay = cal3.getNum();//時間間隔
if(delay==-1){
			CalcTest_pre cal3_1 = new CalcTest_pre(0);
			Runnable run3_1 = new DelayMain2("選択画面2", cal3_1);
			Thread tb3_1 = new Thread(run3_1);
			tb3_1.run();
			while(true){
				new Thread().join();
				if(cal3_1.getBool()){
					break;
				}
			}
delay = cal3_1.getNum();
}

if(delay==-2){
			CalcTest_pre cal3_2 = new CalcTest_pre(0);
			Runnable run3_2 = new DelayMain3("選択画面2", cal3_2);
			Thread tb3_2 = new Thread(run3_2);
			tb3_2.run();
			while(true){
				new Thread().join();
				if(cal3_2.getBool()){
					break;
				}
			}
delay = cal3_2.getNum();
}
			CalcTest_pre cal4 = new CalcTest_pre(0);
			Runnable run4 = new Select2("選択画面4", cal4);
			Thread ta4 = new Thread(run4);
			ta4.run();
			while(true){
				new Thread().join();
				if(cal4.getBool()){
					break;
				}
			}

			int first = cal.getNum();
			problem = cal4.getNum();//問題数
			boolean bool2 = false;//バラバラか否か
			if(first == 1){
				digit = 1;
			} else if(first == 2){
				digit = 2;
			} else if(first == 3){
				digit = 3;
			} else if(first == 4){
				digit = 4;
			} else if(first == 5){
				digit = 5;
			} else if(first == 6){
				digit = 2;
				bool2 = true;
			} else if(first == 7){
				digit = 3;
				bool2 = true;
			} else if(first == 8){
				digit = 4;
				bool2 = true;
			} else if(first == 9){
				digit = 5;
				bool2 = true;
			}
	bool = bool2;
}
			System.out.println(this.problem);
			System.out.println(this.count);
			System.out.println(this.digit);
			System.out.println(this.delay);
			System.out.println(bool);


			GameWindow gw = new GameWindow("フラッシュ暗算", 1120, 630);//1600, 900だった, 16:9の＊70
			GameWindow_Start gws = new GameWindow_Start(gw);
			gws.start();
			gws.join();
//			Anzan_pre ap = new Anzan_pre(numbers, delay, gw);
			Anzan_pre ap = new Anzan_pre(delay, gw,count,digit,bool);

			ap.start();
			ap.join();
			CalcTest_pre calc4 = new CalcTest_pre(0);
//			Runnable calc = new CalcTest01("CalcTest00", gw, answer, calc4);
			Runnable calc = new CalcTest01("CalcTest00", gw, ap.getAnswer(),calc4, problem,count,digit,bool,delay);
			Thread t1 = new Thread(calc);
			t1.start();
			//new Thread(new AnzanMain("選択画面1", cal)).start();
		} catch(InterruptedException e){
			System.out.println("不測の事態発生B");
			return; //スレッドを終了させる
		}
	}
}
class abc2 implements Runnable{
	private GameWindow gw;
	private int answer;
	private String input_answer;
	private CalcTest_pre cap;
	private int problem;
	private int delay;
	private int count;
	private int digit;
	private boolean bool;
	public void run(){
		try{
			GameWindow gw1 = new GameWindow("正誤判定", 1120, 630);//1600,900だった
			GameWindow_No gwn = new GameWindow_No(gw1);
			gwn.start();
			gwn.sleep(2000);
			GameWindow_Answer gwa = new GameWindow_Answer(gw1, this.answer, this.input_answer);
			gwa.start();
			gwa.sleep(3500);
			this.gw.setVisible(false);
			gw1.setVisible(false);
			execute();
		} catch(InterruptedException e){
			System.out.println("不測の事態発生G");
		}
	}
	
	public abc2(GameWindow gw, int answer, String input_answer, CalcTest_pre cap, int problem,int count,int digit,boolean bool,int delay){
		this.gw = gw;
		this.answer = answer;
		this.input_answer = input_answer;
		this.cap = cap;
		this.problem = problem;
		this.count = count;
		this.digit = digit;
		this.bool = bool;
		this.delay = delay;
	}
	public void execute(){
		try{
if(this.problem==0){
			CalcTest_pre cal = new CalcTest_pre(0);
			Runnable run1 = new AnzanMain("選択画面1", cal);
			Thread ta = new Thread(run1);
			ta.run();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}
			CalcTest_pre cal2 = new CalcTest_pre(0);
			Runnable run2 = new CountMain("選択画面2", cal2);
			Thread tb = new Thread(run2);
			tb.run();
			while(true){
				new Thread().join();
				if(cal2.getBool()){
					break;
				}
			}
			count = cal2.getNum();//口数
if(count==-1){
			CalcTest_pre cal2_1 = new CalcTest_pre(0);
			Runnable run2_1 = new CountMain2("選択画面2", cal2_1);
			Thread tb2_1 = new Thread(run2_1);
			tb2_1.run();
			while(true){
				new Thread().join();
				if(cal2_1.getBool()){
					break;
				}
			}
count = cal2_1.getNum();
}

if(count==-1){
			CalcTest_pre cal2_2 = new CalcTest_pre(0);
			Runnable run2_2 = new CountMain3("選択画面2", cal2_2);
			Thread tb2_2 = new Thread(run2_2);
			tb2_2.run();
			while(true){
				new Thread().join();
				if(cal2_2.getBool()){
					break;
				}
			}
count = cal2_2.getNum();
}
			
			CalcTest_pre cal3 = new CalcTest_pre(0);
			Runnable run3 = new DelayMain("選択画面3", cal3);
			Thread tc = new Thread(run3);
			tc.run();
			while(true){
				new Thread().join();
				if(cal3.getBool()){
					break;
				}
			}
			delay = cal3.getNum();//時間間隔
if(delay==-1){
			CalcTest_pre cal3_1 = new CalcTest_pre(0);
			Runnable run3_1 = new DelayMain2("選択画面2", cal3_1);
			Thread tb3_1 = new Thread(run3_1);
			tb3_1.run();
			while(true){
				new Thread().join();
				if(cal3_1.getBool()){
					break;
				}
			}
delay = cal3_1.getNum();
}

if(delay==-2){
			CalcTest_pre cal3_2 = new CalcTest_pre(0);
			Runnable run3_2 = new DelayMain3("選択画面2", cal3_2);
			Thread tb3_2 = new Thread(run3_2);
			tb3_2.run();
			while(true){
				new Thread().join();
				if(cal3_2.getBool()){
					break;
				}
			}
delay = cal3_2.getNum();
}
			CalcTest_pre cal4 = new CalcTest_pre(0);
			Runnable run4 = new Select2("選択画面4", cal4);
			Thread ta4 = new Thread(run4);
			ta4.run();
			while(true){
				new Thread().join();
				if(cal4.getBool()){
					break;
				}
			}

			int first = cal.getNum();
			problem = cal4.getNum();//問題数
			boolean bool2 = false;//バラバラか否か
			if(first == 1){
				digit = 1;
			} else if(first == 2){
				digit = 2;
			} else if(first == 3){
				digit = 3;
			} else if(first == 4){
				digit = 4;
			} else if(first == 5){
				digit = 5;
			} else if(first == 6){
				digit = 2;
				bool2 = true;
			} else if(first == 7){
				digit = 3;
				bool2 = true;
			} else if(first == 8){
				digit = 4;
				bool2 = true;
			} else if(first == 9){
				digit = 5;
				bool2 = true;
			}
	bool = bool2;
}			System.out.println(this.problem);
			System.out.println(this.count);
			System.out.println(this.digit);
			System.out.println(this.delay);
			System.out.println(bool+"\n");


			GameWindow gw = new GameWindow("フラッシュ暗算", 1120, 630);//1600, 900だった, 16:9の＊70
			GameWindow_Start gws = new GameWindow_Start(gw);
			gws.start();
			gws.join();
//			Anzan_pre ap = new Anzan_pre(numbers, delay, gw);
			Anzan_pre ap = new Anzan_pre(delay, gw,count,digit,bool);

			ap.start();
			ap.join();
			CalcTest_pre calc4 = new CalcTest_pre(0);
//			Runnable calc = new CalcTest01("CalcTest00", gw, answer, calc4);
			Runnable calc = new CalcTest01("CalcTest00", gw, ap.getAnswer(),calc4, problem,count,digit,bool,delay);
			Thread t1 = new Thread(calc);
			t1.start();
			//new Thread(new AnzanMain("選択画面1", cal)).start();
		} catch(InterruptedException e){
			System.out.println("不測の事態発生B");
			return; //スレッドを終了させる
		}
	}
}