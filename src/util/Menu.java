
package util;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<String> listFunction;
    Scanner sc;
    
    public Menu(){
        sc = new Scanner(System.in);
        listFunction = new ArrayList<String>();
        listFunction.add(" Add a new food.");
        listFunction.add(" Search a food by name.");
        listFunction.add(" Remove food by ID");
        listFunction.add(" Print the food list in the descending order of expired date.");
        
    }
    
    public int printMenu(){
//        for (int i = 0 ; i < listFunction.size() ; i++) {
//            System.out.println(listFunction.get(i));
//            
//        }


//        for each
//        Kiểu dữ liệu      tên biến (tự đặt)    của cái list nào
//        for(String function: listFunction){
//              khó lấy index
//        }


//      java8: anonymous - vẫn có 2 phần chính là tham số và scope
//      arrow function
    
//        toán tử tham chiếu
//        listFunction.forEach(System.out::println);

        int choice;

        listFunction.forEach((item)->{
            System.out.print(listFunction.indexOf(item)+1+".");
            System.out.println(item);
        });
        choice = getChoice();
        return choice;

    }
    public int getChoice(){
        //validation
        boolean check = false;
        int choice = 0;
        do
        {
            //check nhập chữ
            //check choice có nằm trong list 
            try {
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                check = true;
            } 
            catch(Exception e) {
                System.err.println("Not allow string");
            }
            
            //check nằm trong list
            if (check == true) { //nếu không có lỗi thì mới check
                if (choice >= 1 && choice <= listFunction.size())
                    check = true;
                else {
                    System.err.println("Please enter choice from 1 -> " + listFunction.size() + " !");
                    check = false;
                }
            }
            
        } while(check == false);
        return choice;
    }
}
