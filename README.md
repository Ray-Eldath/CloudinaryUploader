# CloudinaryUploader
A tool which can upload any files to Cloudinary.

## Usage
1. New `Config.java` file in `src\java\eldath\CloudinaryUploader\main` (`Main.java` is in the same folder)
2. Config `Config.java` like:
```Java
package eldath.CloudinaryUploader.main;

class Config {
    static final String CLOUD_NAME = "YOUR_CLOUD_NAME";
    static final String API_KEY = "YOUR_API_KEY";
    static final String API_SECRET = "YOUR_API_SECRET";
    static final String PATH = "C:/IMG";
    static final String PREFIX = "";
    static final boolean WITH_FILE_PATH = true;
    static final boolean USE_ORIGINAL_FILENAME = true;
    static final boolean EMBEDDED_SSL = true;
    static final boolean DEBUG = false;
}
```
3. Compile and run `Main.java`.
4. Enjoy!

**Importance: Please config `Config.java` file with illustration in *Chapter: Configure* !**

## Configuration
In this section we will config the `Config.java` file. First is the explanation.

> ```
> static final String CLOUD_NAME = "YOUR_CLOUD_NAME";
> static final String API_KEY = "YOUR_API_KEY";
> static final String API_SECRET = "YOUR_API_SECRET";
> ```
> You will get your CLOUD_NAME API_KEY and API_SECRET on [here](https://cloudinary.com/console).

> ```
> static final String PATH = "F:/Code/IMG";
> ```
> Upload image/file from where. Must be absolute path.

> ```
> static final String PREFIX = "";
> ```
> The prefix before image url.
> e.g. If the prefix is "eldath", than the URL will be `http://res.cloudinary.com/.../image/upload/eldath/...png` instead of  `http://res.cloudinary.com/.../image/upload/...png`.

> ```
> static final boolean WITH_FILE_PATH = true;
> ```
> Contain file path in the URL or not.
> e.g. If true, than the URL will be `http://res.cloudinary.com/.../image/upload/eldath/folder-1/folder-2/file.png`.

> ```
> static final boolean USE_ORIGINAL_FILENAME = true;
> ```
> Use original filename in the URL or contain a random suffix.
> e.g. If true, than the URL will like: `http://res.cloudinary.com/.../image/upload/demo-axrgfzf.png` instead of `http://res.cloudinary.com/.../image/upload/demo.png`.

> ```
> static final boolean EMBEDDED_SSL = true;
> ```
> Use HTTPS(SSL over HTTP) or not.
> e.g. If true, the URL will begin with `https://` instead of `http://`.

> ```
> static final boolean DEBUG = false;
> ```
> Only for developers.

# That's all