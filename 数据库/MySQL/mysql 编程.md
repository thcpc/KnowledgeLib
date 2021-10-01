```sql
DELIMITER $$ --写函数之前必须写，标志
CREATE FUNCTION mock_data()
RETURNS INT
BEGIN
	DELCARE num INT DEFAULT 1000;
	DELCARE i INT DEFAULT 0;
	WHILE i<num DO
		INSER INTO app_user(`name`,`email`,`phone`,`gender`,`password`,`age`) VALUES(CONTACT('User',i),'ssss@163.com',CONACT('18',FLOOR(RAND()*((999999999-1000000000)+1000000000))),FLOOR(RAND()*2),UUID(),FLOOR(RAND()*100));
		SET i = i + 1;
	END WHILE;
	RETURN I;
END;

SELECT mock_data();
```