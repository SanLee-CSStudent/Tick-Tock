package GUI;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Serializer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings({ "resource", "unchecked" })
	public Serializer(File file) {
		try {
			ObjectInputStream bin = new ObjectInputStream(new FileInputStream(new File("TICKTOCK_lib\\image.tock")));
			
			byteArrays = (ArrayList<byte[]>) bin.readObject();
			
			images = new ArrayList<BufferedImage>();
			
			for(int i = 0; i < byteArrays.size(); i++) {
				images.add(readImage(byteArrays.get(i)));
			}
			bin.close();
			// ImageIO.read(new File("TICKTOCK_lib\\image.tock"));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@SuppressWarnings("resource")
	public Serializer(ArrayList<BufferedImage> images) {
		// TODO Auto-generated constructor stub
		byteArrays = new ArrayList<byte[]>();
		
		try {
			for(int i = 0; i < images.size(); i++) {	
				byteArrays.add(writeImage(images.get(i)));
			}
			
			ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(new File("TICKTOCK_lib\\image.tock")));
			save.writeObject(byteArrays);
			save.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public final byte[] writeImage(BufferedImage image) throws IOException {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
        ImageIO.write(image, "png", bout);
        this.imagebytes = bout.toByteArray();
        
        bout.close();
        
        return this.imagebytes;
	}
	
	public final BufferedImage readImage(byte[] bytes) throws IOException {
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
		
		return img;
	}
	
	public ArrayList<byte[]> getByteArray(){
		
		return byteArrays;
	}
	
	public ArrayList<BufferedImage> getImageArray(){
		
		return images;
	}
	
	private byte[] imagebytes;
	ArrayList<BufferedImage> images;
	ArrayList<byte[]> byteArrays;
}
