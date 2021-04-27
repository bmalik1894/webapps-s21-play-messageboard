CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username varchar(20) NOT NULL,
    color varchar(30) NOT NULL,
    password varchar(200) NOT NULL
);
CREATE Table messages (
    message_id SERIAL PRIMARY KEY,
    touser varchar(30) NOT NULL,
    fromuser varchar(30) NOT NULL,
    body varchar(2000) NOT NULL,
    timestamp varchar(30) NOT NULL
);