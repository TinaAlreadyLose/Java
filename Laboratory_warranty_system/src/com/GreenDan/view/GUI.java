package com.GreenDan.view;


import com.GreenDan.Jmail.SendJmail;
import com.GreenDan.File.MyFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author GreenDan
 * @version 1.0.0.1
 */

public class GUI {

    private JTextArea jTextArea;
    private JPanel mainJPanel;
    private CardLayout cardLayout;
    private JPanel jPanel_Login;
    private JPanel jPanel_Choose;
    private JPanel jPanel_DataAdd;
    private JPanel jPanel_DataSearch;
    private JPanel jPanel_GetAll_Data;
    private MyFile myFile;
    private SendJmail sendJmail;
    //  添加组件
    private TextField textField_username;
    private JPasswordField jPasswordField_password;

    private JLabel jLabel_ID;
    private JTextField jTextField_ID;
    private JLabel jLabel_Name;
    private JTextField jTextField_Name;
    private JLabel jLabel_Date;
    private SpinnerDateModel spinnerDateModel_Date;
    private JSpinner jSpinner_Date;
    private JLabel jLabel_place;
    private JComboBox jComboBox_place;
    private JLabel jLabel_type;
    private JComboBox jComboBox_type;
    private JLabel jLabel_reason;
    private JTextArea jTextArea_reason;
    private JLabel jLabel_solve;
    private JTextArea jTextArea_solve;


    private JTextArea jTextArea_result;
    private JTextField jTextField_search;
    /**
     * login container
     */


