DROP TYPE IF EXISTS file_types_enum CASCADE;
CREATE TYPE file_types_enum AS ENUM ('UNKNOWN', 'IMAGE', 'SOUND', 'WORD_DOCUMENT', 'PDF_DOCUMENT')