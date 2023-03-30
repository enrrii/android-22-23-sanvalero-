 -- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-03-2023 a las 22:53:00
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `glovobd`
--
CREATE DATABASE IF NOT EXISTS `glovobd` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `glovobd`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bebida`
--

CREATE TABLE `bebida` (
  `id_Bebida` int(11) NOT NULL,
  `id_Restaurante` int(2) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Imagen` varchar(255) DEFAULT NULL,
  `Precio` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `bebida`
--

INSERT INTO `bebida` (`id_Bebida`, `id_Restaurante`, `Nombre`, `Imagen`, `Precio`) VALUES
(1, 1, 'Coca-cola', 'https://w7.pngwing.com/pngs/574/913/png-transparent-coca-cola-coca-cola-bottle-glass-bottles.png', '2.99'),
(2, 1, 'Agua mineral', 'https://elfornet.com/media/catalog/product/cache/728587fcd73f36684dd4a1c3c4b36cfb/a/g/agua_sin_gas_01.jpg', '1.99'),
(3, 1, 'Sangría', 'https://images.hola.com/imagenes/cocina/recetas/20200514167988/receta-sangria-clasica/0-823-899/sangria-t.jpg', '4.99'),
(4, 1, 'Vino tinto', 'https://img2.freepng.es/20180525/xfq/kisspng-red-wine-distilled-beverage-pinotage-grape-saffron-5b084bf460bb57.4970590515272703883962.jpg', '22.99'),
(5, 1, 'Cerveza', 'https://www.paulaner.com/content/11-es/1-productos/1-weissbier/modules/1-product_intro-9p648i/bottle-int-1000x1550-hwbn.png', '3.99');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platos`
--

CREATE TABLE `platos` (
  `id_Plato` int(11) NOT NULL,
  `id_Restaurante` int(2) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Descripcion` varchar(450) NOT NULL,
  `Ingredientes` varchar(450) NOT NULL,
  `Precio` int(3) NOT NULL,
  `Imagen` varchar(450) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `platos`
--

