import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hamlet
{

	final static String inputFileName = "War and Peace.txt";

	public static void main(String[] args)
	{
		
		

		
		ListInterface[] Lists = new ListInterface[4]; // By creating the lists as
		// an array, we can iterate
		// with a subscript
		Lists[0] = new List1(); // Unsorted, insertions at beginning, no self-optimization
		Lists[1] = new List2(); // Sorted linked list
		Lists[2] = new List3(); // Unsorted, heavy-handed self-adjusting (moves repeated
		// word to the front of the list)
		Lists[3] = new List4(); // Unsorted, conservative self-adjusting (moves repeated
		// word one position towards front of list)

		String[] ListNames = { "Unsorted", "Sorted", "Self-Adj (Front)", "Self-Adj (By One)" };

		
		String filename = (args.length>0) ? args[0] : "ALL.txt";
		
		
		
		FileInputStream fin;

		try
		{

			fin = new FileInputStream(filename);
			Scanner finScanner = new Scanner(fin);
			while (finScanner.hasNext())
			{
				String word = (finScanner.next());
			}
			finScanner.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		double rpSTime = System.nanoTime();
		try
		{

			fin = new FileInputStream(filename);
			Scanner finScanner = new Scanner(fin);
			while (finScanner.hasNext())
			{
				String word = (finScanner.next());
			}
			finScanner.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		double rpETime = System.nanoTime();
		System.out.println("Time of RP: "+(rpETime-rpSTime));
//		double list1STime = System.nanoTime();
//		try
//		{
//			fin = new FileInputStream(filename);
//			Scanner finScanner = new Scanner(fin);
//			while (finScanner.hasNext())
//			{
//				String word = (finScanner.next());
//				word = word.toLowerCase();
//				word = cleanWord(word);
//				if (word.compareTo("") == 0)
//				{
//					continue; // Its empty word therefore we don't insert into our LLs, lets skip it
//				}
//				Lists[0].add(word);
//
//			}
//			finScanner.close();
//		} catch (FileNotFoundException e)
//		{
//			e.printStackTrace();
//		}
//		double list1ETime = System.nanoTime();
//		
//		try
//		{
//			fin = new FileInputStream(filename);
//			Scanner finScanner = new Scanner(fin);
//			while (finScanner.hasNext())
//			{
//				String word = (finScanner.next());
//				word = word.toLowerCase();
//				word = cleanWord(word);
//				if (word.compareTo("") == 0)
//				{
//					continue; // Its empty word therefore we don't insert into our LLs, lets skip it
//				}
//				Lists[1].add(word);
//
//			}
//			finScanner.close();
//		} catch (FileNotFoundException e)
//		{
//			e.printStackTrace();
//		}
//		double list2ETime = System.nanoTime();
//		
//		try
//		{
//			fin = new FileInputStream(filename);
//			Scanner finScanner = new Scanner(fin);
//			while (finScanner.hasNext())
//			{
//				String word = (finScanner.next());
//				word = word.toLowerCase();
//				word = cleanWord(word);
//				if (word.compareTo("") == 0)
//				{
//					continue; // Its empty word therefore we don't insert into our LLs, lets skip it
//				}
//
//				Lists[2].add(word);
//			}
//			finScanner.close();
//		} catch (FileNotFoundException e)
//		{
//			e.printStackTrace();
//		}
//		double list3ETime = System.nanoTime();
//		
//		try
//		{
//			fin = new FileInputStream(filename);
//			Scanner finScanner = new Scanner(fin);
//			while (finScanner.hasNext())
//			{
//				String word = (finScanner.next());
//				word = word.toLowerCase();
//				word = cleanWord(word);
//				if (word.compareTo("") == 0)
//				{
//					continue; // Its empty word therefore we don't insert into our LLs, lets skip it
//				}
//				Lists[3].add(word);
//			}
//			finScanner.close();
//		} catch (FileNotFoundException e)
//		{
//			e.printStackTrace();
//		}
//		
//		
//		double list4ETime = System.nanoTime();
//		
//		double[] Timelist= {(list1ETime-list1STime)/1000000, (list2ETime-list1ETime)/1000000,
//							(list3ETime-list2ETime)/1000000,(list4ETime-list3ETime)/1000000};
//		
//		for(int i=0; i<=3;i++)
//			{System.out.print("Time of list "+i+":"+Timelist[i]+"\n");}
//		
//		System.out.println(" #     List Name     Run Time Vocabulary Total Words   Key Comp     Ref Chgs\n"
//				+ "-- ----------------- -------- ---------- ----------- ------------ ------------");
//		for(int i=0; i<=3; i++)
//		{
//			System.out.printf("%1d  %-17s %8.3f %-10d %-11d %-12d %-12d\n",i+1,ListNames[i],(double)Timelist[i],
//					Lists[i].getDistinctWords(),Lists[i].getTotalWords(),Lists[i].getKeyCompare(),
//					Lists[i].getRefChanges());
//		}
//
	}

	private static boolean isPunctuation(char letter)
	{
		String punctuation = "!@#$%^&*()_+-=[]\\{}|;':\"`~,./<>?";
		return punctuation.indexOf(letter) == -1 ? false : true;
	}

	private static String cleanWord(String dirtyWord)
	{
		String cleanWord = dirtyWord;

		while (cleanWord.length() > 0
				&& (isPunctuation(cleanWord.charAt(0)) || isPunctuation(cleanWord.charAt(cleanWord.length() - 1))))
		{
			// Lets check if the first letter has a punctuation
			if (cleanWord.length() > 0 && isPunctuation(cleanWord.charAt(0)))
			{
				// Lets grab the substring of the dirty word by removing the first letter
				cleanWord = cleanWord.substring(1); // Grab from the 2nd char until the last char
			}
			if (cleanWord.length() > 0 && isPunctuation(cleanWord.charAt(cleanWord.length() - 1)))
			{
				cleanWord = cleanWord.substring(0, cleanWord.length() - 1);
			}

		}

		// System.out.println(cleanWord);
		return cleanWord;
	}

}
