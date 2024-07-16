CREATE Database IF NOT EXISTS store-multimarcas;

DROP TABLE IF EXISTS "UserEntity";

CREATE TABLE UserEntity(
    id bigint(20) AUTO_INCREMENT NOT NULL ,
    email varchar(50) NOT NULL,
    password varchar(255) NOT NULL,
    status BOOLEAN DEFAULT FALSE,
    PRIMARY KEY ("id"),
    UNIQUE KEY "UK_USUARIO_EMAIL" ("email"),
    KEY "IDX_USUARIO_EMAIL" ("email")
)
DROP TABLE IF EXISTS "PROFILE";

CREATE TABLE PROFILE(
    id bigint(20) AUTO_INCREMENT NOT NULL,
    description varchar(50) NOT NULL,
    PRIMARY KEY ("id"),
    UNIQUE KEY "UK_PROFILE_DESCRIPTION" ("description")
)

LOCK TABLES "profile" WRITE;

INSERT INTO "profile" values(1, "ADMIN"), (2,"CLIENT");

UNLOCK TABLES;

DROP TABLE IF EXISTS "user_with_profile";

CREATE TABLE USER_WITH_PROFILE (
    user_id bigint(20) NOT NULL,
    profile_id bigint(20) NOT NULL,
    PRIMARY KEY("user_id", "profile_id"),
    KEY "FK_USER_WITH_PROFILE_ID" ("profile_id"),
    KEY "FK_PROFILE_WITH_USER_ID" ("user_id"),
    CONSTRAINT "FK_PROFILE_WITH_USER_ID" FOREIGN KEY ("user_id") REFERENCES "user_entity" ("id"),
    CONSTRAINT "FK_USER_WITH_PROFILE_ID" FOREIGN KEY ("profile_id") REFERENCES "profile" ("id")
)

LOCK TABLES "user_with_profile" WRITE;

UNLOCK TABLES;