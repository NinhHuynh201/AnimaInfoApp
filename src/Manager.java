/* =====> Là ĐỊNH NGHĨA CHO QUẢN LÝ
*  chứa thông tin chung về quản lý, bao gồm các thuộc tính và phương thức sau.

 -  Thừa kế: Manager cũng là nhân viên, nên sẽ thừa kế từ class Staff.

 - Thuộc tính: chức danh

 -  Phương thức: displayInformation() hiển thị thông tin bao gồm cả chức danh
* */

public class Manager extends Staff {
    protected String chucDanh;
    protected int employeeSalary;

    /* Constructor có tham số */
    public Manager(String maNhanVien, String tenNhanVien, int tuoiNhanVien, int heSoLuong, String ngayVaoLam, String boPhanLamViec, int soNgayNghiPhep, String chucDanh) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep);
        this.chucDanh = chucDanh;
    }

    /* Getter + Setter */
    public String getChucDanh() {                // String chucDanh
        return chucDanh;
    }                        // String chucDanh

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    // Hàm tính lương implement từ file ICalculater.java
    public void calculateSalary() {
        int luongTrachNhiem;
        if (chucDanh.equalsIgnoreCase("Business Leader")) {
            luongTrachNhiem = 8000000;
        } else if (chucDanh.equalsIgnoreCase("Project Leader")) {
            luongTrachNhiem = 5000000;
        } else {
            luongTrachNhiem = 6000000;
        }

        employeeSalary = heSoLuong * 5000000 + luongTrachNhiem;
    }

    // Abstract method từ file Staff.java
    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public void displayInformation() {
        String fomatString = "%1s %17s %6s %23s %11s %10S %7s %7s %7s %14s %5s %16s %9s %10s %10s %19s %22s %5s";
        System.out.printf(fomatString, "|", maNhanVien, "|", tenNhanVien, "|", tuoiNhanVien, "|", heSoLuong, "|", ngayVaoLam, "|", boPhanLamViec, "|", soNgayNghiPhep, "|", "|", chucDanh, "|");
        System.out.println();
    }

    // TRANG TRÍ: Dùng để display only -> Thông Tin Lương
    public void displaySalaryInformation() {
        String fomatString = "%1s %17s %6s %23s %11s %16s %10s";
        System.out.printf(fomatString, "|", maNhanVien, "|", tenNhanVien, "|", employeeSalary, "|");
        System.out.println();
    }

}


