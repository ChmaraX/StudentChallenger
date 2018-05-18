<h1 align="center">
  <br>
   
  <br>
</h1>

# Student Challenger

<p align="center">
  This project was created as a part of university work on object oriented programming. The concept of this project was to create an e-learning software that will provide simple and effective education while stimulating and motivating students to reuse it trough simple principles of game, competition and progress rewards. User interface is designed in slovak language.
</p>

## Description
After creating the profile, the student chooses a subject where he / she can perform tasks and exams, challenges. Tasks and exams are various challenging and specified (time, ordering, multiple-choice ...). Depending on the difficulty and the success of the solution, the student is awarded with points that contributes in the overall rankings of all students. With completing special or extraordinarily demanding tasks (eg three exam with no mistake consecutively), the student receives badges that are also attributed to the profile and affect ranking in the laddeboard. Student profile include stats as skill level (beginner, intermediate ...), total points, badges, number of completed tasks and exams and more. The result of this project will be software that will enhance motivation to study with simple game principles and competition, as well as a teacher's overview of student performance or simple implementation of new exams and badges by teachers.


## Usage

Using `javac Login.java ` will initialize the program at the Login interface. There you can register as a new user or login trough an existing account. Data are serialized locally for simplification.

### Main menu

- <b>Exams</b>
<br>Includes choosing an exam, option of timer (points multiplier x2), after pressing Start button the exam runs and you are promted to answer various questions. 
The result is shown after completing the exam, including obtained points or badges. 

- <b>Profile</b>
<br>Displays all information and stats about user. 

- <b>Ladderboard</b> 
<br>Rankings of all students, sortable. 

- <b>Create an exam</b>
<br>Allows you to create exam, including choosing question type, wording of question and answer.

> Every question has value of 1 point by default.
