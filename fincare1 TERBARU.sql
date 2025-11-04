-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 03, 2025 at 02:12 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fincare1`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `nik` int(11) NOT NULL,
  `kontak` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`nik`, `kontak`) VALUES
(64720001, '081263904821'),
(64720002, '081246491022'),
(64720003, '081239472033'),
(64720004, '081246284024');

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `nik` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `peran` enum('admin','pengguna') NOT NULL DEFAULT 'pengguna'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`nik`, `nama`, `email`, `password`, `peran`) VALUES
(64720001, 'Yardan', 'yardan@gmail.com', 'yardan123', 'admin'),
(64720002, 'Nabil', 'nabil@gmail.com', 'nabil123', 'admin'),
(64720003, 'Rabi', 'rabi@gmail.com', 'rabi123', 'admin'),
(64720004, 'Indah', 'indah@gmail.com', 'indah123', 'admin'),
(64720005, 'Ahmad Fauzan', 'ahmad.fauzan@gmail.com', '12345', 'pengguna'),
(64720006, 'Siti Aisyah', 'siti.aisyah@gmail.com', '12345', 'pengguna'),
(64720007, 'Budi Santoso', 'budi.santoso@gmail.com', '12345', 'pengguna'),
(64720008, 'Dewi Lestari', 'dewi.lestari@gmail.com', '12345', 'pengguna'),
(64720009, 'Rizky Pratama', 'rizky.pratama@gmail.com', '12345', 'pengguna'),
(64720010, 'Maya Sari', 'maya.sari@gmail.com', '12345', 'pengguna'),
(64720011, 'Dimas Putra', 'dimas.putra@gmail.com', '12345', 'pengguna'),
(64720012, 'Lia Ilma Haris', 'lia.ilma@gmail.com', '12345', 'pengguna'),
(64720013, 'Asep Suhendar', 'asep.suhendar@gmail.com', '12345', 'pengguna'),
(64720014, 'Indah Puspita', 'indah.puspita@gmail.com', '12345', 'pengguna'),
(64720015, 'Yoga Prasetyo', 'yoga.prasetyo@gmail.com', '12345', 'pengguna'),
(64720016, 'Aulia Rahmah', 'aulia.rahmah@gmail.com', '12345', 'pengguna'),
(64720017, 'Farah Nabila', 'farah.nabila@gmail.com', '12345', 'pengguna'),
(64720018, 'Iqbal Ramadhan', 'iqbal.ramadhan@gmail.com', '12345', 'pengguna'),
(64720019, 'Mega Yuliana', 'mega.yuliana@gmail.com', '12345', 'pengguna'),
(64720020, 'Andi Saputra', 'andi.saputra@gmail.com', '12345', 'pengguna'),
(64720021, 'Nadia Putri', 'nadia.putri@gmail.com', '12345', 'pengguna'),
(64720022, 'Hadi Kurniawan', 'hadi.kurniawan@gmail.com', '12345', 'pengguna'),
(64720023, 'Fajar Nugraha', 'fajar.nugraha@gmail.com', '12345', 'pengguna'),
(64720024, 'Salsa Rahma', 'salsa.rahma@gmail.com', '12345', 'pengguna'),
(64720025, 'Dedi Supriyadi', 'dedi.supriyadi@gmail.com', '12345', 'pengguna'),
(64720026, 'Putri Anjani', 'putri.anjani@gmail.com', '12345', 'pengguna'),
(64720027, 'Rahmat Hidayat', 'rahmat.hidayat@gmail.com', '12345', 'pengguna'),
(64720028, 'Ayu Fitriani', 'ayu.fitriani@gmail.com', '12345', 'pengguna'),
(64720029, 'Reza Firmansyah', 'reza.firmansyah@gmail.com', '12345', 'pengguna'),
(64720030, 'Tika Lestari', 'tika.lestari@gmail.com', '12345', 'pengguna'),
(64720031, 'Galang Saputra', 'galang.saputra@gmail.com', '12345', 'pengguna'),
(64720032, 'Rafli Prakoso', 'rafli.prakoso@gmail.com', '12345', 'pengguna'),
(64720033, 'Salsa Amelia', 'salsa.amelia@gmail.com', '12345', 'pengguna'),
(64720034, 'Bagus Permana', 'bagus.permana@gmail.com', '12345', 'pengguna'),
(64720035, 'Yuni Marlinah', 'yuni.marlinah@gmail.com', '12345', 'pengguna'),
(64720036, 'Arif Wibowo', 'arif.wibowo@gmail.com', '12345', 'pengguna'),
(64720037, 'Nisa Nuraini', 'nisa.nuraini@gmail.com', '12345', 'pengguna'),
(64720038, 'Faizal Ramadhan', 'faizal.ramadhan@gmail.com', '12345', 'pengguna'),
(64720039, 'Intan Dewi', 'intan.dewi@gmail.com', '12345', 'pengguna'),
(64720040, 'Mei Setiawan', 'mei.setiawan@gmail.com', '12345', 'pengguna'),
(64720041, 'Rafi Maulana', 'rafi.maulana@gmail.com', '12345', 'pengguna'),
(64720042, 'Aisyah Ramadhani', 'aisyah.ramadhani@gmail.com', '12345', 'pengguna'),
(64720043, 'Tiara Anggraini', 'tiara.anggraini@gmail.com', '12345', 'pengguna'),
(64720044, 'Fauzan Hermawan', 'fauzan.hermawan@gmail.com', '12345', 'pengguna'),
(64720045, 'Kirei', 'KireiHaru', '$2a$10$ip4SesfuCKPTkwst4Cejs.97Qjw9MV2Gf9Gi5Y6Elrn6fAUPdPCz.', 'pengguna'),
(64720046, 'Lestari Putri', 'lestari.24@gmail.com', '12345', 'pengguna'),
(64720047, 'Lestari Kirei', 'lestari.rei@gmail.com', '12345', 'pengguna');

-- --------------------------------------------------------

--
-- Table structure for table `insentif`
--

CREATE TABLE `insentif` (
  `id_insentif` int(11) NOT NULL,
  `id_sertifikat` int(11) NOT NULL,
  `jumlah_insentif` int(11) NOT NULL,
  `tanggal_cair` date DEFAULT NULL,
  `keterangan` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `insentif`
--

INSERT INTO `insentif` (`id_insentif`, `id_sertifikat`, `jumlah_insentif`, `tanggal_cair`, `keterangan`) VALUES
(1, 1, 300000, '2025-03-25', 'Bonus penyelesaian pelatihan kewirausahaan'),
(2, 2, 250000, '2025-03-26', 'Insentif pelatihan teknisi mekanik'),
(3, 3, 250000, '2025-04-06', 'Insentif telah disetujui dan dicairkan'),
(4, 4, 300000, '2025-03-27', 'Insentif pelatihan menjahit dasar'),
(5, 5, 275000, '2025-03-28', 'Bonus pelatihan administrasi perkantoran'),
(6, 6, 250000, '2025-04-07', 'Insentif telah disetujui dan dicairkan'),
(7, 7, 400000, '2025-03-29', 'Bonus menjahit profesional'),
(8, 8, 350000, '2025-03-30', 'Insentif pelatihan transportasi'),
(9, 9, 250000, '2025-04-08', 'Insentif telah disetujui dan dicairkan'),
(10, 10, 250000, '2025-03-31', 'Bonus pelatihan komputer administrasi'),
(11, 11, 250000, '2025-04-09', 'Insentif telah disetujui dan dicairkan'),
(12, 12, 350000, '2025-04-01', 'Bonus pelatihan pertanian modern'),
(13, 13, 280000, '2025-04-02', 'Insentif pelatihan administrasi digital'),
(14, 14, 250000, '2025-04-10', 'Insentif telah disetujui dan dicairkan'),
(15, 15, 300000, '2025-04-03', 'Insentif pelatihan menjahit profesional'),
(16, 16, 0, '2025-11-03', 'Sudah dicairkan'),
(17, 17, 275000, '2025-04-04', 'Bonus pelatihan komunikasi publik'),
(18, 18, 320000, '2025-04-05', 'Bonus penyelesaian pelatihan kuliner'),
(19, 19, 0, '2025-11-03', 'Sudah dicairkan');

-- --------------------------------------------------------

--
-- Table structure for table `pelatihan`
--

CREATE TABLE `pelatihan` (
  `id_pelatihan` int(11) NOT NULL,
  `nik_admin` int(11) NOT NULL,
  `judul_pelatihan` varchar(100) NOT NULL,
  `lembaga_pelatihan` varchar(100) NOT NULL,
  `periode` date NOT NULL,
  `harga_pelatihan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pelatihan`
--

INSERT INTO `pelatihan` (`id_pelatihan`, `nik_admin`, `judul_pelatihan`, `lembaga_pelatihan`, `periode`, `harga_pelatihan`) VALUES
(1, 64720001, 'Pelatihan Pertanian Modern', 'LKP Tani Sejahtera', '2025-10-01', 1200000),
(2, 64720002, 'Pelatihan Menjahit Dasar', 'LKP Menjahit Kreatif', '2025-10-01', 1000000),
(3, 64720003, 'Pelatihan Transportasi Dasar', 'LKP Transport Mandiri', '2025-10-01', 1500000),
(4, 64720004, 'Pelatihan Kewirausahaan UMKM Maju', 'Badan UMKM Maju', '2025-10-01', 1800000),
(5, 64720001, 'Pelatihan Administrasi Perkantoran', 'LKP Admin Center', '2025-10-01', 1300000),
(6, 64720002, 'Pelatihan Keamanan Dasar', 'LKP Satpam Indonesia', '2025-10-01', 1600000),
(7, 64720003, 'Pelatihan Logistik Nasional', 'LKP Logistik Nasional', '2025-10-01', 1500000),
(8, 64720004, 'Pelatihan Cleaning Service Dasar', 'LKP Bersih Mandiri', '2025-10-01', 900000),
(9, 64720001, 'Pelatihan Sopir Profesional', 'LKP Transport Mandiri', '2025-11-01', 2000000),
(10, 64720002, 'Pelatihan Menjahit Menengah', 'LKP Menjahit Kreatif', '2025-11-01', 1200000),
(11, 64720003, 'Pelatihan Digital Marketing', 'Badan UMKM Maju', '2025-11-01', 1800000),
(12, 64720004, 'Pelatihan Administrasi Digital', 'LKP Admin Center', '2025-11-01', 1500000),
(13, 64720001, 'Pelatihan Keamanan Lingkungan', 'LKP Satpam Indonesia', '2025-11-01', 1700000),
(14, 64720002, 'Pelatihan Logistik Menengah', 'LKP Logistik Nasional', '2025-11-01', 1600000),
(15, 64720003, 'Pelatihan Pertanian Cerdas', 'LKP Tani Sejahtera', '2025-11-01', 1800000),
(16, 64720004, 'Pelatihan Menjahit Kreatif', 'LKP Menjahit Kreatif', '2025-11-01', 1200000),
(17, 64720001, 'Pelatihan Cleaning Service Profesional', 'LKP Bersih Mandiri', '2025-11-01', 1100000),
(18, 64720002, 'Pelatihan Kewirausahaan Kreatif', 'Badan UMKM Maju', '2025-12-01', 2000000),
(19, 64720003, 'Pelatihan Petani Modern', 'LKP Tani Sejahtera', '2025-12-01', 1400000),
(20, 64720004, 'Pelatihan Satpam Profesional', 'LKP Satpam Indonesia', '2025-12-01', 1900000),
(21, 64720001, 'Pelatihan Logistik Profesional', 'LKP Logistik Nasional', '2025-12-01', 2200000),
(22, 64720002, 'Pelatihan Administrasi Perkantoran Lanjutan', 'LKP Admin Center', '2025-12-01', 1300000),
(23, 64720003, 'Pelatihan Menjahit Gaun', 'LKP Menjahit Kreatif', '2025-12-01', 1100000),
(24, 64720004, 'Pelatihan Pertanian Organik', 'LKP Tani Sejahtera', '2025-12-01', 1600000),
(25, 64720001, 'Pelatihan Cleaning Service Profesional', 'LKP Bersih Mandiri', '2025-12-01', 1200000),
(26, 64720002, 'Pelatihan Transportasi Industri', 'LKP Transport Mandiri', '2026-01-01', 1800000),
(27, 64720003, 'Pelatihan Pertanian Digital', 'LKP Tani Sejahtera', '2026-01-01', 1600000),
(28, 64720004, 'Pelatihan Menjahit Lanjutan', 'LKP Menjahit Kreatif', '2026-01-01', 1600000),
(29, 64720001, 'Pelatihan Kewirausahaan Digital', 'Badan UMKM Maju', '2026-01-01', 2000000),
(30, 64720002, 'Pelatihan Logistik Lanjutan', 'LKP Logistik Nasional', '2026-01-01', 1900000),
(31, 64720003, 'Pelatihan Admin Kantor Lanjutan', 'LKP Admin Center', '2026-01-01', 1500000),
(32, 64720004, 'Pelatihan UMKM Digital', 'Badan UMKM Maju', '2026-01-01', 2200000),
(33, 64720001, 'Pelatihan Sopir Bus', 'LKP Transport Mandiri', '2026-01-01', 2100000),
(34, 64720002, 'Pelatihan Satpam Gedung', 'LKP Satpam Indonesia', '2026-01-01', 2000000),
(35, 64720003, 'Pelatihan Menjahit Seragam', 'LKP Menjahit Kreatif', '2026-02-01', 1500000),
(36, 64720004, 'Pelatihan Pertanian Urban', 'LKP Tani Sejahtera', '2026-02-01', 1300000),
(37, 64720001, 'Pelatihan Fashion Muslim', 'LKP Menjahit Kreatif', '2026-02-01', 1700000),
(38, 64720002, 'Pelatihan Logistik Retail', 'LKP Logistik Nasional', '2026-02-01', 1600000),
(39, 64720003, 'Pelatihan Kasir Digital', 'LKP Admin Center', '2026-02-01', 1400000),
(40, 64720004, 'Pelatihan Cleaning Service Perhotelan', 'LKP Bersih Mandiri', '2026-02-01', 1900000),
(41, 64720001, 'Pelatihan Kewirausahaan Rumah Kopi', 'Badan UMKM Maju', '2026-02-01', 2000000),
(42, 64720002, 'Pelatihan Pariwisata', 'LKP Transport Mandiri', '2026-03-01', 2200000),
(43, 64720003, 'Pelatihan Pertanian Berkebun', 'LKP Tani Sejahtera', '2026-03-01', 1400000),
(44, 64720004, 'Pelatihan UMKM Kuliner Kreatif', 'Badan UMKM Maju', '2026-03-01', 1800000),
(45, 64720001, 'Pelatihan Logistik Lanjut', 'LKP Logistik Nasional', '2026-03-01', 1900000),
(46, 64720002, 'Pelatihan Kantor Digital', 'LKP Admin Center', '2026-03-01', 1500000),
(47, 64720003, 'Pelatihan Cleaning Service Profesional', 'LKP Bersih Mandiri', '2026-03-01', 2000000),
(48, 64720004, 'Pelatihan Menjahit Seragam Sekolah', 'LKP Menjahit Kreatif', '2026-03-01', 1600000),
(49, 64720001, 'Pelatihan Pertanian Organik Lanjutan', 'LKP Tani Sejahtera', '2026-03-01', 1500000),
(50, 64720002, 'Pelatihan Manajemen UMKM', 'Badan UMKM Maju', '2026-03-01', 1800000);

-- --------------------------------------------------------

--
-- Table structure for table `pelatihan_pengguna`
--

CREATE TABLE `pelatihan_pengguna` (
  `ID` int(11) NOT NULL,
  `TANGGALBELI` datetime NOT NULL,
  `id_pelatihan` int(11) NOT NULL,
  `nik_pengguna` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pelatihan_pengguna`
