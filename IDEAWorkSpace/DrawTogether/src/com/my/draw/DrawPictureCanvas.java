package com.my.draw;

import java.awt.*;

public class DrawPictureCanvas extends Canvas {
    private Image image = null;/*创建画板中的展示的图片对象*/

    /**
     * 设置画板的图片
     *
     * @pragam image-画板中展示的图片
     */
    public void setImage(Image image) {
        this.image=image;
    }

    /**
     * 重写paint方法
     */
    public void paint(Graphics graphics) {
        graphics.drawImage(this.image,0,0,null);/*在画布上绘制图象*/
    }
    /**
     * 重写update方法，解决屏幕闪烁
     */
    public void update (Graphics graphics){
        paint(graphics);
    }

}
