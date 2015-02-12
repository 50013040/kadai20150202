package pkg20150202_report;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 50013040
 */
public class FrameRenderer extends Frame implements ActionListener, WindowListener {

    private Button b_av = new Button("Average");
    private Button b_max = new Button("Maximum");
    private Button b_min = new Button("Minimum");
    private Button b_all = new Button("All");

    public FrameRenderer() {
        String city;
        double av_temp, max_temp, min_temp;

        ResultSet rs;
        MySQL mysql = new MySQL();
        rs = mysql.selectAll();

        addWindowListener(this);
        setTitle("Temperature at 2014/2/13");
        setLayout(new FlowLayout(FlowLayout.CENTER));

        add(new Label("Temperature in major cities of 2014/2/13."));
        try {
            while (rs.next()) {
                city = rs.getString("city");
                av_temp = rs.getDouble("av_temp");
                max_temp = rs.getDouble("max_temp");
                min_temp = rs.getDouble("min_temp");
                add(new Label(city));               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        add(b_av);
        add(b_max);
        add(b_min);
        add(b_all);
        b_av.addActionListener(this);
        b_max.addActionListener(this);
        b_min.addActionListener(this);
        b_all.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e
    ) {
        int i = 0;
        if (e.getSource() == b_av) {
            i = 0;
        } else if (e.getSource() == b_max) {
            i = 1;
        } else if (e.getSource() == b_min) {
            i = 2;
        } else if (e.getSource() == b_all) {
            i = 3;
        }
        Graph_view graph = new Graph_view(i);
        graph.setBounds(5, 5, 655, 455);
        graph.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e
    ) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
