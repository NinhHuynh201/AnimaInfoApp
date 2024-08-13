/* =======> Là CLASS CHỨA LUỒNG CHÍNH CỦA CHƯƠNG TRÌNH
* chứa thông tin chung về nhân viên, bao gồm các thuộc tính và phương thức sau.

 - Tạo ra hàm main để xử lý luồng chính của chương trình

 - Chỉ sử dụng duy nhất ArrayList để quản lý toàn bộ nhân viên trong công ty bao gồm cả nhân viên và quản lý.

 - Dùng vòng lặp do…while để cho phép người dùng chọn lại chức năng

 - Triển khai các chương trình theo yêu cầu
* */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class HumanResources {

    static Scanner input = new Scanner(System.in);
    final static ArrayList<Staff> staffList = new ArrayList<>();
    final static ArrayList<Department> departmentList = new ArrayList<>();

    public static void main(String[] args) {

        // Thêm staff vào sẵn để tiện review
        staffList.add(new Employee("employee001", "employeename1", 20, 1, "01/02/2021", "Marketing", 0, 0));
        staffList.add(new Manager("manager001", "managername1", 30, 2, "01/01/2021", "Marketing", 0, "Business Leader"));
        staffList.add(new Employee("employee002", "employeename2", 20, 2, "02/02/2021", "Media", 0, 0));
        staffList.add(new Manager("manager003", "managername3", 30, 2, "03/01/2021", "Developer", 0, "Technical Leader"));
        staffList.add(new Employee("employee003", "employeename3", 20, 3, "03/02/2021", "Developer", 0, 0));
        staffList.add(new Manager("manager002", "managername2", 30, 2, "02/01/2021", "Media", 0, "Project Leader"));


        // Thêm department vào sẵn để tiện review
        departmentList.add(new Department("A101", "Marketing", 2));
        departmentList.add(new Department("B101", "Media", 2));
        departmentList.add(new Department("C101", "Developer", 2));


        boolean check = true;  // Biến dùng để vận hành vòng lặp do-while


        // Do-while loop chạy chương trình
        do {
            menu();
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(input.nextLine());
            System.out.println();

            switch (choice) {
                // Hiển thị danh sách nhân viên hiện có trong công ty
                case 1 -> {
                    hangNgangTrangTriDayDuThongTin();
                    hienThiDanhSachNhanVienHienCoTrongCongTy();
                }

                // Hiển thị các bộ phận trong công ty
                case 2 -> hienThiCacBoPhanTrongCongTy();

                // Hiển thị các nhân viên theo từng bộ phận
                case 3 -> hienThiCacNhanVienTheoBoPhan();

                // Thêm nhân viên mới vào công ty: bao gồm 2 loại ( 1-Thêm nhân viên thông thường; 2- Thêm nhân viên là cấp quản lý (có thêm chức vụ))
                case 4 -> themNhanVienMoiVaoCongTy();

                // Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên
                case 5 -> timKiemThongTinNhanVien();

                // NÂNG CAO: Hiển thị bảng lương của nhân viên toàn công ty GIẢM DẦN
                case 6 -> {
                    tinhLuong();
                    displaySalaryInformationRow();  // Mục đích: Trang trí
                    hienThiLuongTheoThuTuGiamDan();
                }

                // NÂNG CAO: Hiển thị bảng lương của nhân viên theo thứ tự TĂNG DẦN
                case 7 -> {
                    tinhLuong();
                    displaySalaryInformationRow();  // Mục đích: Trang trí
                    hienThiLuongTheoThuTuTangDan();
                }

                // Kết thúc chương trình
                case 0 -> {
                    System.out.println("Tạm biệt! Chúc bạn luôn khỏe mạnh!");
                    check = false;
                }

                // Mặc định: chọn lại
                default -> System.out.println("ERROR: Số " + choice + " không có trong danh sách.\nVui lòng nhập lại số tương ứng với danh sách!\n");
            }
        } while (check);

    }

    /* Danh sách các chức năng chính */
    public static void menu() {
        System.out.println("Hãy chọn số tương ứng với những chức năng sau:");
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
        System.out.println("2. Hiển thị các bộ phận trong công ty");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
        System.out.println("4. Thêm nhân viên mới vào công ty:");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
        System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
        System.out.println("0. Kết thúc chương trình");
    }

    /* Chức năng 1 : Hiển thị danh sách nhân viên hiện có trong công ty */
    public static void hienThiDanhSachNhanVienHienCoTrongCongTy() {
        for (Staff staff : staffList) {
            staff.displayInformation();
        }
        System.out.println();
    }

    /* Chức năng 2 : Hiển thị các bộ phận trong công ty */
    public static void hienThiCacBoPhanTrongCongTy() {
        System.out.println("Các bộ phận trong công ty:");
        hangNgangTrangTriCacBoPhanTrongCongTy();  // Trang trí

        for (Department department : departmentList) {
            System.out.println(department);
        }
        System.out.println();
    }

    /* Chức năng 3 : Hiển thị các nhân viên theo từng bộ phận */
    public static void hienThiCacNhanVienTheoBoPhan() {
        boolean showStaffChoiceBoolean = true;  //  Biến boolean để vận hành loop do-while
        do {
            System.out.println("Xin chọn bộ phận:");
            System.out.println("  [0] Quay lại!");
            System.out.println("  [1] Marketing \n  [2] Media \n  [3] Developer");
            System.out.print("Nhập số: ");
            int chonBoPhan = Integer.parseInt(input.nextLine());  // Nhập số

            //Xét điệu kiện
            switch (chonBoPhan) {
                case 0:
                    showStaffChoiceBoolean = false;  // Kết thúc & Quay lại danh sách chức năng chính
                case 1:
                    System.out.print("                                                                   ");
                    System.out.print("                   ");
                    System.out.println("DANH SÁCH NHÂN VIÊN CỦA BỘ NHẬN \"MARKETING\"");
                    hangNgangTrangTriDayDuThongTin();         // Trang trí
                    for (Staff staff : staffList) {
                        if (staff.getBoPhanLamViec().equalsIgnoreCase("Marketing")) {
                            staff.displayInformation();
                        }
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.print("                                                                   ");
                    System.out.print("                   ");
                    System.out.println("DANH SÁCH NHÂN VIÊN CỦA BỘ NHẬN \"MEDIA\"");
                    hangNgangTrangTriDayDuThongTin();         // Trang trí
                    for (Staff staff : staffList) {
                        if (staff.getBoPhanLamViec().equalsIgnoreCase("Media")) {
                            staff.displayInformation();
                        }
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("                                                                   ");
                    System.out.print("                   ");
                    System.out.println("DANH SÁCH NHÂN VIÊN CỦA BỘ NHẬN \"DEVELOPER\"");
                    hangNgangTrangTriDayDuThongTin();         // Trang trí
                    for (Staff staff : staffList) {
                        if (staff.getBoPhanLamViec().equalsIgnoreCase("Developer")) {
                            staff.displayInformation();
                        }
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("\nERROR: Số " + chonBoPhan + " không nằm trong danh sách.\nBạn vui lòng chọn lại số!\n");
            }
        } while (showStaffChoiceBoolean);
        System.out.println();
    }

    /* Chức năng 4 : Thêm nhân viên mới vào công ty: bao gồm 2 loại ( 1-Thêm nhân viên thông thường; 2- Thêm nhân viên là cấp quản lý (có thêm chức vụ)) */
    public static void themNhanVienMoiVaoCongTy() {

        boolean addStaffChoiceBoolean = true;      //  Biến boolean để vận hành loop do-while

        do {
            System.out.println("Xin chọn số tương ứng với các chức năng sau: ");
            System.out.println("  [0] Quay lại! ");
            System.out.println("  [1] Thêm nhân viên thông thường");
            System.out.println("  [2] Thêm nhân viên là cấp quản lý");
            System.out.print("Bạn chọn số: ");
            int addElementChoice = Integer.parseInt(input.nextLine());// Biến chứa lựa chọn chức năng

            // Xét điều kiện
            switch (addElementChoice) {
                // Kết thúc & Quay lại danh sách chức năng chính
                case 0 -> addStaffChoiceBoolean = false;

                // Thêm nhân viên thông thường
                case 1 -> {
                    System.out.println("Nhập mã số nhân viên: ");
                    String maNV = input.next();

                    System.out.println("Nhập tên nhân viên: ");
                    String tenNV = input.next();

                    System.out.println("Nhập tuổi nhân viên: ");
                    int tuoiNV = Integer.parseInt(input.nextLine());

                    System.out.println("Nhập hệ số lương của nhân viên: ");
                    int heSoLuong = Integer.parseInt(input.nextLine());

                    System.out.println("Nhập ngày vào làm (DD/MM/YYYY): ");
                    String ngayVaoLam = input.next();

                    System.out.println("Chọn bộ phận làm việc của nhân viên: ");

                    String employeeJob = "";    // Biến sẽ chuyển thành tên bộ phận làm việc tương ứng

                    boolean employeeJobChoiceBoolean = true;  // Biến boolean để vận hành loop do-while
                    do {
                        System.out.println("  (1) Marketing \n  (2) Media \n  (3) Developer");
                        System.out.print("Nhập số: ");
                        int employeeJobChoice = Integer.parseInt(input.nextLine());   // Chọn SỐ tương ứng với bộ phận làm việc

                        switch (employeeJobChoice) {
                            case 1 -> {
                                employeeJob = "Marketing";
                                employeeJobChoiceBoolean = false;
                            }
                            case 2 -> {
                                employeeJob = "Media";
                                employeeJobChoiceBoolean = false;
                            }
                            case 3 -> {
                                employeeJob = "Developer";
                                employeeJobChoiceBoolean = false;
                            }
                            default -> System.out.println("\nERROR: Số " + employeeJobChoice + " không nằm trong danh sách.\nBạn vui lòng chọn lại số!\n");
                        }

                    } while (employeeJobChoiceBoolean);

                    System.out.println("Nhập số ngày nghỉ phép: ");
                    int soNgayNghiPhep = Integer.parseInt(input.nextLine());

                    System.out.println("Nhập số giờ làm thêm : ");
                    int soGioLamThem = Integer.parseInt(input.nextLine());

                    // Thêm vào ArrayList staffList (Mã và Tên của nhân viên sẽ được lower case)
                    staffList.add(new Employee(maNV.toLowerCase(), tenNV.toLowerCase(), tuoiNV, heSoLuong, ngayVaoLam, employeeJob, soNgayNghiPhep, soGioLamThem));

                    // Tăng số lượng nhân viên hiện tại lên
                    for (Department department : departmentList) {
                        if (department.getTenBoPhan().equalsIgnoreCase(employeeJob)) {
                            department.themNhanVienMoi();
                        }
                    }
                }

                // Thêm nhân viên là cấp quản lý (có thêm chức vụ)
                case 2 -> {
                    System.out.println("Nhập mã số quản lý: ");
                    String managerID = input.next();

                    System.out.println("Nhập tên quản lý: ");
                    String managerName = input.next();

                    System.out.println("Nhập tuổi quản lý: ");
                    int managerAge = Integer.parseInt(input.nextLine());

                    System.out.println("Nhập hệ số lương của quản lý: ");
                    int managerSalaryScale = Integer.parseInt(input.nextLine());

                    System.out.println("Nhập ngày vào làm của quản lý (DD/MM/YYYY): ");
                    String managerStartWorkedDay = input.next();


                    System.out.println("Chọn bộ phận làm việc của nhân viên: ");
                    String managerJob = "";                       // Biến sẽ chuyển thành tên bộ phận làm việc tương ứng

                    boolean managerJobChoiceBoolean = true;       // Biến boolean để vận hành loop do-while
                    do {
                        System.out.println("  (1) Marketing \n  (2) Media \n  (3) Developer");
                        System.out.print("Nhập số: ");
                        int managerJobChoice = Integer.parseInt(input.nextLine());   // Nhập SỐ tương ứng với bộ phận làm việc

                        switch (managerJobChoice) {
                            case 1 -> {
                                managerJob = "Marketing";
                                managerJobChoiceBoolean = false;
                            }
                            case 2 -> {
                                managerJob = "Media";
                                managerJobChoiceBoolean = false;
                            }
                            case 3 -> {
                                managerJob = "Developer";
                                managerJobChoiceBoolean = false;
                            }
                            default -> System.out.println("\nERROR: Số " + managerJobChoice + " không nằm trong danh sách.\nBạn vui lòng chọn lại số!\n");
                        }

                    } while (managerJobChoiceBoolean);


                    System.out.println("Nhập số ngày nghỉ phép: ");
                    int staffNumberOfDayOff = Integer.parseInt(input.nextLine());

                    System.out.println("Chọn chức danh: ");
                    String managerPosition = "";                  // Biến sẽ chuyển thành tên chức danh tương ứng

                    boolean managerPositionChoiceBoolean = true;  // Biến boolean để vận hành loop do-while
                    do {
                        System.out.println("  (1) Business Leader \n  (2) Project Leader \n  (3) Technical Leader");
                        System.out.print("Nhập số: ");
                        int managerPositionChoice = Integer.parseInt(input.nextLine());  // Chọn số tương ứng với chức danh

                        switch (managerPositionChoice) {
                            case 1 -> {
                                managerPosition = "Business Leader";
                                managerPositionChoiceBoolean = false;
                            }
                            case 2 -> {
                                managerPosition = "Project Leader";
                                managerPositionChoiceBoolean = false;
                            }
                            case 3 -> {
                                managerPosition = "Technical Leader";
                                managerPositionChoiceBoolean = false;
                            }
                            default -> System.out.println("\nERROR: Số " + managerPositionChoice + " không nằm trong danh sách.\nBạn vui lòng chọn lại số!\n");
                        }
                    } while (managerPositionChoiceBoolean);


                    // Bỏ vào ArrayList staffList (Mã và Tên của manager sẽ được lower case)
                    staffList.add(new Manager(managerID.toLowerCase(), managerName.toLowerCase(), managerAge, managerSalaryScale, managerStartWorkedDay, managerJob, staffNumberOfDayOff, managerPosition));

                    // Tăng số lượng nhân viên hiện tại lên
                    for (Department department : departmentList) {
                        if (department.getTenBoPhan().equalsIgnoreCase(managerJob)) {
                            department.themNhanVienMoi();
                        }
                    }
                }

                // Mặc định: Kêu User nhập lại số (nếu không chọn đúng số)
                default -> System.out.println("\nERROR: Số " + addElementChoice + " không nằm trong danh sách.\nBạn vui lòng chọn lại số!\n");

            }
        } while (addStaffChoiceBoolean);
        System.out.println();
    }

    /* Chức năng 5 : Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên */
    public static void timKiemThongTinNhanVien() {
        boolean searchStaffChoiceBoolean = true;  //  Biến boolean để vận hành loop do-while
        do {
            System.out.println("Xin chọn số tương ứng với các chức năng sau: ");
            System.out.println("  [0] Quay lại!");
            System.out.println("  [1] Tìm kiếm thông tin nhân viên theo tên");
            System.out.println("  [2] Tìm kiếm thông tin nhân viên theo mã nhân viên");
            System.out.print("Bạn chọn số: ");
            int searchStaffChoice = Integer.parseInt(input.nextLine());   // Nhập dữ liệu chứa lựa chọn của User

            // Để xét điều kiện
            switch (searchStaffChoice) {
                // Kết thúc & Quay lại danh sách chức năng chính
                case 0 -> searchStaffChoiceBoolean = false;

                // Tìm kiếm theo TÊN
                case 1 -> {
                    System.out.println("Nhập tên nhân viên:");
                    String searchStaffName = input.next();
                    int soLuongNhanVienHienThiRa = 0;

                    for (Staff staff : staffList) {
                        if (staff.getTenNhanVien().equalsIgnoreCase(searchStaffName.toLowerCase())) {
                            hangNgangTrangTriDayDuThongTin();  // Mục đích: Trang trí
                            staff.displayInformation();
                            soLuongNhanVienHienThiRa++; // biến sẽ được thay đổi KHI tìm thấy tên nhân viên trong danh sách
                        }
                    }
                    System.out.println();

                    // Nếu biến không thay đổi (nghĩa là không tìm thấy tên) thì hiện thông báo dưới đây
                    if (soLuongNhanVienHienThiRa == 0) {
                        System.out.println("Tên nhân viên \"" + searchStaffName + "\"" + " không tồn tại");
                    }
                }

                // Tìm kiếm theo MÃ
                case 2 -> {
                    System.out.println("Nhập mã nhân viên:");
                    String searchStaffID = input.next();
                    int soLuongNhanVienHienThiRa = 0;

                    for (Staff staff : staffList) {
                        if (staff.getMaNhanVien().equalsIgnoreCase(searchStaffID.toLowerCase())) {
                            hangNgangTrangTriDayDuThongTin();
                            staff.displayInformation();
                            soLuongNhanVienHienThiRa++; // biến sẽ được thay đổi KHI tìm thấy mã nhân viên trong danh sách
                        }
                    }
                    System.out.println();

                    // Nếu biến không thay đổi (nghĩa là không tìm thấy tên) thì hiện thông báo dưới đây
                    if (soLuongNhanVienHienThiRa == 0) {
                        System.out.println("Mã nhân viên \"" + searchStaffID + "\"" + " không tồn tại");
                    }
                }

                // Mặc định: Kêu User nhập lại số (nếu không chọn đúng số)
                default -> System.out.println("\nERROR: Số " + searchStaffChoice + " không nằm trong danh sách.\nBạn vui lòng chọn lại số!\n");
            }
        } while (searchStaffChoiceBoolean);
        System.out.println();
    }

    /* Tính lương */
    public static void tinhLuong() {
        for (Staff staff : staffList) {
            staff.calculateSalary();
        }
    }

    /* Chức năng 6 : Hiển thị bảng lương của nhân viên toàn công ty GIẢM DẦN */
    public static void hienThiLuongTheoThuTuGiamDan() {
        // Dùng Comparator để sắp xếp ArrayList staffList (theo Giảm Dần)
        staffList.sort(Comparator.comparingInt(Staff::getEmployeeSalary).reversed());

        for (Staff staff : staffList) {
            staff.displaySalaryInformation();
        }
        System.out.println();
    }

    /* Chức năng 7 : Hiển thị bảng lương của nhân viên toàn công ty TĂNG DẦN */
    public static void hienThiLuongTheoThuTuTangDan() {
        // Dùng Comparator để sắp xếp ArrayList staffList (theo Tăng Dần)
        staffList.sort(Comparator.comparingInt(Staff::getEmployeeSalary));

        for (Staff staff : staffList) {
            staff.displaySalaryInformation();
        }
        System.out.println();
    }

    /* TRANG TRÍ: Hàng ngang trình bày full thông tin của chức năng 1 */
    public static void hangNgangTrangTriDayDuThongTin() {
        for (int i = 1; i < 217; i++) {
            System.out.print("-");
        }
        System.out.println();
        String fomatString = "%1s %17s %6s %23s %11s %15S %2s %12s %2s %15s %4s %20s %5s %18s %2s %16s %2s %18s %9s";
        System.out.printf(fomatString, "|", "MÃ NHÂN VIÊN", "|", "TÊN NHÂN VIÊN", "|", "TUỔI NHÂN VIÊN", "|", "HỆ SỐ LƯƠNG", "|", "NGÀY VÀO LÀM", "|", "BỘ PHẬN LÀM VIỆC", "|", "SỐ NGÀY NGHỈ PHÉP", "|", "SỐ GIỜ LÀM THÊM", "|", "CHỨC DANH", "|");
        System.out.println();
        for (int i = 1; i < 217; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /* TRANG TRÍ: Hàng ngang trình bày các bộ phận trong công ty của chức năng 2 */
    public static void hangNgangTrangTriCacBoPhanTrongCongTy() {
        for (int i = 1; i < 95; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("%1s %17s %6s %23s %11s %28s %2s", "|", "TÊN BỘ PHẬN", "|", "MÃ BỘ PHẬN", "|", "SỐ LƯỢNG NHÂN VIÊN HIỆN TẠI", "|");
        System.out.println();
        for (int i = 1; i < 95; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /* TRANG TRÍ: Hàng ngang trình bày thông tin lương */
    public static void displaySalaryInformationRow() {
        for (int i = 1; i < 91; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("%1s %17s %6s %23s %11s %20s %6s", "|", "MÃ NHÂN VIÊN", "|", "TÊN NHÂN VIÊN", "|", "THÔNG TIN LƯƠNG", "|");
        System.out.println();
        for (int i = 1; i < 91; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

