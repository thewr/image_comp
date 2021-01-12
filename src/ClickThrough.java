import ic.util.Constants;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box.Filler;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class ClickThrough extends JFrame {
    
    static final int INIT = 70;    //initial frames per second
    public static int sliderval;
    public static boolean isON;
    
    private JFrame f = new JFrame("Test");
    private CardLayout jCard = new CardLayout();  
    private JPanel jPanelActions = new JPanel();
    private TextArea log = new TextArea();    
    private JTextPane jtStream = new JTextPane();

    private JScrollPane jScrollPane = new JScrollPane();
    private JScrollPane jScrollPane2 = new JScrollPane();

    //TAB PANE
    private JTabbedPane jTabbedPane = new JTabbedPane();
    private JPanel jPanelTab = new JPanel();
    
    //???
    private JPanel jpSlider = new JPanel();
    private JSlider jSlider = new JSlider();
    private JPanel jpBottom = new JPanel();


    public static LinkedList<String> stream = new LinkedList<>();
    //CLR PANEL
    private JRadioButton jrMorley, jrLeuke, jrSaax, jrSeike, jrHealth;
    private JPanel jPanelCLR = new JPanel();
   
    private JCheckBox jCheckSIT = new JCheckBox();;
    private JTextField jTextOrder = new JTextField();
    private JCheckBox jSlowed = new JCheckBox();
    private JComboBox jCombo = new JComboBox();
    
    private Filler filler = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 10));
    private JPanel jPanelTab2 = new JPanel();
    private JPanel jPanelWrapper = new JPanel();
    private JTextField jTextLocation =  new JTextField();;
    private JToggleButton jButtonLocate = new JToggleButton();

    JDesktopPane desktop;
    public ClickThrough() {
        //Set up the GUI.
       // desktop = new JDesktopPane(); //a specialized layered pane
       // setContentPane(desktop);
        initComponents();
    }
   
    
    private void initComponents(){
        setAlwaysOnTop(true);
        
        setBackground(Color.darkGray);

        //setUndecorated(true);
        //setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
       // setLayout(jCard);
        
        //getContentPane().add(f);
        
        //f.getContentPane().setLayout(new GridLayout());
        
        //setBackground(java.awt.SystemColor.window);
        setLocation(new java.awt.Point(1300, 200));
        //setMinimumSize(new java.awt.Dimension(jTabbedPane.getWidth(), 465));
        //f.setSize(new java.awt.Dimension(450, 450));
        
        //CLERIC PANEL
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
        jTextOrder.setHorizontalAlignment(JTextField.CENTER);
        jTextOrder.setBackground(Color.BLACK);
        jTextOrder.setForeground(Color.WHITE);
        jPanelCLR.add(jTextOrder, java.awt.BorderLayout.PAGE_END);

        jSlowed.setText("SLOW");
        jSlowed.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanelCLR.add(jSlowed, java.awt.BorderLayout.LINE_END);

        String[] clrStrings = { "CH", "CHAIN", "LHEALS", "NONE"};
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( clrStrings );
        jCombo.setModel( model );
        jCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboActionPerformed(evt);
            }
        });
        
        jPanelCLR.add(jCombo, BorderLayout.PAGE_START);
       
        
        // MAKE TABE PANE
        jTabbedPane.setBackground(new java.awt.Color(255, 204, 204));
        jTabbedPane.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane.setToolTipText("");
        jTabbedPane.setPreferredSize(new java.awt.Dimension(265, 265));

        jPanelTab.setBackground(Constants.colorNOTSELECTED);
        jPanelTab.setForeground(new java.awt.Color(255, 255, 255));

        jrMorley = createRadioButton("Morley");
        jrMorley.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMorleyActionPerformed(evt);
            }
        });
        
        JRadioButton jrSeike = createRadioButton("Seike"); 
        jrSeike.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
             jrDefaultActionPerformed(jrSeike, evt);
            }
        });     
        
        JRadioButton jrLeuke = createRadioButton("Leuke");
        jrLeuke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrDefaultActionPerformed(jrLeuke, evt);
            }
        });
        
        
        JRadioButton jrSaax = createRadioButton("Saax");
        jrSaax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrDefaultActionPerformed(jrSaax, evt);
            }
        });

        jPanelActions.setBackground(Constants.colorNOTSELECTED);

        GroupLayout jPanelLayout = new GroupLayout(jPanelActions);
        jPanelActions.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );


        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanelTab);
        jPanelTab.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(filler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jrSaax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrSeike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrMorley, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrLeuke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelActions, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jrMorley)
                        .addComponent(jrSeike)
                        .addComponent(jrSaax)
                        .addComponent(jrLeuke)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                .addComponent(filler, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
                                ))))
                )
        );
        jTabbedPane.addTab("CHARACTER", jPanelTab);
        
        jPanelActions.setLayout(jCard);
        jPanelActions.add(jPanelCLR,"CLR");
        jPanelActions.setBackground(Constants.colorNOTSELECTED);
        jCard.show(jPanelActions, "CLR");
        
        
        
        
        
        jPanelTab2.setForeground(new java.awt.Color(65, 65, 65));

        jPanelWrapper.setBackground(new java.awt.Color(60, 60, 60));
        jPanelWrapper.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelWrapper.setForeground(new java.awt.Color(255, 102, 255));

        jTextLocation.setBackground(new java.awt.Color(255, 255, 255));
        jTextLocation.setForeground(new java.awt.Color(51, 51, 51));


        jButtonLocate.setText("OFF");
        jButtonLocate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLocateActionPerformed(evt);
            }
        });
        jButtonLocate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jButtonLocateStateChanged(evt);
            }
        });


        javax.swing.GroupLayout jPanelWrapperLayout = new javax.swing.GroupLayout(jPanelWrapper);
        jPanelWrapper.setLayout(jPanelWrapperLayout);

        jPanelWrapperLayout.setHorizontalGroup(
            jPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLocate)
                .addContainerGap())
        );
        jPanelWrapperLayout.setVerticalGroup(
            jPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLocate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelTab2Layout = new javax.swing.GroupLayout(jPanelTab2);
        jPanelTab2.setLayout(jPanelTab2Layout);
        jPanelTab2Layout.setHorizontalGroup(
            jPanelTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTab2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTab2Layout.setVerticalGroup(
            jPanelTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTab2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanelWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("LOCATE", jPanelTab2);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //log.setColumns(50);
        //log.setRows(50);
        log.setBackground(new java.awt.Color(255, 255, 255));
        log.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        log.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane.setViewportView(log);
        
        ///SLIDER
       
        jpSlider.setBackground(Constants.colorNOTSELECTED);
        jpSlider.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSlider.setBackground(Constants.colorNOTSELECTED);
        //jSlider.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jSlider.setForeground(new java.awt.Color(0, 0, 0));
        jSlider.setMajorTickSpacing(10);
        //jSlider.setPaintLabels(true);
        jSlider.setPaintTicks(true);
        jSlider.setSnapToTicks(true);
        jSlider.setValue(70);
        jSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderStateChanged(evt);
            }
        });

        jrHealth = new JRadioButton();
        jrHealth.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jrHealth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioHEALTHActionPerformed(evt);
            }
        });
        

        javax.swing.GroupLayout jpSliderLayout = new javax.swing.GroupLayout(jpSlider);
        jpSlider.setLayout(jpSliderLayout);
        jpSliderLayout.setHorizontalGroup(
            jpSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSliderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrHealth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
        );
        jpSliderLayout.setVerticalGroup(
            jpSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSliderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrHealth)
                    .addComponent(jSlider))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        jtStream.setBackground(new java.awt.Color(0, 0, 0));
        jtStream.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null));
        jtStream.setFont(new java.awt.Font("Inconsolata", 0, 12)); // NOI18N
        jtStream.setForeground(new java.awt.Color(255, 255, 204));
        jScrollPane2.setViewportView(jtStream);
       
        

        javax.swing.GroupLayout jpBottomLayout = new javax.swing.GroupLayout(jpBottom);
        jpBottom.setLayout(jpBottomLayout);
        jpBottomLayout.setHorizontalGroup(
            jpBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBottomLayout.createSequentialGroup()
                
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                )
        );
        jpBottomLayout.setVerticalGroup(
            jpBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBottomLayout.createSequentialGroup()
                .addGroup(jpBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                )
        );
        
        
        JDesktopPane desktop = new JDesktopPane();
        JInternalFrame iFrame1 = createInternalFrame(log, "LOG");
        iFrame1.setSize(250, 130);
        iFrame1.setLocation(0,70);
        JInternalFrame iFrame2 = createInternalFrame(jtStream, "STREAM");
        iFrame2.setSize(150, 50);
        iFrame2.setLocation(0,0);

        desktop.add(iFrame1, BorderLayout.PAGE_END);
        desktop.add(iFrame2, BorderLayout.PAGE_START);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("DesktopPane"));
        panel.add(desktop);
        
                
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                .addGap(5, 5, Short.MAX_VALUE))
        );
       layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE,135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jpSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)  
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
       


       
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
        
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
    }
    
    private void jrMorleyActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        JRadioButton button = jrMorley;

        if(button.isSelected())
        {
            log.append("Morley is selected" + "\n");
            button.setBackground(Constants.colorSELECTED);
            jCard.show(jPanelActions, "CLR");
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
    }
    
    private void jrDefaultActionPerformed(JRadioButton selected, java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        JRadioButton button = selected;

        if(button.isSelected())
        {
            String name = button.getText();
            log.append(name + " is selected" + "\n");
            button.setBackground(Constants.colorSELECTED);
            jCard.show(jPanelActions, "CLR");
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
    }
    
    public void inTextStream(String s)
    {
        stream.addFirst(s);
        
        String lines = "";
        Iterator it = stream.listIterator();
        while(it.hasNext())
        {
            lines += " " + it.next();
        }
        jtStream.setText(lines);
        if(stream.size()>7)
            stream.removeLast();
    }
    
    public void initializeReader(JRadioButton button) throws FileNotFoundException
    {
        Constants.charname = button.getText();
        Constants.updateFilename();
        System.out.println("Opening " + Constants.filename + " .... ");
        Constants.reader = new BufferedReader(new FileReader(Constants.filename));
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
    
    public JSlider getSlider()
    {
        return jSlider;
    }
    
    private void jRadioHEALTHActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        if(jrHealth.isSelected())
        {
            jSlider.setEnabled(true);
        } else {
            jSlider.setEnabled(false);
        }
    }                                            

    private void jSliderStateChanged(javax.swing.event.ChangeEvent evt) {                                      
        // TODO add your handling code here:
        JSlider source = (JSlider)evt.getSource();
        int sliderval = (int)source.getValue();
        int lower = Math.max(sliderval-25,25);
        int upper = Math.max(sliderval+15,90);

        if (!source.getValueIsAdjusting()) {
            log.append("Upper limit set to " + (int)source.getValue() +"%"+ "\n");
            Constants.sliderval = (int)source.getValue();
        }
    }    
    
    private JRadioButton createRadioButton(String name)
    {
        JRadioButton button = new JRadioButton();
            button.setBackground(Constants.colorNOTSELECTED);
            button.setForeground(new java.awt.Color(0, 0, 0));
            button.setText(name);
            button.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            Constants.radioButtons.add(button);

            return button;
    }
    
    private void jButtonLocateActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        Boolean selected = jButtonLocate.isSelected();
        Boolean empty = jTextLocation.getText().isEmpty();

        if((selected && empty) || !selected) {
            jButtonLocate.setText("OFF");
            Constants.bSeek = false;

            if (empty) {
                setTextArea("location field empty!!");
            }
        }

        if (selected && !empty) {
            jButtonLocate.setText("ON");
            Constants.location = jTextLocation.getText().split(",(\\s)?");
            log.append("Location: " +
                Constants.location[0] + ", "
                + Constants.location[1] + "\n");
            Constants.bSeek = true;
        }
    }
    
    private void jButtonLocateStateChanged(javax.swing.event.ChangeEvent evt) {                                        
        // TODO add your handling code here:
        Boolean selected = jButtonLocate.isSelected();
        Boolean empty = jTextLocation.getText().isEmpty();

        if (selected && !empty) {
            jButtonLocate.setText("ON");
        }
    }   
    
    public void setTextArea(String s)
    {
        log.append(String.format(s+"\n",s));
    }
    

    
    //public static void main(String[] args) {
    public static void main(String args[]){
        GraphicsEnvironment ge = 
        GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create the GUI on the event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClickThrough tw = new ClickThrough();

                // Set the window to 55% opaque (45% translucent).
                tw.setOpacity(0.70f);

                // Display the window.
                tw.setVisible(true);
            }
        });
    }
    
    private JInternalFrame createInternalFrame(){
        JInternalFrame frame = new JInternalFrame();
        frame.setSize(200, 200);
        frame.setVisible(true);

        return frame;
    }
    
    private JInternalFrame createInternalFrame(Component c, String name) {
        JInternalFrame frame = new JInternalFrame(name, true, true, true, true);
        frame.setMaximizable(false);
        frame.add(c);
        frame.setSize(150, 50);
        frame.setLocation(0,100);
        frame.setVisible(true);
        return frame;
      }
    

}

        /*
        Component c = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D)g.create();
                g2.setColor(Color.gray);
                int w = getWidth();
                int h = getHeight();
                g2.fillRect(0, 0, w,h);
                g2.setComposite(AlphaComposite.Clear);
                g2.fillRect(w/4, h/4, w-2*(w/4), h-2*(h/4));
            }
        };
        c.setPreferredSize(new Dimension(300, 300));        
        f.getContentPane().add(c);
        */