import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDoApp extends JFrame {
    private JTable taskTable;
    private DefaultTableModel tableModel;
    private JTextField titleField;
    private JTextField descriptionField;
    private JComboBox<String> categoryBox;
    private JComboBox<String> priorityBox;
    private JSpinner dueDateSpinner;

    public ToDoApp() {
        setTitle("To-Do Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10)); // Adds margin around the frame content

        // Custom Background Panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(30, 30, 30); // Dark grey
                Color color2 = new Color(60, 60, 60); // Slightly lighter grey
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setLayout(new BorderLayout(10, 10));
        backgroundPanel.setBorder(new EmptyBorder(15, 15, 15, 15)); // Margin for the entire content
        setContentPane(backgroundPanel);

        // Table Model and Table
        tableModel = new DefaultTableModel(new String[]{"Title", "Description", "Category", "Due Date", "Priority", "Status"}, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        taskTable = new JTable(tableModel);
        taskTable.setRowHeight(30);

        // Set custom renderer for the "Priority" column (index 4)
        taskTable.getColumnModel().getColumn(4).setCellRenderer(new TaskTableRenderer());
        JScrollPane scrollPane = new JScrollPane(taskTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // Input Panel
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.setOpaque(false);

        JPanel fieldsPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        fieldsPanel.setOpaque(false);

        titleField = new JTextField();
        descriptionField = new JTextField();
        categoryBox = new JComboBox<>(new String[]{"Work", "Personal", "Study", "Other"});
        priorityBox = new JComboBox<>(new String[]{"High", "Medium", "Low"});
        dueDateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dueDateSpinner, "dd/MM/yyyy");
        dueDateSpinner.setEditor(dateEditor);

        fieldsPanel.add(createLabel("Title:"));
        fieldsPanel.add(titleField);
        fieldsPanel.add(createLabel("Description:"));
        fieldsPanel.add(descriptionField);
        fieldsPanel.add(createLabel("Category:"));
        fieldsPanel.add(categoryBox);
        fieldsPanel.add(createLabel("Priority:"));
        fieldsPanel.add(priorityBox);
        fieldsPanel.add(createLabel("Due Date:"));
        fieldsPanel.add(dueDateSpinner);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new GridLayout(1, 5, 10, 10));

        JButton addButton = createButton("Add Task");
        JButton deleteButton = createButton("Delete Task");
        JButton markAsDoneButton = createButton("Mark as Done");
        JButton saveButton = createButton("Save Tasks");
        JButton loadButton = createButton("Load Tasks");

        buttonsPanel.add(addButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(markAsDoneButton);
        buttonsPanel.add(saveButton);
        buttonsPanel.add(loadButton);

        inputPanel.add(fieldsPanel, BorderLayout.CENTER);
        inputPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // Add components to the frame
        backgroundPanel.add(scrollPane, BorderLayout.CENTER);
        backgroundPanel.add(inputPanel, BorderLayout.SOUTH);

        // Event Listeners
        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());
        markAsDoneButton.addActionListener(e -> markAsDone());
        saveButton.addActionListener(e -> saveTasks());
        loadButton.addActionListener(e -> loadTasks());

        setVisible(true);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        return label;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(70, 70, 70));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return button;
    }

    private void addTask() {
        String title = titleField.getText();
        String description = descriptionField.getText();
        String category = (String) categoryBox.getSelectedItem();
        String priority = (String) priorityBox.getSelectedItem();
        Date dueDate = (Date) dueDateSpinner.getValue();
        String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(dueDate);

        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Title cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.addRow(new Object[]{title, description, category, formattedDate, priority, "Pending"});
        clearInputs();
    }

    private void deleteTask() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Select a task to delete!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void markAsDone() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.setValueAt("Completed", selectedRow, 5);
        } else {
            JOptionPane.showMessageDialog(this, "Select a task to mark as done!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tasks.dat"))) {
            int rowCount = tableModel.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                Object[] row = new Object[tableModel.getColumnCount()];
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    row[j] = tableModel.getValueAt(i, j);
                }
                oos.writeObject(row);
            }
            JOptionPane.showMessageDialog(this, "Tasks saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to save tasks!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadTasks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tasks.dat"))) {
            tableModel.setRowCount(0); // Clear existing tasks
            while (true) {
                Object[] row = (Object[]) ois.readObject();
                tableModel.addRow(row);
            }
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Failed to load tasks!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearInputs() {
        titleField.setText("");
        descriptionField.setText("");
        categoryBox.setSelectedIndex(0);
        priorityBox.setSelectedIndex(0);
        dueDateSpinner.setValue(new Date());
    }

    // Custom Renderer for Priority Column
    private static class TaskTableRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Apply custom styling for the "Priority" column
            if (column == 4) {
                String priority = (String) value;
                switch (priority) {
                    case "High":
                        component.setBackground(Color.RED);
                        component.setForeground(Color.WHITE);
                        break;
                    case "Medium":
                        component.setBackground(Color.ORANGE);
                        component.setForeground(Color.BLACK);
                        break;
                    case "Low":
                        component.setBackground(Color.GREEN);
                        component.setForeground(Color.BLACK);
                        break;
                    default:
                        component.setBackground(Color.WHITE);
                        component.setForeground(Color.BLACK);
                }
            } else {
                component.setBackground(Color.WHITE);
                component.setForeground(Color.BLACK);
            }

            if (isSelected) {
                component.setBackground(Color.BLUE);
                component.setForeground(Color.WHITE);
            }

            return component;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}