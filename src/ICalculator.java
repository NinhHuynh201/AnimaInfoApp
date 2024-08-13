/*
*  chứa hàm tính lương, các class nhân viên và quản lý implement interface để tính lương phù hợp
*  Nhân viên: Hệ số lương * 3,000,000 + số giờ làm thêm * 200,000
   Quản lý: Hệ số lương * 5,000,000 + lương trách nhiệm

    Lương trách nhiệm:
    Business Leader = 8,000,000
    Project Leader = 5,000,000
    Technical Leader = 6,000,000
* */

interface ICalculator {
    default void calculateSalary() {
    }
}
