-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 26 jan. 2022 à 08:20
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `safeguarddemo`
--

-- --------------------------------------------------------

--
-- Structure de la table `appointment`
--

CREATE TABLE `appointment` (
  `id` int(11) NOT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `vaccin_type` varchar(255) DEFAULT NULL,
  `vaccin_cov` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `next_vaccin_date` date DEFAULT NULL,
  `last_vaccin_date` date DEFAULT NULL,
  `email` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id`, `first_name`, `last_name`, `address`, `vaccin_type`, `vaccin_cov`, `phone`, `next_vaccin_date`, `last_vaccin_date`, `email`) VALUES
(1, 'Cami', 'Dono', 'Mulhouse', 'PFIZER', '2', '', '2022-01-24', '2022-01-24', 'cami@gmail.com'),
(2, 'Cami', 'Dono', 'Mulhouse', 'PFIZER', '2', '', '2022-01-25', '2022-01-25', 'cami@gmail.com'),
(3, 'Cami', 'Dono', 'Mulhouse', 'PFIZER', '2', '', '2022-01-25', '2022-01-25', 'cami@gmail.com'),
(4, 'Cami', 'Dono', 'Mulhouse', 'PFIZER', '2', '', '2022-01-25', '2022-01-25', 'cami@gmail.com'),
(5, 'tassadit', 'BOUTATA', 'mulhouse', 'Pfizer', '3', '0605767034', '2022-02-02', '2021-12-12', 'sasy.boutata@gmail.com'),
(6, 'toto', 'Kevin', 'Paris', 'moderna', '2', '07893215', '2022-01-29', '2021-11-18', 'kevin18@gmail.com'),
(7, 'fifo', 'toto', 'Mulhouse', 'Pfizer', '3', '0605403456', '2022-01-29', '2021-12-13', 'toto12@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `staff`
--

CREATE TABLE `staff` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `staff`
--

INSERT INTO `staff` (`id`, `first_name`, `last_name`, `username`, `phone`, `email`) VALUES
(1, 'Carlos', 'Maria', NULL, 'Maria', 'carloa@gmail.com'),
(2, 'Carlos', 'Maria', NULL, 'Maria', 'carloa@gmail.com'),
(3, 'Carlos', 'Maria', NULL, 'Maria', 'carloa@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `stock`
--

CREATE TABLE `stock` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity` varchar(255) DEFAULT NULL,
  `date` date DEFAULT curdate()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `stock`
--

INSERT INTO `stock` (`id`, `name`, `quantity`, `date`) VALUES
(1, 'MASK', '0', '2022-01-24'),
(2, 'GEL', '0', '2022-01-24'),
(3, 'VACCIN-PFIZER', '0', '2022-01-24'),
(4, 'VACCIN-MODERNA', '0', '2022-01-24'),
(5, 'TEST-PCR', '0', '2022-01-24'),
(6, 'TEST-ANTI', '0', '2022-01-24'),
(7, 'MASK', '500', '2022-01-25'),
(8, 'TEST-PCR', '1234', '2022-01-25'),
(9, 'TEST-ANTI', '300', '2022-01-25'),
(10, 'VACCIN-PFIZER', '30', '2022-01-25'),
(11, 'VACCIN-MODERNA', '400', '2022-01-25'),
(12, 'MASK', '56', '2022-01-26'),
(13, 'TEST-PCR', '12', '2022-01-26'),
(14, 'TEST-ANTI', '342', '2022-01-26'),
(15, 'VACCIN-PFIZER', '200', '2022-01-26'),
(16, 'VACCIN-MODERNA', '356', '2022-01-26');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `staff_id` (`staff_id`),
  ADD KEY `patient_id` (`patient_id`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `stock`
--
ALTER TABLE `stock`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`),
  ADD CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
