CREATE TABLE movie_streaming(
    movie_id INTEGER,
    streaming_id INTEGER,
    -- Obriga o id de movie e o id de streaming a estarem relacionados
    -- a um id existente da sua classe
    CONSTRAINT fk_movie_streaming_movie FOREIGN KEY(movie_id) REFERENCES movie(id),
    CONSTRAINT fk_movie_streaming_streaming FOREIGN KEY(streaming_id) REFERENCES streaming(id)
);