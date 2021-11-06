package org.example.hellomaven;

import javax.sound.sampled.*;
import java.io.File;

public class Player implements LineListener {
    String url;
    public Player(String url)
    {
        this.url=url;
    }

    Long currentFrame;
    Clip clip;
    String status;
    AudioInputStream ais;
    boolean playCompleted;
    public void audioPlayer()
    {
        try
        {
            ais= AudioSystem.getAudioInputStream(new File(url).getAbsoluteFile());
            clip=AudioSystem.getClip();
            clip.open(ais);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void play()
    {
        clip.start();
        status="play";
    }

    public long pause()
    {
        if (status.equals("paused"))
        {
            System.out.println("audio is already paused");
            return 0;
        }
        this.currentFrame =
                this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
        return currentFrame;
    }

    public void resume(long currentFrame)
    {
        if (status.equals("play"))
        {
            System.out.println("Audio is already "+
                    "being played");
            return;
        }

        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    private void resetAudioStream() {
        try
        {
            ais = AudioSystem.getAudioInputStream(
                    new File(url).getAbsoluteFile());
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public void stop()
    {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }


    public void update(LineEvent event)
    {
        LineEvent.Type type=event.getType();
        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");

        } else if (type == LineEvent.Type.STOP) {
            boolean playCompleted = true;
            System.out.println("Playback completed.");
        }
    }
    public boolean isActive()
    {
        clip.addLineListener(this);
        if(playCompleted=true)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public void loop()
    {
        clip.loop(1);
    }
}
