package projeto.tcc;
import java.io.IOException;
import java.net.URL;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import javazoom.jl.player.Player;

@Named
@ViewScoped
public class MusicBean {
	
	Player mp3player = null;
	SourceDataLine line = null;
	private static boolean stopped = false;
	
//	 public String play() {
//        String song = "http://www.ntonyx.com/mp3files/Morning_Flower.mp3";
//        BufferedInputStream in = null;
//        try {
//          in = new BufferedInputStream(new URL(song).openStream());
//          
//          
//          
//          
//          mp3player = new Player(in);
//          mp3player.play();
//        } catch (MalformedURLException ex) {
//        } catch (IOException e) {
//        } catch (JavaLayerException e) {
//        } catch (NullPointerException ex) {
//        }
//        return"";
//
//}
//	
	public void play2(){
	    try {
	        AudioInputStream in= AudioSystem.getAudioInputStream(new URL("http://www.ntonyx.com/mp3files/Morning_Flower.mp3"));
	        AudioInputStream din = null;
	        AudioFormat baseFormat = in.getFormat();
	        AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
	                baseFormat.getSampleRate(),
	                16,
	                baseFormat.getChannels(),
	                baseFormat.getChannels() * 2,
	                baseFormat.getSampleRate(),
	                false);
	        din = AudioSystem.getAudioInputStream(decodedFormat, in);
	        // Play now.
	        stopped = false;
	        rawplay(decodedFormat, din);
	        in.close();
	    } catch (Exception e){
	        e.printStackTrace();
	    }
	}

	@SuppressWarnings("unused")
	private  void rawplay(AudioFormat targetFormat, AudioInputStream din) throws LineUnavailableException, IOException{
	    try{
	        byte[] data = new byte[4096];
	        line = getLine(targetFormat);
	        if (line != null)
	        {
	            // Start
	            line.start();
	            int nBytesRead = 0, nBytesWritten = 0;
	            while (nBytesRead != -1 && !stopped)
	            {
	                nBytesRead = din.read(data, 0, data.length);
	                if (nBytesRead != -1) nBytesWritten = line.write(data, 0, nBytesRead);
	            }
	            // Stop
	            line.drain();
	            line.stop();
	            line.close();
	            din.close();
	        }
	    }catch(IOException e){
	        e.printStackTrace();
	    }
	}
	
	public void stop(){

		stopped = true;
		
	}
	
	

	private SourceDataLine getLine(AudioFormat audioFormat) throws LineUnavailableException{
	    try{
	        SourceDataLine res = null;
	        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
	        res = (SourceDataLine) AudioSystem.getLine(info);
	        res.open(audioFormat);
	        return res;
	    }catch(LineUnavailableException e){
	        e.printStackTrace();
	        return null;
	    }
	} 

	
}
