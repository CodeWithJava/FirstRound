import java.util.Scanner;
public class Permutation
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to select our permutation system!");
		System.out.println("Please input the size of array:");
		int size = sc.nextInt();
		int [] array = new int [size];
		for(int i = 0;i < size;i++)
		{
			System.out.println("Please input the No." + (i + 1) + " element");
			array[i] = sc.nextInt();
		}
		System.out.println("Please select mode:");
		System.out.println("1.previous 2.next");

		int mode = sc.nextInt();

		if(mode == 1)
		{
			Previous.previousPermutation(array);
			System.out.println("Previous Permutation:");
			for(int x: array)
				System.out.print(x + " ");
			System.out.println();
		}
		else if(mode == 2)
		{
			Next.nextPermutation(array);
			System.out.println("Next Permutation:");
			for(int x: array)
				System.out.print(x + " ");
			System.out.println();
		}
		sc.close();
	}
}
