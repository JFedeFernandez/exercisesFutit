public class magicSquad {
	public static void main(String[] args){
		int ar[][] = {{8,1,6},{3,5,7},{4,9,2}};
		int squad[] = {0,0,0,0,0,0,0,0};
		int i,j,k = -1;

		for(i = 0; i < 3; i++){
			k = k + 1;

			for(j = 0; j < 3; j++){
				squad[k] = squad[k] + ar[i][j];
				squad[k+3] = squad[k+3] + ar[j][i];

			}
		}

		for(i = 0; i < 3; i++){
			squad[6] = squad[6] + ar[i][i];
			squad[7] = squad[7] + ar[i][2-1];
		}

		boolean band = true;
		i = 0;

		while (band && i<7){
			if(squad[i] != squad[i+1])
				band = false;

			i = i+1;
		}

		if(band)
			System.out.println("La matriz es magica");
		else
			System.out.println("La matriz no es magica");

		for(i = 0; i < 8; i ++){
			System.out.println(squad[i]+"\t");
		}
	}
}