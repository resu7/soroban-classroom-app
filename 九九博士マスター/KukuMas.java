import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class KukuMas extends JFrame implements KeyListener{
	int table2_num = 0;
	JTextField fields[] = new JTextField[20];
	JTextField labels[] = new JTextField[20];
	int[] table = {0,10,1,11,2,12,3,13,4,14,5,15,6,16,7,17,8,18,9,19};
	int[] table2 = {0,2,4,6,8,10,12,14,16,18,1,3,5,7,9,11,13,15,17,19};
	int[] answers = new int[20];
	
	public static void main(String[] args){
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
		
		int mode = cal.getNum();//mode=1`9
		if(mode==9){new NextGo(2);return;}
		//‚±‚Ì1sª‚ğƒRƒƒ“ƒgƒAƒEƒg(execute‚ÆKukuRen‚Ìexecute3‚Ì“¯‚¶‚Æ‚±‚à)‚ÅKukuRen‚¶‚á‚È‚­A1`9‚ÌMIXƒ‚[ƒh‚Ös‚­
		GameWindow gw = new GameWindow("START", 1120, 630);
		GameWindow_Start gws = new GameWindow_Start(gw, "start.jpg", 3000);
		gws.start();
		try{gws.join();}catch(InterruptedException e){e.printStackTrace();}
		String[] questions = KukuMas.getQuestions(mode);
		int[] answers = KukuMas.getAnswers(questions);
		KukuMas w = new KukuMas("‹ã‹ã”mƒ}ƒXƒ^[", questions, answers);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(1120, 630);
		w.setLocationRelativeTo(null);
		w.setResizable(false);
		w.setVisible(true);
	}
	public KukuMas(String title, String[] questions, int[] answers){
		super(title);
		ImageIcon icon = new ImageIcon("doctor_pic.jpg");
		setIconImage(icon.getImage());
		
		addKeyListener(this);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new GridLayout(11, 4));
		this.answers = answers;
		
		JLabel l1 = new JLabel("<html><body>‚Ü‚¦‚Ì‚à‚ñ‚¾‚¢‚ÖFªƒL[<br />‚Â‚¬‚Ì‚à‚ñ‚¾‚¢‚ÖF«ƒL[AEnterƒL[</body></html>");
		JLabel l2 = new JLabel("<html><body>ƒ}ƒEƒX‚Å‚à‚»‚¤‚³‚Å‚«‚é‚æI<br />‚í‚©‚ç‚È‚©‚Á‚½‚çAƒZƒ“ƒZƒC‚É‚«‚±‚¤I</body></html>");
		JTextField l3 = new JTextField();
		JTextField l4 = new JTextField("‚Ì‚±‚è‚¶‚©‚ñF90");
		l3.setEditable(false);
		l3.setBorder(null);
		l4.setEditable(false);
		l4.setBorder(null);
		
		l1.setFont(new Font("Serif", Font.PLAIN, 15));
		l2.setFont(new Font("Serif", Font.PLAIN, 15));
		l3.setFont(new Font("Sefif", Font.BOLD, 25));
		l4.setFont(new Font("Sefif", Font.PLAIN, 25));
		pane.add(l1);
		pane.add(l2);
		pane.add(l3);
		pane.add(l4);
		
		for(int i = 0; i < 20; i++){
			String label_name = "  [" + (table[i]+1) + "]  " + questions[table[i]];
			if(i == 18) label_name = "  [10] " + questions[table[i]];
			JTextField label = new JTextField(label_name);
			label.setEditable(false);
			label.setFont(new Font("Sefif", Font.PLAIN, 38));
			labels[i] = label;
			JTextField field = new JTextField();
			field.addKeyListener(this);
			field.setFont(new Font("Sefif", Font.PLAIN, 38));
			field.setHorizontalAlignment(JTextField.CENTER);
			fields[i] = field;
			pane.add(label);
			pane.add(fields[i]);
		}
		CountMain cm = new CountMain(this,pane);
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				table2_num--;
				if(table2_num == -1) table2_num = 19;
				fields[table2[table2_num]].requestFocus();
				break;
			case KeyEvent.VK_DOWN:
				table2_num++;
				if(table2_num == 20) table2_num = 0;
				fields[table2[table2_num]].requestFocus();
				break;
			case KeyEvent.VK_ENTER:
				table2_num++;
				if(table2_num == 20) table2_num = 0;
				fields[table2[table2_num]].requestFocus();
				break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e){}
	@Override
	public void keyTyped(KeyEvent e){}
	
	class CountMain extends TimerTask{
		private Timer timer = new Timer();
		private KukuMas km;
		private int count = 91;
		private CalcTest_pre cal = new CalcTest_pre(0);
		private JPanel pane;
		
		public CountMain(KukuMas km, JPanel pane){
			super();
			this.km = km;
			this.pane = pane;
			this.timer.scheduleAtFixedRate(this, 1000, 1000);
		}
		public void run(){
			this.count--;
			Component[] comps = this.pane.getComponents();
			JTextField fd1 = (JTextField)comps[3];
			if(this.count == 90) fields[0].requestFocus();
			String space = "";
			if(this.count < 10) space = " ";
			if(this.count >= 0) fd1.setText("‚Ì‚±‚è‚¶‚©‚ñF" + space + this.count);
			if(this.count == 0){
				this.km.setVisible(false);
				int correct = 0;
				JTextField fd2 = (JTextField)comps[2];
				for(int i = 0; i < fields.length; i++){
					JTextField fd = fields[i];
					if(fd.getText().equals(""+answers[table[i]])){
						Color c1 = Color.cyan.brighter();
						fd.setBackground(c1);
						fd.setCaretColor(c1);
						correct++;
					} else {
						Color c2 = Color.PINK;
						fd.setBackground(c2);
						fd.setCaretColor(c2);
					}
					fd.setEditable(false);
					labels[i].setText(labels[i].getText()+answers[table[i]]);
				}
				GameWindow gw = new GameWindow("", 1120, 630);
				String name = "";
				if(correct == fields.length){
					name = "pass.jpg";
				} else {
					name = "fail.jpg";
				}
				fd1.setText("šEnterƒL[‚Å‚Â‚¬‚Ö");
				fd2.setText("‚¹‚¢‚©‚¢F" + correct + "/20‚à‚ñ");
				GameWindow_Start gws = new GameWindow_Start(gw, name, 3000);
				gws.start();
				try{gws.join();}catch(InterruptedException e){e.printStackTrace();}
				this.km.setVisible(true);
				fd1.setEditable(true);
				fd1.setBackground(Color.YELLOW);
				fd1.setCaretColor(Color.YELLOW);
				fd1.requestFocus();
				fd1.addKeyListener(new NextKey(fd1,this.km, this.cal));
			}
			if(this.count < 0) fd1.requestFocus();
			if(this.cal.getBool()){
				timer.cancel();
				execute();
			}
		}
		////////////////////////
		public void execute(){
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
			int mode = cal.getNum();//mode=1`9
			if(mode==9){new NextGo(2);return;}
			GameWindow gw = new GameWindow("START", 1120, 630);
			GameWindow_Start gws = new GameWindow_Start(gw, "start.jpg", 3000);
			gws.start();
			try{gws.join();}catch(InterruptedException e2){e2.printStackTrace();}
			String[] questions = KukuMas.getQuestions(mode);
			int[] answers = KukuMas.getAnswers(questions);
			KukuMas w = new KukuMas("‹ã‹ã”mƒ}ƒXƒ^[", questions, answers);
			w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			w.setSize(1120, 630);
			w.setLocationRelativeTo(null);
			w.setResizable(false);
			w.setVisible(true);
		}
		////////////////////////
	}
	
	
	public static int[] getAnswers(String[] questions){
		int[] answers = new int[20];
		for(int i = 0; i < questions.length; i++){
			String[] question_letters = questions[i].split("");
			int str1 = Integer.parseInt(question_letters[0]);
			int str2 = Integer.parseInt(question_letters[2]);
			answers[i] = str1 * str2;
		}
		return answers;
	}
	
	public static String[] getQuestions(int mode){
		String[] questions = new String[20];
		List<String> questionsA = new ArrayList<String>();
		List<String> questionsB = new ArrayList<String>();
		List<String> questionsC = new ArrayList<String>();
		
		if(mode == 1){
			for(int i = 0; i < 10; i++){
				String questionA = "1~" + i + " = ";
				String questionB = "2~" + i + " = ";
				questionsA.add(questionA);
				questionsB.add(questionB);
			}
			Collections.shuffle(questionsA);
			Collections.shuffle(questionsB);
			questionsA.addAll(questionsB);
		} else if(mode == 9){
			Random rd = new Random();
			int r1 = rd.nextInt(9) + 1;
			int r2 = rd.nextInt(9) + 1;
			while(r1==r2) r2 = rd.nextInt(9) + 1;
			for(int i = 1; i < 10; i++){
				int a = rd.nextInt(10);
				int b = rd.nextInt(10);
				while(a==b) b = rd.nextInt(10);
				if(i==r1||i==r2){
					int c = rd.nextInt(10);
					while(a==c||b==c) c = rd.nextInt(10);
					String questionC = i + "~" + c + " = ";
					questionsA.add(questionC);
				}
				
				String questionA = i + "~" + a + " = ";
				String questionB = i + "~" + b + " = ";
				questionsA.add(questionA);
				questionsA.add(questionB);
				Collections.shuffle(questionsA);
			}
		} else {
			for(int i = 0; i < 10; i++){
				String questionA = (mode-1) + "~" + i + " = ";
				String questionB = mode + "~" + i + " = ";
				String questionC = (mode+1) + "~" + i + " = ";
				questionsA.add(questionA);
				questionsB.add(questionB);
				questionsC.add(questionC);
			}
			Collections.shuffle(questionsA);
			Collections.shuffle(questionsB);
			Collections.shuffle(questionsC);
			
			questionsA = questionsA.subList(0,5);
			questionsB = questionsB.subList(0,5);
			questionsA.addAll(questionsB);
			Collections.shuffle(questionsA);
			questionsA.addAll(questionsC);
		}
		questionsA.toArray(questions);
		return questions;
	}
}
class NextKey implements KeyListener{
	JTextField fd; KukuMas km; CalcTest_pre cal;
	public NextKey(JTextField fd, KukuMas km, CalcTest_pre cal){
		this.fd = fd;
		this.km = km;
		this.cal = cal;
	}
	@Override
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			this.km.setVisible(false);
			this.cal.setBool(true);
		} else {
			this.fd.setText("šEnterƒL[‚Å‚Â‚¬‚Ö");
		}
	}
	@Override
	public void keyPressed(KeyEvent e){}
	@Override
	public void keyTyped(KeyEvent e){}
}

