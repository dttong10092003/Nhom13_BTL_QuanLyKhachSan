USE [master]
GO
/****** Object:  Database [QuanLyKhachSan]    Script Date: 5/3/2023 9:21:04 PM ******/
CREATE DATABASE [QuanLyKhachSan]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyKhachSan', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\QuanLyKhachSan.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QuanLyKhachSan_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\QuanLyKhachSan_log.ldf' , SIZE = 1088KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
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
/****** Object:  Table [dbo].[ChiTietDichVu]    Script Date: 5/3/2023 9:21:04 PM ******/
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
/****** Object:  Table [dbo].[ChiTietLuong]    Script Date: 5/3/2023 9:21:04 PM ******/
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
/****** Object:  Table [dbo].[DatPhong]    Script Date: 5/3/2023 9:21:04 PM ******/
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
/****** Object:  Table [dbo].[DichVu]    Script Date: 5/3/2023 9:21:04 PM ******/
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
/****** Object:  Table [dbo].[HoaDon]    Script Date: 5/3/2023 9:21:04 PM ******/
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
/****** Object:  Table [dbo].[Khac]    Script Date: 5/3/2023 9:21:04 PM ******/
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
/****** Object:  Table [dbo].[KhachHang]    Script Date: 5/3/2023 9:21:04 PM ******/
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
	[SoCCCD] [char](12) NULL CONSTRAINT [DF_KhachHang_SoCCCD]  DEFAULT (N'123456789111'),
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiKhachHang]    Script Date: 5/3/2023 9:21:04 PM ******/
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
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 5/3/2023 9:21:04 PM ******/
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
/****** Object:  Table [dbo].[Luong]    Script Date: 5/3/2023 9:21:04 PM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/3/2023 9:21:04 PM ******/
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
/****** Object:  Table [dbo].[Phong]    Script Date: 5/3/2023 9:21:04 PM ******/
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
/****** Object:  Table [dbo].[Quyen]    Script Date: 5/3/2023 9:21:04 PM ******/
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
/****** Object:  Table [dbo].[User]    Script Date: 5/3/2023 9:21:04 PM ******/
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
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (9, 6, N'DV005', 5000.0000, 2, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (10, 6, N'DV004', 25000.0000, 2, 50000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (11, 6, N'DV004', 25000.0000, 3, 75000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (12, 6, N'DV009', 150000.0000, 1, 150000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (13, 4, N'DV003', 50000.0000, 1, 50000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (14, 4, N'DV008', 280000.0000, 1, 280000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (15, 2, N'DV001', 10000.0000, 3, 30000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (16, 3, N'DV002', 20000.0000, 3, 60000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (17, 20, N'DV001', 10000.0000, 1, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (18, 20, N'DV002', 20000.0000, 2, 40000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (19, 7, N'DV005', 5000.0000, 2, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (20, 7, N'DV004', 25000.0000, 2, 50000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (21, 7, N'DV004', 25000.0000, 3, 75000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (22, 7, N'DV009', 150000.0000, 1, 150000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (23, 11, N'DV003', 50000.0000, 1, 50000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (24, 11, N'DV008', 280000.0000, 1, 280000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (25, 5, N'DV001', 10000.0000, 3, 30000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (26, 10, N'DV002', 20000.0000, 3, 60000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (27, 31, N'DV001', 10000.0000, 1, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (28, 31, N'DV002', 20000.0000, 2, 40000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (29, 9, N'DV005', 5000.0000, 2, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (30, 9, N'DV004', 25000.0000, 2, 50000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (31, 9, N'DV004', 25000.0000, 3, 75000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (32, 9, N'DV009', 150000.0000, 1, 150000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (33, 12, N'DV003', 50000.0000, 1, 50000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (34, 12, N'DV008', 280000.0000, 1, 280000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (35, 32, N'DV001', 10000.0000, 3, 30000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (36, 35, N'DV002', 20000.0000, 3, 60000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (37, 44, N'DV006', 10000.0000, 1, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (38, 44, N'DV003', 50000.0000, 1, 50000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (39, 44, N'DV005', 5000.0000, 2, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (40, 42, N'DV001', 10000.0000, 2, 20000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (41, 42, N'DV002', 20000.0000, 2, 40000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (42, 46, N'DV005', 5000.0000, 3, 15000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (43, 46, N'DV005', 5000.0000, 3, 15000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (44, 46, N'DV004', 25000.0000, 1, 25000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (45, 52, N'DV004', 25000.0000, 2, 50000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (46, 52, N'DV001', 10000.0000, 3, 30000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (47, 52, N'DV001', 10000.0000, 3, 30000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (48, 46, N'DV007', 30000.0000, 1, 30000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (49, 50, N'DV003', 50000.0000, 2, 100000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (50, 50, N'DV002', 20000.0000, 2, 40000.0000)
SET IDENTITY_INSERT [dbo].[ChiTietDichVu] OFF
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'01052023NV003', N'NV003', 0, 1, CAST(N'2023-05-01' AS Date), 280000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'01052023NV004', N'NV004', 0, 152, CAST(N'2023-05-01' AS Date), 30400000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'01052023NV007', N'NV007', 0, 1, CAST(N'2023-05-01' AS Date), 200000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'01052023NV009', N'NV009', 0, 407, CAST(N'2023-05-01' AS Date), 81400000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'01052023NV010', N'NV010', 0, 399, CAST(N'2023-05-01' AS Date), 111720000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'01052023NV011', N'NV011', 0, 292, CAST(N'2023-05-01' AS Date), 58400000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'01052023NV013', N'NV013', 0, 115, CAST(N'2023-05-01' AS Date), 32200000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'01052023NV014', N'NV014', 0, 54, CAST(N'2023-05-01' AS Date), 10800000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'01052023NV016', N'NV016', 0, 83, CAST(N'2023-05-01' AS Date), 16600000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'01052023NV017', N'NV017', 0, 83, CAST(N'2023-05-01' AS Date), 16600000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'01052023NV018', N'NV018', 0, 81, CAST(N'2023-05-01' AS Date), 16200000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'01052023NV020', N'NV020', 0, 81, CAST(N'2023-05-01' AS Date), 16200000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'01052023NV021', N'NV021', 0, 81, CAST(N'2023-05-01' AS Date), 16200000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'30042023NV005', N'NV005', 0, 419, CAST(N'2023-04-30' AS Date), 83800000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'30042023NV007', N'NV007', 0, 416, CAST(N'2023-04-30' AS Date), 83200000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'30042023NV008', N'NV008', 0, 412, CAST(N'2023-04-30' AS Date), 115360000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'30042023NV012', N'NV012', 0, 319, CAST(N'2023-04-30' AS Date), 63800000.0000)
SET IDENTITY_INSERT [dbo].[DatPhong] ON 

INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (1, N'KH019', N'501', 0, CAST(N'2022-03-08 15:15:31.140' AS DateTime), CAST(N'2022-03-09 15:15:31.140' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (2, N'KH013', N'401', 1, CAST(N'2022-03-30 16:21:29.000' AS DateTime), CAST(N'2022-03-31 16:21:29.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (3, N'KH016', N'403', 1, CAST(N'2022-04-01 16:21:40.000' AS DateTime), CAST(N'2022-04-02 16:21:40.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (4, N'KH015', N'502', 1, CAST(N'2022-04-10 16:21:50.000' AS DateTime), CAST(N'2022-04-11 16:21:50.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (5, N'KH003', N'305', 1, CAST(N'2022-04-15 16:25:28.000' AS DateTime), CAST(N'2022-04-17 16:25:28.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (6, N'KH004', N'602', 0, CAST(N'2022-04-20 16:25:58.000' AS DateTime), CAST(N'2022-04-22 16:25:58.000' AS DateTime), 4, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (7, N'KH005', N'103', 1, CAST(N'2022-05-02 16:27:46.000' AS DateTime), CAST(N'2022-05-04 16:27:46.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (8, N'KH011', N'106', 1, CAST(N'2022-07-10 16:27:58.000' AS DateTime), CAST(N'2022-07-11 16:27:58.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (9, N'KH018', N'204', 1, CAST(N'2022-10-30 16:28:43.000' AS DateTime), CAST(N'2022-10-31 16:28:34.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (10, N'KH001', N'105', 0, CAST(N'2022-11-08 15:15:31.140' AS DateTime), CAST(N'2022-11-09 15:15:31.140' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (11, N'KH002', N'107', 0, CAST(N'2022-11-10 16:21:29.000' AS DateTime), CAST(N'2022-11-12 16:21:29.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (12, N'KH006', N'203', 0, CAST(N'2022-11-20 16:21:40.000' AS DateTime), CAST(N'2022-11-22 16:21:40.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (13, N'KH017', N'502', 1, CAST(N'2022-12-20 16:21:50.000' AS DateTime), CAST(N'2022-12-22 16:21:50.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (14, N'KH020', N'305', 1, CAST(N'2023-01-11 16:25:28.000' AS DateTime), CAST(N'2023-01-12 16:25:28.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (15, N'KH012', N'601', 0, CAST(N'2023-01-13 16:25:58.000' AS DateTime), CAST(N'2023-01-14 16:25:58.000' AS DateTime), 4, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (16, N'KH015', N'303', 1, CAST(N'2023-01-13 16:27:46.000' AS DateTime), CAST(N'2023-01-14 16:27:46.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (17, N'KH004', N'404', 1, CAST(N'2023-01-13 17:27:58.000' AS DateTime), CAST(N'2023-01-14 17:27:58.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (18, N'KH008', N'204', 1, CAST(N'2023-01-13 12:28:43.000' AS DateTime), CAST(N'2023-01-14 12:28:34.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (19, N'KH019', N'101', 0, CAST(N'2023-01-14 15:15:31.140' AS DateTime), CAST(N'2023-01-15 15:15:31.140' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (20, N'KH013', N'102', 0, CAST(N'2023-01-14 16:21:29.000' AS DateTime), CAST(N'2023-01-15 16:21:29.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (21, N'KH016', N'103', 0, CAST(N'2023-01-14 15:21:40.000' AS DateTime), CAST(N'2023-01-15 15:21:40.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (22, N'KH015', N'104', 1, CAST(N'2023-01-15 16:21:50.000' AS DateTime), CAST(N'2023-01-16 16:21:50.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (23, N'KH003', N'201', 1, CAST(N'2023-01-16 16:25:28.000' AS DateTime), CAST(N'2023-01-17 16:25:28.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (24, N'KH004', N'202', 0, CAST(N'2023-01-16 17:25:58.000' AS DateTime), CAST(N'2023-01-17 17:25:58.000' AS DateTime), 4, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (25, N'KH005', N'203', 1, CAST(N'2023-01-16 15:27:46.000' AS DateTime), CAST(N'2023-01-17 15:27:46.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (26, N'KH011', N'303', 1, CAST(N'2023-01-18 16:27:58.000' AS DateTime), CAST(N'2023-01-19 16:27:58.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (27, N'KH018', N'304', 1, CAST(N'2023-01-18 16:28:43.000' AS DateTime), CAST(N'2023-01-19 16:28:34.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (28, N'KH001', N'305', 0, CAST(N'2023-01-20 15:15:31.140' AS DateTime), CAST(N'2023-01-21 15:15:31.140' AS DateTime), 3, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (29, N'KH002', N'107', 0, CAST(N'2023-01-20 16:21:29.000' AS DateTime), CAST(N'2023-01-21 16:21:29.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (30, N'KH006', N'203', 0, CAST(N'2023-01-23 16:21:40.000' AS DateTime), CAST(N'2023-01-24 16:21:40.000' AS DateTime), 3, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (31, N'KH017', N'102', 1, CAST(N'2023-01-23 16:21:50.000' AS DateTime), CAST(N'2023-01-24 16:21:50.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (32, N'KH020', N'305', 1, CAST(N'2023-01-24 12:25:28.000' AS DateTime), CAST(N'2023-01-25 12:25:28.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (33, N'KH012', N'101', 0, CAST(N'2023-01-24 16:25:58.000' AS DateTime), CAST(N'2023-01-25 16:25:58.000' AS DateTime), 4, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (34, N'KH015', N'303', 1, CAST(N'2023-01-26 11:27:46.000' AS DateTime), CAST(N'2023-01-27 11:27:46.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (35, N'KH004', N'204', 1, CAST(N'2023-01-27 17:27:58.000' AS DateTime), CAST(N'2023-01-28 17:27:58.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (36, N'KH008', N'304', 1, CAST(N'2023-01-27 12:28:43.000' AS DateTime), CAST(N'2023-01-28 12:28:34.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (37, N'KH012', N'201', 0, CAST(N'2023-01-27 16:25:58.000' AS DateTime), CAST(N'2023-01-28 16:25:58.000' AS DateTime), 4, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (38, N'KH015', N'303', 1, CAST(N'2023-02-01 16:27:46.000' AS DateTime), CAST(N'2023-02-02 16:27:46.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (39, N'KH004', N'304', 1, CAST(N'2023-02-01 17:27:58.000' AS DateTime), CAST(N'2023-02-02 17:27:58.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (40, N'KH008', N'601', 1, CAST(N'2023-02-01 12:28:43.000' AS DateTime), CAST(N'2023-02-02 12:28:34.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (41, N'KH039', N'101', 1, CAST(N'2023-05-01 10:19:28.000' AS DateTime), CAST(N'2023-05-01 10:19:28.000' AS DateTime), 3, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (42, N'KH035', N'105', 1, CAST(N'2023-05-01 10:19:44.000' AS DateTime), CAST(N'2023-05-01 10:19:44.000' AS DateTime), 3, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (43, N'KH026', N'402', 1, CAST(N'2023-05-01 10:20:26.000' AS DateTime), CAST(N'2023-05-01 10:20:26.000' AS DateTime), 4, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (44, N'KH001', N'303', 0, CAST(N'2023-05-01 10:20:49.000' AS DateTime), CAST(N'2023-05-02 10:20:49.000' AS DateTime), 4, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (45, N'KH003', N'105', 1, CAST(N'2023-05-01 21:11:34.000' AS DateTime), CAST(N'2023-05-01 21:11:34.000' AS DateTime), 1, N'admin', N'Chưa thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (46, N'KH024', N'306', 1, CAST(N'2023-05-01 21:11:44.000' AS DateTime), CAST(N'2023-05-01 21:11:44.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (47, N'KH026', N'601', 1, CAST(N'2023-05-01 21:11:50.000' AS DateTime), CAST(N'2023-05-01 21:11:50.000' AS DateTime), 1, N'admin', N'Chưa thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (48, N'KH014', N'407', 0, CAST(N'2023-05-01 21:12:03.000' AS DateTime), CAST(N'2023-05-02 21:12:03.000' AS DateTime), 1, N'admin', N'Chưa thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (49, N'KH038', N'104', 0, CAST(N'2023-05-01 21:12:12.000' AS DateTime), CAST(N'2023-05-02 21:12:12.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (50, N'KH005', N'103', 1, CAST(N'2023-05-01 21:12:21.000' AS DateTime), CAST(N'2023-05-01 21:12:21.000' AS DateTime), 1, N'admin', N'Chưa thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (51, N'KH024', N'505', 1, CAST(N'2023-05-01 21:12:31.000' AS DateTime), CAST(N'2023-05-01 21:12:31.000' AS DateTime), 1, N'admin', N'Chưa thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (52, N'KH017', N'102', 1, CAST(N'2023-05-01 21:13:00.000' AS DateTime), CAST(N'2023-05-01 21:13:00.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (53, N'KH021', N'106', 0, CAST(N'2023-05-01 21:13:05.000' AS DateTime), CAST(N'2023-05-02 21:13:05.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (54, N'KH021', N'205', 0, CAST(N'2023-05-01 21:13:13.000' AS DateTime), CAST(N'2023-05-02 21:13:13.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (55, N'KH001', N'108', 1, CAST(N'2023-05-01 21:16:07.000' AS DateTime), CAST(N'2023-05-01 21:16:07.000' AS DateTime), 1, N'admin', N'dattruoc', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (56, N'KH002', N'207', 0, CAST(N'2023-05-01 21:16:14.000' AS DateTime), CAST(N'2023-05-02 21:16:14.000' AS DateTime), 1, N'admin', N'dattruoc', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (57, N'KH033', N'502', 1, CAST(N'2023-05-01 21:16:38.000' AS DateTime), CAST(N'2023-05-01 21:16:38.000' AS DateTime), 4, N'admin', N'Chưa thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (58, N'KH011', N'404', 0, CAST(N'2023-05-01 21:16:52.000' AS DateTime), CAST(N'2023-05-02 21:16:52.000' AS DateTime), 4, N'admin', N'Chưa thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (59, N'KH022', N'303', 1, CAST(N'2023-05-01 21:17:07.000' AS DateTime), CAST(N'2023-05-01 21:17:07.000' AS DateTime), 3, N'admin', N'Chưa thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (60, N'KH029', N'204', 1, CAST(N'2023-05-01 21:17:20.000' AS DateTime), CAST(N'2023-05-01 21:17:20.000' AS DateTime), 2, N'admin', N'Chưa thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (61, N'KH023', N'301', 0, CAST(N'2023-05-01 21:17:35.000' AS DateTime), CAST(N'2023-05-02 21:17:35.000' AS DateTime), 4, N'admin', N'Chưa thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (62, N'KH020', N'202', 1, CAST(N'2023-05-01 21:18:01.000' AS DateTime), CAST(N'2023-05-01 21:18:01.000' AS DateTime), 1, N'admin', N'dattruoc', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (63, N'KH035', N'504', 0, CAST(N'2023-05-01 21:18:12.000' AS DateTime), CAST(N'2023-05-02 21:18:12.000' AS DateTime), 4, N'admin', N'Chưa thanh toán', 0.0000)
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

INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1, 1, N'admin', N'Nguyễn Thanh Sang', N'501', 1, 1, 1000000.0000, 0.0000, 0.0000, 50000.0000, 1050000.0000, CAST(N'2022-03-09' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (2, 2, N'admin', N'Dương Toàn Ninh', N'401', 1, 1, 90000.0000, 0.0000, 0.0000, 30000.0000, 930000.0000, CAST(N'2022-03-31' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (3, 3, N'admin', N'Nguyễn Thanh Phúc', N'403', 1, 1, 90000.0000, 0.0000, 0.0000, 0.0000, 900000.0000, CAST(N'2022-04-02' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (4, 4, N'admin', N'Lê Tuấn Kiệt', N'502', 1, 1, 110000.0000, 0.0000, 0.0000, 330000.0000, 1430000.0000, CAST(N'2022-04-11' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (5, 5, N'admin', N'Võ Thu Thảo', N'305', 1, 1, 80000.0000, 0.0000, 0.0000, 30000.0000, 110000.0000, CAST(N'2022-04-17' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (6, 6, N'admin', N'Phan Hữu Tín', N'602', 1, 1, 1000000.0000, 0.0000, 0.0000, 285000.0000, 1285000.0000, CAST(N'2022-04-22' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (7, 7, N'admin', N'Lê Phú Quý', N'103', 1, 1, 40000.0000, 0.0000, 0.0000, 285000.0000, 325000.0000, CAST(N'2022-05-04' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (8, 8, N'admin', N'Trần Anh Kiệt', N'106', 1, 1, 40000.0000, 0.0000, 0.0000, 0.0000, 40000.0000, CAST(N'2022-07-11' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (9, 9, N'admin', N'Lê Công Vinh', N'204', 1, 1, 60000.0000, 0.0000, 0.0000, 285000.0000, 345000.0000, CAST(N'2022-10-31' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (10, 10, N'admin', N'Bùi Văn Tám', N'105', 1, 1, 250000.0000, 0.0000, 0.0000, 60000.0000, 310000.0000, CAST(N'2022-11-09' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (11, 11, N'admin', N'Trần Quang Trường', N'107', 1, 1, 250000.0000, 0.0000, 0.0000, 200000.0000, 450000.0000, CAST(N'2022-11-12' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (12, 12, N'admin', N'Lương Tấn Đạt', N'203', 1, 1, 400000.0000, 0.0000, 0.0000, 330000.0000, 730000.0000, CAST(N'2022-11-22' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (13, 13, N'admin', N'Ngô Anh Thư', N'502', 1, 1, 110000.0000, 0.0000, 0.0000, 0.0000, 110000.0000, CAST(N'2023-12-22' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (14, 14, N'admin', N'Lê Hồng Nhung', N'305', 1, 1, 80000.0000, 0.0000, 0.0000, 0.0000, 80000.0000, CAST(N'2023-01-12' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (15, 15, N'admin', N'Nguyễn Thảo Vy', N'601', 1, 1, 1000000.0000, 0.0000, 0.0000, 0.0000, 1000000.0000, CAST(N'2023-01-14' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (16, 16, N'admin', N'Lê Tuấn Kiệt', N'303', 1, 1, 80000.0000, 0.0000, 0.0000, 0.0000, 80000.0000, CAST(N'2023-01-14' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (17, 17, N'admin', N'Phan Hữu Tín', N'404', 1, 1, 90000.0000, 0.0000, 0.0000, 0.0000, 90000.0000, CAST(N'2023-01-14' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (18, 18, N'admin', N'Trần Hữu Độ', N'204', 1, 1, 60000.0000, 0.0000, 0.0000, 0.0000, 60000.0000, CAST(N'2023-01-14' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (19, 19, N'admin', N'Nguyễn Thanh Sang', N'101', 1, 1, 250000.0000, 0.0000, 0.0000, 285000.0000, 535000.0000, CAST(N'2023-01-15' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (20, 20, N'admin', N'Dương Toàn Ninh', N'102', 1, 1, 250000.0000, 0.0000, 0.0000, 0.0000, 250000.0000, CAST(N'2023-01-15' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (21, 21, N'admin', N'Nguyễn Thanh Phúc', N'103', 1, 1, 250000.0000, 0.0000, 0.0000, 0.0000, 250000.0000, CAST(N'2023-01-15' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (22, 22, N'admin', N'Lê Tuấn Kiệt', N'104', 1, 1, 40000.0000, 0.0000, 0.0000, 0.0000, 40000.0000, CAST(N'2023-01-16' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (23, 23, N'admin', N'Võ Thu Thảo', N'201', 1, 1, 60000.0000, 0.0000, 0.0000, 0.0000, 60000.0000, CAST(N'2023-01-17' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (24, 24, N'admin', N'Phan Hữu Tín', N'202', 1, 1, 400000.0000, 0.0000, 0.0000, 0.0000, 400000.0000, CAST(N'2023-01-17' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (25, 25, N'admin', N'Lê Phú Quý', N'203', 1, 1, 60000.0000, 0.0000, 0.0000, 0.0000, 60000.0000, CAST(N'2023-01-17' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (26, 26, N'admin', N'Trần Anh Kiệt', N'303', 1, 1, 80000.0000, 0.0000, 0.0000, 0.0000, 80000.0000, CAST(N'2023-01-19' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (27, 27, N'admin', N'Lê Công Vinh', N'304', 1, 1, 80000.0000, 0.0000, 0.0000, 0.0000, 80000.0000, CAST(N'2023-01-19' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (28, 28, N'admin', N'Bùi Văn Tám', N'305', 1, 1, 600000.0000, 0.0000, 0.0000, 0.0000, 60000.0000, CAST(N'2023-01-21' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (29, 29, N'admin', N'Trần Quang Trường', N'107', 1, 1, 250000.0000, 0.0000, 0.0000, 330000.0000, 580000.0000, CAST(N'2023-01-21' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (30, 30, N'admin', N'Lương Tấn Đạt', N'203', 1, 1, 400000.0000, 0.0000, 0.0000, 30000.0000, 430000.0000, CAST(N'2023-01-24' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (31, 31, N'admin', N'Ngô Anh Thư', N'102', 1, 1, 40000.0000, 0.0000, 0.0000, 50000.0000, 90000.0000, CAST(N'2023-01-24' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (32, 32, N'admin', N'Lê Hồng Nhung', N'305', 1, 1, 80000.0000, 0.0000, 0.0000, 30000.0000, 110000.0000, CAST(N'2023-01-25' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (33, 33, N'admin', N'Nguyễn Thảo Vy', N'101', 1, 1, 250000.0000, 0.0000, 0.0000, 0.0000, 250000.0000, CAST(N'2023-01-25' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (34, 34, N'admin', N'Lê Tuấn Kiệt', N'303', 1, 1, 80000.0000, 0.0000, 0.0000, 0.0000, 80000.0000, CAST(N'2023-01-27' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (35, 35, N'admin', N'Phan Hữu Tín', N'204', 1, 1, 60000.0000, 0.0000, 0.0000, 0.0000, 60000.0000, CAST(N'2023-01-28' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (36, 36, N'admin', N'Trần Hữu Độ', N'304', 1, 1, 80000.0000, 0.0000, 0.0000, 0.0000, 80000.0000, CAST(N'2023-01-28' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (37, 37, N'admin', N'Nguyễn Thảo Vy', N'201', 1, 1, 400000.0000, 0.0000, 0.0000, 0.0000, 400000.0000, CAST(N'2023-01-28' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (38, 38, N'admin', N'Lê Tuấn Kiệt', N'303', 1, 1, 80000.0000, 0.0000, 0.0000, 0.0000, 80000.0000, CAST(N'2023-02-02' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (39, 39, N'admin', N'Phan Hữu Tín', N'304', 1, 1, 80000.0000, 0.0000, 0.0000, 0.0000, 80000.0000, CAST(N'2023-02-02' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (40, 40, N'admin', N'Trần Hữu Độ', N'601', 1, 1, 110000.0000, 0.0000, 0.0000, 0.0000, 110000.0000, CAST(N'2023-02-02' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (41, 44, N'admin', N'Bùi Văn Tám', N'303', 1, 0, 600000.0000, 180000.0000, 0.0000, 0.0000, 780000.0000, CAST(N'2023-05-01' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (42, 42, N'admin', N'Lê Minh Cảnh', N'105', 1, 1, 40000.0000, 0.0000, 0.0000, 60000.0000, 100000.0000, CAST(N'2023-05-01' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (43, 54, N'admin', N'Đỗ Duy Manh', N'205', 1, 1, 400000.0000, 0.0000, 120000.0000, 0.0000, 520000.0000, CAST(N'2023-05-01' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (44, 53, N'admin', N'Đỗ Duy Manh', N'106', 1, 1, 250000.0000, 0.0000, 75000.0000, 0.0000, 325000.0000, CAST(N'2023-05-01' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (45, 49, N'admin', N'Huỳnh Thị Hồng Đào', N'104', 1, 1, 250000.0000, 0.0000, 75000.0000, 0.0000, 325000.0000, CAST(N'2023-05-01' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (46, 46, N'admin', N'Nguyễn Thị Thùy Chi', N'306', 1, 1, 80000.0000, 0.0000, 0.0000, 55000.0000, 135000.0000, CAST(N'2023-05-01' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (47, 52, N'admin', N'Ngô Anh Thư', N'102', 1, 1, 40000.0000, 0.0000, 0.0000, 110000.0000, 150000.0000, CAST(N'2023-05-01' AS Date), NULL)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
SET IDENTITY_INSERT [dbo].[Khac] ON 

INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (3, 6, CAST(N'12:00:00' AS Time), N'qua mốc checkin1 ')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (4, 3, CAST(N'12:00:00' AS Time), N'quá mốc checkin2')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (5, 2, CAST(N'14:00:00' AS Time), N'mốc checkout2')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (6, 5, CAST(N'14:00:00' AS Time), N'mốc checkout1')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (7, 30, NULL, N'phụ thu checkin1')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (8, 50, NULL, N'phụ thu checkin2')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (9, 20, NULL, N'phụ thu checkout1')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (10, 30, NULL, N'phụ thu checkout1')
SET IDENTITY_INSERT [dbo].[Khac] OFF
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH001', N'1', N'Bùi Văn Tám', 42, 1, N'0388884418', N'079081123456')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH002', N'1', N'Trần Quang Trường', 22, 1, N'0388884418', N'079201120918')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH003', N'2', N'Võ Thu Thảo', 20, 0, N'0966989156', N'079303123437')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH004', N'1', N'Phan Hữu Tín', 20, 1, N'0372890765', N'079203126437')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH005', N'1', N'Lê Phú Quý', 23, 1, N'0933548962', N'079200892438')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH006', N'1', N'Lương Tấn Đạt', 19, 1, N'0989856784', N'079204007575')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH007', N'1', N'Nguyễn Hoàng Anh Thư', 20, 0, N'0357888918', N'079303782729')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH008', N'1', N'Trần Hữu Độ', 40, 1, N'0945772884', N'079083002210')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH009', N'1', N'Trương Tuệ Mẫn', 24, 0, N'0988198231', N'079199009898')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH010', N'2', N'Trương Quang Dũng', 25, 1, N'0357899227', N'079098015643')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH011', N'2', N'Trần Anh Kiệt', 21, 1, N'0381298123', N'079202014545')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH012', N'1', N'Nguyễn Thảo Vy', 18, 0, N'0987234738', N'079305029383')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH013', N'1', N'Dương Toàn Ninh', 22, 1, N'0977392981', N'079201039874')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH014', N'1', N'Lê Thanh Thiên', 45, 1, N'0966138248', N'079078049817')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH015', N'1', N'Lê Tuấn Kiệt', 30, 1, N'0388819223', N'079093015628')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH016', N'2', N'Nguyễn Thanh Phúc', 28, 0, N'0901230019', N'079195026969')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH017', N'1', N'Ngô Anh Thư', 20, 0, N'0977382920', N'079303007537')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH018', N'1', N'Lê Công Vinh', 30, 1, N'0300239394', N'079093091192')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH019', N'2', N'Nguyễn Thanh Sang', 23, 1, N'0388193843', N'079200710928')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH020', N'1', N'Lê Hông Nhung', 23, 0, N'0992029111', N'079300898912')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH021', N'1', N'Đỗ Duy Manh', 29, 1, N'0971288729', N'079094001238')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH022', N'2', N'Lê Quốc Dương', 29, 1, N'0978872991', N'079094998176')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH023', N'2', N'Nguyễn Thị Cẩm Tiên', 21, 0, N'0367988182', N'079302988271')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH024', N'1', N'Nguyễn Thị Thùy Chi', 23, 0, N'0355198272', N'079300881729')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH025', N'1', N'Đào Bá Lộc', 23, 1, N'0309911922', N'079200981771')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH026', N'1', N'Phùng Tuấn Hưng', 31, 1, N'0398812214', N'079092287871')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH027', N'1', N'Nguyễn Anh Tuấn', 20, 1, N'0398812214', N'079203287117')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH028', N'1', N'Lê Đại Hải', 20, 1, N'0992121913', N'079203888199')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH029', N'1', N'Nguyễn Lý Hải', 40, 1, N'0399881773', N'079083998172')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH030', N'1', N'Nguyễn Thị Bích Ngọc', 23, 0, N'0312993981', N'079300829101')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH031', N'1', N'Trịnh Thị Ái Mỹ', 23, 0, N'0399881661', N'079300878273')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH032', N'1', N'Nguyễn Xuân Diệu', 23, 0, N'0367898112', N'079300987738')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH033', N'1', N'Lê Quang Hùng', 23, 1, N'0366178311', N'079200988138')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH034', N'1', N'Hồ Quốc Việt', 20, 1, N'0987187291', N'079203888162')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH035', N'1', N'Lê Minh Cảnh', 27, 1, N'0934772619', N'079096877482')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH036', N'1', N'Trần Duy Phú', 27, 1, N'0399172672', N'079096779192')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH037', N'1', N'Võ Minh Quốc', 27, 1, N'0355881823', N'079096028816')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH038', N'1', N'Huỳnh Thị Hồng Đào', 20, 0, N'0388129361', N'079303007676')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH039', N'1', N'Trần Anh Thư', 20, 0, N'0399827334', N'079303015437')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD]) VALUES (N'KH040', N'1', N'Nguyễn Thị Diệp', 25, 0, N'0988299123', N'079198018828')
INSERT [dbo].[LoaiKhachHang] ([MaLoaiKH], [TenLoaiKH], [TienGiam], [MoTa]) VALUES (N'1', N'Khách vãng lai', 0, N'')
INSERT [dbo].[LoaiKhachHang] ([MaLoaiKH], [TenLoaiKH], [TienGiam], [MoTa]) VALUES (N'2', N'Khách Vip', 10, N'')
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'P1', N'Phòng Tiêu Chuẩn(STD)', NULL, NULL, 40000.0000, 250000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'P2', N'Phòng Superior(SUP)', NULL, NULL, 60000.0000, 400000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'P3', N'Phòng Deluxe (DLX)', NULL, NULL, 80000.0000, 600000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'P4', N'Phòng Suite (SUT)', NULL, NULL, 90000.0000, 750000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'P5', N'Connecting room', NULL, NULL, 110000.0000, 1000000.0000)
INSERT [dbo].[Luong] ([MaLuong], [LuongTheoGio], [SoGioLam], [GhiChu]) VALUES (N'LuongNhanVien1', 25000.0000, 8, N'Lương cao thứ 2')
INSERT [dbo].[Luong] ([MaLuong], [LuongTheoGio], [SoGioLam], [GhiChu]) VALUES (N'LuongNhanVien2', 35000.0000, 8, N'Lương bình thường')
INSERT [dbo].[Luong] ([MaLuong], [LuongTheoGio], [SoGioLam], [GhiChu]) VALUES (N'LuongQuanLy', 50000.0000, 6, N'Lương cao nhất')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV001', N'Đinh Thanh Tòng', 1, CAST(N'2003-09-10' AS Date), N'0366459222', N'LuongQuanLy', N'Đồng Tháp', N'', CAST(N'2022-02-04' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV002', N'Nguyễn Trọng Tính', 1, CAST(N'2003-08-04' AS Date), N'0388654782', N'LuongQuanLy', N'TP HCM', N'', CAST(N'2022-02-05' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV003', N'Phan Hữu Tín', 1, CAST(N'2003-08-01' AS Date), N'0327858091', N'LuongNhanVien2', N'TP HCM', N'', CAST(N'2023-05-01' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV004', N'Phan Thanh Nam', 1, CAST(N'2003-03-23' AS Date), N'0989762854', N'LuongNhanVien1', N'Long An', N'', CAST(N'2023-05-01' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV005', N'Nguyễn Thị Hồng Thắm', 0, CAST(N'2003-05-16' AS Date), N'0398182932', N'LuongNhanVien2', N'Đồng Tháp', N'', CAST(N'2023-04-30' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV006', N'Lê Kiều Thi', 0, CAST(N'2000-05-10' AS Date), N'0382369182', N'LuongNhanVien2', N'Long An', N'', CAST(N'2022-03-09' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV007', N'Lê Anh Dũng', 1, CAST(N'2000-06-06' AS Date), N'0998823373', N'LuongNhanVien1', N'Thái Nguyên', N'', CAST(N'2023-05-01' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV008', N'Trần Quang Đại', 1, CAST(N'2001-06-20' AS Date), N'0981266392', N'LuongNhanVien2', N'Tây Ninh', N'', CAST(N'2023-04-30' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV009', N'Trương Tuệ Mẫn', 0, CAST(N'2001-06-20' AS Date), N'0357892797', N'LuongNhanVien1', N'Tây Ninh', N'', CAST(N'2023-05-01' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV010', N'Lê Hữu Duy', 1, CAST(N'2002-06-14' AS Date), N'0389893245', N'LuongNhanVien2', N'TP HCM', N'', CAST(N'2023-05-01' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV011', N'Trần Bá Huy', 1, CAST(N'2003-10-18' AS Date), N'0377328229', N'LuongNhanVien1', N'TP HCM', N'', CAST(N'2023-05-01' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV012', N'Nguyễn Lý Bảo Trâm', 0, CAST(N'2000-10-29' AS Date), N'0979875223', N'LuongNhanVien1', N'TP HCM', N'', CAST(N'2023-04-30' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV013', N'Thạch Quốc Bảo', 1, CAST(N'2003-10-19' AS Date), N'0357765891', N'LuongNhanVien2', N'TP HCM', N'', CAST(N'2023-05-01' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV014', N'Nguyễn Thanh Vy', 0, CAST(N'2001-08-23' AS Date), N'0988713557', N'LuongNhanVien1', N'TP HCM', N'null', CAST(N'2023-05-01' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV015', N'Đinh Thị Dung', 0, CAST(N'2003-02-11' AS Date), N'0399282117', N'LuongNhanVien1', N'Vũng Tàu', N'null', CAST(N'2023-02-07' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV016', N'Nguyễn Thị Lệ Phương', 0, CAST(N'2000-04-18' AS Date), N'0922328112', N'LuongNhanVien1', N'Vũng Tàu', N'null', CAST(N'2023-05-01' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV017', N'Trần Anh Dũng', 1, CAST(N'2000-06-20' AS Date), N'0988177344', N'LuongNhanVien1', N'Bến Tre', N'null', CAST(N'2023-05-01' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV018', N'Nguyễn Trọng Hiếu', 1, CAST(N'2000-03-16' AS Date), N'0991287312', N'LuongNhanVien1', N'Bến Tre', N'null', CAST(N'2023-05-01' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV020', N'Nguyễn Trí Thức', 1, CAST(N'2002-08-19' AS Date), N'0388199134', N'LuongNhanVien1', N'TP HCM', N'null', CAST(N'2023-05-01' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV021', N'Trần Minh Khôi', 1, CAST(N'1999-08-19' AS Date), N'0988198823', N'LuongNhanVien1', N'Bến Tre', N'null', CAST(N'2023-05-01' AS Date), N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'101', N'P1', 18, 1, 0, 1, N'null', N'trong', N'Phòng View Đẹp')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'102', N'P1', 20, 1, 0, 1, N'null', N'dondep', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'103', N'P1', 18, 1, 0, 1, N'null', N'sudung', N'Phòng View Đẹp')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'104', N'P1', 20, 1, 0, 1, N'null', N'dondep', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'105', N'P1', 20, 1, 0, 1, N'null', N'sudung', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'106', N'P1', 23, 1, 0, 1, N'null', N'dondep', N'Phòng rộng')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'107', N'P1', 20, 1, 0, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'108', N'P1', 23, 1, 0, 1, N'null', N'dattruoc', N'Phòng View Đẹp')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'201', N'P2', 23, 2, 1, 1, N'null', N'trong', N'Phòng View Đẹp')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'202', N'P2', 26, 2, 1, 1, N'null', N'dattruoc', N'Phòng rộng')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'203', N'P2', 26, 2, 1, 1, N'null', N'trong', N'Phòng rộng')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'204', N'P2', 23, 2, 1, 1, N'null', N'sudung', N'Phòng View Đẹp')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'205', N'P2', 26, 2, 1, 1, N'null', N'dondep', N'Phòng rộng')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'206', N'P2', 23, 2, 1, 1, N'null', N'trong', N'Phòng View Đẹp')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'207', N'P2', 26, 2, 1, 1, N'null', N'dattruoc', N'Phòng rộng')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'301', N'P3', 30, 3, 2, 1, N'null', N'sudung', N'Phòng rộng')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'302', N'P3', 30, 3, 2, 1, N'null', N'trong', N'Phòng rộng')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'303', N'P3', 27, 3, 2, 1, N'null', N'sudung', N'Phòng View Đẹp')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'304', N'P3', 30, 3, 0, 2, N'null', N'trong', N'Nhiều giường đôi')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'305', N'P3', 30, 3, 2, 1, N'null', N'trong', N'Phòng rộng')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'306', N'P3', 27, 3, 2, 1, N'null', N'dondep', N'View Phòng đẹp')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'401', N'P4', 33, 4, 1, 2, N'null', N'trong', N'Nhiều giường đôi')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'402', N'P4', 33, 4, 1, 2, N'null', N'trong', N'Nhiều giường đôi')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'403', N'P4', 35, 4, 2, 2, N'null', N'trong', N'Phòng rộng')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'404', N'P4', 35, 4, 2, 2, N'null', N'sudung', N'Phòng rộng')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'405', N'P4', 33, 4, 0, 3, N'null', N'trong', N'Nhiều giường đôi')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'406', N'P4', 35, 4, 2, 2, N'null', N'trong', N'Phòng Rộng')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'407', N'P4', 30, 4, 2, 1, N'null', N'sudung', N'View Phòng Đẹp')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'501', N'P5', 45, 5, 3, 2, N'null', N'trong', N'Phòng rộng')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'502', N'P5', 45, 5, 3, 2, N'null', N'sudung', N'Phòng rộng')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'503', N'P5', 40, 5, 2, 2, N'null', N'trong', N'View Phòng Đẹp')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'504', N'P5', 35, 5, 3, 1, N'null', N'sudung', N'Free nước trong tủ lạnh và một phần trái cây')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'505', N'P5', 40, 5, 2, 2, N'null', N'sudung', N'View Phòng Đẹp')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'601', N'P5', 45, 6, 3, 2, N'null', N'sudung', N'Phòng rộng')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'602', N'P5', 40, 6, 2, 2, N'null', N'trong', N'View Phòng Đẹp')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'603', N'P5', 45, 6, 2, 3, N'null', N'trong', N'Nhiều giường đôi')
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [MoTa]) VALUES (N'NhanVien', N'Nhân viên', NULL)
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [MoTa]) VALUES (N'QuanLy', N'Quản lý', NULL)
INSERT [dbo].[User] ([TenUser], [MatKhau], [NgayLap], [MaQuyen], [GhiChu], [MaNhanVien]) VALUES (N'admin', N'admin', CAST(N'2022-10-24' AS Date), N'QuanLy', NULL, N'NV001')
INSERT [dbo].[User] ([TenUser], [MatKhau], [NgayLap], [MaQuyen], [GhiChu], [MaNhanVien]) VALUES (N'admin1', N'admin1', CAST(N'2023-04-27' AS Date), N'QuanLy', NULL, N'NV002')
INSERT [dbo].[User] ([TenUser], [MatKhau], [NgayLap], [MaQuyen], [GhiChu], [MaNhanVien]) VALUES (N'NV003', N'123456', CAST(N'2023-05-03' AS Date), N'NhanVien', NULL, N'NV003')
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
