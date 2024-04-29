import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountMain3 extends JFrame implements Runnable{
	private CalcTest_pre calc;
	String[] aa = 
	{"","  [1]   3  ��","  [2]   4  ��","  [3]   5  ��","  [4]   6  ��","  [5]   7  ��","  [6]   8  ��","  [7]   9  ��","  [8]   10  ��","  [9] �����Ƃ�����"};
	String[] bb = 
	{"","  [1]   11  ��","  [2]   12  ��","  [3]   13  ��","  [4]   14  ��","  [5]   15  ��","  [6]   16  ��","  [7]   18  ��","  [8]   20  ��","  [9] �����Ƃ�����"};
	String[] cc = 
	{"","  [1]   25  ��","  [2]   30  ��","  [3]   40  ��","  [4]   50  ��","  [5]   60  ��","  [6]   70  ��","  [7]   80  ��","  [8]   90  ��","  [9]   100  ��"};

	public void run(){
		CountMain3 w = new CountMain3( "�I�����2" , this.calc);
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		w.setSize( 1120, 630 );
		w.setVisible( true );
		w.setResizable(false);
		w.setLocationRelativeTo(null);
	}
	public CountMain3( String title, CalcTest_pre calc ){
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
			JButton button = new JButton(cc[i]);
			button.setFont(new Font("Dialog", Font.PLAIN, 35));
			setLayout(new GridLayout(3,3,5,5));
			button.setMaximumSize(new Dimension(373, 210));
			button.addActionListener(new ClickAction(this, i, imap, amap, calc));
			add(button);
		}

	}
	
//	class RadioAction extends AbstractAction{
	class ClickAction extends AbstractAction implements ActionListener {
		private CountMain3 w;
		private int num;
		private String str;
		private InputMap imap;
		private ActionMap amap;
		private CalcTest_pre calc;
		public ClickAction( CountMain3 w, int index, InputMap imap, ActionMap amap, CalcTest_pre calc){
			this.w = w;
			this.imap = imap;
			this.amap = amap;
			this.calc = calc;
			String str = "";
			if(index == 1){
				this.str = "1";
				this.num = 25;
			} else if(index == 2){
				this.str = "2";
				this.num = 30;
			} else if(index == 3){
				this.str = "3";
				this.num = 40;
			} else if(index == 4){
				this.str = "4";
				this.num = 50;
			} else if(index == 5){
				this.str = "5";
				this.num = 60;
			} else if(index == 6){
				this.str = "6";
				this.num = 70;
			} else if(index == 7){
				this.str = "7";
				this.num = 80;
			} else if(index == 8){
				this.str = "8";
				this.num = 90;
			} else if(index == 9){
				this.str = "9";
				this.num = 100;
			}

			str = "  [" + this.str + "]   " + this.num + "  ��";
			putValue( Action.NAME, str);

			Action num1_2 = new NumKey("  [1]   25  ��", this.w, this.calc);
			Action num2_2 = new NumKey("  [2]   30  ��", this.w, this.calc);
			Action num3_2 = new NumKey("  [3]   40  ��", this.w, this.calc);
			Action num4_2 = new NumKey("  [4]   50  ��", this.w, this.calc);
			Action num5_2 = new NumKey("  [5]   60  ��", this.w, this.calc);
			Action num6_2 = new NumKey("  [6]   70  ��", this.w, this.calc);
			Action num7_2 = new NumKey("  [7]   80  ��", this.w, this.calc);
			Action num8_2 = new NumKey("  [8]   90  ��", this.w, this.calc);
			Action num9_2 = new NumKey("  [9]   100  ��", this.w, this.calc);
			this.imap.put(KeyStroke.getKeyStroke("1"), num1_2);
			this.imap.put(KeyStroke.getKeyStroke("2"), num2_2);
			this.imap.put(KeyStroke.getKeyStroke("3"), num3_2);
			this.imap.put(KeyStroke.getKeyStroke("4"), num4_2);
			this.imap.put(KeyStroke.getKeyStroke("5"), num5_2);
			this.imap.put(KeyStroke.getKeyStroke("6"), num6_2);
			this.imap.put(KeyStroke.getKeyStroke("7"), num7_2);
			this.imap.put(KeyStroke.getKeyStroke("8"), num8_2);
			this.imap.put(KeyStroke.getKeyStroke("9"), num9_2);
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD1"), num1_2);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD2"), num2_2);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD3"), num3_2);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD4"), num4_2);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD5"), num5_2);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD6"), num6_2);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD7"), num7_2);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD8"), num8_2);//
			this.imap.put(KeyStroke.getKeyStroke("NUMPAD9"), num9_2);//
			this.amap.put(num1_2, num1_2);
			this.amap.put(num2_2, num2_2);
			this.amap.put(num3_2, num3_2);
			this.amap.put(num4_2, num4_2);
			this.amap.put(num5_2, num5_2);
			this.amap.put(num6_2, num6_2);
			this.amap.put(num7_2, num7_2);
			this.amap.put(num8_2, num8_2);
			this.amap.put(num9_2, num9_2);
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
		private CountMain3 w;
		private CalcTest_pre calc;
		public NumKey(String num, CountMain3 w, CalcTest_pre calc){
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
