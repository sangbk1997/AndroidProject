package com.example.sangbk.note;

import java.io.Serializable;

/**
 * Created by Sangbk on 10/11/2017.
 */

public class note implements Serializable {
    private int noteId;
    private String noteTitle;
    private String noteContent;
    public note(){

    }
    public note(String noteTitle,String noteContent){
        this.noteTitle=noteTitle;
        this.noteContent=noteContent;
    }
    public note(int noteId,String noteTitle,String noteContent){
        this.noteId=noteId;
        this.noteTitle=noteTitle;
        this.noteContent=noteContent;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
    public String toString(){
        return this.noteTitle;
    }

}
