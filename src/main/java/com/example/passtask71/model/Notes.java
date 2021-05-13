package com.example.passtask71.model;

public class Notes {
    private long note_id;
    private String note_description;

    public Notes(String note_description) {
        this.note_description = note_description;
    }

    public Notes(long note_id, String note_description) {
        this.note_id = note_id;
        this.note_description = note_description;
    }

    public Notes() {
    }

    public long getNote_id() {
        return note_id;
    }

    public void setNote_id(long note_id) {
        this.note_id = note_id;
    }

    public String getNote_description() {
        return note_description;
    }

    public void setNote_description(String note_description) {
        this.note_description = note_description;
    }
}
