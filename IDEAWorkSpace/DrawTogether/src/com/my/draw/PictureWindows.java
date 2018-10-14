package com.my.draw;

import com.mr.util.BackgroundPanel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PictureWindows extends JWindow{
    private  JButton changeButton; //跟换图片按钮 |   change photo button
    private  JButton hiddenButton; //隐藏图片按钮 |   hidden photo button
    private BackgroundPanel centerPane1; //展示图片中的带背景的面板 |   show photos in background
    File list[];    //图片文件数组    |   list of photos in  file
    int index;      //当前数组下表    |   index of this photo
    DrawPictureFrame frame; //父窗体 |   fathe Window

    /**
     * @param frame
     * @author Dan
     */
    public PictureWindows(DrawPictureFrame frame) {
        this.frame=frame;
        setSize(400, 600);
        init(); //初始化
        addListener();  //给组件添加监听事件     |       add listener
    }

    /**
     * 初始化  |    initialize
     * @author Dan
     */
    public  void init(){
        Container container=getContentPane();//获取窗口的主容器     |   get main windows
        File dir =new File("src/img/picture");//获取素材 | get photo in path
        list =dir.listFiles();//获取图片中的所有文件      |       get all photos
        centerPane1 = new BackgroundPanel(getListImage());//获取第一张照片   |   get the1first photo
        container.add(centerPane1, BorderLayout.CENTER);//把获取的图片放在正中央   |   add  photo to the center of container
        FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);//右对齐
        flowLayout.setHgap(20);//水平间隔20像素

        JPanel southPane1 = new JPanel();
        southPane1.setLayout(flowLayout);//使用建好的布局流 |   use it
        changeButton =new JButton("更改图片");
        southPane1.add(changeButton);
        hiddenButton = new JButton("隐藏");
        southPane1.add(hiddenButton);
        container.add(southPane1, BorderLayout.SOUTH);


    }

    /**
     * 监听事件 |   add listener
     * @author Dan
     */
    private void addListener(){
        hiddenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//单击
                setVisible(false);//隐藏  |hidden
                frame.initShowPictureButton();/*父类窗体还原简笔画按钮的文本*/
            }
        });
        changeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                centerPane1.setImage(getListImage());
            }
        });

    }

    private Image getListImage() {
        String imgPath=list[index].getAbsolutePath();//获取当前索引下的图片文件路径   |   get the path of  this   photo
        ImageIcon imageIcon = new ImageIcon(imgPath);
        index++;
        if (index >= list.length) {
            index=0;
        }
        return imageIcon.getImage();//获取图表对象的图片对象   |   get photo
    }
}
