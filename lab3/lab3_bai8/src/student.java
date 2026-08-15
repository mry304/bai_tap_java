public class student {
    private int id;
    private String name;
    private double point;

    public student(int id, String name, double point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String rank(){
        if(point >= 8.5) return "Gioi";
        else if(point >= 7 && point < 8.5) return "Kha";
        else if(point >= 5 && point < 7) return "Trung binh";
        return "";
    }
}
