import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnzanMain extends JFrame implements Runnable{
	private CalcTest_pre calc;
	String[] aa = {"","  [1]   1ケタ(そろい)","  [2]   2ケタ(そろい)","  [3]   3ケタ(そろい)","  [4]   4ケタ(そろい)","  [5]   5ケタ(そろい)","  [6]   2ケタ(バラバラ)","  [7]   3ケタ(バラバラ)","  [8]   4ケタ(バラバラ)","  [9]   5ケタ(バラバラ)"};
	public void run(){
		AnzanMain w = new AnzanMain( "選択画面１" , this.calc);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		w.setSize( 1120, 630 );
		w.setVisible( true );
		w.setResizable(false);
		w.setLocationRelativeTo(null);
	}
	public AnzanMain( String title, CalcTest_pre calc ){
		super( title );
		this.calc = calc;
		ImageIcon icon = new ImageIcon("flush_pic.jpg");
		setIconImage(icon.getImage());
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
		ButtonGroup buttonGroup = new ButtonGroup();
		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		
/*		for(int i = 1; i <= 9; i++){
			RadioAction ra = new RadioAction(this, i, imap, amap, calc);
			JRadioButton bt = new JRadioButton(ra);
			pane.add( bt );
			buttonGroup.add( bt );
		}
*/
		for(int i = 1; i <= 9; i++){
			JButton button = new JButton(aa[i]);
			button.setFont(new Font("Dialog", Font.PLAIN, 30));
			setLayout(new GridLayout(3,3,5,5));
			button.setMaximumSize(new Dimension(373, 210));
			button.addActionListener(new ClickAction(this, i, imap, amap, calc));
			add(button);
		}

	}


	class ClickAction extends AbstractAction implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("Button 1 was clicked.");
//		}
//	}
	
//	class RadioAction extends AbstractAction{
		private AnzanMain w;
		private int index;
		private InputMap imap;
		private ActionMap amap;
		private CalcTest_pre calc;
		public ClickAction( AnzanMain w, int index, InputMap imap, ActionMap amap, CalcTest_pre calc){
			this.w = w;
			this.index = index;
			this.imap = imap;
			this.amap = amap;
			this.calc = calc;
			if(index > 5){
				index -= 4;
			}
			String str = "  [" + this.index + "]   " + index + "ケタ";
			if(this.index <= 5){
				str += "(そろい)";
			} else {
				str += "(バラバラ)";
			}
			putValue( Action.NAME, str);
			Action num1 = new NumKey("  [1]   1ケタ(そろい)", this.w, this.calc);
			Action num2 = new NumKey("  [2]   2ケタ(そろい)", this.w, this.calc);
			Action num3 = new NumKey("  [3]   3ケタ(そろい)", this.w, this.calc);
			Action num4 = new NumKey("  [4]   4ケタ(そろい)", this.w, this.calc);
			Action num5 = new NumKey("  [5]   5ケタ(そろい)", this.w, this.calc);
			Action num6 = new NumKey("  [6]   2ケタ(バラバラ)", this.w, this.calc);
			Action num7 = new NumKey("  [7]   3ケタ(バラバラ)", this.w, this.calc);
			Action num8 = new NumKey("  [8]   4ケタ(バラバラ)", this.w, this.calc);
			Action num9 = new NumKey("  [9]   5ケタ(バラバラ)", this.w, this.calc);
			this.imap.put(KeyStroke.getKeyStroke("1"), num1);
			this.imap.put(KeyStroke.getKeyStroke("2"), num2);
			this.imap.put(KeyStroke.getKeyStroke("3"), num3);
			this.imap.put(KeyStroke.getKeyStroke("4"), num4);
			this.imap.put(KeyStroke.getKeyStroke("5"), num5);
			this.imap.put(KeyStroke.getKeyStroke("6"), num6);
			this.imap.put(KeyStroke.getKeyStroke("7"), num7);
			this.imap.put(KeyStroke.getKeyStroke("8"), num8);
			this.imap.put(KeyStroke.getKeyStroke("9"), num9);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD1"), num1);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD2"), num2);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD3"), num3);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD4"), num4);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD5"), num5);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD6"), num6);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD7"), num7);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD8"), num8);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD9"), num9);//
			this.amap.put(num1, num1);
			this.amap.put(num2, num2);
			this.amap.put(num3, num3);
			this.amap.put(num4, num4);
			this.amap.put(num5, num5);
			this.amap.put(num6, num6);
			this.amap.put(num7, num7);
			this.amap.put(num8, num8);
			this.amap.put(num9, num9);
		}
		public void actionPerformed( ActionEvent e ){
	//		System.out.println( (String)getValue( Action.NAME ) +" が 選択されました" );
			this.w.setVisible(false);
			Anzan azn = new Anzan((String)getValue( Action.NAME ));
			this.calc.setNum(azn.getNum());
			this.calc.setBool(true);
	//		System.out.println(calc.getNum());
	//		System.out.println(calc.getBool());
			this.w.setVisible(false);
		}
	}

