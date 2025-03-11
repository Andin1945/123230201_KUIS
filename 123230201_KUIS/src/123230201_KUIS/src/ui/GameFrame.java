package ui;

import model.GameLogic;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    private JTextField player1Field, player2Field;
    private JRadioButton batu1, kertas1, gunting1, batu2, kertas2, gunting2;
    private JButton battleButton, resetButton, logoutButton;
    private JLabel hasilLabel;

    public GameFrame(String username) {
        setTitle("Frame GAME");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        // Pemain 1
        add(new JLabel("Player 1:"));
        player1Field = new JTextField(username);
        player1Field.setEditable(false);
        add(player1Field);

        add(new JLabel("Serangan:"));
        batu1 = new JRadioButton("Batu");
        kertas1 = new JRadioButton("Kertas");
        gunting1 = new JRadioButton("Gunting");
        ButtonGroup group1 = new ButtonGroup();
        group1.add(batu1);
        group1.add(kertas1);
        group1.add(gunting1);
        JPanel panel1 = new JPanel();
        panel1.add(batu1);
        panel1.add(kertas1);
        panel1.add(gunting1);
        add(panel1);

        // Pemain 2
        add(new JLabel("Player 2:"));
        player2Field = new JTextField("Player 2");
        add(player2Field);

        add(new JLabel("Serangan:"));
        batu2 = new JRadioButton("Batu");
        kertas2 = new JRadioButton("Kertas");
        gunting2 = new JRadioButton("Gunting");
        ButtonGroup group2 = new ButtonGroup();
        group2.add(batu2);
        group2.add(kertas2);
        group2.add(gunting2);
        JPanel panel2 = new JPanel();
        panel2.add(batu2);
        panel2.add(kertas2);
        panel2.add(gunting2);
        add(panel2);

        // Tombol dan hasil
        battleButton = new JButton("Battle");
        resetButton = new JButton("Reset");
        logoutButton = new JButton("Logout");
        hasilLabel = new JLabel("Hasil: ");

        battleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pilihan1 = getSelectedButtonText(group1);
                String pilihan2 = getSelectedButtonText(group2);

                if (pilihan1 != null && pilihan2 != null) {
                    Player player1 = new Player(player1Field.getText(), pilihan1);
                    Player player2 = new Player(player2Field.getText(), pilihan2);
                    String hasil = GameLogic.determineWinner(player1, player2);
                    hasilLabel.setText("Hasil: " + hasil);
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih serangan untuk kedua pemain!");
                }
            }
        });

        resetButton.addActionListener(e -> hasilLabel.setText("Hasil: "));

        logoutButton.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        add(battleButton);
        add(resetButton);
        add(logoutButton);
        add(hasilLabel);

        setVisible(true);
    }

    private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (AbstractButton button : java.util.Collections.list(buttonGroup.getElements())) {
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}