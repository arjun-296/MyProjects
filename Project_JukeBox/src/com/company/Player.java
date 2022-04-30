package com.company;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Player
{
    Scanner sc = new Scanner(System.in);

    Long currentFrame;   // to store current position
    Clip clip;


    String status;		// current status of clip

    AudioInputStream audioInputStream;


    // constructor to initialize streams and clip
    public Player(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException, SQLException
    {

        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());  // create AudioInputStream object


        clip = AudioSystem.getClip();		// creating clip reference


        clip.open(audioInputStream);		// open audioInputStream to the clip

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }


    // Method to play the track.
    public void play()
    {

        clip.start();	//start the clip

        status = "play";
    }



    // Method to pause the track.
    public void pause()
    {
        if (status.equals("paused"))
        {
            System.out.println("audio paused");
            return;
        }
        this.currentFrame = this.clip.getMicrosecondPosition();		//saving the microsecond frameposition and which the song was stopped.
        clip.stop();					// halting the track.
        status = "paused";

    }



    // Method to resume the track.
    public void resumeAudio(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        if (status.equals("play"))
        {
            System.out.println("Audio being played");
            return;
        }
        clip.close();
        resetAudioStream(filePath);			//calling the reset method and passing the url of the track being played
        clip.setMicrosecondPosition(currentFrame);	//passing the saved frameposition from the paused method.
        this.play();	//the song being played from the saved frame-microsecond.
    }



    // Method to restart the track.
    public void restart(String filePath) throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {
        clip.stop();
        clip.close();
        resetAudioStream(filePath);		//calling the reset method and passing the URL of the track.
        currentFrame = 0L;				//decalring the frame position of the song as 00:00:00(hh:mm:ss).
        clip.setMicrosecondPosition(0);	//passing the frame postion to the set the microsecond position
        this.play();
    }



    // Method to stop the track.
    public void stop() {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }



    // Method to reset the audio input stream.
    public void resetAudioStream(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }


    // method  to take match the user input with the action it performs.
    tracklistops to=new  tracklistops();
    public void userChoice(int c,String filePath)throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {
        switch (c) {
            case 1 -> pause();
            case 2 -> resumeAudio(filePath);
            case 3 -> restart(filePath);
            case 4 -> stop();
        }
    }










}