CREATE TABLE IF NOT EXISTS book (
    id SERIAL PRIMARY KEY,
    title varchar(100) NOT NULL,
   	price decimal NOT NULL,
    publish_date date NOT NULL
);