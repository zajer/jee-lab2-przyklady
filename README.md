# jee-lab2-przyklady

Do utworzenia bazy danych na podstawie której została wygenerowana klasa encyjna można użyć poniższego skryptu:

create table BOOKS
(
	ISBN10 CHAR(13) not null primary key,
	TITLE VARCHAR(20)
)
