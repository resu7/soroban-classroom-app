import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class KukuRen extends JFrame{
	JTextField questions[] = new JTextField[9];//–â‘è—“
	JTextField answers[] = new JTextField[9];//‰ğ“š—“
	JButton buttons[] = new JButton[4];
	String button_labels[] = {
		"<html><body>y‚à‚¤‚¢‚¿‚Çz<br/>F1‚ğ‚¨‚·‚©<br/>‚±‚±‚ğƒNƒŠƒbƒN</body></html>",
		"<html><body>y‚Ù‚©‚Ì‚¾‚ñz<br/>F2‚ğ‚¨‚·‚©<br/>‚±‚±‚ğƒNƒŠƒbƒN</body></html>",
		"<html><body>y‚³‚¢‚µ‚å‚Öz<br/>F3‚ğ‚¨‚·‚©<br/>‚±‚±‚ğƒNƒŠƒbƒN</body></html>",
		"<html><body>y@‚±‚½‚¦@z<br/>F4‚ğ‚¨‚·‚©<br/>‚±‚±‚ğƒNƒŠƒbƒN</body></html>"
	};
	public KukuRen(int mode){
		ImageIcon icon = new ImageIcon("doctor_pic.jpg");
		setIconImage(icon.getImage());
		int n = mode;
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(840, 630));
		GridLayout layout1 = new GridLayout(10,2);
		p1.setLayout(layout1);
		
		JTextField title_label1 = new JTextField(mode + "‚Ì‚¾‚ñ");
		title_label1 = this.formatField(title_label1, false, true);
		JTextField title_label2 = new JTextField();
		title_label2 = this.formatField(title_label2, false, true);
		title_label2.setFont(new Font("Sefif", Font.ITALIC, 38));
		p1.add(title_label1); p1.add(title_label2);
		for(int i = 0; i < questions.length; i++){
			questions[i] = new JTextField("       ["+(i+1)+"]    "+n+"~"+(i+1)+" = "/*+(n*(i+1))*/);
			questions[i] = this.formatField(questions[i], false, false);
			p1.add(questions[i]);
			answers[i] = new JTextField();
			answers[i] = this.formatField(answers[i], false, true);
			answers[i].addKeyListener(new KeyListener1(n,i,answers, this, title_label2));
			p1.add(answers[i]);
		}
		
		JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(280, 630));
		FlowLayout layout2 = new FlowLayout();
		layout2.setAlignment(FlowLayout.LEFT);
		p2.setLayout(layout2);
		for(int i = 0; i < buttons.length; i++){
			JButton button = new JButton(button_labels[i]);
			button.setFont(new Font("Sefif", Font.PLAIN, 33));
			button.setHorizontalAlignment(JTextField.CENTER);
			button.addMouseListener(new ClickListener(this, i, answers, n, title_label2));
			p2.add(button);
		}
		this.add("Center", p1);
		this.add("East", p2);
		this.addWindowListener( new WindowAdapter(){
			public void windowOpened( WindowEvent e ){
				answers[0].setEditable(true);
				answers[0].requestFocus();
			}
		});
		this.setVisible(true);
	}
	public JTextField formatField(JTextField jf, boolean bool1, boolean bool2){
		jf.setEditable(bool1);//bool1:editable, bool2:center
		jf.setFont(new Font("Sefif", Font.PLAIN, 38));
		if(bool2) jf.setHorizontalAlignment(JTextField.CENTER);
		return jf;
	}
}

