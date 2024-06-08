package Todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.File;


public class App implements ActionListener {
    JFrame frame = new JFrame();
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Reset");
    JTextArea notesArea = new JTextArea();
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            elapsedTime += 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime/ 60000) % 60;
            seconds = (elapsedTime/ 1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);

        }
    });

    public App() {
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timeLabel.setBounds(25, 25, 200 , 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createEtchedBorder(Color.green, Color.black));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        notesArea.setBounds(25, 140, 325, 100);

        startButton.setBounds(250, 25, 100, 50);
        startButton.setFont(new Font("Verdana", Font.PLAIN, 15));
        startButton.setFocusable(false);

        stopButton.setBounds(250, 80, 100, 45);
        stopButton.setFont(new Font("Verdana", Font.PLAIN, 15));
        stopButton.setFocusable(false);

        startButton.addActionListener(this);
        stopButton.addActionListener(this);

        frame.add(timeLabel);
        frame.add(notesArea);
        frame.add(startButton);
        frame.add(stopButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
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
            elapsedTime = 0;
            seconds = 0;
            minutes = 0;
            hours = 0;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }
    }

}
