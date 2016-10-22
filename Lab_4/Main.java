package Lab_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by igor on 22.10.16.
 */
public class Main {
    public static void main(String args[]) {

        new Frame("Lab_4", 1700, 1200);
    }
}

class Frame extends JFrame {
    Frame(String text, int width, int height) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(50, 50, width, height);
        setTitle(text);
        setLayout(null);
        new Presenter(this);
        setVisible(true);
    }

}

class Presenter {
    Presenter(Frame frame) {
        JTextArea jTextArea = new JTextArea();
        jTextArea.setBounds(500, 200, 300, 300);

        JButton textAreaButton = new JButton("View properties");
        textAreaButton.setBounds(550, 550, 200, 50);

        JButton setHeightButton = new JButton("Set height");
        setHeightButton.setBounds(50, 100, 200, 50);

        JButton setWeightButton = new JButton("Set weight");
        setWeightButton.setBounds(300, 100, 200, 50);

        JButton setMassButton = new JButton("Set mass");
        setMassButton.setBounds(550, 100, 200, 50);

        JButton setCountRollersButton = new JButton("Set Count Rollers");
        setCountRollersButton.setBounds(850, 100, 200, 50);

        JButton setColorButton = new JButton("Set Color");
        setColorButton.setBounds(1100, 100, 200, 50);

        JTextField heightTextField = new JTextField();
        heightTextField.setBounds(50, 20, 200, 50);

        JTextField weightTextField = new JTextField();
        weightTextField.setBounds(300, 20, 200, 50);

        JTextField countRollersTextField = new JTextField();
        countRollersTextField.setBounds(550, 20, 200, 50);

        JTextField massTextField = new JTextField();
        massTextField.setBounds(850, 20, 200, 50);

        JTextField colorTextField = new JTextField();
        colorTextField.setBounds(1100, 20, 200, 50);

        Listener listener = new Listener();
        listener.addChairColorListener(setColorButton, colorTextField);
        listener.addChairCountRollersListener(setCountRollersButton, countRollersTextField);
        listener.addChairHeightListener(setHeightButton, heightTextField);
        listener.addChairMassListener(setMassButton, massTextField);
        listener.addChairWeightListener(setWeightButton, weightTextField);
        listener.addChairPropertiesListener(textAreaButton, jTextArea);

        frame.add(jTextArea);
        frame.add(textAreaButton);
        frame.add(setColorButton);
        frame.add(setCountRollersButton);
        frame.add(setWeightButton);
        frame.add(setMassButton);
        frame.add(heightTextField);
        frame.add(setHeightButton);
        frame.add(weightTextField);
        frame.add(colorTextField);
        frame.add(countRollersTextField);
        frame.add(massTextField);
    }
}

class Chair {
    private int height;
    private int width;
    private String color;
    private double mass;
    private int countRollers;

    Chair(int height, int width, String color, double mass, int countRollers) {
        this.height = height;
        this.width = width;
        this.color = color;
        this.mass = mass;
        this.countRollers = countRollers;
    }

    int getHeight() {
        return height;
    }

    void setHeight(int height) {
        this.height = height;
    }

    int getWidth() {
        return width;
    }

    void setWidth(int width) {
        this.width = width;
    }

    String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }

    double getMass() {
        return mass;
    }

    void setMass(double mass) {
        this.mass = mass;
    }

    int getCountRollers() {
        return countRollers;
    }

    void setCountRollers(int countRollers) {
        this.countRollers = countRollers;
    }

}

class Action {
    private Chair chair = new Chair(50, 50, "black", 5, 5);

    void setChairHeight(JTextField jTextField) {
        chair.setHeight(Integer.parseInt(jTextField.getText()));

    }

    void setChairWeight(JTextField jTextField) {
        chair.setWidth(Integer.parseInt(jTextField.getText()));
    }

    void setChairColor(JTextField jTextField) {
        chair.setColor(jTextField.getText());
    }

    void setChairMass(JTextField jTextField) {
        chair.setMass(Integer.parseInt(jTextField.getText()));

    }

    void setChairCoutnRollers(JTextField jTextField) {
        chair.setCountRollers(Integer.parseInt(jTextField.getText()));

    }

    void getChairProperties(JTextArea textArea) {
        textArea.setText("");
        textArea.append("\n" + "color " + chair.getColor());
        textArea.append("\n" + " width " + String.valueOf(chair.getWidth()));
        textArea.append("\n" + "height" + String.valueOf(chair.getHeight()));
        textArea.append("\n" + "mass " + String.valueOf(chair.getMass()));
        textArea.append("\n" + "CountRollers " + String.valueOf(chair.getCountRollers()));
    }

}

class Listener {

    private Action action = new Action();

    void addChairWeightListener(JButton btnPress, JTextField jTextField) {

        btnPress.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                action.setChairWeight(jTextField);
            }
        });
    }

    void addChairHeightListener(JButton btnPress, JTextField jTextField) {

        btnPress.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                action.setChairHeight(jTextField);
            }
        });
    }

    void addChairMassListener(JButton btnPress, JTextField jTextField) {

        btnPress.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                action.setChairMass(jTextField);
            }
        });
    }

    void addChairColorListener(JButton btnPress, JTextField jTextField) {

        btnPress.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                action.setChairColor(jTextField);
            }
        });
    }

    void addChairCountRollersListener(JButton btnPress, JTextField jTextField) {

        btnPress.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                action.setChairCoutnRollers(jTextField);
            }
        });
    }

    void addChairPropertiesListener(JButton btnPress, JTextArea jTextArea) {

        btnPress.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                action.getChairProperties(jTextArea);
            }
        });
    }


}