class ClickListener implements MouseListener{
	private KukuRen kr; private int mode; private JTextField[] fields; private int n;
	private JTextField last; private boolean clear = false;
	public ClickListener(KukuRen kr, int mode, JTextField[] fields, int n, JTextField last){
		this.kr = kr;
		this.mode = mode;
		this.fields = fields;
		this.n = n;
		this.last = last;
	}
	public void mouseClicked(MouseEvent e){
		switch(this.mode){
			case 0: this.kr.setVisible(false); new NextGo(1, this.n);break;
			case 1: this.kr.setVisible(false); new NextGo(2);break;
			case 2: this.kr.setVisible(false); new NextGo(3);break;
			case 3:
				if(clear) return;
				for(int i = 0; i < this.fields.length; i++){
					JTextField jf = this.fields[i];
					if(jf.isEditable()){
						jf.setText(""+(n * (i+1)));
						jf.setEditable(false);
						jf.setBackground(Color.PINK);
						if(i==this.fields.length-1){
							this.clear = true;
							jf.setCaretColor(Color.PINK);
							this.last.setText("‚¨‚Â‚©‚ê‚³‚ÜI");
							return;
						}
						this.fields[i+1].setEditable(true);
						this.fields[i+1].requestFocus();
						break;
					}
				}
				break;
		}
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
}

class KeyListener1 implements KeyListener{
	int a = 0, b = 0; JTextField jf, last; JTextField[] fields; KukuRen kr;
	boolean clear = false;
	public KeyListener1(int n, int i, JTextField[] fields, KukuRen kr, JTextField last){
		this.a = n;
		this.b = i + 1;
		this.jf = fields[i];
		this.fields = fields;
		this.kr = kr;
		this.last = last;
	}
	public void keyPressed(KeyEvent e){
		if(clear){jf.setText(""+a*b);}
		switch(e.getKeyCode()){
			case KeyEvent.VK_ENTER:
				if(jf.getText().equals(""+(a*b))){
					jf.setEditable(false);
					jf.setBackground(Color.cyan.brighter());
					if(b==this.fields.length){
						clear = true;
						jf.setCaretColor(Color.cyan.brighter());
						last.setText("‚¨‚Â‚©‚ê‚³‚ÜI");
						return;
					}
					this.fields[b].setEditable(true);
					this.fields[b].requestFocus();
				} else {
					jf.setText("");
				}
				break;
			case KeyEvent.VK_F1: this.kr.setVisible(false);new NextGo(1,a);break;
			case KeyEvent.VK_F2: this.kr.setVisible(false);new NextGo(2);break;
			case KeyEvent.VK_F3: this.kr.setVisible(false);new NextGo(3);break;
			case KeyEvent.VK_F4:
				jf.setText(""+(a*b));
				jf.setEditable(false);
				jf.setBackground(Color.PINK);
				if(b==this.fields.length){
					clear = true;
					jf.setCaretColor(Color.PINK);
					last.setText("‚¨‚Â‚©‚ê‚³‚ÜI");
					return;
				}
				this.fields[b].setEditable(true);
				this.fields[b].requestFocus();
				break;
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
}

class ModeSelect2 extends JFrame implements Runnable{
	private String[] labels = {" [1]  ‚P‚Ì‚¾‚ñ", " [2]  ‚Q‚Ì‚¾‚ñ", " [3]  ‚R‚Ì‚¾‚ñ", " [4]  ‚S‚Ì‚¾‚ñ", " [5]  ‚T‚Ì‚¾‚ñ", " [6]  ‚U‚Ì‚¾‚ñ", " [7]  ‚V‚Ì‚¾‚ñ", " [8]  ‚W‚Ì‚¾‚ñ", " [9]  ‚X‚Ì‚¾‚ñ"};
	private CalcTest_pre calc;
	public ModeSelect2(String title, CalcTest_pre calc){
		super(title);
		ImageIcon icon = new ImageIcon("doctor_pic.jpg");
		setIconImage(icon.getImage());
		this.calc = calc;
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new GridLayout(3, 3));
		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		
		for(int i = 0; i < 9; i++){
			JButton button = new JButton(labels[i]);
			button.setFont(new Font("Dialog", Font.PLAIN, 35));
			button.setMaximumSize(new Dimension(373, 210));
			button.addActionListener(new ClickAction2(this, imap, amap, i, this.calc));
			pane.add(button);
		}
	}
	public void run(){
		ModeSelect2 w = new ModeSelect2("‘I‘ğ‰æ–Ê", this.calc);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		w.setSize( 1120, 630 );
		w.setResizable(false);
		w.setVisible( true );
		w.setLocationRelativeTo(null);
	}
}
class ClickAction2 extends AbstractAction{
	ModeSelect2 ms; InputMap imap; ActionMap amap; int index; CalcTest_pre calc;
	private String[] labels = {" [1]  ‚P‚Ì‚¾‚ñ", " [2]  ‚Q‚Ì‚¾‚ñ", " [3]  ‚R‚Ì‚¾‚ñ", " [4]  ‚S‚Ì‚¾‚ñ", " [5]  ‚T‚Ì‚¾‚ñ", " [6]  ‚U‚Ì‚¾‚ñ", " [7]  ‚V‚Ì‚¾‚ñ", " [8]  ‚W‚Ì‚¾‚ñ", " [9]  ‚X‚Ì‚¾‚ñ"};
	public ClickAction2(ModeSelect2 ms, InputMap imap, ActionMap amap, int index, CalcTest_pre calc){
		this.ms = ms; this.imap = imap; this.amap = amap; this.index = index; this.calc = calc;
		putValue( Action.NAME, this.labels[this.index]);
		for(int i = 0; i < this.labels.length; i++){
			Action num = new NumKey2(this.labels[i], this.ms, this.calc);
			this.imap.put(KeyStroke.getKeyStroke(""+(i+1)), num);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD"+(i+1)), num);
			this.amap.put(num, num);
		}
	}
	public void actionPerformed( ActionEvent e ){
		this.ms.setVisible(false);
		String label = (String)getValue(Action.NAME);
		for(int i = 0; i < this.labels.length; i++){
			if(this.labels[i].equals(label)){
				this.calc.setNum(i+1);
				this.calc.setBool(true);
			}
		}
	}
}
class NumKey2 extends AbstractAction{
	String label; ModeSelect2 ms; CalcTest_pre calc;
	private String[] labels = {" [1]  ‚P‚Ì‚¾‚ñ", " [2]  ‚Q‚Ì‚¾‚ñ", " [3]  ‚R‚Ì‚¾‚ñ", " [4]  ‚S‚Ì‚¾‚ñ", " [5]  ‚T‚Ì‚¾‚ñ", " [6]  ‚U‚Ì‚¾‚ñ", " [7]  ‚V‚Ì‚¾‚ñ", " [8]  ‚W‚Ì‚¾‚ñ", " [9]  ‚X‚Ì‚¾‚ñ"};
	public NumKey2(String label, ModeSelect2 ms, CalcTest_pre calc){
		this.label = label; this.ms = ms; this.calc = calc;
		putValue( Action.NAME, this.label);
	}
	public void actionPerformed( ActionEvent e ){
		this.ms.setVisible(false);
		String label = (String)getValue(Action.NAME);
		for(int i = 0; i < this.labels.length; i++){
			if(this.labels[i].equals(label)){
				this.calc.setNum(i+1);
				this.calc.setBool(true);
			}
		}
	}
}

class NextGo extends TimerTask{
	private Timer timer = new Timer();
	private int num; private int num2;
	public NextGo(int num){
		super();
		this.num = num;
		this.timer.scheduleAtFixedRate(this, 1000, 1000);
	}
	public NextGo(int num, int num2){
		super();
		this.num = num;
		this.num2 = num2;
		this.timer.scheduleAtFixedRate(this, 1000, 1000);
	}
	public void run(){
		switch (this.num){
			case 1: execute1();break;
			case 2: execute2();break;
			case 3: execute3();break;
		}
		timer.cancel();
	}
	public void execute1(){
		GameWindow gw = new GameWindow("START", 1120, 630);
		GameWindow_Start gws = new GameWindow_Start(gw, "start.jpg", 3000);
		gws.start();
		try{gws.join();}catch(InterruptedException e2){e2.printStackTrace();}
		KukuRen frame = new KukuRen(this.num2);
		frame.setTitle("‹ã‹ã”mƒ}ƒXƒ^[");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( 1120, 630 );
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible( true );
	}
	public void execute2(){
		CalcTest_pre cal = new CalcTest_pre(0);
		try{
			Runnable run1 = new ModeSelect2("‘I‘ğ‰æ–Ê", cal);
			Thread ta = new Thread(run1);
			ta.run();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}
		}catch(InterruptedException ie){ie.printStackTrace();}
		int mode = cal.getNum();
		GameWindow gw = new GameWindow("START", 1120, 630);
		GameWindow_Start gws = new GameWindow_Start(gw, "start.jpg", 3000);
		gws.start();
		try{gws.join();}catch(InterruptedException e2){e2.printStackTrace();}
		KukuRen frame = new KukuRen(mode);
		frame.setTitle("‹ã‹ã”mƒ}ƒXƒ^[");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( 1120, 630 );
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible( true );
	}
	public void execute3(){
		CalcTest_pre cal = new CalcTest_pre(0);
		try{
			Runnable run1 = new ModeSelect("‘I‘ğ‰æ–Ê", cal);
			Thread ta = new Thread(run1);
			ta.run();
			while(true){
				new Thread().join();
				if(cal.getBool()){
					break;
				}
			}
		}catch(InterruptedException ie){ie.printStackTrace();}
		int mod = cal.getNum();//mode=1`9
		if(mod==9){new NextGo(2);return;}
		GameWindow gw = new GameWindow("START", 1120, 630);
		GameWindow_Start gws = new GameWindow_Start(gw, "start.jpg", 3000);
		gws.start();
		try{gws.join();}catch(InterruptedException e2){e2.printStackTrace();}
		String[] questions = KukuMas.getQuestions(mod);
		int[] answers = KukuMas.getAnswers(questions);
		KukuMas w = new KukuMas("‹ã‹ã”mƒ}ƒXƒ^[", questions, answers);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(1120, 630);
		w.setLocationRelativeTo(null);
		w.setResizable(false);
		w.setVisible(true);
	}
}