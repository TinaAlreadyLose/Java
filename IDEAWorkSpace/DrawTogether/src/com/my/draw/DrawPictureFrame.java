package com.my.draw;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.awt.event.*;

import javax.swing.*;
/**
 * 构造方法
 */
public class DrawPictureFrame extends JFrame {// 继承窗体类
//    创建一个8位的BGR颜色分量的图像
    BufferedImage image =new BufferedImage(570,390,BufferedImage.TYPE_INT_BGR);
    Graphics graphics=image.getGraphics();//获得图像的绘图对象
    Graphics2D graphics2D=(Graphics2D)graphics;/*讲绘图的对象转换为Graphics2D类型*/
    DrawPictureCanvas canvas = new DrawPictureCanvas();
    Color foreColor = Color.black;/*定义前景色*/
    Color backgroudColor=Color.white;/*定义背景色*/
    int x=-1; //定义上次鼠标的横纵点的横坐标
    int y=-1;
    private  int width=570;
    private  int height=390;
    boolean rubber=false;/*橡皮识别变量*/
    private JToolBar toolBar;//工具栏
    private JButton eraserButton;
    private  JToggleButton strokeButton1;/*细线按钮*/
    private JToggleButton strokeButtom2;/*粗线按钮*/
    private JToggleButton strokeButtom3;/**较粗的按钮*/
    private JButton backGroundButton;/**背景颜色按钮*/
    private JButton foreGroundButton;/**前景颜色按钮*/
    private JButton clearButton;/**清除按钮*/
    private JButton savaButton;/**保存按钮*/
    private JButton shapeButton;/**图像按钮*/
    public DrawPictureFrame() {
        setResizable(false);// 设置窗体大小不可被改变
        setTitle("画图。程序");// 设置标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 窗口关闭停止工作
        setBounds(500, 100, 574, 460);
        init();/*初始化组件*/
        addListener();/*添加监听组件*/
    }// end

    private void init(){
        graphics2D.setColor(backgroudColor);/*背景色*/
        graphics2D.fillRect(0,0,width,height);
        graphics2D.setColor(foreColor);/*前景色*/
        canvas.setImage(image);/*布置画布中的图像*/
        getContentPane().add(canvas);/*将画布添加到窗体的默认布局的中部为主*/

        toolBar =new JToolBar();/**初始化工具栏*/
        getContentPane().add(toolBar,BorderLayout.NORTH);/**把工具栏放在最北边*/
        savaButton =new JButton("保存");
        toolBar.add(savaButton);/**工具栏添加保存按钮*/
        toolBar.addSeparator();//添加分割线

        strokeButton1 = new JToggleButton("细线");
        strokeButton1.setSelected(true);/*默认被选中*/
        toolBar.add(strokeButton1);

        strokeButtom2 = new JToggleButton("粗线");
        toolBar.add(strokeButtom2);

        strokeButtom3 =new JToggleButton("较粗");
        toolBar.add(strokeButtom3);

        ButtonGroup strokeGroup= new ButtonGroup();/*把三个按钮放在一个按钮组中，保证他们同时只能选择一个*/
        strokeGroup.add(strokeButton1);
        strokeGroup.add(strokeButtom2);
        strokeGroup.add(strokeButtom3);

       toolBar.addSeparator();/*添加分割线*/

        backGroundButton = new JButton("背景颜色");
        toolBar.add(backGroundButton);

        foreGroundButton = new JButton("前景色");
        toolBar.add(foreGroundButton);
        toolBar.addSeparator();

        clearButton = new JButton("清除");
        toolBar.add(clearButton);
        eraserButton = new JButton("橡皮");
        toolBar.add(eraserButton);



}
    private void addListener(){
//        画板添加鼠标移动时间监听
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(final MouseEvent e) {
                if(x>0&&y>0){/*如果运动了*/
                    if(rubber){/*使用橡皮*/
                        graphics2D.setColor(backgroudColor);/*用背景色来填充*/
                        graphics2D.fillRect(x,y,10,10);/*划过的大小为10*10的正方形*/
                    }else{
                        graphics2D.drawLine(x,y,e.getX(),e.getY());/*鼠标划过的位置画直线*/
                    }
                }
                x=e.getX();/*更新上一次鼠标绘制的横纵坐标*/
                y=e.getY();
                canvas.repaint();/*跟新画布*/
            }
        });
        canvas.addMouseListener(new MouseAdapter() {/*添加鼠标但是事件监听*/
            @Override
            public void mouseReleased(MouseEvent e) {/*当鼠标被抬起时*/
                x=-1;
                y=-1;/*上次记录的横纵坐标回复成-1*/
            }
        });
        /**
         * BasicStroke（）
         * BasicStroke（float width）
         * BasicStroke（float width，int cap ，int join）
         * cap控制对线段点的描述效果
         * join控制线段交汇时的效果
         */
        /**
         * 选择画笔的粗细
         * */
        strokeButton1.addActionListener(new ActionListener() {//点击细线默认的逻辑处理事件
            @Override
            public void actionPerformed(final ActionEvent e) {
                /*一像素，末端无修饰，折线出为尖角*/
                BasicStroke basicStroke=new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER);
                graphics2D.setStroke(basicStroke);/*设置使用此画笔*/
            }
        });

        strokeButtom2.addActionListener(new ActionListener() {//点击粗线触发的逻辑事件
            @Override
            public void actionPerformed(final ActionEvent e) {
                BasicStroke basicStroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
                graphics2D.setStroke(basicStroke);
            }
        });

        strokeButtom3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                BasicStroke basicStroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
                graphics2D.setStroke(basicStroke);
            }
        });

        /**
         * 更换背景前景颜色
         */

        backGroundButton.addActionListener(new ActionListener() {


            public void actionPerformed(final ActionEvent e) {
                Color bgcolor=JColorChooser.showDialog(DrawPictureFrame.this,"选择颜色对话框",Color.CYAN);
                if (bgcolor != null) {
                    backgroudColor=bgcolor;/*把图片的·颜色赋值给背景颜色变量*/
                }
                backGroundButton.setBackground(backgroudColor);
                graphics2D.setColor(backgroudColor);
                graphics2D.fillRect(0,0,width,height);/*画一个方向的方块充当背景*/
                graphics2D.setColor(foreColor);/*绘图工具使用前景色*/
                canvas.repaint();
            }
        });
        foreGroundButton.addActionListener(new ActionListener() {

            public void actionPerformed(final ActionEvent e) {
                Color fColor = JColorChooser.showDialog(DrawPictureFrame.this, "选择颜色对话框", Color.CYAN);
                if (fColor != null) {
                    foreColor=fColor;
                }
                foreGroundButton.setForeground(foreColor);
                graphics2D.setColor(foreColor);
            }
        });
        /**
         * 清除功能
         * 用一块新的画布覆盖
         *
         * 橡皮擦功能
         * methed： 把前景色变为背景色，即可实现此功能
         */

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final  ActionEvent e) {
                graphics2D.setColor(backgroudColor);
                graphics2D.fillRect(0,0,width,height);
                graphics2D.setColor(foreColor);
                canvas.repaint();/*重新画画*/
            }
        });
        eraserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (eraserButton.getText().equals("橡皮")) {
                    rubber=true;
                    eraserButton.setText("画图");
                }else{
                    rubber=false;
                    eraserButton.setText("橡皮");
                    graphics2D.setColor(foreColor);
                }
            }
        });
    }


    public static void main(String[] args) {

        /**
         * 程序运行的主体方法
         */
        DrawPictureFrame frame = new DrawPictureFrame();
        frame.setVisible(true);

    }

}