/*	class RadioAction extends AbstractAction{
		private AnzanMain w;
		private int index;
		private InputMap imap;
		private ActionMap amap;
		private CalcTest_pre calc;
		public RadioAction( AnzanMain w, int index, InputMap imap, ActionMap amap, CalcTest_pre calc){
			this.w = w;
			this.index = index;
			this.imap = imap;
			this.amap = amap;
			this.calc = calc;
			if(index > 5){
				index -= 4;
			}
			String str = "  [" + this.index + "]   " + index + "ケタ";
			if(this.index <= 5){
				str += "(そろい)";
			} else {
				str += "(バラバラ)";
			}
			putValue( Action.NAME, str);
			Action num1 = new NumKey("  [1]   1ケタ(そろい)", this.w, this.calc);
			Action num2 = new NumKey("  [2]   2ケタ(そろい)", this.w, this.calc);
			Action num3 = new NumKey("  [3]   3ケタ(そろい)", this.w, this.calc);
			Action num4 = new NumKey("  [4]   4ケタ(そろい)", this.w, this.calc);
			Action num5 = new NumKey("  [5]   5ケタ(そろい)", this.w, this.calc);
			Action num6 = new NumKey("  [6]   2ケタ(バラバラ)", this.w, this.calc);
			Action num7 = new NumKey("  [7]   3ケタ(バラバラ)", this.w, this.calc);
			Action num8 = new NumKey("  [8]   4ケタ(バラバラ)", this.w, this.calc);
			Action num9 = new NumKey("  [9]   5ケタ(バラバラ)", this.w, this.calc);
			this.imap.put(KeyStroke.getKeyStroke("1"), num1);
			this.imap.put(KeyStroke.getKeyStroke("2"), num2);
			this.imap.put(KeyStroke.getKeyStroke("3"), num3);
			this.imap.put(KeyStroke.getKeyStroke("4"), num4);
			this.imap.put(KeyStroke.getKeyStroke("5"), num5);
			this.imap.put(KeyStroke.getKeyStroke("6"), num6);
			this.imap.put(KeyStroke.getKeyStroke("7"), num7);
			this.imap.put(KeyStroke.getKeyStroke("8"), num8);
			this.imap.put(KeyStroke.getKeyStroke("9"), num9);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD1"), num1);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD2"), num2);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD3"), num3);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD4"), num4);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD5"), num5);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD6"), num6);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD7"), num7);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD8"), num8);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD9"), num9);//
			this.amap.put(num1, num1);
			this.amap.put(num2, num2);
			this.amap.put(num3, num3);
			this.amap.put(num4, num4);
			this.amap.put(num5, num5);
			this.amap.put(num6, num6);
			this.amap.put(num7, num7);
			this.amap.put(num8, num8);
			this.amap.put(num9, num9);
		}
		public void actionPerformed( ActionEvent e ){
	//		System.out.println( (String)getValue( Action.NAME ) +" が 選択されました" );
			this.w.setVisible(false);
			Anzan azn = new Anzan((String)getValue( Action.NAME ));
			this.calc.setNum(azn.getNum());
			this.calc.setBool(true);
	//		System.out.println(calc.getNum());
	//		System.out.println(calc.getBool());
			this.w.setVisible(false);
		}
	}
*/	class NumKey extends AbstractAction{
		private String num;
		private AnzanMain w;
		private CalcTest_pre calc;
		public NumKey(String num, AnzanMain w, CalcTest_pre calc){
			this.num = num;
			this.w = w;
			this.calc = calc;
			putValue(Action.NAME, num);
		}
		public void actionPerformed(ActionEvent e){
	//		System.out.println( (String)getValue( Action.NAME ) +" が 選択されました" );
			Anzan azn = new Anzan((String)getValue( Action.NAME ));
			this.calc.setNum(azn.getNum());
			this.calc.setBool(true);
	//		System.out.println(calc.getNum());
	//		System.out.println(calc.getBool());
			this.w.setVisible(false);
		}
	}
}
