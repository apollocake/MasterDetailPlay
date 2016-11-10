package com.example.jack.masterdetailplay;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DirectoryModel {
    /**
     * An array of sample (dummy) items.
     */
    public static final List<FileItem> ITEMS = new ArrayList<FileItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, FileItem> ITEM_MAP = new HashMap<String, FileItem>();


    private static final int COUNT = 25;
    private static File dataFile;
    private static PrintWriter pWriter;
    private static BufferedReader br;
    private static StringBuilder builder = new StringBuilder();
    private static String sCurrentLine;

    //create files
    static {

    }

    //add files to array
    static {

    }

    public static void setupFiles(Context context) {
        // create files to list.
        File root = android.os.Environment.getExternalStorageDirectory();
        //mResultsView.append("\nExternal file system root: " + root);

        //set file up for writing
        File baseDir = new File(context.getExternalCacheDir(), "SensorData");
        boolean success = baseDir.mkdirs();


            try {
                for (int i = 1; i <= COUNT; i++) {
                    dataFile = new File(baseDir, "band_accel.txt " + i);
                    pWriter = new PrintWriter(new BufferedWriter(new FileWriter(dataFile), 8192));
                    pWriter.print("test");
                    pWriter.flush();
                }
                pWriter.close();
                pWriter = null;
            } catch (IOException e) {
                e.printStackTrace();
            }

        // Add files to array
        File[] fileList = baseDir.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            addItem(createDummyItem(fileList, i));
        }
    }

    private static void addItem(FileItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static FileItem createDummyItem(File[] files, int i) {
        //id or index, content or viewed string, details in detail view
        return new FileItem(String.valueOf(i), files[i].getName(), makeDetails(files[i]));
    }

    private static String makeDetails(File file) {
        sCurrentLine = null;
        builder.setLength(0);
        builder.append("File contents: \n");
        try {
            br = new BufferedReader(new FileReader(file), 1024);



            while ((sCurrentLine = br.readLine()) != null) {
                builder.append(sCurrentLine);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class FileItem {
        public final String id;
        public final String content;
        public final String details;

        public FileItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
