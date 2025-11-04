package View;

import javax.swing.*;
import java.net.URL;

public class DisplayGIF extends JFrame {

    public DisplayGIF() {
        setTitle("Menampilkan GIF");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        URL gifUrl = getClass().getResource("/Image/fincare.gif");
        URL gifUrl2 = getClass().getResource("/Image/HOMEADMIN.gif");

        if (gifUrl != null) {
            ImageIcon gifIcon = new ImageIcon(gifUrl);

            JLabel gifLabel = new JLabel(gifIcon);

            add(gifLabel);

            setVisible(true);
        } if (gifUrl2 != null) {
            ImageIcon gifIcon = new ImageIcon(gifUrl2);

            JLabel gifLabel = new JLabel(gifIcon);

            add(gifLabel);

            setVisible(true); 
        } else {
            System.out.println("GIF tidak ditemukan!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DisplayGIF());
    }
}
