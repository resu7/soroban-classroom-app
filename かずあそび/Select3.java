import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Select3 extends JFrame implements Runnable{
	private CalcTest_pre calc;
	String[] aa = {"  [1]   やさしい　", "  [2]   ふつう　　", "  [3]   むずかしい"};
	public void run(){
		Select3 w = new Select3( "選択画面" , this.calc);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		w.setSize( 1120, 630 );
		w.setResizable(false);
		w.setVisible( true );
		w.setLocationRelativeTo(null);
	}
	public Select3( String title, CalcTest_pre calc ){
		super( title );
		ImageIcon icon = new ImageIcon("number_pic.jpg");
		setIconImage(icon.getImage());
		this.calc = calc;
		JPanel pane = (JPanel)getContentPane();pane.setBackground(Color.BLACK);
		pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
		ButtonGroup buttonGroup = new ButtonGroup();
		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		
		for(int i = 0; i < 3; i++){
			JButton button = new JButton(aa[i]);
			if(i==0){button.setBackground(Color.PINK);}
			else if(i==1){button.setBackground(Color.YELLOW);}
			else if(i==2){button.setBackground(Color.green.brighter());}
			button.setFont(new Font("Dialog", Font.PLAIN, 50));
			button.setMaximumSize(new Dimension(1120, 210));
			button.addActionListener(new ClickAction(this, i, imap, amap, calc));
			add(button);
		}
	}
	


	
	class ClickAction extends AbstractAction implements ActionListener {
		private Select3 w;
		private int index;
		private InputMap imap;
		private ActionMap amap;
		private CalcTest_pre calc;
		public ClickAction( Select3 w, int index, InputMap imap, ActionMap amap, CalcTest_pre calc){
			this.w = w;
			this.index = index;
			this.imap = imap;
			this.amap = amap;
			this.calc = calc;
			String str = aa[this.index];
			putValue( Action.NAME, str);
			Action num1 = new NumKey("  [1]   やさしい　", this.w, this.calc);
			Action num2 = new NumKey("  [2]   ふつう　　", this.w, this.calc);
			Action num3 = new NumKey("  [3]   むずかしい", this.w, this.calc);
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
		private Select3 w;
		private CalcTest_pre calc;
		public NumKey(String num, Select3 w, CalcTest_pre calc){
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
