# ToDoNotes Application

**ToDoNotes** is a simple, feature-rich desktop application designed to help users manage their tasks efficiently. Built using Java Swing, it provides an intuitive graphical interface for creating, organizing, and tracking tasks. 

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [System Requirements](#system-requirements)
5. [Installation and Setup](#installation-and-setup)
6. [How to Use](#how-to-use)
   - [Adding Tasks](#adding-tasks)
   - [Marking Tasks as Done](#marking-tasks-as-done)
   - [Deleting Tasks](#deleting-tasks)
   - [Saving Tasks](#saving-tasks)
   - [Loading Tasks](#loading-tasks)
7. [User Interface](#user-interface)
8. [Customization Options](#customization-options)
9. [Code Explanation](#code-explanation)
10. [Known Issues and Limitations](#known-issues-and-limitations)
11. [Future Improvements](#future-improvements)
12. [Contributing](#contributing)
13. [License](#license)
14. [Contact Information](#contact-information)

---
![image](https://github.com/user-attachments/assets/d3393227-11dd-467c-8a87-4806a0371527)

## <a name="introduction"></a>Introduction

Managing tasks is crucial for personal productivity and organization. **ToDoNotes** is a lightweight Java-based desktop application designed for individuals seeking a straightforward way to manage their daily to-dos. 

This application allows users to create tasks with descriptions, categories, priorities, and due dates. Users can update, delete, or mark tasks as completed. For convenience, tasks can also be saved to a file and loaded later, ensuring that no data is lost between sessions.

---

## <a name="features"></a>Features

The **ToDoNotes** application comes with the following features:

1. **Add Tasks:** Add tasks with attributes such as title, description, category, priority, and due date.
2. **Mark as Done:** Mark tasks as completed to track progress.
3. **Delete Tasks:** Remove tasks that are no longer required.
4. **Save Tasks:** Save tasks to a file (`tasks.dat`) to maintain data persistency.
5. **Load Tasks:** Load previously saved tasks to resume from where you left off.
6. **Customizable Categories and Priorities:** Tasks can be categorized as "Work," "Personal," "Study," or "Other," with priorities set to "High," "Medium," or "Low."
7. **Dynamic Priority Color Coding:** Tasks are visually distinguished by priority, enhancing usability.
8. **Intuitive User Interface:** Designed with simplicity and functionality in mind, ensuring ease of use for all users.
9. **Background Image Support:** Includes an aesthetic background for a visually appealing interface.

---

## <a name="technologies-used"></a>Technologies Used

- **Programming Language:** Java (JDK 8 or later)
- **GUI Framework:** Java Swing
- **File I/O:** For saving and loading tasks
- **Serialization:** To persist data between sessions

---

## <a name="system-requirements"></a>System Requirements

To run the **ToDoNotes** application, ensure your system meets the following requirements:

- Operating System: Windows, macOS, or Linux
- Java Runtime Environment (JRE) 8 or later
- 2 GB RAM or more (recommended)
- At least 100 MB of free disk space
- A screen resolution of 1024x768 or higher

---

## <a name="installation-and-setup"></a>Installation and Setup

Follow these steps to set up the application:

1. **Download the Source Code:**
   - Clone the repository or download the source code files.

   ```bash
   git clone <repository-url>
Install Java:

Ensure Java JDK 8 or a later version is installed. If not, download and install it from the official Oracle website.
Compile the Code:

Navigate to the project directory and compile the code using the following command:
javac ToDoNotes.java
Run the Application:

Execute the application with the following command:
bash
Copy code
java ToDoNotes
Add the Background Image:

Place your preferred background image in the specified path:
<br><br>
--.assets\To-Do_Image
Ensure the file name matches the code.
<a name="how-to-use"></a>How to Use<br><br>
Adding Tasks
Enter a title and description for the task.
Select a category from the dropdown list: Work, Personal, Study, Other.
Choose a priority level: High, Medium, Low.
Set the due date using the date picker.
Click the Add Task button to add the task to the list.
Marking Tasks as Done
Select the task you want to mark as done from the table.
Click the Mark as Done button. The status of the selected task will change to "Completed."
Deleting Tasks
Select the task you wish to delete.
Click the Delete Task button to remove the task from the list.
Saving Tasks
Click the Save Tasks button to save all tasks to a file (tasks.dat).
A confirmation message will appear if the save operation is successful.
Loading Tasks
Click the Load Tasks button to retrieve tasks from a previously saved file.
Tasks will appear in the table if the file exists.
<a name="user-interface"></a>User Interface
The application interface consists of:

Task Table:
Displays all tasks with columns for Title, Description, Category, Due Date, Priority, and Status.
Input Fields:
Includes fields for entering task details such as title, description, category, priority, and due date.
Action Buttons:
Add, Delete, Mark as Done, Save, and Load buttons for managing tasks.
Background Image:
An optional background image for improved aesthetics.
<a name="customization-options"></a>Customization Options
Background Image:
Change the image by replacing the file at the specified path with another image of your choice.
Priority Colors:
Customize the color-coding in the TaskTableRenderer class by modifying the RGB values for High, Medium, and Low priority levels.
Categories:
Update or add more categories in the categoryBox initialization:
java
Copy code
categoryBox = new JComboBox<>(new String[]{"Work", "Personal", "Study", "Other", "NewCategory"});
<a name="code-explanation"></a>Code Explanation
The application is structured as follows:

Main Class: ToDoNotes
Manages the application lifecycle and GUI components.
Table Model: DefaultTableModel
Used for dynamically managing task data.
File Handling: ObjectOutputStream and ObjectInputStream
Saves and loads tasks from a binary file.
Priority Renderer: TaskTableRenderer
Customizes table cell colors based on priority.
Event Handling:
ActionListener interfaces handle button click events.
Swing Components:
JTable, JButton, JPanel, and others are used to build the user interface.
<a name="known-issues-and-limitations"></a>Known Issues and Limitations
File Path Dependency:
The background image path is hardcoded. Users must ensure the image exists at the specified location.
Fixed Categories and Priorities:
Categories and priorities are predefined and cannot be edited via the UI.
Error Handling:
Minimal error handling is implemented for invalid file paths or data corruption.
File Format:
Tasks are saved in a binary format, making them inaccessible outside the application.
<a name="future-improvements"></a>Future Improvements
Dynamic Configuration:
Allow users to dynamically set the background image path through a settings menu.
Custom Categories and Priorities:
Enable users to add or modify categories and priorities directly within the application.
Export to CSV/Excel:
Provide options to save tasks in human-readable formats like CSV or Excel.
Task Filtering:
Add filters for categories, priorities, or due dates for easier navigation.
Drag-and-Drop Support:
Implement drag-and-drop functionality for reorganizing tasks in the table.
<a name="contributing"></a>Contributing
Contributions are welcome! To contribute:

Fork the repository.
Create a new branch for your feature:

git checkout -b feature-name
Commit your changes:

git commit -m "Add feature"

Push to the branch:
git push origin feature-name
Open a pull request detailing your changes.

<a name="license"></a>License
This project is licensed under the MIT License. See the LICENSE file for details.

<a name="contact-information"></a>Contact Information
If you have any questions or suggestions, feel free to reach out to:
<br><br>
Name: Amal Prasad Trivedi<br>
Email: [Email ID](amaltrivedi3904stella@gmail.com)<br>
GitHub: [GitHub Profile](https://github.com/amalprasadtrivedi/)<br>
Happy Task Managing!<br><br>

You can copy and paste this directly into your `README.md`. Let me know if you need further customizations!










