package com.my.draw;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.awt.event.*;
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
    boolean rubber=false;/**橡皮识别变量*/

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
        graphics2D.fillRect(0,0,570,390);
        graphics2D.setColor(foreColor);/*前景色*/
        canvas.setImage(image);/*布置画布中的图像*/
        getContentPane().add(canvas);/*将画布添加到窗体的默认布局的中部为主*/
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
    }
    public static void main(String[] args) {

        /**
         * 程序运行的主体方法
         */
        DrawPictureFrame frame = new DrawPictureFrame();
        frame.setVisible(true);

    }

}
