CREATE DATABASE shopdb;
USE shopdb;

CREATE TABLE Humans(
HumanID INT PRIMARY KEY auto_increment,
FirstName VARCHAR(50),
Age INT
);

CREATE TABLE Products(
ProductID INT PRIMARY KEY auto_increment,
ProductName VARCHAR(50)
);

CREATE TABLE Byings(
ByingID INT PRIMARY KEY auto_increment,
HumanID INT,
ProductID INT,
foreign key (HumanID) references Humans(HumanID),
foreign key (ProductID) references Products(ProductID)
);

INSERT INTO Humans (FirstName,Age ) VALUES ('KATE', 17);
INSERT INTO Products (ProductName ) VALUES ('MILK');
INSERT INTO Byings (HumanID, ProductID) VALUES (1,1);

SELECT * FROM Humans;
SELECT * FROM Products;
SELECT * FROM Byings;

DELETE FROM Byings WHERE ByingID = 1;
DROP DATABASE shopdb;