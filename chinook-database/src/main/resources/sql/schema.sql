DROP DATABASE IF EXISTS chinook;
CREATE DATABASE chinook;

USE chinook;

SELECT 'CREATING DATABASE STRUCTURE' as 'INFO';

/*!50503 set default_storage_engine = InnoDB */;
/*!50503 select CONCAT('storage engine: ', @@default_storage_engine) as INFO */;

CREATE TABLE album (
    album_id    SERIAL,
    title       VARCHAR(160) NOT NULL,
    artist_id   BIGINT UNSIGNED NOT NULL,
    CONSTRAINT pk_album PRIMARY KEY (album_id)
) ENGINE = INNODB;

CREATE TABLE artist (
    artist_id   SERIAL,
    name        VARCHAR(120),
    CONSTRAINT pk_artist PRIMARY KEY (artist_id)
) ENGINE = INNODB;

CREATE TABLE customer (
    customer_id     SERIAL,
    first_name      VARCHAR(80) NOT NULL,
    last_name       VARCHAR(80) NOT NULL,
    company         VARCHAR(80),
    address         VARCHAR(70),
    city            VARCHAR(40),
    state           VARCHAR(40),
    country         VARCHAR(40),
    postal_code     VARCHAR(10),
    phone           VARCHAR(24),
    fax             VARCHAR(24),
    email           VARCHAR(60) NOT NULL,
    support_rep_id  BIGINT UNSIGNED,
    CONSTRAINT pk_customer PRIMARY KEY (customer_id)
) ENGINE = INNODB;

CREATE TABLE employee (
    employee_id     SERIAL,
    first_name      VARCHAR(80) NOT NULL,
    last_name       VARCHAR(80) NOT NULL,
    title           VARCHAR(30),
    reports_to      BIGINT UNSIGNED,
    birth_date      DATETIME,
    hire_date       DATETIME,
    address         VARCHAR(70),
    city            VARCHAR(40),
    state           VARCHAR(40),
    country         VARCHAR(40),
    postal_code     VARCHAR(10),
    phone           VARCHAR(24),
    fax             VARCHAR(24),
    email           VARCHAR(60),
    CONSTRAINT pk_employee PRIMARY KEY (employee_id)
) ENGINE = INNODB;

CREATE TABLE genre (
    genre_id        SERIAL,
    name            VARCHAR(120),
    CONSTRAINT pk_genre PRIMARY KEY (genre_id)
) ENGINE = INNODB;

CREATE TABLE invoice (
    invoice_id          SERIAL,
    customer_id         BIGINT UNSIGNED NOT NULL,
    invoice_date        DATETIME NOT NULL,
    billing_address     VARCHAR(70),
    billing_city        VARCHAR(40),
    billing_state       VARCHAR(40),
    billing_country     VARCHAR(40),
    billing_postal_code NVARCHAR(10),
    total               NUMERIC(10,2) NOT NULL,
    CONSTRAINT pk_invoice PRIMARY KEY (invoice_id)
) ENGINE = INNODB;

CREATE TABLE invoice_line (
    invoice_line_id SERIAL,
    invoice_id      BIGINT UNSIGNED,
    track_id        BIGINT UNSIGNED,
    unit_price      NUMERIC(10,2) NOT NULL,
    quantity        INT NOT NULL,
    CONSTRAINT pk_invoice_line PRIMARY KEY (invoice_line_id)
) ENGINE = INNODB;

CREATE TABLE media_type (
    media_type_id   SERIAL,
    name            VARCHAR(120),
    CONSTRAINT pk_media_type PRIMARY KEY (media_type_id)
) ENGINE = INNODB;

CREATE TABLE playlist (
    playlist_id     SERIAL,
    name            VARCHAR(120),
    CONSTRAINT pk_playlist PRIMARY KEY (playlist_id)
) ENGINE = INNODB;

