/*
 * Class Abstract chứa các thông tin cơ bản của nhân viên,
 * hàm displayInformation() là hàm abstract, các class kế thừa triển khai hiện thị thông tin phù hợp
 * Thuộc tính: mã nhân viên, tên nhân viên, tuổi nhân viên, hệ số lương, ngày vào làm, bộ phận làm việc, số ngày nghỉ phép
 * */

public abstract class Staff implements ICalculator {
    protected String maNhanVien;
    protected String tenNhanVien;
    protected int tuoiNhanVien;
    protected int heSoLuong;
    protected String ngayVaoLam;
    protected String boPhanLamViec;
    protected int soNgayNghiPhep;


    // Constructor có tham số
    public Staff(String maNhanVien, String tenNhanVien, int tuoiNhanVien, int heSoLuong, String ngayVaoLam, String boPhanLamViec, int soNgayNghiPhep) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.tuoiNhanVien = tuoiNhanVien;
        this.heSoLuong = heSoLuong;
        this.ngayVaoLam = ngayVaoLam;
        this.boPhanLamViec = boPhanLamViec;
        this.soNgayNghiPhep = soNgayNghiPhep;
    }


    /* Getter + Setter */
    public String getMaNhanVien() {                         // String maNhanVien
        return maNhanVien;
    }                                  // String maNhanVien

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {                        // String tenNhanVien
        return tenNhanVien;
    }                                // String tenNhanVien

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public int getTuoiNhanVien() {                          // int tuoiNhanVien
        return tuoiNhanVien;
    }                                 // int tuoiNhanVien

    public void setTuoiNhanVien(int tuoiNhanVien) {
        this.tuoiNhanVien = tuoiNhanVien;
    }

    public int getHeSoLuong() {                             // int heSoLuong
        return heSoLuong;
    }                                       // int heSoLuong

    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public String getNgayVaoLam() {                            // int ngayVaoLam
        return ngayVaoLam;
    }                                  // String ngayVaoLam

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getBoPhanLamViec() {                      // String boPhanLamViec
        return boPhanLamViec;
    }                            // String boPhanLamViec

    public void setBoPhanLamViec(String boPhanLamViec) {
        this.boPhanLamViec = boPhanLamViec;
    }

    public int getSoNgayNghiPhep() {                        // int soNgayNghiPhep
        return soNgayNghiPhep;
    }                             // int soNgayNghiPhep

    public void setSoNgayNghiPhep(int soNgayNghiPhep) {
        this.soNgayNghiPhep = soNgayNghiPhep;
    }

    /* Abstract methods */
    public abstract int getEmployeeSalary();

    public abstract void setEmployeeSalary(int employeeSalary);

    public abstract void displayInformation();

    // TRANG TRÍ: Dùng để display only -> Thông Tin Lương
    public abstract void displaySalaryInformation();
}


