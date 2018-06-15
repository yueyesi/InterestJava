import test.TestPack;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * 监控某个目录下的文件变化
 * Created by Administrator on 2018/6/16 0016.
 */

/**
 * 目录过滤器
 */
class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}

public class Hello {
    public static void main(String[] args) {
//        File path = new File("D:/file");
//        String[] list = path.list();
//        for (String item : list) {
//            System.out.println(item);
//        }
        TestPack test = new TestPack();
        test.test();
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    System.out.println("\n\n\n");
                    System.out.println("monitor file list changes");
                    File path = new File("D:/file");
                    String[] list = path.list(new DirFilter(".+\\.mp4"));
                    for (String item : list) {
                        System.out.println(item);
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
        System.out.println("Hello");
    }
}
