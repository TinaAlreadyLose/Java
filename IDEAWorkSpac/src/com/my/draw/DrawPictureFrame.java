package com.my.draw;

import javax.swing.JFrame;

/**
 * 构造方法
 */
public class DrawPictureFrame extends JFrame {// 继承窗体类
    public DrawPictureFrame() {
        setResizable(false);// 设置窗体大小不可被改变
        setTitle("画图程序");// 设置标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗口关闭停止工作
        setBounds(500, 100, 574, 460);
    }// end

    public static void main(String[] args) {

        /**
         * 程序运行的主体方法
         */
        DrawPictureFrame frame = new DrawPictureFrame();
        frame.setVisible(true);

    }

}
