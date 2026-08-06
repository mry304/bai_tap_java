package chuong1;

public class lab2 {

     static class sinhVien{
        private String id;
        private String name;
        private double dcc;
        private double dgk;
        private double dck;
        private double tong;
         public sinhVien() {
         }

         public sinhVien(String id, String name, double dcc, double dgk, double dck) {
            this.id = id;
            this.name = name;
            this.dcc = dcc;
            this.dgk = dgk;
            this.dck = dck;
        }

        public double tinhDiemTong(){
             tong = dcc * 0.1 + dgk * 0.3 + dck * 0.6;
            return tong;
        }
        public void rank(){
             if(tong >= 8.5) System.out.println("A");
             else if(tong >= 7.0 && tong < 8.5) System.out.println("B");
             else if(tong >= 5.5 && tong < 7.0) System.out.println("C");
             else if(tong >= 4.0 && tong < 5.5) System.out.println("D");
             else if(tong < 4.0) System.out.println("F");

        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getDcc() {
            return dcc;
        }

        public double getDgk() {
            return dgk;
        }

        public double getDck() {
            return dck;
        }


         private boolean isValidScore(double score) {
             return score >= 0.0 && score <= 10.0;
         }

         // Cập nhật các hàm Setters
         public void setDcc(double dcc) {
             if (isValidScore(dcc)) {
                 this.dcc = dcc;
             } else {
                 System.out.println("Lỗi: Điểm CC (" + dcc + ") phải nằm trong khoảng 0 - 10!");
                 this.dcc = 0; // Hoặc ném Exception: throw new IllegalArgumentException("Điểm không hợp lệ");
             }
         }

         public void setDgk(double dgk) {
             if (isValidScore(dgk)) {
                 this.dgk = dgk;
             } else {
                 System.out.println("Lỗi: Điểm GK (" + dgk + ") phải nằm trong khoảng 0 - 10!");
                 this.dgk = 0;
             }
         }

         public void setDck(double dck) {
             if (isValidScore(dck)) {
                 this.dck = dck;
             } else {
                 System.out.println("Lỗi: Điểm CK (" + dck + ") phải nằm trong khoảng 0 - 10!");
                 this.dck = 0;
             }
         }
    }

    public static void main(String[] args) {
        sinhVien sinhVien1 = new sinhVien("01", "binh", 8, 7, 9);
        double tong = sinhVien1.tinhDiemTong();
        System.out.println(tong);
        sinhVien1.rank();
    }
}
