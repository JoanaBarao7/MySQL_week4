package Application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CatDao;
import entity.Cat;

public class Menu {
	
	private CatDao catDao = new CatDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Cats",
			"Display a Cat",
			"Create Cat",
			"Delete Cat");
	
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
			
				if (selection.equals("1")) {
					displayCats();
				} else if (selection.equals("2")) {
					displayCat();
				} else if (selection.equals("3")) {
					createCat();
				} else if (selection.equals("4")) {
					deleteCat();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue...");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}

	private void printMenu() {
		System.out.println("Select an Option: \n-------------------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayCats() throws SQLException {
		List<Cat> cats = catDao.getCats();
		for (Cat cat : cats) {
			System.out.println("ID: " + cat.getCatId() + " Name: " + cat.getCatName());
		}
		
	}
	
	private void displayCat() throws SQLException {
		System.out.println("Enter cat id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Cat cat = catDao.getCatById(id);
		System.out.println("ID: " + cat.getCatId() + " Name: " + cat.getCatName());
	}
	
	private void createCat() throws SQLException {
		System.out.println("Enter new cat name:");
		String catName = scanner.nextLine();
		catDao.createNewCat(catName);
		
	}
	
	private void deleteCat() throws SQLException {
		System.out.print("Enter cat id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		catDao.deleteCatById(id);
	}
}
