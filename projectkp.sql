-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.38-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for projectkp
CREATE DATABASE IF NOT EXISTS `projectkp` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `projectkp`;

-- Dumping structure for table projectkp.absensisiswa
CREATE TABLE IF NOT EXISTS `absensisiswa` (
  `kode_input` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL,
  `januari_hadir` int(11) DEFAULT '0',
  `januari_sakit` int(11) DEFAULT '0',
  `januari_izin` int(11) DEFAULT '0',
  `februari_hadir` int(11) DEFAULT '0',
  `februari_sakit` int(11) DEFAULT '0',
  `februari_izin` int(11) DEFAULT '0',
  `maret_hadir` int(11) DEFAULT '0',
  `maret_sakit` int(11) DEFAULT '0',
  `maret_izin` int(11) DEFAULT '0',
  `april_hadir` int(11) DEFAULT '0',
  `april_sakit` int(11) DEFAULT '0',
  `april_izin` int(11) DEFAULT '0',
  `mei_hadir` int(11) DEFAULT '0',
  `mei_sakit` int(11) DEFAULT '0',
  `mei_izin` int(11) DEFAULT '0',
  PRIMARY KEY (`kode_input`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table projectkp.nilaisiswa
CREATE TABLE IF NOT EXISTS `nilaisiswa` (
  `kode_input` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) DEFAULT NULL,
  `mata_pelajaran` varchar(50) DEFAULT NULL,
  `nilai_januari` int(11) DEFAULT NULL,
  `nilai_februari` int(11) DEFAULT NULL,
  `nilai_maret` int(11) DEFAULT NULL,
  `nilai_april` int(11) DEFAULT NULL,
  `nilai_mei` int(11) DEFAULT NULL,
  PRIMARY KEY (`kode_input`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table projectkp.users
CREATE TABLE IF NOT EXISTS `users` (
  `email` varchar(50) NOT NULL,
  `unique_id` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `mobilephone` varchar(50) DEFAULT NULL,
  `encrypted_password` varchar(80) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`unique_id`),
  UNIQUE KEY `unique_id` (`unique_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
