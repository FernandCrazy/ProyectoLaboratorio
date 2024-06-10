-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-05-2024 a las 01:40:15
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
-- Estructura de tabla para la tabla `citaexamen`
--

CREATE TABLE `citaexamen` (
  `idCitaExamen` int(11) NOT NULL,
  `ExamenInvidual_NoExamen` int(10) NOT NULL,
  `tcita_NoCita` int(5) NOT NULL,
  `tcita_NoMedico` int(10) NOT NULL,
  `tcita_NoPaciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `citaexamen`
--

INSERT INTO `citaexamen` (`idCitaExamen`, `ExamenInvidual_NoExamen`, `tcita_NoCita`, `tcita_NoMedico`, `tcita_NoPaciente`) VALUES
(5, 1, 3, 1, 1),
(6, 3, 3, 1, 1),
(7, 1, 4, 1, 2),
(8, 2, 4, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `examengrupo`
--

CREATE TABLE `examengrupo` (
  `idExamenGrupo` int(11) NOT NULL,
  `ExamenInvidual_NoExamen` int(10) NOT NULL,
  `Grupo_NoGrupo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `examengrupo`
--

INSERT INTO `examengrupo` (`idExamenGrupo`, `ExamenInvidual_NoExamen`, `Grupo_NoGrupo`) VALUES
(1, 3, 1),
(2, 2, 1),
(3, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `exameninvidual`
--

CREATE TABLE `exameninvidual` (
  `NoExamen` int(10) NOT NULL,
  `Nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `exameninvidual`
--

INSERT INTO `exameninvidual` (`NoExamen`, `Nombre`) VALUES
(1, 'GLOBULOS ROJOS'),
(2, 'EUCOCITOS'),
(3, 'GLOBULOS BLANCOS'),
(4, 'HEMOGLOBINA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `examenperfil`
--

CREATE TABLE `examenperfil` (
  `idExamenPerfil` int(11) NOT NULL,
  `ExamenInvidual_NoExamen` int(10) NOT NULL,
  `Perfil_NoPerfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `examenperfil`
--

INSERT INTO `examenperfil` (`idExamenPerfil`, `ExamenInvidual_NoExamen`, `Perfil_NoPerfil`) VALUES
(1, 2, 1),
(2, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

CREATE TABLE `grupo` (
  `NoGrupo` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `grupo`
--

INSERT INTO `grupo` (`NoGrupo`, `Nombre`) VALUES
(1, 'COVID');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parametrosexamen`
--

CREATE TABLE `parametrosexamen` (
  `NoPametroExa` int(10) NOT NULL,
  `NoExamen` int(10) NOT NULL,
  `Sexo` varchar(45) DEFAULT NULL,
  `EdadInicial` varchar(45) DEFAULT NULL,
  `EdadFinal` varchar(45) DEFAULT NULL,
  `Unidades` varchar(100) NOT NULL,
  `ValoresReferencia` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `parametrosexamen`
--

INSERT INTO `parametrosexamen` (`NoPametroExa`, `NoExamen`, `Sexo`, `EdadInicial`, `EdadFinal`, `Unidades`, `ValoresReferencia`) VALUES
(1, 1, 'F', '1', '99', 'xmm3', '4 - 12'),
(2, 1, 'M', '1', '66', 'xmm3', '4  -  12'),
(3, 2, 'M', '1', '60', 'mmx3', '12 - 20'),
(4, 2, 'F', '1', '60', 'mmx1', '12 - 20'),
(5, 3, 'M', '1', '80', 'xmm1', '5 - 10'),
(6, 3, 'F', '1', '80', 'xmm1', '5 - 10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil`
--

CREATE TABLE `perfil` (
  `NoPerfil` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `perfil`
--

INSERT INTO `perfil` (`NoPerfil`, `Nombre`) VALUES
(1, 'DIABETES');

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
-- Volcado de datos para la tabla `resultadosparametro`
--

INSERT INTO `resultadosparametro` (`NoResultadosParametro`, `Valor_de_Analisis`, `ParametrosExamen_NoPametroExa`, `CitaExamen_idCitaExamen`, `CitaExamen_ExamenInvidual_NoExamen`, `CitaExamen_tcita_NoCita`, `CitaExamen_tcita_NoMedico`, `CitaExamen_tcita_NoPaciente`) VALUES
(23, '4', 1, 7, 1, 4, 1, 2),
(24, '5', 4, 8, 2, 4, 1, 2),
(25, '4', 1, 5, 1, 3, 1, 1),
(26, '5', 6, 6, 3, 3, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tadmin`
--

CREATE TABLE `tadmin` (
  `idAdmin` int(11) NOT NULL,
  `usuario` varchar(100) DEFAULT NULL,
  `contrasena` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tadmin`
--

INSERT INTO `tadmin` (`idAdmin`, `usuario`, `contrasena`) VALUES
(2, 'Fernando', '1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tcita`
--

CREATE TABLE `tcita` (
  `NoCita` int(5) NOT NULL,
  `Hora` time NOT NULL,
  `Fecha` date NOT NULL,
  `Prueba` varchar(50) NOT NULL,
  `Estado` varchar(50) NOT NULL,
  `Resultados` varchar(20) NOT NULL,
  `NoMedico` int(10) NOT NULL,
  `NoPaciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tcita`
--

INSERT INTO `tcita` (`NoCita`, `Hora`, `Fecha`, `Prueba`, `Estado`, `Resultados`, `NoMedico`, `NoPaciente`) VALUES
(3, '17:37:15', '2024-05-14', 'Diabates ', 'Listo', 'Listo', 1, 1),
(4, '18:10:58', '2024-05-14', 'diabetes', 'Listo', 'En proceso', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tmedicos`
--

CREATE TABLE `tmedicos` (
  `Clave` int(10) NOT NULL,
  `Cargo` varchar(100) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `TelefonoCel` varchar(12) NOT NULL,
  `Telefono` varchar(12) NOT NULL,
  `Ciudad` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tmedicos`
--

INSERT INTO `tmedicos` (`Clave`, `Cargo`, `Nombre`, `Direccion`, `TelefonoCel`, `Telefono`, `Ciudad`) VALUES
(1, 'Medico', 'Fernando Gonzalez', 'La Grana #120', '3171286773', '3173824883', 'Autlan de Navarro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tpacientes`
--

CREATE TABLE `tpacientes` (
  `NoPaciente` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Edad` varchar(3) NOT NULL,
  `Sexo` varchar(2) NOT NULL,
  `FechaNac` varchar(15) NOT NULL,
  `RFC` varchar(100) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `TelefonoCel` varchar(100) NOT NULL,
  `Telefono` varchar(100) NOT NULL,
  `Curp` varchar(100) NOT NULL,
  `Ciudad` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tpacientes`
--

INSERT INTO `tpacientes` (`NoPaciente`, `Nombre`, `Edad`, `Sexo`, `FechaNac`, `RFC`, `Direccion`, `TelefonoCel`, `Telefono`, `Curp`, `Ciudad`, `Email`) VALUES
(1, 'Juana Fernandez Cortez', '64', 'F', '24-07-1954', 'FHGJHFJOJEWGU', 'La Grana #120', '3171286773', '3173824883', 'JHFJJFFJFJHGDFSHJD', 'Autlan de Navarro', 'fernandgonzlez@gmail.com'),
(2, 'Mary Moran', '55', 'F', '15/03/1983', 'MAMORAN048520', 'Clemente amaya 155', '3173021854', '3171235892', 'MAMORAN12358H7', 'Autlán ', 'soniconu11@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tusuario`
--

CREATE TABLE `tusuario` (
  `idUsuario` int(11) NOT NULL,
  `Usuario` varchar(255) DEFAULT NULL,
  `Contrasena` mediumblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tusuario`
--

INSERT INTO `tusuario` (`idUsuario`, `Usuario`, `Contrasena`) VALUES
(1, 'Sonia ', 0x988c49fe1d93bf64be69a1115c35e344),
(2, 'Julian', 0x6ee9bb82a0a89aec577afffc133f2fca);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citaexamen`
--
ALTER TABLE `citaexamen`
  ADD PRIMARY KEY (`idCitaExamen`,`ExamenInvidual_NoExamen`,`tcita_NoCita`,`tcita_NoMedico`,`tcita_NoPaciente`),
  ADD KEY `fk_ExamenInvidual_has_tcita_tcita1_idx` (`tcita_NoCita`,`tcita_NoMedico`,`tcita_NoPaciente`),
  ADD KEY `fk_ExamenInvidual_has_tcita_ExamenInvidual1_idx` (`ExamenInvidual_NoExamen`);

--
-- Indices de la tabla `examengrupo`
--
ALTER TABLE `examengrupo`
  ADD PRIMARY KEY (`idExamenGrupo`,`ExamenInvidual_NoExamen`,`Grupo_NoGrupo`),
  ADD KEY `fk_ExamenInvidual_has_Grupo_Grupo1_idx` (`Grupo_NoGrupo`),
  ADD KEY `fk_ExamenInvidual_has_Grupo_ExamenInvidual1_idx` (`ExamenInvidual_NoExamen`);

--
-- Indices de la tabla `exameninvidual`
--
ALTER TABLE `exameninvidual`
  ADD PRIMARY KEY (`NoExamen`);

--
-- Indices de la tabla `examenperfil`
--
ALTER TABLE `examenperfil`
  ADD PRIMARY KEY (`idExamenPerfil`,`ExamenInvidual_NoExamen`,`Perfil_NoPerfil`),
  ADD KEY `fk_ExamenInvidual_has_Perfil_Perfil1_idx` (`Perfil_NoPerfil`),
  ADD KEY `fk_ExamenInvidual_has_Perfil_ExamenInvidual1_idx` (`ExamenInvidual_NoExamen`);

--
-- Indices de la tabla `grupo`
--
ALTER TABLE `grupo`
  ADD PRIMARY KEY (`NoGrupo`);

--
-- Indices de la tabla `parametrosexamen`
--
ALTER TABLE `parametrosexamen`
  ADD PRIMARY KEY (`NoPametroExa`,`NoExamen`),
  ADD KEY `fk_ParametrosExamen_ExamenInvidual_idx` (`NoExamen`);

--
-- Indices de la tabla `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`NoPerfil`);

--
-- Indices de la tabla `resultadosparametro`
--
ALTER TABLE `resultadosparametro`
  ADD PRIMARY KEY (`NoResultadosParametro`,`ParametrosExamen_NoPametroExa`,`CitaExamen_idCitaExamen`,`CitaExamen_ExamenInvidual_NoExamen`,`CitaExamen_tcita_NoCita`,`CitaExamen_tcita_NoMedico`,`CitaExamen_tcita_NoPaciente`),
  ADD KEY `fk_ResultadosParametro_ParametrosExamen1_idx` (`ParametrosExamen_NoPametroExa`),
  ADD KEY `fk_ResultadosParametro_CitaExamen1_idx` (`CitaExamen_idCitaExamen`,`CitaExamen_ExamenInvidual_NoExamen`,`CitaExamen_tcita_NoCita`,`CitaExamen_tcita_NoMedico`,`CitaExamen_tcita_NoPaciente`);

--
-- Indices de la tabla `tadmin`
--
ALTER TABLE `tadmin`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Indices de la tabla `tcita`
--
ALTER TABLE `tcita`
  ADD PRIMARY KEY (`NoCita`,`NoMedico`,`NoPaciente`),
  ADD KEY `fk_tcita_tmedicos1_idx` (`NoMedico`),
  ADD KEY `fk_tcita_tpacientes1_idx` (`NoPaciente`);

--
-- Indices de la tabla `tmedicos`
--
ALTER TABLE `tmedicos`
  ADD PRIMARY KEY (`Clave`);

--
-- Indices de la tabla `tpacientes`
--
ALTER TABLE `tpacientes`
  ADD PRIMARY KEY (`NoPaciente`);

--
-- Indices de la tabla `tusuario`
--
ALTER TABLE `tusuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citaexamen`
--
ALTER TABLE `citaexamen`
  MODIFY `idCitaExamen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `examengrupo`
--
ALTER TABLE `examengrupo`
  MODIFY `idExamenGrupo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `exameninvidual`
--
ALTER TABLE `exameninvidual`
  MODIFY `NoExamen` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `examenperfil`
--
ALTER TABLE `examenperfil`
  MODIFY `idExamenPerfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `grupo`
--
ALTER TABLE `grupo`
  MODIFY `NoGrupo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `parametrosexamen`
--
ALTER TABLE `parametrosexamen`
  MODIFY `NoPametroExa` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `perfil`
--
ALTER TABLE `perfil`
  MODIFY `NoPerfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `resultadosparametro`
--
ALTER TABLE `resultadosparametro`
  MODIFY `NoResultadosParametro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `tadmin`
--
ALTER TABLE `tadmin`
  MODIFY `idAdmin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tcita`
--
ALTER TABLE `tcita`
  MODIFY `NoCita` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tmedicos`
--
ALTER TABLE `tmedicos`
  MODIFY `Clave` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tpacientes`
--
ALTER TABLE `tpacientes`
  MODIFY `NoPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tusuario`
--
ALTER TABLE `tusuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citaexamen`
--
ALTER TABLE `citaexamen`
  ADD CONSTRAINT `fk_ExamenInvidual_has_tcita_ExamenInvidual1` FOREIGN KEY (`ExamenInvidual_NoExamen`) REFERENCES `exameninvidual` (`NoExamen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ExamenInvidual_has_tcita_tcita1` FOREIGN KEY (`tcita_NoCita`,`tcita_NoMedico`,`tcita_NoPaciente`) REFERENCES `tcita` (`NoCita`, `NoMedico`, `NoPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `examengrupo`
--
ALTER TABLE `examengrupo`
  ADD CONSTRAINT `fk_ExamenInvidual_has_Grupo_ExamenInvidual1` FOREIGN KEY (`ExamenInvidual_NoExamen`) REFERENCES `exameninvidual` (`NoExamen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ExamenInvidual_has_Grupo_Grupo1` FOREIGN KEY (`Grupo_NoGrupo`) REFERENCES `grupo` (`NoGrupo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `examenperfil`
--
ALTER TABLE `examenperfil`
  ADD CONSTRAINT `fk_ExamenInvidual_has_Perfil_ExamenInvidual1` FOREIGN KEY (`ExamenInvidual_NoExamen`) REFERENCES `exameninvidual` (`NoExamen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ExamenInvidual_has_Perfil_Perfil1` FOREIGN KEY (`Perfil_NoPerfil`) REFERENCES `perfil` (`NoPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `parametrosexamen`
--
ALTER TABLE `parametrosexamen`
  ADD CONSTRAINT `fk_ParametrosExamen_ExamenInvidual` FOREIGN KEY (`NoExamen`) REFERENCES `exameninvidual` (`NoExamen`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `resultadosparametro`
--
ALTER TABLE `resultadosparametro`
  ADD CONSTRAINT `fk_ResultadosParametro_CitaExamen1` FOREIGN KEY (`CitaExamen_idCitaExamen`,`CitaExamen_ExamenInvidual_NoExamen`,`CitaExamen_tcita_NoCita`,`CitaExamen_tcita_NoMedico`,`CitaExamen_tcita_NoPaciente`) REFERENCES `citaexamen` (`idCitaExamen`, `ExamenInvidual_NoExamen`, `tcita_NoCita`, `tcita_NoMedico`, `tcita_NoPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ResultadosParametro_ParametrosExamen1` FOREIGN KEY (`ParametrosExamen_NoPametroExa`) REFERENCES `parametrosexamen` (`NoPametroExa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tcita`
--
ALTER TABLE `tcita`
  ADD CONSTRAINT `fk_tcita_tmedicos1` FOREIGN KEY (`NoMedico`) REFERENCES `tmedicos` (`Clave`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tcita_tpacientes1` FOREIGN KEY (`NoPaciente`) REFERENCES `tpacientes` (`NoPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
