public class NumNum{
	private int num;private String[] aa = {"  [1]   ‚â‚³‚µ‚¢", "  [2]   ‚Ó‚Â‚¤", "  [3]   ‚Ş‚¸‚©‚µ‚¢", "  [1]   ã‚è(‚Ì‚Ú‚è)", "  [2]   ‰º‚è(‚­‚¾‚è)"};
	public NumNum(){
	}
	public void setNum(String str){
		if(str.equals(aa[0])){
			this.num = 6;
		} else if(str.equals(aa[1])){
			this.num = 8;
		} else if(str.equals(aa[2])){
			this.num = 10;
		} else if(str.equals(aa[3])){
			this.num = 1;
		} else if(str.equals(aa[4])){
			this.num = 2;
		}
	}
	public int getNum(){
		return this.num;
	}
}