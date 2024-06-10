-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-02-2024 a las 23:39:35
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.0.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdconsultoriorenteria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultadosparametro`
--

CREATE TABLE `resultadosparametro` (
  `NoResultadosParametro` int(11) NOT NULL,
  `Valor_de_Analisis` varchar(45) DEFAULT NULL,
  `ParametrosExamen_NoPametroExa` int(10) NOT NULL,
  `CitaExamen_idCitaExamen` int(11) NOT NULL,
  `CitaExamen_ExamenInvidual_NoExamen` int(10) NOT NULL,
  `CitaExamen_tcita_NoCita` int(5) NOT NULL,
  `CitaExamen_tcita_NoMedico` int(10) NOT NULL,
  `CitaExamen_tcita_NoPaciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `resultadosparametro`
--
ALTER TABLE `resultadosparametro`
  ADD PRIMARY KEY (`NoResultadosParametro`,`ParametrosExamen_NoPametroExa`,`CitaExamen_idCitaExamen`,`CitaExamen_ExamenInvidual_NoExamen`,`CitaExamen_tcita_NoCita`,`CitaExamen_tcita_NoMedico`,`CitaExamen_tcita_NoPaciente`),
  ADD KEY `fk_ResultadosParametro_ParametrosExamen1_idx` (`ParametrosExamen_NoPametroExa`),
  ADD KEY `fk_ResultadosParametro_CitaExamen1_idx` (`CitaExamen_idCitaExamen`,`CitaExamen_ExamenInvidual_NoExamen`,`CitaExamen_tcita_NoCita`,`CitaExamen_tcita_NoMedico`,`CitaExamen_tcita_NoPaciente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `resultadosparametro`
--
ALTER TABLE `resultadosparametro`
  MODIFY `NoResultadosParametro` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `resultadosparametro`
--
ALTER TABLE `resultadosparametro`
  ADD CONSTRAINT `fk_ResultadosParametro_CitaExamen1` FOREIGN KEY (`CitaExamen_idCitaExamen`,`CitaExamen_ExamenInvidual_NoExamen`,`CitaExamen_tcita_NoCita`,`CitaExamen_tcita_NoMedico`,`CitaExamen_tcita_NoPaciente`) REFERENCES `citaexamen` (`idCitaExamen`, `ExamenInvidual_NoExamen`, `tcita_NoCita`, `tcita_NoMedico`, `tcita_NoPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ResultadosParametro_ParametrosExamen1` FOREIGN KEY (`ParametrosExamen_NoPametroExa`) REFERENCES `parametrosexamen` (`NoPametroExa`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
