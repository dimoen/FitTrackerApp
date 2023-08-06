# FitTrackerApp
Android Fitness app to track user training 
Project Idea:
The goal is to develop an app for tracking sports activities. Users can create sports activities and choose the parameters they want to track (duration, distance, elevation gain, weight, number of sets, etc.).

Users can record and monitor their progress and changes over time within the app. The app could also provide features to create training plans and offer exercise recommendations to support individual fitness goals of the users.

Overall, the app will provide users with a means to track, analyze, and improve their fitness data to achieve their health and fitness goals.

See Sketch:
GeneralInfo.pdf

See Milestone 2:
Milestone2.pdf

Third Milestone on 28.05.2023

Navigation Diagram:
https://code.fbi.h-da.de/-/ide/project/human-computer-interaction/HCI_SS23_Meyer/HCI_SS23_Meyer_Gruppe12-Bach_Boudaou_Durben_Kausch/tree/main/-/navigationdiagram.drawio.png/

Screen Diagrams:


Paper Prototype:
Images: https://code.fbi.h-da.de/-/ide/project/human-computer-intera..main/-/PaperPrototype/

Rationale for Design Decisions:
Cross-page Design:

The menu is accessible on every page through the element located at the top left.
Next to the menu element, the current page/subpage is displayed to help users keep track of their location.
The button for saving entered data is represented by a plus symbol and is fixed in the bottom right corner for easy access.
The use of dropdown menus ensures data consistency.
Body Weight Tracking:

The page for tracking body weight is kept minimal to allow users to quickly enter their weight, even when drowsy.
The page includes a weight-time graph, a field for entering weight, and the save button.
Workout/Exercise:

To provide a comprehensive overview, only six exercises/values are available for tracking in each workout.
Description of Test Cases:

Stereotype 1: Amateur Athlete

Add a new exercise "Running" and fill in the corresponding attributes.
Add multiple training sessions for the exercise "Running."
View the progress to see if there are any improvements.
Track body weight.
Stereotype 2: Professional Athlete

Add a new exercise "Bench Press" and fill in the corresponding attributes.
Set a training goal for the exercise "Bench Press."
Add multiple training sessions for the exercise "Bench Press."
Review progress across the individual training sessions.
Create a workout and add exercises to it.
Track the workout.
Track body weight.
Implementation:

The app includes a search function to find exercises and workouts.
An overview page displays all exercises.
The home screen allows users to enter their body weight.
A dashboard presents graphical representations of exercise data.
The data is stored in a JSON file when an exercise/workout is entered and loaded at each app start.
Usability Test and Design Review:

To improve the app's user-friendliness, usability tests were conducted with various test cases to evaluate effectiveness, efficiency, satisfaction, and robustness. The test results highlighted positive aspects such as intuitive navigation, clear design, legible font sizes, meaningful icons, and consistent color schemes. Improvement suggestions include adding more options, adjusting settings, considering usability feedback, and optimizing exercise attribute input.

The app already offers a certain level of user-friendliness and intuitiveness. However, additional options should be provided to enhance the app's functionality and flexibility. The settings should also be optimized to ensure a more user-friendly configuration.

Feedback from usability tests should be considered to further optimize the design. Simplifying the input of exercise attributes and providing better instructions for exercise execution are essential.

The results from the usability tests and design reviews provide valuable insights for improving the app and ensuring an optimal user experience.

Usability Tests and Design Reviews:

