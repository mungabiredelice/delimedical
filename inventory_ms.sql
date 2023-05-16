-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2023 at 06:50 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory_ms`
--

-- --------------------------------------------------------

--
-- Table structure for table `medecine`
--

CREATE TABLE `medecine` (
  `id` bigint(20) NOT NULL,
  `approval` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medecine`
--

INSERT INTO `medecine` (`id`, `approval`, `category`, `name`, `price`, `quantity`, `status`, `type`) VALUES
(1, 'approved', 'old', 'quarthem', 2000, 10, 'available', 'Other parts');

-- --------------------------------------------------------

--
-- Table structure for table `signup_data`
--

CREATE TABLE `signup_data` (
  `uid` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT 'user'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signup_data`
--

INSERT INTO `signup_data` (`uid`, `email`, `id_card`, `name`, `password`, `phone`, `role`) VALUES
(1, 'nduwayo@gmail.com', '73847834', 'nduwayo', 'nana', '87938479', NULL),
(2, NULL, NULL, 'admin', 'admin', NULL, 'admin'),
(3, 'delice@gmail.com', '9876543567', 'delice', 'nana', '32427834', 'normal');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `medecine`
--
ALTER TABLE `medecine`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `signup_data`
--
ALTER TABLE `signup_data`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `medecine`
--
ALTER TABLE `medecine`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `signup_data`
--
ALTER TABLE `signup_data`
  MODIFY `uid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
