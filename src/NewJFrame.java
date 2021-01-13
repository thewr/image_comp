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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;  // Using Frame class in package java.awt
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class NewJFrame extends JFrame {
    static final int INIT = 70;    //initial frames per second
    public static int sliderval;
    public static boolean isON;

    public static LinkedList<String> stream = new LinkedList<>();
    //
    LinkedList<JPanel> panels = new LinkedList<>();
    //Create a file chooser
    final JFileChooser fc = new JFileChooser();
    private CardLayout card;  
    //In response to a button click
    private JPanel jPanelBlank = new JPanel();
    private JPanel jPanelCLR = new JPanel();
    
    //CLR PANEL
    private JCheckBox jCheckSIT = new JCheckBox();;
    private JTextField jTextOrder = new JTextField();
    private JCheckBox jSlowed = new JCheckBox();
    private JComboBox jCombo = new JComboBox();
    
    
    //private JPanel jPanelCLR;
    //private JPanel jPanelCLR = new JPanel();
    //private JTextField jTextOrder = new JTextField();

         
    public NewJFrame() {
        this.sliderval = INIT;
        this.isON = false;
        fc.setCurrentDirectory(new File("D:\\Games\\p99\\EQLITE\\Logs"));
        initComponents();
        initCustomComponents();
    }
    
    private void initCustomComponents() {
        jSlider1.setEnabled(false);
        
        
        Constants.radioButtons.add(jrLeuke3);
        Constants.radioButtons.add(jrMorley3);
        Constants.radioButtons.add(jrSeike3);
        Constants.radioButtons.add(jrSaax3);
        

        panels.add(jPanelActions);
        //container=getContentPane();
        card=new CardLayout(50,50);  
        card.setHgap(4);
        card.setVgap(4);
        
        //CLERIC PANE

        jPanelCLR.setBackground(Constants.colorNOTSELECTED);
        jPanelCLR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCLR.setLayout(new java.awt.BorderLayout());

        jCheckSIT.setBackground(Constants.colorNOTSELECTED);
        jCheckSIT.setForeground(new java.awt.Color(0, 0, 0));
        jCheckSIT.setText("SIT");
        jCheckSIT.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanelCLR.add(jCheckSIT, java.awt.BorderLayout.LINE_START);

        jTextOrder.setText("111");
        jTextOrder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextOrder.setSelectionStart(5);
        jPanelCLR.add(jTextOrder, java.awt.BorderLayout.PAGE_END);

        jSlowed.setText("SLOW");
        jSlowed.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanelCLR.add(jSlowed, java.awt.BorderLayout.LINE_END);

        String[] clrStrings = { "CH", "CHAIN", "LHEALS", "NONE"};
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( clrStrings );
        jCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCombo.setModel( model );
        jCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboActionPerformed(evt);
            }
        });
        jPanelCLR.add(jCombo, java.awt.BorderLayout.PAGE_START);

        
        
        
        //create CardLayout object with 40 hor space and 30 ver space  
        jPanelActions.setLayout(card);
        jPanelActions.add(jPanelCLR,"CLR");
        jPanelActions.add(jPanelBlank,"NEC");
        jPanelActions.add(jPanelBlank,"BLANK");
        jPanelActions.add(jPanelBlank,"BRD");
        card.show(jPanelActions, "BLANK");
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
        jDialog1 = new javax.swing.JDialog();
        jFrame2 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel10 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jRadioHEALTH = new javax.swing.JRadioButton();
        label1 = new java.awt.Label();
        log = new java.awt.TextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jrMorley3 = new javax.swing.JRadioButton();
        jrSeike3 = new javax.swing.JRadioButton();
        jrLeuke3 = new javax.swing.JRadioButton();
        jrSaax3 = new javax.swing.JRadioButton();
        jPanel17 = new javax.swing.JPanel();
        jPanelActions = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jSlider2 = new javax.swing.JSlider();
        jRadioHEALTH1 = new javax.swing.JRadioButton();
        label2 = new java.awt.Label();
        jPanel16 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jTextLocation3 = new javax.swing.JTextField();
        jtbLocate3 = new javax.swing.JToggleButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jTextField = new javax.swing.JTextField();
        jbOpen1 = new javax.swing.JButton();
        jbCapture = new javax.swing.JButton();

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

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.SystemColor.window);
        setLocation(new java.awt.Point(1300, 200));
        setMinimumSize(new java.awt.Dimension(465, 626));
        setSize(new java.awt.Dimension(450, 600));

        jPanel1.setForeground(new java.awt.Color(0, 0, 51));
        jPanel1.setFocusable(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(640, 480));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jDesktopPane1.setBackground(new java.awt.Color(51, 51, 51));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jDesktopPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(200, 300));
        jDesktopPane1.setRequestFocusEnabled(false);

        jPanel10.setBackground(Constants.colorNOTSELECTED);
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSlider1.setBackground(Constants.colorNOTSELECTED);
        jSlider1.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
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

        jRadioHEALTH.setText("OFF");
        jRadioHEALTH.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jRadioHEALTH.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jRadioHEALTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioHEALTHActionPerformed(evt);
            }
        });

        label1.setText("label1");
        label1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                label1FocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioHEALTH, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioHEALTH)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        log.setBackground(new java.awt.Color(255, 255, 255));
        log.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        log.setForeground(new java.awt.Color(0, 0, 0));

        jTextPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTextPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null));
        jTextPane1.setFont(new java.awt.Font("Inconsolata", 0, 12)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(255, 255, 204));
        jScrollPane2.setViewportView(jTextPane1);

        jTabbedPane7.setBackground(new java.awt.Color(255, 204, 204));
        jTabbedPane7.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane7.setToolTipText("");
        jTabbedPane7.setPreferredSize(new java.awt.Dimension(550, 265));

        jPanel18.setBackground(Constants.colorNOTSELECTED);
        jPanel18.setForeground(new java.awt.Color(255, 255, 255));

        jrMorley3.setBackground(Constants.colorNOTSELECTED);
        jrMorley3.setForeground(new java.awt.Color(0, 0, 0));
        jrMorley3.setText("Morley");
        jrMorley3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jrMorley3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMorleyActionPerformed(evt);
            }
        });

        jrSeike3.setBackground(Constants.colorNOTSELECTED);
        jrSeike3.setForeground(new java.awt.Color(0, 0, 0));
        jrSeike3.setText("Seike");
        jrSeike3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jrSeike3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jrSeikeStateChanged(evt);
            }
        });
        jrSeike3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrSeikeActionPerformed(evt);
            }
        });

        jrLeuke3.setBackground(Constants.colorNOTSELECTED);
        jrLeuke3.setForeground(new java.awt.Color(0, 0, 0));
        jrLeuke3.setText("Leuke");
        jrLeuke3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jrLeuke3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrLeukeActionPerformed(evt);
            }
        });

        jrSaax3.setBackground(Constants.colorNOTSELECTED);
        jrSaax3.setForeground(new java.awt.Color(0, 0, 0));
        jrSaax3.setText("Saax");
        jrSaax3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jrSaax3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jrSaaxStateChanged(evt);
            }
        });
        jrSaax3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrSaaxActionPerformed(evt);
            }
        });

        jPanel17.setBackground(Constants.colorNOTSELECTED);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelActionsLayout = new javax.swing.GroupLayout(jPanelActions);
        jPanelActions.setLayout(jPanelActionsLayout);
        jPanelActionsLayout.setHorizontalGroup(
            jPanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        jPanelActionsLayout.setVerticalGroup(
            jPanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        jPanel11.setBackground(Constants.colorNOTSELECTED);
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSlider2.setBackground(Constants.colorNOTSELECTED);
        jSlider2.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jSlider2.setForeground(new java.awt.Color(0, 0, 0));
        jSlider2.setMajorTickSpacing(10);
        jSlider2.setMinorTickSpacing(5);
        jSlider2.setPaintLabels(true);
        jSlider2.setPaintTicks(true);
        jSlider2.setSnapToTicks(true);
        jSlider2.setValue(70);
        jSlider2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });

        jRadioHEALTH1.setText("OFF");
        jRadioHEALTH1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jRadioHEALTH1.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jRadioHEALTH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioHEALTH1ActionPerformed(evt);
            }
        });

        label2.setText("label1");
        label2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                label2FocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioHEALTH1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioHEALTH1)
                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrSeike3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jrMorley3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jrSaax3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jrLeuke3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 8, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jrMorley3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                .addComponent(jrSeike3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrSaax3)
                                .addGap(10, 10, 10)
                                .addComponent(jrLeuke3))))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("CHARACTER", jPanel18);

        jPanel16.setForeground(new java.awt.Color(65, 65, 65));

        jPanel15.setBackground(new java.awt.Color(60, 60, 60));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel15.setForeground(new java.awt.Color(255, 102, 255));

        jTextLocation3.setBackground(new java.awt.Color(255, 255, 255));
        jTextLocation3.setForeground(new java.awt.Color(51, 51, 51));
        jTextLocation3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextLocation1MouseClicked(evt);
            }
        });

        jtbLocate3.setText("OFF");
        jtbLocate3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jtbLocate1StateChanged(evt);
            }
        });
        jtbLocate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbLocate1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextLocation3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtbLocate3)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextLocation3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtbLocate3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("LOCATE", jPanel16);

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
                .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbOpen1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCapture)
                .addGap(141, 141, 141))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCapture)
                .addGap(69, 69, 69))
        );

        jTabbedPane7.addTab("OPEN", jPanel7);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addGap(107, 107, 107)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94))
        );
        jDesktopPane1.setLayer(jPanel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(log, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTabbedPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.add(jDesktopPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jrSaaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrSaaxActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        JRadioButton button = jrSaax3;
        if(button.isSelected())
        {
            clearNotSelected(button);
            initializePanel(button);
            try {
                initializeReader(button);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            isON = false;
            button.setBackground(Constants.colorNOTSELECTED);
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

    private void jrLeukeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrLeukeActionPerformed
        // TODO add your handling code here:
        JRadioButton button = jrLeuke3;

        if(button.isSelected()){
            card.show(jPanelActions, "BLANK");
            clearNotSelected(button);
            try {
                initializeReader(button);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            button.setBackground(Constants.colorNOTSELECTED);
            if(Constants.reader != null)
            try {
                Constants.reader.close();
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jrLeukeActionPerformed

    private void jrSeikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrSeikeActionPerformed

        if(jrSeike3.isSelected())
        {
            card.show(jPanelActions, "NEC");
            
            clearNotSelected(jrSeike3);
            try {
                initializeReader(jrSeike3);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jrSeike3.setBackground(Constants.colorNOTSELECTED);
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

    private void jrMorleyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMorleyActionPerformed
        // TODO add your handling code here:
        System.out.println("Morley action performed!");

        if(jrMorley3.isSelected())
        {
            System.out.println("Morley selected!");
            isON = true;
            card.show(jPanelActions, "CLR");
            clearNotSelected(jrMorley3);
            try {
                initializeReader(jrMorley3);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Morley NOT selected!");
            isON = false;
            jrMorley3.setBackground(Constants.colorNOTSELECTED);
            if(Constants.reader != null)
            try {
                Constants.reader.close();
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jrMorleyActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider)evt.getSource();
        int sliderval = (int)source.getValue();
        int lower = Math.max(sliderval-25,25);
        int upper = Math.max(sliderval+15,90);

        if (!source.getValueIsAdjusting()) {
            log.append("Upper limit set to " + (int)source.getValue() +"%"+ "\n");
            Constants.sliderval = (int)source.getValue();
            label1.setText(Double.toString(Constants.sliderval));
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void jRadioHEALTHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioHEALTHActionPerformed
        // TODO add your handling code here:
        if(jRadioHEALTH.isSelected())
        {
            jRadioHEALTH.setText("ON");
            jSlider1.setEnabled(true);
        } else {
            jRadioHEALTH.setText("OFF");
            jSlider1.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioHEALTHActionPerformed

    private void label1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_label1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_label1FocusGained

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jSlider2StateChanged

    private void jRadioHEALTH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioHEALTH1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioHEALTH1ActionPerformed

    private void label2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_label2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_label2FocusGained
    
    
    public void setTextArea(String s)
    {
        log.append(s+ "\n");
    }
    
    public void initializePanel(JRadioButton button)
    {
        String name = button.getText();
        switch(name){
            case("Morley"):
                card.show(jPanelActions, "CLR");
                break;
            case("Seike"):
                card.show(jPanelActions,"NEC");
                break;
            case("Leuke"):
                card.show(jPanelActions, "BLANK");
                break;
            case("Saax"):
                card.show(jPanelActions,"BRD");
                break;      
        }
    }
    
    public void clearNotSelected(JRadioButton button)
    {
        System.out.println("CLEARING UNSELECTED!");
        Iterator it = Constants.radioButtons.listIterator();
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
    
    public JSlider getSlider()
    {
        return jSlider1;
    }
    
    /*
    public static boolean isButtonSelected()
    {
        Iterator it = Constants.radioButtons.listIterator();
        while(it.hasNext()){
                JRadioButton current = (JRadioButton)it.next();
                if(current.isSelected()) {
                    return true;
                } 
            }
        return false;
    }*/

        private void jComboActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        ///String[] clrStrings = { "CH", "CHAIN", "LHEALS", "NONE"};
        String selection = jCombo.getSelectedItem().toString();
        Constants.clr.setSelected(selection);

        switch (selection) {
            case "CH":
            log.append("CH Normal " + Constants.clr.isCH() + "  Order: " + Constants.CHorder + "\n");
            //initial CH
            break;
            case "CHAIN":
            Constants.CHorder = jTextOrder.getText().trim();
            log.append("Chain " + Constants.clr.isCHAIN() + "  Order: " + Constants.CHorder + "\n");
            break;
            case "LHEALS":
            // TODO add your handling code here:
            Constants.clr.setSelected(selection);
            log.append("Lheals " + Constants.clr.isLHEALS()+"\n");
            break;
            case "NONE":
            Constants.clr.bStart = false;
            break;
            default:
            break;
        }
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
    private javax.swing.Box.Filler filler6;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelActions;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioHEALTH;
    private javax.swing.JRadioButton jRadioHEALTH1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTextField jTextField;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextLocation3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton jbCapture;
    private javax.swing.JButton jbOpen1;
    private javax.swing.JRadioButton jrLeuke3;
    private javax.swing.JRadioButton jrMorley3;
    private javax.swing.JRadioButton jrSaax3;
    private javax.swing.JRadioButton jrSeike3;
    private javax.swing.JToggleButton jtbLocate3;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.TextArea log;
    // End of variables declaration//GEN-END:variables

    private void showMessageDialog(String location_empty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class ScreenCaptureRectangle {
  Rectangle captureRect;
  static Point final_start = new Point();
  boolean mouseClicked = false;
  ScreenCaptureRectangle(final BufferedImage screen) {
    BufferedImage screenCopy = new BufferedImage(screen.getWidth(),
        screen.getHeight(), screen.getType());
    JLabel screenLabel = new JLabel(new ImageIcon(screenCopy));
    JScrollPane screenScroll = new JScrollPane(screenLabel);

    screenScroll.setPreferredSize(new Dimension(800, 800));

    repaint(screen, screenCopy);
    screenLabel.repaint();

    screenLabel.addMouseMotionListener(new MouseMotionAdapter() {
      Point start = new Point();
      @Override
      public void mouseMoved(MouseEvent me) {
              start = me.getPoint();
              repaint(screen, screenCopy);
              if(!mouseClicked){
                screenLabel.repaint();
                captureRect = new Rectangle(start, new Dimension(110,12));//end.x - start.x, end.y
              }
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