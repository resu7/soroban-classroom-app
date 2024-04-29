import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Select2 extends JFrame implements Runnable{
	private CalcTest_pre calc;private int a;
	private String[] aa = {"","  [1]   入門(にゅうもん)", "  [2]   初級(しょきゅう)", "  [3]   中級(ちゅうきゅう)", "  [4]   上級(じょうきゅう)"};
	private String[] bb = {"","  [1]   1ケタ", "  [2]   2ケタ", "  [3]   3ケタ", "  [4]   4ケタ", "  [5]   5ケタ", "  [6]   6ケタ", "  [7]   7ケタ", "  [8]   8ケタ", "  [9]   9ケタ"};
	public void run(){
		Select2 w = new Select2( "選択画面" , this.calc, this.a);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
/*		if(a==1){
			w.setSize( 80, 260 );
		} else {
			w.setSize( 180, 140 );
		}
*/		w.setSize( 1120, 630 );
		w.setResizable(false);
		w.setVisible( true );
		w.setLocationRelativeTo(null);
	}
	public Select2( String title, CalcTest_pre calc , int a){
		super( title );
		ImageIcon icon = new ImageIcon("soroban_pic.jpg");
		setIconImage(icon.getImage());
		this.calc = calc;this.a = a;
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
		ButtonGroup buttonGroup = new ButtonGroup();
		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		
		if(a==1){
		for(int i = 1; i <= 9; i++){
			JButton button = new JButton(bb[i]);
			button.setFont(new Font("Dialog", Font.PLAIN, 50));
			setLayout(new GridLayout(3,3,5,5));
			button.setMaximumSize(new Dimension(373, 210));
			button.addActionListener(new ClickAction(this, i, imap, amap, calc));
			add(button);
		}
		} else {
		for(int i = 1; i <= 4; i++){
			JButton button = new JButton(aa[i]);
			button.setFont(new Font("Dialog", Font.PLAIN, 45));
			setLayout(new GridLayout(2,2,5,5));
			button.setMaximumSize(new Dimension(560, 315));
			button.addActionListener(new ClickAction(this, i, imap, amap, calc));
			add(button);
		}
		}
	}
	class ClickAction extends AbstractAction{
		private Select2 w;
		private int index;
		private InputMap imap;
		private ActionMap amap;
		private CalcTest_pre calc;
		private String[] aa = {"  [1]   入門(にゅうもん)", "  [2]   初級(しょきゅう)", "  [3]   中級(ちゅうきゅう)", "  [4]   上級(じょうきゅう)"};
		private String[] bb = {"  [1]   1ケタ", "  [2]   2ケタ", "  [3]   3ケタ", "  [4]   4ケタ", "  [5]   5ケタ", "  [6]   6ケタ", "  [7]   7ケタ", "  [8]   8ケタ", "  [9]   9ケタ"};
		public ClickAction( Select2 w, int index, InputMap imap, ActionMap amap, CalcTest_pre calc){
			this.w = w;
			this.index = index;
			this.imap = imap;
			this.amap = amap;
			this.calc = calc;
			String str = "";
			if(a==1){
				str = this.bb[this.index - 1];
			} else {
				str = this.aa[this.index - 1];
			}
			putValue( Action.NAME, str);
			
			if(a==1){

				Action num1 = new NumKey("  [1]   1ケタ", this.w, this.calc);
				Action num2 = new NumKey("  [2]   2ケタ", this.w, this.calc);
				Action num3 = new NumKey("  [3]   3ケタ", this.w, this.calc);
				Action num4 = new NumKey("  [4]   4ケタ", this.w, this.calc);
				Action num5 = new NumKey("  [5]   5ケタ", this.w, this.calc);
				Action num6 = new NumKey("  [6]   6ケタ", this.w, this.calc);
				Action num7 = new NumKey("  [7]   7ケタ", this.w, this.calc);
				Action num8 = new NumKey("  [8]   8ケタ", this.w, this.calc);
				Action num9 = new NumKey("  [9]   9ケタ", this.w, this.calc);
				this.imap.put(KeyStroke.getKeyStroke("1"), num1);
				this.imap.put(KeyStroke.getKeyStroke("2"), num2);
				this.imap.put(KeyStroke.getKeyStroke("3"), num3);
				this.imap.put(KeyStroke.getKeyStroke("4"), num4);
				this.imap.put(KeyStroke.getKeyStroke("5"), num5);
				this.imap.put(KeyStroke.getKeyStroke("6"), num6);
				this.imap.put(KeyStroke.getKeyStroke("7"), num7);
				this.imap.put(KeyStroke.getKeyStroke("8"), num8);
				this.imap.put(KeyStroke.getKeyStroke("9"), num9);
				this.imap.put(KeyStroke.getKeyStroke("NUMPAD1"), num1);
				this.imap.put(KeyStroke.getKeyStroke("NUMPAD2"), num2);
				this.imap.put(KeyStroke.getKeyStroke("NUMPAD3"), num3);
				this.imap.put(KeyStroke.getKeyStroke("NUMPAD4"), num4);
				this.imap.put(KeyStroke.getKeyStroke("NUMPAD5"), num5);
				this.imap.put(KeyStroke.getKeyStroke("NUMPAD6"), num6);
				this.imap.put(KeyStroke.getKeyStroke("NUMPAD7"), num7);
				this.imap.put(KeyStroke.getKeyStroke("NUMPAD8"), num8);
				this.imap.put(KeyStroke.getKeyStroke("NUMPAD9"), num9);
				
				this.amap.put(num1, num1);
				this.amap.put(num2, num2);
				this.amap.put(num3, num3);
				this.amap.put(num4, num4);
				this.amap.put(num5, num5);
				this.amap.put(num6, num6);
				this.amap.put(num7, num7);
				this.amap.put(num8, num8);
				this.amap.put(num9, num9);
				
			} else {
				Action num1 = new NumKey("  [1]   入門(にゅうもん)", this.w, this.calc);
				Action num2 = new NumKey("  [2]   初級(しょきゅう)", this.w, this.calc);
				Action num3 = new NumKey("  [3]   中級(ちゅうきゅう)", this.w, this.calc);
				Action num4 = new NumKey("  [4]   上級(じょうきゅう)", this.w, this.calc);
				this.imap.put(KeyStroke.getKeyStroke("1"), num1);
				this.imap.put(KeyStroke.getKeyStroke("2"), num2);
				this.imap.put(KeyStroke.getKeyStroke("3"), num3);
				this.imap.put(KeyStroke.getKeyStroke("4"), num4);
				this.imap.put(KeyStroke.getKeyStroke("NUMPAD1"), num1);
				this.imap.put(KeyStroke.getKeyStroke("NUMPAD2"), num2);
				this.imap.put(KeyStroke.getKeyStroke("NUMPAD3"), num3);
				this.imap.put(KeyStroke.getKeyStroke("NUMPAD4"), num4);
				
				this.amap.put(num1, num1);
				this.amap.put(num2, num2);
				this.amap.put(num3, num3);
				this.amap.put(num4, num4);
			}
		}
		public void actionPerformed( ActionEvent e ){
			this.w.setVisible(false);
			NumNum azn = new NumNum();
			azn.setNum((String)getValue( Action.NAME ));
			this.calc.setNum(azn.getNum());
			this.calc.setBool(true);
			this.w.setVisible(false);
		}
	}
	class NumKey extends AbstractAction{
		private String num;
		private Select2 w;
		private CalcTest_pre calc;
		public NumKey(String num, Select2 w, CalcTest_pre calc){
			this.num = num;
			this.w = w;
			this.calc = calc;
			putValue(Action.NAME, num);
		}
		public void actionPerformed(ActionEvent e){
			NumNum azn = new NumNum();
			azn.setNum((String)getValue( Action.NAME ));
			this.calc.setNum(azn.getNum());
			this.calc.setBool(true);
			this.w.setVisible(false);
		}
	}
}
