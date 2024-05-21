-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-05-2024 a las 02:28:54
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cursos`
--
CREATE DATABASE IF NOT EXISTS `cursos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cursos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--
-- Creación: 20-05-2024 a las 23:08:18
--

CREATE TABLE `alumno` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id`, `nombre`, `apellido`) VALUES
(1, 'Juan', 'Pérez'),
(2, 'María', 'Gómez'),
(3, 'Carlos', 'Rodríguez'),
(4, 'Ana', 'Martínez'),
(5, 'Luis', 'Fernández');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--
-- Creación: 20-05-2024 a las 23:08:18
--

CREATE TABLE `curso` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tipo_aprobacion` enum('asistencia','calificacion') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`id`, `nombre`, `tipo_aprobacion`) VALUES
(1, 'Matemáticas', 'asistencia'),
(2, 'Historia', 'calificacion'),
(3, 'Biología', 'asistencia'),
(4, 'Física', 'calificacion'),
(5, 'Literatura', 'asistencia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--
-- Creación: 20-05-2024 a las 23:35:53
--

CREATE TABLE `inscripcion` (
  `id` bigint(20) NOT NULL,
  `curso_id` bigint(20) DEFAULT NULL,
  `alumno_id` bigint(20) DEFAULT NULL,
  `asistencia` int(11) DEFAULT 0,
  `calificacion` float DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripcion`
--

INSERT INTO `inscripcion` (`id`, `curso_id`, `alumno_id`, `asistencia`, `calificacion`) VALUES
(1, 1, 1, 85, 8.5),
(2, 1, 2, 75, 9.5),
(3, 1, 3, 95, 6.5),
(4, 1, 4, 85, 9),
(5, 2, 2, 90, 8),
(6, 2, 3, 80, 9),
(7, 2, 4, 75, 6),
(8, 2, 5, 95, 8),
(9, 3, 3, 75, 6),
(10, 3, 4, 85, 8),
(11, 3, 5, 95, 9),
(12, 3, 2, 75, 8),
(13, 4, 4, 95, 7),
(14, 4, 5, 90, 5),
(15, 4, 1, 95, 8),
(16, 4, 2, 95, 9),
(17, 5, 5, 80, 7.5),
(18, 5, 1, 90, 9.5),
(19, 5, 2, 80, 5.5),
(20, 5, 3, 85, 9.5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `inscripcion_ibfk_2` (`alumno_id`),
  ADD KEY `FK53oy51geundskbmafp223e705` (`curso_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `curso`
--
ALTER TABLE `curso`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `FK53oy51geundskbmafp223e705` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id`),
  ADD CONSTRAINT `FKndj1y0din8ba2lkfntabm6476` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`),
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
