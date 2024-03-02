package Task15;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame implements ActionListener {

    private JLabel text = new JLabel("0");
    private String num1;
    private String sign;

    UI(){
        setSize(700,500);
        setLayout(new GridLayout(3, 2, 50, 30));


        for (int i = 1; i <= 9; i++) {
            JButton numberButton = new JButton(String.valueOf(i));
            numberButton.addActionListener(this);
            add(numberButton);
        }

        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(this);
        add(zeroButton);


        JButton addButton = new JButton("+");
        addButton.addActionListener(this);
        add(addButton);

        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(this);
        add(subtractButton);

        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(this);
        add(multiplyButton);

        JButton divideButton = new JButton("/");
        divideButton.addActionListener(this);
        add(divideButton);

        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        add(equalsButton);

        JButton clearButton = new JButton("C");
        clearButton.addActionListener(this);
        add(clearButton);


        add(text);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();


        if (buttonText.matches("\\d")) {        // дивилася туторіал на ютубі, але так і не допетрала, навіщо конкретня ця строка, але загалом - для перевірки)
            if (text.getText().equals("0")) {
                text.setText(buttonText);
            } else {
                text.setText(text.getText() + buttonText);
            }
        }


        if (buttonText.matches("[+\\-*/]")) {       //   як морально заблудша душа знайшла в інеті
            num1 = text.getText();
            sign = buttonText;
            text.setText("");
        }


        if (buttonText.equals("=")) {
            String num2 = text.getText();
            int result = 0;
            switch (sign) {
                case "+":
                    result = Integer.valueOf(num1) + Integer.valueOf(num2);
                    break;
                case "-":
                    result = Integer.valueOf(num1) - Integer.valueOf(num2);
                    break;
                case "*":
                    result = Integer.valueOf(num1) * Integer.valueOf(num2);
                    break;
                case "/":
                    result = Integer.valueOf(num1) / Integer.valueOf(num2);
                    break;
            }
            text.setText(String.valueOf(result));
        }


        if (buttonText.equals("C")) {
            text.setText("0");
        }
    }

    public static void main(String[] args) {
        new UI();
    }
}
