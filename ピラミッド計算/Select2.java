import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Select2 extends JFrame implements Runnable{
	private CalcTest_pre calc;
	private String[] aa = {"","  [1]   è„ÇË(ÇÃÇ⁄ÇË)", "  [2]   â∫ÇË(Ç≠ÇæÇË)"};
	public void run(){
		Select2 w = new Select2( "ëIëâÊñ " , this.calc);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		w.setSize( 1120, 630 );
		w.setResizable(false);
		w.setVisible( true );
		w.setLocationRelativeTo(null);
	}
	public Select2( String title, CalcTest_pre calc ){
		super( title );
		ImageIcon icon = new ImageIcon("pyramid_pic.jpg");
		setIconImage(icon.getImage());
		this.calc = calc;
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
		ButtonGroup buttonGroup = new ButtonGroup();
		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		
		for(int i = 1; i <= 2; i++){
//			RadioAction ra = new RadioAction(this, i, imap, amap, calc);
//			JButton bt = new JButton(ra);
			JButton button = new JButton(aa[i]);
			button.setFont(new Font("Dialog", Font.PLAIN, 50));
			button.setMaximumSize(new Dimension(1120, 315));
			button.addActionListener(new ClickAction(this, i, imap, amap, calc));
			add(button);
		}
	}
//	class RadioAction extends AbstractAction{
	class ClickAction extends AbstractAction implements ActionListener {
		private Select2 w;
		private int index;
		private InputMap imap;
		private ActionMap amap;
		private CalcTest_pre calc;
		private String[] aa = {"  [1]   è„ÇË(ÇÃÇ⁄ÇË)", "  [2]   â∫ÇË(Ç≠ÇæÇË)"};
		public ClickAction( Select2 w, int index, InputMap imap, ActionMap amap, CalcTest_pre calc){
			this.w = w;
			this.index = index;
			this.imap = imap;
			this.amap = amap;
			this.calc = calc;
			String str = this.aa[this.index - 1];
			putValue( Action.NAME, str);
			Action num1 = new NumKey("  [1]   è„ÇË(ÇÃÇ⁄ÇË)", this.w, this.calc);
			Action num2 = new NumKey("  [2]   â∫ÇË(Ç≠ÇæÇË)", this.w, this.calc);
			this.imap.put(KeyStroke.getKeyStroke("1"), num1);
			this.imap.put(KeyStroke.getKeyStroke("2"), num2);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD1"), num1);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD2"), num2);
			this.amap.put(num1, num1);
			this.amap.put(num2, num2);
		}
		public void actionPerformed( ActionEvent e ){
//			System.out.println( (String)getValue( Action.NAME ) +" Ç™ ëIëÇ≥ÇÍÇ‹ÇµÇΩ" );
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
		private Select2 w;
		private CalcTest_pre calc;
		public NumKey(String num, Select2 w, CalcTest_pre calc){
			this.num = num;
			this.w = w;
			this.calc = calc;
			putValue(Action.NAME, num);
		}
		public void actionPerformed(ActionEvent e){
//			System.out.println( (String)getValue( Action.NAME ) +" Ç™ ëIëÇ≥ÇÍÇ‹ÇµÇΩ" );
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