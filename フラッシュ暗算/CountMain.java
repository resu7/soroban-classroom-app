import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountMain extends JFrame implements Runnable{
	private CalcTest_pre calc;
	String[] aa = 
	{"","  [1]   3  口","  [2]   4  口","  [3]   5  口","  [4]   6  口","  [5]   7  口","  [6]   8  口","  [7]   9  口","  [8]   10  口","  [9] もっとおおく"};
	String[] bb = 
	{"","  [1]   11  口","  [2]   12  口","  [3]   13  口","  [4]   14  口","  [5]   15  口","  [6]   16  口","  [7]   18  口","  [8]   20  口","  [9] もっとおおく"};
	String[] cc = 
	{"","  [1]   25  口","  [2]   30  口","  [3]   40  口","  [4]   50  口","  [5]   60  口","  [6]   70  口","  [7]   80  口","  [8]   90  口","  [9]   100  口"};

	public void run(){
		CountMain w = new CountMain( "選択画面2" , this.calc);
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
			if(index == 9) str = "  [9] もっとおおく";
			else str = "  [" + this.str + "]   " + this.num + "  口";
			putValue( Action.NAME, str);

			Action num1 = new NumKey("  [1]   3  口", this.w, this.calc);
			Action num2 = new NumKey("  [2]   4  口", this.w, this.calc);
			Action num3 = new NumKey("  [3]   5  口", this.w, this.calc);
			Action num4 = new NumKey("  [4]   6  口", this.w, this.calc);
			Action num5 = new NumKey("  [5]   7  口", this.w, this.calc);
			Action num6 = new NumKey("  [6]   8  口", this.w, this.calc);
			Action num7 = new NumKey("  [7]   9  口", this.w, this.calc);
			Action num8 = new NumKey("  [8]   10  口", this.w, this.calc);
			Action num9 = new NumKey("  [9] もっとおおく", this.w, this.calc);
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
