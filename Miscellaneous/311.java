public class Solution
{
	public static int[][] multiply(int[][] A, int[][] B)
	{
		int Ar = A.length;
		int Ac = A[0].length;
		int Bc = B[0].length;
		int[][] C = new int[Ar][Bc];

		for (int i = 0; i < Ar; i++)
		{
			for (int j = 0; j < Ac; j++)
			{
				if (A[i][j] == 0)
					continue;
				for (int k = 0; k < Bc; k++)
				{
					if (B[j][k] == 0)
						continue;
					C[i][k] += A[i][j] * B[j][k];
				}
			}
		}

		return C;
	}
}