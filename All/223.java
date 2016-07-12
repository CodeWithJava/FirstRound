public class Solution
{
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
	{
		int result = (C - A) * (D - B) + (G - E) * (H - F);

		if(C < E || G < A)
		return result;
		if(D < F || H < B)
		return result;

		int top = Math.min(H,D);
		int bottom = Math.max(F,B);
		int left = Math.max(A,E);
		int right = Math.min (C,G);

		return result - (right - left) * (top - bottom);
	}
}