public class NumNum{
	private int num;private String[] aa = {"  [1]   �₳����", "  [2]   �ӂ�", "  [3]   �ނ�������", "  [1]   ���(�̂ڂ�)", "  [2]   ����(������)"};
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