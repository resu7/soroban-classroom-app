public class NumNum{
	private int num;private String[] aa = {"  [1]   ��������", "  [2]   ���킹��", "  [3]   ����ׂ�", "  [4]   �����ˁ@", "  [1]   1 ����", "  [2]   5 ����", "  [3]  10 ����", "  [1]   �₳�����@", "  [2]   �ӂ��@�@", "  [3]   �ނ�������", "  [1]   �f�t�H���g", "  [2]   �o���o���@"};
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