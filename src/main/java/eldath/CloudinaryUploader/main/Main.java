package eldath.CloudinaryUploader.main;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;

import java.io.File;
import java.util.*;

import static eldath.CloudinaryUploader.main.Config.*;

/**
 * Created by Eldath on 2017/3/11 0011.
 *
 * @author Eldath Ray
 * @version 0.0.1
 */
public class Main {
    // !PLEASE READ README.MD FIRST TO CONFIRM THAT YOU HAS BEEN PROPERLY CONFIGURED Config.java FILE!
    private static List<File> allFiles = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Map<String, Object> config = new HashMap<>();
        config.put("cloud_name", CLOUD_NAME);
        config.put("api_key", API_KEY);
        config.put("api_secret", API_SECRET);
        config.put("use_filename", USE_FILENAME);
        config.put("secure", EMBEDDED_SSL);
        if (USE_ORIGINAL_FILENAME) {
            config.put("invalidate", true);
            config.put("use_filename", true);
            config.put("unique_filename", false);
        }
        Cloudinary cloudinary = new Cloudinary(config);
        Uploader uploader = cloudinary.uploader();
        getAllFiles();
        System.out.println("Start file uploading, from " + PATH + ":");
        System.out.println("!DO NOT CLOSE THIS WINDOW UNTIL UPLOAD IS FINISHED!");
        System.out.println("!THIS MAY COST FIVE MINUTES TIME!");
        Map<String, Object> thisConfig = config;
        for (File thisFile : allFiles) {
            String publicId = thisFile.getName();
            if (WITH_FILE_PATH)
                publicId = thisFile.getPath().replace("\\", "/").replace(PATH, "").substring(1);
            if (!PREFIX.isEmpty())
                if (!WITH_FILE_PATH) publicId = PREFIX + "/" + thisFile.getName();
                else publicId = PREFIX + "/" + publicId;
            thisConfig.put("public_id", publicId);
            Map updateResult = uploader.upload(thisFile, thisConfig);
            String url;
            if (EMBEDDED_SSL) url = (String) updateResult.get("secure_url");
            else url = (String) updateResult.get("url");
            System.out.println("File " + thisFile.getName() + " is uploaded at " +
                    url.replace("/v" + updateResult.get("version"), ""));
            thisConfig = config;
        }
        System.out.println("File upload finished.");
    }

    private static void getAllFiles() {
        File file = new File(PATH);
        File[] files = file.listFiles();
        if (files == null) return;
        for (File thisFile : files)
            listOnePath(thisFile);
        //
        if (!DEBUG) return;
        for (File thisFile : allFiles)
            System.out.println(thisFile);
        System.out.println("Total: " + allFiles.size());
    }

    private static void listOnePath(File path) {
        File[] files = path.listFiles();
        if (files == null) return;
        for (File thisFile : files) {
            if (thisFile.isFile())
                allFiles.add(thisFile);
            listOnePath(thisFile);
        }
    }
}
