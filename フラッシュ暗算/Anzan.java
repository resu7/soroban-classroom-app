public class Anzan{
	private int num;
	public Anzan(String str){
		if(str.equals("  [1]   1ケタ(そろい)")){
			this.num = 1;
		} else if(str.equals("  [2]   2ケタ(そろい)")){
			this.num = 2;
		} else if(str.equals("  [3]   3ケタ(そろい)")){
			this.num = 3;
		} else if(str.equals("  [4]   4ケタ(そろい)")){
			this.num = 4;
		} else if(str.equals("  [5]   5ケタ(そろい)")){
			this.num = 5;
		} else if(str.equals("  [6]   2ケタ(バラバラ)")){
			this.num = 6;
		} else if(str.equals("  [7]   3ケタ(バラバラ)")){
			this.num = 7;
		} else if(str.equals("  [8]   4ケタ(バラバラ)")){
			this.num = 8;
		} else if(str.equals("  [9]   5ケタ(バラバラ)")){
			this.num = 9;
		} else if(str.equals("  [1]   0.1  秒")){
			this.num = 100;
		} else if(str.equals("  [2]   0.2  秒")){
			this.num = 200;
		} else if(str.equals("  [3]   0.3  秒")){
			this.num = 300;
		} else if(str.equals("  [4]   0.4  秒")){
			this.num = 400;
		} else if(str.equals("  [5]   0.5  秒")){
			this.num = 500;
		} else if(str.equals("  [6]   0.6  秒")){
			this.num = 600;
		} else if(str.equals("  [7]   0.7  秒")){
			this.num = 700;
		} else if(str.equals("  [8]   0.8  秒")){
			this.num = 800;
		} else if(str.equals("  [9]   0.9  秒")){
			this.num = 900;
		} else if(str.equals("  [1]   1.0  秒")){
			this.num = 1000;
		} else if(str.equals("  [2]   1.1  秒")){
			this.num = 1100;
		} else if(str.equals("  [3]   1.2  秒")){
			this.num = 1200;
		} else if(str.equals("  [4]   1.3  秒")){
			this.num = 1300;
		} else if(str.equals("  [5]   1.4  秒")){
			this.num = 1400;
		} else if(str.equals("  [6]   1.5  秒")){
			this.num = 1500;
		} else if(str.equals("  [7]   1.6  秒")){
			this.num = 1600;
		} else if(str.equals("  [1]   1.7  秒")){
			this.num = 1700;
		} else if(str.equals("  [2]   1.8  秒")){
			this.num = 1800;
		} else if(str.equals("  [3]   1.9  秒")){
			this.num = 1900;
		} else if(str.equals("  [4]   2.0  秒")){
			this.num = 2000;
		} else if(str.equals("  [5]   3.0  秒")){
			this.num = 3000;
		} else if(str.equals("  [6]   4.0  秒")){
			this.num = 4000;
		} else if(str.equals("  [7]   5.0  秒")){
			this.num = 5000;
		} else if(str.equals("  [8]   6.0  秒")){
			this.num = 6000;
		} else if(str.equals("  [9]   7.0  秒")){
			this.num = 7000;
		} else if(str.equals("  [1]   3  口")){
			this.num = 3;
		} else if(str.equals("  [2]   4  口")){
			this.num = 4;
		} else if(str.equals("  [3]   5  口")){
			this.num = 5;
		} else if(str.equals("  [4]   6  口")){
			this.num = 6;
		} else if(str.equals("  [5]   7  口")){
			this.num = 7;
		} else if(str.equals("  [6]   8  口")){
			this.num = 8;
		} else if(str.equals("  [7]   9  口")){
			this.num = 9;
		} else if(str.equals("  [8]   10  口")){
			this.num = 10;
		} else if(str.equals("  [9] もっとおおく")||str.equals("  [8] もっとゆっくり")){
			this.num = -1;
		} else if(str.equals("  [9] もっとはやく")){
			this.num = -2;
		} else if(str.equals("  [1]   11  口")){
			this.num = 11;
		} else if(str.equals("  [2]   12  口")){
			this.num = 12;
		} else if(str.equals("  [3]   13  口")){
			this.num = 13;
		} else if(str.equals("  [4]   14  口")){
			this.num = 14;
		} else if(str.equals("  [5]   15  口")){
			this.num = 15;
		} else if(str.equals("  [6]   16  口")){
			this.num = 16;
		} else if(str.equals("  [7]   18  口")){
			this.num = 18;
		} else if(str.equals("  [8]   20  口")){
			this.num = 20;
		} else if(str.equals("  [1]   25  口")){
			this.num = 25;
		} else if(str.equals("  [2]   30  口")){
			this.num = 30;
		} else if(str.equals("  [3]   40  口")){
			this.num = 40;
		} else if(str.equals("  [4]   50  口")){
			this.num = 50;
		} else if(str.equals("  [5]   60  口")){
			this.num = 60;
		} else if(str.equals("  [6]   70  口")){
			this.num = 70;
		} else if(str.equals("  [7]   80  口")){
			this.num = 80;
		} else if(str.equals("  [8]   90  口")){
			this.num = 90;
		} else if(str.equals("  [9]   100  口")){
			this.num = 100;
		} else if(str.equals("  [1]   1 もん")){
			this.num = 1;
		} else if(str.equals("  [2]   5 もん")){
			this.num = 5;
		} else if(str.equals("  [3]  10 もん")){
			this.num = 10;
		}
	}
	public int getNum(){
		return this.num;
	}
}