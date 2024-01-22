
use mini_test1;
-- Tạo bảng Thành phố
CREATE TABLE ThanhPho (
    id INT PRIMARY KEY,
    tenThanhPho VARCHAR(255)
);

-- Tạo bảng Điểm đến du lịch
CREATE TABLE DiemDenDuLich (
    id INT PRIMARY KEY,
    tenDiemDen VARCHAR(255),
    moTa VARCHAR(255),
    giaTrungBinh DECIMAL(10, 2),
    thanhPho_id INT,
    FOREIGN KEY (thanhPho_id) REFERENCES ThanhPho(id)
);

-- Tạo bảng Khách hàng đặt tour
CREATE TABLE KhachHangDatTour (
    id INT PRIMARY KEY,
    tenKhachHang VARCHAR(255),
    soCanCuoc VARCHAR(255),
    namSinh INT,
    thanhPho_id INT,
    FOREIGN KEY (thanhPho_id) REFERENCES ThanhPho(id)
);

-- Tạo bảng Đơn đặt tour
CREATE TABLE DonDatTour (
    id INT PRIMARY KEY,
    khachHang_id INT,
    diemDen_id INT,
    ngayDat DATE,
    FOREIGN KEY (khachHang_id) REFERENCES KhachHangDatTour(id),
    FOREIGN KEY (diemDen_id) REFERENCES DiemDenDuLich(id)
);

-- Tạo bảng Tour
CREATE TABLE Tour (
    id INT PRIMARY KEY,
    tenTour VARCHAR(255),
    moTa VARCHAR(255),
    giaTour DECIMAL(10, 2),
    diemDen_id INT,
    FOREIGN KEY (diemDen_id) REFERENCES DiemDenDuLich(id)
);

-- Thêm 5 bản ghi vào bảng DiemDenDuLich
INSERT INTO DiemDenDuLich (id, tenDiemDen, moTa, giaTrungBinh, thanhPho_id)
VALUES
    (6, 'Điểm đến 6', 'Mô tả 6', 250.00, 1),
    (7, 'Điểm đến 7', 'Mô tả 7', 180.00, 3),
    (8, 'Điểm đến 8', 'Mô tả 8', 300.00, 2),
    (9, 'Điểm đến 9', 'Mô tả 9', 150.00, 1),
    (10, 'Điểm đến 10', 'Mô tả 10', 200.00, 3);
    
    -- Thêm 10 bản ghi vào bảng KhachHangDatTour
INSERT INTO KhachHangDatTour (id, tenKhachHang, soCanCuoc, namSinh, thanhPho_id)
VALUES
    (11, 'Khách hàng 11', 'CC011', 1994, 2),
    (12, 'Khách hàng 12', 'CC012', 1989, 1),
    (13, 'Khách hàng 13', 'CC013', 1996, 3),
    (14, 'Khách hàng 14', 'CC014', 1991, 1),
    (15, 'Khách hàng 15', 'CC015', 1987, 2),
    (16, 'Khách hàng 16', 'CC016', 1993, 1),
    (17, 'Khách hàng 17', 'CC017', 1988, 3),
    (18, 'Khách hàng 18', 'CC018', 1995, 2),
    (19, 'Khách hàng 19', 'CC019', 1990, 1),
    (20, 'Khách hàng 20', 'CC020', 1986, 3);
    
    -- Thêm 2 bản ghi vào bảng Tour
INSERT INTO Tour (id, tenTour, moTa, giaTour, diemDen_id)
VALUES
    (3, 'Tour 3', 'Mô tả tour 3', 500.00, 1),
    (4, 'Tour 4', 'Mô tả tour 4', 800.00, 2);
    
    -- Thêm 10 bản ghi vào bảng DonDatTour
INSERT INTO DonDatTour (id, khachHang_id, diemDen_id, ngayDat)
VALUES
    (1, 1, 1, '2024-01-01'),
    (2, 2, 2, '2024-01-02'),
    (3, 3, 1, '2024-01-03'),
    (4, 4, 3, '2024-01-04'),
    (5, 5, 2, '2024-01-05'),
    (6, 6, 1, '2024-01-06'),
    (7, 7, 2, '2024-01-07'),
    (8, 8, 1, '2024-01-08'),
    (9, 9, 3, '2024-01-09'),
    (10, 10, 2, '2024-01-10');
    
    SELECT ThanhPho.tenThanhPho, COUNT(Tour.id) AS SoLuongTour
FROM ThanhPho
JOIN DiemDenDuLich ON ThanhPho.id = DiemDenDuLich.thanhPho_id
JOIN Tour ON DiemDenDuLich.id = Tour.diemDen_id
GROUP BY ThanhPho.tenThanhPho;

SELECT COUNT(Tour.id) AS SoLuongTour
FROM Tour
JOIN DonDatTour ON Tour.id = DonDatTour.diemDen_id
WHERE DATEPART(year, DonDatTour.ngayDat) = 2020 AND DATEPART(month, DonDatTour.ngayDat) = 3;

SELECT COUNT(Tour.id) AS SoLuongTour
FROM Tour
JOIN DonDatTour ON Tour.id = DonDatTour.diemDen_id
WHERE DATEPART(year, DonDatTour.ngayKetThuc) = 2020 AND DATEPART(month, DonDatTour.ngayKetThuc) = 4;