-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2019 at 11:13 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `c_id` int(4) NOT NULL,
  `type` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`c_id`, `type`) VALUES
(1, 'vaiyar banano'),
(2, 'Headphone'),
(4, 'Cover'),
(9, 'Mouse'),
(10, 'Mobile'),
(58, 'Keyboard');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cus_id` int(4) NOT NULL,
  `cus_name` varchar(25) NOT NULL,
  `cus_add` varchar(45) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `log_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cus_id`, `cus_name`, `cus_add`, `phone`, `log_id`) VALUES
(1, 'Numayer', 'Baridhara,Dhaka 1212', '01699587403', 1212),
(4, 'Hassan', 'Chashara,Dhaka', '01499678530', 6363),
(5, 'Boshir Khan', 'Rampura,Dhaka', '01811097543', 2578),
(6, 'Billal Ahmed', 'Puran Dhaka,Dhaka', '01755863450', 9999),
(8, 'Khalid Hassan', 'Gulshan,Dhaka', '01677873564', 6475),
(9, 'Navid Iqbal', 'Rampura,Dhaka', '01799507634', 3434);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `e_id` int(4) NOT NULL,
  `e_name` varchar(25) NOT NULL,
  `job` varchar(15) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `Salary` int(6) NOT NULL,
  `log_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`e_id`, `e_name`, `job`, `phone`, `Salary`, `log_id`) VALUES
(1, 'Misson', 'President', '01722007980', 35000, 1111),
(2, 'Abdullah Kabir', 'Accountant', '01788953642', 17500, 6969),
(3, 'Humayon Kabir', 'Salesman', '01521078933', 20000, 2323),
(4, 'Sefatullah', 'Guard', '01630059176', 5500, 6767),
(5, 'Akram Hossain', 'Manager', '01521304432', 27000, 2222),
(6, 'Qazi Iqbal', 'Guard', '01911087612', 4520, 3333),
(7, 'Habibullah Akbar', 'Helper', '01533789642', 12000, 7532);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `log_id` varchar(100) NOT NULL,
  `password` varchar(1000) NOT NULL,
  `status` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`log_id`, `password`, `status`) VALUES
('1111', '1111', 3),
('1212', '1212', 1),
('1234', '1234', 2),
('2323', '2323', 2),
('2578', '12345', 1),
('3434', '3434', 1),
('6363', '0078', 1),
('6475', '6475', 1),
('6666', '6666', 2),
('6969', '6969', 2),
('7532', '7532', 2),
('9999', '9999', 1);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `o_id` varchar(10) NOT NULL,
  `p_id` int(3) NOT NULL,
  `cus_id` int(4) NOT NULL,
  `quantity` int(3) NOT NULL,
  `price` int(5) NOT NULL,
  `date` varchar(15) NOT NULL,
  `e_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`o_id`, `p_id`, `cus_id`, `quantity`, `price`, `date`, `e_id`) VALUES
('2', 3, 6363, 3, 81000, '05/05/2019', 2323),
('33', 1, 1212, 2, 10700, '09/01/2019', 2323),
('35', 58, 1212, 2, 900, '03/04/2018', 6363),
('45', 58, 1212, 6, 5700, '04/05/2019', 6767),
('63', 3, 1212, 2, 1900, '03/04/2019', 6363),
('99', 3, 6363, 3, 81000, '05/05/2019', 2323);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `p_id` int(3) NOT NULL,
  `pName` varchar(20) NOT NULL,
  `modelNo` varchar(10) NOT NULL,
  `price` int(5) NOT NULL,
  `c_id` int(4) NOT NULL,
  `s_id` int(6) NOT NULL,
  `warranty` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`p_id`, `pName`, `modelNo`, `price`, `c_id`, `s_id`, `warranty`) VALUES
(1, 'Sony Stereo', 'A21GF66', 5400, 6969, 2436, 2),
(3, 'Samsung J7Max', 'A2JK087', 27000, 10, 5, 1),
(58, 'Dell Mouse', 'C1S714H', 950, 9, 42, 1),
(987, 'biggo bigg', 'x3876', 2, 1, 25, 2);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `s_id` int(6) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`s_id`, `Quantity`) VALUES
(1, 40),
(5, 70),
(25, 900),
(42, 85),
(478, 90),
(2436, 70);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cus_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`e_id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`log_id`(5));

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`o_id`(7));

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`p_id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`s_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `c_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `cus_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `e_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `p_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8011;
--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `s_id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2437;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
