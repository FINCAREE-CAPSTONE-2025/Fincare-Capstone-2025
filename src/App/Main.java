package App;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final String HOMEE_FORM_CLASS = "View.HOMEE";

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo i : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(i.getName())) { UIManager.setLookAndFeel(i.getClassName()); break; }
            }
        } catch (Exception ignored) {}

        Runtime.getRuntime().addShutdownHook(new Thread(JPAProvider::shutdown, "JPA-Shutdown"));

        new Thread(() -> {
            try {
                JPAProvider.getFactory();
                EventQueue.invokeLater(Main::openHome);
            } catch (Throwable t) {
                EventQueue.invokeLater(() -> JOptionPane.showMessageDialog(
                    null, "Gagal inisialisasi JPA (MariaDB):\n" + t, "Error", JOptionPane.ERROR_MESSAGE));
            }
        }, "JPA-Init").start();
    }

    private static void openHome() {
        try {
            Class<?> c = Class.forName(HOMEE_FORM_CLASS);
            Object o = c.getDeclaredConstructor().newInstance();
            if (o instanceof Window win) {
                if (win instanceof JFrame f) f.setLocationRelativeTo(null);
                win.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Kelas awal bukan turunan java.awt.Window");
            }
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, "Gagal muat GUI:\n" + t, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
