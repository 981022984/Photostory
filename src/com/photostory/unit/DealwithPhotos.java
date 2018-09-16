package com.photostory.unit;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @author zuo
 * @time 2018年9月13日09:56:53
 * @vision 1.0
 * 图片处理工具
 */
public class DealwithPhotos {
    /**
     * @param src  源图片存储位置
     * @param dest 缩放后图片存储位置
     * @param w    目标图片宽
     * @param h    目标图片高
     * @throws Exception  io读写异常
     */
    public static void zoomImage(String src,String dest,int w,int h) throws Exception {
        
        double wr=0,hr=0;
        File srcFile = new File(src);
        File destFile = new File(dest);

        BufferedImage bufImg = ImageIO.read(srcFile); //读取图片
        System.out.println(""+bufImg);
        Image Itemp = bufImg.getScaledInstance(w, h, bufImg.SCALE_SMOOTH);//设置缩放目标图片模板
        
        wr=w*1.0/bufImg.getWidth();     //获取缩放比例
        hr=h*1.0 / bufImg.getHeight();
        System.out.println(wr+"高-"+bufImg.getWidth());
        System.out.println(hr+"高-"+bufImg.getHeight());
        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
        Itemp = ato.filter(bufImg, null);
        try {
            ImageIO.write((RenderedImage) Itemp,dest.substring(dest.lastIndexOf(".")+1), destFile); //写入缩减后的图片
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * 创建图片缩略图,不补白(等比缩放,达到效果)
     * 
     * @param src
     *            源图片文件完整路径
     * @param dist
     *            目标图片文件完整路径
     * @param width
     *            缩放的宽度
     * @param height
     *            缩放的高度
     */
    public static void createThumbnail(String src, String dist, float width,float height) {
        try {
            File srcfile = new File(src); 
            if (!srcfile.exists()) {
                System.out.println("文件不存在");
                return;
            }
            BufferedImage image = ImageIO.read(srcfile);

            // 获得缩放的比例
            double ratio = 1.0;
            // 判断如果高、宽都不大于设定值，则不处理
            if (image.getHeight() > height || image.getWidth() > width) {
                if (image.getHeight() > image.getWidth()) {
                    ratio = height / image.getHeight();
                } else {
                    ratio = width / image.getWidth();
                }
            }
            // 计算新的图面宽度和高度
            int newWidth = (int) (image.getWidth() * ratio);
            int newHeight = (int) (image.getHeight() * ratio);

            BufferedImage bfImage = new BufferedImage(newWidth, newHeight,
                    BufferedImage.TYPE_INT_RGB);
            bfImage.getGraphics().drawImage(
                    image.getScaledInstance(newWidth, newHeight,
                            Image.SCALE_SMOOTH), 0, 0, null);

            FileOutputStream os = new FileOutputStream(dist);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
            encoder.encode(bfImage);
            os.close();
        } catch (Exception e) {
            System.out.println("创建缩略图发生异常" + e.getMessage());
        }
    }
    
    /** 
     * 图片缩放 
     * @param filePath 图片路径 
     * @param destPath
     * @param height 高度 
     * @param width 宽度 
     * @param bb 比例不对时是否需要补白 
     */  
    public static void resize(String filePath, String destPath,int height, int width, boolean bb) {  
        try {  
            double ratio = 0; //缩放比例      
            File f = new File(filePath); 
            File d = new File(destPath);
            BufferedImage bi = ImageIO.read(f);     
            Image itemp = bi.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);     
            //计算比例     
            if ((bi.getHeight() > height) || (bi.getWidth() > width)) {     
                if (bi.getHeight() > bi.getWidth()) {     
                    ratio = (new Integer(height)).doubleValue() / bi.getHeight();     
                } else {     
                    ratio = (new Integer(width)).doubleValue() / bi.getWidth();     
                }     
                AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);     
                itemp = op.filter(bi, null);     
            } 
            
            if (bb) {     
                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);     
                Graphics2D g = image.createGraphics();     
                g.setColor(Color.white);     
                g.fillRect(0, 0, width, height);     
                if (width == itemp.getWidth(null))     
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);     
                else    
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);     
                g.dispose();     
                itemp = image;     
            }  
            ImageIO.write((BufferedImage) itemp, destPath.substring(destPath.lastIndexOf(".")+1), d); 
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    } 
}
