package BUS;

import DTO.ReportDTO;
import GUI.GUIapp;
import static GUI.GUIapp.arrRep;
import static GUI.GUIapp.tb1Model;
import static GUI.GUIapp.tb2Model;
import com.impinj.octane.*;
import java.util.Scanner;

public class ReadTags {

    //public void main() {
    public static void main(String[] args) {
    
        try {
            //String hostname = System.getProperty(SampleProperties.hostname);
            String hostname = "169.254.96.13";
            
            if (hostname == null) {
                throw new Exception("Must specify the '" + SampleProperties.hostname + "' property");
            }

            ImpinjReader reader = new ImpinjReader();

            System.out.println("Connecting");
            reader.connect(hostname);

            Settings settings = reader.queryDefaultSettings();

            //lấy kết quả các dòng output
            ReportConfig report = settings.getReport();
            report.setIncludeAntennaPortNumber(true);
            report.setMode(ReportMode.Individual);
            report.setIncludeFirstSeenTime(true);
            report.setIncludeLastSeenTime(true);
            report.setIncludePeakRssi(true);

            // The reader can be set into various modes in which reader
            // dynamics are optimized for specific regions and environments
            // The following mode, AutoSetDenseReader, monitors RF noise and interference and then automatically
            // and continuously optimizes the reader's configuration
            settings.setReaderMode(ReaderMode.AutoSetDenseReader); //dieu khien dau doc RFID

//            settings.getAutoStart().setMode(AutoStartMode.Periodic);
//            settings.getAutoStart().setPeriodInMs(2000);
//            settings.getAutoStop().setMode(AutoStopMode.Duration);
//            settings.getAutoStop().setDurationInMs(2000);

            // set some special settings for antenna 1
            AntennaConfigGroup antennas = settings.getAntennas();
            antennas.disableAll();
            antennas.enableById(new short[]{1});
            antennas.getAntenna((short) 1).setIsMaxRxSensitivity(false);
            antennas.getAntenna((short) 1).setIsMaxTxPower(false);
            antennas.getAntenna((short) 1).setTxPowerinDbm(20.0);   
            antennas.getAntenna((short) 1).setRxSensitivityinDbm(-70); 

            //reader.setTagReportListener(new TagReportListenerImplementation());
            reader.setTagReportListener(new MyTagReportListener());

            System.out.println("Applying Settings");
            reader.applySettings(settings);

            System.out.println("Starting");
            reader.start();

            System.out.println("Press Enter to exit.");
            Scanner s = new Scanner(System.in);
            s.nextLine();
            
            reader.stop();
            reader.disconnect();
            
        } catch (OctaneSdkException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }
}
