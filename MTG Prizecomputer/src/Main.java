import java.text.DecimalFormat;


public class Main {
	
	public static void main (String[]args) {
	
		int minplayers = 9;
		int maxplayers = 16;
		double payout40 = 38.5;//35 eur to chf
		double payout301 = 33.0;//30 eur to chf
		double payout31 = 27.5; //25 eur to chf
        drawper = 5.0; //percentage of games being drawn
 
 
 
		double [][] arr = new double [maxplayers+2][7];		
	System.out.println("total players, prob 3-1, prob 3-0-1, prob 4-0, expected value, total income, total average payout, average plus");
	
	DecimalFormat f = new DecimalFormat("###.###");
          drawper = (100-drawper)/100;
         
		 for(int i = minplayers; i<=maxplayers;i++) {
			if ((i%2) == 1) {
			arr[i][0] = lp(i)*wp(i%2)*wp(0)*wp(0)+3.0*wp(i)*wp(0)*wp(0)*lp(0); //prob 3-1
			arr[i][1] = dp(i)*wp(0)*wp(0)*wp(0)+3.0*dp(0)*wp(i)*wp(0)*wp(0); //prob 4-0
			arr[i][2] = wp(i)*wp(0)*wp(0)*wp(0); //prob 4-0
			}else {
			arr[i][0] = 4.0*wp(0)*wp(0)*wp(0)*lp(0);
			arr[i][1] = 4.0*dp(0)*wp(0)*wp(0)*wp(0);
			arr[i][2] = wp(0)*wp(0)*wp(0)*wp(0);				
			}			
			arr[i][3] = arr[i][0]*payout31+arr[i][1]*payout301+arr[i][2]*payout40;
			arr[i][4]= i*10; 
			arr[i][5]= arr[i][3]*i;
			arr[i][6] = arr[i][4]- arr[i][5];
			
			
			if(i<10)
				System.out.print("0");
			System.out.print(i);
			System.out.print("             " +f.format(arr[i][0])+
					"     "+f.format(arr[i][1])+
					"       "+f.format(arr[i][2]) +
					"       "+ f.format(arr[i][3])+
					"             "+ f.format(arr[i][4])+
					"            "+f.format(arr[i][5])+
			        "            "+f.format(arr[i][6]));
			
			System.out.println();
			
		} 
		 System.out.println("average if players are uniformly distributed between "+minplayers+" and "+maxplayers+" players");
		 for(int i= minplayers; i<=maxplayers; i++) {
			 arr [maxplayers+1][0] += arr[i][0];
			 arr [maxplayers+1][1] += arr[i][1];
			 arr [maxplayers+1][2] += arr[i][2];
			 arr [maxplayers+1][3] += arr[i][3];
    		 arr [maxplayers+1][4] += arr[i][4];
    	     arr [maxplayers+1][5] += arr[i][5];
    	     arr [maxplayers+1][6] += arr[i][6];
									 
		 }
	     arr [maxplayers+1][0] /=maxplayers-minplayers+1;
		 arr [maxplayers+1][1] /=maxplayers-minplayers+1;
		 arr [maxplayers+1][2] /=maxplayers-minplayers+1;
		 arr [maxplayers+1][3] /=maxplayers-minplayers+1;
		 arr [maxplayers+1][4] /=maxplayers-minplayers+1;
	     arr [maxplayers+1][5] /=maxplayers-minplayers+1;
	     arr [maxplayers+1][6] /=maxplayers-minplayers+1;
				
	    System.out.print("               " +f.format(arr[maxplayers+1][0])+
				"     "+f.format(arr[maxplayers+1][1])+
				"       "+f.format(arr[maxplayers+1][2]) +
				"    "+ f.format(arr[maxplayers+1][3])+
				"      "+ f.format(arr[maxplayers+1][4])+
				"          "+f.format(arr[maxplayers+1][5])+
	            "           "+f.format(arr[maxplayers+1][6]));
		System.out.println();
		
		
	}
	static double drawper;
	
	private static double wp(int i) {
		if (i==0)
			return 0.5*drawper;
			else
		return 1.0/i+(i-1.0)/i*0.5*drawper;
	}
	
	private static double lp(int i) {
		if (i==0)
			return 0.5*drawper;
			else
		return (i-1.0)/i*0.5*drawper;
	}
	
	private static double dp(int i) {
		if (i==0)
			return 1-drawper;
			else
		return (i-1.0)/i*(1-drawper);
	}
	
	
	
}
