public class NumNum{
	private int num;private String[] aa = {"  [1]   ‘«‚µZ(‚½‚µ‚´‚ñ)", "  [2]   ˆø‚«Z(‚Ğ‚«‚´‚ñ)", "  [3]   Š|‚¯Z(‚©‚¯‚´‚ñ)", "  [4]   Š„‚èZ(‚í‚è‚´‚ñ)", "  [1]   —]‚è–³‚µ(‚ ‚Ü‚è‚È‚µ)", "  [2]   —]‚è—L‚è(‚ ‚Ü‚è‚ ‚è)", "  [1]   ƒfƒtƒHƒ‹ƒg", "  [2]   ¤‚Ì‚İ(‚µ‚å‚¤‚Ì‚İ)", "  [2]   ‚â‚³‚µ‚¢"};
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