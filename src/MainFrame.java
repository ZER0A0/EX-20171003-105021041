import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    public MainFrame (){
        initComp();
    }
    private Container cp;
    private JButton JbtnA = new JButton("範例");
    private JButton JbtnB = new JButton("加密");
    private JButton JbtnC = new JButton("清除");
    private JButton JbtnE = new JButton("離開");
    private JLabel Jla = new JLabel("Key");
    private JTextField Jtf = new JTextField("1");
    private JPanel Jpa = new JPanel(new GridLayout(6,1,3,3));
    private JTextArea JtaL = new JTextArea();
    private JTextArea JtaR = new JTextArea();
    private JScrollPane JspL = new JScrollPane(JtaL);
    private JScrollPane JspR = new JScrollPane(JtaR);
    private void initComp(){
        this.setBounds(450,200,500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Jla.setHorizontalAlignment(JLabel.CENTER);
        JtaL.setPreferredSize(new Dimension(200,300));
        JtaR.setPreferredSize(new Dimension(200,300));
        JtaL.setLineWrap(true);
        JtaR.setLineWrap(true);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        Jpa.add(JbtnA);
        Jpa.add(JbtnB);
        Jpa.add(Jla);
        Jpa.add(Jtf);
        Jpa.add(JbtnC);
        Jpa.add(JbtnE);
        cp.add(JspL,BorderLayout.WEST);
        cp.add(JspR,BorderLayout.EAST);
        cp.add(Jpa,BorderLayout.CENTER);
        JbtnA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JtaL.setText("ABC1233211234567OAO");
            }
        });
        JbtnB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[] = JtaL.getText().toCharArray();
                int len = data.length , key = Integer.parseInt(Jtf.getText());
                for(int x = 0 ; x < len ; x ++){data[x] += key;}
                JtaR.setText(new String(data));
            }
        });
        JbtnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JtaL.setText("");
                JtaR.setText("");
            }
        });
        JbtnE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
