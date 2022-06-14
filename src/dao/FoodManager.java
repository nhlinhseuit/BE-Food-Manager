//asset
//dao chứa các đối tượng quản lí (manager)
package dao;

import dto.Food;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import util.Input;
import java.util.Date;
import java.util.*;
import java.util.Collections;

//class DateItem{
//    String date;
//    public DateItem(String date) {
//        this.date = date;
//    }
//    
//}
//<DateItem>

//class Sortbyroll implements Comparator<Food>
//{
//    // Used for sorting in ascending order of
//    // roll number
//    public int compare(Food a, Food b)
//    {
////        return a.rollno - b.rollno;
//        return a.getExpiredDate() - b.getExpiredDate();
//    }
//}

public class FoodManager  {
    ArrayList<Food> listFood;
    Input input;
    
    public FoodManager(){
        listFood = new ArrayList<>();
        //khi sử dụng INput làm hàm riêng, phải truyền listFood qua cho nó, và truyền như truyền tham số (truyền địa chỉ qua)
        input = new Input(listFood);
    }

    
    public void add() throws ParseException{
        //nhập(validation)
        Food newFood = input.inputFood();
            
        //add vào list
        listFood.add(newFood);
        System.out.println("Add successfully!");
        //hỏi muốn add thêm không
        //nhap su lua chon, inputContinue handle viec nhap co muon tiep tuc hay khong
        boolean isContinue = input.inputContinue();
        if(isContinue){
            this.add();
        }
                    
    }
    
    public void Search(){
        String keyword = input.inputString("keyword");
        boolean isHaveRecord = false;
        for(Food food: listFood){
            if(food.getName().toLowerCase().contains(keyword.toLowerCase()))
            {
                System.out.println(food);
                isHaveRecord = true; 
            }        
        }
        if(!isHaveRecord)
            System.err.println("This food does not exist");
    }
        //SPECIAL
        //java 8 -> arrow function/anonymous function (khong co ten ham)
        //trong ham` nay thì food đầu là item còn sau dấu -> là filter
//        listFood.stream().filter(food->food.getName().toLowerCase().contains(keyword.toLowerCase()))
//                .forEachOrdered(System.out::println);
        
    
    
    public void remove(){
            //get index by id
            //show confirm message
            //show result
            //returns to menu
        String id;
        boolean decision;
        id = input.inputIdfRemove();
        int index = getIndexById(id);
        if (index == -1)
            System.out.println("ID not found");
        else
        {
            System.out.println("This item will be deleted..");
            decision = input.inputContinue();
            if (decision)
            {
                listFood.remove(index);
                System.out.println("Remove successfully!");
            }
            else    
                System.err.println("Cannot find Id!!");
        }
       
    }
        
    public int getIndexById(String id){
        for (int i = 0 ; i < listFood.size(); i++)
            if(listFood.get(i).getId().equals(id))
                return i;
        return -1;
    }
     
    public void print(){
            //print the food int the descending order of expired date
            //return to menu
            
        System.out.println("List of food available int the descending order of expired date: ");
        System.out.printf("%20s %20s %20s %20s %20s %25s\n", "ID", "Name", "Weight", "Type", "Place", "Expired Date");
              
        Collections.sort(listFood, (Food t1, Food t2) -> t1.getExpiredDate().compareTo(t2.getExpiredDate()));


        for (Food food:listFood)
            System.out.printf("%20s %20s %20s %20s %20s %25s\n", food.getId(), food.getName(), food.getWeight()
                    , food.getType(), food.getPlace(), food. getExpiredDate());

    }
    
//        Collections.sort(listFood, new Comparator<Food>() {
//            public int compare(Food s1, Food s2) {
//                return getDate(s1.getExpiredDay()).compareTo(getDate(s2.getExpiredDay()));
//            }s
//        });
    
    
//    public Date getDate(String date) {
//        try {
//            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//            df.setLenient(false);
//            return df.parse(date);
//        } catch (Exception e) {
//            return null;
//        }
//    }

}

        

       
//        public Date getDate1(String date) {
////            Date datestd = new Date();
////            try {
////                datestd = new SimpleDateFormat("dd/MM/yyyy").parse(std.getExpiredDate());
////            } catch (Exception e) {
////                System.err.println("Cannot parse from string to date...");
////            }
////            return datestd;
//
//                try {
//                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//                    df.setLenient(false);
//                    return df.parse(date);
//                } catch (Exception e) {
//                    return null;
//                }
//            }
        
//        listFood.forEach(i -> {
//            i.getInfo();
//        });

//https://www.geeksforgeeks.org/collections-sort-java-examples/
