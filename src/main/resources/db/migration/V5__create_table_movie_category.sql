CREATE TABLE movie_category(
    movie_id INTEGER,
    category_id INTEGER,
    -- Obriga o id de movie e o id de category a estarem relacionados
    -- a um id existente da sua classe
    CONSTRAINT fk_movie_category_movie FOREIGN KEY(movie_id) REFERENCES movie(id),
    CONSTRAINT fk_movie_category_category FOREIGN KEY(category_id) REFERENCES category(id)
)