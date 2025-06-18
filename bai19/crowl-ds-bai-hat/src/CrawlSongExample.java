import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {
        String urlStr = "https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html";
        try {
            URL url = new URL(urlStr);
            Scanner sc = new Scanner(new InputStreamReader(url.openStream(), "UTF-8"));
            sc.useDelimiter("\\Z");
            String content = sc.next();
            sc.close();
            content = content.replaceAll("\\n+", "");
            String regex = "name_song\\\">(.*?)</a>";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(content);
            System.out.println("Danh sach bai hat");
            int count = 0;
            while (matcher.find()) {
                String title = matcher.group(1).trim();
                System.out.println(++count + " : " + title);
                if (count >= 20) break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
