package org.wired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ToDoListApp extends JFrame {
    public AbstractButton addButton;
    public AbstractButton removeButton;
    private DefaultListModel<TaskGUI> taskListModel = new DefaultListModel<>();
    JList<TaskGUI> taskGUIJList;
    JTextField taskField;

    public ToDoListApp(String[] args) {
        setTitle("Do zrobienia");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicjalizacja taskListModel i taskGUIJList
        taskGUIJList = new JList<>(taskListModel);
        taskGUIJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(taskGUIJList);

        taskGUIJList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                TaskGUI task = (TaskGUI) value;
                JCheckBox checkbox = new JCheckBox(task.toString());
                checkbox.setSelected(task.isCompleted());
                checkbox.setBackground(isSelected ? getBackground().darker() : getBackground());
                checkbox.setEnabled(true);
                return checkbox;
            }
        });

        taskGUIJList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int index = taskGUIJList.locationToIndex(evt.getPoint());
                TaskGUI task = taskListModel.getElementAt(index);
                task.setCompleted(!task.isCompleted()); // Zmieniamy stan na przeciwny
                taskGUIJList.repaint(); // Odświeżamy wyświetlanie listy
            }
        });

        taskField = new JTextField();
        JButton addButton = new JButton("Dodaj zadanie");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskDescription = taskField.getText();
                if (!taskDescription.isEmpty()) {
                    taskListModel.addElement(new TaskGUI(taskDescription));
                    taskField.setText("");
                }
            }
        });

        JButton removeButton = new JButton("Usuń zadanie");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskGUIJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex);
                }
            }
        });

        JButton saveButton = new JButton("Zapisz zadania");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTasks();
            }
        });

        JButton loadButton = new JButton("Wczytaj zadania");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTasks();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(taskField, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(removeButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void saveTasks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("tasks.txt"))) {
            for (int i = 0; i < taskListModel.size(); i++) {
                TaskGUI task = taskListModel.getElementAt(i);
                writer.println(task.isCompleted() + ";" + task.getTaskDescription());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTasks() {
        taskListModel.clear(); // Wyczyść aktualną listę zadań
        try (BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";", 2); // Rozdzielamy po pierwszym średniku
                boolean completed = Boolean.parseBoolean(parts[0]);
                String description = parts[1];
                TaskGUI task = new TaskGUI(description);
                task.setCompleted(completed);
                taskListModel.addElement(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DefaultListModel<TaskGUI> getTaskListModel() {
        return null;
    }

    public void setFilePath(String absolutePath) {

    }
}