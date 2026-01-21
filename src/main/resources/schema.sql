DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

CREATE TABLE authors (
   id BIGINT DEFAULT nextval('authors_id_seq') NOT NULL,
   name TEXT,
   age INTEGER,
   CONSTRAINT author_pkey PRIMARY KEY (id)
);

CREATE TABLE books (
   isbn TEXT NOT NULL,
   title TEXT,
   author_id BIGINT,
   CONSTRAINT book_pkey PRIMARY KEY (isbn),
   CONSTRAINT fkey_author FOREIGN KEY (author_id) REFERENCES authors(id)
);
