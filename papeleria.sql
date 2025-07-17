-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-07-2025 a las 05:19:36
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
-- Base de datos: `papeleria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `IDCATEGORIA` int(11) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `TIEMPO_ESTIMADO_ALMACEN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`IDCATEGORIA`, `NOMBRE`, `TIEMPO_ESTIMADO_ALMACEN`) VALUES
(1, 'Papel', 90);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contactoproveedor`
--

CREATE TABLE `contactoproveedor` (
  `IDCONTACTO` int(11) NOT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `CARGO` int(11) DEFAULT NULL,
  `CORREO` varchar(255) DEFAULT NULL,
  `DIRECCION` varchar(255) DEFAULT NULL,
  `DOCUMENTO` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `TELEFONO` varchar(255) DEFAULT NULL,
  `TIPODOCUMENTO` int(11) DEFAULT NULL,
  `proveedor_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallepedido`
--

CREATE TABLE `detallepedido` (
  `IDDETALLEPEDIDO` int(11) NOT NULL,
  `CANTIDAD` int(11) DEFAULT NULL,
  `SUBTOTAL` double DEFAULT NULL,
  `pedido_id` int(11) DEFAULT NULL,
  `producto_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detallepedido`
--

INSERT INTO `detallepedido` (`IDDETALLEPEDIDO`, `CANTIDAD`, `SUBTOTAL`, `pedido_id`, `producto_id`) VALUES
(1, 12, 120, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallesalida`
--

