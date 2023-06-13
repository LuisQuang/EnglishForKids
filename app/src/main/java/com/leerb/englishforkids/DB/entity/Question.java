package com.leerb.englishforkids.DB.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "question")
public class Question {
    public Question() {
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    public int id;

    @ColumnInfo(name = "question")
    public String question;

    @ColumnInfo(name = "level")
    public int level;

    @ColumnInfo(name = "casea")
    public String caseA;

    @ColumnInfo(name = "caseb")
    public String caseB;

    @ColumnInfo(name = "casec")
    public String caseC;

    @ColumnInfo(name = "cased")
    public String caseD;

    @ColumnInfo(name = "truecase")
    public String trueCase;


    public Question(int id, String question, int level, String caseA, String caseB, String caseC, String caseD, String trueCase) {
        this.id = id;
        this.question = question;
        this.level = level;
        this.caseA = caseA;
        this.caseB = caseB;
        this.caseC = caseC;
        this.caseD = caseD;
        this.trueCase = trueCase;
    }


    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getLevel() {
        return level;
    }

    public String getCaseA() {
        return caseA;
    }

    public String getCaseB() {
        return caseB;
    }

    public String getCaseC() {
        return caseC;
    }

    public String getCaseD() {
        return caseD;
    }

    public String getTrueCase() {
        return trueCase;
    }
}
