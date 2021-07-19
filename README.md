# Read Me


I tried to make some changes both in structures and some code.
I moved the main method to 
`src/com/proquest/interview/phonebook/PhoneBookApp.java`


I made the assumption that `PhoneBookImpl` as the Service Layers where most of the Business Logic should happens there. There was almost zero business logic here in this project to put in the service layer except for some exception handling and combing firstName and lastName.

And I believe the service layer shouldn't get dirty with the Database operations such as connections and statements.

I tried to untouch the DatabaseUtil class but added a DAO - Data Access Layer for database operations - only `Create`,  `Retrieve` and `RetrieveAll` in this project.

I also tried to add a db integration test  which should cover CR operations needed for this project, and also added a Unit Test for Service Layer which I added a `Mockito` library to configure the mock objects. 
