import java.awt.*;
import javax.swing.*;

public class NilaiMahasiswa extends JFrame {

    MataKuliah[] matkuls = {new ASD(), new Pemlan(), new Matkomlan(), new Probstat()};
    boolean[] done = new boolean[4];

    JRadioButton[] radios  = new JRadioButton[4];
    JTextField[]   inputs  = new JTextField[4];
    JTextField     tfHasil = new JTextField();
    JTextArea      taRekap = new JTextArea(6, 20);

    String[] labelInput = {"Tugas :", "Kuis :", "UTS :", "UAS :"};

    public NilaiMahasiswa() {
        setTitle("Hitung Nilai Akhir dengan GUI...");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Hitung Nilai Akhir", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 6, 0));
        add(title, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridBagLayout());
        center.setBorder(BorderFactory.createEmptyBorder(4, 20, 4, 20));
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 4, 4, 4);
        g.fill   = GridBagConstraints.HORIZONTAL;

        // Radio buttons
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        ButtonGroup bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            radios[i] = new JRadioButton(matkuls[i].nama);
            bg.add(radios[i]);
            radioPanel.add(radios[i]);
            radios[i].addActionListener(e -> clearInputs());
        }
        radios[1].setSelected(true);
        g.gridx = 0; g.gridy = 0; g.gridwidth = 2;
        center.add(radioPanel, g);

        // Input fields
        g.gridwidth = 1;
        for (int i = 0; i < 4; i++) {
            inputs[i] = new JTextField(10);
            g.gridx = 0; g.gridy = i + 1; g.weightx = 0.3;
            center.add(new JLabel(labelInput[i]), g);
            g.gridx = 1; g.weightx = 0.7;
            center.add(inputs[i], g);
        }

        // Field Hasil 
        tfHasil.setEditable(false);
        tfHasil.setBackground(new Color(230, 230, 230));
        g.gridx = 0; g.gridy = 5; g.weightx = 0.3; g.gridwidth = 1;
        center.add(new JLabel("Hasil :"), g);
        g.gridx = 1; g.weightx = 0.7;
        center.add(tfHasil, g);

        // Tombol Hitung
        JButton btnHitung = new JButton("Hitung");
        btnHitung.addActionListener(e -> hitung());
        g.gridx = 0; g.gridy = 6; g.gridwidth = 2; g.weightx = 1;
        center.add(btnHitung, g);

        // TextArea rekap
        taRekap.setEditable(false);
        taRekap.setText("HASIL NILAI SEMUA MATA KULIAH");
        g.gridy = 7;
        center.add(new JScrollPane(taRekap), g);

        add(center, BorderLayout.CENTER);

        // Tombol Tampilkan
        JButton btnTampil = new JButton("Tampilkan nilai semua matkul");
        btnTampil.addActionListener(e -> tampil());
        JPanel south = new JPanel(new BorderLayout());
        south.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
        south.add(btnTampil);
        add(south, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    int selectedIdx() {
        for (int i = 0; i < 4; i++) if (radios[i].isSelected()) return i;
        return 0;
    }

    void clearInputs() {
        for (JTextField tf : inputs) tf.setText("");
        tfHasil.setText("");
    }

    void hitung() {
        try {
            double[] v = new double[4];
            for (int i = 0; i < 4; i++) {
                v[i] = Double.parseDouble(inputs[i].getText().trim());
                if (v[i] < 0 || v[i] > 100) throw new NumberFormatException();
            }
            int idx = selectedIdx();
            matkuls[idx].setNilai(v[0], v[1], v[2], v[3]);
            done[idx] = true;
            tfHasil.setText(String.valueOf(matkuls[idx].nilaiAkhir));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Isi semua nilai 0–100!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void tampil() {
        StringBuilder sb = new StringBuilder("HASIL NILAI SEMUA MATA KULIAH\n\n");
        for (int i = 0; i < 4; i++) {
            sb.append(String.format("%-12s : %.1f\n",
                matkuls[i].nama, done[i] ? matkuls[i].nilaiAkhir : 0.0));
        }
        taRekap.setText(sb.toString());
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
        SwingUtilities.invokeLater(() -> new NilaiMahasiswa().setVisible(true));
    }
}