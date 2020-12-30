import ic.util.Cleric;
import ic.util.Bard;
import ic.util.Constants;
import java.awt.AWTException;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;  // Using Frame class in package java.awt
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;

public class NewJFrame extends JFrame {
    static final int INIT = 70;    //initial frames per second
    public static int sliderval;
    public static boolean isON;
    JButton b1,b2,b3;  
    public static LinkedList<String> stream = new LinkedList<>();
    LinkedList<JRadioButton> radioButtons = new LinkedList<>();
    LinkedList<JPanel> panels = new LinkedList<>();
    //Create a file chooser
    final JFileChooser fc = new JFileChooser();
    private CardLayout card;  
    //In response to a button click
    private JPanel jPanelBlank = new JPanel();
    //private JPanel jPanelCLR = new JPanel();
    //private JTextField jTextOrder = new JTextField();

     
    //private JCheckBox jrCHAIN, jrLHEAL, jCheckSIT;
    
    public NewJFrame() {
        this.sliderval = INIT;
        this.isON = false;
        fc.setCurrentDirectory(new File("D:\\Games\\p99\\EQLITE\\Logs"));
        initComponents();
        //initCustomComponents();
        
        radioButtons.add(jrLeuke);
        radioButtons.add(jrMorley);
        radioButtons.add(jrSeike);
        radioButtons.add(jrSaax);

        panels.add(jPanel);
        //container=getContentPane();
        card=new CardLayout(150,150);  
        card.setHgap(4);
        card.setVgap(4);
        
        
        
        //create CardLayout object with 40 hor space and 30 ver space  
        jPanel.setLayout(card);
        jPanel.add(jPanelCLR,"CLR");
        jPanel.add(jPanelNEC,"NEC");
        jPanel.add(jPanelBlank,"BLANK");
        jPanel.add(jPanelBRD,"BRD");
        card.show(jPanel, "BLANK");
        

    }
    
    private void initCustomComponents() {
        javax.swing.GroupLayout jPanelCLRLayout = new javax.swing.GroupLayout(jPanelCLR);
        jPanelCLR.setLayout(jPanelCLRLayout);
        jPanelCLRLayout.setHorizontalGroup(
            jPanelCLRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCLRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCLRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelCLRLayout.createSequentialGroup()
                        .addComponent(jrLHEAL)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckSIT))
                    .addGroup(jPanelCLRLayout.createSequentialGroup()
                        .addComponent(jrCHAIN)
                        .addGap(18, 18, 18)
                        .addComponent(jTextOrder)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanelCLRLayout.setVerticalGroup(
            jPanelCLRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCLRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCLRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrLHEAL)
                    .addComponent(jCheckSIT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCLRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrCHAIN)
                    .addComponent(jTextOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jFileChooser1 = new javax.swing.JFileChooser();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 3), new java.awt.Dimension(0, 3), new java.awt.Dimension(32767, 3));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        jPanel5 = new javax.swing.JPanel();
        jrMorley = new javax.swing.JRadioButton();
        jrLeuke = new javax.swing.JRadioButton();
        jrSeike = new javax.swing.JRadioButton();
        jrSaax = new javax.swing.JRadioButton();
        jPanel = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jTextLocation1 = new javax.swing.JTextField();
        jtbLocate1 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jTextField = new javax.swing.JTextField();
        jbOpen1 = new javax.swing.JButton();
        jbCapture = new javax.swing.JButton();
        log = new java.awt.TextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel10 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jPanelCLR = new javax.swing.JPanel();
        jrLHEAL = new javax.swing.JCheckBox();
        jrCHAIN = new javax.swing.JCheckBox();
        jCheckSIT = new javax.swing.JCheckBox();
        jTextOrder = new javax.swing.JTextField();
        jSlowed = new javax.swing.JCheckBox();
        jPanelNEC = new javax.swing.JPanel();
        jCheckSIT1 = new javax.swing.JCheckBox();
        jPanelBRD = new javax.swing.JPanel();
        jrKITE = new javax.swing.JCheckBox();

        jTextField1.setText("jTextField1");

