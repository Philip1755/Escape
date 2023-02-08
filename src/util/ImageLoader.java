package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageLoader {

	private static HashMap<String, BufferedImage> sprites = new HashMap<>();
	
	public static boolean hasSprite(String parentFolder, String fileName) {
		File tmp = new File("./res/" + parentFolder + "/" + fileName);
		
		return ImageLoader.sprites.containsKey(tmp.getAbsolutePath());
	}

	public static BufferedImage getSprite(String parentFolder, String fileName) {
		File tmp = new File("./res/" + parentFolder + "/" + fileName);
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(tmp.getAbsoluteFile());
		} catch (IOException e) {
			e.printStackTrace();
            System.exit(-1);
		}
		
		if (!ImageLoader.hasSprite(parentFolder, fileName))
            ImageLoader.addSprite(parentFolder, fileName, img);
		
		return ImageLoader.sprites.get(tmp.getAbsolutePath());
	}

	private static void addSprite(String parentFolder, String fileName, BufferedImage img) {
		File file = new File("./res/" + parentFolder + "/" + fileName);
		
        if(!ImageLoader.hasSprite(parentFolder, fileName))
        	ImageLoader.sprites.put(file.getAbsolutePath(), img);
        else {
            System.out.println("AssetPool already has asset: " + file.getAbsolutePath());
            System.exit(-1);
        }
	}
}