sql
Copy code
CREATE TABLE User (
  UserId INT PRIMARY KEY,
  Username VARCHAR(255) NOT NULL,
  Password VARCHAR(255) NOT NULL,
  Role VARCHAR(50) NOT NULL
);

CREATE TABLE Question (
  QuestionId INT PRIMARY KEY,
  Question VARCHAR(255) NOT NULL,
  TypeId INT,
  FOREIGN KEY (TypeId) REFERENCES QuestionType(TypeId)
);

CREATE TABLE Answer (
  AnswerId INT PRIMARY KEY,
  QuestionId INT,
  UserId INT,
  FOREIGN KEY (QuestionId) REFERENCES Question(QuestionId),
  FOREIGN KEY (UserId) REFERENCES User(UserId)
);

CREATE TABLE Option (
  OptionId INT PRIMARY KEY,
  QuestionId INT,
  OptionText VARCHAR(255) NOT NULL,
  FOREIGN KEY (QuestionId) REFERENCES Question(QuestionId)
);

CREATE TABLE CorrectOption (
  QuestionId INT,
  OptionId INT,
  PRIMARY KEY (QuestionId, OptionId),
  FOREIGN KEY (QuestionId) REFERENCES Question(QuestionId),
  FOREIGN KEY (OptionId) REFERENCES Option(OptionId)
);

CREATE TABLE AnswerText (
  AnswerTextId INT PRIMARY KEY,
  AnswerId INT,
  Text VARCHAR(255) NOT NULL,
  FOREIGN KEY (AnswerId) REFERENCES Answer(AnswerId)
);
For CRUD operations, here's an example of how you can perform them using SQL queries:

Create a user:
sql
Copy code
INSERT INTO User (UserId, Username, Password, Role) VALUES (1, 'john', 'password', 'user');
Create a question:
sql
Copy code
INSERT INTO Question (QuestionId, Question, TypeId) VALUES (1, 'What is the capital of France?', 1);
Create options for the question:
sql
Copy code
INSERT INTO Option (OptionId, QuestionId, OptionText) VALUES (1, 1, 'Paris');
INSERT INTO Option (OptionId, QuestionId, OptionText) VALUES (2, 1, 'London');
INSERT INTO Option (OptionId, QuestionId, OptionText) VALUES (3, 1, 'Berlin');
INSERT INTO Option (OptionId, QuestionId, OptionText) VALUES (4, 1, 'Madrid');
Specify the correct option(s) for the question:
sql
Copy code
INSERT INTO CorrectOption (QuestionId, OptionId) VALUES (1, 1);
Insert an answer from the user:
sql
Copy code
INSERT INTO Answer (AnswerId, QuestionId, UserId) VALUES (1, 1, 1);
Insert the answer text:
sql
Copy code
INSERT INTO AnswerText (AnswerTextId, AnswerId, Text) VALUES (1, 1, 'Paris');
To check if the user's answer is correct, you can use the following query:

sql
Copy code
SELECT COUNT(*) AS CorrectAnswerCount
FROM Answer a
JOIN CorrectOption co ON a.QuestionId = co.QuestionId
WHERE a.UserId = 1
  AND a.AnswerId = 1
  AND co.OptionId IN (
    SELECT OptionId
    FROM AnswerText
    WHERE AnswerId = a.AnswerId
      AND Text = (
        SELECT Text
        FROM Option
        WHERE OptionId = co.OptionId
      )
  );
This query counts the number of correct answers for a specific user's answer. If the CorrectAnswerCount is greater than 0, it means the user's answer is correct.

Please note that these are just examples, and you may need to modify them based on your specific requirements and table structures.





