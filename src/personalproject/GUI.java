package personalproject;

import javax.swing.*;
import java.awt.*;

public class GUI {

        public static void main (String[] args) {
            // Tạo cửa sổ chính
            JFrame frame = new JFrame("Hotel Booking Management"); // Tạo frame với tiêu đề "Hotel Booking Management"
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Thiết lập hành động đóng cửa sổ để thoát chương trình
            frame.setSize(700, 500); // Thiết lập kích thước cửa sổ
            frame.setLayout(new BorderLayout()); // Sử dụng bố cục BorderLayout

            // Tạo tiêu đề chính
            JLabel title = new JLabel("Hotel Booking Management", SwingConstants.CENTER); // Tiêu đề trung tâm của ứng dụng
            title.setFont(new Font("Arial", Font.BOLD, 24)); // Đặt font chữ cho tiêu đề
            title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10)); // Đặt khoảng cách viền
            frame.add(title, BorderLayout.NORTH); // Thêm tiêu đề vào phía trên của frame

            // Tạo bảng điều khiển cho các trường nhập liệu
            JPanel formPanel = new JPanel(); // Tạo JPanel để chứa các trường nhập liệu
            formPanel.setLayout(new GridLayout(6, 2, 10, 10)); // Sử dụng bố cục lưới 6x2
            formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Đặt viền cho panel

            // Thêm các trường nhập liệu và nhãn
            formPanel.add(new JLabel("Customer Name:")); // Nhãn cho tên khách hàng
            JTextField customerNameField = new JTextField(); // Trường nhập liệu cho tên khách hàng
            formPanel.add(customerNameField);

            formPanel.add(new JLabel("Phone Number:")); // Nhãn cho số điện thoại
            JTextField phoneNumberField = new JTextField(); // Trường nhập liệu cho số điện thoại
            formPanel.add(phoneNumberField);

            formPanel.add(new JLabel("Room Type:")); // Nhãn cho loại phòng
            String[] roomTypes = {"Single", "Double", "Suite"}; // Danh sách loại phòng
            JComboBox<String> roomTypeBox = new JComboBox<>(roomTypes); // Hộp thả xuống chọn loại phòng
            formPanel.add(roomTypeBox);

            formPanel.add(new JLabel("Check-in Date:")); // Nhãn cho ngày check-in
            JTextField checkInField = new JTextField("YYYY-MM-DD"); // Trường nhập liệu cho ngày check-in
            formPanel.add(checkInField);

            formPanel.add(new JLabel("Check-out Date:")); // Nhãn cho ngày check-out
            JTextField checkOutField = new JTextField("YYYY-MM-DD"); // Trường nhập liệu cho ngày check-out
            formPanel.add(checkOutField);

            formPanel.add(new JLabel("Number of Guests:")); // Nhãn cho số lượng khách
            JTextField guestsField = new JTextField(); // Trường nhập liệu cho số lượng khách
            formPanel.add(guestsField);

            frame.add(formPanel, BorderLayout.CENTER); // Thêm bảng điều khiển vào trung tâm của frame

            // Tạo bảng điều khiển cho các nút bấm
            JPanel buttonPanel = new JPanel(); // Tạo JPanel cho các nút bấm
            buttonPanel.setLayout(new GridLayout(1, 3, 10, 10)); // Sử dụng bố cục lưới 1x3
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Đặt viền cho panel

            // Thêm các nút bấm
            JButton bookButton = new JButton("Book Room"); // Nút đặt phòng
            JButton resetButton = new JButton("Reset"); // Nút làm mới
            JButton exitButton = new JButton("Exit"); // Nút thoát

            buttonPanel.add(bookButton); // Thêm nút đặt phòng vào panel
            buttonPanel.add(resetButton); // Thêm nút làm mới vào panel
            buttonPanel.add(exitButton); // Thêm nút thoát vào panel

            frame.add(buttonPanel, BorderLayout.SOUTH); // Thêm bảng điều khiển nút bấm vào phía dưới của frame

            // Định nghĩa hành động cho các nút bấm
            bookButton.addActionListener(e -> {
                String customerName = customerNameField.getText(); // Lấy tên khách hàng
                String phoneNumber = phoneNumberField.getText(); // Lấy số điện thoại
                String roomType = (String) roomTypeBox.getSelectedItem(); // Lấy loại phòng
                String checkInDate = checkInField.getText(); // Lấy ngày check-in
                String checkOutDate = checkOutField.getText(); // Lấy ngày check-out
                String guests = guestsField.getText(); // Lấy số lượng khách

                // Kiểm tra nếu có trường nào trống
                if (customerName.isEmpty() || phoneNumber.isEmpty() || checkInDate.isEmpty() || checkOutDate.isEmpty() || guests.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE); // Hiển thị lỗi nếu trường trống
                } else {
                    JOptionPane.showMessageDialog(frame, "Booking Successful!\nCustomer: " + customerName
                            + "\nPhone: " + phoneNumber
                            + "\nRoom: " + roomType
                            + "\nCheck-in: " + checkInDate
                            + "\nCheck-out: " + checkOutDate
                            + "\nGuests: " + guests, "Booking Confirmation", JOptionPane.INFORMATION_MESSAGE); // Hiển thị thông báo thành công
                }
            });

            resetButton.addActionListener(e -> {
                customerNameField.setText(""); // Xóa dữ liệu trong trường tên khách hàng
                phoneNumberField.setText(""); // Xóa dữ liệu trong trường số điện thoại
                roomTypeBox.setSelectedIndex(0); // Đặt lại loại phòng về mặc định
                checkInField.setText("YYYY-MM-DD"); // Đặt lại ngày check-in về mặc định
                checkOutField.setText("YYYY-MM-DD"); // Đặt lại ngày check-out về mặc định
                guestsField.setText(""); // Xóa dữ liệu trong trường số lượng khách
            });

            exitButton.addActionListener(e -> System.exit(0)); // Thoát chương trình khi nhấn nút thoát

            // Hiển thị cửa sổ
            frame.setVisible(true); // Hiển thị frame
        }
    }