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
<h1>ToDoNotes Installation and Usage Guide</h1>

<h2>Install Java</h2>
<p>Ensure Java JDK 8 or a later version is installed. If not, download and install it from the <a href="https://www.oracle.com/java/technologies/javase-downloads.html" target="_blank">official Oracle website</a>.</p>

<h2>Compile the Code</h2>
<p>Navigate to the project directory and compile the code using the following command:</p>
<pre><code>javac ToDoNotes.java</code></pre>

<h2>Run the Application</h2>
<p>Execute the application with the following command:</p>
<pre><code>java ToDoNotes</code></pre>

<h2>Add the Background Image</h2>
<p>Place your preferred background image in the specified path:</p>
<pre><code>.assets\To-Do_Image</code></pre>
<p>Ensure the file name matches the code.</p>

<h2><a name="how-to-use"></a>How to Use</h2>

<h3>Adding Tasks</h3>
<ul>
    <li>Enter a <strong>title</strong> and <strong>description</strong> for the task.</li>
    <li>Select a <strong>category</strong> from the dropdown list: <em>Work, Personal, Study, Other</em>.</li>
    <li>Choose a <strong>priority</strong> level: <em>High, Medium, Low</em>.</li>
    <li>Set the <strong>due date</strong> using the date picker.</li>
    <li>Click the <strong>Add Task</strong> button to add the task to the list.</li>
</ul>

<h3>Marking Tasks as Done</h3>
<ul>
    <li>Select the task you want to mark as done from the table.</li>
    <li>Click the <strong>Mark as Done</strong> button. The status of the selected task will change to "Completed."</li>
</ul>

<h3>Deleting Tasks</h3>
<ul>
    <li>Select the task you wish to delete.</li>
    <li>Click the <strong>Delete Task</strong> button to remove the task from the list.</li>
</ul>

<h3>Saving Tasks</h3>
<ul>
    <li>Click the <strong>Save Tasks</strong> button to save all tasks to a file (<code>tasks.dat</code>).</li>
    <li>A confirmation message will appear if the save operation is successful.</li>
</ul>

<h3>Loading Tasks</h3>
<ul>
    <li>Click the <strong>Load Tasks</strong> button to retrieve tasks from a previously saved file.</li>
    <li>Tasks will appear in the table if the file exists.</li>
</ul>

<h2><a name="user-interface"></a>User Interface</h2>
<p>The application interface consists of:</p>
<ul>
    <li><strong>Task Table:</strong> Displays all tasks with columns for Title, Description, Category, Due Date, Priority, and Status.</li>
    <li><strong>Input Fields:</strong> Includes fields for entering task details such as title, description, category, priority, and due date.</li>
    <li><strong>Action Buttons:</strong> Add, Delete, Mark as Done, Save, and Load buttons for managing tasks.</li>
    <li><strong>Background Image:</strong> An optional background image for improved aesthetics.</li>
</ul>

<h2><a name="customization-options"></a>Customization Options</h2>
<h3>Background Image</h3>
<p>Change the image by replacing the file at the specified path with another image of your choice.</p>

<h3>Priority Colors</h3>
<p>Customize the color-coding in the <code>TaskTableRenderer</code> class by modifying the RGB values for High, Medium, and Low priority levels.</p>

<h3>Categories</h3>
<p>Update or add more categories in the <code>categoryBox</code> initialization:</p>
<pre><code>categoryBox = new JComboBox<>(new String[]{"Work", "Personal", "Study", "Other", "NewCategory"});</code></pre>

<h2><a name="code-explanation"></a>Code Explanation</h2>
<p>The application is structured as follows:</p>
<ul>
    <li><strong>Main Class:</strong> <code>ToDoNotes</code> - Manages the application lifecycle and GUI components.</li>
    <li><strong>Table Model:</strong> <code>DefaultTableModel</code> - Used for dynamically managing task data.</li>
    <li><strong>File Handling:</strong> <code>ObjectOutputStream</code> and <code>ObjectInputStream</code> - Saves and loads tasks from a binary file.</li>
    <li><strong>Priority Renderer:</strong> <code>TaskTableRenderer</code> - Customizes table cell colors based on priority.</li>
    <li><strong>Event Handling:</strong> <code>ActionListener</code> interfaces handle button click events.</li>
    <li><strong>Swing Components:</strong> <code>JTable</code>, <code>JButton</code>, <code>JPanel</code>, and others are used to build the user interface.</li>
</ul>

<h2><a name="known-issues-and-limitations"></a>Known Issues and Limitations</h2>
<ul>
    <li><strong>File Path Dependency:</strong> The background image path is hardcoded. Users must ensure the image exists at the specified location.</li>
    <li><strong>Fixed Categories and Priorities:</strong> Categories and priorities are predefined and cannot be edited via the UI.</li>
    <li><strong>Error Handling:</strong> Minimal error handling is implemented for invalid file paths or data corruption.</li>
    <li><strong>File Format:</strong> Tasks are saved in a binary format, making them inaccessible outside the application.</li>
</ul>

<h2><a name="future-improvements"></a>Future Improvements</h2>
<ul>
    <li><strong>Dynamic Configuration:</strong> Allow users to dynamically set the background image path through a settings menu.</li>
    <li><strong>Custom Categories and Priorities:</strong> Enable users to add or modify categories and priorities directly within the application.</li>
    <li><strong>Export to CSV/Excel:</strong> Provide options to save tasks in human-readable formats like CSV or Excel.</li>
    <li><strong>Task Filtering:</strong> Add filters for categories, priorities, or due dates for easier navigation.</li>
    <li><strong>Drag-and-Drop Support:</strong> Implement drag-and-drop functionality for reorganizing tasks in the table.</li>
</ul>

<h2><a name="contributing"></a>Contributing</h2>
<p>Contributions are welcome! To contribute:</p>
<ol>
    <li>Fork the repository.</li>
    <li>Create a new branch for your feature:
        <pre><code>git checkout -b feature-name</code></pre>
    </li>
    <li>Commit your changes:
        <pre><code>git commit -m "Add feature"</code></pre>
    </li>
    <li>Push to the branch:
        <pre><code>git push origin feature-name</code></pre>
    </li>
    <li>Open a pull request detailing your changes.</li>
</ol>

<h2><a name="license"></a>License</h2>
<p>This project is licensed under the MIT License. See the <code>LICENSE</code> file for details.</p>

<h2><a name="contact-information"></a>Contact Information</h2>
<p>If you have any questions or suggestions, feel free to reach out to:</p>
<ul>
    <li><strong>Name:</strong> Amal Prasad Trivedi</li>
    <li><strong>Email:</strong> <a href="mailto:amaltrivedi3904stella@gmail.com">amaltrivedi3904stella@gmail.com</a></li>
    <li><strong>GitHub:</strong> <a href="https://github.com/amalprasadtrivedi/" target="_blank">GitHub Profile</a></li>
</ul>
<p><strong>Happy Task Managing!</strong></p>
