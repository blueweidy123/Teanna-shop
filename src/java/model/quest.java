/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anlal
 */
public class quest {
    
    
    private String id;
    private String content;
    private String A;
    private String B;
    private String C;
    private String D;
    private String Answer;

    public quest() {
    }

    public quest(String id, String content, String A, String B, String C, String D, String Answer) {
        this.id = id;
        this.content = content;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.Answer = Answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getD() {
        return D;
    }

    public void setD(String D) {
        this.D = D;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }

    @Override
    public String toString() {
        return "quest{" + "id=" + id + ", content=" + content + ", A=" + A + ", B=" + B + ", C=" + C + ", D=" + D + ", Answer=" + Answer + '}';
    }
    
}
