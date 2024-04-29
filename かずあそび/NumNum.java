public class NumNum{
	private int num;private String[] aa = {"  [1]   かぞえる", "  [2]   あわせる", "  [3]   くらべる", "  [4]   おかね　", "  [1]   1 もん", "  [2]   5 もん", "  [3]  10 もん", "  [1]   やさしい　", "  [2]   ふつう　　", "  [3]   むずかしい", "  [1]   デフォルト", "  [2]   バラバラ　"};
	public NumNum(){
	}
	public void setNum(String str){
		if(str.equals(aa[0])||str.equals(aa[4])||str.equals(aa[7])||str.equals(aa[10])){
			this.num = 1;
		} else if(str.equals(aa[1])||str.equals(aa[8])||str.equals(aa[11])){
			this.num = 2;
		} else if(str.equals(aa[2])||str.equals(aa[9])){
			this.num = 3;
		} else if(str.equals(aa[3])){
			this.num = 4;
		} else if(str.equals(aa[5])){
			this.num = 5;
		} else if(str.equals(aa[6])){
			this.num = 10;
		}
	}
	public int getNum(){
		return this.num;
	}
}