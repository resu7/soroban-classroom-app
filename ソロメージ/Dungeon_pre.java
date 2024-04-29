import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.awt.image.*;

class Dungeon_pre extends JFrame{
	int count = 0;JPanel pane;
	public Dungeon_pre(String title, String str){
		super(title);
		ImageIcon icon = new ImageIcon("soroban_pic.jpg");
		setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1120, 630);
		this.setResizable(false);
/*		JPanel pane = new JPanel();//JPanel pane = (JPanel)getContentPane();
		pane.add(this.getJLabel("b"));
		this.add(pane);
		this.setVisible(true);
*//*		try{
			new Thread().sleep(20000);
		}catch(InterruptedException e){
			System.out.println("asd2");
		}
*/
		this.pane = new JPanel();//JPanel pane = (JPanel)getContentPane();
		this.pane.add(this.getJLabel(str));
		this.add(this.pane);
		this.setVisible(true);
		try{
			new Thread().sleep(10000);
		}catch(InterruptedException e){
			System.out.println("asd2");
		}
		this.pane.remove(0);
		this.add(this.pane);
		repaint();
/*		pane.remove(0);
		this.add(pane);
		repaint();
*/	}
	public static void main(String[] args){
		Dungeon_pre dp = new Dungeon_pre("Anime Gif", "b");
/*		Dungeon_pre dp2 = new Dungeon_pre("Anime Gif", "a");
		try{
			new Thread().sleep(3200);
		}catch(InterruptedException e){
			System.out.println("asd2");
		}
		dp2.setVisible(false);
	}
	public void paint(Graphics g){
		super.paint(g);
		if(this.count == 1){
		this.add(new JLabel(new ImageIcon("enemy0.jpg")));
//			this.pane.remove(0);
//			this.pane.add(this.getJLabel("a"));
//			this.add(this.pane);
		}
*/	}

//GIFアニメ表示
	public JLabel getJLabel(String str) {
		Image im=null;
		URL url=this.getClass().getResource("enemy0" + str + ".gif");
		try {
			im=this.createImage((ImageProducer)url.getContent());
		}catch(Exception ex){
			System.out.println("Resource Error!");
		}
		ImageIcon ii = new ImageIcon(im);
		JLabel jLabel = new JLabel(ii);
		//GIFアニメを表示
		jLabel.setVisible(true);
		System.out.println("高さ" + ii.getIconHeight());
		System.out.println("幅" + ii.getIconWidth());
		this.count++;
		return jLabel;
	}
}