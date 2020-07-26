// java program by Eric Adamian
// implementation of naive gaussian/gaussian with SPP
// input: .lin file; output: .sol file with results

import java.io.*;
import java.util.*;

public class Gaussian{

	// NAIVE GAUSSIAN ELIMINATION

	// forward elimination
	public static void FwdElimination(float[][] coeff, float[] constant) {

		int n = coeff.length;

		for (int k = 0; k < (n - 1); k++) {
			for(int i = (k + 1); i < n; i++) {
				float mult = (coeff[i][k] / coeff[k][k]);

				for(int j = (k + 1); j < n; j++){
					coeff[i][j] = (coeff[i][j] - (mult * coeff[k][j]));
				}
				constant[i] = (constant[i] - (mult * constant[k]));
			}
		}
	}

	// back substitution
	public static float[] BackSubst(float[][] coeff, float[] constant) {

		int n = coeff.length;
		float[] sol = new float[n];
		float sum = 0;

		sol[n - 1] = constant[n - 1] / coeff[n - 1][n - 1];

		for(int i = (n - 2); i > -1; i--) {
			sum = constant[i];
			for(int j = (i + 1); j < n; j++) {
				sum = (sum - (coeff[i][j] * sol[j])); 
			}
			sol[i] = (sum / coeff[i][i]);
		}
		return sol;
	}

	// ****************************************************************************************************

	// GAUSSIAN ELIMINATION WITH SCALED PARTIAL PIVOTING

	// forward elimination
	public static int[] SPPFwdElimination(float[][] coeff, float[] constant) {

		int n = coeff.length;
		float[] scaling = new float[n];
		int[] indices = new int[n];
		float smax, rmax = 0;

		for(int i = 0; i < n; i++) {
			indices[i] = i;
			smax = 0;
			for(int j = 0; j < n; j++) {
				while(smax < (coeff[i][j])) {
					smax = coeff[i][j];
				}
			}
			scaling[i] = smax;
		}

		for(int k = 0; k < (n - 1); k++) {
			int maxIndex = k;
			for(int i = k; i < n; i++) {
				float r = (coeff[indices[i]][k] / scaling[indices[i]]);
				if(r > rmax) {
					rmax = r;
					maxIndex = i;
				}	
			} 
			
			swap(indices, maxIndex, k);

			for(int i = (k + 1); i < n; i++) {
				float mult = coeff[indices[i]][k] / coeff[indices[k]][k];

				for(int j = (k + 1); j < n; j++) {
					coeff[indices[i]][j] = coeff[indices[i]][j] - mult * coeff[indices[k]][j];
				}
				constant[indices[i]] = constant[indices[i]] - mult * constant[indices[k]];
			}
		}
		return indices;
	}

	// swap between maxIndex and k
	public static void swap(int[] indices, int maxIndex, int k) {
		int swap = indices[k];
		indices[k] = indices[maxIndex];
		indices[maxIndex] = swap;
	}

	// back substitution
	public static float[] SPPBackSubst(float[][] coeff, float[] constant, int[] indices) {

		int n = coeff.length;
		float[] sol = new float[n];
		float sum = 0;

		sol[n - 1] = constant[indices[n - 1]] / coeff[indices[n - 1]][n - 1];


		for(int i = n - 2; i > -1; i--) {
			sum = constant[indices[i]];
			for(int j = (i + 1); j < n; j++) {
				sum = (sum - (coeff[indices[i]][j] * sol[j]));
			}
			sol[i] = (sum / coeff[indices[i]][i]);
		}
		return sol;
	}


	// ****************************************************************************************************

	// main method
	public static void main(String[] args) throws FileNotFoundException{
		try{
			String fileName = null;
			boolean executeSPP = false;
			float[] sol;

			// compiling without a .lin file
			if(args.length == 0) {
				System.out.println("Error: Specify .lin file.");
				System.exit(0);
			}

			// compiling with .lin file using --spp flag (scaled partial pivoting)
			// args[0] and args[1] in reference to command line arguments for file
			if(args.length > 1) {
				String flag = args[0];
				if(flag.equals("--spp")) {
					executeSPP = true;
				}else{
					System.out.println("Warning: Flag unknown, running on default settings (ensure type '--spp').");
				}
				fileName = args[1];
			} else {
				fileName = args[0];
			}


			// iterating through inputted coefficients/constants of given linear system
			Scanner input = new Scanner(new File(fileName));
			int n = input.nextInt();

			float[][] coeff = new float[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					coeff[i][j] = input.nextFloat();

				}
			}

			float[] constants = new float[n];
			for(int i = 0; i < n; i++) {
				constants[i] = input.nextFloat();
			}

			// executing our naive gaussian/gaussian with SPP
			if(executeSPP) {
				int[] indices = SPPFwdElimination(coeff, constants);
				sol = SPPBackSubst(coeff, constants, indices);
			} else {
				FwdElimination(coeff, constants);
				sol = BackSubst(coeff, constants);
			}

			// appending to our new .sol file
			try {
				String newFileName = fileName.substring(0, fileName.indexOf('.'));
				FileWriter fw = new FileWriter(newFileName + ".sol");
				for(int i = 0; i < sol.length; i++) {
					if(sol[i] > 0 || sol[i] < 0){
						fw.append(sol[i] + " ");
					}else{
						fw.append("0.0 ");
					}
				}
				fw.close();
			}catch(IOException exception){
			}

		// error message for files not found or entered correctly
		}catch(FileNotFoundException e){
			System.out.println("Error: File not found, please try again.");
			System.exit(0);
		}
	} 
}