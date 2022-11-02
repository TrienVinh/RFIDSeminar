-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2022 at 04:28 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `seminar`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `BillID` varchar(20) NOT NULL,
  `Date` date NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`BillID`, `Date`, `Total`) VALUES
('HD01', '2022-05-03', 29000000),
('HD02', '2022-05-01', 31000000),
('HD03', '2022-05-14', 18000000);

-- --------------------------------------------------------

--
-- Table structure for table `billdetail`
--

CREATE TABLE `billdetail` (
  `BillID` varchar(20) NOT NULL,
  `ProductInstanceID` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `billdetail`
--

INSERT INTO `billdetail` (`BillID`, `ProductInstanceID`) VALUES
('HD01', 'SP20664'),
('HD02', 'SP25996'),
('HD02', 'SP60585'),
('HD03', 'SP46565');

-- --------------------------------------------------------

--
-- Table structure for table `productinstance`
--

CREATE TABLE `productinstance` (
  `ProductInstanceID` varchar(20) NOT NULL,
  `ProductLineID` varchar(20) NOT NULL,
  `IsPurchased` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productinstance`
--

INSERT INTO `productinstance` (`ProductInstanceID`, `ProductLineID`, `IsPurchased`) VALUES
('SP20664', 'DSP05', 0),
('SP23102', 'DSP01', 1),
('SP25996', 'DSP02', 0),
('SP43361', 'DSP01', 1),
('SP46565', 'DSP02', 0),
('SP56051', 'DSP02', 1),
('SP60585', 'DSP03', 0),
('SP62527', 'DSP03', 1),
('SP82934', 'DSP01', 0),
('SP98300', 'DSP04', 1);

-- --------------------------------------------------------

--
-- Table structure for table `productline`
--

CREATE TABLE `productline` (
  `ProductLineID` varchar(20) NOT NULL,
  `ProductLineName` varchar(255) NOT NULL,
  `Price` double NOT NULL,
  `Stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productline`
--

INSERT INTO `productline` (`ProductLineID`, `ProductLineName`, `Price`, `Stock`) VALUES
('DSP01', 'Iphone 13', 22000000, 50),
('DSP02', 'Iphone 12', 18000000, 50),
('DSP03', 'Iphone 11', 13000000, 50),
('DSP04', 'Iphone 13 Mini', 19000000, 50),
('DSP05', 'Iphone 13 Pro', 29000000, 50);

-- --------------------------------------------------------

--
-- Table structure for table `tagread`
--

CREATE TABLE `tagread` (
  `TagReadID` varchar(20) NOT NULL,
  `ProductInstanceID` varchar(20) NOT NULL,
  `Time` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tagread`
--

INSERT INTO `tagread` (`TagReadID`, `ProductInstanceID`, `Time`) VALUES
('300F 4F57 3AD0 01C0 ', 'SP20664', '2022-05-02'),
('4D4F 5300', 'SP23102', '2022-05-01'),
('00FF F145 2000 44C6 ', 'SP25996', '2022-05-03'),
(' E200 3072 0205 0238', 'SP46565', '2022-04-13'),
('E200 1026 8110 0274 ', 'SP56051', '2022-04-15'),
('E200 1026 8110 0159 ', 'SP62527', '2022-04-19');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`BillID`);

--
-- Indexes for table `billdetail`
--
ALTER TABLE `billdetail`
  ADD PRIMARY KEY (`BillID`,`ProductInstanceID`),
  ADD KEY `ProductInstanceID` (`ProductInstanceID`);

--
-- Indexes for table `productinstance`
--
ALTER TABLE `productinstance`
  ADD PRIMARY KEY (`ProductInstanceID`,`ProductLineID`),
  ADD KEY `ProductLineID` (`ProductLineID`);

--
-- Indexes for table `productline`
--
ALTER TABLE `productline`
  ADD PRIMARY KEY (`ProductLineID`);

--
-- Indexes for table `tagread`
--
ALTER TABLE `tagread`
  ADD PRIMARY KEY (`ProductInstanceID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `billdetail`
--
ALTER TABLE `billdetail`
  ADD CONSTRAINT `billdetail_ibfk_1` FOREIGN KEY (`ProductInstanceID`) REFERENCES `productinstance` (`ProductInstanceID`),
  ADD CONSTRAINT `billdetail_ibfk_2` FOREIGN KEY (`BillID`) REFERENCES `bill` (`BillID`);

--
-- Constraints for table `productinstance`
--
ALTER TABLE `productinstance`
  ADD CONSTRAINT `productinstance_ibfk_1` FOREIGN KEY (`ProductLineID`) REFERENCES `productline` (`ProductLineID`);

--
-- Constraints for table `tagread`
--
ALTER TABLE `tagread`
  ADD CONSTRAINT `tagread_ibfk_1` FOREIGN KEY (`ProductInstanceID`) REFERENCES `productinstance` (`ProductInstanceID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
