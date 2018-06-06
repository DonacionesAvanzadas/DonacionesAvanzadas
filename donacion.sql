-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-06-2018 a las 05:03:21
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
  `ID` int(11) NOT NULL,
  `dinopsis` text NOT NULL,
  `descripcion` text NOT NULL,
  `imagen` varchar(60) NOT NULL,
  `tema` varchar(20) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `ID` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denuncia`
--

CREATE TABLE `denuncia` (
  `ID` int(11) NOT NULL,
  `id_articulo` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pertenece`
--

CREATE TABLE `pertenece` (
  `ID` int(11) NOT NULL,
  `id_articulo` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quiere`
--

CREATE TABLE `quiere` (
  `ID` int(11) NOT NULL,
  `id_articulo` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `encuentro` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID` int(11) NOT NULL,
  `imagen` varchar(60) NOT NULL,
  `nombre` varchar(70) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `nombre_usuario` varchar(30) NOT NULL,
  `contrasena` varchar(30) NOT NULL,
  `estrellas` int(11) NOT NULL,
  `denuncias` int(11) NOT NULL,
  `tipo_usuario` varchar(10) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_bloqueados`
--

CREATE TABLE `usuarios_bloqueados` (
  `ID` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha_sancion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo_donar`
--
ALTER TABLE `articulo_donar`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Id_Usuario` (`id_Usuario`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `denuncia`
--
ALTER TABLE `denuncia`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_Articulo` (`id_Articulo`),
  ADD KEY `id_Usuario` (`id_Usuario`);

--
-- Indices de la tabla `pertenece`
--
ALTER TABLE `pertenece`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_Articulo` (`id_Articulo`),
  ADD KEY `id_Categoria` (`id_Categoria`);

--
-- Indices de la tabla `quiere`
--
ALTER TABLE `quiere`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_Articulo` (`id_Articulo`),
  ADD KEY `id_Usuario` (`id_Usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `usuarios_bloqueados`
--
ALTER TABLE `usuarios_bloqueados`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Id_Usuario` (`Id_Usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulo_donar`
--
ALTER TABLE `articulo_donar`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `denuncia`
--
ALTER TABLE `denuncia`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pertenece`
--
ALTER TABLE `pertenece`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `quiere`
--
ALTER TABLE `quiere`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `usuarios_bloqueados`
--
ALTER TABLE `usuarios_bloqueados`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `articulo_donar`
--
ALTER TABLE `articulo_donar`
  ADD CONSTRAINT `articulo_donar_ibfk_2` FOREIGN KEY (`id_Usuario`) REFERENCES `usuario` (`ID`);

--
-- Filtros para la tabla `denuncia`
--
ALTER TABLE `denuncia`
  ADD CONSTRAINT `denuncia_ibfk_1` FOREIGN KEY (`id_Usuario`) REFERENCES `usuario` (`ID`),
  ADD CONSTRAINT `denuncia_ibfk_2` FOREIGN KEY (`id_Articulo`) REFERENCES `articulo_donar` (`ID`);

--
-- Filtros para la tabla `pertenece`
--
ALTER TABLE `pertenece`
  ADD CONSTRAINT `pertenece_ibfk_1` FOREIGN KEY (`id_Articulo`) REFERENCES `articulo_donar` (`ID`),
  ADD CONSTRAINT `pertenece_ibfk_2` FOREIGN KEY (`id_Categoria`) REFERENCES `categoria` (`ID`);

--
-- Filtros para la tabla `quiere`
--
ALTER TABLE `quiere`
  ADD CONSTRAINT `quiere_ibfk_1` FOREIGN KEY (`id_Articulo`) REFERENCES `articulo_donar` (`ID`),
  ADD CONSTRAINT `quiere_ibfk_2` FOREIGN KEY (`id_Usuario`) REFERENCES `usuario` (`ID`);

--
-- Filtros para la tabla `usuarios_bloqueados`
--
ALTER TABLE `usuarios_bloqueados`
  ADD CONSTRAINT `usuarios_bloqueados_ibfk_1` FOREIGN KEY (`id_Usuario`) REFERENCES `usuario` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
