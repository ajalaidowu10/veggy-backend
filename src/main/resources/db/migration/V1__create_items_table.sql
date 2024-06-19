CREATE TABLE IF NOT EXISTS items (
    `id` BIGINT(20) unsigned NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(200) NOT NULL,
    `description` VARCHAR(200) DEFAULT NULL,
    `image` VARCHAR(200) DEFAULT NULL,
    `price` DECIMAL(8, 2) NOT NULL,
    `qty` INT NOT NULL,
    `created_at` TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)