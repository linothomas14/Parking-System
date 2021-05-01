-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2021 at 07:01 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parking_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `user` varchar(30) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`user`, `pass`) VALUES
('admin', 'admin123'),
('penjagarajin', 'rajinbanget123');

-- --------------------------------------------------------

--
-- Table structure for table `parkir`
--

CREATE TABLE `parkir` (
  `id_kendaraan` int(10) NOT NULL,
  `plat_nomor` varchar(10) NOT NULL,
  `jenis_kendaraan` varchar(10) NOT NULL,
  `waktu_masuk` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `parkir`
--

INSERT INTO `parkir` (`id_kendaraan`, `plat_nomor`, `jenis_kendaraan`, `waktu_masuk`) VALUES
(15, 'B1212KK', 'Motor', '21/04/28 10:14:30'),
(20, 'B4444II', 'Bis', '21/04/29 8:45:38'),
(21, 'B3322', 'Motor', '21/04/29 16:30:29'),
(22, 'B3432UI', 'Motor', '21/04/28 19:56:37'),
(24, 'B2123DD', 'Truk', '21/04/29 17:35:28'),
(30, 'B1234TY', 'Mobil', '21/05/01 22:45:29');

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `id_kendaraan` int(10) NOT NULL,
  `plat_nomor` varchar(20) NOT NULL,
  `jenis_kendaraan` varchar(20) NOT NULL,
  `waktu_masuk` varchar(30) NOT NULL,
  `waktu_keluar` varchar(50) NOT NULL,
  `tarif` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`id_kendaraan`, `plat_nomor`, `jenis_kendaraan`, `waktu_masuk`, `waktu_keluar`, `tarif`) VALUES
(1, 'T5566JA', 'Motor', '21/04/28 10:56:37', '0', 5000),
(2, 'T5566JB', 'Motor', '21/04/26 10:56:37', '0', 7000),
(26, 'F4444YY', 'Truk', '21/04/29 17:50:21', '21/05/01 22:22:59', 30000),
(27, 'B1232', 'Motor', '21/04/30 15:28:02', '0', 5000),
(28, 'B1234DD', 'Bis', '21/04/30 15:31:06', '21/05/01 22:18:58', 15000),
(29, 'B1030FA', 'Motor', '21/04/30 16:05:35', '0', 5000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`user`);

--
-- Indexes for table `parkir`
--
ALTER TABLE `parkir`
  ADD PRIMARY KEY (`id_kendaraan`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`id_kendaraan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `parkir`
--
ALTER TABLE `parkir`
  MODIFY `id_kendaraan` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
  MODIFY `id_kendaraan` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
