package Todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Reset");
    JButton addTaskButton = new JButton("ADD");
    JTextField taskTextField = new JTextField("ADD your task here");
    JTextArea notesArea = new JTextArea();
    JLabel timeLabel = new JLabel();
    JLabel taskLabel = new JLabel();
    JButton deleteTaskButton = new JButton();


    int taskCounter = 1;

    TemporizerTime time = new TemporizerTime();
    boolean started = false;

    Timer timer = new Timer(1000, new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            time.updateTime(1000);
            timeLabel.setText(time.getFullTimeString());
        }
    });

    public App() {
        timeLabel.setText(time.getFullTimeString());
        timeLabel.setBounds(25, 25, 200 , 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createEtchedBorder(Color.green, Color.black));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        addTaskButton.setBounds(25, 250, 75, 25);
        taskTextField.setBounds(100, 250, 250, 25);
        taskLabel.setBounds(25, 275, 325, 25);

        notesArea.setBounds(25, 140, 325, 100);

        startButton.setBounds(250, 25, 100, 50);
        startButton.setFont(new Font("Verdana", Font.PLAIN, 15));
        startButton.setFocusable(false);

        stopButton.setBounds(250, 80, 100, 45);
        stopButton.setFont(new Font("Verdana", Font.PLAIN, 15));
        stopButton.setFocusable(false);

        addTaskButton.setFocusable(false);
        taskLabel.setBorder(BorderFactory.createEtchedBorder(Color.red, Color.black));

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        addTaskButton.addActionListener(this);

        frame.add(taskLabel);
        frame.add(timeLabel);
        frame.add(taskTextField);
        frame.add(addTaskButton);
        frame.add(notesArea);
        frame.add(startButton);
        frame.add(stopButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setTitle("Conquest");
        frame.setLayout(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton) {
            timer.start();
            if(!started) {
                started = true;
                startButton.setText("Stop");
            }else {
                started = false;
                startButton.setText("Start");
                timer.stop();
            }
        }
        else if(e.getSource() == stopButton) {
            started = false;
            startButton.setText("Start");
            timer.stop();
            time.resetTime();
            timeLabel.setText(time.getFullTimeString());
        }
    }

}
