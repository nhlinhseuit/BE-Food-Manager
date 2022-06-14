

//graphic user interface
package gui;

import dao.FoodManager;
import java.text.ParseException;
import util.Menu;

public class main {
    /* 1 menu:
            - hien thi menu
            - nguoi dung nhap choice
        
    */
    public static void main(String[] args) throws ParseException {
        int choice;
        Menu menu = new Menu();
        FoodManager foodManager = new FoodManager();
        
        while(true){
            choice = menu.printMenu();
            switch(choice) {
            case 1:
                foodManager.add();
                break;
            case 2:
                foodManager.Search();
                break;
            case 3:
                foodManager.remove();
                break;
            case 4:
                foodManager.print();
                break;
            
        }
        }
    }
}
