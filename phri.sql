-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2020 at 06:38 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phri`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `idPhri` int(11) NOT NULL,
  `text` varchar(141) NOT NULL,
  `date` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `comments_liked`
--

CREATE TABLE `comments_liked` (
  `idUser` int(11) NOT NULL,
  `idComment` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(282) NOT NULL,
  `idHost` int(11) NOT NULL,
  `creationDate` datetime NOT NULL DEFAULT current_timestamp(),
  `celebrationDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `name`, `description`, `idHost`, `creationDate`, `celebrationDate`) VALUES
(1, 'evento', 'primer evento', 1, '2020-07-15 12:19:13', '2020-11-13 00:00:00'),
(2, 'evento', 'primer evento', 1, '2020-07-15 12:20:04', '2020-11-13 17:09:00');

-- --------------------------------------------------------

--
-- Table structure for table `event_attendant`
--

CREATE TABLE `event_attendant` (
  `idEvent` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `status` bit(1) DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_attendant`
--

INSERT INTO `event_attendant` (`idEvent`, `idUser`, `status`) VALUES
(1, 1, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `follows`
--

CREATE TABLE `follows` (
  `idUserFollower` int(11) NOT NULL,
  `idUserFollowing` int(11) NOT NULL,
  `followingDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `photo`
--

CREATE TABLE `photo` (
  `id` int(11) NOT NULL,
  `url` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `phris`
--

CREATE TABLE `phris` (
  `id` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `text` varchar(141) NOT NULL,
  `date` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `phris_liked`
--

CREATE TABLE `phris_liked` (
  `idUser` int(11) NOT NULL,
  `idPhri` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(15) NOT NULL,
  `lastName` varchar(15) NOT NULL,
  `idProfilePhoto` int(11) DEFAULT NULL,
  `idCoverPhoto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `name`, `lastName`, `idProfilePhoto`, `idCoverPhoto`) VALUES
(1, 'klk', 'klk', 'minombre', 'miapellido', NULL, NULL),
(2, 'root', '1234', 'host', 'server', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `comments_liked`
--
ALTER TABLE `comments_liked`
  ADD PRIMARY KEY (`idUser`,`idComment`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `event_attendant`
--
ALTER TABLE `event_attendant`
  ADD PRIMARY KEY (`idEvent`,`idUser`);

--
-- Indexes for table `photo`
--
ALTER TABLE `photo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `phris`
--
ALTER TABLE `phris`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `phris_liked`
--
ALTER TABLE `phris_liked`
  ADD PRIMARY KEY (`idUser`,`idPhri`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `photo`
--
ALTER TABLE `photo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `phris`
--
ALTER TABLE `phris`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
