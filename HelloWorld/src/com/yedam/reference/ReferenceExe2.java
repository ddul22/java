package com.yedam.reference;

public class ReferenceExe2 {

	public static void main(String[] args) {
		
	double[]dbAry = new double[5];
	dbAry[0] = 80;
	System.out.println(dbAry.length);
	for (int i = 0; i < dbAry.length; i++) {
		
	}
	
//	String[][] scores = new String[5][2];
	
    String[][] scores = { {"홍길동", "80"},
    		{"김민수","85"},
            {"박헌수","88"},
            {"심상현","90"},
            {"최기동","75"},
    };
    for (int i = 0; i <scores.length; i++) {
    	System.out.println("점수=> " + scores[i][1]);
    }
    int sum = 0;
    for(int j = 0; j < scores.length; j++) {
    	sum += Integer.parseInt(scores[j][1]);
    	System.out.println("점수의 합계 => " + scores[j][1]);
    }
    int max = 0;
     
    //String[][] scores = { {"홍길동", "80"},와 같음
//    System.out.printf("sum의 값은 %d\n", sum);
//	scores[0][0] = "홍길동";	
//	scores[0][1] = "80";
//	scores[1][0] = "김민수";
//	scores[1][1] = "85";
//	scores[2][0] = "박현수";
//	scores[2][1] = "90";
//	scores[3][0] = "심상현";
//	scores[3][1] = "75";
//	scores[4][0] = "최기동";
//	scores[4][1] = "75";
//	
//	for (int j = 0; j < scores.length; j++) {
//		for (int i = 0; i <scores[0].length; i++) {
//			System.out.println("["+ j + "][" + i + "] => "+scores[j][i]); 
//		}
//	}
	
	
	} // end of main.
}
