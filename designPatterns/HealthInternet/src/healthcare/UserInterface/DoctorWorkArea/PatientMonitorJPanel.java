/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.UserInterface.DoctorWorkArea;

import static healthcare.Department.DepartmentType.Patient;
import healthcare.Department.PatientDepartment;
import healthcare.Encounter.Encounter;
import healthcare.Patient.Patient;
import healthcare.Person.Person;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author Muddassar
 */
public class PatientMonitorJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private PatientDepartment patientDepartment;
    /**
     * Creates new form PatientMonitorJPanel
     */
    public PatientMonitorJPanel(JPanel upc,PatientDepartment patientDept) {
        initComponents();
        this.userProcessContainer = upc;
        this.patientDepartment = patientDept;
        this.buildChart();
    }
    
    
    private HashMap<String,Integer> patientsByChiefComplaint()
    {
        HashMap<String,Integer> result = new HashMap<>();
        
        for(Person person : this.patientDepartment.getPersonDirectory().getPersonList())
        {
            if(person instanceof Patient)
            {
                Patient patient = (Patient)person;
                
                for(Encounter encounter : patient.getEncounterHistory().getEncounterList())
                {
                    if(encounter.getChiefComplaint() != null)
                    {
                        if(!result.containsKey(encounter.getChiefComplaint()))
                        {
                            result.put(encounter.getChiefComplaint(), 1);
                        }
                        else
                        {
                            int newValue = result.get(encounter.getChiefComplaint()).intValue() + 1;
                            result.put(encounter.getChiefComplaint(), newValue);
                        }
                    }
                }
                
            }
        }
            
            return result;
    }
    
    private void buildChart(){
        this.pnlPatientComplaintChart.removeAll();
        
        CategoryDataset ds = this.createDataset(this.patientsByChiefComplaint());
        if(ds!=null)
        {
            ChartPanel chartPanel = new ChartPanel(this.createChart1(ds));
            if(chartPanel != null)
            {
                chartPanel.setSize(400, 400);
                //chartPanel.setSize(this.pnlPatientComplaintChart.getSize());
                chartPanel.setVisible(true);
                this.pnlPatientComplaintChart.add(chartPanel);
                this.pnlPatientComplaintChart.repaint();
                
            }
        }
    }
    
     private CategoryDataset createDataset(HashMap<String,Integer> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        
        for(Entry<String,Integer> key : data.entrySet())
        {
            dataset.addValue(key.getValue(),key.getKey(),"Chief Complaint");
        }
        
        return dataset;
         
         
                
    }
    
    private static JFreeChart createChart(CategoryDataset dataset) {
        
          // create the chart...
          JFreeChart chart = ChartFactory.createBarChart(
              "Patient Statistics",       // chart title
              "Cases",               // domain axis label
              "Value",                  // range axis label
              dataset,                  // data
              PlotOrientation.VERTICAL, // orientation
              true,                     // include legend
              true,                     // tooltips?
              false                     // URLs?
          );
  
          // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
  
          // set the background color for the chart...
          chart.setBackgroundPaint(Color.white);
  
          // get a reference to the plot for further customisation...
          CategoryPlot plot = (CategoryPlot) chart.getPlot();
          plot.setBackgroundPaint(Color.lightGray);
          plot.setDomainGridlinePaint(Color.white);
          plot.setDomainGridlinesVisible(true);
          plot.setRangeGridlinePaint(Color.white);
  
          // ******************************************************************
          //  More than 150 demo applications are included with the JFreeChart
          //  Developer Guide...for more information, see:
          //
          //  >   http://www.object-refinery.com/jfreechart/guide.html
          //
          // ******************************************************************
          
          // set the range axis to display integers only...
          final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
          rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
  
          // disable bar outlines...
          BarRenderer renderer = (BarRenderer) plot.getRenderer();
          renderer.setDrawBarOutline(false);
          
          // set up gradient paints for series...
          GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.blue, 
                  0.0f, 0.0f, new Color(0, 0, 64));
          GradientPaint gp1 = new GradientPaint(0.0f, 0.0f, Color.green, 
                  0.0f, 0.0f, new Color(0, 64, 0));
          GradientPaint gp2 = new GradientPaint(0.0f, 0.0f, Color.red, 
                  0.0f, 0.0f, new Color(64, 0, 0));
          renderer.setSeriesPaint(0, gp0);
          renderer.setSeriesPaint(1, gp1);
          renderer.setSeriesPaint(2, gp2);
  
          CategoryAxis domainAxis = plot.getDomainAxis();
          domainAxis.setCategoryLabelPositions(
                  CategoryLabelPositions.createUpRotationLabelPositions(
                          Math.PI / 6.0));
          // OPTIONAL CUSTOMISATION COMPLETED.
          
          return chart;
          
      }
    
    private static JFreeChart createChart1(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
            "Chief Complaint Statistics", null /* x-axis label*/, 
                "Number of Encounters" /* y-axis label */, dataset);
        chart.addSubtitle(new TextTitle("Total number of encounters grouped by Chief Complaint"));
        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        // ******************************************************************
        //  More than 150 demo applications are included with the JFreeChart
        //  Developer Guide...for more information, see:
        //
        //  >   http://www.object-refinery.com/jfreechart/guide.html
        //
        // ******************************************************************

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        chart.getLegend().setFrame(BlockBorder.NONE);
        return chart;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPatientComplaintChart = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPatientComplaintChart.setLayout(new java.awt.BorderLayout());
        add(pnlPatientComplaintChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 530, 370));

        jLabel1.setText("Patient Statistics");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jLabel2.setText("Chart");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnlPatientComplaintChart;
    // End of variables declaration//GEN-END:variables
}
