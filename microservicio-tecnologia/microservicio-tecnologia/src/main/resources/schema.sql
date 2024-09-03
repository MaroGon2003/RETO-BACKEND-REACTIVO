CREATE TABLE IF NOT EXISTS `tecnologias` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(90) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `name_unique` (`name`)
) ENGINE=InnoDB;