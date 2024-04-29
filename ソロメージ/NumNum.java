public class NumNum{
	private int num;private String[] aa = {
		"  [1]   珠を読む(たまをよむ)", "  [2]   足し算(たしざん)", "  [3]   引き算(ひきざん)", "  [1]   入門(にゅうもん)", "  [2]   初級(しょきゅう)", "  [3]   中級(ちゅうきゅう)", "  [4]   上級(じょうきゅう)",
		"  [1]   1ケタ", "  [2]   2ケタ", "  [3]   3ケタ", "  [4]   4ケタ", "  [5]   5ケタ", "  [6]   6ケタ", "  [7]   7ケタ", "  [8]   8ケタ", "  [9]   9ケタ",
		"  [9]   ノーリミット", "  [1]   1秒(びょう)", "  [2]   2秒(びょう)", "  [3]   3秒(びょう)", "  [4]   4秒(びょう)", "  [5]   5秒(びょう)", "  [6]   6秒(びょう)", "  [7]   7秒(びょう)", "  [8]   8秒(びょう)", "",
		"  [1]   両方珠(りょうほうたま)", "  [2]   左だけ珠(ひだりだけたま)", "  [3]   右だけ珠(みぎだけたま)",
		"  [1]   1問 (もん)", "  [2]   5問 (もん)", "  [3]   10問 (もん)"
	};
	public NumNum(){
	}
	public void setNum(String str){
		if(str.equals(aa[0])||str.equals(aa[3])||str.equals(aa[7])||str.equals(aa[26])){
			this.num = 1;
		} else if(str.equals(aa[1])||str.equals(aa[4])||str.equals(aa[8])||str.equals(aa[27])){
			this.num = 2;
		} else if(str.equals(aa[2])||str.equals(aa[5])||str.equals(aa[9])||str.equals(aa[28])){
			this.num = 3;
		} else if(str.equals(aa[6])||str.equals(aa[10])||str.equals(aa[30])){
			this.num = 4;
		} else if(str.equals(aa[11])){
			this.num = 5;
		} else if(str.equals(aa[12])){
			this.num = 6;
		} else if(str.equals(aa[13])){
			this.num = 7;
		} else if(str.equals(aa[14])){
			this.num = 8;
		} else if(str.equals(aa[15])||str.equals(aa[31])){
			this.num = 9;
		} else if(str.equals(aa[16])||str.equals(aa[29])){
			this.num = 0;
		} else if(str.equals(aa[17])){
			this.num = 1000;
		} else if(str.equals(aa[18])){
			this.num = 2000;
		} else if(str.equals(aa[19])){
			this.num = 3000;
		} else if(str.equals(aa[20])){
			this.num = 4000;
		} else if(str.equals(aa[21])){
			this.num = 5000;
		} else if(str.equals(aa[22])){
			this.num = 6000;
		} else if(str.equals(aa[23])){
			this.num = 7000;
		} else if(str.equals(aa[24])){
			this.num = 8000;
		} else if(str.equals(aa[25])){
			this.num = 10000;
		}
	}
	public int getNum(){
		return this.num;
	}
}