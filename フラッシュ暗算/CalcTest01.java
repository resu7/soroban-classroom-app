
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalcTest01 extends JFrame implements Runnable{
	JTextField field = new JTextField();
	GameWindow gw;
	int answer;
	int problem;
	CalcTest_pre cap;
	private int delay;
	private int count;
	private int digit;
	private boolean bool;

	public void run(){
		CalcTest01 w = new CalcTest01("解答入力", this.gw, this.answer, this.cap,this.problem,this.count,this.digit,this.bool,this.delay);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize( 1120, 630);
		w.setVisible( true );
		w.setResizable(false);
		w.setLocationRelativeTo(null);
	}

	public CalcTest01(String title, GameWindow gw, int answer, CalcTest_pre cap, int problem,int count,int digit,boolean bool,int delay){
		super(title);
		ImageIcon icon = new ImageIcon("flush_pic.jpg");
		setIconImage(icon.getImage());
		this.gw = gw;
		this.answer = answer;
		this.cap = cap;
		this.problem = problem;
		this.count = count;
		this.digit = digit;
		this.bool = bool;
		this.delay = delay;
		JPanel pane = (JPanel)getContentPane();
//		pane.add(field, BorderLayout.NORTH);

		field.setFont(new Font("Dialog", Font.PLAIN, 170));
		field.setHorizontalAlignment(JTextField.CENTER);
		pane.add(field);
		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		FuncKey fck = new FuncKey("R|W",this, this.gw, this.answer, this.cap,this.problem,this.count,this.digit,this.bool,this.delay);
		KeyStroke k = KeyStroke.getKeyStroke("ENTER");
		imap.put(k, fck);
		amap.put(fck, fck);
	}

	class NumKey extends AbstractAction{
		NumKey(String num){
			putValue(Action.NAME, num);
		}
		public void actionPerformed(ActionEvent e){
			String num = (String)getValue(Action.NAME);
			field.setText(field.getText() + num);
		}
	}
	class FuncKey extends AbstractAction{
		CalcTest01 calc;
		GameWindow gw;
		int answer;
		CalcTest_pre cap;
		int problem;
	private int delay;
	private int count;
	private int digit;
	private boolean bool;

		FuncKey(String label, CalcTest01 calc, GameWindow gw, int answer, CalcTest_pre cap, int problem,int count,int digit,boolean bool,int delay){
			putValue(Action.NAME, label);
			this.calc = calc;
			this.gw = gw;
			this.answer = answer;
			this.cap = cap;
			this.problem = problem;
		this.count = count;
		this.digit = digit;
		this.bool = bool;
		this.delay = delay;
		}
		public void actionPerformed(ActionEvent e){
			String label = (String)getValue(Action.NAME);
			if(label.equals("C")){
				field.setText("");
			} else if(label.equals("R|W")){
				String input_answer = field.getText();
				this.calc.setVisible(false);
				this.problem--;
				if(input_answer.equals("" + this.answer)){
					Runnable run1 = new abc(this.gw, this.answer, input_answer, this.cap,this.problem,this.count,this.digit,this.bool,this.delay);
					Thread t1 = new Thread(run1);
					t1.start();
				} else {
					Runnable run2 = new abc2(this.gw, this.answer, input_answer, this.cap,this.problem,this.count,this.digit,this.bool,this.delay);
					Thread t2 = new Thread(run2);
					t2.start();
				}
			}//CalcTest_pre.javaが残りのスカスカファイル
		}
	}
}