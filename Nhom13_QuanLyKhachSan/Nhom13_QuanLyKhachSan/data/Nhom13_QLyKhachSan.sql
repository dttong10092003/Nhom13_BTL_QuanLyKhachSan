USE [master]
GO
/****** Object:  Database [QuanLyKhachSan]    Script Date: 4/27/2023 8:55:07 PM ******/
CREATE DATABASE [QuanLyKhachSan]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyKhachSan', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\QuanLyKhachSan.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QuanLyKhachSan_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\QuanLyKhachSan_log.ldf' , SIZE = 1072KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QuanLyKhachSan] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyKhachSan].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyKhachSan] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyKhachSan] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyKhachSan] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyKhachSan] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyKhachSan] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyKhachSan] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyKhachSan] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [QuanLyKhachSan] SET DELAYED_DURABILITY = DISABLED 
GO
USE [QuanLyKhachSan]
GO
/****** Object:  Table [dbo].[ChiTietDichVu]    Script Date: 4/27/2023 8:55:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDichVu](
	[MaCTDV] [int] IDENTITY(1,1) NOT NULL,
	[MaDatPhong] [int] NOT NULL,
	[MaDichVu] [nvarchar](50) NOT NULL,
	[DonGia] [money] NOT NULL,
	[SoLuong] [float] NOT NULL CONSTRAINT [DF_ChiTietDichVu_SoLuong]  DEFAULT ((1)),
	[ThanhTien] [money] NULL,
 CONSTRAINT [PK_ChiTietDichVu] PRIMARY KEY CLUSTERED 
(
	[MaCTDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChiTietLuong]    Script Date: 4/27/2023 8:55:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietLuong](
	[MaChiTietLuong] [nvarchar](50) NOT NULL,
	[MaNhanVien] [nvarchar](50) NULL,
	[SoNgayNghi] [int] NULL,
	[SoNgayLam] [int] NULL,
	[NgayNhanLuong] [date] NULL,
	[TongNhan] [money] NULL,
 CONSTRAINT [PK_NhanLuong] PRIMARY KEY CLUSTERED 
(
	[MaChiTietLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DatPhong]    Script Date: 4/27/2023 8:55:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DatPhong](
	[MaDatPhong] [int] IDENTITY(1,1) NOT NULL,
	[MaKhachHang] [nvarchar](50) NOT NULL,
	[MaPhong] [nvarchar](50) NOT NULL,
	[LoaiHinhThue] [bit] NULL,
	[NgayThue] [datetime] NULL CONSTRAINT [DF_DatPhong_NgayThue]  DEFAULT (getdate()),
	[NgayRaDuKien] [datetime] NULL,
	[SoNguoi] [int] NULL CONSTRAINT [DF_DatPhong_SoNguoi]  DEFAULT ((1)),
	[TenUser] [nvarchar](50) NOT NULL,
	[TinhTrang] [nvarchar](50) NULL CONSTRAINT [DF_DatPhong_TinhTrang]  DEFAULT (N'Chưa thanh toán'),
	[TienDatCoc] [money] NULL CONSTRAINT [DF_DatPhong_TienDatCoc]  DEFAULT ((0)),
 CONSTRAINT [PK_DatPhong] PRIMARY KEY CLUSTERED 
(
	[MaDatPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 4/27/2023 8:55:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[MaDichVu] [nvarchar](50) NOT NULL,
	[TenDichVu] [nvarchar](50) NOT NULL,
	[DonVi] [nvarchar](50) NOT NULL,
	[DonGia] [money] NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[MaDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 4/27/2023 8:55:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[MaDatPhong] [int] NOT NULL,
	[TenUser] [nvarchar](50) NOT NULL,
	[TenKhachHang] [nvarchar](50) NOT NULL,
	[MaPhong] [nvarchar](50) NOT NULL,
	[SoNgayThue] [float] NULL,
	[SoGioThue] [float] NULL,
	[TienPhong] [money] NULL,
	[PhuThuCheckin] [money] NULL,
	[PhuThuCheckout] [money] NULL,
	[TienDichVu] [money] NULL,
	[ThanhTien] [money] NOT NULL,
	[NgayThanhToan] [date] NULL,
	[GhiChu] [nvarchar](max) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Khac]    Script Date: 4/27/2023 8:55:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Khac](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[GiaTriSo] [float] NULL,
	[GiaTriTG] [time](7) NULL,
	[MoTa] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 4/27/2023 8:55:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKhachHang] [nvarchar](50) NOT NULL,
	[MaLoaiKH] [nvarchar](50) NOT NULL,
	[TenKhachHang] [nvarchar](50) NOT NULL,
	[Tuoi] [int] NULL,
	[GioiTinh] [bit] NULL CONSTRAINT [DF_KhachHang_GioiTinh]  DEFAULT ('true'),
	[SoDienThoai] [char](10) NULL CONSTRAINT [DF_KhachHang_SoDienThoai]  DEFAULT (N'0123456789'),
	[SoCMND] [char](12) NULL CONSTRAINT [DF_KhachHang_SoCMND]  DEFAULT (N'123456789111'),
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiKhachHang]    Script Date: 4/27/2023 8:55:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiKhachHang](
	[MaLoaiKH] [nvarchar](50) NOT NULL,
	[TenLoaiKH] [nvarchar](50) NOT NULL,
	[TienGiam] [int] NULL,
	[MoTa] [nvarchar](max) NULL,
 CONSTRAINT [PK_LoaiKhachHang] PRIMARY KEY CLUSTERED 
(
	[MaLoaiKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 4/27/2023 8:55:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[MaLoaiPhong] [nvarchar](50) NOT NULL,
	[TenLoaiPhong] [nvarchar](50) NOT NULL,
	[GiuongDon] [int] NULL,
	[GiuongDoi] [int] NULL,
	[GiaTheoGio] [money] NULL,
	[GiaTheoNgay] [money] NULL,
 CONSTRAINT [PK_LoaiPhong] PRIMARY KEY CLUSTERED 
(
	[MaLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Luong]    Script Date: 4/27/2023 8:55:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Luong](
	[MaLuong] [nvarchar](50) NOT NULL,
	[LuongTheoGio] [money] NOT NULL,
	[SoGioLam] [int] NOT NULL,
	[GhiChu] [nvarchar](max) NULL CONSTRAINT [DF_Luong_NgayBatDauLam]  DEFAULT (getdate()),
 CONSTRAINT [PK_Luong] PRIMARY KEY CLUSTERED 
(
	[MaLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/27/2023 8:55:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [nvarchar](50) NOT NULL,
	[TenNhanVien] [nvarchar](50) NOT NULL,
	[GioiTinh] [bit] NULL CONSTRAINT [DF_NhanVien_GioiTinh]  DEFAULT ('true'),
	[NgaySinh] [date] NULL,
	[SoDienThoai] [char](10) NULL,
	[MaLuong] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](max) NULL,
	[Hinh] [nvarchar](max) NULL,
	[NgayBatDauLam] [date] NULL CONSTRAINT [DF_NhanVien_NgayBatDauLam]  DEFAULT (getdate()),
	[GhiChu] [nvarchar](255) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 4/27/2023 8:55:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[MaPhong] [nvarchar](50) NOT NULL,
	[MaLoaiPhong] [nvarchar](50) NOT NULL,
	[DienTich] [int] NULL,
	[MaTang] [int] NULL CONSTRAINT [DF_Phong_MaTang]  DEFAULT ((1)),
	[GiuongDon] [int] NULL CONSTRAINT [DF_Phong_GiuongDon]  DEFAULT ((0)),
	[GiuongDoi] [int] NULL CONSTRAINT [DF_Phong_GiuongDoi]  DEFAULT ((0)),
	[Hinh] [nvarchar](max) NULL,
	[TinhTrang] [nvarchar](50) NULL CONSTRAINT [DF_Phong_TinhTrang]  DEFAULT (N'trống'),
	[GhiChu] [nvarchar](255) NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Quyen]    Script Date: 4/27/2023 8:55:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quyen](
	[MaQuyen] [nvarchar](50) NOT NULL,
	[TenQuyen] [nvarchar](50) NOT NULL,
	[MoTa] [nvarchar](255) NULL,
 CONSTRAINT [PK_Quyen] PRIMARY KEY CLUSTERED 
(
	[MaQuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[User]    Script Date: 4/27/2023 8:55:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[TenUser] [nvarchar](50) NOT NULL,
	[MatKhau] [nvarchar](50) NULL,
	[NgayLap] [date] NOT NULL CONSTRAINT [DF_User_NgayLap]  DEFAULT (getdate()),
	[MaQuyen] [nvarchar](50) NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
	[MaNhanVien] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[TenUser] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[ChiTietDichVu] ON 

INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (4, 1, N'DV001', 10000.0000, 1, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (8, 1, N'DV002', 20000.0000, 2, 40000.0000)
SET IDENTITY_INSERT [dbo].[ChiTietDichVu] OFF
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'CTL001', N'NV001', 0, 3, CAST(N'2019-12-04' AS Date), 432000.0000)
SET IDENTITY_INSERT [dbo].[DatPhong] ON 

INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (1, N'KH001', N'101', 0, CAST(N'2023-03-08 15:15:31.140' AS DateTime), CAST(N'2023-03-09 15:15:31.140' AS DateTime), 1, N'admin', N'Đã thanh toán', NULL)
SET IDENTITY_INSERT [dbo].[DatPhong] OFF
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'DV001', N'Nước suối', N'Chai', 10000.0000, N'Lạnh hoặc không lạnh')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'DV002', N'Nước ngọt', N'Lon', 20000.0000, N'Sting,Number1,Red Bull')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'DV003', N'Giặt đồ', N'Kg', 50000.0000, N'')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'DV004', N'Bia', N'Lon', 25000.0000, N'')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'DV005', N'Khăn ướt', N'Cái', 5000.0000, N'')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'DV006', N'Mỳ', N'Gói', 10000.0000, N'Mỳ các loại')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'DV007', N'Thuốc lá', N'Gói', 30000.0000, N'Jet,555,ConMeo')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'DV008', N'Rượu vang', N'Chai', 280000.0000, N'Vang đỏ Đà Lạt 750ml')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'DV009', N'Trái cây', N'Phần', 150000.0000, N'')
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1, 1, N'admin', N'Bùi Văn Tám', N'101', 1, 24, 1440000.0000, NULL, NULL, 0.0000, 4680000.0000, NULL, NULL)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
SET IDENTITY_INSERT [dbo].[Khac] ON 

INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (3, 6, CAST(N'12:00:00' AS Time), N'qua mốc checkin1 ')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (4, 1, CAST(N'12:00:00' AS Time), N'quá mốc checkin2')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (5, 2, CAST(N'14:00:00' AS Time), N'mốc checkout2')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (6, 5, CAST(N'14:00:00' AS Time), N'mốc checkout1')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (7, 30, NULL, N'phụ thu checkin1')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (8, 50, NULL, N'phụ thu checkin2')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (9, 20, NULL, N'phụ thu checkout1')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (10, 30, NULL, N'phụ thu checkout1')
SET IDENTITY_INSERT [dbo].[Khac] OFF
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH001', N'1', N'Bùi Văn Tám', 42, 1, N'0388884418', N'079081123456')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH002', N'1', N'Trần Quang Trường', 22, 1, N'0388884418', N'079201120918')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH003', N'2', N'Võ Thu Thảo', 20, 0, N'0966989156', N'079303123437')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH004', N'1', N'Phan Hữu Tín', 20, 1, N'0372890765', N'079203126437')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH005', N'1', N'Lê Phú Quý', 23, 1, N'0933548962', N'079200892438')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH006', N'1', N'Lương Tấn Đạt', 19, 1, N'0989856784', N'079204007575')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH007', N'1', N'Nguyễn Hoàng Anh Thư', 20, 0, N'0357888918', N'079303782729')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH008', N'1', N'Trần Hữu Độ', 40, 1, N'0945772884', N'079083002210')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH009', N'1', N'Trương Tuệ Mẫn', 24, 0, N'0988198231', N'079199009898')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH010', N'2', N'Trương Quang Dũng', 25, 1, N'0357899227', N'079098015643')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH011', N'2', N'Trần Anh Kiệt', 21, 1, N'0381298123', N'079202014545')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH012', N'1', N'Nguyễn Thảo Vy', 18, 0, N'0987234738', N'079305029383')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH013', N'1', N'Dương Toàn Ninh', 22, 1, N'0977392981', N'079201039874')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH014', N'1', N'Lê Thanh Thiên', 45, 1, N'0966138248', N'079078049817')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH015', N'1', N'Lê Tuấn Kiệt', 30, 1, N'0388819223', N'079093015628')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH016', N'2', N'Nguyễn Thanh Phúc', 28, 0, N'0901230019', N'079195026969')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH017', N'1', N'Ngô Anh Thư', 20, 0, N'0977382920', N'079303007537')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH018', N'1', N'Lê Công Vinh', 30, 1, N'0300239394', N'079093091192')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH019', N'2', N'Nguyễn Thanh Sang', 23, 1, N'0388193843', N'079200710928')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH020', N'1', N'Lê Hông Nhung', 23, 0, N'0992029111', N'079300898912')
INSERT [dbo].[LoaiKhachHang] ([MaLoaiKH], [TenLoaiKH], [TienGiam], [MoTa]) VALUES (N'1', N'Khách vãng lai', 0, N'')
INSERT [dbo].[LoaiKhachHang] ([MaLoaiKH], [TenLoaiKH], [TienGiam], [MoTa]) VALUES (N'2', N'Khách Vip', 10, N'')
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'P1', N'Phòng Tiêu Chuẩn(STD)', NULL, NULL, 60000.0000, 200000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'P2', N'Phòng Superior(SUP)', NULL, NULL, 70000.0000, 300000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'P3', N'Phòng Deluxe (DLX)', NULL, NULL, 80000.0000, 400000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'P4', N'Phòng Suite (SUT)', NULL, NULL, 90000.0000, 500000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'P5', N'Connecting room', NULL, NULL, 100000.0000, 1000000.0000)
INSERT [dbo].[Luong] ([MaLuong], [LuongTheoGio], [SoGioLam], [GhiChu]) VALUES (N'LuongNhanVien1', 25000.0000, 8, N'Lương cao thứ 2')
INSERT [dbo].[Luong] ([MaLuong], [LuongTheoGio], [SoGioLam], [GhiChu]) VALUES (N'LuongNhanVien2', 35000.0000, 8, N'Lương bình thường')
INSERT [dbo].[Luong] ([MaLuong], [LuongTheoGio], [SoGioLam], [GhiChu]) VALUES (N'LuongQuanLy', 50000.0000, 6, N'Lương cao nhất')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV001', N'Đinh Thanh Tòng', 1, CAST(N'2003-09-10' AS Date), N'0366459222', N'LuongQuanLy', N'Đồng Tháp', N'', CAST(N'2022-10-24' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV002', N'Nguyễn Trọng Tính', 1, CAST(N'2003-08-04' AS Date), N'0388654782', N'LuongQuanLy', N'TP HCM', N'', CAST(N'2022-06-01' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV003', N'Phan Hữu Tín', 1, CAST(N'2003-08-01' AS Date), N'0327858091', N'LuongNhanVien2', N'TP HCM', N'', CAST(N'2022-06-03' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV004', N'Phan Thanh Nam', 1, CAST(N'2003-03-23' AS Date), N'0989762854', N'LuongNhanVien1', N'Long An', N'', CAST(N'2022-06-04' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV005', N'Nguyễn Thị Hồng Thắm', 0, CAST(N'2003-05-16' AS Date), N'0398182932', N'LuongNhanVien1', N'Đồng Tháp', N'', CAST(N'2022-07-06' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV006', N'Lê Kiều Thi', 0, CAST(N'2000-05-10' AS Date), N'0382369182', N'LuongNhanVien1', N'Long An', N'', CAST(N'2022-07-06' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV007', N'Lê Anh Dũng', 1, CAST(N'2000-06-06' AS Date), N'0998823373', N'LuongNhanVien1', N'Thái Nguyên', N'', CAST(N'2023-01-05' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV008', N'Trần Quang Đại', 1, CAST(N'2001-06-20' AS Date), N'0981266392', N'LuongNhanVien2', N'Tây Ninh', N'', CAST(N'2023-01-05' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV009', N'Trương Tuệ Mẫn', 0, CAST(N'2001-06-20' AS Date), N'0357892797', N'LuongNhanVien1', N'Tây Ninh', N'', CAST(N'2023-01-05' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV010', N'Lê Hữu Duy', 1, CAST(N'2002-06-14' AS Date), N'0389893245', N'LuongNhanVien2', N'TP HCM', N'', CAST(N'2023-01-07' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV011', N'Trần Bá Huy', 1, CAST(N'2003-10-18' AS Date), N'0377328229', N'LuongNhanVien1', N'TP HCM', N'', CAST(N'2023-01-09' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV012', N'Nguyễn Lý Bảo Trâm', 0, CAST(N'2000-10-29' AS Date), N'0979875223', N'LuongNhanVien1', N'TP HCM', N'', CAST(N'2023-01-09' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV013', N'Thạch Quốc Bảo', 1, CAST(N'2003-10-19' AS Date), N'0357765891', N'LuongNhanVien2', N'TP HCM', N'', CAST(N'2023-01-09' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV014', N'Nguyễn Chí Tâm', 1, CAST(N'1999-10-19' AS Date), N'0979888133', N'LuongNhanVien1', N'TP HCM', N'', CAST(N'2023-01-12' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV015', N'Nguyễn Kim Phát', 1, CAST(N'2000-10-19' AS Date), N'0393899823', N'LuongNhanVien1', N'TP HCM', N'', CAST(N'2023-01-10' AS Date), N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'101', N'P1', 20, 1, 0, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'102', N'P1', 20, 1, 0, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'103', N'P1', 20, 1, 0, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'104', N'P1', 20, 1, 0, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'105', N'P1', 20, 1, 0, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'106', N'P1', 20, 1, 0, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'107', N'P1', 20, 1, 0, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'108', N'P1', 20, 1, 0, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'201', N'P2', 25, 2, 1, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'202', N'P2', 25, 2, 1, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'203', N'P2', 25, 2, 1, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'204', N'P2', 25, 2, 1, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'205', N'P2', 25, 2, 1, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'206', N'P2', 25, 2, 1, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'207', N'P2', 25, 2, 1, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'301', N'P3', 30, 3, 2, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'302', N'P3', 30, 3, 2, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'303', N'P3', 30, 3, 2, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'304', N'P3', 30, 3, 2, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'305', N'P3', 30, 3, 2, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'306', N'P3', 30, 3, 2, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'401', N'P4', 33, 4, 2, 2, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'402', N'P4', 33, 4, 2, 2, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'403', N'P4', 33, 4, 2, 2, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'404', N'P4', 33, 4, 2, 2, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'405', N'P4', 33, 4, 2, 2, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'406', N'P4', 33, 4, 2, 2, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'407', N'P4', 33, 4, 2, 2, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'502', N'P5', 45, 5, 3, 2, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'503', N'P5', 45, 5, 3, 2, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'504', N'P5', 45, 5, 3, 2, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'505', N'P5', 45, 5, 3, 2, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'601', N'P5', 45, 6, 3, 2, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'602', N'P5', 45, 6, 3, 2, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'603', N'P5', 45, 6, 3, 2, N'null', N'trong', N'')
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [MoTa]) VALUES (N'NhanVien', N'Nhân viên', NULL)
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [MoTa]) VALUES (N'QuanLy', N'Quản lý', NULL)
INSERT [dbo].[User] ([TenUser], [MatKhau], [NgayLap], [MaQuyen], [GhiChu], [MaNhanVien]) VALUES (N'admin', N'admin', CAST(N'2022-10-24' AS Date), N'QuanLy', NULL, N'NV001')
INSERT [dbo].[User] ([TenUser], [MatKhau], [NgayLap], [MaQuyen], [GhiChu], [MaNhanVien]) VALUES (N'admin1', N'admin1', CAST(N'2023-04-27' AS Date), N'QuanLy', NULL, N'NV002')
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDichVu_DatPhong] FOREIGN KEY([MaDatPhong])
REFERENCES [dbo].[DatPhong] ([MaDatPhong])
GO
ALTER TABLE [dbo].[ChiTietDichVu] CHECK CONSTRAINT [FK_ChiTietDichVu_DatPhong]
GO
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDichVu_DichVu] FOREIGN KEY([MaDichVu])
REFERENCES [dbo].[DichVu] ([MaDichVu])
GO
ALTER TABLE [dbo].[ChiTietDichVu] CHECK CONSTRAINT [FK_ChiTietDichVu_DichVu]
GO
ALTER TABLE [dbo].[ChiTietLuong]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietLuong_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[ChiTietLuong] CHECK CONSTRAINT [FK_ChiTietLuong_NhanVien]
GO
ALTER TABLE [dbo].[DatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DatPhong_KhachHang] FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[KhachHang] ([MaKhachHang])
GO
ALTER TABLE [dbo].[DatPhong] CHECK CONSTRAINT [FK_DatPhong_KhachHang]
GO
ALTER TABLE [dbo].[DatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DatPhong_Phong] FOREIGN KEY([MaPhong])
REFERENCES [dbo].[Phong] ([MaPhong])
GO
ALTER TABLE [dbo].[DatPhong] CHECK CONSTRAINT [FK_DatPhong_Phong]
GO
ALTER TABLE [dbo].[DatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DatPhong_User] FOREIGN KEY([TenUser])
REFERENCES [dbo].[User] ([TenUser])
GO
ALTER TABLE [dbo].[DatPhong] CHECK CONSTRAINT [FK_DatPhong_User]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_DatPhong] FOREIGN KEY([MaDatPhong])
REFERENCES [dbo].[DatPhong] ([MaDatPhong])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_DatPhong]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK_KhachHang_LoaiKhachHang] FOREIGN KEY([MaLoaiKH])
REFERENCES [dbo].[LoaiKhachHang] ([MaLoaiKH])
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK_KhachHang_LoaiKhachHang]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_Luong] FOREIGN KEY([MaLuong])
REFERENCES [dbo].[Luong] ([MaLuong])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_Luong]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_LoaiPhong] FOREIGN KEY([MaLoaiPhong])
REFERENCES [dbo].[LoaiPhong] ([MaLoaiPhong])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_LoaiPhong]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_NhanVien]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Quyen] FOREIGN KEY([MaQuyen])
REFERENCES [dbo].[Quyen] ([MaQuyen])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_Quyen]
GO
USE [master]
GO
ALTER DATABASE [QuanLyKhachSan] SET  READ_WRITE 
GO
