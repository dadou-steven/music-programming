package music.examples;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import music.Instrument;
import music.Pitch;
import music.SequencePlayer;
import music.midi.MidiSequencePlayer;

public class ScaleSequence {
    
    /**
     * Play an octave up and back down starting from middle C.
     * 
     * @param args not used
     * @throws MidiUnavailableException if MIDI device unavailable
     * @throws InvalidMidiDataException if MIDI play fails
    */
    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException {

        Instrument piano = Instrument.PIANO;

        // create a new player
        final int beatsPerMinute = 120; // a beat is a quarter note, so this is 120 quarter notes per minute
        final int ticksPerBeat = 2;
        SequencePlayer player = new MidiSequencePlayer(beatsPerMinute, ticksPerBeat);

        // addNote(instr, pitch, startBeat, numBeats) schedules a note with pitch value 'pitch'
        // played by 'instr' starting at 'startBeat' to be played for 'numBeats' beats.
        
        int startBeat = 0;
        int numBeats = 1;
        player.addNote(piano, new Pitch('C'), startBeat++, numBeats);
        player.addNote(piano, new Pitch('D'), startBeat++, numBeats);
        player.addNote(piano, new Pitch('E'), startBeat++, numBeats);
        player.addNote(piano, new Pitch('F'), startBeat++, numBeats);
        player.addNote(piano, new Pitch('G'), startBeat++, numBeats);
        player.addNote(piano, new Pitch('A'), startBeat++, numBeats);
        player.addNote(piano, new Pitch('B'), startBeat++, numBeats);
        player.addNote(piano, new Pitch('C').transpose(Pitch.OCTAVE), startBeat++, numBeats);
        player.addNote(piano, new Pitch('B'), startBeat++, numBeats);
        player.addNote(piano, new Pitch('A'), startBeat++, numBeats);
        player.addNote(piano, new Pitch('G'), startBeat++, numBeats);
        player.addNote(piano, new Pitch('F'), startBeat++, numBeats);
        player.addNote(piano, new Pitch('E'), startBeat++, numBeats);
        player.addNote(piano, new Pitch('D'), startBeat++, numBeats);
        player.addNote(piano, new Pitch('C'), startBeat++, numBeats);

        System.out.println(player);

        // play!
        player.play();
    }
}
