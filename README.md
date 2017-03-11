# CloudinaryUploader
A tool which can upload any files to Cloudinary.

## Usage
1. New `Config.java` file in `src\java\eldath\CloudinaryUploader\main` (`Main.java` is in the same folder)
2. Config `Config.java` like:
```Java
package eldath.CloudinaryUploader.main;

/**
 * Created by Eldath on 2017/3/11 0011.
 *
 * @author Eldath Ray
 */
public class Config {
    static final String CLOUD_NAME = "ray-eldath";
    static final String API_KEY = "674491988881849";
    static final String API_SECRET = "3N4hWmieiPymrFkPnWAsJ2_Qek4";
    static final String PATH = "F:/Code/IMG";
    static final String PREFIX = "";
    static final boolean WITH_FILE_PATH = true;
    static final boolean USE_ORIGINAL_FILENAME = true;
    /**
     * If true, than the URL will like: http://res.cloudinary.com/.../image/upload/demo-axrgfzf.png
     * else http://res.cloudinary.com/.../image/upload/demo.png
     */
    static final boolean EMBEDDED_SSL = true;
    static final boolean USE_FILENAME = true;
    static final boolean DEBUG = false;
}

}

```

