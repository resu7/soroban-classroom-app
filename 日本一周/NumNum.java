public class NumNum{
	private int num;private String[] aa = {"  [1]   足し算(たしざん)", "  [2]   引き算(ひきざん)", "  [3]   掛け算(かけざん)", "  [4]   割り算(わりざん)", "  [1]   余り無し(あまりなし)", "  [2]   余り有り(あまりあり)", "  [1]   デフォルト", "  [2]   商のみ(しょうのみ)", "  [2]   やさしい"};
	public NumNum(){
	}
	public void setNum(String str){
		if(str.equals(aa[0])){
			this.num = 1;
		} else if(str.equals(aa[1])){
			this.num = 2;
		} else if(str.equals(aa[2])){
			this.num = 3;
		} else if(str.equals(aa[3])){
			this.num = 4;
		} else if(str.equals(aa[4])){
			this.num = 4;
		} else if(str.equals(aa[5])||str.equals(aa[6])){
			this.num = 5;
		} else if(str.equals(aa[7])){
			this.num = 6;
		} else if(str.equals(aa[8])){
			this.num = 7;
		}
	}
	public int getNum(){
		return this.num;
	}
}