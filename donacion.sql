-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-05-2018 a las 00:49:09
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `donacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo_donar`
--

CREATE TABLE `articulo_donar` (
  `Id` int(11) NOT NULL,
  `Sinopsis` text NOT NULL,
  `Descripcion` text NOT NULL,
  `Imagen` varchar(60) NOT NULL,
  `Tema` varchar(20) NOT NULL,
  `Id_Usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denuncia`
--

CREATE TABLE `denuncia` (
  `Id` int(11) NOT NULL,
  `Id_Articulo` int(11) NOT NULL,
  `Id_Usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pertenece`
--

CREATE TABLE `pertenece` (
  `Id` int(11) NOT NULL,
  `Id_Articulo` int(11) NOT NULL,
  `Id_Categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quiere`
--

CREATE TABLE `quiere` (
  `Id` int(11) NOT NULL,
  `Id_Articulo` int(11) NOT NULL,
  `Id_Usuario` int(11) NOT NULL,
  `Estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Id` int(11) NOT NULL,
  `Imagen` varchar(60) NOT NULL,
  `Nombre` varchar(70) NOT NULL,
  `Correo` varchar(60) NOT NULL,
  `Nombre_Usuario` varchar(30) NOT NULL,
  `Contrasena` varchar(30) NOT NULL,
  `Estrellas` int(11) NOT NULL,
  `Denuncias` int(11) NOT NULL,
  `Tipo_Usuario` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_bloqueados`
--

CREATE TABLE `usuarios_bloqueados` (
  `Id` int(11) NOT NULL,
  `Id_Usuario` int(11) NOT NULL,
  `Fecha_Sancion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo_donar`
--
ALTER TABLE `articulo_donar`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_Usuario` (`Id_Usuario`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `denuncia`
--
ALTER TABLE `denuncia`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_Articulo` (`Id_Articulo`),
  ADD KEY `Id_Usuario` (`Id_Usuario`);

--
-- Indices de la tabla `pertenece`
--
ALTER TABLE `pertenece`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_Articulo` (`Id_Articulo`),
  ADD KEY `Id_Categoria` (`Id_Categoria`);

--
-- Indices de la tabla `quiere`
--
ALTER TABLE `quiere`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_Articulo` (`Id_Articulo`),
  ADD KEY `Id_Usuario` (`Id_Usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `usuarios_bloqueados`
--
ALTER TABLE `usuarios_bloqueados`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_Usuario` (`Id_Usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulo_donar`
--
ALTER TABLE `articulo_donar`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `denuncia`
--
ALTER TABLE `denuncia`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pertenece`
--
ALTER TABLE `pertenece`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `quiere`
--
ALTER TABLE `quiere`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `usuarios_bloqueados`
--
ALTER TABLE `usuarios_bloqueados`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `articulo_donar`
--
ALTER TABLE `articulo_donar`
  ADD CONSTRAINT `articulo_donar_ibfk_2` FOREIGN KEY (`Id_Usuario`) REFERENCES `usuario` (`Id`);

--
-- Filtros para la tabla `denuncia`
--
ALTER TABLE `denuncia`
  ADD CONSTRAINT `denuncia_ibfk_1` FOREIGN KEY (`Id_Usuario`) REFERENCES `usuario` (`Id`),
  ADD CONSTRAINT `denuncia_ibfk_2` FOREIGN KEY (`Id_Articulo`) REFERENCES `articulo_donar` (`Id`);

--
-- Filtros para la tabla `pertenece`
--
ALTER TABLE `pertenece`
  ADD CONSTRAINT `pertenece_ibfk_1` FOREIGN KEY (`Id_Articulo`) REFERENCES `articulo_donar` (`Id`),
  ADD CONSTRAINT `pertenece_ibfk_2` FOREIGN KEY (`Id_Categoria`) REFERENCES `categoria` (`Id`);

--
-- Filtros para la tabla `quiere`
--
ALTER TABLE `quiere`
  ADD CONSTRAINT `quiere_ibfk_1` FOREIGN KEY (`Id_Articulo`) REFERENCES `articulo_donar` (`Id`),
  ADD CONSTRAINT `quiere_ibfk_2` FOREIGN KEY (`Id_Usuario`) REFERENCES `usuario` (`Id`);

--
-- Filtros para la tabla `usuarios_bloqueados`
--
ALTER TABLE `usuarios_bloqueados`
  ADD CONSTRAINT `usuarios_bloqueados_ibfk_1` FOREIGN KEY (`Id_Usuario`) REFERENCES `usuario` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