        jScrollPane1.setViewportView(jTree1);

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 153));
        setLocation(new java.awt.Point(1300, 200));
        setPreferredSize(new java.awt.Dimension(470, 626));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(0, 0, 51));
        jPanel1.setFocusable(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 405));

        jTabbedPane2.setBackground(new java.awt.Color(255, 204, 204));
        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane2.setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setForeground(new java.awt.Color(255, 255, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));

        jPanel5.setBackground(Constants.colorNOTSELECTED);
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jrMorley.setBackground(Constants.colorNOTSELECTED);
        jrMorley.setForeground(new java.awt.Color(0, 0, 0));
        jrMorley.setText("Morley");
        jrMorley.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jrMorley.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMorleyActionPerformed(evt);
            }
        });

        jrLeuke.setBackground(Constants.colorNOTSELECTED);
        jrLeuke.setForeground(new java.awt.Color(0, 0, 0));
        jrLeuke.setText("Leuke");
        jrLeuke.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jrLeuke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrLeukeActionPerformed(evt);
            }
        });

        jrSeike.setBackground(Constants.colorNOTSELECTED);
        jrSeike.setForeground(new java.awt.Color(0, 0, 0));
        jrSeike.setText("Seike");
        jrSeike.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jrSeike.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jrSeikeStateChanged(evt);
            }
        });
        jrSeike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrSeikeActionPerformed(evt);
            }
        });

        jrSaax.setBackground(Constants.colorNOTSELECTED);
        jrSaax.setForeground(new java.awt.Color(0, 0, 0));
        jrSaax.setText("Saax");
        jrSaax.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jrSaax.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jrSaaxStateChanged(evt);
            }
        });
        jrSaax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrSaaxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jrMorley, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
            .addComponent(jrSeike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jrLeuke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jrSaax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jrMorley)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrSeike)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrLeuke)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrSaax)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jPanel.setBackground(Constants.colorNOTSELECTED);
        jPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane2.addTab("CHARACTER", jPanel3);

        jPanel4.setForeground(new java.awt.Color(65, 65, 65));

        jPanel6.setBackground(new java.awt.Color(60, 60, 60));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setForeground(new java.awt.Color(255, 102, 255));

        jTextLocation1.setBackground(new java.awt.Color(255, 255, 255));
        jTextLocation1.setForeground(new java.awt.Color(51, 51, 51));
        jTextLocation1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextLocation1MouseClicked(evt);
            }
        });

        jtbLocate1.setText("OFF");
        jtbLocate1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jtbLocate1StateChanged(evt);
            }
        });
        jtbLocate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbLocate1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("AUTO LOCATE");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jtbLocate1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtbLocate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("LOCATE", jPanel4);

        jPanel7.setForeground(new java.awt.Color(51, 51, 51));

        jPanel8.setBackground(new java.awt.Color(60, 60, 60));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setForeground(new java.awt.Color(255, 102, 255));

        jTextField.setBackground(new java.awt.Color(255, 255, 255));
        jTextField.setForeground(new java.awt.Color(51, 51, 51));
        jTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldMouseClicked(evt);
            }
        });

        jbOpen1.setText("...");
        jbOpen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOpen1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbOpen1))
                .addContainerGap())
        );

        jbCapture.setText("CAPTURE");
        jbCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCaptureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCapture)
                .addGap(141, 141, 141))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jbCapture)
                .addGap(69, 69, 69))
        );

        jTabbedPane2.addTab("OPEN", jPanel7);

        log.setBackground(new java.awt.Color(0, 0, 0));
        log.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        log.setForeground(new java.awt.Color(255, 255, 255));

        jTextPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTextPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null));
        jTextPane1.setForeground(new java.awt.Color(255, 255, 204));
        jScrollPane2.setViewportView(jTextPane1);

        jPanel10.setBackground(Constants.colorNOTSELECTED);
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSlider1.setBackground(Constants.colorNOTSELECTED);
        jSlider1.setForeground(new java.awt.Color(0, 0, 0));
        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMinorTickSpacing(5);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(70);
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(log, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)))
        );

        jPanelCLR.setBackground(Constants.colorNOTSELECTED);

        jrLHEAL.setBackground(Constants.colorNOTSELECTED);
        jrLHEAL.setForeground(new java.awt.Color(0, 0, 0));
        jrLHEAL.setText("LHEAL");
        jrLHEAL.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jrLHEAL.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jrLHEALStateChanged(evt);
            }
        });
        jrLHEAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrLHEALActionPerformed(evt);
            }
        });

        jrCHAIN.setBackground(Constants.colorNOTSELECTED);
        jrCHAIN.setForeground(new java.awt.Color(0, 0, 0));
        jrCHAIN.setText("CHAIN");
        jrCHAIN.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jrCHAIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrCHAINActionPerformed(evt);
            }
        });

        jCheckSIT.setBackground(Constants.colorNOTSELECTED);
        jCheckSIT.setForeground(new java.awt.Color(0, 0, 0));
        jCheckSIT.setSelected(true);
        jCheckSIT.setText("SIT");
        jCheckSIT.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckSIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckSITActionPerformed(evt);
            }
        });

        jTextOrder.setText("111");
        jTextOrder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextOrder.setSelectionStart(5);

        jSlowed.setText("SLOW");
        jSlowed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlowedStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelCLRLayout = new javax.swing.GroupLayout(jPanelCLR);
        jPanelCLR.setLayout(jPanelCLRLayout);
        jPanelCLRLayout.setHorizontalGroup(
            jPanelCLRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCLRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCLRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCLRLayout.createSequentialGroup()
                        .addComponent(jrLHEAL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jCheckSIT))
                    .addGroup(jPanelCLRLayout.createSequentialGroup()
                        .addGroup(jPanelCLRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCLRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jrCHAIN))
                            .addComponent(jSlowed))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelCLRLayout.setVerticalGroup(
            jPanelCLRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCLRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCLRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckSIT)
                    .addComponent(jrLHEAL))
                .addGap(42, 42, 42)
                .addComponent(jrCHAIN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSlowed)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jPanelNEC.setBackground(Constants.colorNOTSELECTED);
        jPanelNEC.setPreferredSize(new java.awt.Dimension(146, 238));

        jCheckSIT1.setBackground(Constants.colorNOTSELECTED);
        jCheckSIT1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckSIT1.setSelected(true);
        jCheckSIT1.setText("SIT");
        jCheckSIT1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckSIT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckSIT1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNECLayout = new javax.swing.GroupLayout(jPanelNEC);
        jPanelNEC.setLayout(jPanelNECLayout);
        jPanelNECLayout.setHorizontalGroup(
            jPanelNECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNECLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jCheckSIT1)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanelNECLayout.setVerticalGroup(
            jPanelNECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNECLayout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addComponent(jCheckSIT1)
                .addGap(35, 35, 35))
        );

        jPanelBRD.setBackground(Constants.colorNOTSELECTED);

        jrKITE.setBackground(Constants.colorNOTSELECTED);
        jrKITE.setForeground(new java.awt.Color(0, 0, 0));
        jrKITE.setText("KITE");
        jrKITE.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jrKITE.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jrKITEStateChanged(evt);
            }
        });
        jrKITE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrKITEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBRDLayout = new javax.swing.GroupLayout(jPanelBRD);
        jPanelBRD.setLayout(jPanelBRDLayout);
        jPanelBRDLayout.setHorizontalGroup(
            jPanelBRDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBRDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrKITE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanelBRDLayout.setVerticalGroup(
            jPanelBRDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBRDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrKITE)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelCLR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanelNEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelBRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCLR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelNEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jPanelBRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbOpen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOpen1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbOpen1ActionPerformed

    private void jTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMouseClicked

    private void jtbLocate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbLocate1ActionPerformed
        // TODO add your handling code here:
        Boolean selected = jtbLocate1.isSelected();
        Boolean empty = jTextLocation1.getText().isEmpty();

        if((selected && empty) || !selected) {
            jtbLocate1.setText("OFF");
            Constants.bSeek = false;
            
            if (empty) {
                setTextArea("location field empty!!");
            }
        }
        
        if (selected && !empty) {
            jtbLocate1.setText("ON");
            Constants.location = jTextLocation1.getText().split(",(\\s)?");
                    log.append("Location: " + 
                            Constants.location[0] + ", " 
                            + Constants.location[1] + "\n");
            Constants.bSeek = true;
        }
        
    }//GEN-LAST:event_jtbLocate1ActionPerformed

    private void jtbLocate1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jtbLocate1StateChanged
        // TODO add your handling code here:
        Boolean selected = jtbLocate1.isSelected();
        Boolean empty = jTextLocation1.getText().isEmpty();
        
        if (selected && !empty) {
            jtbLocate1.setText("ON");
        }
           
    }//GEN-LAST:event_jtbLocate1StateChanged

    private void jTextLocation1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextLocation1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextLocation1MouseClicked

    private void jbCaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCaptureActionPerformed
        Robot robot;
        try {
            robot = new Robot();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            BufferedImage screen = robot.createScreenCapture(new Rectangle(screenSize));
            Constants.capture = (new ScreenCaptureRectangle(screen)).captureRect;

        } catch (AWTException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbCaptureActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider)evt.getSource();
        int sliderval = (int)source.getValue();
        int lower = Math.max(sliderval-25,25);
        int upper = Math.max(sliderval+15,90);

        if (!source.getValueIsAdjusting()) {
            log.append("Upper limit set to " + (int)source.getValue() +"%"+ "\n");
//            log.append(String.format("[%.2f, %.2f]%n",upper, lower));
            Constants.sliderval = (int)source.getValue();
        }
        /*
        int fps = (int)source.getValue();
        if (fps == 0) {
            if (!frozen) stopAnimation();
        } else {
            delay = 1000 / fps;
            timer.setDelay(delay);
            timer.setInitialDelay(delay * 10);
            if (frozen) startAnimation();
        }

        }*/
    }//GEN-LAST:event_jSlider1StateChanged

    private void jrSeikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrSeikeActionPerformed

        if(jrSeike.isSelected())
        {
            card.show(jPanel, "NEC");
            clearNotSelected(jrSeike);
            isON = true;
            try {
                initializeReader(jrSeike);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            isON = false;
            jrSaax.setBackground(Constants.colorNOTSELECTED);
            if(Constants.reader != null)
            try {
                Constants.reader.close();
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jrSeikeActionPerformed

    private void jrSeikeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jrSeikeStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jrSeikeStateChanged

    private void jrLeukeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrLeukeActionPerformed
        // TODO add your handling code here:
        if(jrLeuke.isSelected()){
            isON = true;
            card.show(jPanel, "BLANK");
            clearNotSelected(jrLeuke);
            try {
                initializeReader(jrLeuke);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jrLeuke.setBackground(Constants.colorNOTSELECTED);
            isON = false;
            if(Constants.reader != null)
            try {
                Constants.reader.close();
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jrLeukeActionPerformed

    private void jrMorleyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMorleyActionPerformed
        // TODO add your handling code here:
        if(jrMorley.isSelected())
        {
            card.show(jPanel, "CLR");
            clearNotSelected(jrMorley);
            isON = true;
            try {
                initializeReader(jrMorley);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jrMorley.setBackground(Constants.colorNOTSELECTED);
            isON = false;
            if(Constants.reader != null)
            try {
                Constants.reader.close();
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jrMorleyActionPerformed

    private void jCheckSIT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckSIT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckSIT1ActionPerformed

    private void jCheckSITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckSITActionPerformed
        // TODO add your handling code here:
        Constants.clr.sitSelected(jCheckSIT.isSelected());
    }//GEN-LAST:event_jCheckSITActionPerformed

    private void jrCHAINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrCHAINActionPerformed
        // TODO add your handling code here:
        Constants.clr.chainSelected(jrCHAIN.isSelected());
        Constants.CHorder = jTextOrder.getText().trim();
        log.append("Chain " + jrCHAIN.isSelected() + "  Order: " + Constants.CHorder + "\n");
    }//GEN-LAST:event_jrCHAINActionPerformed

    private void jrLHEALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrLHEALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrLHEALActionPerformed

    private void jrLHEALStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jrLHEALStateChanged
        // TODO add your handling code here:
        if(jrLHEAL.isSelected())
        Constants.clr.setSpell(Cleric.spellName.CE, true);
        else
        Constants.clr.setSpell(Cleric.spellName.CE, false);
    }//GEN-LAST:event_jrLHEALStateChanged

    private void jrSaaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrSaaxActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
        JRadioButton button = jrSaax;
        if(button.isSelected())
        {
            isON = true;
            clearNotSelected(button);
            initializePanel(button);
            try {
                initializeReader(button);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            button.setBackground(Constants.colorNOTSELECTED);
            isON = false;
            if(Constants.reader != null)
            try {
                Constants.reader.close();
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jrSaaxActionPerformed

    private void jrSaaxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jrSaaxStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jrSaaxStateChanged

    private void jrKITEStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jrKITEStateChanged
        // TODO add your handling code here:
        Bard bard = Bard.getInstance();
        try {
            bard.kite(jrKITE.isSelected());
        } catch (AWTException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jrKITEStateChanged

    private void jrKITEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrKITEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrKITEActionPerformed

    private void jSlowedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlowedStateChanged
        // TODO add your handling code here:
        if(jSlowed.isSelected())
            Constants.clr.setSlowed(true);
        else
            Constants.clr.setSlowed(false);
    }//GEN-LAST:event_jSlowedStateChanged
    
    
    public void setTextArea(String s)
    {
        log.append(s+ "\n");
    }
    
    public void initializePanel(JRadioButton button)
    {
        String name = button.getText();
        switch(name){
            case("Morley"):
                card.show(jPanel, "CLR");
                break;
            case("Seike"):
                card.show(jPanel,"NEC");
                break;
            case("Leuke"):
                card.show(jPanel, "BLANK");
                break;
            case("Saax"):
                card.show(jPanel,"BRD");
                break;      
        }
    }
    
    public void clearNotSelected(JRadioButton button)
    {
        Iterator it = radioButtons.listIterator();
        button.setBackground(Constants.colorSELECTED);

        JRadioButton selected = null;
            while(it.hasNext()){
                selected = (JRadioButton)it.next();
                if(!selected.equals(button))
                {
                    selected.setSelected(false);
                    selected.setBackground(Constants.colorNOTSELECTED);
                }
            }
    }
    
    public void initializeReader(JRadioButton button) throws FileNotFoundException
    {
        Constants.charname = button.getText();
        Constants.updateFilename();
        Constants.updateFilename();
        Constants.reader = new BufferedReader(new FileReader(Constants.filename));
    }
    
    public void inTextStream(String s)
    {
        stream.addFirst(s);
        
        String lines = "";
        Iterator it = stream.listIterator();
        while(it.hasNext())
        {
            lines += "  " + it.next() +"\n";
        }
        jTextPane1.setText(lines);
        if(stream.size()>12)
            stream.removeLast();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JCheckBox jCheckSIT;
    private javax.swing.JCheckBox jCheckSIT1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelBRD;
    private javax.swing.JPanel jPanelCLR;
    private javax.swing.JPanel jPanelNEC;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JCheckBox jSlowed;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextLocation1;
    private javax.swing.JTextField jTextOrder;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton jbCapture;
    private javax.swing.JButton jbOpen1;
    private javax.swing.JCheckBox jrCHAIN;
    private javax.swing.JCheckBox jrKITE;
    private javax.swing.JCheckBox jrLHEAL;
    private javax.swing.JRadioButton jrLeuke;
    private javax.swing.JRadioButton jrMorley;
    private javax.swing.JRadioButton jrSaax;
    private javax.swing.JRadioButton jrSeike;
    private javax.swing.JToggleButton jtbLocate1;
    private java.awt.TextArea log;
    // End of variables declaration//GEN-END:variables

    private void showMessageDialog(String location_empty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class ScreenCaptureRectangle {
  Rectangle captureRect;

  boolean mouseClicked = false;
  ScreenCaptureRectangle(final BufferedImage screen) {
    BufferedImage screenCopy = new BufferedImage(screen.getWidth(),
        screen.getHeight(), screen.getType());
    JLabel screenLabel = new JLabel(new ImageIcon(screenCopy));
    JScrollPane screenScroll = new JScrollPane(screenLabel);

    screenScroll.setPreferredSize(new Dimension(300, 300));

    repaint(screen, screenCopy);
    screenLabel.repaint();

    screenLabel.addMouseMotionListener(new MouseMotionAdapter() {
      Point start = new Point();
      @Override
      public void mouseMoved(MouseEvent me) {
              start = me.getPoint();
              captureRect = new Rectangle(start, new Dimension(110,12));//end.x - start.x, end.y
              repaint(screen, screenCopy);
              if(!mouseClicked)
                screenLabel.repaint();    
              System.out.println(mouseClicked);
      }
    });
    
    screenLabel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            mouseClicked = !mouseClicked;
        }
    });
    
    JOptionPane.showMessageDialog(null, screenScroll);
  }

  public void repaint(BufferedImage orig, BufferedImage copy) {
    Graphics2D g = copy.createGraphics();
    g.drawImage(orig, 0, 0, null);
    g.setColor(Color.RED);
    if (captureRect == null) {
      return;
    }
    g.draw(captureRect);
    g.setColor(new Color(25, 25, 23, 10));
    g.fill(captureRect);
    g.dispose();
  }

}