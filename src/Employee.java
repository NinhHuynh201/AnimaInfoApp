/* =====> lÀ ĐỊNH NGHĨA CHO CLASS NHÂN VIÊN
* chứa thông tin chung về nhân viên, bao gồm các thuộc tính và phương thức sau.
*  - Thuộc tính: số giờ làm thêm
   - Phương thức: calculateSalary() trả về lương nhân viên, displayInformation() hiển thị thông tin nhân viên.
   - Employee kế thừa class Staff
* */

public class Employee extends Staff {
    protected int soGioLamThem;
    protected int employeeSalary;

    /* Constructor có tham số */
    public Employee(String maNhanVien, String tenNhanVien, int tuoiNhanVien, int heSoLuong, String ngayVaoLam, String boPhanLamViec, int soNgayNghiPhep, int soGioLamThem) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep);
        this.soGioLamThem = soGioLamThem;
    }


    /* Getter + Setter */
    // int soGioLamThem
    public int getSoGioLamThem() {
        return soGioLamThem; 
    }

    public void setSoGioLamThem(int soGioLamThem) {
        this.soGioLamThem = soGioLamThem;
    }

    // Hàm tính lương implement từ file ICalculater.java
    public void calculateSalary() {
        employeeSalary = heSoLuong * 3000000 + soGioLamThem * 200000;
    }

    // Abstract method từ file Staff.java
    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public void displayInformation() {
        String fomatString = "%1s %17s %6s %23s %11s %10S %7s %7s %7s %14s %5s %16s %9s %10s %10s %10s %8s %28s";
        System.out.printf(fomatString, "|", maNhanVien, "|", tenNhanVien, "|", tuoiNhanVien, "|", heSoLuong, "|", ngayVaoLam, "|", boPhanLamViec, "|", soNgayNghiPhep, "|", soGioLamThem, "|", "|");
        System.out.println();
    }

    // TRANG TRÍ: Dùng để display only -> Thông Tin Lương
    public void displaySalaryInformation() {
        String fomatString = "%1s %17s %6s %23s %11s %16s %10s";
        System.out.printf(fomatString, "|", maNhanVien, "|", tenNhanVien, "|", employeeSalary, "|");
        System.out.println();
    }
}
