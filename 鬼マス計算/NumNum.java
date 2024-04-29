public class NumNum{
	private int num;private String[] aa = {"  [1]   足し算(たしざん)", "  [2]   掛け算(かけざん)", "  [1]   1ケタ＋1ケタ", "  [2]   2ケタ＋1ケタ", "  [3]   2ケタ＋2ケタ", "  [4]   3ケタ＋2ケタ", "  [5]   3ケタ＋3ケタ", "  [6]   4ケタ＋4ケタ", "  [1]   1ケタ×1ケタ", "  [2]   2ケタ×1ケタ", "  [3]   3ケタ×1ケタ", "  [4]   2ケタ×2ケタ", "  [5]   3ケタ×2ケタ", "  [6]   3ケタ×3ケタ", "  [2]   よこのケタが大きい(おおきい)"};
	public NumNum(){
	}
	public void setNum(String str){
		if(str.equals(aa[0])){
			this.num = 0;
		} else if(str.equals(aa[1])){
			this.num = 1;
		} else if(str.equals(aa[2])||str.equals(aa[8])){
			this.num = 10;
		} else if(str.equals(aa[3])||str.equals(aa[9])){
			this.num = 8;
		} else if(str.equals(aa[4])||str.equals(aa[10])){
			this.num = 7;
		} else if(str.equals(aa[5])||str.equals(aa[11])){
			this.num = 6;
		} else if(str.equals(aa[6])||str.equals(aa[12])){
			this.num = 5;
		} else if(str.equals(aa[7])||str.equals(aa[13])){
			this.num = 4;
		} else if(str.equals(aa[14])){
			this.num = 100;
		}
	}
	public int getNum(){
		return this.num;
	}
}