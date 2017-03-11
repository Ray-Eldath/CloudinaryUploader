package main;

import java.io.File;

/**
 * Created by Eldath on 2017/3/11 0011.
 *
 * @author Eldath Ray
 */
public class Test {
    private static final String PERFIX = "eldath";
    private static final boolean WITH_FILE_PATH = true;
    private static final String PATH = "F:/Code/IMG";

    public static void main(String[] args) throws Exception {
        File thisFile = new File("F:\\Code\\IMG\\in-post\\talk-about-cryptography\\TAC0002.png");
        System.out.println(thisFile.getPath().replace("\\", "/").replace(PATH, "").substring(1));
        //
        String publicId = thisFile.getName();
        if (WITH_FILE_PATH)
            publicId = thisFile.getPath().replace("\\", "/").replace(PATH, "").substring(1);
        if (!PERFIX.isEmpty())
            if (!WITH_FILE_PATH) publicId = PERFIX + "/" + thisFile.getName();
            else publicId = PERFIX + "/" + publicId;

        System.out.println("Final: " + publicId);
    }
}
