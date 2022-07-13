package contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem_Starters_47_Div4_F {

	public static FastScanner fs = new FastScanner();
    public static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		int testCases = fs.nextInt();

        for (int i = 0; i < testCases; i++) {
        	out.println(solve());
        }
        
        out.close();
	}

	public static int solve() {
		int n = fs.nextInt();
		int[] a = fs.readArray(n);
		if(n == 1)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int unique = 0, maxHeight = 0;
		for(int i = 0; i < n; i++) {
			maxHeight = Math.max(maxHeight, a[i]);
			if(map.containsKey(a[i])) {
				int count = map.get(a[i]);
				count++;
				map.put(a[i], count);
			}
			else 
				map.put(a[i], 1);
		}
//		out.println(map);
		int maxCount = 0;
		for(int i = 0; i < n; i++) {
			int count = map.get(a[i]);
			maxCount = Math.max(maxCount, count);
			if(count == 1)
				unique++;
		}
		return (unique == 0) ? 0 : ((unique % 2 == 0) ? (unique / 2) : ((map.get(maxHeight) == 1 && maxCount == 2) ? 
				(unique + 1) / 2 + 1 : (unique + 1) / 2));
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
            return Integer.parseInt(next());
        }
 
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i<n; i++) a[i]=nextInt();
            return a;
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
	}
}
