import java.awt.*;
import javax.swing.*;

public class Formdaftarulang extends JFrame {

    // Field input
    private JTextField tfNama, tfTanggal, tfNoPendaftaran, tfNoTelp, tfEmail;
    private JTextArea  taAlamat;

    public Formdaftarulang() {
        setTitle("Form Daftar Ulang Mahasiswa Baru");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        buildUI();
        pack();
        setLocationRelativeTo(null);
    }

    private void buildUI() {
        // Panel utama dengan padding
        JPanel main = new JPanel(new BorderLayout(0, 16));
        main.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        main.setBackground(new Color(245, 247, 250));

        // ── Header ──
        JLabel lblJudul = new JLabel("FORMULIR DAFTAR ULANG MAHASISWA BARU", SwingConstants.CENTER);
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblJudul.setForeground(new Color(30, 60, 120));
        lblJudul.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));

        JLabel lblSub = new JLabel("Universitas Brawijaya  •  Tahun Akademik 2025/2026", SwingConstants.CENTER);
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblSub.setForeground(Color.GRAY);

        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 0, 2));
        headerPanel.setBackground(new Color(245, 247, 250));
        headerPanel.add(lblJudul);
        headerPanel.add(lblSub);
        main.add(headerPanel, BorderLayout.NORTH);

        // ── Form panel ──
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(Color.WHITE);
        form.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 210, 230), 1),
            BorderFactory.createEmptyBorder(20, 24, 20, 24)
        ));

        GridBagConstraints g = new GridBagConstraints();
        g.insets  = new Insets(7, 6, 7, 6);
        g.anchor  = GridBagConstraints.WEST;
        g.fill    = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("SansSerif", Font.PLAIN, 12);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 12);
        Dimension fieldSize = new Dimension(280, 28);

        // Nama Lengkap
        tfNama = new JTextField(); tfNama.setPreferredSize(fieldSize); tfNama.setFont(fieldFont);
        addRow(form, g, 0, "Nama Lengkap", tfNama, labelFont);

        // Tanggal Lahir
        tfTanggal = new JTextField(); tfTanggal.setPreferredSize(fieldSize); tfTanggal.setFont(fieldFont);
        tfTanggal.setToolTipText("Contoh: 3 Juli 2000");
        addRow(form, g, 1, "Tanggal Lahir", tfTanggal, labelFont);

        // Nomor Pendaftaran
        tfNoPendaftaran = new JTextField(); tfNoPendaftaran.setPreferredSize(fieldSize); tfNoPendaftaran.setFont(fieldFont);
        addRow(form, g, 2, "Nomor Pendaftaran", tfNoPendaftaran, labelFont);

        // No. Telp
        tfNoTelp = new JTextField(); tfNoTelp.setPreferredSize(fieldSize); tfNoTelp.setFont(fieldFont);
        addRow(form, g, 3, "No. Telp", tfNoTelp, labelFont);

        // Alamat (TextArea)
        taAlamat = new JTextArea(3, 20);
        taAlamat.setFont(fieldFont);
        taAlamat.setLineWrap(true);
        taAlamat.setWrapStyleWord(true);
        taAlamat.setBorder(BorderFactory.createLineBorder(new Color(180, 190, 210)));
        JScrollPane scrollAlamat = new JScrollPane(taAlamat);
        scrollAlamat.setPreferredSize(new Dimension(280, 60));
        scrollAlamat.setBorder(BorderFactory.createEmptyBorder());
        addRow(form, g, 4, "Alamat", scrollAlamat, labelFont);

        // Email
        tfEmail = new JTextField(); tfEmail.setPreferredSize(fieldSize); tfEmail.setFont(fieldFont);
        addRow(form, g, 5, "E-mail", tfEmail, labelFont);

        // Tombol Submit
        JButton btnSubmit = new JButton("  Submit  ");
        btnSubmit.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnSubmit.setBackground(new Color(30, 80, 180));
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setFocusPainted(false);
        btnSubmit.setBorderPainted(false);
        btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(e -> onSubmit());

        g.gridx = 1; g.gridy = 6; g.anchor = GridBagConstraints.EAST; g.fill = GridBagConstraints.NONE;
        g.insets = new Insets(14, 6, 4, 6);
        form.add(btnSubmit, g);

        main.add(form, BorderLayout.CENTER);

        // Footer
        JLabel footer = new JLabel("* Pastikan semua data yang diisi sudah benar sebelum submit", SwingConstants.CENTER);
        footer.setFont(new Font("SansSerif", Font.ITALIC, 10));
        footer.setForeground(Color.GRAY);
        main.add(footer, BorderLayout.SOUTH);

        add(main);
    }

    // Helper: tambah baris label + field ke form
    private void addRow(JPanel form, GridBagConstraints g, int row, String label, JComponent field, Font lf) {
        g.gridx = 0; g.gridy = row; g.weightx = 0; g.fill = GridBagConstraints.NONE;
        g.anchor = GridBagConstraints.NORTHWEST; g.insets = new Insets(9, 6, 7, 12);
        JLabel lbl = new JLabel(label);
        lbl.setFont(lf);
        lbl.setForeground(new Color(50, 60, 80));
        form.add(lbl, g);

        g.gridx = 1; g.weightx = 1; g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.WEST; g.insets = new Insets(7, 6, 7, 6);
        form.add(field, g);
    }

    // Validasi semua field terisi
    private boolean validasi() {
        if (tfNama.getText().trim().isEmpty()         ||
            tfTanggal.getText().trim().isEmpty()      ||
            tfNoPendaftaran.getText().trim().isEmpty() ||
            tfNoTelp.getText().trim().isEmpty()       ||
            taAlamat.getText().trim().isEmpty()       ||
            tfEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    // Klik Submit
    private void onSubmit() {
        if (!validasi()) return;

        int pilihan = JOptionPane.showConfirmDialog(this,
            "Apakah anda yakin data yang Anda isi sudah benar?",
            "Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (pilihan == JOptionPane.OK_OPTION) {
            tampilkanHasil();
        }
        // jika Cancel: otomatis kembali ke form (tidak ada aksi tambahan)
    }

    // Jendela baru yang menampilkan data mahasiswa
    private void tampilkanHasil() {
        JFrame hasil = new JFrame("Data Mahasiswa");
        hasil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hasil.setResizable(false);

        JPanel panel = new JPanel(new BorderLayout(0, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(16, 20, 16, 20));
        panel.setBackground(Color.WHITE);

        JLabel lblJudul = new JLabel("Data Mahasiswa", SwingConstants.CENTER);
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblJudul.setForeground(new Color(30, 60, 120));
        panel.add(lblJudul, BorderLayout.NORTH);

        // TextArea untuk menampilkan data
        JTextArea ta = new JTextArea();
        ta.setEditable(false);
        ta.setFont(new Font("Monospaced", Font.PLAIN, 12));
        ta.setBackground(new Color(245, 247, 252));
        ta.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        ta.setText(
            String.format("%-18s: %s%n", "Nama",            tfNama.getText().trim())         +
            String.format("%-18s: %s%n", "Tanggal Lahir",   tfTanggal.getText().trim())      +
            String.format("%-18s: %s%n", "No.Pendaftaran",  tfNoPendaftaran.getText().trim())+
            String.format("%-18s: %s%n", "No.Telp",         tfNoTelp.getText().trim())       +
            String.format("%-18s: %s%n", "Alamat",          taAlamat.getText().trim())       +
            String.format("%-18s: %s%n", "E-mail",          tfEmail.getText().trim())
        );

        JScrollPane scroll = new JScrollPane(ta);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(200, 210, 230)));
        scroll.setPreferredSize(new Dimension(360, 160));
        panel.add(scroll, BorderLayout.CENTER);

        JButton btnTutup = new JButton("Tutup");
        btnTutup.setFont(new Font("SansSerif", Font.PLAIN, 11));
        btnTutup.addActionListener(e -> hasil.dispose());
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.setBackground(Color.WHITE);
        btnPanel.add(btnTutup);
        panel.add(btnPanel, BorderLayout.SOUTH);

        hasil.add(panel);
        hasil.pack();
        hasil.setLocationRelativeTo(this);
        hasil.setVisible(true);
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
        SwingUtilities.invokeLater(() -> new Formdaftarulang().setVisible(true));
    }
}