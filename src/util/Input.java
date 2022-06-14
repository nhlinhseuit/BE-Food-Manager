
package util;

import dto.Food;
//import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;


public class Input {
    Scanner sc;
    ArrayList<Food> listFood;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    public Input(ArrayList<Food> list) {
        sc = new Scanner(System.in);
        listFood = list;
        
    }
    
//ID, name, weight, type, place, expired date
    public Food inputFood() throws ParseException {
        //nhập
        String id = inputID();
        String name = inputString("name");
        float weight = inputWeight();
        String type = inputString("type");
        String place = inputString("place");
        Date expiredDate = inputDate();
        Food newFood = new Food(id, name, type, place, expiredDate, weight);
        //check
        //trả về
        
        return newFood;
    }
    
    public float inputWeight(){
        //validation: <0 || STRING
        int weight = 0;
        boolean isEnterString = true;
        do
        {   
            try {
                System.out.println("Enter weight: ");
                weight = Integer.parseInt(sc.nextLine());
                isEnterString = false;
                
                if (weight < 0)
                    System.err.println("Weight need to be greater than or equal 0!");
            } 
            catch(Exception e) {
                System.err.println("Weight not allow input string!");
            }
        } while(weight < 0 || isEnterString);
        return weight;
    }
    
    public String inputString(String label){
        String str;
        do {
            System.out.println("Enter " + label + ": ");
            str = sc.nextLine();
            if (str.isEmpty())
                System.err.println("Not allow empty");
        }while(str.isEmpty());
        return str;
    }
    
    public String inputID(){
        //empty?
        //duplicate?
        boolean isDuplicate = true;
        String id;
        
        do{
            System.out.println("Enter id: ");
            id = sc.nextLine();
            isDuplicate = checkDuplicate(id);
            
            if (isDuplicate)
                System.err.println("Not allow duplicate!");
            if (id.isEmpty())
                System.err.println("Not allow empty!!");
            
        }while(id.isEmpty() || isDuplicate);
        
        return id;
    }
    
    public String inputIdfRemove(){
            System.out.println("Enter id: ");
            String id = sc.nextLine();
            return id;
        }
    
    public boolean checkDuplicate(String id){
        for(Food food : listFood){//for each đặc biệt
            //sử dụng getId thay food.id để thể hiện tính đóng gói (encapsulation)
            if(food.getId().equals(id))
                return true;
        }
        return false;
    }
        
    public boolean inputContinue(){
        //true -> continue
        //false - > hien ra lai menu
        boolean choice;
        String option;
        do {
            System.out.println("Do you want to continue? (yes/no) ");
            option = sc.nextLine();
            if (!option.equals("yes") && !option.equals("no")){
                System.err.println("Only allow yes/no!");
            }
        }while(!option.equals("yes") && !option.equals("no"));
        //yes/no
        return option.equals("yes");
    }
    
    public Date inputDate() throws ParseException {
        String date;
        do{
            System.out.println("Enter expired date: ");
            date = sc.nextLine();
            if(!checkDate(date))
                System.err.println("Date invalid!");
        }while(!checkDate(date));
        return df.parse(date);
    }
    
    public boolean checkDate(String date){
        
        boolean result = true;
        try{
//            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            //cơ chế đổi String sang Date.
            //nếu ngày (date) mà sai thì LỖI
            
            df.setLenient(false); //cơ chế tắt chế độ tự sửa lỗi đổi 29/2 thành 1/3
            //29/2/2022 -> 1/3/2022
            df.parse(date);//nếu sai sẽ lỗi tại đây
        } catch(Exception e){
            result = false;
        }
            
        return result;
    }
}
