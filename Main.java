package projekt;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
	public static void main(String args[]) throws FileNotFoundException 
	{

		Scanner odczyt = new Scanner(System.in);
		
		Kalkulator2 kalk = new Kalkulator2();

		
		String koniec="begin";
		while(!koniec.equals("koniec"))
		{
			System.out.println("Wybierz opcje\n1-obliczanie  rownania z klawiatury\n2-obliczanie rownania z pliku\nJesli napiszesz 'koniec'program sie zakonczy\n");
			String wybor2 = odczyt.nextLine();
			if(wybor2.equals("koniec"))
			{
				System.out.println("koniec programu\n");
				break;
			}
			int wybor=Integer.valueOf(wybor2);
			
			while (wybor < 1 || wybor > 2) 
			{
				System.out.println("Nie ma takiej opcji.Podaj jeszcze raz\n");
				wybor = odczyt.nextInt();
			}
	
			switch(wybor)
			{
				case 1:
				{
					StringTokenizer token;
					int wynik=0;
					System.out.println("Podaj rownanie\n");
					String linijka=odczyt.nextLine();
					token = new StringTokenizer(linijka, "+-*/", true);
		
					while (token.hasMoreTokens()) 
					{
						//System.out.println("token =" + token.nextToken());
						int liczba = Integer.valueOf(token.nextToken());
						String znak = token.nextToken();
						int liczba2 = Integer.valueOf(token.nextToken());
	
						if (znak.equals("+")) 
						{
							wynik=kalk.dodawanie(liczba,liczba2);
						}
						else if (znak.equals("-")) 
						{
							wynik=kalk.odejmowanie(liczba,liczba2);
						}
						else if (znak.equals("*")) 
						{
							wynik=kalk.mnozenie(liczba,liczba2);
						}
						else if (znak.equals("/")) 
						{
							wynik=kalk.dzielenie(liczba,liczba2);
						}
						System.out.println(linijka+"="+wynik);
					}
					break;
				} 
				case 2:
				{
					StringTokenizer token;
					File plik = new File("dane.txt");
					Scanner odczytzpliku = new Scanner(plik);
					while (odczytzpliku.hasNextLine()) 
					{
						int wynik=0;
						String linijka= odczytzpliku.nextLine();
						token = new StringTokenizer(linijka, "+-*/", true);
						
		
						while (token.hasMoreTokens()) 
						{
							//System.out.println("token =" + token.nextToken());
							int liczba = Integer.valueOf(token.nextToken());
							String znak = token.nextToken();
							int liczba2 = Integer.valueOf(token.nextToken());
		
							if (znak.equals("+")) 
							{
								wynik=kalk.dodawanie(liczba,liczba2);
							}
							else if (znak.equals("-")) 
							{
								wynik=kalk.odejmowanie(liczba,liczba2);
							}
							else if (znak.equals("*")) 
							{
								wynik=kalk.mnozenie(liczba,liczba2);
							}
							else if (znak.equals("/")) 
							{
								wynik=kalk.dzielenie(liczba,liczba2);
							}
							System.out.println(linijka+"="+wynik);
							
						}
					}
					odczytzpliku.close();
					break;
				}
			}
		}
		odczyt.close();
		
	}
}
