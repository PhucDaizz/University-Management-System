-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 27, 2024 lúc 01:47 PM
-- Phiên bản máy phục vụ: 10.4.14-MariaDB
-- Phiên bản PHP: 7.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `universitymanagement`
--
CREATE DATABASE `universitymanagement`;
-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `fee`
--

CREATE TABLE `fee` (
  `course` varchar(20) DEFAULT NULL,
  `semester1` varchar(20) DEFAULT NULL,
  `semester2` varchar(20) DEFAULT NULL,
  `semester3` varchar(20) DEFAULT NULL,
  `semester4` varchar(20) DEFAULT NULL,
  `semester5` varchar(20) DEFAULT NULL,
  `semester6` varchar(20) DEFAULT NULL,
  `semester7` varchar(20) DEFAULT NULL,
  `semester8` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `fee`
--

INSERT INTO `fee` (`course`, `semester1`, `semester2`, `semester3`, `semester4`, `semester5`, `semester6`, `semester7`, `semester8`) VALUES
('Lịch Sử Đảng', '49000', '43000', '43000', '43000', '43000', '43000', '43000', '43000'),
('Đại số', '44000', '35000', '35000', '35000', '35000', '35000', '', ''),
('Thể chất', '39000', '34000', '34000', '34000', '34000', '34000', '', ''),
('Tin học cơ bản', '70000', '60000', '60000', '60000', '', '', '', ''),
('Mạng', '44000', '45000', '45000', '45000', '', '', '', ''),
('Cơ sở sữ liệu', '66000', '42000', '42000', '49000', '', '', '', ''),
('Triết', '32000', '20000', '20000', '20000', '20000', '20000', '12000', ''),
('Lập Trình Mạng', '46000', '30000', '30000', '30000', '', '', '', ''),
('Tiếng anh', '50000', '52000', '53000', '54000', '55000', '56000', '57000', '58000'),
('Hóa học đại cương', '52000', '51000', '50000', '50000', '52000', '53000', '54000', '55000'),
('Vật lý cơ bản', '45000', '46000', '47000', '47000', '48000', '49000', '50000', '51000'),
('Kỹ thuật số', '60000', '58000', '59000', '60000', '61000', '62000', '63000', '64000'),
('Hệ điều hành', '70000', '68000', '69000', '71000', '72000', '73000', '74000', '75000'),
('Quản lý dự án', '48000', '47000', '46000', '46000', '47000', '48000', '49000', '50000'),
('Kinh tế học', '53000', '52000', '51000', '52000', '53000', '54000', '55000', '56000'),
('Kỹ thuật mạng', '49000', '50000', '51000', '52000', '53000', '54000', '55000', '56000'),
('Phân tích dữ liệu', '65000', '64000', '63000', '64000', '65000', '66000', '67000', '68000'),
('Máy học', '68000', '67000', '66000', '67000', '68000', '69000', '70000', '71000'),
('Phát triển phần mềm', '56000', '55000', '54000', '55000', '56000', '57000', '58000', '59000'),
('Thống kê ứng dụng', '54000', '53000', '52000', '53000', '54000', '55000', '56000', '57000'),
('Thiết kế giao diện', '50000', '49000', '48000', '49000', '50000', '51000', '52000', '53000'),
('Điện tử cơ bản', '52000', '51000', '50000', '51000', '52000', '53000', '54000', '55000'),
('Quản trị hệ thống', '59000', '58000', '57000', '58000', '59000', '60000', '61000', '62000'),
('Hệ thống nhúng', '62000', '61000', '60000', '61000', '62000', '63000', '64000', '65000'),
('Cơ sở lập trình', '40000', '39000', '38000', '39000', '40000', '41000', '42000', '43000'),
('Phân tích thiết kế', '46000', '45000', '44000', '45000', '46000', '47000', '48000', '49000'),
('Điều khiển tự động', '61000', '60000', '59000', '60000', '61000', '62000', '63000', '64000'),
('Cơ học lượng tử', '65000', '64000', '63000', '64000', '65000', '66000', '67000', '68000'),
('Tâm lý học', '35000', '34000', '33000', '34000', '35000', '36000', '37000', '38000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `feecollege`
--

CREATE TABLE `feecollege` (
  `stuID` varchar(20) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `Department` varchar(20) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `total` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `feecollege`
--

INSERT INTO `feecollege` (`stuID`, `course`, `Department`, `semester`, `total`) VALUES
('14092570', 'Đại số', 'Khoa học máy tính', 'semester1', '49000'),
('14092570', 'Thể chất', 'Khoa học máy tính', 'semester1', '49000'),
('14092570', 'Triết', 'Khoa học máy tính', 'semester1', '49000'),
('14092570', 'Lập Trình Mạng', 'Khoa học máy tính', 'semester1', '49000'),
('14092570', 'Lịch Sử Đảng', 'Khoa học máy tính', 'semester1', '49000'),
('14092570', 'Tâm lý học', 'Khoa học máy tính', 'semester2', '34000.0'),
('14092570', 'Cơ học lượng tử', 'Khoa học máy tính', 'semester2', '64000.0'),
('14092570', 'Điều khiển tự động', 'Khoa học máy tính', 'semester2', '60000.0'),
('14092570', 'Phân tích thiết kế', 'Khoa học máy tính', 'semester2', '45000.0'),
('14092570', 'Quản trị hệ thống', 'Khoa học máy tính', 'semester2', '58000.0'),
('1409194', 'Lịch Sử Đảng', 'Khoa học máy tính', 'semester1', '49000'),
('1409194', 'Đại số', 'Khoa học máy tính', 'semester1', '44000'),
('1409194', 'Thể chất', 'Khoa học máy tính', 'semester1', '39000'),
('1409194', 'Tin học cơ bản', 'Khoa học máy tính', 'semester1', '70000'),
('1409194', 'Mạng', 'Khoa học máy tính', 'semester1', '44000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `login`
--

CREATE TABLE `login` (
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin1@uni.com', 'Admin1@123'),
('admin2@uni.com', 'Admin2@123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `marks`
--

CREATE TABLE `marks` (
  `stuID` varchar(40) DEFAULT NULL,
  `semester` varchar(40) DEFAULT NULL,
  `mrk1` varchar(40) DEFAULT NULL,
  `mrk2` varchar(40) DEFAULT NULL,
  `mrk3` varchar(40) DEFAULT NULL,
  `mrk4` varchar(40) DEFAULT NULL,
  `mrk5` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `marks`
--

INSERT INTO `marks` (`stuID`, `semester`, `mrk1`, `mrk2`, `mrk3`, `mrk4`, `mrk5`) VALUES
('14092570', 'semester1', '10', '7', '9', '6', '5');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `name` varchar(40) DEFAULT NULL,
  `fname` varchar(40) DEFAULT NULL,
  `stuID` varchar(40) DEFAULT NULL,
  `dob` varchar(40) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `phone` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `class_X` varchar(40) DEFAULT NULL,
  `class_XII` varchar(20) DEFAULT NULL,
  `userID` varchar(40) DEFAULT NULL,
  `course` varchar(40) DEFAULT NULL,
  `branch` varchar(40) DEFAULT NULL,
  `gender` enum('male','female') NOT NULL DEFAULT 'male'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`name`, `fname`, `stuID`, `dob`, `address`, `phone`, `email`, `class_X`, `class_XII`, `userID`, `course`, `branch`, `gender`) VALUES
('dat', 'nguyen', '14092570', '5 thg 1, 2004', 'go vap', '12357627', 'heyu@gmail.com', '80', '85', '0061105', 'Thể chất', 'Điện', 'male'),
('Thị Hoa', 'Nguyễn ', '1409194', '22 Nov 2004', 'quận 1, TPHCM', '0974543521', 'thihoa@gmail.com', '90', '90', '4534532213213', 'Thể chất', 'Trí tuệ nhân tạo', 'female'),
('Hoàng', 'Minh', '14097390', '19 Jul 2004', 'An Giang', '0123987654', 'Hoang@gmail.com', '70', '70', '234354647805', 'Mạng', 'Khoa học máy tính', 'male'),
('Đạt', 'Trần', '14097637', '11 Jun 2003', 'Tam An, Đồng Nai', '0432434567', 'Dat@gmail.com', '90', '80', '345643957538', 'Thể chất', 'Cơ khí', 'male'),
('Bích', 'Tô', '14095898', '7 Apr 2004', 'Long Thành, Đồng Nai', '0934342342', 'ToBich@gmail.com', '100', '100', '2352789769657', 'Tiếng anh', 'Ngôn ngữ anh', 'female'),
('Châu', 'Bảo', '14094259', '4 Nov 2005', 'Quận 1, TP.HCM', '0234216147', 'baoChau@gmail.com', '90', '90', '32498327489', 'Tiếng anh', 'Ngôn ngữ anh', 'female'),
('Anh', 'Nguyen', '14092001', '2004-01-01', 'Hà Nội', '123456789', 'anhnguyen@gmail.com', '85', '90', '1001001', 'Lịch Sử Đảng', 'Điện', 'male'),
('Bình', 'Trần', '14092002', '2004-02-02', 'Đà Nẵng', '987654321', 'binhtran@gmail.com', '80', '85', '1001002', 'Đại số', 'Cơ khí', 'male'),
('Châu', 'Phạm', '14092003', '2004-03-03', 'TP.HCM', '112233445', 'chaupt@gmail.com', '90', '92', '1001003', 'Thể chất', 'Ngôn ngữ anh', 'female'),
('Dương', 'Lê', '14092004', '2004-04-04', 'Hải Phòng', '998877665', 'duongle@gmail.com', '88', '91', '1001004', 'Tin học cơ bản', 'Xây dựng', 'male'),
('Em', 'Bùi', '14092005', '2004-05-05', 'Huế', '776655443', 'embuoi@gmail.com', '95', '98', '1001005', 'Mạng', 'Khoa học máy tính', 'female'),
('Phúc', 'Nguyễn', '14092006', '2004-06-06', 'Quảng Nam', '556677889', 'phucnguyen@gmail.com', '70', '75', '1001006', 'Cơ sở sữ liệu', 'Trí tuệ nhân tạo', 'male'),
('Gấm', 'Đỗ', '14092007', '2004-07-07', 'Vũng Tàu', '998855776', 'gamdo@gmail.com', '85', '89', '1001007', 'Triết', 'Oto', 'female'),
('Hà', 'Hoàng', '14092008', '2004-08-08', 'Cần Thơ', '667788990', 'hahoang@gmail.com', '92', '94', '1001008', 'Lập Trình Mạng', 'Logistic', 'female'),
('Hiếu', 'Vũ', '14092009', '2004-09-09', 'Quảng Bình', '447788990', 'hieuvu@gmail.com', '75', '80', '1001009', 'Tiếng anh', 'Điện', 'male'),
('Khánh', 'Phan', '14092010', '2004-10-10', 'Đồng Nai', '556688774', 'khanhphan@gmail.com', '88', '85', '1001010', 'Lịch Sử Đảng', 'Ngôn ngữ anh', 'female'),
('Lâm', 'Trịnh', '14092011', '2004-11-11', 'Lạng Sơn', '778899665', 'lamtrinh@gmail.com', '89', '90', '1001011', 'Đại số', 'Cơ khí', 'male'),
('Minh', 'Đặng', '14092012', '2004-12-12', 'Tây Ninh', '665544332', 'minhdang@gmail.com', '90', '95', '1001012', 'Thể chất', 'Xây dựng', 'male'),
('Ngọc', 'Lý', '14092013', '2004-12-15', 'Quảng Ngãi', '887755443', 'ngocly@gmail.com', '78', '82', '1001013', 'Tin học cơ bản', 'Trí tuệ nhân tạo', 'female'),
('Phong', 'Quang', '14092014', '2004-05-19', 'Hà Tĩnh', '998822336', 'phongquang@gmail.com', '93', '90', '1001014', 'Mạng', 'Khoa học máy tính', 'male'),
('Quang', 'Tôn', '14092015', '2004-03-22', 'Hà Nam', '665522335', 'quangton@gmail.com', '80', '85', '1001015', 'Cơ sở sữ liệu', 'Logistic', 'male'),
('Sơn', 'Linh', '14092016', '2004-02-01', 'Quảng Trị', '554433112', 'sonlinh@gmail.com', '82', '86', '1001016', 'Triết', 'Oto', 'male'),
('Tâm', 'Tạ', '14092017', '2004-09-18', 'Sóc Trăng', '224466880', 'tamtata@gmail.com', '84', '87', '1001017', 'Lập Trình Mạng', 'Điện', 'male'),
('Thảo', 'Ngô', '14092018', '2004-11-20', 'Vĩnh Long', '113322440', 'thaongo@gmail.com', '86', '88', '1001018', 'Tiếng anh', 'Ngôn ngữ anh', 'female'),
('Uyên', 'Bảo', '14092019', '2004-07-13', 'Thanh Hóa', '998877112', 'uyenbao@gmail.com', '85', '91', '1001019', 'Lịch Sử Đảng', 'Cơ khí', 'female'),
('Vinh', 'Thạch', '14092020', '2004-04-29', 'Bạc Liêu', '776655220', 'vinhthach@gmail.com', '89', '92', '1001020', 'Đại số', 'Ngôn ngữ anh', 'male');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `studentleave`
--

CREATE TABLE `studentleave` (
  `stuID` varchar(20) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `studentleave`
--

INSERT INTO `studentleave` (`stuID`, `date`, `time`, `description`) VALUES
('14092570', '21 Nov 2024', 'Cả ngày', NULL),
('14092570', '21 Nov 2024', 'Cả ngày', NULL),
('14092570', '24 Nov 2024', 'Cả ngày', NULL),
('14092570', '25 Nov 2024', 'Cả ngày', 'bận');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject`
--

CREATE TABLE `subject` (
  `stuID` varchar(40) DEFAULT NULL,
  `semester` varchar(40) DEFAULT NULL,
  `subj1` varchar(40) DEFAULT NULL,
  `subj2` varchar(40) DEFAULT NULL,
  `subj3` varchar(40) DEFAULT NULL,
  `subj4` varchar(40) DEFAULT NULL,
  `sbj5` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `subject`
--

INSERT INTO `subject` (`stuID`, `semester`, `subj1`, `subj2`, `subj3`, `subj4`, `sbj5`) VALUES
('14092570', 'semester1', 'Lịch Sử Đảng', 'Đại số', 'Thể chất', 'Triết', 'Lập Trình Mạng'),
('14092570', 'semester2', 'Tâm lý học', 'Cơ học lượng tử', 'Điều khiển tự động', 'Phân tích thiết kế', 'Quản trị hệ thống'),
('1409194', 'semester1', 'Lịch Sử Đảng', 'Đại số', 'Thể chất', 'Tin học cơ bản', 'Mạng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `teacher`
--

CREATE TABLE `teacher` (
  `name` varchar(40) DEFAULT NULL,
  `fname` varchar(40) DEFAULT NULL,
  `empId` varchar(40) DEFAULT NULL,
  `dob` varchar(40) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `phone` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `class_X` varchar(40) DEFAULT NULL,
  `class_XII` varchar(40) DEFAULT NULL,
  `userId` varchar(40) DEFAULT NULL,
  `education` varchar(40) DEFAULT NULL,
  `department` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `teacher`
--

INSERT INTO `teacher` (`name`, `fname`, `empId`, `dob`, `address`, `phone`, `email`, `class_X`, `class_XII`, `userId`, `education`, `department`) VALUES
('Đại', 'Phúc', '14092991', '5 Oct 2024', 'Tam an', '1234567890', 'dai@gmail.com', '88', '89', '9876543210', 'Đại số', 'Khoa học máy tính'),
('Xuân Hoa', 'Thị', '14092021', '25 Nov 1990', 'Bình thạnh, TPHCM', '0934324345', 'hoathi@gmail.com', '100', '100', '02343243423525', 'Cơ sở sữ liệu', 'Khoa học máy tính'),
('Hoàng', 'Lương Xuân', '14093132', '24 Nov 1970', 'Bình Thạnh, TPHCM', '0565465461', 'hoang@gmail.com', '100', '100', '3249083094583', 'Đại số', 'Cơ khí'),
('Xuân', 'Nguyên', '14094', '26 Nov 1980', 'quận 12, TP.HCM', '0987654328', 'xuan@gmal.com', '90', '90', '4353464574735', 'Tiếng anh', 'Ngôn ngữ anh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `teacherleave`
--

CREATE TABLE `teacherleave` (
  `empId` varchar(20) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `teacherleave`
--

INSERT INTO `teacherleave` (`empId`, `date`, `time`, `description`) VALUES
('14092991', '25 Oct 2024', 'Cả ngày', NULL),
('14092991', '21 Nov 2024', 'Cả ngày', NULL),
('14092991', '24 Nov 2024', 'Cả ngày', 'mệt');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
