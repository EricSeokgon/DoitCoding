package elice;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.Map;
import java.util.HashMap;;
import javax.xml.bind.DatatypeConverter;
class EliceUtilException extends Exception {
    public EliceUtilException(String message) {
        super(message);
    }
}
public class EliceUtils {
    private String _executionToken;
    private String _executorIp;
    private String _executorComPort;
    private String _otpKey;
    private void _send(String url, HashMap < String, String > data) throws EliceUtilException {
        try{
            URL reqUrl = new URL(url);
            HttpURLConnection reqConn = (HttpURLConnection) reqUrl.openConnection();
            reqConn.setRequestMethod("POST");
            reqConn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            StringBuilder dataEncodedBuilder = new StringBuilder();
            for(Map.Entry<String, String> param : data.entrySet()){
                if(dataEncodedBuilder.length() > 0){
                    dataEncodedBuilder.append('&');
                }
                dataEncodedBuilder.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                dataEncodedBuilder.append("=");
                dataEncodedBuilder.append(URLEncoder.encode(param.getValue(), "UTF-8"));
            }
            reqConn.setDoOutput(true);
            DataOutputStream outputStream = new DataOutputStream(reqConn.getOutputStream());
            outputStream.writeBytes(dataEncodedBuilder.toString());
            outputStream.flush();
            outputStream.close();
            BufferedReader responseReader = new BufferedReader(
                    new InputStreamReader(reqConn.getInputStream()));
            responseReader.close();
            reqConn.disconnect();
        } catch (MalformedURLException ex) {
            throw new EliceUtilException("Invalid URL format.");
        } catch (IOException ex) {
            throw new EliceUtilException("Failed to send message to elice.");
        }
    }
    private String _handleImage(String filepath) throws EliceUtilException {
        try {
            Path path = Paths.get(filepath);
            String mtype = Files.probeContentType(path);
            if (mtype == null || !mtype.startsWith("image/")) {
                throw new EliceUtilException("Invalid image filepath.");
            }
            byte[] fileContent = Files.readAllBytes(path);
            String fileContentBase64 = DatatypeConverter.printBase64Binary(fileContent);
            return String.format("data:%s;base64,%s",
                    mtype,
                    fileContentBase64);
        } catch (InvalidPathException ex) {
            throw new EliceUtilException("Cannot open given filepath.");
        } catch (IOException ex) {
            throw new EliceUtilException("Cannot read the file.");
        }
    }
    private String _handleFile(String filepath) throws EliceUtilException {
        try {
            Path path = Paths.get(filepath);
            String mtype = Files.probeContentType(path);
            if (mtype == null) {
                mtype = "application/octet-stream";
            }
            byte[] fileContent = Files.readAllBytes(path);
            String fileContentBase64 = DatatypeConverter.printBase64Binary(fileContent);
            return String.format("%s;data:%s;base64,%s",
                    path.getFileName(),
                    mtype,
                    fileContentBase64);
        } catch (InvalidPathException ex) {
            throw new EliceUtilException("Cannot open given filepath.");
        } catch (IOException ex) {
            throw new EliceUtilException("Cannot read the file.");
        }
    }
    public EliceUtils() {
        _executionToken = System.getenv("EXECUTION_TOKEN");
        _executorIp = System.getenv("EXECUTOR_IP");
        _executorComPort = System.getenv("EXECUTOR_COM_PORT");
    }
    void send(String msgType, String msgData) throws EliceUtilException {
        HashMap < String, String > data = new HashMap < String, String > ();
        data.put("type", msgType);
        data.put("data", msgData);
        _send(String.format("http://%s:%s/comm/send/%s",
                _executorIp, _executorComPort, _executionToken),
                data);
    }
    void sendImage(String filepath) throws EliceUtilException {
        send("image", _handleImage(filepath));
    }
    void sendFile(String filepath) throws EliceUtilException {
        send("file", _handleFile(filepath));
    }
    void secureInit() throws EliceUtilException {
        try{
            URL reqUrl = new URL(String.format("http://%s:%s/comm/secure/init/%s",
                    _executorIp, _executorComPort, _executionToken));
            HttpURLConnection reqConn = (HttpURLConnection) reqUrl.openConnection();
            BufferedReader responseReader = new BufferedReader(
                    new InputStreamReader(reqConn.getInputStream()));
            _otpKey = responseReader.readLine();
            responseReader.close();
            reqConn.disconnect();
        } catch (MalformedURLException ex) {
            throw new EliceUtilException("Invalid URL format.");
        } catch (IOException ex) {
            throw new EliceUtilException("Failed to send message to elice.");
        }
    }
    void secureSend(String msgType, String msgData) throws EliceUtilException {
        HashMap < String, String > data = new HashMap < String, String > ();
        data.put("type", msgType);
        data.put("data", msgData);
        _send(String.format("http://%s:%s/comm/secure/send/%s/%s",
                _executorIp, _executorComPort, _executionToken, _otpKey),
                data);
    }
    void secureSendImage(String filepath) throws EliceUtilException {
        secureSend("image", _handleImage(filepath));
    }
    void secureSendFile(String filepath) throws EliceUtilException {
        secureSend("file", _handleFile(filepath));
    }
    void secureSendGrader(String msg) throws EliceUtilException {
        secureSend("grader", msg);
    }
    void secureSendScore(int score) throws EliceUtilException {
        secureSend("score", String.valueOf(score));
    }
}
