import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;import java.util.Timer;import java.util.TimerTask;
import javax.swing.border.*;

public class MoneyGame extends JFrame{
	int answer = 0;int chn = 0;int clean = 0;int count;
	public MoneyGame(int count, int chn, int clean){
		ImageIcon icon = new ImageIcon("number_pic.jpg");
		setIconImage(icon.getImage());
		this.count=count;this.chn=chn;this.clean=clean;
		JPanel panel = (JPanel)getContentPane();
		JPanel p1 = new JPanel();JPanel p2 = new JPanel();
		panel.setLayout(null);panel.setBackground(Color.BLACK);

		int[] elements = {1,5,10,50,100,500,1000,5000,10000};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int j = 0; j < this.chn*3; j++){
			for(int i = 0; i < new Random().nextInt(5); i++){
				list.add(elements[j]);
			}
		}
		while(list.size()<36){list.add(0);}
		if(list.get(0)==0){list.remove(0);list.add(elements[new Random().nextInt(9)]);}
		if(this.clean==2){Collections.shuffle(list);}

		for(int a : list){
			p1.add(new JLabel(new ImageIcon("money_"+a+"c.jpg")));
			this.answer+=a;
		}

		p1.setBackground(Color.WHITE);
		p1.setBounds(0,0,1120,440);
		panel.add(p1);
		
		p2.setLayout(new GridLayout(1,3));
		for(int i = 0;i < 3; i++){
			JTextField field = new JTextField();
			field.setEditable(false);
			if(i==1){

				InputMap imap = p2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
				ActionMap amap = p2.getActionMap();
				FuncKey f = new FuncKey("ENTER",  p2, this, field);
				KeyStroke k = KeyStroke.getKeyStroke("ENTER");
				imap.put(k, f);amap.put(f, f);
				field.setEditable(true);
				field.setBackground(Color.yellow.brighter());
				new CountMain2(field);
			} else {
				field.setBackground(Color.WHITE);
				field.setBorder(new LineBorder(Color.WHITE, 8, false));
			}
			field.setCaretColor(Color.BLACK);
			field.setPreferredSize(new Dimension(373,150));
			field.setFont(new Font("Dialog", Font.BOLD, 120));
			field.setHorizontalAlignment(JTextField.CENTER);

			if(i==0){
				field.setFont(new Font("Dialog", Font.PLAIN, 90));
				field.setText("Ç∫ÇÒÇ‘Ç≈");
			} else if(i==2){
				field.setFont(new Font("Dialog", Font.PLAIN, 90));
				field.setText("â~(Ç¶ÇÒ)");
			}
			p2.add(field);
		}
		p2.setBounds(0,443,1120,150);panel.add(p2);
		
		panel.setBackground(Color.BLACK);
	}

	class FuncKey extends AbstractAction{
		JPanel pane;int num;MoneyGame mg;JTextField field;int jj = 0;
		FuncKey(String label, JPanel pane, MoneyGame mg, JTextField field){
			this.pane = pane;this.field = field;
			putValue(Action.NAME, label);this.mg = mg;
		}
		public void actionPerformed(ActionEvent e){
			String label = (String)getValue(Action.NAME);
			if(label.equals("ENTER")){
				if((field.getText()).equals(""+answer)&&jj==0){
					this.field.setBackground(Color.cyan.brighter());
					this.field.setCaretColor(Color.cyan.brighter());
					try{new Thread().sleep(250);}catch(InterruptedException e2){}field.setText("OK!");field.setEditable(false);//"OK!"
				} else if(((field.getText()).equals("OK!")||(field.getText()).equals(""+answer))&&jj>0){
					count--;if(count==0){
//						System.out.println("finish");System.exit(0);
						this.mg.setVisible(false);new CountMain2(1);return;
					}
					this.mg.setVisible(false);
					MoneyGame frame = new MoneyGame(count, chn, clean);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setSize(1120,630);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Ç©Ç∏Ç†ÇªÇ—");
					frame.setVisible(true);
					frame.setResizable(false);

				} else {
					this.field.setBackground(Color.PINK);
					this.field.setCaretColor(Color.PINK);
					try{new Thread().sleep(250);}catch(InterruptedException e2){}
					if(this.jj==0){field.setText("(ÅL-É÷-`)");}else{field.setText(""+answer);}field.setEditable(false);
				}this.jj++;
			}
		}
	}

	class CountMain2 extends TimerTask{
		private Timer timer = new Timer();
		private JTextField field;int i = 0;
		public CountMain2(int i){
			super();this.i=i;
			this.timer.scheduleAtFixedRate(this, 1000, 1000);
		}
		public void run(){
			if(this.i==0){field.requestFocus();}
			else{new NumGame(0);}
			timer.cancel();
		}
		public CountMain2(JTextField field){
			super();this.field = field;
			this.timer.scheduleAtFixedRate(this, 1000, 1000);
		}
	}
}