public class NumNum{
	private int num;private String[] aa = {
		"  [1]   ���ǂ�(���܂����)", "  [2]   �����Z(��������)", "  [3]   �����Z(�Ђ�����)", "  [1]   ����(�ɂイ����)", "  [2]   ����(���傫�イ)", "  [3]   ����(���イ���イ)", "  [4]   �㋉(���傤���イ)",
		"  [1]   1�P�^", "  [2]   2�P�^", "  [3]   3�P�^", "  [4]   4�P�^", "  [5]   5�P�^", "  [6]   6�P�^", "  [7]   7�P�^", "  [8]   8�P�^", "  [9]   9�P�^",
		"  [9]   �m�[���~�b�g", "  [1]   1�b(�т傤)", "  [2]   2�b(�т傤)", "  [3]   3�b(�т傤)", "  [4]   4�b(�т傤)", "  [5]   5�b(�т傤)", "  [6]   6�b(�т傤)", "  [7]   7�b(�т傤)", "  [8]   8�b(�т傤)", "",
		"  [1]   ������(��傤�ق�����)", "  [2]   ��������(�Ђ��肾������)", "  [3]   �E������(�݂���������)",
		"  [1]   1�� (����)", "  [2]   5�� (����)", "  [3]   10�� (����)"
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