INSERT INTO `platos` (`id_Plato`, `id_Restaurante`, `Nombre`, `Descripcion`, `Ingredientes`, `Precio`, `Imagen`) VALUES
(1, 1, 'Star Wars: Episodio VI', 'Seis meses después de que Han Solo fuera capturado y congelado en carbonita en la Ciudad de las Nubes, el Imperio Galáctico está construyendo una nueva Estrella de la Muerte. Mientras tanto, el joven Luke lucha para alcanzar la maestría jedi.', '', 6, 'https://observandocine.com/wp-content/uploads/2015/12/star_wars_vi___return_of_the_jedi___movie_poster_by_nei1b-d5t3b8d.jpg'),
(2, 2, 'American Psycho', 'En la década de 1980, Patrick Bateman es un exitoso "yuppie" obsesionado por la competencia y por la perfección material, que utiliza los más caros cosméticos masculinos, equipos de gimnasia, solárium y demás maquinaria estética para lograr un cuerpo atlético y bien acicalado, identificador material del éxito social.','', 6, 'https://pics.filmaffinity.com/american_psycho-503776720-mmed.jpg'),
(3, 3, 'Los Croods', 'Prehistoria. Tras la destrucción de su hogar por un gran terremoto, Grug se ve obligado a emigrar con su familia. Mientras avanzan por un mundo desconocido y aterrador, se encuentran con un nómada de mente abierta que los deja a todos fascinados, sobre todo a la hija de Grug.', '', 6, 'https://pics.filmaffinity.com/the_croods-675771807-mmed.jpg'),
(4, 4, 'Creed III', 'Después de dominar el mundo del boxeo, Adonis Creed ha progresado tanto en su carrera como en su vida familiar.', '', 6, 'https://pics.filmaffinity.com/creed_iii-358416025-mmed.jpg'),
(5, 5, 'Joker', 'Arthur Fleck (Phoenix) vive en Gotham con su madre, y su única motivación en la vida es hacer reír a la gente. Actúa haciendo de payaso en pequeños trabajos, pero tiene problemas mentales que hacen que la gente le vea como un bicho raro.', '', 6, 'https://pics.filmaffinity.com/joker-790658206-mmed.jpg'),
(6, 6, 'El caballero oscuro', 'Batman/Bruce Wayne (Christian Bale) regresa para continuar su guerra contra el crimen. Con la ayuda del teniente Jim Gordon (Gary Oldman) y del Fiscal del Distrito Harvey Dent (Aaron Eckhart), Batman se propone destruir el crimen organizado en la ciudad de Gotham.', '', 6, 'https://pics.filmaffinity.com/the_dark_knight-102763119-mmed.jpg'),
(7, 7, 'Pulp Finction', 'Jules y Vincent, dos asesinos a sueldo con no demasiadas luces, trabajan para el gángster Marsellus Wallace.', '', 6, 'https://pics.filmaffinity.com/pulp_fiction-210382116-mmed.jpg'),
(8, 8, 'Malditos bastardos', 'Segunda Guerra Mundial (1939-1945). En la Francia ocupada por los alemanes, Shosanna Dreyfus (Mélanie Laurent) presencia la ejecución de su familia por orden del coronel Hans Landa (Christoph Waltz).', '', 6, 'https://pics.filmaffinity.com/inglourious_basterds-976286054-mmed.jpg'),
(9, 9, 'Django', 'En Texas, dos años antes de estallar la Guerra Civil Americana, King Schultz (Christoph Waltz), un cazarrecompensas alemán que sigue la pista a unos asesinos para cobrar por sus cabezas, le promete al esclavo negro Django (Jamie Foxx) dejarlo en libertad si le ayuda a atraparlos.', '', 6, 'https://pics.filmaffinity.com/django_unchained-956246347-mmed.jpg'),
(10, 10, 'Lo imposible', 'Una mañana, mientras se encuentran todos en la piscina del complejo a orillas del mar, un tremendo tsunami destroza el hotel y gran parte de la costa del sudeste asiático.', '', 6, 'https://pics.filmaffinity.com/lo_imposible_the_impossible-554801449-mmed.jpg'),
(11, 1, 'El Hobbit', ' En compañía del mago Gandalf y de trece enanos, el hobbit Bilbo Bolsón emprende un viaje a través del país de los elfos y los bosques de los trolls.', '', 6, 'https://pics.filmaffinity.com/the_hobbit_an_unexpected_journey-249234415-mmed.jpg'),
(12, 2, 'Erase una vez en Hollywood', 'Hollywood, años 60. La estrella de un western televisivo, Rick Dalton (DiCaprio), intenta amoldarse a los cambios del medio al mismo tiempo que su doble (Pitt)', '', 6, 'https://pics.filmaffinity.com/once_upon_a_time_in_hollywood-735160977-mmed.jpg'),
(13, 3, 'El lobo de Wall Street', 'Película basada en hechos reales del corredor de bolsa neoyorquino Jordan Belfort (Leonardo DiCaprio).', '', 6, 'https://pics.filmaffinity.com/the_wolf_of_wall_street-675195906-mmed.jpg'),
(14, 4, 'Project X', 'Tres estudiantes de un instituto deciden organizar una fiesta salvaje en casa de uno de ellos, promocionándola en las redes sociales como la fiesta más loca de la temporada. ', '', 6, 'https://pics.filmaffinity.com/project_x-393876705-mmed.jpg'),
(15, 5, 'Torrente 2', 'Torrente decide instalarse en plena Costa del sol, en el ayuntamiento de Marbella, y trabajar como investigador privado. ', '', 6, 'https://pics.filmaffinity.com/torrente_2_mision_en_marbella-426650610-mmed.jpg'),
(16, 6, 'Avengers: Endgame', 'Después de los eventos devastadores de Avengers: Infinity War, el universo está en ruinas debido a las acciones de Thanos, el Titán Loco.', '', 6, 'https://pics.filmaffinity.com/avengers_endgame-135478227-mmed.jpg'),
(17, 7, 'Baby Driver', 'Baby (Ansel Elgort), un joven y talentoso conductor especializado en fugas, depende del ritmo de su banda sonora personal para ser el mejor en lo suyo.', '', 6, 'https://pics.filmaffinity.com/baby_driver-399368582-mmed.jpg'),
(18, 8, 'Spiderman 2', 'Peter debe afrontar nuevos desafíos mientras lucha contra el don y la maldición de sus poderes equilibrando sus dos identidades: el escurridizo superhéroe Spider-Man y el estudiante universitario.', '', 6, 'https://pics.filmaffinity.com/spider_man_2-876729560-mmed.jpg'),
(19, 9, 'Kung Fu Panda 3', 'Tercera película de la saga "Kung Fu Panda", en la que Po deberá hacer frente a dos desafíos épicos: uno, de origen sobrenatural; el otro, muy cerca de su hogar, con la aparición del que dice ser su padre biológico.', '', 6, 'https://pics.filmaffinity.com/kung_fu_panda_3-119198470-mmed.jpg'),
(20, 10, 'Forrest Gump', 'Forrest Gump (Tom Hanks) sufre desde pequeño un cierto retraso mental. A pesar de todo, gracias a su tenacidad y a su buen corazón será protagonista de acontecimientos cruciales de su país durante varias décadas.', '', 6, 'https://pics.filmaffinity.com/forrest_gump-212765827-mmed.jpg'),
(21, 1, 'Demon Slayer: La villa del herrero', 'Después de que su familia es brutalmente asesinada, un chico de buen corazón llamado Tanjiro Kamado decide convertirse en Demon Slayer con la esperanza de convertir a su hermana menor Nezuko en humana. Junto con sus camaradas, Zenitsu e Inosuke, junto con uno de los miembros de alto rango del Demon Slayer Corps, Tengen Uzui, Tanjiro se embarca en una misión dentro del Distrito de Entretenimiento, donde se encuentran con los formidables demonios de alto rango, Daki y Gyutaro.', '', 6, 'https://pics.filmaffinity.com/demon_slayer_kimetsu_no_yaiba_to_the_swordsmith_village-213333256-mmed.jpg'),
(22, 2, 'NightCrawler', 'Tras ser testigo de un accidente, Lou Bloom (Jake Gyllenhaal), un apasionado joven que no consigue encontrar empleo, descubre como forma de ganar dinero el mundo del periodismo criminalista en la peligrosa ciudad de Los Ángeles.', '', 6, 'https://pics.filmaffinity.com/nightcrawler-317347366-mmed.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurante`
--

CREATE TABLE `restaurante` (
  `id_Restaurante` int(2) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Tipo` varchar(50) NOT NULL,
  `Ventas` int(99) NOT NULL,
  `Puntuacion` int(10) NOT NULL,
  `Imagen` varchar(535) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `restaurante`
--

INSERT INTO `restaurante` (`id_Restaurante`, `Nombre`, `Tipo`, `Ventas`, `Puntuacion`, `Imagen`) VALUES
(1, 'Cinesa Puerto venecia', 'Cinesa', 10, 5, 'https://www.tabiquesytechos.com/sites/default/files/styles/proyecto_nodo/public/proyectos/2017-08/Puerto%20Venecia%201%20%28Large%29.JPG?itok=V-PuVHzB'),
(2, 'Cinesa Grancasa', 'Cinesa', 60, 3, 'https://sonaesierracms-v2.cdnpservers.net/wp-content/uploads/sites/24/2021/03/cines-destacada.jpg'),
(3, 'Cines Palafox', 'Palafox', 25, 3, 'https://upload.wikimedia.org/wikipedia/commons/7/7c/Cines_Palafox_Zaragoza.jpg'),
(4, 'Cines Aragonia', 'Palafox', 40, 4, 'https://3.bp.blogspot.com/_aBb0D8UQ8DE/SqvJYxSCsqI/AAAAAAAAB1s/ZPLjpaVRX-M/w1200-h630-p-k-no-nu/Sala-Cines-Aragonia.jpg'),
(5, 'Cines Yelmo', 'Yelmo', 75, 5, 'https://res.cloudinary.com/deunyl3k1/image/upload/s--R9GOFIcC--/c_fill,f_auto,h_650,q_auto,w_800/v1/pnor/ds_common/0001/09/28cb2cbfb910c0f9423520727a2f55ae9bacbfbd.jpeg'),
(6, 'Artesiete Cines', 'Latorre', 90, 1, 'https://www.cineytele.com/wp-content/uploads/2022/05/artesiete_la_torre07_reporTORRE_pasillo-salas.jpg'),
(7, 'Cines Cervantes', 'Palafox', 79, 2, 'https://www.diariodesevilla.es/2022/10/31/sevilla/emblematico-edificio-Cine-Cervantes-Sevilla_1734436897_169495795_667x375.jpg'),
(8, 'Cine-Teatro Borja', 'Yelmo', 73, 4, 'https://upload.wikimedia.org/wikipedia/commons/2/2e/Cine_Cervantes%2C_Borja%2C_Zaragoza%2C_Espa%C3%B1a%2C_2018-03-30%2C_DD_03.jpg'),
(9, 'Cines Goya Caspe', 'Cinesa', 10, 1, 'https://www.prospectosdecine.com/public/images/sala_cine/1610737728_caspe-fa.jpg'),
(10, 'Canfranc Cines', 'Yelmo', 20, 2, 'https://www.aragonmusical.com/wp-content/uploads/2016/06/Teatro-de-las-Esquinas.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Id_Usuario` int(2) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Id_Usuario`, `Nombre`, `Password`, `Email`) VALUES
(1, 'Kaik', '123', 'kaik@gmail.com'),
(2, 'María', 'abcde12345', 'maria@example.com'),
(3, 'Pedro', 'contraseña456', 'pedro@example.com'),
(4, 'Sofía', '123456', 'sofia@example.com'),
(5, 'Ana', 'contraseña789', 'ana@example.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bebida`
--
ALTER TABLE `bebida`
  ADD PRIMARY KEY (`id_Bebida`),
  ADD KEY `id_Restaurante` (`id_Restaurante`);

--
-- Indices de la tabla `platos`
--
ALTER TABLE `platos`
  ADD PRIMARY KEY (`id_Plato`),
  ADD KEY `id_Restaurante` (`id_Restaurante`);

--
-- Indices de la tabla `restaurante`
--
ALTER TABLE `restaurante`
  ADD PRIMARY KEY (`id_Restaurante`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id_Usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bebida`
--
ALTER TABLE `bebida`
  MODIFY `id_Bebida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `platos`
--
ALTER TABLE `platos`
  MODIFY `id_Plato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `restaurante`
--
ALTER TABLE `restaurante`
  MODIFY `id_Restaurante` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Id_Usuario` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bebida`
--
ALTER TABLE `bebida`
  ADD CONSTRAINT `bebida_ibfk_1` FOREIGN KEY (`id_Restaurante`) REFERENCES `restaurante` (`id_Restaurante`);

--
-- Filtros para la tabla `platos`
--
ALTER TABLE `platos`
  ADD CONSTRAINT `platos_ibfk_1` FOREIGN KEY (`id_Restaurante`) REFERENCES `restaurante` (`id_Restaurante`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
