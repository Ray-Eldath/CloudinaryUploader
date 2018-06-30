package ray.eldath.cu.main;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Eldath on 2017/3/11 0011.
 *
 * @author Ray Eldath
 * @version 1.0.0
 */
public class Main {
	/**
	 * <strong>!PLEASE READ README.MD FIRST TO CONFIRM THAT YOU HAS BEEN PROPERLY CONFIGURED Config.java FILE!</strong>
	 */
	private static List<File> allFiles = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		Map<String, Object> config = new HashMap<>();
		config.put("cloud_name", Config.CLOUD_NAME);
		config.put("api_key", Config.API_KEY);
		config.put("api_secret", Config.API_SECRET);
		config.put("secure", Config.EMBEDDED_SSL);
		if (Config.USE_ORIGINAL_FILENAME) {
			config.put("invalidate", true);
			config.put("use_filename", true);
			config.put("unique_filename", false);
		}
		Cloudinary cloudinary = new Cloudinary(config);
		Uploader uploader = cloudinary.uploader();
		getAllFiles();
		System.out.println("Start file uploading, from " + Config.PATH + ":");
		System.out.println("!DO NOT CLOSE THIS WINDOW UNTIL UPLOAD IS FINISHED!");
		System.out.println("!THIS MAY COST FIVE MINUTES TIME!");
		Map<String, Object> thisConfig = config;
		for (File thisFile: allFiles) {
			String publicId;
			if (Config.WITH_FILE_PATH)
				publicId = thisFile.getPath().replace("\\", "/")
						.replace(Config.PATH, "")
						.replace("." + thisFile.getName().split("\\.")[1], "")
						.substring(1);
			if (!Config.PREFIX.isEmpty())
				if (!Config.WITH_FILE_PATH) publicId = Config.PREFIX + "/" + thisFile.getName();
				else publicId = Config.PREFIX + "/" + publicId;
			thisConfig.put("public_id", publicId);
			Map updateResult = uploader.upload(thisFile, thisConfig);
			String url;
			if (Config.EMBEDDED_SSL) url = (String) updateResult.get("secure_url");
			else url = (String) updateResult.get("url");
			System.out.println("\t> File " + thisFile.getName() + " is uploaded at " +
					url.replace("/v" + updateResult.get("version"), ""));
			thisConfig = config;
		}
		System.out.println("File upload finished.");
	}

	private static void getAllFiles() {
		File file = new File(Config.PATH);
		File[] files = file.listFiles();
		if (files == null) return;
		for (File thisFile: files)
			listOnePath(thisFile);
		//
		if (!Config.DEBUG) return;
		for (File thisFile: allFiles)
			System.out.println(thisFile);
		System.out.println("Total: " + allFiles.size());
	}

	private static void listOnePath(File path) {
		File[] files = path.listFiles();
		if (files == null) return;
		for (File thisFile: files) {
			if (thisFile.isFile())
				allFiles.add(thisFile);
			listOnePath(thisFile);
		}
	}
}