CREATE TABLE playlist_track (
    playlist_track_id   SERIAL,
    playlist_id         BIGINT UNSIGNED NOT NULL,
    track_id            BIGINT UNSIGNED NOT NULL,
    CONSTRAINT pk_playlist_track PRIMARY KEY (playlist_track_id)
) ENGINE = INNODB;

CREATE TABLE track (
    track_id        SERIAL,
    name            VARCHAR(200) NOT NULL,
    album_id        BIGINT UNSIGNED NOT NULL,
    media_type_id   BIGINT UNSIGNED NOT NULL,
    genre_id        BIGINT UNSIGNED,
    composer        VARCHAR(220),
    milliseconds    INT NOT NULL,
    bytes           INT,
    unit_price      NUMERIC(10,2) NOT NULL,
    CONSTRAINT pk_track PRIMARY KEY (track_id)
) ENGINE = INNODB;

-- CREATING INDEXES on ALBUM

-- FK to Artist
ALTER TABLE album
    ADD CONSTRAINT fk_album2artist
        FOREIGN KEY (artist_id)
        REFERENCES artist ( artist_id )
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

-- IDX on artist_id
ALTER TABLE album
    ADD INDEX idx_artistid (artist_id);

-- UNIQUE title per artist
ALTER TABLE album
    ADD UNIQUE INDEX unq_Title2Artist (title, artist_id);

-- FK to employee for support_rep_id
ALTER TABLE customer
    ADD CONSTRAINT fk_customer2supportRepId
    FOREIGN KEY (support_rep_id)
    REFERENCES employee (employee_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

-- IDX on support_rep_id
ALTER TABLE customer
    ADD INDEX idx_supportRepId (support_rep_id);

ALTER TABLE employee
    ADD CONSTRAINT fk_employee2reportsTo
    FOREIGN KEY (reports_to)
    REFERENCES employee (employee_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

CREATE INDEX `IFK_EmployeeReportsTo`
    ON employee (reports_to);

ALTER TABLE invoice
    ADD CONSTRAINT fk_invoice2customer
    FOREIGN KEY (customer_id)
    REFERENCES customer (customer_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

CREATE INDEX `IFK_InvoiceCustomerId`
    ON invoice (customer_id);

ALTER TABLE invoice_line
    ADD CONSTRAINT fk_invoiceline2invoice
    FOREIGN KEY (invoice_id)
    REFERENCES invoice (invoice_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

CREATE INDEX `IFK_InvoiceLineInvoiceId`
    ON invoice_line (invoice_id);

ALTER TABLE invoice_line
    ADD CONSTRAINT fk_invoiceline2trackid
    FOREIGN KEY (track_id)
    REFERENCES track (track_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

CREATE INDEX `ifk_invoiceline2trackid`
    ON invoice_line (track_id);

ALTER TABLE playlist_track
    ADD CONSTRAINT `FK_PlaylistTrackPlaylistId`
    FOREIGN KEY (playlist_id)
    REFERENCES playlist (playlist_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

CREATE INDEX `IFK_PlaylistTrackPlaylistId`
    ON playlist_track (playlist_id);

ALTER TABLE playlist_track
    ADD CONSTRAINT `FK_PlaylistTrackTrackId`
    FOREIGN KEY (track_id)
    REFERENCES track (track_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

CREATE INDEX `IFK_PlaylistTrackTrackId`
    ON playlist_track (track_id);

ALTER TABLE track
    ADD CONSTRAINT `FK_TrackAlbumId`
    FOREIGN KEY (album_id)
    REFERENCES album (album_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

CREATE INDEX `IFK_TrackAlbumId`
    ON track (album_id);

ALTER TABLE track
    ADD CONSTRAINT `FK_TrackGenreId`
    FOREIGN KEY (genre_id)
    REFERENCES genre (genre_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

CREATE INDEX `IFK_TrackGenreId`
    ON track (genre_id);

ALTER TABLE track
    ADD CONSTRAINT `FK_TrackMediaTypeId`
    FOREIGN KEY (media_type_id)
    REFERENCES media_type (media_type_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

CREATE INDEX `IFK_TrackMediaTypeId`
    ON track (media_type_id);
