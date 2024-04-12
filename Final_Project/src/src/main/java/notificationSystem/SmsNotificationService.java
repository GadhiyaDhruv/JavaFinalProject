package notificationSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import transferObject.UserDTO;

public class SmsNotificationService implements NotificationService {

    private static final String SMS_API_URL = "https://example.com/sms_api";
    private static final String SMS_API_KEY = "your_sms_api_key";

    @Override
    public void sendNotification(UserDTO user, String message) {
        try {
            String url = SMS_API_URL + "?apikey=" + SMS_API_KEY + "&to=" + user.getPhoneNumber() + "&message=" + message;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("SMS notification sent successfully to " + user.getPhoneNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
