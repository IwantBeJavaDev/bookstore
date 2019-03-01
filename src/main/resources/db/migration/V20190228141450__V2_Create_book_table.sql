create table bookstore.BOOK (
  ID_BOOK int8 not null,
  TITLE VARCHAR(255) not null,
  DESCRIPTION text null,
  ISBN varchar(255) not null,
  RELEASE_DATE date not null,

  constraint pk_book primary key(ID_BOOK)
);
create index in_book_title on bookstore.BOOK using btree(title);
create index in_book_isbn on bookstore.BOOK using btree(isbn);

CREATE SEQUENCE bookstore.S_BOOK INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1;