    /**
     * 实现图形化界面的主方法
     */
    public void Main_GUI() {
        JFrame jFrame;
        Container container;
        jFrame = new JFrame("实验室保修系统");
        container = jFrame.getContentPane();
        mainJPanel = new JPanel();
        cardLayout = new CardLayout();
        jPanel_Login = new JPanel();
        jPanel_Choose = new JPanel();
        jPanel_DataAdd = new JPanel();
        jPanel_DataSearch = new JPanel();
        jPanel_GetAll_Data = new JPanel();


        myFile = new MyFile();
        sendJmail = new SendJmail();
        Login_GUI();
        Choose_GUI();
        DataAdd_GUI();
        DataSearch_GUI();
        GetAllData_GUI();
/**
 * 页面整体布局：CardLayout
 */
        mainJPanel.setLayout(cardLayout);
        mainJPanel.add("jPanel_Login", jPanel_Login);
        mainJPanel.add("jPanel_Choose", jPanel_Choose);
        mainJPanel.add("jPanel_DataAdd", jPanel_DataAdd);
        mainJPanel.add("jPanel_DataSearch", jPanel_DataSearch);
        mainJPanel.add("jPanel_GetAll_Data", jPanel_GetAll_Data);
        container.add(mainJPanel);


        /**
         * JFrame 设置
         */
        jFrame.pack();
        jFrame.setSize(400, 450);
        jFrame.setLocation(700, 350);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    /**
     * 实现页面之间的跳转
     *
     * @return 首页，登入页，下一页，上一页
     */

    private JPanel Change_GUI() {
        JPanel jPanel = new JPanel();
        JButton jButton_LoginPage;
        JButton jButton_ChoosePage;
        JButton jButton_NextPage;
        JButton jButton_PreviousPage;
        jButton_LoginPage = new JButton("登出");
        jButton_ChoosePage = new JButton("首页");
        jButton_NextPage = new JButton("下一页");
        jButton_PreviousPage = new JButton("上一页");
        jButton_LoginPage.addActionListener(new Card_First());
        jButton_ChoosePage.addActionListener(new Card_Show("jPanel_Choose"));
        jButton_NextPage.addActionListener(new Card_Next());
        jButton_PreviousPage.addActionListener(new Card_Previous());
        jPanel.add(jButton_LoginPage);
        jPanel.add(jButton_ChoosePage);
        jPanel.add(jButton_NextPage);
        jPanel.add(jButton_PreviousPage);
        return jPanel;
    }

    /**
     * 实现图形化登入界面
     */
    private void Login_GUI() {
        JLabel jLabel_Welcome;
        JLabel jLabel_Username;
        JLabel jLabel_Password;

        JButton jButton_Login;
        JButton jButton_Create;
//        JPanel jPanel = new JPanel();
//        jPanel.setLayout(new FlowLayout());
//        jPanel_Login.setLayout(new BorderLayout());
/**
 * 新建容器
 */
        jLabel_Welcome = new JLabel("欢迎使用本系统", JLabel.CENTER);
        textField_username = new TextField(30);
        jPasswordField_password = new JPasswordField(20);
        jButton_Create = new JButton("注册");
        jButton_Create.addActionListener(new Create());
        jButton_Login = new JButton("登入");
        jButton_Login.addActionListener(new LogIn());
        jLabel_Username = new JLabel("用户名");
        jLabel_Password = new JLabel("密码");
//        jPanel.add(jLabel_Username);
//        jPanel.add(textField_username);
//        jPanel.add(jLabel_Password);
//        jPanel.add(jPasswordField_password);
//e
//        jPanel_Login.add(jLabel_Welcome,BorderLayout.NORTH);
//        jPanel_Login.add(jPanel,BorderLayout.CENTER);
//        jPanel_Login.add(jButton_Login,BorderLayout.SOUTH);
        /**
         * 容器布局
         */
        jLabel_Welcome.setFont(new java.awt.Font("黑体", 1, 35));
        jLabel_Welcome.setBounds(50, 50, 300, 100);
        jLabel_Username.setBounds(75, 175, 50, 30);
        textField_username.setBounds(140, 175, 150, 30);
        jLabel_Password.setBounds(75, 225, 50, 30);
        jPasswordField_password.setBounds(140, 225, 150, 30);
        jButton_Create.setBounds(100, 275, 60, 40);
        jButton_Login.setBounds(200, 275, 60, 40);
        jPanel_Login.setLayout(null);
        /**
         * 添加容器
         */
        jPanel_Login.add(jLabel_Welcome);
        jPanel_Login.add(jLabel_Username);
        jPanel_Login.add(textField_username);
        jPanel_Login.add(jLabel_Password);
        jPanel_Login.add(jPasswordField_password);
        jPanel_Login.add(jButton_Create);
        jPanel_Login.add(jButton_Login);
    }

    /**
     * 实现选择界面
     */

    /**
     * 实现数据添加界面
     */
    private void DataAdd_GUI() {
//      new
        JButton jButton = new JButton("添加");
        JPanel jPanel_south = new JPanel();
        JPanel jPanel_main = new JPanel();
        jPanel_DataAdd.setLayout(new BorderLayout(7, 2));


        jLabel_ID = new JLabel("订单号码", JLabel.CENTER);
        jTextField_ID = new JTextField("");

        jLabel_Name = new JLabel("产品名称", JLabel.CENTER);
        jTextField_Name = new JTextField("");

        jLabel_Date = new JLabel("发生日期", JLabel.CENTER);
        //获取时间日期模型
        spinnerDateModel_Date = new SpinnerDateModel();
        //获取JSPrinner对象
        jSpinner_Date = new JSpinner(spinnerDateModel_Date);
        jSpinner_Date.setValue(new Date());
        //设置时间模式
        JSpinner.DateEditor editor = new JSpinner.DateEditor(jSpinner_Date, "yyyy-MM-DD HH:mm:ss");
        jSpinner_Date.setEditor(editor);
        jLabel_place = new JLabel("发生地点", JLabel.CENTER);
        jComboBox_place = new JComboBox();
        jComboBox_place.addItem("地点1");
        jComboBox_place.addItem("地点2");
        jComboBox_place.addItem("地点3");
        jComboBox_place.addItem("地点4");
        jComboBox_place.setVisible(true);

        jLabel_type = new JLabel("故障类型", JLabel.CENTER);
        jComboBox_type = new JComboBox();
        jComboBox_type.addItem("故障1");
        jComboBox_type.addItem("故障2");
        jComboBox_type.addItem("故障3");
        jComboBox_type.addItem("故障4");
        jComboBox_type.setVisible(true);

        jLabel_reason = new JLabel("故障原因", JLabel.CENTER);
        jTextArea_reason = new JTextArea("");
        JScrollPane jScrollPane_reason = new JScrollPane(jTextArea_reason);

        jLabel_solve = new JLabel("处理对策", JLabel.CENTER);
        jTextArea_solve = new JTextArea();
        JScrollPane jScrollPane_solve = new JScrollPane(jTextArea_solve);

//      north
        JLabel jLabel = new JLabel("数据添加", JLabel.CENTER);
        jLabel.setFont(new java.awt.Font("黑体", 1, 20));
//      center
        jPanel_main.setLayout(new GridLayout(7, 2, 10, 10));

//      south
        jPanel_south.add(this.Change_GUI());
        jPanel_south.add(jButton);
//      add
        jPanel_main.add(jLabel_ID);
        jPanel_main.add(jTextField_ID);
        jPanel_main.add(jLabel_Name);
        jPanel_main.add(jTextField_Name);
        jPanel_main.add(jLabel_Date);
        jPanel_main.add(jSpinner_Date);
        jPanel_main.add(jLabel_place);
        jPanel_main.add(jComboBox_place);
        jPanel_main.add(jLabel_type);
        jPanel_main.add(jComboBox_type);
        jPanel_main.add(jLabel_reason);
        jPanel_main.add(jScrollPane_reason);
        jPanel_main.add(jLabel_solve);
        jPanel_main.add(jScrollPane_solve);

        jButton.addActionListener(new AddData());

        jPanel_DataAdd.add(jLabel, BorderLayout.NORTH);
        jPanel_DataAdd.add(jPanel_main, BorderLayout.CENTER);
        jPanel_DataAdd.add(jPanel_south, BorderLayout.SOUTH);

    }


    /**
     * 实现数据查询界面
     */
    private void DataSearch_GUI() {
//
        JPanel jPanel_main = new JPanel();
        JPanel jPanel_south = new JPanel();
        JButton jButton = new JButton("邮件");
        jPanel_DataSearch.setLayout(new BorderLayout());
        JLabel jLabel = new JLabel("数据查询", JLabel.CENTER);
        jLabel.setFont(new java.awt.Font("黑体", 1, 20));

        jTextField_search = new JTextField(20);
        JButton jButton_search = new JButton("查询");
        jTextArea_result = new JTextArea(18, 35);
        JScrollPane jScrollPane = new JScrollPane(jTextArea_result);
//        add
        jPanel_main.add(jTextField_search);
        jPanel_main.add(jButton_search);
        jPanel_main.add(jScrollPane);
        jPanel_south.add(this.Change_GUI());
        jPanel_south.add(jButton);
        jPanel_DataSearch.add(jLabel, BorderLayout.NORTH);
        jPanel_DataSearch.add(jPanel_main, BorderLayout.CENTER);
        jPanel_DataSearch.add(jPanel_south, BorderLayout.SOUTH);

        jButton_search.addActionListener(new SearchDataByID());
        jButton.addActionListener(new Jmail());

    }

    /**
     * 实现详细数据的查看
     */
    private void GetAllData_GUI() {
        JPanel jPanel0 = new JPanel();
        JButton jButton = new JButton("邮件");
        JButton jButton1 = new JButton("刷新");
        JPanel jPanel = new JPanel();
        jPanel_GetAll_Data.setLayout(new BorderLayout());
        JLabel jLabel = new JLabel("详细数据", JLabel.CENTER);

        jLabel.setFont(new java.awt.Font("黑体", 1, 20));
        String AllData = null;
        jPanel0.add(jLabel);
        jPanel0.add(jButton1);
         jTextArea = new JTextArea(10, 30);
        AllData = myFile.GetAllData_ByGson();
        if (AllData == null) {
            AllData = "没有数据";
        }
        jTextArea.setText(AllData);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jPanel.add(this.Change_GUI());
        jPanel.add(jButton);
        jPanel_GetAll_Data.add(jPanel0, BorderLayout.NORTH);
        jPanel_GetAll_Data.add(jScrollPane, BorderLayout.CENTER);
        jPanel_GetAll_Data.add(jPanel, BorderLayout.SOUTH);
        jButton1.addActionListener(new reflush());
        jButton.addActionListener(new JmailALL());

    }

    private void Choose_GUI() {
        jPanel_Choose.setLayout(new BorderLayout());
        JPanel jPanelGird = new JPanel();
        jPanelGird.setLayout(new GridLayout(2, 2, 10, 10));

        JButton jButton_LoginPage = new JButton("注册");
        JButton jButton_DataAddPage = new JButton("数据添加");
        JButton jButton_DataSearchPage = new JButton("数据查询");
        JButton jButton_GetAllDataPage = new JButton("查看所有数据");

        jButton_LoginPage.setSize(50, 50);
        jButton_DataAddPage.setSize(50, 50);
        jButton_DataSearchPage.setSize(20, 50);
        jButton_GetAllDataPage.setSize(50, 50);

        jPanelGird.add(jButton_LoginPage);
        jPanelGird.add(jButton_DataAddPage);
        jPanelGird.add(jButton_DataSearchPage);
        jPanelGird.add(jButton_GetAllDataPage);
        jPanel_Choose.add(jPanelGird, BorderLayout.CENTER);

        jButton_LoginPage.addActionListener(new Card_First());
        jButton_DataAddPage.addActionListener(new Card_Show("jPanel_DataAdd"));
        jButton_DataSearchPage.addActionListener(new Card_Show("jPanel_DataSearch"));
        jButton_GetAllDataPage.addActionListener(new Card_Show("jPanel_GetAll_Data"));

    }

    private void ShowMessage(String Message, String name) {
        JFrame jFrame = new JFrame(name);
        Container container = jFrame.getContentPane();
        JLabel jLabel = new JLabel(Message, JLabel.CENTER);
        container.add(jLabel);
        jFrame.pack();
        jFrame.setSize(150, 150);
        jFrame.setLocation(850, 500);
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }

    class reflush implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
         jTextArea.setText( myFile.GetAllData_ByGson());
        }
    }
    class Create implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ShowMessage("内测期间，此功能未开发","注册账号");
        }
    }
    class LogIn implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            char[] pass=jPasswordField_password.getPassword();
            String password=new String(pass);
            if ((textField_username.getText().equalsIgnoreCase("Admin")) && (password.equalsIgnoreCase("123456"))) {
//                new Card_Show("jPanel_Choose");
                cardLayout.show(mainJPanel, "jPanel_Choose");
            }else {
//                new Card_Show("jPanel_Login");
                cardLayout.show(mainJPanel, "jPanel_Login");
            }
        }
    }

    class AddData implements ActionListener {
        private String ID = null;
        private String Name = null;
        private String Date = null;
        private String Place = null;
        private String Type = null;
        private String Reason = null;
        private String Solve = null;

        private void GetAll() {
            ID = jTextField_ID.getText();
            Name = jTextField_Name.getText();
            Date = jSpinner_Date.getValue().toString();
            Place = jComboBox_place.getSelectedItem().toString();
            Type = jComboBox_type.getSelectedItem().toString();
            Reason = jTextArea_reason.getText();
            Solve = jTextArea_solve.getText();
        }

        private boolean IS_ADD() {
            boolean isADD = (ID.isEmpty()) && (Name.isEmpty())
                    && (Date.isEmpty()) && (Place.isEmpty())
                    && (Type.isEmpty()) && (Reason.isEmpty())
                    && (Solve.isEmpty());
            System.out.println(isADD);
            if (!isADD) {
                return true;
            }
            return false;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                GetAll();
//            System.out.println(Name.isEmpty());
                if (IS_ADD()) {
                    System.out.println("ID:" + ID + "\tName:" + Name + "\tDate:" + Date + "\tPlace:" + Place + "\tType:" + Type + "\tReason:" + Reason + "\tSolve:" + Solve);
                    if (myFile.AddData_ByGson(ID, Name, Date, Place, Type, Reason, Solve)) {
                        ShowMessage("数据添加成功", "添加结果");
                    } else ShowMessage("数据添加失败", "添加结果");
                } else ShowMessage("数据不全无法添加", "添加结果");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    class Jmail implements ActionListener {
        private String massage;

        @Override
        public void actionPerformed(ActionEvent e) {
            massage=jTextArea_result.getText();
            if (massage != null) {
                try {
                    sendJmail.sendJmail(massage);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    class JmailALL implements ActionListener {
        private String massage;

        @Override
        public void actionPerformed(ActionEvent e) {
            massage=jTextArea.getText();
            System.out.println(massage);
            if (massage != null) {
                try {
                    sendJmail.sendJmail(massage);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    class SearchDataByID implements ActionListener {
        private String ID;

        @Override
        public void actionPerformed(ActionEvent e) {
            ID = jTextField_search.getText();
            if (!ID.equals(null) && !ID.equalsIgnoreCase("请输入查询的ID")) {
                try {
                   String result= myFile.searchById_ByGson(ID);
                    if(result!=null)
                        jTextArea_result.setText(result);
                 else ShowMessage("没有此产品，请重现查找","查询结果");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        }
    }

    /**
     * 下一个容器
     *
     * @author GreenDan
     */
    class Card_Next implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.next(mainJPanel);
        }
    }

    /**
     * 上一个容器
     *
     * @author GreenDan
     */
    class Card_Previous implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.previous(mainJPanel);
        }
    }

    /**
     * 第一个容器
     *
     * @author GreenDan
     */
    class Card_First implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.first(mainJPanel);
        }
    }

    /**
     * 最后一个容器
     *
     * @author GreenDan
     */
    class Card_Last implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.last(mainJPanel);
        }
    }

    /**
     * 找到特定的容器
     *
     * @author GreenDan
     */
    class Card_Show implements ActionListener {
        private String show;

        Card_Show(String show) {
            this.show = show;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(mainJPanel, show);
        }
    }

    public static void main(String[] args) {
        GUI demo = new GUI();
        demo.Main_GUI();
    }
}


