import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Dashboard extends JFrame {
    public Dashboard(){
        setTitle("Dashboard");
        setSize(600,400);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(4,2));

        inputPanel.add(new JLabel("Name"));
        JTextField nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("NIM"));
        JTextField nimField = new JTextField();
        inputPanel.add(nimField);

        inputPanel.add(new JLabel("Major"));
        JTextField majorField = new JTextField();
        inputPanel.add(majorField);

        JButton addButton = new JButton ("add student");
        inputPanel.add(addButton);

        JButton deleteButton = new JButton ("delete student");
        inputPanel.add(deleteButton);

        String[] column = {"Nama", "NIM", "Major"};
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);


        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane,BorderLayout.CENTER);

        addButton.addActionListener( e -> {
            String name= nameField.getText();
            String nim= nimField.getText();
            String major= majorField.getText();

            tableModel.addRow(new Object[]{name,nim,major});
            nameField.setText("");
            nimField.setText("");
            majorField.setText("");
        });
        deleteButton.addActionListener(e ->{
            int selectedRow= table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            }
            else{
                JOptionPane.showMessageDialog(this,"please select row first"
                );
            }
        });
    }
}