--

INSERT INTO `pelatihan_pengguna` (`ID`, `TANGGALBELI`, `id_pelatihan`, `nik_pengguna`) VALUES
(1, '2025-11-03 10:20:17', 12, 64720047),
(2, '2025-11-03 10:22:21', 8, 64720047);

-- --------------------------------------------------------

--
-- Table structure for table `pengajuan_bantuan`
--

CREATE TABLE `pengajuan_bantuan` (
  `id_pengajuan` int(11) NOT NULL,
  `nik_pengguna` int(11) NOT NULL,
  `nik_admin` int(11) DEFAULT NULL,
  `id_pelatihan` int(11) DEFAULT NULL,
  `alasan_pengajuan` text NOT NULL,
  `bidang_diminati` varchar(100) NOT NULL,
  `tanggal_pengajuan` datetime NOT NULL DEFAULT current_timestamp(),
  `status_pengajuan` enum('MENUNGGU','DITERIMA','DITOLAK') DEFAULT 'MENUNGGU'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengajuan_bantuan`
--

INSERT INTO `pengajuan_bantuan` (`id_pengajuan`, `nik_pengguna`, `nik_admin`, `id_pelatihan`, `alasan_pengajuan`, `bidang_diminati`, `tanggal_pengajuan`, `status_pengajuan`) VALUES
(1, 64720005, 64720001, 3, 'Ingin meningkatkan keterampilan berjualan online', 'Kewirausahaan', '2025-01-10 00:00:00', 'DITERIMA'),
(2, 64720006, 64720001, NULL, 'Butuh pelatihan dasar keuangan untuk usaha kecil', 'Administrasi', '2025-01-11 00:00:00', 'MENUNGGU'),
(3, 64720007, 64720002, 3, 'Ingin membuka bengkel sendiri, butuh pelatihan mekanik', 'Teknologi', '2025-01-12 00:00:00', 'DITERIMA'),
(4, 64720008, 64720004, NULL, 'Mengajukan bantuan namun berkas tidak lengkap', 'Pertanian', '2025-01-13 00:00:00', 'DITERIMA'),
(5, 64720009, 64720003, NULL, 'Butuh pelatihan tambahan agar bisa naik jabatan', 'Administrasi', '2025-01-14 00:00:00', 'MENUNGGU'),
(6, 64720010, 64720003, 18, 'Ingin memperdalam pengetahuan manajemen usaha', 'Kewirausahaan', '2025-01-15 00:00:00', 'DITERIMA'),
(7, 64720011, 64720004, NULL, 'Ingin mengikuti pelatihan sopir profesional', 'Transportasi', '2025-01-16 00:00:00', 'MENUNGGU'),
(8, 64720012, 64720004, 2, 'Butuh pelatihan keterampilan menjahit agar punya penghasilan tambahan', 'Menjahit', '2025-01-17 00:00:00', 'DITERIMA'),
(9, 64720013, 64720001, NULL, 'Ingin belajar memperbaiki motor untuk usaha kecil', 'Teknologi', '2025-01-18 00:00:00', 'MENUNGGU'),
(10, 64720014, 64720002, NULL, 'Mengajukan bidang yang tidak sesuai latar belakang', 'Pertanian', '2025-01-19 00:00:00', 'DITOLAK'),
(11, 64720015, 64720003, 5, 'Ingin menambah keterampilan administrasi perkantoran', 'Administrasi', '2025-01-20 00:00:00', 'DITERIMA'),
(12, 64720016, 64720004, NULL, 'Butuh pelatihan pelayanan pelanggan untuk usaha laundry', 'Kewirausahaan', '2025-01-21 00:00:00', 'MENUNGGU'),
(13, 64720017, 64720001, 8, 'Ingin menambah kemampuan kerja di bidang kebersihan', 'Cleaning Service', '2025-01-22 00:00:00', 'DITERIMA'),
(14, 64720018, 64720002, NULL, 'Butuh pelatihan membuat produk kuliner rumahan', 'Kewirausahaan', '2025-01-23 00:00:00', 'MENUNGGU'),
(15, 64720019, 64720003, 10, 'Ingin memperdalam keterampilan menjahit untuk membuka usaha', 'Menjahit', '2025-01-24 00:00:00', 'DITERIMA'),
(16, 64720020, 64720004, NULL, 'Butuh pelatihan tambahan agar bisa naik jabatan', 'Administrasi', '2025-01-25 00:00:00', 'MENUNGGU'),
(17, 64720021, 64720001, 29, 'Ingin meningkatkan keterampilan dagang di pasar', 'Kewirausahaan', '2025-01-26 00:00:00', 'DITERIMA'),
(18, 64720022, 64720002, NULL, 'Mengajukan pelatihan tanpa melengkapi berkas', 'Pertanian', '2025-01-27 00:00:00', 'DITOLAK'),
(19, 64720023, 64720003, 9, 'Ingin belajar mengemudi untuk pekerjaan transportasi', 'Transportasi', '2025-01-28 00:00:00', 'DITERIMA'),
(20, 64720024, 64720004, NULL, 'Butuh pelatihan digital marketing untuk toko online', 'Kewirausahaan', '2025-01-29 00:00:00', 'MENUNGGU'),
(21, 64720025, 64720001, 12, 'Butuh pelatihan dasar komputer untuk administrasi', 'Teknologi', '2025-01-30 00:00:00', 'DITERIMA'),
(22, 64720026, 64720002, NULL, 'Ingin meningkatkan kemampuan komunikasi kerja', 'Administrasi', '2025-01-31 00:00:00', 'MENUNGGU'),
(23, 64720027, 64720003, NULL, 'Mengajukan bantuan dana tanpa rekomendasi', 'Kewirausahaan', '2025-02-01 00:00:00', 'DITOLAK'),
(24, 64720028, 64720004, 32, 'Ingin memperluas jaringan bisnis kuliner', 'Kewirausahaan', '2025-02-02 00:00:00', 'DITERIMA'),
(25, 64720029, 64720001, NULL, 'Butuh pelatihan agar bisa bekerja di hotel', 'Cleaning Service', '2025-02-03 00:00:00', 'MENUNGGU'),
(26, 64720030, 64720002, 1, 'Ingin pelatihan pertanian modern', 'Pertanian', '2025-02-04 00:00:00', 'DITERIMA'),
(27, 64720031, 64720003, NULL, 'Ingin belajar keterampilan baru untuk meningkatkan pendapatan', 'Kewirausahaan', '2025-02-05 00:00:00', 'MENUNGGU'),
(28, 64720032, 64720004, NULL, 'Mengajukan pelatihan logistik namun gagal verifikasi', 'Logistik', '2025-02-06 00:00:00', 'DITOLAK'),
(29, 64720033, 64720001, 12, 'Ingin mengikuti pelatihan administrasi digital', 'Administrasi', '2025-02-07 00:00:00', 'DITERIMA'),
(30, 64720034, 64720002, NULL, 'Butuh pelatihan kepemimpinan dan komunikasi kerja', 'Administrasi', '2025-02-08 00:00:00', 'MENUNGGU'),
(31, 64720035, 64720003, 17, 'Ingin memperdalam keterampilan kebersihan rumah tangga', 'Cleaning Service', '2025-02-09 00:00:00', 'DITERIMA'),
(32, 64720036, 64720004, NULL, 'Butuh pelatihan dasar komputer untuk kantor', 'Teknologi', '2025-02-10 00:00:00', 'MENUNGGU'),
(33, 64720037, 64720001, 16, 'Ingin memperluas kemampuan menjahit profesional', 'Menjahit', '2025-02-11 00:00:00', 'DITERIMA'),
(34, 64720038, 64720002, NULL, 'Mengajukan pelatihan yang tidak sesuai syarat', 'Pertanian', '2025-02-12 00:00:00', 'DITOLAK'),
(35, 64720039, 64720003, NULL, 'Butuh pelatihan pemasaran digital untuk usaha kecil', 'Kewirausahaan', '2025-02-13 00:00:00', 'MENUNGGU'),
(36, 64720040, 64720004, 44, 'Ingin pelatihan barista untuk membuka kafe kecil', 'Kuliner', '2025-02-14 00:00:00', 'DITERIMA'),
(37, 64720041, 64720004, NULL, 'Butuh pelatihan logistik agar bisa kerja di gudang', 'Logistik', '2025-02-15 00:00:00', 'DITERIMA'),
(38, 64720042, 64720002, 22, 'Ingin pelatihan komunikasi kerja untuk pelayanan publik', 'Administrasi', '2025-02-16 00:00:00', 'DITERIMA'),
(39, 64720043, 64720003, NULL, 'Butuh pelatihan digital marketing namun gagal verifikasi', 'Kewirausahaan', '2025-02-17 00:00:00', 'DITOLAK'),
(40, 64720044, 64720004, 44, 'Ingin pelatihan tata boga agar bisa buka usaha sendiri', 'Kuliner', '2025-02-18 00:00:00', 'DITERIMA'),
(42, 64720047, 64720004, NULL, 'Saya ingin mengupgrade skill sekaligus membuka usaha', 'Komputer', '2025-11-03 10:00:00', 'DITERIMA');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `nik` int(11) NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `pekerjaan` varchar(100) NOT NULL,
  `penghasilan` int(11) NOT NULL,
  `tanggal_daftar` date NOT NULL,
  `saldo_akun` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`nik`, `alamat`, `pekerjaan`, `penghasilan`, `tanggal_daftar`, `saldo_akun`) VALUES
(64720005, 'Jl. Melati No.10, Samarinda', 'Wiraswasta', 2500000, '2025-01-15', 0),
(64720006, 'Jl. Dahlia No.8, Balikpapan', 'Karyawan Swasta', 3200000, '2025-01-16', 0),
(64720007, 'Jl. Cempaka No.5, Tenggarong', 'Guru', 4000000, '2025-01-17', 0),
(64720008, 'Jl. Mawar No.2, Samarinda', 'Pedagang', 2800000, '2025-01-18', 2500000),
(64720009, 'Jl. Flamboyan No.4, Bontang', 'Penjahit', 2600000, '2025-01-19', 0),
(64720010, 'Jl. Kenanga No.7, Samarinda', 'Buruh Harian', 2300000, '2025-01-20', 0),
(64720011, 'Jl. Anggrek No.3, Balikpapan', 'Supir', 3000000, '2025-01-21', 0),
(64720012, 'Jl. Seruni No.6, Tenggarong', 'Kasir Toko', 2700000, '2025-01-22', 0),
(64720013, 'Jl. Melur No.8, Samarinda', 'Petani', 2400000, '2025-01-23', 0),
(64720014, 'Jl. Mawar No.9, Balikpapan', 'Ibu Rumah Tangga', 2000000, '2025-01-24', 0),
(64720015, 'Jl. Anggrek No.4, Samarinda', 'Montir', 3100000, '2025-01-25', 0),
(64720016, 'Jl. Dahlia No.2, Bontang', 'Penjual Gorengan', 2200000, '2025-01-26', 0),
(64720017, 'Jl. Kenanga No.1, Samarinda', 'Karyawan Toko', 2600000, '2025-01-27', 0),
(64720018, 'Jl. Melati No.11, Balikpapan', 'Barista', 2800000, '2025-01-28', 0),
(64720019, 'Jl. Mawar No.12, Tenggarong', 'Desainer', 3500000, '2025-01-29', 0),
(64720020, 'Jl. Flamboyan No.15, Samarinda', 'Penjahit', 2600000, '2025-01-30', 0),
(64720021, 'Jl. Kenanga No.9, Samarinda', 'Sopir Pribadi', 3200000, '2025-02-01', 0),
(64720022, 'Jl. Cempaka No.2, Bontang', 'Petani', 2300000, '2025-02-02', 0),
(64720023, 'Jl. Melur No.5, Samarinda', 'Pedagang', 2700000, '2025-02-03', 0),
(64720024, 'Jl. Anggrek No.10, Balikpapan', 'Guru Les', 4000000, '2025-02-04', 0),
(64720025, 'Jl. Mawar No.7, Samarinda', 'Pegawai Kantor', 4500000, '2025-02-05', 0),
(64720026, 'Jl. Flamboyan No.11, Bontang', 'Koki', 3100000, '2025-02-06', 0),
(64720027, 'Jl. Dahlia No.6, Samarinda', 'Kasir', 2800000, '2025-02-07', 0),
(64720028, 'Jl. Cempaka No.4, Balikpapan', 'Cleaning Service', 2500000, '2025-02-08', 0),
(64720029, 'Jl. Melati No.5, Samarinda', 'Kurir', 2700000, '2025-02-09', 0),
(64720030, 'Jl. Mawar No.3, Balikpapan', 'Supir', 2900000, '2025-02-10', 0),
(64720031, 'Jl. Kenanga No.2, Samarinda', 'Penjahit', 2300000, '2025-02-11', 0),
(64720032, 'Jl. Melur No.7, Tenggarong', 'Buruh Pabrik', 2500000, '2025-02-12', 0),
(64720033, 'Jl. Cempaka No.6, Samarinda', 'Pedagang', 2700000, '2025-02-13', 0),
(64720034, 'Jl. Mawar No.11, Balikpapan', 'Cleaning Service', 2600000, '2025-02-14', 0),
(64720035, 'Jl. Melati No.2, Bontang', 'Supir', 3000000, '2025-02-15', 0),
(64720036, 'Jl. Dahlia No.9, Samarinda', 'Penjahit', 2500000, '2025-02-16', 0),
(64720037, 'Jl. Flamboyan No.8, Balikpapan', 'Buruh Harian', 2200000, '2025-02-17', 0),
(64720038, 'Jl. Kenanga No.5, Samarinda', 'Pedagang', 2600000, '2025-02-18', 0),
(64720039, 'Jl. Mawar No.1, Bontang', 'Karyawan Toko', 2800000, '2025-02-19', 0),
(64720040, 'Jl. Anggrek No.9, Samarinda', 'Cleaning Service', 2400000, '2025-02-20', 0),
(64720041, 'Jl. Flamboyan No.10, Balikpapan', 'Barista', 2700000, '2025-02-21', 2500000),
(64720042, 'Jl. Melur No.4, Samarinda', 'Pegawai Kantor', 3500000, '2025-02-22', 0),
(64720043, 'Jl. Mawar No.13, Bontang', 'Karyawan Swasta', 3200000, '2025-02-23', 0),
(64720044, 'Jl. Cempaka No.8, Samarinda', 'Pedagang', 2600000, '2025-02-24', 0),
(64720045, 'Jl. Bunga', 'Mahasiswa', 0, '2025-10-23', 0),
(64720046, 'Jl. Rapak', 'Mahasiswa', 3000000, '2025-11-03', 0),
(64720047, 'Jalan Rapak', 'Mahasiswa', 3000000, '2025-11-03', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `sertifikat_pelatihan`
--

CREATE TABLE `sertifikat_pelatihan` (
  `id_sertifikat` int(11) NOT NULL,
  `nik_pengguna` int(11) NOT NULL,
  `id_pelatihan` int(11) DEFAULT NULL,
  `tanggal_upload` date NOT NULL,
  `dokumen` varchar(255) DEFAULT NULL,
  `status` enum('MENUNGGU','DITERIMA','DITOLAK') DEFAULT 'MENUNGGU'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sertifikat_pelatihan`
--

INSERT INTO `sertifikat_pelatihan` (`id_sertifikat`, `nik_pengguna`, `id_pelatihan`, `tanggal_upload`, `dokumen`, `status`) VALUES
(1, 64720005, 1, '2025-03-01', 'sertifikat_64720005.pdf', 'DITERIMA'),
(2, 64720007, 2, '2025-03-02', 'sertifikat_64720007.pdf', 'DITERIMA'),
(3, 64720010, 3, '2025-03-03', 'sertifikat_64720010.pdf', 'MENUNGGU'),
(4, 64720012, 4, '2025-03-04', 'sertifikat_64720012.pdf', 'DITERIMA'),
(5, 64720015, 5, '2025-03-05', 'sertifikat_64720015.pdf', 'DITERIMA'),
(6, 64720017, 6, '2025-03-06', 'sertifikat_64720017.pdf', 'MENUNGGU'),
(7, 64720019, 7, '2025-03-07', 'sertifikat_64720019.pdf', 'DITERIMA'),
(8, 64720021, 8, '2025-03-08', 'sertifikat_64720021.pdf', 'DITERIMA'),
(9, 64720023, 9, '2025-03-09', 'sertifikat_64720023.pdf', 'DITOLAK'),
(10, 64720025, 10, '2025-03-10', 'sertifikat_64720025.pdf', 'DITERIMA'),
(11, 64720028, 11, '2025-03-11', 'sertifikat_64720028.pdf', 'MENUNGGU'),
(12, 64720030, 12, '2025-03-12', 'sertifikat_64720030.pdf', 'DITERIMA'),
(13, 64720033, 13, '2025-03-13', 'sertifikat_64720033.pdf', 'DITERIMA'),
(14, 64720035, 14, '2025-03-14', 'sertifikat_64720035.pdf', 'DITOLAK'),
(15, 64720037, 15, '2025-03-15', 'sertifikat_64720037.pdf', 'DITERIMA'),
(16, 64720040, 16, '2025-03-16', 'sertifikat_64720040.pdf', 'DITERIMA'),
(17, 64720042, 17, '2025-03-17', 'sertifikat_64720042.pdf', 'DITERIMA'),
(18, 64720044, 18, '2025-03-18', 'sertifikat_64720044.pdf', 'DITERIMA'),
(19, 64720047, 12, '2025-11-03', 'https://drive.google.com/file/d/18_R81TUWm0Niu5kuz1IuwWk3E8Y3kSVK/view?usp=drive_link', 'DITERIMA');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`nik`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `insentif`
--
ALTER TABLE `insentif`
  ADD PRIMARY KEY (`id_insentif`),
  ADD UNIQUE KEY `id_sertifikat` (`id_sertifikat`);

--
-- Indexes for table `pelatihan`
--
ALTER TABLE `pelatihan`
  ADD PRIMARY KEY (`id_pelatihan`),
  ADD KEY `nik_admin` (`nik_admin`);

--
-- Indexes for table `pelatihan_pengguna`
--
ALTER TABLE `pelatihan_pengguna`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_pelatihan_pengguna_id_pelatihan` (`id_pelatihan`),
  ADD KEY `FK_pelatihan_pengguna_nik_pengguna` (`nik_pengguna`);

--
-- Indexes for table `pengajuan_bantuan`
--
ALTER TABLE `pengajuan_bantuan`
  ADD PRIMARY KEY (`id_pengajuan`),
  ADD KEY `nik_pengguna` (`nik_pengguna`),
  ADD KEY `nik_admin` (`nik_admin`),
  ADD KEY `id_pelatihan` (`id_pelatihan`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `sertifikat_pelatihan`
--
ALTER TABLE `sertifikat_pelatihan`
  ADD PRIMARY KEY (`id_sertifikat`),
  ADD KEY `nik_pengguna` (`nik_pengguna`),
  ADD KEY `id_pelatihan` (`id_pelatihan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akun`
--
ALTER TABLE `akun`
  MODIFY `nik` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64720048;

--
-- AUTO_INCREMENT for table `insentif`
--
ALTER TABLE `insentif`
  MODIFY `id_insentif` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `pelatihan`
--
ALTER TABLE `pelatihan`
  MODIFY `id_pelatihan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `pelatihan_pengguna`
--
ALTER TABLE `pelatihan_pengguna`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pengajuan_bantuan`
--
ALTER TABLE `pengajuan_bantuan`
  MODIFY `id_pengajuan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `sertifikat_pelatihan`
--
ALTER TABLE `sertifikat_pelatihan`
  MODIFY `id_sertifikat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `FK_admin_nik` FOREIGN KEY (`nik`) REFERENCES `akun` (`nik`),
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`nik`) REFERENCES `akun` (`nik`);

--
-- Constraints for table `insentif`
--
ALTER TABLE `insentif`
  ADD CONSTRAINT `FK_insentif_id_sertifikat` FOREIGN KEY (`id_sertifikat`) REFERENCES `sertifikat_pelatihan` (`id_sertifikat`),
  ADD CONSTRAINT `insentif_ibfk_1` FOREIGN KEY (`id_sertifikat`) REFERENCES `sertifikat_pelatihan` (`id_sertifikat`);

--
-- Constraints for table `pelatihan`
--
ALTER TABLE `pelatihan`
  ADD CONSTRAINT `pelatihan_ibfk_1` FOREIGN KEY (`nik_admin`) REFERENCES `admin` (`nik`);

--
-- Constraints for table `pelatihan_pengguna`
--
ALTER TABLE `pelatihan_pengguna`
  ADD CONSTRAINT `FK_pelatihan_pengguna_id_pelatihan` FOREIGN KEY (`id_pelatihan`) REFERENCES `pelatihan` (`id_pelatihan`),
  ADD CONSTRAINT `FK_pelatihan_pengguna_nik_pengguna` FOREIGN KEY (`nik_pengguna`) REFERENCES `akun` (`nik`);

--
-- Constraints for table `pengajuan_bantuan`
--
ALTER TABLE `pengajuan_bantuan`
  ADD CONSTRAINT `FK_pengajuan_bantuan_nik_admin` FOREIGN KEY (`nik_admin`) REFERENCES `admin` (`nik`),
  ADD CONSTRAINT `FK_pengajuan_bantuan_nik_pengguna` FOREIGN KEY (`nik_pengguna`) REFERENCES `akun` (`nik`),
  ADD CONSTRAINT `pengajuan_bantuan_ibfk_1` FOREIGN KEY (`nik_pengguna`) REFERENCES `pengguna` (`nik`),
  ADD CONSTRAINT `pengajuan_bantuan_ibfk_2` FOREIGN KEY (`nik_admin`) REFERENCES `admin` (`nik`),
  ADD CONSTRAINT `pengajuan_bantuan_ibfk_3` FOREIGN KEY (`id_pelatihan`) REFERENCES `pelatihan` (`id_pelatihan`);

--
-- Constraints for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD CONSTRAINT `FK_pengguna_nik` FOREIGN KEY (`nik`) REFERENCES `akun` (`nik`),
  ADD CONSTRAINT `pengguna_ibfk_1` FOREIGN KEY (`nik`) REFERENCES `akun` (`nik`);

--
-- Constraints for table `sertifikat_pelatihan`
--
ALTER TABLE `sertifikat_pelatihan`
  ADD CONSTRAINT `FK_sertifikat_pelatihan_id_pelatihan` FOREIGN KEY (`id_pelatihan`) REFERENCES `pelatihan` (`id_pelatihan`),
  ADD CONSTRAINT `FK_sertifikat_pelatihan_nik_pengguna` FOREIGN KEY (`nik_pengguna`) REFERENCES `akun` (`nik`),
  ADD CONSTRAINT `sertifikat_pelatihan_ibfk_1` FOREIGN KEY (`nik_pengguna`) REFERENCES `pengguna` (`nik`),
  ADD CONSTRAINT `sertifikat_pelatihan_ibfk_2` FOREIGN KEY (`id_pelatihan`) REFERENCES `pelatihan` (`id_pelatihan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
