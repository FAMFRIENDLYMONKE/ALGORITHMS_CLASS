import java.util.Scanner;

class AssemblyLineScheduling{
    public static void main(String[] args){
        int e1 = 2, 
        e2 = 4, 
        x1 = 3, 
        x2 = 2;

        int[][] s = 
        {   {7, 9, 3, 4, 8, 4},
            {8, 5, 6, 4, 5, 7}
        };
        int[][] cost_to_other = 
        {
            {2, 3, 1, 3, 4},
            {2, 1, 2, 2, 1}
        };

        int[][] min = new int[2][6];
        int[][] dp = new int[2][6];

        min[0][0] = e1 + s[0][0];
        min[1][0] = e2 + s[1][0];
        dp[0][0] = 1;
        dp[1][0] = 2;

        for(int j=1; j<6; j++){
            // findig min cost to reach s1,j
            int cost_line_one = min[0][j-1] + s[0][j];
            int cost_line_two = min[1][j-1] + cost_to_other[1][j-1] + s[0][j];
            if(cost_line_one < cost_line_two){
                min[0][j] = cost_line_one;
                dp[0][j] = 1;
            }else{
                min[0][j] = cost_line_two;
                dp[0][j] = 2;
            }

            // findig min cost to reach s2,j
            cost_line_two = min[1][j-1] + s[1][j];
            cost_line_one = min[0][j-1] + cost_to_other[0][j-1] + s[1][j];
            if(cost_line_one < cost_line_two){
                min[1][j] = cost_line_one;
                dp[1][j] = 1;
            }else{
                min[1][j] = cost_line_two;
                dp[1][j] = 2;
            }
        }

        int cost_final_one = min[0][5] + x1;
        int cost_final_two = min[1][5] + x2;

        int i = cost_final_one < cost_final_two?0:1;
        for(int j = 4; j > 0; j--){
            System.out.println("Select S"+i+","+(j+1)+" Shop");
            i = dp[i][j]-1;
        }
        System.out.println("Select S"+i+",1 Shop");

        for(i = 0; i < 6; i++) System.out.print(min[0][i]+" ");
        System.out.println();
        for(i = 0; i < 6; i++) System.out.print(min[1][i]+" ");
        System.out.println();    
        for(i = 0; i < 6; i++) System.out.print(dp[0][i]+" ");
        System.out.println();
        for(i = 0; i < 6; i++) System.out.print(dp[1][i]+" ");
        System.out.println();
    }
}