import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountMain2 extends JFrame implements Runnable{
	private CalcTest_pre calc;
	String[] aa = 
	{"","  [1]   3  口","  [2]   4  口","  [3]   5  口","  [4]   6  口","  [5]   7  口","  [6]   8  口","  [7]   9  口","  [8]   10  口","  [9] もっとおおく"};
	String[] bb = 
	{"","  [1]   11  口","  [2]   12  口","  [3]   13  口","  [4]   14  口","  [5]   15  口","  [6]   16  口","  [7]   18  口","  [8]   20  口","  [9] もっとおおく"};
	String[] cc = 
	{"","  [1]   25  口","  [2]   30  口","  [3]   40  口","  [4]   50  口","  [5]   60  口","  [6]   70  口","  [7]   80  口","  [8]   90  口","  [9]   100  口"};

	public void run(){
		CountMain2 w = new CountMain2( "選択画面2" , this.calc);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		w.setSize( 1120, 630 );
		w.setVisible( true );
		w.setResizable(false);
		w.setLocationRelativeTo(null);
	}
	public CountMain2( String title, CalcTest_pre calc ){
		super( title );
		ImageIcon icon = new ImageIcon("flush_pic.jpg");
		setIconImage(icon.getImage());
		this.calc = calc;
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
		ButtonGroup buttonGroup = new ButtonGroup();
		InputMap imap = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap amap = pane.getActionMap();
		
		for(int i = 1; i <= 9; i++){
			JButton button = new JButton(bb[i]);
			button.setFont(new Font("Dialog", Font.PLAIN, 35));
			setLayout(new GridLayout(3,3,5,5));
			button.setMaximumSize(new Dimension(373, 210));
			button.addActionListener(new ClickAction(this, i, imap, amap, calc));
			add(button);
		}

	}
	
	class ClickAction extends AbstractAction implements ActionListener {
		private CountMain2 w;
		private int num;
		private String str;
		private InputMap imap;
		private ActionMap amap;
		private CalcTest_pre calc;
		public ClickAction( CountMain2 w, int index, InputMap imap, ActionMap amap, CalcTest_pre calc){
			this.w = w;
			this.imap = imap;
			this.amap = amap;
			this.calc = calc;
			String str = "";
			if(index == 1){
				this.str = "1";
				this.num = 11;
			} else if(index == 2){
				this.str = "2";
				this.num = 12;
			} else if(index == 3){
				this.str = "3";
				this.num = 13;
			} else if(index == 4){
				this.str = "4";
				this.num = 14;
			} else if(index == 5){
				this.str = "5";
				this.num = 15;
			} else if(index == 6){
				this.str = "6";
				this.num = 16;
			} else if(index == 7){
				this.str = "7";
				this.num = 18;
			} else if(index == 8){
				this.str = "8";
				this.num = 20;
			}

			if(index == 9) str = "  [9] もっとおおく";
			else str = "  [" + this.str + "]   " + this.num + "  口";
			putValue( Action.NAME, str);
			Action num1_1 = new NumKey("  [1]   11  口", this.w, this.calc);
			Action num2_1 = new NumKey("  [2]   12  口", this.w, this.calc);
			Action num3_1 = new NumKey("  [3]   13  口", this.w, this.calc);
			Action num4_1 = new NumKey("  [4]   14  口", this.w, this.calc);
			Action num5_1 = new NumKey("  [5]   15  口", this.w, this.calc);
			Action num6_1 = new NumKey("  [6]   16  口", this.w, this.calc);
			Action num7_1 = new NumKey("  [7]   18  口", this.w, this.calc);
			Action num8_1 = new NumKey("  [8]   20  口", this.w, this.calc);
			Action num9_1 = new NumKey("  [9] もっとおおく", this.w, this.calc);
			this.imap.put(KeyStroke.getKeyStroke("1"), num1_1);
			this.imap.put(KeyStroke.getKeyStroke("2"), num2_1);
			this.imap.put(KeyStroke.getKeyStroke("3"), num3_1);
			this.imap.put(KeyStroke.getKeyStroke("4"), num4_1);
			this.imap.put(KeyStroke.getKeyStroke("5"), num5_1);
			this.imap.put(KeyStroke.getKeyStroke("6"), num6_1);
			this.imap.put(KeyStroke.getKeyStroke("7"), num7_1);
			this.imap.put(KeyStroke.getKeyStroke("8"), num8_1);
			this.imap.put(KeyStroke.getKeyStroke("9"), num9_1);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD1"), num1_1);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD2"), num2_1);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD3"), num3_1);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD4"), num4_1);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD5"), num5_1);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD6"), num6_1);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD7"), num7_1);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD8"), num8_1);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD9"), num9_1);//
			this.amap.put(num1_1, num1_1);
			this.amap.put(num2_1, num2_1);
			this.amap.put(num3_1, num3_1);
			this.amap.put(num4_1, num4_1);
			this.amap.put(num5_1, num5_1);
			this.amap.put(num6_1, num6_1);
			this.amap.put(num7_1, num7_1);
			this.amap.put(num8_1, num8_1);
			this.amap.put(num9_1, num9_1);
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
		private CountMain2 w;
		private CalcTest_pre calc;
		public NumKey(String num, CountMain2 w, CalcTest_pre calc){
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