CREATE TABLE `detallesalida` (
  `IDDETALLESALIDA` int(11) NOT NULL,
  `FECHARETIRO` datetime DEFAULT NULL,
  `salida_id` int(11) DEFAULT NULL,
  `lote_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detallesalida`
--

INSERT INTO `detallesalida` (`IDDETALLESALIDA`, `FECHARETIRO`, `salida_id`, `lote_id`) VALUES
(1, '2025-07-16 03:39:58', 1, 1),
(2, '2025-07-16 03:39:58', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallesolicitud`
--

CREATE TABLE `detallesolicitud` (
  `IDDETALLE` bigint(20) NOT NULL,
  `CANTIDAD` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `idSolicitud` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detallesolicitud`
--

INSERT INTO `detallesolicitud` (`IDDETALLE`, `CANTIDAD`, `id_producto`, `idSolicitud`) VALUES
(1, 2, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lote`
--

CREATE TABLE `lote` (
  `IDLOTE` int(11) NOT NULL,
  `CODIGO` varchar(255) DEFAULT NULL,
  `ESTADO` varchar(255) DEFAULT NULL,
  `FECHAINGRESO` date DEFAULT NULL,
  `FECHAVENCIMIENTO` date DEFAULT NULL,
  `detalle_id` int(11) DEFAULT NULL,
  `producto_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lote`
--

INSERT INTO `lote` (`IDLOTE`, `CODIGO`, `ESTADO`, `FECHAINGRESO`, `FECHAVENCIMIENTO`, `detalle_id`, `producto_id`) VALUES
(1, '1-1-250715-001', 'RETIRO_EXITOSO', '2025-07-15', '2025-10-13', 1, 1),
(2, '1-1-250715-002', 'RETIRO_EXITOSO', '2025-07-15', '2025-10-13', 1, 1),
(3, '1-1-250715-003', 'ACTIVO', '2025-07-15', '2025-10-13', 1, 1),
(4, '1-1-250715-004', 'ACTIVO', '2025-07-15', '2025-10-13', 1, 1),
(5, '1-1-250715-005', 'ACTIVO', '2025-07-15', '2025-10-13', 1, 1),
(6, '1-1-250715-006', 'ACTIVO', '2025-07-15', '2025-10-13', 1, 1),
(7, '1-1-250715-007', 'ACTIVO', '2025-07-15', '2025-10-13', 1, 1),
(8, '1-1-250715-008', 'ACTIVO', '2025-07-15', '2025-10-13', 1, 1),
(9, '1-1-250715-009', 'ACTIVO', '2025-07-15', '2025-10-13', 1, 1),
(10, '1-1-250715-010', 'ACTIVO', '2025-07-15', '2025-10-13', 1, 1),
(11, '1-1-250715-011', 'ACTIVO', '2025-07-15', '2025-10-13', 1, 1),
(12, '1-1-250715-012', 'ACTIVO', '2025-07-15', '2025-10-13', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `ID` bigint(20) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`ID`, `NOMBRE`) VALUES
(1, 'Perú');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `IDPEDIDO` int(11) NOT NULL,
  `ESTADO` varchar(255) DEFAULT NULL,
  `FECHAESTIMADOLLEGADA` date DEFAULT NULL,
  `FECHAREGISTRO` date DEFAULT NULL,
  `TOTAL` double DEFAULT NULL,
  `proveedor_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`IDPEDIDO`, `ESTADO`, `FECHAESTIMADOLLEGADA`, `FECHAREGISTRO`, `TOTAL`, `proveedor_id`) VALUES
(1, 'RECIBIDO', '2025-07-15', '2025-07-15', 120, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `IDPRODUCTO` int(11) NOT NULL,
  `CANTIDADLOTES` int(11) DEFAULT NULL,
  `CANTIDADPRESENTACIONLOTE` int(11) DEFAULT NULL,
  `CANTIDADPRESENTACIONPRODUCTO` int(11) DEFAULT NULL,
  `CODIGO` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `PRECIOCOMPRA` double DEFAULT NULL,
  `PRESENTACIONLOTE` int(11) DEFAULT NULL,
  `PRESENTACIONPRODUCTO` int(11) DEFAULT NULL,
  `categoria_id` int(11) DEFAULT NULL,
  `proveedor_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`IDPRODUCTO`, `CANTIDADLOTES`, `CANTIDADPRESENTACIONLOTE`, `CANTIDADPRESENTACIONPRODUCTO`, `CODIGO`, `NOMBRE`, `PRECIOCOMPRA`, `PRESENTACIONLOTE`, `PRESENTACIONPRODUCTO`, `categoria_id`, `proveedor_id`) VALUES
(1, 10, 2, 2, 'ESTPAP001ART', 'papelA4', 10, 0, 3, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `IDPROVEEDOR` int(11) NOT NULL,
  `RUC` varchar(255) DEFAULT NULL,
  `CORREO` varchar(255) DEFAULT NULL,
  `DIRECCION` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `SITIOWEB` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`IDPROVEEDOR`, `RUC`, `CORREO`, `DIRECCION`, `NOMBRE`, `SITIOWEB`) VALUES
(1, '96385274144', 'artesco@gmail.com', 'ate', 'Artesco', 'artesco.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `IDROL` int(11) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`IDROL`, `NOMBRE`) VALUES
(1, 'ADMINISTRADOR'),
(2, 'LOGISTICA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salida`
--

CREATE TABLE `salida` (
  `IDSALIDA` int(11) NOT NULL,
  `FECHASALIDA` date DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `salida`
--

INSERT INTO `salida` (`IDSALIDA`, `FECHASALIDA`, `usuario_id`) VALUES
(1, '2025-07-15', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

CREATE TABLE `solicitud` (
  `id_solicitud` int(11) NOT NULL,
  `codigo_salida` varchar(20) DEFAULT NULL,
  `estado_solicitud` varchar(20) DEFAULT NULL,
  `fecha_aprobacion` datetime DEFAULT NULL,
  `fecha_solicitud` datetime DEFAULT NULL,
  `IDUSUARIO` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `solicitud`
--

INSERT INTO `solicitud` (`id_solicitud`, `codigo_salida`, `estado_solicitud`, `fecha_aprobacion`, `fecha_solicitud`, `IDUSUARIO`) VALUES
(1, '6772602', 'Aprobado', NULL, '2025-07-16 03:39:12', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `IDUSUARIO` bigint(20) NOT NULL,
  `APELLIDOS` varchar(255) DEFAULT NULL,
  `DIRECCION` varchar(255) DEFAULT NULL,
  `DOCUMENTO` varchar(255) DEFAULT NULL,
  `ENABLED` tinyint(1) DEFAULT 0,
  `NOMBRES` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `TELEFONO` varchar(255) DEFAULT NULL,
  `TIPODOCUMENTO` int(11) DEFAULT NULL,
  `pais_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`IDUSUARIO`, `APELLIDOS`, `DIRECCION`, `DOCUMENTO`, `ENABLED`, `NOMBRES`, `PASSWORD`, `TELEFONO`, `TIPODOCUMENTO`, `pais_id`) VALUES
(1, 'Administrador', 'Santa Clara', '00000000', 1, 'Super', '$2a$12$XVdOEBybqATpIA4Kp.mqHehJf3hWzkRcphLK0mcMwabjUPdrieB1e', '999666333', 0, 1),
(2, 'Logistica', 'ate', '12345678', 1, 'EMP', '$2a$10$9.3Cj4tNRsF4Qp0tbuHDfOKKexYgLNkzDGqlpXqBlmJXFdbNDDtEC', '963852741', 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol`
--

CREATE TABLE `usuario_rol` (
  `usuario_id` bigint(20) NOT NULL,
  `rol_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario_rol`
--

INSERT INTO `usuario_rol` (`usuario_id`, `rol_id`) VALUES
(1, 1),
(2, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`IDCATEGORIA`);

--
-- Indices de la tabla `contactoproveedor`
--
ALTER TABLE `contactoproveedor`
  ADD PRIMARY KEY (`IDCONTACTO`),
  ADD KEY `FK_CONTACTOPROVEEDOR_proveedor_id` (`proveedor_id`);

--
-- Indices de la tabla `detallepedido`
--
ALTER TABLE `detallepedido`
  ADD PRIMARY KEY (`IDDETALLEPEDIDO`),
  ADD KEY `FK_DETALLEPEDIDO_pedido_id` (`pedido_id`),
  ADD KEY `FK_DETALLEPEDIDO_producto_id` (`producto_id`);

--
-- Indices de la tabla `detallesalida`
--
ALTER TABLE `detallesalida`
  ADD PRIMARY KEY (`IDDETALLESALIDA`),
  ADD KEY `FK_DETALLESALIDA_salida_id` (`salida_id`),
  ADD KEY `FK_DETALLESALIDA_lote_id` (`lote_id`);

--
-- Indices de la tabla `detallesolicitud`
--
ALTER TABLE `detallesolicitud`
  ADD PRIMARY KEY (`IDDETALLE`),
  ADD KEY `FK_detallesolicitud_id_producto` (`id_producto`),
  ADD KEY `FK_detallesolicitud_idSolicitud` (`idSolicitud`);

--
-- Indices de la tabla `lote`
--
ALTER TABLE `lote`
  ADD PRIMARY KEY (`IDLOTE`),
  ADD KEY `FK_LOTE_detalle_id` (`detalle_id`),
  ADD KEY `FK_LOTE_producto_id` (`producto_id`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`IDPEDIDO`),
  ADD KEY `FK_PEDIDO_proveedor_id` (`proveedor_id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`IDPRODUCTO`),
  ADD KEY `FK_producto_categoria_id` (`categoria_id`),
  ADD KEY `FK_producto_proveedor_id` (`proveedor_id`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`IDPROVEEDOR`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`IDROL`);

--
-- Indices de la tabla `salida`
--
ALTER TABLE `salida`
  ADD PRIMARY KEY (`IDSALIDA`),
  ADD KEY `FK_SALIDA_usuario_id` (`usuario_id`);

--
-- Indices de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD PRIMARY KEY (`id_solicitud`),
  ADD KEY `FK_solicitud_IDUSUARIO` (`IDUSUARIO`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`IDUSUARIO`),
  ADD KEY `FK_USUARIO_pais_id` (`pais_id`);

--
-- Indices de la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD PRIMARY KEY (`usuario_id`,`rol_id`),
  ADD KEY `FK_usuario_rol_rol_id` (`rol_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `IDCATEGORIA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `contactoproveedor`
--
ALTER TABLE `contactoproveedor`
  MODIFY `IDCONTACTO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detallepedido`
--
ALTER TABLE `detallepedido`
  MODIFY `IDDETALLEPEDIDO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `detallesalida`
--
ALTER TABLE `detallesalida`
  MODIFY `IDDETALLESALIDA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `detallesolicitud`
--
ALTER TABLE `detallesolicitud`
  MODIFY `IDDETALLE` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `lote`
--
ALTER TABLE `lote`
  MODIFY `IDLOTE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `IDPEDIDO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `IDPRODUCTO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `IDPROVEEDOR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `IDROL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `salida`
--
ALTER TABLE `salida`
  MODIFY `IDSALIDA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  MODIFY `id_solicitud` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `IDUSUARIO` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `contactoproveedor`
--
ALTER TABLE `contactoproveedor`
  ADD CONSTRAINT `FK_CONTACTOPROVEEDOR_proveedor_id` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedor` (`IDPROVEEDOR`);

--
-- Filtros para la tabla `detallepedido`
--
ALTER TABLE `detallepedido`
  ADD CONSTRAINT `FK_DETALLEPEDIDO_pedido_id` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`IDPEDIDO`),
  ADD CONSTRAINT `FK_DETALLEPEDIDO_producto_id` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`IDPRODUCTO`);

--
-- Filtros para la tabla `detallesalida`
--
ALTER TABLE `detallesalida`
  ADD CONSTRAINT `FK_DETALLESALIDA_lote_id` FOREIGN KEY (`lote_id`) REFERENCES `lote` (`IDLOTE`),
  ADD CONSTRAINT `FK_DETALLESALIDA_salida_id` FOREIGN KEY (`salida_id`) REFERENCES `salida` (`IDSALIDA`);

--
-- Filtros para la tabla `detallesolicitud`
--
ALTER TABLE `detallesolicitud`
  ADD CONSTRAINT `FK_detallesolicitud_idSolicitud` FOREIGN KEY (`idSolicitud`) REFERENCES `solicitud` (`id_solicitud`),
  ADD CONSTRAINT `FK_detallesolicitud_id_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`IDPRODUCTO`);

--
-- Filtros para la tabla `lote`
--
ALTER TABLE `lote`
  ADD CONSTRAINT `FK_LOTE_detalle_id` FOREIGN KEY (`detalle_id`) REFERENCES `detallepedido` (`IDDETALLEPEDIDO`),
  ADD CONSTRAINT `FK_LOTE_producto_id` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`IDPRODUCTO`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK_PEDIDO_proveedor_id` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedor` (`IDPROVEEDOR`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `FK_producto_categoria_id` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`IDCATEGORIA`),
  ADD CONSTRAINT `FK_producto_proveedor_id` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedor` (`IDPROVEEDOR`);

--
-- Filtros para la tabla `salida`
--
ALTER TABLE `salida`
  ADD CONSTRAINT `FK_SALIDA_usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`IDUSUARIO`);

--
-- Filtros para la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD CONSTRAINT `FK_solicitud_IDUSUARIO` FOREIGN KEY (`IDUSUARIO`) REFERENCES `usuario` (`IDUSUARIO`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_USUARIO_pais_id` FOREIGN KEY (`pais_id`) REFERENCES `pais` (`ID`);

--
-- Filtros para la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `FK_usuario_rol_rol_id` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`IDROL`),
  ADD CONSTRAINT `FK_usuario_rol_usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`IDUSUARIO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
