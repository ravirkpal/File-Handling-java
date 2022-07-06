package FileHandler;

import java.io.File;
import java.util.Scanner;

public class FileHandling {

	public static void main(String[] args) {

		FileHandling.mainmenu();

	}

	public static void mainmenu() {

		System.out.println("**********File Handling***********");
		System.out.println("********My First Java Project*********");

		try (Scanner r = new Scanner(System.in)) {
			int options;
			do {

				System.out.println("1.Show All Sorted UserFiles");
				System.out.println("2.File Management");
				System.out.println("3.Quit.");

				options = r.nextInt();

				switch (options) {
				case 1:
					showallfiles();
					break;
				case 2:
					filemanagement();
					break;
				case 3:
					quit();
					break;
				default:
					throw new IllegalArgumentException("wrong option");
				}
			} while (options != 3);
		}
			
		}

	

	private static void showallfiles() {

		File file = new File("C:\\Users\\ravipal\\Java");
		String F = file.toString();
		File[] direct = new File(F).listFiles();

		for (File F1 : direct) {
			if (F1.isFile()) {
				System.out.println(F1.getName());

			} else if (F1.isDirectory()) {
				System.out.println(F1.getName());

			}
		}

	}

	private static void filemanagement() {

		try (Scanner fileoption = new Scanner(System.in)) {
			int fo;
			do {
				System.out.println("******File Management*******");
				System.out.println("1.Create a file");
				System.out.println("2.delete a file");
				System.out.println("3.search a file");
				System.out.println("4.rename a file");
				System.out.println("5.back to main menu");

				fo = fileoption.nextInt();
				switch (fo) {
				case 1:
					System.out.println("option 1 selected");
					createfile();
					break;
				case 2:
					System.out.println("option 2 selected");
					deletefile();
					break;
				case 3:
					System.out.println("option 3 selected");
					searchfile();
					break;
				case 4:
					System.out.println("option 4 selected");
					renamefile();
					break;
				case 5:
					System.out.println("option 5 selected");
					backtomenu();
					break;
				default:
					throw new IllegalArgumentException("wrong option");
				}
			} while (fo != 5);

		}

	}

	private static void createfile() {
		System.out.println("Enter a file name1");
		try (Scanner name = new Scanner(System.in)) {
			String filename = name.next();
			
				File file = new File("C:\\Users\\ravipal\\Java\\" + filename);
				try {
					if (file.createNewFile()) {
						System.out.println("File Created Succesfully..");
					}else {
						System.out.println("already exist!!");
						createfile();
					}
				} catch (Exception e) {
					System.out.println("error accured!!!");
				}
				
			
		}

	}

	private static void deletefile() {

		@SuppressWarnings("resource")
		Scanner d = new Scanner(System.in);
		System.out.println("Enter a file name you want to delete");
		String dname = d.next();
		File file = new File("C:\\Users\\ravipal\\java\\" + dname);
		
		if (file.delete()) {
			System.out.println("File Delete Succesfully...");
		}else {
			System.out.println("File doesn't exist!!");
			
		}
		

	}

	private static void searchfile() {
		
	      
			try (Scanner s = new Scanner(System.in)) {
				System.out.println("Enter a file name you want to search");
				String sname = s.next();
				File file = new File("C:\\Users\\ravipal\\java\\"+sname);
				
				if (file.exists()) {
					System.out.println("File exist..");
					
				}else {
					System.out.println("File doesn't exist!!");
					
				}
			}
		
	}

	@SuppressWarnings("resource")
	private static void renamefile() {

		Scanner f = new Scanner(System.in);
		Scanner r = new Scanner(System.in);
		System.out.println("enter a exist file name");
		String f1 = f.next();

		System.out.println("rename a file");
		String r1 = r.next();

		File f2 = new File("C:\\Users\\ravipal\\Java\\" + f1);
		File r2 = new File("C:\\Users\\ravipal\\Java\\" + r1);

		if (f2.renameTo(r2)) {
			System.out.println("file renamed succesfully...");
		} else {
			System.out.println("file doesn't change");
		}

	}

	private static void backtomenu() {
		mainmenu();

	}

	// QUIT APPLICATION
	private static void quit() {

		System.out.println("Thanks for using application");
		System.exit(0);

	}
}
