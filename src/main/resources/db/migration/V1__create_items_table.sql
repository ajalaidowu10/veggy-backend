DROP TABLE IF EXISTS `items`;
CREATE TABLE items (
    `id` BIGINT(20) unsigned NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(200) NOT NULL,
    `description` VARCHAR(200),
    `image` VARCHAR(200) NOT NULL,
    `price` DECIMAL(8, 2) NOT NULL,
    `qty` INT NOT NULL,
    `created_at` TIMESTAMP NULL DEFAULT NULL,
    `updated_at` TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KED (`id`)
)