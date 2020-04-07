import java.io.IOException;
import java.io.BufferedReader;
import  java.io.FileReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Prog1 {

    public static void main(String[] args) {
        int i = 0, k = 0, koef1 = 4, koef2 = 2, sms; double sum = 0, b, koefsms = 1.5;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;

        LocalTime timenum = LocalTime.now();
        LocalTime tarifone = LocalTime.of(0, 30, 0);

        BufferedReader br = null;
        StringBuffer timestamp = new StringBuffer("");
        StringBuffer msisdn_origin = new StringBuffer("");
        StringBuffer msisdn_dest = new StringBuffer("");
        StringBuffer call_duration = new StringBuffer("");
        StringBuffer sms_number = new StringBuffer("");
        try {
            br = new BufferedReader(new FileReader("data.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                if (k != 0) {

                for (String retval : line.split(",")) {
                    switch (i) {

                        case 0: {
                            timestamp.insert(0, retval);
                            break;
                        }
                        case 1: {
                            msisdn_origin.insert(0, retval);
                            break;
                        }
                        case 2: {
                            msisdn_dest.insert(0, retval);
                            break;
                        }
                        case 3: {
                            call_duration.insert(0, retval);
                            break;
                        }
                        case 4: {
                            sms_number.insert(0, retval);
                            break;
                        }
                    }


                    i++;
                }
                    int index1 = timestamp.indexOf(" ");
                timestamp.delete(0, index1+1);
                timenum = LocalTime.parse(timestamp, dateTimeFormatter);

                i = 0;
                if (msisdn_origin.toString().equals("933156729")) {

                    if (timenum.isAfter(tarifone)) {
                        b = Double.parseDouble(call_duration.toString());
                        sms = Integer.parseInt(sms_number.toString());
                        sum = sum + b*koef2 + sms*koefsms;

                    } else {
                        b = Double.parseDouble(call_duration.toString());
                        sms = Integer.parseInt(sms_number.toString());
                        sum = sum + b*koef1 + sms*koefsms;
                    }

                }

                if (msisdn_dest.toString().equals("933156729")) {

                    if (timenum.isAfter(tarifone)) {
                        b = Double.parseDouble(call_duration.toString());
                        sms = Integer.parseInt(sms_number.toString());
                        sum = sum + b*koef2 + sms*koefsms;

                    } else {
                        b = Double.parseDouble(call_duration.toString());
                        sum = sum + b*koef1;
                    }
                }
                timestamp.setLength(0);
                msisdn_dest.setLength(0);
                msisdn_origin.setLength(0);
                call_duration.setLength(0);
                sms_number.setLength(0);
            }
k++;
            }
        } catch (IOException e) {
            System.out.println("Error" + e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Error" + e);
            }

        }
System.out.println(sum);
    }
}