class ModeSelect extends JFrame implements Runnable{
	private String[] labels = {" [1]  €‚P‚O‹‰", " [2]  ‚P‚O‹‰@", " [3]  €‚X‹‰", " [4]  ‚X‹‰@", " [5]  €‚W‹‰", " [6]  ‚W‹‰@", " [7]  €‚V‹‰", " [8]  ‚V‹‰@", " [9]  ‚ê‚ñ‚µ‚ã‚¤"};
	private CalcTest_pre calc;
	public ModeSelect(String title, CalcTest_pre calc){
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
			button.addActionListener(new ClickAction(this, imap, amap, i, this.calc));
			pane.add(button);
		}
	}
	public void run(){
		ModeSelect w = new ModeSelect("‘I‘ğ‰æ–Ê", this.calc);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		w.setSize( 1120, 630 );
		w.setResizable(false);
		w.setVisible( true );
		w.setLocationRelativeTo(null);
	}
}

class ClickAction extends AbstractAction{
	ModeSelect ms; InputMap imap; ActionMap amap; int index; CalcTest_pre calc;
	private String[] labels = {" [1]  €‚P‚O‹‰", " [2]  ‚P‚O‹‰@", " [3]  €‚X‹‰", " [4]  ‚X‹‰@", " [5]  €‚W‹‰", " [6]  ‚W‹‰@", " [7]  €‚V‹‰", " [8]  ‚V‹‰@", " [9]  ‚ê‚ñ‚µ‚ã‚¤"};
	public ClickAction(ModeSelect ms, InputMap imap, ActionMap amap, int index, CalcTest_pre calc){
		this.ms = ms; this.imap = imap; this.amap = amap; this.index = index; this.calc = calc;
		putValue( Action.NAME, this.labels[this.index]);
		for(int i = 0; i < this.labels.length; i++){
			Action num = new NumKey(this.labels[i], this.ms, this.calc);
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

class NumKey extends AbstractAction{
	String label; ModeSelect ms; CalcTest_pre calc;
	private String[] labels = {" [1]  €‚P‚O‹‰", " [2]  ‚P‚O‹‰@", " [3]  €‚X‹‰", " [4]  ‚X‹‰@", " [5]  €‚W‹‰", " [6]  ‚W‹‰@", " [7]  €‚V‹‰", " [8]  ‚V‹‰@", " [9]  ‚ê‚ñ‚µ‚ã‚¤"};
	public NumKey(String label, ModeSelect ms, CalcTest_pre calc){
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
class GameWindow extends JFrame{
	String title;
	public GameWindow(String title, int width, int height){
		super(title);this.title = title;
		ImageIcon icon = new ImageIcon("doctor_pic.jpg");
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
	private GameWindow gw; private String name; private int delay;
	public GameWindow_Start(GameWindow gw, String name, int delay){
		this.gw = gw;
		this.name = name;
		this.delay = delay;
	}
	public void run(){
		try{
			this.gw.add(new DrawCanvas(this.name));
			this.gw.setVisible(true);
			Thread.sleep(this.delay);
			this.gw.setVisible(false);
			return;
		} catch(InterruptedException e){
			System.out.println("•s‘ª‚Ì–‘Ô”­¶C");
			return;
		}
	}
}
class DrawCanvas extends JPanel{
	ImageIcon backImage;
	public DrawCanvas(String name){
		backImage = new ImageIcon(name);
	}
	@Override
	protected void paintComponent(Graphics g){
		BufferedImage scaledImage = getScaledImage();
		super.paintComponent(g);
		g.drawImage(scaledImage, 0, 0, null);
	}
	private BufferedImage getScaledImage(){
		BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D) image.createGraphics();
		g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
		g2d.drawImage(backImage.getImage(), 0, 0,getWidth(),getHeight(), null);
		return image;
	}
}
