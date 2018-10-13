/**
 * @author Dan
 */
package com.my.draw;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import java.awt.event.*;

import javax.swing.*;
import com.mr.util.*;
/**
 * 构造方法
 */
public class DrawPictureFrame extends JFrame implements FrameGetShape {// 继承窗体类
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

    private JButton shapeButton;/**图像按钮*/
    boolean drawShape =false;
    Shapes shape;
    private JButton saveButton;/**保存按钮*/

    /**
     *  添加工具栏       | add toolbar
     * @auther Dan
     * 不同             |   different：
     * 不能调用 add方法  | can“t use the method of add
     * 使用setMenuBar（）|use method of setMenuBar()
     */
    private  JMenuItem strokeMenuItem1;     //细线菜单    |     thin line menu
    private  JMenuItem strokeMenuItem2;     //粗线菜单    |     thick line menu
    private JMenuItem strokeMenuItem3;      //较粗菜单    |     thicker line menu
    private JMenuItem clearMenuItem;        //清除菜单
    private JMenuItem foregroundMenuItem;   //前景色菜单
    private JMenuItem backgroundMenuItem;   //背景色菜单
    private JMenuItem eraserMenuItem;       //橡皮菜单
    private JMenuItem exitMenuItem;         //退出菜单
    private JMenuItem saveMenuItem;         //退出菜单
    private  JMenuItem shuiyinMenuItem;     //水印菜单    |     watermark menu
    private  String shuiyin="";                //水印参数    |     watermark String

    /**
     * 用于获得图形空间返回的被选中的图形
     * @param getshape
     */
    public void getShape(Shapes shape) {
        this.shape=shape;
        drawShape=true;
    }
    public DrawPictureFrame() {
        setResizable(false);// 设置窗体大小不可被改变
        setTitle("画图程序(水印内容：["+shuiyin+"])");// 设置标题
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
        saveButton =new JButton("保存");
        toolBar.add(saveButton);/**工具栏添加保存按钮*/
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

        shapeButton = new JButton("图像");
        toolBar.add(shapeButton);

        clearButton = new JButton("清除");
        toolBar.add(clearButton);
        eraserButton = new JButton("橡皮");
        toolBar.add(eraserButton);

        /**
         * 初始化菜单按钮  |   Initialize menu button
         * @author Dan
         */
        //创建菜单栏  |      create menu Bar
        JMenuBar menuBar =new JMenuBar();
        setJMenuBar(menuBar);


        JMenu systemMenu =new JMenu("系统");
        JMenu strokeMenu=new JMenu("线形");
        JMenu colorMenu = new JMenu("颜色");
        JMenu editMenu = new JMenu("编辑");


        shuiyinMenuItem=new JMenuItem("水印");
        systemMenu.add(shuiyinMenuItem);
        saveMenuItem = new JMenuItem("保存");
        systemMenu.add(saveMenuItem);
        exitMenuItem = new JMenuItem("退出");
        systemMenu.add(exitMenuItem);


        strokeMenuItem1=new JMenuItem("细线");
        strokeMenu.add(strokeMenuItem1);
        strokeMenuItem2 = new JMenuItem("粗线");
        strokeMenu.add(strokeMenuItem2);
        strokeMenuItem3 = new JMenuItem("较粗");
        strokeMenu.add(strokeMenuItem3);

        foregroundMenuItem =new JMenuItem("前景颜色");
        colorMenu.add(foregroundMenuItem);
        backgroundMenuItem = new JMenuItem("背景颜色");
        colorMenu.add(backgroundMenuItem);

        clearMenuItem = new JMenuItem("清除");
        editMenu.add(clearMenuItem);
        eraserMenuItem = new JMenuItem("橡皮");
        editMenu.add(eraserMenuItem);

        menuBar.add(systemMenu);
        menuBar.add(strokeMenu);
        menuBar.add(colorMenu );
        menuBar.add(editMenu);

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

            public void mouseMoved(final MouseEvent e) {
                if (rubber) {//使用橡皮擦        |       use erase
                    Toolkit toolkit =Toolkit.getDefaultToolkit();//获取系统默认的组建安装包
                    Image image = toolkit.createImage("src/img/icon/鼠标橡皮.png");//获得工具包中的图片
                    Cursor cursor = toolkit.createCustomCursor(image, new Point(0, 0), "clear");//参数作为图片，光标热点，和贯标买哦书字符串
                    setCursor(cursor);//使用自定义图片作为光标
                }else{
                    setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                }
            }
        });
        toolBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
        canvas.addMouseListener(new MouseAdapter() {/*添加鼠标但是事件监听*/
            @Override
            public void mouseReleased(MouseEvent e) {/*当鼠标被抬起时*/
                x=-1;
                y=-1;/*上次记录的横纵坐标回复成-1*/
            }
            public void mousePressed(MouseEvent e){
                if (drawShape) {//花的是图像
                    switch (shape.getType()) {
                        case  Shapes.YUAN:
//                            计算坐标，让鼠标处于圆的最中心
                            int yuanX =e.getX()-shape.getWidth()/2;
                            int yuanY=e.getY()-shape.getWidth()/2;
                            //创建圆形并指定宽高
                            Ellipse2D yuan=new Ellipse2D.Double(yuanX,yuanY,shape.getWidth(),shape.getHeigth());
                            graphics2D.draw(yuan);
                            break;
                        case Shapes.FANG:
                            int fangX=e.getX()-shape.getWidth()/2;
                            int fangY=e.getY()-shape.getHeigth()/2;
                            Rectangle2D fang = new Rectangle2D.Double(fangX, fangY, shape.getWidth(), shape.getHeigth());
                            graphics2D.draw(fang);
                            break;
                    }
                    canvas.repaint();/*更新画布*/
                    drawShape=false;
                }
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
                    eraserMenuItem.setText("画图");
                }else{
                    rubber=false;
                    eraserButton.setText("橡皮");
                    eraserMenuItem.setText("橡皮");
                    graphics2D.setColor(foreColor);
                }
            }
        });

        //图形按钮添加动作监听--选择圆形，方形，以及大小
        shapeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShapeWindow shapeWindow = new ShapeWindow(DrawPictureFrame.this);
                int shapeButtonWidth = shapeButton.getWidth();//获取图像按钮的宽度
                int shapeWindowWidth =shapeWindow.getWidth();//获取图形按钮的宽容
                int shapeButtonX=shapeButton.getX();//获取图像按钮的横纵坐标
                int shapeButtonY=shapeButton.getY();
