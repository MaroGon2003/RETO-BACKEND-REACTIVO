CREATE TABLE IF NOT EXISTS `tecnologias` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(50) NOT NULL,
    `descripcion` VARCHAR(90) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `nombre_unique` (`nombre`)
) ENGINE=InnoDB;