import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Select4 extends JFrame implements Runnable{
	private CalcTest_pre calc;
	private String[] aa = {"","  [1]   両方珠(りょうほうたま)", "  [2]   左だけ珠(ひだりだけたま)", "  [3]   右だけ珠(みぎだけたま)"};
	public void run(){
		Select4 w = new Select4( "選択画面" , this.calc);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		w.setSize( 1120, 630 );
		w.setResizable(false);
		w.setVisible( true );
		w.setLocationRelativeTo(null);
	}
	public Select4( String title, CalcTest_pre calc ){
		super( title );
		ImageIcon icon = new ImageIcon("soroban_pic.jpg");
		setIconImage(icon.getImage());
		this.calc = calc;
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
		ButtonGroup buttonGroup = new ButtonGroup();
		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		
		for(int i = 1; i <= 3; i++){
			JButton button = new JButton(aa[i]);
			button.setFont(new Font("Dialog", Font.PLAIN, 40));
			button.setMaximumSize(new Dimension(1120, 210));
			button.addActionListener(new ClickAction(this, i, imap, amap, calc));
			add(button);
		}
	}
	class ClickAction extends AbstractAction{
		private Select4 w;
		private int index;
		private InputMap imap;
		private ActionMap amap;
		private CalcTest_pre calc;
		private String[] aa = {"  [1]   両方珠(りょうほうたま)", "  [2]   左だけ珠(ひだりだけたま)", "  [3]   右だけ珠(みぎだけたま)"};
		public ClickAction( Select4 w, int index, InputMap imap, ActionMap amap, CalcTest_pre calc){
			this.w = w;
			this.index = index;
			this.imap = imap;
			this.amap = amap;
			this.calc = calc;
			String str = this.aa[this.index - 1];
			putValue( Action.NAME, str);
			Action num1 = new NumKey("  [1]   両方珠(りょうほうたま)", this.w, this.calc);
			Action num2 = new NumKey("  [2]   左だけ珠(ひだりだけたま)", this.w, this.calc);
			Action num3 = new NumKey("  [3]   右だけ珠(みぎだけたま)", this.w, this.calc);
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
		private Select4 w;
		private CalcTest_pre calc;
		public NumKey(String num, Select4 w, CalcTest_pre calc){
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
