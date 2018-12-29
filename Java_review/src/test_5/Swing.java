package test_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing {
    private JFrame jFrame;
    private Container container;
    private JMenuBar jMenuBar;
    private JMenu jMenu;
    private JMenuItem jMenuItem;
    private JTextArea jtextArea;

    public void GUI() {
        jFrame = new JFrame("测试窗口");
        container = jFrame.getContentPane();
        jMenuBar = new JMenuBar();
        jMenu = new JMenu("文件");
        jMenuItem = new JMenuItem("新建");
        jMenuItem.addActionListener(new Item());
        jtextArea = new JTextArea(10,10);
        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jtextArea);
        jFrame.setLocation(300, 300);
        jFrame.setSize(400,400);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class Item implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            jtextArea.append("你单击了”新建“菜单\n");
        }
    }
}
