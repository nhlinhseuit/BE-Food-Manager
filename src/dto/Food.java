
//dto là package dùng để lưu tất cả các đối tượng
package dto;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Food {
    //ID, name, weight, type, place, expired date
    //constructor - getter - setter
    
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    private String id, name, type, place;
    private Date expiredDate;
    private float weight;
    
    
    public Food(String id, String name, String type, String place, Date expiredDate, float weight) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
        this.weight = weight;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPlace() {
        return place;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public float getWeight() {
        return weight;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", name=" + name + ", type=" + type + ", place=" + place + ", expiredDate=" + expiredDate + ", weight=" + weight + '}';
    }
    
    public void getInfo() {
        System.out.printf("%20s %20s %20s %20s %20s %25s\n" , getId(), getName(), getWeight(), getType(), getPlace(), df.format(getExpiredDate()));
    }
    
}
