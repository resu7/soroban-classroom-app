public class NumNum{
	private int num;private String[] aa = {"  [1]   �����Z(��������)", "  [2]   �|���Z(��������)", "  [1]   1�P�^�{1�P�^", "  [2]   2�P�^�{1�P�^", "  [3]   2�P�^�{2�P�^", "  [4]   3�P�^�{2�P�^", "  [5]   3�P�^�{3�P�^", "  [6]   4�P�^�{4�P�^", "  [1]   1�P�^�~1�P�^", "  [2]   2�P�^�~1�P�^", "  [3]   3�P�^�~1�P�^", "  [4]   2�P�^�~2�P�^", "  [5]   3�P�^�~2�P�^", "  [6]   3�P�^�~3�P�^", "  [2]   �悱�̃P�^���傫��(��������)"};
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