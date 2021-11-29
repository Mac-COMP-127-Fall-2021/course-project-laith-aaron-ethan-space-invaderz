import java.io.File;

import javax.sound.sampled.*;

public class SoundEffect {

    // static File pew = new File("Pew.wav");


    public static void PlaySound() {

        File lol = new File("Pew.wav");

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(lol));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// try {
// Clip clip = AudioSystem.getClip();
// clip.open(AudioSystem.getAudioInputStream(pew));
// clip.start();
// System.out.println("sound");
// System.out.println(clip.isRunning());
// } catch (Exception e) {

// }
// }

