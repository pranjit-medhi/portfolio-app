CREATE TABLE projects (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(255),
description TEXT,
tech_stack VARCHAR(255),
github_url VARCHAR(255),
live_url VARCHAR(255),
image_url VARCHAR(255),
featured BOOLEAN,
created_at TIMESTAMP,
updated_at TIMESTAMP
);

CREATE TABLE blog_posts (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(255),
slug VARCHAR(255) UNIQUE,
content LONGTEXT,
tags VARCHAR(255),
published BOOLEAN,
created_at TIMESTAMP,
updated_at TIMESTAMP
);

CREATE TABLE metrics (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
page VARCHAR(255),
views INT,
unique_visitors INT,
recorded_date DATE
);

CREATE TABLE users (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(100) UNIQUE,
password VARCHAR(255),
role VARCHAR(50)
);