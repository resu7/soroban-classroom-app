import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DelayMain extends JFrame implements Runnable{
	private CalcTest_pre calc;
	String aa[] = {"","  [1]   1.0  •b","  [2]   1.1  •b","  [3]   1.2  •b","  [4]   1.3  •b","  [5]   1.4  •b","  [6]   1.5  •b","  [7]   1.6  •b","  [8] ‚à‚Á‚Æ‚ä‚Á‚­‚è","  [9] ‚à‚Á‚Æ‚Í‚â‚­"};
	String bb[] = {"","  [1]   1.7  •b","  [2]   1.8  •b","  [3]   1.9  •b","  [4]   2.0  •b","  [5]   3.0  •b","  [6]   4.0  •b","  [7]   5.0  •b","  [8]   6.0  •b","  [9]   7.0  •b"};
	String cc[] = {"","  [1]   0.1  •b","  [2]   0.2  •b","  [3]   0.3  •b","  [4]   0.4  •b","  [5]   0.5  •b","  [6]   0.6  •b","  [7]   0.7  •b","  [8]   0.8  •b","  [9]   0.9  •b"};
	public void run(){
		DelayMain w = new DelayMain( "‘I‘ð‰æ–Ê3" , this.calc);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		w.setSize( 1120, 630 );
		w.setVisible( true );
		w.setResizable(false);
		w.setLocationRelativeTo(null);
	}
	public DelayMain( String title, CalcTest_pre calc ){
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
	class ClickAction extends AbstractAction implements ActionListener {
		private DelayMain w;
		private double num;
		private String str;
		private InputMap imap;
		private ActionMap amap;
		private CalcTest_pre calc;
		public ClickAction( DelayMain w, int index, InputMap imap, ActionMap amap, CalcTest_pre calc){
			this.w = w;
			this.imap = imap;
			this.amap = amap;
			this.calc = calc;
/*			if(index == 1){
				this.str = "1";
				this.num = 0.1;
			} else if(index == 2){
				this.str = "2";
				this.num = 0.2;
			} else if(index == 3){
				this.str = "3";
				this.num = 0.3;
			} else if(index == 4){
				this.str = "4";
				this.num = 0.4;
			} else if(index == 5){
				this.str = "5";
				this.num = 0.5;
			} else if(index == 6){
				this.str = "6";
				this.num = 0.6;
			} else if(index == 7){
				this.str = "7";
				this.num = 0.7;
			} else if(index == 8){
				this.str = "8";
				this.num = 0.8;
			} else if(index == 9){
				this.str = "9";
				this.num = 0.9;
*/			if(index == 1){
				this.str = "1";
				this.num = 1.0;
			} else if(index == 2){
				this.str = "2";
				this.num = 1.1;
			} else if(index == 3){
				this.str = "3";
				this.num = 1.2;
			} else if(index == 4){
				this.str = "4";
				this.num = 1.3;
			} else if(index == 5){
				this.str = "5";
				this.num = 1.4;
			} else if(index == 6){
				this.str = "6";
				this.num = 1.5;
			} else if(index == 7){
				this.str = "7";
				this.num = 1.6;
/*			} else if(index == 1){
				this.str = "1";
				this.num = 1.7;
			} else if(index == 2){
				this.str = "2";
				this.num = 1.8;
			} else if(index == 3){
				this.str = "3";
				this.num = 1.9;
			} else if(index == 4){
				this.str = "4";
				this.num = 2.0;
			} else if(index == 5){
				this.str = "5";
				this.num = 3.0;
			} else if(index == 6){
				this.str = "6";
				this.num = 4.0;
			} else if(index == 7){
				this.str = "7";
				this.num = 5.0;
			} else if(index == 8){
				this.str = "8";
				this.num = 6.0;
			} else if(index == 9){
				this.str = "9";
				this.num = 7.0;
*/			}
			String str = "";
			if(index == 9) str = "  [9] ‚à‚Á‚Æ‚Í‚â‚­";
			else if(index == 8) str = "  [8] ‚à‚Á‚Æ‚ä‚Á‚­‚è";
			else str = "  [" + this.str + "]   " + this.num + "  •b";
			putValue( Action.NAME, str);
/*			Action num1 = new NumKey("  [1]   0.1  •b", this.w, this.calc);
			Action num2 = new NumKey("  [2]   0.2  •b", this.w, this.calc);
			Action num3 = new NumKey("  [3]   0.3  •b", this.w, this.calc);
			Action num4 = new NumKey("  [4]   0.4  •b", this.w, this.calc);
			Action num5 = new NumKey("  [5]   0.5  •b", this.w, this.calc);
			Action num6 = new NumKey("  [6]   0.6  •b", this.w, this.calc);
			Action num7 = new NumKey("  [7]   0.7  •b", this.w, this.calc);
			Action num8 = new NumKey("  [8]   0.8  •b", this.w, this.calc);
			Action num9 = new NumKey("  [9]   0.9  •b", this.w, this.calc);
*/			Action num1 = new NumKey("  [1]   1.0  •b", this.w, this.calc);
			Action num2 = new NumKey("  [2]   1.1  •b", this.w, this.calc);
			Action num3 = new NumKey("  [3]   1.2  •b", this.w, this.calc);
			Action num4 = new NumKey("  [4]   1.3  •b", this.w, this.calc);
			Action num5 = new NumKey("  [5]   1.4  •b", this.w, this.calc);
			Action num6 = new NumKey("  [6]   1.5  •b", this.w, this.calc);
			Action num7 = new NumKey("  [7]   1.6  •b", this.w, this.calc);
			Action num8 = new NumKey("  [8] ‚à‚Á‚Æ‚ä‚Á‚­‚è", this.w, this.calc);
			Action num9 = new NumKey("  [9] ‚à‚Á‚Æ‚Í‚â‚­", this.w, this.calc);
/*			Action num1 = new NumKey("  [1]   1.7  •b", this.w, this.calc);
			Action num2 = new NumKey("  [2]   1.8  •b", this.w, this.calc);
			Action num3 = new NumKey("  [3]   1.9  •b", this.w, this.calc);
			Action num4 = new NumKey("  [4]   2.0  •b", this.w, this.calc);
			Action num5 = new NumKey("  [5]   3.0  •b", this.w, this.calc);
			Action num6 = new NumKey("  [6]   4.0  •b", this.w, this.calc);
			Action num7 = new NumKey("  [7]   5.0  •b", this.w, this.calc);
			Action num8 = new NumKey("  [8]   6.0  •b", this.w, this.calc);
			Action num9 = new NumKey("  [9]   7.0  •b", this.w, this.calc);
*/			this.imap.put(KeyStroke.getKeyStroke("1"), num1);
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
			this.w.setVisible(false);
			Anzan azn = new Anzan((String)getValue( Action.NAME ));
			this.calc.setNum(azn.getNum());
			this.calc.setBool(true);
			this.w.setVisible(false);
		}
	}
	class NumKey extends AbstractAction{
		private String num;
		private DelayMain w;
		private CalcTest_pre calc;
		public NumKey(String num, DelayMain w, CalcTest_pre calc){
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
