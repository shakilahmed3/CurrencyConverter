
package currencyconverter;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Shakil
 */
public class CurrencyConverter  extends JFrame implements ActionListener{
    
    private Container container;
    private JLabel title;
    private Font font, font2;
    private JComboBox box;
    private JTextField get;
    private JTextArea area;
    private JScrollPane pane;
    private JButton  Convert, Clear;
    
    private final String[] money = {"BD TO USD", "USD TO BD", "BD TO EURO", "EURO TO BD", "EURO TO USD", "USD TO EURO", "POUND TO EURO", "POUND TO USD", "POUND TO BD", "POUND TO CAD", "BD TO POUND", "USD TO POUND"};

    
    CurrencyConverter(){
        this.setBounds(300, 200, 500, 400);
        this.setTitle("Currency Converter");
        initComponenets();
    }

    public void initComponenets(){
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.DARK_GRAY);
        
        //Create  Font Style
        font = new Font("Arial", Font.BOLD,47);
        font2 = new Font("Arial", Font.BOLD, 24);
        
        
        //Title Create in Currency converter
        title = new JLabel("Currency Converter");
        title.setBounds(0,0,500,80);
        title.setOpaque(true);
        title.setBackground(Color.LIGHT_GRAY);
        title.setForeground(Color.DARK_GRAY);
        title.setFont(font);
        title.setHorizontalAlignment(JLabel.CENTER);
        container.add(title);
        
        //Create JCombobox
        box = new JComboBox(money);
        box.setBounds(25,110,200,50);
        box.setEditable(true);
        box.setFont(font2);
        container.add(box);
        
        //Create JText Field
        get = new JTextField();
        get.setBounds(25,180,200,50);
        get.setFont(font2);
        container.add(get);
        
        //Create Text Area
        area = new JTextArea();
        area.setFont(font2);
        area.setBackground(Color.LIGHT_GRAY);
        area.setForeground(Color.DARK_GRAY);
        area.setEditable(false);
        
        //Create JScrollPane
        pane = new JScrollPane(area);
        pane.setBounds(245,110,220,120);
        container.add(pane);
        
        //Create button option
        
        Convert = new JButton("Convert");
        Convert.setBounds(20,260,220,50);
        Convert.setFont(font2);
        Convert.setBackground(Color.LIGHT_GRAY);
        Convert.setForeground(Color.DARK_GRAY);
        container.add(Convert);
        
        
        Clear = new JButton("Clear");
        Clear.setBounds(245,260,220,50);
        Clear.setFont(font2);
        Clear.setBackground(Color.LIGHT_GRAY);
        Clear.setForeground(Color.DARK_GRAY);
        container.add(Clear);
        
        Convert.addActionListener(this);
        Clear.addActionListener(this);
        get.addActionListener(this);
        
    }
    
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Convert)
        {
            try{
                SetCalculation();
            }
            catch(Exception excep)
            {
                JOptionPane.showMessageDialog(null, excep+"Try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource()==get)
        {
            try{
                SetCalculation();
            }
            catch(Exception excep)
            {
                JOptionPane.showMessageDialog(null, excep+"Try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource()==Clear)
        {
            area.setText("");
            get.setText("");
        }
        
    }
    
    
    public void SetCalculation(){
        
        String s = box.getSelectedItem().toString();
        DecimalFormat formate = new DecimalFormat("0.0000");
        
        String d = get.getText();
        
        if(d.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Enter Any Number", "Error", JOptionPane.ERROR_MESSAGE);
            
        }else{
            if(s==money[0])
            {
                double BD = Double.valueOf(get.getText());
                
                double USD = BD * 0.01173;
                String output = String.valueOf(formate.format(USD));
                this.area.setText("$"+output);
            }
            else if(s==money[1])
            {
                double USD = Double.valueOf(get.getText());
                
                double BD = USD / 0.01173;
                String output = String.valueOf(formate.format(BD));
                this.area.setText(output+"Tk");
            }
            else if(s==money[2])
            {
                double BD = Double.valueOf(get.getText());
                
                double Euro = BD * 0.01042;
                String output = String.valueOf(formate.format(Euro));
                this.area.setText(output+"Euro");
            }
            else if(s==money[3])
            {
                double Euro = Double.valueOf(get.getText());
                
                double BD = Euro / 0.01042;
                String output = String.valueOf(formate.format(BD));
                this.area.setText(output+"Tk");
            }
            else if(s==money[4])
            {
                double Euro = Double.valueOf(get.getText());
                
                double USD = Euro * 1.12497;
                String output = String.valueOf(formate.format(USD));
                this.area.setText("$"+output);
            }
            else if(s==money[5])
            {
                double USD = Double.valueOf(get.getText());
                
                double Euro = USD / 1.12497;
                String output = String.valueOf(formate.format(Euro));
                this.area.setText(output+"Euro");
            }
            else if(s==money[6])
            {
                double pound = Double.valueOf(get.getText());
                
                double Euro = pound * 1.15427;
                String output = String.valueOf(formate.format(Euro));
                this.area.setText(output+"Euro");
            }
            else if(s==money[7])
            {
                double pound = Double.valueOf(get.getText());
                
                double USD = pound * 1.29564;
                String output = String.valueOf(formate.format(USD));
                this.area.setText("$"+output);
            }
            else if(s==money[8])
            {
                double pound = Double.valueOf(get.getText());
                
                double BD = pound * 108.342;
                String output = String.valueOf(formate.format(BD));
                this.area.setText(output+"Tk");
            }
            else if(s==money[9])
            {
                double pound = Double.valueOf(get.getText());
                
                double CAD = pound * 1.73454;
                String output = String.valueOf(formate.format(CAD));
                this.area.setText(output+"CAD");
            }
            else if(s==money[10])
            {
                double BD = Double.valueOf(get.getText());
                
                double pound = BD * 0.00903;
                String output = String.valueOf(formate.format(pound));
                this.area.setText(output+"GBP");
            }
            else if(s==money[11])
            {
                double USD = Double.valueOf(get.getText());
                
                double pound = USD * 0.76991;
                String output = String.valueOf(formate.format(pound));
                this.area.setText(output+"GBP");
            }
        }
        
    }
        
    
    public static void main(String[] args) {

        CurrencyConverter converter = new CurrencyConverter();
        converter.setVisible(true);
        converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

   
    
}
