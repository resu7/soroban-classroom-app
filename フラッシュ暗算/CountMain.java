import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountMain extends JFrame implements Runnable{
	private CalcTest_pre calc;
	String[] aa = 
	{"","  [1]   3  Œû","  [2]   4  Œû","  [3]   5  Œû","  [4]   6  Œû","  [5]   7  Œû","  [6]   8  Œû","  [7]   9  Œû","  [8]   10  Œû","  [9] ‚à‚Á‚Æ‚¨‚¨‚­"};
	String[] bb = 
	{"","  [1]   11  Œû","  [2]   12  Œû","  [3]   13  Œû","  [4]   14  Œû","  [5]   15  Œû","  [6]   16  Œû","  [7]   18  Œû","  [8]   20  Œû","  [9] ‚à‚Á‚Æ‚¨‚¨‚­"};
	String[] cc = 
	{"","  [1]   25  Œû","  [2]   30  Œû","  [3]   40  Œû","  [4]   50  Œû","  [5]   60  Œû","  [6]   70  Œû","  [7]   80  Œû","  [8]   90  Œû","  [9]   100  Œû"};

	public void run(){
		CountMain w = new CountMain( "‘I‘ð‰æ–Ê2" , this.calc);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		w.setSize( 1120, 630);
		w.setVisible( true );
		w.setResizable(false);
		w.setLocationRelativeTo(null);
	}
	public CountMain( String title, CalcTest_pre calc ){
		super( title );
		ImageIcon icon = new ImageIcon("flush_pic.jpg");
		setIconImage(icon.getImage());
		this.calc = calc;
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
		ButtonGroup buttonGroup = new ButtonGroup();
		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		
/*		for(int i = 1; i <= 26; i++){
			RadioAction ra = new RadioAction(this, i, imap, amap, calc);
			JRadioButton bt = new JRadioButton(ra);
			pane.add( bt );
			buttonGroup.add( bt );
		}
*/
		for(int i = 1; i <= 9; i++){
			JButton button = new JButton(aa[i]);
			button.setFont(new Font("Dialog", Font.PLAIN, 35));
			setLayout(new GridLayout(3,3,5,5));
			button.setMaximumSize(new Dimension(373, 210));
			button.addActionListener(new ClickAction(this, i, imap, amap, calc));
			add(button);
		}

	}
	
//	class RadioAction extends AbstractAction{
	class ClickAction extends AbstractAction implements ActionListener {
		private CountMain w;
		private int num;
		private String str;
		private InputMap imap;
		private ActionMap amap;
		private CalcTest_pre calc;
		public ClickAction( CountMain w, int index, InputMap imap, ActionMap amap, CalcTest_pre calc){
			this.w = w;
			this.imap = imap;
			this.amap = amap;
			this.calc = calc;
			String str = "";
			if(index == 1){
				this.str = "1";
				this.num = 3;
			} else if(index == 2){
				this.str = "2";
				this.num = 4;
			} else if(index == 3){
				this.str = "3";
				this.num = 5;
			} else if(index == 4){
				this.str = "4";
				this.num = 6;
			} else if(index == 5){
				this.str = "5";
				this.num = 7;
			} else if(index == 6){
				this.str = "6";
				this.num = 8;
			} else if(index == 7){
				this.str = "7";
				this.num = 9;
			} else if(index == 8){
				this.str = "8";
				this.num = 10;
			}
			if(index == 9) str = "  [9] ‚à‚Á‚Æ‚¨‚¨‚­";
			else str = "  [" + this.str + "]   " + this.num + "  Œû";
			putValue( Action.NAME, str);

			Action num1 = new NumKey("  [1]   3  Œû", this.w, this.calc);
			Action num2 = new NumKey("  [2]   4  Œû", this.w, this.calc);
			Action num3 = new NumKey("  [3]   5  Œû", this.w, this.calc);
			Action num4 = new NumKey("  [4]   6  Œû", this.w, this.calc);
			Action num5 = new NumKey("  [5]   7  Œû", this.w, this.calc);
			Action num6 = new NumKey("  [6]   8  Œû", this.w, this.calc);
			Action num7 = new NumKey("  [7]   9  Œû", this.w, this.calc);
			Action num8 = new NumKey("  [8]   10  Œû", this.w, this.calc);
			Action num9 = new NumKey("  [9] ‚à‚Á‚Æ‚¨‚¨‚­", this.w, this.calc);
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
			Anzan azn = new Anzan((String)getValue( Action.NAME ));
			this.calc.setNum(azn.getNum());
			this.calc.setBool(true);
			this.w.setVisible(false);
		}
	}
	class NumKey extends AbstractAction{
		private String num;
		private CountMain w;
		private CalcTest_pre calc;
		public NumKey(String num, CountMain w, CalcTest_pre calc){
			this.num = num;
			this.w = w;
			this.calc = calc;
			putValue(Action.NAME, num);
		}
		public void actionPerformed(ActionEvent e){
			Anzan azn = new Anzan((String)getValue( Action.NAME ));
			this.calc.setNum(azn.getNum());
			this.calc.setBool(true);
			this.w.setVisible(false);
		}
	}
}
