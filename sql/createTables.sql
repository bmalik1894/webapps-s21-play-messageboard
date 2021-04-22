CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username varchar(20) NOT NULL,
    color varchar(30) NOT NULL,
    password varchar(200) NOT NULL
);
CREATE Table messages (
    message_id SERIAL PRIMARY KEY,
    touser int4 NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    fromuser int4 NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    body varchar(2000) NOT NULL,
    timestamp varchar(30) NOT NULL
);