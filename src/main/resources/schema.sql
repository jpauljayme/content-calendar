CREATE TABLE IF NOT EXISTS Content (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(20) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url varchar(255)
);

INSERT INTO Content(title,description,status,content_type,date_created)
    VALUES (
        'Lana Del Rey - The Mother I Never Had',
        'A conversation with an adult full of the chanteuse music',
        'IDEA',
        'ARTICLE',
        CURRENT_TIMESTAMP
);