public class NumNum{
	private int num;private String[] aa = {"  [1]   �����Z(��������)", "  [2]   �����Z(�Ђ�����)", "  [3]   �|���Z(��������)", "  [4]   ����Z(��肴��)", "  [1]   �]�薳��(���܂�Ȃ�)", "  [2]   �]��L��(���܂肠��)", "  [1]   �f�t�H���g", "  [2]   ���̂�(���傤�̂�)", "  [2]   �₳����"};
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