-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 04 mai 2021 à 00:49
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `notre_projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `apprenant`
--

CREATE TABLE `apprenant` (
  `idapprenant` int(10) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `date_naissance` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `apprenant`
--

INSERT INTO `apprenant` (`idapprenant`, `nom`, `prenom`, `date_naissance`, `email`, `password`) VALUES
(1, 'll', 'mm', '22/4/2001', 'xx@xxdvffver.com', 'yyy'),
(10, 'Ali', 'ben salah', '22/4/2001', 'Alibensalah@yahoo.fr', 'aliali10'),
(27, 'ergerg', 'regerg', '6/7/1998', 'rger', 'gergge'),
(28, 'mohamed', 'benhjal', '6/7/2002', 'mohamedbh@gmail.com', 'ergerg');

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `idcours` int(10) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `idformation` int(10) NOT NULL,
  `contenu` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`idcours`, `nom`, `idformation`, `contenu`, `description`) VALUES
(50, 'j2ee chap1', 111, 'http://docs.google.com/gview?url=http://infolab.stanford.edu/pub/papers/google.pdf&embedded=true', 'ceci le premier cours du j2EE:'),
(51, 'cours j2ee', 109, 'https://docs.google.com/gview?url=http://infolab.stanford.edu/pub/papers/google.pdf&embedded=true', 'chap j2ee');

-- --------------------------------------------------------

--
-- Structure de la table `etudier`
--

CREATE TABLE `etudier` (
  `idapprenant` int(10) NOT NULL,
  `idformation` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etudier`
--

INSERT INTO `etudier` (`idapprenant`, `idformation`) VALUES
(1, 0),
(1, 0),
(10, 106),
(10, 100),
(10, 102),
(10, 111),
(10, 109),
(28, 100),
(28, 101),
(28, 109);

-- --------------------------------------------------------

--
-- Structure de la table `formateur`
--

CREATE TABLE `formateur` (
  `idformateur` int(10) NOT NULL,
  `nomfr` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `date_naissance` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `formateur`
--

INSERT INTO `formateur` (`idformateur`, `nomfr`, `prenom`, `date_naissance`, `email`, `password`) VALUES
(10, 'fedi', 'benzid', '9/10/2000', 'fadibenzid@gmail.com', '123aze'),
(11, 'kabil', 'fouzai', '2/7/2000', 'kabilfouzai@yahoo.fr', 'mlkoiu'),
(12, 'xccx', 'nnn', '6/7/1998', 'alibensalah@yahoo.fr', 'gthrth'),
(13, 'aymen', 'masmoudi', '6/7/2000', 'xx@xx.com', 'tgrbrth'),
(113, 'Jbeli', 'FouFou', '6/7/1998', 'mohameddhia@gmail.com', 'ytjyj'),
(114, 'Malek', 'Gasmi', '6/7/2000', 'Gasama@yahoo.fr', 'fgerfsdfr4864'),
(115, 'nayrouz', 'abdaoui', '6/7/2000', 'nayrouz@gmail.com', 'azert123');

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `idformation` int(10) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `idformateur` int(10) NOT NULL,
  `nomfr` varchar(30) NOT NULL,
  `description` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `formation`
--

INSERT INTO `formation` (`idformation`, `nom`, `idformateur`, `nomfr`, `description`) VALUES
(100, 'Javascript', 10, 'fedi', 'Commencer a apprendre Javascript'),
(101, 'Angular', 11, 'kabil', 'Framework n=1'),
(106, 'nodejs', 10, 'Fedi', 'commencer en nodejs'),
(109, 'J2EE', 13, 'Aymen', 'commencer en J2EE'),
(111, 'J2EE', 11, 'kabil', 'commencer en j2ee'),
(114, 'ASD', 11, 'kabil', 'commencer en ASD'),
(126, 'Anglais', 114, 'GESMI', 'lets learn english'),
(130, 'Angular', 113, 'JBELI', 'commencer en angular');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `apprenant`
--
ALTER TABLE `apprenant`
  ADD PRIMARY KEY (`idapprenant`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `password` (`password`);

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`idcours`),
  ADD KEY `idformation` (`idformation`);

--
-- Index pour la table `formateur`
--
ALTER TABLE `formateur`
  ADD PRIMARY KEY (`idformateur`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `password` (`password`);

--
-- Index pour la table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`idformation`),
  ADD KEY `idformateur` (`idformateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `apprenant`
--
ALTER TABLE `apprenant`
  MODIFY `idapprenant` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT pour la table `cours`
--
ALTER TABLE `cours`
  MODIFY `idcours` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT pour la table `formateur`
--
ALTER TABLE `formateur`
  MODIFY `idformateur` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;

--
-- AUTO_INCREMENT pour la table `formation`
--
ALTER TABLE `formation`
  MODIFY `idformation` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=131;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cours`
--
ALTER TABLE `cours`
  ADD CONSTRAINT `cours_ibfk_1` FOREIGN KEY (`idformation`) REFERENCES `formation` (`idformation`);

--
-- Contraintes pour la table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `formation_ibfk_1` FOREIGN KEY (`idformateur`) REFERENCES `formateur` (`idformateur`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
