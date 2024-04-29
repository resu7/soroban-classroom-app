import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Select2 extends JFrame implements Runnable{
	private CalcTest_pre calc;
	String[] aa = {"  [1]   1 ‚à‚ñ", "  [2]   5 ‚à‚ñ", "  [3]  10 ‚à‚ñ"};
	public void run(){
		Select2 w = new Select2( "‘I‘ð‰æ–Ê4" , this.calc);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		w.setSize( 1120, 630 );
		w.setResizable(false);
		w.setVisible( true );
		w.setLocationRelativeTo(null);
	}
	public Select2( String title, CalcTest_pre calc ){
		super( title );
		ImageIcon icon = new ImageIcon("flush_pic.jpg");
		setIconImage(icon.getImage());
		this.calc = calc;
		JPanel pane = (JPanel)getContentPane();pane.setBackground(Color.BLACK);
		pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
		ButtonGroup buttonGroup = new ButtonGroup();
		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		
		for(int i = 0; i < 3; i++){
//			RadioAction ra = new RadioAction(this, i, imap, amap, calc);
//			JButton bt = new JButton(ra);
			JButton button = new JButton(aa[i]);
			button.setFont(new Font("Dialog", Font.PLAIN, 50));
			button.setMaximumSize(new Dimension(1120, 210));
			button.addActionListener(new ClickAction(this, i, imap, amap, calc));
			add(button);
		}
	}
	


	
	class ClickAction extends AbstractAction implements ActionListener {
		private Select2 w;
		private int index;
		private InputMap imap;
		private ActionMap amap;
		private CalcTest_pre calc;
		public ClickAction( Select2 w, int index, InputMap imap, ActionMap amap, CalcTest_pre calc){
			this.w = w;
			this.index = index;
			this.imap = imap;
			this.amap = amap;
			this.calc = calc;
			String str = aa[this.index];
			putValue( Action.NAME, str);
			Action num1 = new NumKey("  [1]   1 ‚à‚ñ", this.w, this.calc);
			Action num2 = new NumKey("  [2]   5 ‚à‚ñ", this.w, this.calc);
			Action num3 = new NumKey("  [3]  10 ‚à‚ñ", this.w, this.calc);
			this.imap.put(KeyStroke.getKeyStroke("1"), num1);
			this.imap.put(KeyStroke.getKeyStroke("2"), num2);
			this.imap.put(KeyStroke.getKeyStroke("3"), num3);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD1"), num1);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD2"), num2);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD3"), num3);

			this.amap.put(num1, num1);
			this.amap.put(num2, num2);
			this.amap.put(num3, num3);
		}
		public void actionPerformed( ActionEvent e ){
//			System.out.println( (String)getValue( Action.NAME ) +" ‚ª ‘I‘ð‚³‚ê‚Ü‚µ‚½" );
			this.w.setVisible(false);
			Anzan azn = new Anzan((String)getValue( Action.NAME ));
			this.calc.setNum(azn.getNum());
			this.calc.setBool(true);
//			System.out.println(calc.getNum());
//			System.out.println(calc.getBool());
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
//			System.out.println( (String)getValue( Action.NAME ) +" ‚ª ‘I‘ð‚³‚ê‚Ü‚µ‚½" );
			Anzan azn = new Anzan((String)getValue( Action.NAME ));
			this.calc.setNum(azn.getNum());
			this.calc.setBool(true);
//			System.out.println(calc.getNum());
//			System.out.println(calc.getBool());
			this.w.setVisible(false);
		}
	}
}
