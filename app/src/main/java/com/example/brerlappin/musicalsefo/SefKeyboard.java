package com.example.brerlappin.musicalsefo;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SefKeyboard extends Activity {
    public int currentNote = -1;
    public int currentPlayer = 0;
    public MediaPlayer[] notePlayers;
    public int[] currentMediaNotes;
    public static final int MAX_NOTE_PLAYS = 4;
    public Thread playerThread;
    public boolean isRunning = true;
    public Context playerContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sef_keyboard);
        setContentView(R.layout.activity_sef_scroll_keyboard);

        playerContext = this;
        initializeKeys();

        notePlayers = new MediaPlayer[MAX_NOTE_PLAYS];
        currentMediaNotes = new int[MAX_NOTE_PLAYS];
        for(int x=0;x<MAX_NOTE_PLAYS;x++){
            currentMediaNotes[x] = -1;
        }

        playerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(isRunning){
                    if(currentNote >= 0){
                        int tempNote;
                        //synchronized (this) {
                            tempNote = currentNote;
                            currentNote = -1;
                        //}

                        if(notePlayers[currentPlayer] != null){
                            //Stops and destroys player to reuse it
                            if(notePlayers[currentPlayer].isPlaying())
                                continue;

                            notePlayers[currentPlayer].release();
                            notePlayers[currentPlayer] = null;
                        }

                        //System.out.println("Attempting to play note with resource ID: "+tempNote);
                        notePlayers[currentPlayer] = MediaPlayer.create(playerContext, tempNote);
                        notePlayers[currentPlayer].start();

                        currentPlayer++;
                        if(currentPlayer >= MAX_NOTE_PLAYS){
                            currentPlayer = 0;
                        }
                    }
                    try {
                        //wait();
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Thread.yield();
                }
            }
        });
        playerThread.start();
    }
    @Override
    protected void onStop(){
        isRunning = false;
        super.onStop();
    }

    private void initializeKeys(){
        Button do3 = (Button) findViewById(R.id.Do3);
        Button do3s = (Button) findViewById(R.id.Do3_Sos);
        Button re3 = (Button) findViewById(R.id.Re3);
        Button re3s = (Button) findViewById(R.id.Re3_Sos);
        Button mi3 = (Button) findViewById(R.id.Mi3);
        Button fa3 = (Button) findViewById(R.id.Fa3);
        Button fa3s = (Button) findViewById(R.id.Fa3_Sos);
        Button sol3 = (Button) findViewById(R.id.Sol3);
        Button sol3s = (Button) findViewById(R.id.Sol3_Sos);
        Button la3 = (Button) findViewById(R.id.La3);
        Button la3s = (Button) findViewById(R.id.La3_Sos);
        Button si3 = (Button) findViewById(R.id.Si3);
        Button do4 = (Button) findViewById(R.id.Do4);
        Button do4s = (Button) findViewById(R.id.Do4_Sos);
        Button re4 = (Button) findViewById(R.id.Re4);
        Button re4s = (Button) findViewById(R.id.Re4_Sos);
        Button mi4 = (Button) findViewById(R.id.Mi4);
        Button fa4 = (Button) findViewById(R.id.Fa4);
        Button fa4s = (Button) findViewById(R.id.Fa4_Sos);
        Button sol4 = (Button) findViewById(R.id.Sol4);
        Button sol4s = (Button) findViewById(R.id.Sol4_Sos);
        Button la4 = (Button) findViewById(R.id.La4);
        Button la4s = (Button) findViewById(R.id.La4_Sos);
        Button si4 = (Button) findViewById(R.id.Si4);
        Button do5 = (Button) findViewById(R.id.Do5);
        Button do5s = (Button) findViewById(R.id.Do5_Sos);
        Button re5 = (Button) findViewById(R.id.Re5);
        Button re5s = (Button) findViewById(R.id.Re5_Sos);
        Button mi5 = (Button) findViewById(R.id.Mi5);
        Button fa5 = (Button) findViewById(R.id.Fa5);
        Button fa5s = (Button) findViewById(R.id.Fa5_Sos);
        Button sol5 = (Button) findViewById(R.id.Sol5);
        Button sol5s = (Button) findViewById(R.id.Sol5_Sos);
        Button la5 = (Button) findViewById(R.id.La5);
        Button la5s = (Button) findViewById(R.id.La5_Sos);
        Button si5 = (Button) findViewById(R.id.Si5);

        do3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //System.out.println("--------------------- Touching DO ("+motionEvent+")---------------------");
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(101);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(101);//STOP!!!
                return false;
            }
        });
        do3s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(102);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(102);//STOP!!!
                return false;
            }
        });
        re3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(103);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(103);//STOP!!!
                return false;
            }
        });
        re3s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(104);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(104);//STOP!!!
                return false;
            }
        });
        mi3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(105);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(105);//STOP!!!
                return false;
            }
        });
        fa3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(106);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(106);//STOP!!!
                return false;
            }
        });
        fa3s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(107);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(107);//STOP!!!
                return false;
            }
        });
        sol3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(108);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(108);//STOP!!!
                return false;
            }
        });
        sol3s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(109);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(109);//STOP!!!
                return false;
            }
        });
        la3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(1);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(1);//STOP!!!
                return false;
            }
        });
        la3s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(2);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(2);//STOP!!!
                return false;
            }
        });
        si3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(3);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(3);//STOP!!!
                return false;
            }
        });
        do4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //System.out.println("--------------------- Touching DO ("+motionEvent+")---------------------");
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(4);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(4);//STOP!!!
                return false;
            }
        });
        do4s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(5);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(5);//STOP!!!
                return false;
            }
        });
        re4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(6);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(6);//STOP!!!
                return false;
            }
        });
        re4s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(7);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(7);//STOP!!!
                return false;
            }
        });
        mi4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(8);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(8);//STOP!!!
                return false;
            }
        });
        fa4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(9);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(9);//STOP!!!
                return false;
            }
        });
        fa4s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(10);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(10);//STOP!!!
                return false;
            }
        });
        sol4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(11);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(11);//STOP!!!
                return false;
            }
        });
        sol4s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(12);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(12);//STOP!!!
                return false;
            }
        });
        la4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(13);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(13);//STOP!!!
                return false;
            }
        });
        la4s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(14);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(14);//STOP!!!
                return false;
            }
        });
        si4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(15);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(15);//STOP!!!
                return false;
            }
        });
        do5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(16);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(16);//STOP!!!
                return false;
            }
        });
        do5s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(17);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(17);//STOP!!!
                return false;
            }
        });
        re5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(18);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(18);//STOP!!!
                return false;
            }
        });
        re5s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(201);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(201);//STOP!!!
                return false;
            }
        });
        mi5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(202);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(202);//STOP!!!
                return false;
            }
        });
        fa5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(203);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(203);//STOP!!!
                return false;
            }
        });
        fa5s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(204);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(204);//STOP!!!
                return false;
            }
        });
        sol5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(205);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(205);//STOP!!!
                return false;
            }
        });
        sol5s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(206);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(206);//STOP!!!
                return false;
            }
        });
        la5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(207);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(207);//STOP!!!
                return false;
            }
        });
        la5s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(208);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(208);//STOP!!!
                return false;
            }
        });
        si5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    playNote(209);
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    stopNote(209);//STOP!!!
                return false;
            }
        });

        /* //OLD REFERENCE
        la3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playNote(1);
            }
        });
        */
    }
    public void stopNote(int noteID){
        int posicion;
        for(posicion=0; posicion<MAX_NOTE_PLAYS; posicion++){
            if(currentMediaNotes[posicion] == noteID){
                currentMediaNotes[posicion] = -1;
                /*
                if(notePlayers[posicion] != null) {
                    notePlayers[posicion].stop();
                    notePlayers[posicion].release();
                    notePlayers[posicion] = null;
                }
                */
                break;
            }
        }
    }
    public void playNote(int noteID){
        currentMediaNotes[currentPlayer] = noteID;
        //synchronized (this) {
            switch(noteID){
                case 101:
                    currentNote = R.raw.c3;
                    break;
                case 102:
                    currentNote = R.raw.c3s;
                    break;
                case 103:
                    currentNote = R.raw.d3;
                    break;
                case 104:
                    currentNote = R.raw.d3s;
                    break;
                case 105:
                    currentNote = R.raw.e3;
                    break;
                case 106:
                    currentNote = R.raw.f3;
                    break;
                case 107:
                    currentNote = R.raw.f3s;
                    break;
                case 108:
                    currentNote = R.raw.g3;
                    break;
                case 109:
                    currentNote = R.raw.g3s;
                    break;
                case 1:
                    currentNote = R.raw.a3;
                    break;
                case 2:
                    currentNote = R.raw.a3s;
                    break;
                case 3:
                    currentNote = R.raw.b3;
                    break;
                case 4:
                    currentNote = R.raw.c4;
                    break;
                case 5:
                    currentNote = R.raw.c4s;
                    break;
                case 6:
                    currentNote = R.raw.d4;
                    break;
                case 7:
                    currentNote = R.raw.d4s;
                    break;
                case 8:
                    currentNote = R.raw.e4;
                    break;
                case 9:
                    currentNote = R.raw.f4;
                    break;
                case 10:
                    currentNote = R.raw.f4s;
                    break;
                case 11:
                    currentNote = R.raw.g4;
                    break;
                case 12:
                    currentNote = R.raw.g4s;
                    break;
                case 13:
                    currentNote = R.raw.a4;
                    break;
                case 14:
                    currentNote = R.raw.a4s;
                    break;
                case 15:
                    currentNote = R.raw.b4;
                    break;
                case 16:
                    currentNote = R.raw.c5;
                    break;
                case 17:
                    currentNote = R.raw.c5s;
                    break;
                case 18:
                    currentNote = R.raw.d5;
                    break;
                case 201:
                    currentNote = R.raw.d5s;
                    break;
                case 202:
                    currentNote = R.raw.e5;
                    break;
                case 203:
                    currentNote = R.raw.f5;
                    break;
                case 204:
                    currentNote = R.raw.f5s;
                    break;
                case 205:
                    currentNote = R.raw.g5;
                    break;
                case 206:
                    currentNote = R.raw.g5s;
                    break;
                case 207:
                    currentNote = R.raw.a5;
                    break;
                case 208:
                    currentNote = R.raw.a5s;
                    break;
                case 209:
                    currentNote = R.raw.b5;
                    break;
                default:
                    Toast.makeText(this, "Key not found!", Toast.LENGTH_SHORT).show();
            }
        //}

        //playerThread.notify();
    }
}
