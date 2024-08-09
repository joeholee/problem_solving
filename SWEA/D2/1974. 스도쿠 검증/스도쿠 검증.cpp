import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] arr = new int[9][9];
		boolean[] doesExist = new boolean[9];
		for (int test_case = 1; test_case <= T; test_case++) {
			for (int r = 0; r < 9; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 9; c++)
					arr[r][c] = Integer.parseInt(st.nextToken());
			}
			boolean isValid = checkValid(arr, doesExist);
			System.out.print("#" + test_case + " ");
			System.out.println(isValid ? 1 : 0);
		}
	}

	static boolean checkValid(int[][] arr, boolean[] doesExist) {
    	for(int r=0; r<9; r++) {
            Arrays.fill(doesExist, false);
            for(int c=0; c<9; c++) doesExist[arr[r][c]-1]=true;
            for(boolean b : doesExist) if(!b) return false;
            Arrays.fill(doesExist, false);
            for(int c=0; c<9; c++) doesExist[arr[c][r]-1]=true;
            for(boolean b : doesExist) if(!b) return false;
            Arrays.fill(doesExist, false);
        }
    	for(int i=0; i<3; i++) {
    		for(int j=0; j<3; j++) {
    			for(int r=0; r<3; r++) {
    				for(int c=0; c<3; c++) {
    					doesExist[arr[i*3+r][j*3+c]-1]=true;
    				}
    			}
    			for(boolean b : doesExist) if(!b) return false;
                Arrays.fill(doesExist, false);
    		}
    	}
        return true;
    }
}