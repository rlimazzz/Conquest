package Todo;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;

public class App implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Reset");
    JButton addTaskButton = new JButton("ADD");
    JTextField taskTextField = new JTextField("ADD sua task aqui");
    JTextArea notesArea = new JTextArea();
    JLabel timeLabel = new JLabel();
    JButton deleteTaskButton = new JButton();
    LocalDateTime dataHora;
    JList<Todo.Task> taskList;
    DefaultListModel<Todo.Task> taskListModel;

    int taskCounter = 1;

    TemporizerTime time = new TemporizerTime();
    boolean started = false;
    Todo.Task currentTask = null;

    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            time.updateTime(1000);
            timeLabel.setText(time.getFullTimeString());
            if (currentTask != null) {
                currentTask.updateTimeSpent(Duration.ofMillis(1000));
                taskList.repaint();
            }
        }
    });

    public App() {
        timeLabel.setText(time.getFullTimeString());
        timeLabel.setBounds(25, 25, 200, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createEtchedBorder(Color.green, Color.black));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        addTaskButton.setBounds(25, 150, 75, 25);
        taskTextField.setBounds(100, 150, 250, 25);

        //notesArea.setBounds(25, 140, 325, 100);

        startButton.setBounds(250, 25, 100, 50);
        startButton.setFont(new Font("Verdana", Font.PLAIN, 15));
        startButton.setFocusable(false);

        stopButton.setBounds(250, 80, 100, 45);
        stopButton.setFont(new Font("Verdana", Font.PLAIN, 15));
        stopButton.setFocusable(false);

        addTaskButton.setFocusable(false);

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        addTaskButton.addActionListener(this);

        taskListModel = new DefaultListModel<>();

        taskList = new JList<Todo.Task>(taskListModel);

        JScrollPane taskScrollPane = new JScrollPane(taskList);
        taskScrollPane.setBounds(25, 200, 325, 200);

        frame.add(timeLabel);
        frame.add(taskTextField);
        frame.add(addTaskButton);
        frame.add(notesArea);
        frame.add(taskScrollPane);
        frame.add(startButton);
        frame.add(stopButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setTitle("Pomodoro");
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            timer.start();
            if (!started) {
                started = true;
                startButton.setText("Stop");
                dataHora = LocalDateTime.now();

                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    currentTask = taskListModel.get(selectedIndex);
                    currentTask.setStartTime(dataHora);
                }
            } else {
                started = false;
                startButton.setText("Start");
                timer.stop();
                if (currentTask != null) {
                    currentTask = null;
                }
            }
        } else if (e.getSource() == stopButton) {
            started = false;
            startButton.setText("Start");
            timer.stop();
            time.resetTime();
            timeLabel.setText(time.getFullTimeString());
        } else if (e.getSource() == addTaskButton) {
            String taskDescription = taskTextField.getText();
            if (!taskDescription.isEmpty() && !taskDescription.equals("ADD sua task aqui")) {
                Todo.Task newTask = new Todo.Task(taskDescription);
                taskListModel.addElement(newTask);
                taskTextField.setText("");
            }
        }
    }
}
