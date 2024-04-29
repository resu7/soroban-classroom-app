import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Select extends JFrame implements Runnable{
	private CalcTest_pre calc;
	String[] aa = {"","  [1]   ‚â‚³‚µ‚¢", "  [2]   ‚Ó‚Â‚¤", "  [3]   ‚Þ‚¸‚©‚µ‚¢"};
	public void run(){
		Select w = new Select( "‘I‘ð‰æ–Ê" , this.calc);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		w.setSize( 1120, 630 );
		w.setResizable(false);
		w.setVisible( true );
		w.setLocationRelativeTo(null);
	}
	public Select( String title, CalcTest_pre calc ){
		super( title );
		ImageIcon icon = new ImageIcon("pyramid_pic.jpg");
		setIconImage(icon.getImage());
		this.calc = calc;
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
		ButtonGroup buttonGroup = new ButtonGroup();
		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		
		for(int i = 1; i <= 3; i++){
//			RadioAction ra = new RadioAction(this, i, imap, amap, calc);
//			JButton bt = new JButton(ra);
			JButton button = new JButton(aa[i]);
			button.setFont(new Font("Dialog", Font.PLAIN, 50));
			button.setMaximumSize(new Dimension(1120, 210));
			button.addActionListener(new ClickAction(this, i, imap, amap, calc));
			add(button);
		}
	}
//	class RadioAction extends AbstractAction{
	class ClickAction extends AbstractAction implements ActionListener {
		private Select w;
		private int index;
		private InputMap imap;
		private ActionMap amap;
		private CalcTest_pre calc;
		private String[] aa = {"  [1]   ‚â‚³‚µ‚¢", "  [2]   ‚Ó‚Â‚¤", "  [3]   ‚Þ‚¸‚©‚µ‚¢"};
		public ClickAction( Select w, int index, InputMap imap, ActionMap amap, CalcTest_pre calc){
			this.w = w;
			this.index = index;
			this.imap = imap;
			this.amap = amap;
			this.calc = calc;
			String str = this.aa[this.index - 1];
			putValue( Action.NAME, str);
			Action num1 = new NumKey("  [1]   ‚â‚³‚µ‚¢", this.w, this.calc);
			Action num2 = new NumKey("  [2]   ‚Ó‚Â‚¤", this.w, this.calc);
			Action num3 = new NumKey("  [3]   ‚Þ‚¸‚©‚µ‚¢", this.w, this.calc);
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
		private Select w;
		private CalcTest_pre calc;
		public NumKey(String num, Select w, CalcTest_pre calc){
			this.num = num;
			this.w = w;
			this.calc = calc;
			putValue(Action.NAME, num);
		}
		public void actionPerformed(ActionEvent e){
//			System.out.println( (String)getValue( Action.NAME ) +" ‚ª ‘I‘ð‚³‚ê‚Ü‚µ‚½" );
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
