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
 * @time 2018��9��13��09:56:53
 * @vision 1.0
 * ͼƬ������
 */
public class DealwithPhotos {
    /**
     * @param src  ԴͼƬ�洢λ��
     * @param dest ���ź�ͼƬ�洢λ��
     * @param w    Ŀ��ͼƬ��
     * @param h    Ŀ��ͼƬ��
     * @throws Exception  io��д�쳣
     */
    public static void zoomImage(String src,String dest,int w,int h) throws Exception {
        
        double wr=0,hr=0;
        File srcFile = new File(src);
        File destFile = new File(dest);

        BufferedImage bufImg = ImageIO.read(srcFile); //��ȡͼƬ
        System.out.println(""+bufImg);
        Image Itemp = bufImg.getScaledInstance(w, h, bufImg.SCALE_SMOOTH);//��������Ŀ��ͼƬģ��
        
        wr=w*1.0/bufImg.getWidth();     //��ȡ���ű���
        hr=h*1.0 / bufImg.getHeight();
        System.out.println(wr+"��-"+bufImg.getWidth());
        System.out.println(hr+"��-"+bufImg.getHeight());
        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
        Itemp = ato.filter(bufImg, null);
        try {
            ImageIO.write((RenderedImage) Itemp,dest.substring(dest.lastIndexOf(".")+1), destFile); //д���������ͼƬ
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * ����ͼƬ����ͼ,������(�ȱ�����,�ﵽЧ��)
     * 
     * @param src
     *            ԴͼƬ�ļ�����·��
     * @param dist
     *            Ŀ��ͼƬ�ļ�����·��
     * @param width
     *            ���ŵĿ��
     * @param height
     *            ���ŵĸ߶�
     */
    public static void createThumbnail(String src, String dist, float width,float height) {
        try {
            File srcfile = new File(src); 
            if (!srcfile.exists()) {
                System.out.println("�ļ�������");
                return;
            }
            BufferedImage image = ImageIO.read(srcfile);

            // ������ŵı���
            double ratio = 1.0;
            // �ж�����ߡ����������趨ֵ���򲻴���
            if (image.getHeight() > height || image.getWidth() > width) {
                if (image.getHeight() > image.getWidth()) {
                    ratio = height / image.getHeight();
                } else {
                    ratio = width / image.getWidth();
                }
            }
            // �����µ�ͼ���Ⱥ͸߶�
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
            System.out.println("��������ͼ�����쳣" + e.getMessage());
        }
    }
    
    /** 
     * ͼƬ���� 
     * @param filePath ͼƬ·�� 
     * @param destPath
     * @param height �߶� 
     * @param width ��� 
     * @param bb ��������ʱ�Ƿ���Ҫ���� 
     */  
    public static void resize(String filePath, String destPath,int height, int width, boolean bb) {  
        try {  
            double ratio = 0; //���ű���      
            File f = new File(filePath); 
            File d = new File(destPath);
            BufferedImage bi = ImageIO.read(f);     
            Image itemp = bi.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);     
            //�������     
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
