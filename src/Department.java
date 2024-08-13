/* =====> Là ĐỊNH NGHĨA CHO CLASS BỘ PHẬN
* chứa thông tin chung về bộ phận, bao gồm các thuộc tính và phương thức sau.

 - Thuộc tính: mã bộ phận, tên bộ phận, số lượng nhân viên hiện tại

 - Phương thức: toString() hiển thị thông tin về bộ phận.
* */

public class Department {
    private String maBoPhan;
    private String tenBoPhan;
    private int soLuongNhanVienHienTai;


    /* Constructor */
    public Department(String maBoPhan, String tenBoPhan, int soLuongNhanVienHienTai) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
        this.soLuongNhanVienHienTai = soLuongNhanVienHienTai;
    }

    /* Gettter + Setter */

    public String getMaBoPhan() {
        return maBoPhan;
    }                              // String maBoPhan

    public void setMaBoPhan(String maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }                            // String tenBoPhan

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public int getSoLuongNhanVienHienTai() {
        return soLuongNhanVienHienTai;
    }     // int soLuongNhanVienHienTai

    public void setSoLuongNhanVienHienTai(int soLuongNhanVienHienTai) {
        this.soLuongNhanVienHienTai = soLuongNhanVienHienTai;
    }

    /* toString */
    @Override
    public String toString() {
        return String.format("%1s %17s %6s %20s %14s %16s %14s", "|", tenBoPhan, "|", maBoPhan, "|", soLuongNhanVienHienTai, "|");
    }

    // Method dùng đề tăng số lượng nhân viên thêm (+1)
    public void themNhanVienMoi() {
        this.soLuongNhanVienHienTai = soLuongNhanVienHienTai + 1;
    }

}
