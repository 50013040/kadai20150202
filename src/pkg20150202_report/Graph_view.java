package pkg20150202_report;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author 50013040
 */
public class Graph_view extends Frame implements ActionListener, WindowListener, KeyListener {

    public Graph_view(int i) {
        String city;
        double av_temp, max_temp, min_temp,
                av_temp_av, max_temp_av, min_temp_av;

        ResultSet rs;
        MySQL mysql = new MySQL();
        rs = mysql.selectAll();

        addWindowListener(this);
        setTitle("2014/2/13");

        DefaultCategoryDataset data = new DefaultCategoryDataset();

        try {
            if (i == 0) {
                while (rs.next()) {
                    city = rs.getString("city");
                    av_temp = rs.getDouble("av_temp");
                    av_temp_av = rs.getDouble("av_temp_av");
                    data.addValue(av_temp, "Average Temperature", city);
                    data.addValue(av_temp_av, "Average Temperature(average of '30)", city);
                }
            } else if (i == 1) {
                while (rs.next()) {
                    city = rs.getString("city");
                    max_temp = rs.getDouble("max_temp");
                    max_temp_av = rs.getDouble("max_temp_av");
                    data.addValue(max_temp, "Maximum Temperature", city);
                    data.addValue(max_temp_av, "Maximum Temperature(average of '30)", city);
                }
            } else if (i == 2) {
                while (rs.next()) {
                    city = rs.getString("city");
                    min_temp = rs.getDouble("min_temp");
                    min_temp_av = rs.getDouble("min_temp_av");
                    data.addValue(min_temp, "Minimum Temperature", city);
                    data.addValue(min_temp_av, "Minimum Temperature(average of '30)", city);
                }
            } else if (i == 3) {
                while (rs.next()) {
                    city = rs.getString("city");
                    av_temp = rs.getDouble("av_temp");
                    max_temp = rs.getDouble("max_temp");
                    min_temp = rs.getDouble("min_temp");
                    data.addValue(av_temp, "Average Temperature", city);
                    data.addValue(max_temp, "Maximum Temperature", city);
                    data.addValue(min_temp, "Minimum Temperature", city);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFreeChart chart
                = ChartFactory.createLineChart(
                        "Temperature in major cities",
                        "City",
                        "Temperature",
                        data,
                        PlotOrientation.VERTICAL,
                        true,
                        false,
                        false);

        ChartPanel cpanel = new ChartPanel(chart);
        add(cpanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