//                让自定义组件与“图像”居中对齐
                int shapeWindowX=getX()+shapeButtonX-(shapeWindowWidth-shapeButtonWidth)/2;
                //让图像组件显示在下方
                int shapeWindowY=getY()+shapeButtonY+80;
                shapeWindow.setLocation(shapeWindowX,shapeWindowY);
                shapeWindow.setVisible(true);
            }
        });

        //保存功能
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                addWatermark(); //添加水印      |      add watermark
                DrawImageUtil.saveImage(DrawPictureFrame.this,image);//打印图片
            }
        });

        /**
         * @author Dan
         * 实现菜单栏功能监听事件      | achieve tool bar
         */
        exitMenuItem.addActionListener(new ActionListener() {   //退出    |   exit
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        eraserMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (eraserMenuItem.getText().equals("橡皮")) {
                    rubber=true;
                    eraserMenuItem.setText("画图");
                    eraserButton.setText("画图");
                }else{
                    rubber=false;
                    eraserMenuItem.setText("橡皮");
                    eraserButton.setText("橡皮");
                }
            }
        });
        clearMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final  ActionEvent e) {
                graphics2D.setColor(backgroudColor);
                graphics2D.fillRect(0, 0, width, height);
                graphics2D.setColor(foreColor);
                canvas.repaint();
            }
        });

        strokeMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BasicStroke basicStroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
                graphics2D.setStroke(basicStroke);
                strokeMenuItem1.setSelected(true);
            }
        });
        strokeMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BasicStroke basicStroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
                graphics2D.setStroke(basicStroke);
                strokeMenuItem2.setSelected(true);
            }
        });
        strokeMenuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BasicStroke basicStroke =new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.CAP_BUTT);
                graphics2D.setStroke(basicStroke);
                strokeMenuItem2.setSelected(true);
            }
        });



        foregroundMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(DrawPictureFrame.this, "选择颜色对话框", Color.CYAN);
                if (color != null) {
                    foreColor=color;
                }
                foreGroundButton.setForeground(foreColor);
                graphics2D.setColor(foreColor);
            }
        });
        backgroundMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(DrawPictureFrame.this, "选择颜色对话框", Color.CYAN);
                if (color != null) {
                    backgroudColor=color;
                }
                backGroundButton.setForeground(backgroudColor);
                graphics2D.setColor(backgroudColor);
                graphics2D.fillRect(0, 0, width, height);
                graphics2D.setColor(foreColor);
                canvas.repaint();
            }
        });
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWatermark();     //添加水印
                DrawImageUtil.saveImage(DrawPictureFrame.this,image);
            }
        });
        shuiyinMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shuiyin = JOptionPane.showInputDialog(DrawPictureFrame.this, "你想添加什么水印？");
                if (null== shuiyin) {
                    shuiyin = "";
                }
                else {
                    setTitle("画图程序(水印内容：["+shuiyin+"])"); //修改窗体    |   change windows with watermark
                }
            }


        });
    }

    private void addWatermark(){    //添加水印函数    |   the function of add watermark
        if (!"".equals(shuiyin.trim())) {        //水印不为空  exist of watermark
            graphics2D.rotate(Math.toRadians(-30));//-30°
            Font font = new Font("楷体", Font.BOLD, 36);//设置字体    |set font
            graphics2D.setFont(font);//载入字体     |       add font
            graphics2D.setColor(Color.GRAY);//使用灰色  |   use gray
            AlphaComposite alphaComposite = AlphaComposite.SrcOver.derive(0.4f);//设置透明度     |    set transparency
            graphics2D.setComposite(alphaComposite);//使用透明度     |       use transparency
            graphics2D.drawString(shuiyin,150,500);//绘制水印  |      draw watermark
            canvas.repaint();                               //重绘画板|     repaint
            graphics2D.rotate(Math.toRadians(30));//把图片在旋转回来   |      make photo return
            alphaComposite=AlphaComposite.SrcOver.derive(1f); //不再透明 |   stop transparency
            graphics2D.setComposite(alphaComposite);//使用不透明效果   ||     use it
            graphics2D.setColor(foreColor);// 回复画笔颜色              |     make painting brush return
            }//stop
    }
    public static void main(String[] args) {

        /**
         * 程序运行的主体方法
         */
        DrawPictureFrame frame = new DrawPictureFrame();
        frame.setVisible(true);

    }

}
