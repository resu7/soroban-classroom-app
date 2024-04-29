import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Select1b extends JFrame implements Runnable{
	private CalcTest_pre calc;
	private String[] aa = {"","  [1]   1ケタ×1ケタ", "  [2]   2ケタ×1ケタ", "  [3]   3ケタ×1ケタ", "  [4]   2ケタ×2ケタ", "  [5]   3ケタ×2ケタ", "  [6]   3ケタ×3ケタ"};
	public void run(){
		Select1b w = new Select1b( "選択画面" , this.calc);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		w.setSize( 1120, 630 );
		w.setResizable(false);
		w.setVisible( true );
		w.setLocationRelativeTo(null);
	}
	public Select1b( String title, CalcTest_pre calc){
		super( title );
		this.calc = calc;
		ImageIcon icon = new ImageIcon("devil_pic.jpg");
		setIconImage(icon.getImage());
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
		ButtonGroup buttonGroup = new ButtonGroup();
		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		
		for(int i = 1; i <= 6; i++){
			JButton button = new JButton(aa[i]);
			button.setFont(new Font("Dialog", Font.PLAIN, 45));
			setLayout(new GridLayout(3,2,5,5));
			button.setMaximumSize(new Dimension(373, 315));
			button.addActionListener(new ClickAction(this, i, imap, amap, calc));
			add(button);
		}
	}
	class ClickAction extends AbstractAction{
		private Select1b w;
		private int index;
		private InputMap imap;
		private ActionMap amap;
		private CalcTest_pre calc;
		private String[] aa = {"  [1]   1ケタ×1ケタ", "  [2]   2ケタ×1ケタ", "  [3]   3ケタ×1ケタ", "  [4]   2ケタ×2ケタ", "  [5]   3ケタ×2ケタ", "  [6]   3ケタ×3ケタ"};
		public ClickAction( Select1b w, int index, InputMap imap, ActionMap amap, CalcTest_pre calc){
			this.w = w;
			this.index = index;
			this.imap = imap;
			this.amap = amap;
			this.calc = calc;
			String str = this.aa[this.index - 1];
			putValue( Action.NAME, str);
			Action num1 = new NumKey("  [1]   1ケタ×1ケタ", this.w, this.calc);
			Action num2 = new NumKey("  [2]   2ケタ×1ケタ", this.w, this.calc);
			Action num3 = new NumKey("  [3]   3ケタ×1ケタ", this.w, this.calc);
			Action num4 = new NumKey("  [4]   2ケタ×2ケタ", this.w, this.calc);
			Action num5 = new NumKey("  [5]   3ケタ×2ケタ", this.w, this.calc);
			Action num6 = new NumKey("  [6]   3ケタ×3ケタ", this.w, this.calc);
			this.imap.put(KeyStroke.getKeyStroke("1"), num1);
			this.imap.put(KeyStroke.getKeyStroke("2"), num2);
			this.imap.put(KeyStroke.getKeyStroke("3"), num3);
			this.imap.put(KeyStroke.getKeyStroke("4"), num4);
			this.imap.put(KeyStroke.getKeyStroke("5"), num5);
			this.imap.put(KeyStroke.getKeyStroke("6"), num6);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD1"), num1);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD2"), num2);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD3"), num3);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD4"), num4);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD5"), num5);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD6"), num6);
			
			this.amap.put(num1, num1);
			this.amap.put(num2, num2);
			this.amap.put(num3, num3);
			this.amap.put(num4, num4);
			this.amap.put(num5, num5);
			this.amap.put(num6, num6);
		}
		public void actionPerformed( ActionEvent e ){
//			System.out.println( (String)getValue( Action.NAME ) +" が 選択されました" );
			this.w.setVisible(false);
			NumNum azn = new NumNum();
			azn.setNum((String)getValue( Action.NAME ));
			this.calc.setNum(azn.getNum());
			this.calc.setBool(true);
//			System.out.println(calc.getNum());
//			System.out.println(calc.getBool());
			this.w.setVisible(false);
		}
	}
	class NumKey extends AbstractAction{
		private String num;
		private Select1b w;
		private CalcTest_pre calc;
		public NumKey(String num, Select1b w, CalcTest_pre calc){
			this.num = num;
			this.w = w;
			this.calc = calc;
			putValue(Action.NAME, num);
		}
		public void actionPerformed(ActionEvent e){
//			System.out.println( (String)getValue( Action.NAME ) +" が 選択されました" );
			NumNum azn = new NumNum();
			azn.setNum((String)getValue( Action.NAME ));
			this.calc.setNum(azn.getNum());
			this.calc.setBool(true);
//			System.out.println(calc.getNum());
//			System.out.println(calc.getBool());
			this.w.setVisible(false);
		}
	}
}
