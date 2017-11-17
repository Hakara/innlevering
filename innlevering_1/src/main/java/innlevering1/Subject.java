package innlevering1;

public class Subject {
    private String emneKode;
    private String emneNavn;
    private String elever;
    private String foreleser;
    private String romNr;

    public String getEmneKode() {
        return emneKode;
    }

    public String getEmneNavn() {
        return emneNavn;
    }

    public Integer getElever() {
        return Integer.parseInt(elever);
    }

    public String getForeleser() {
        return foreleser;
    }

    public String getRomNr() {
        return romNr;
    }

    public Subject(String[] attributes){
        this.emneKode = attributes[0];
        this.emneNavn = attributes[1];
        this.elever = attributes[2];
        this.foreleser = attributes[3];
        this.romNr = attributes[4];
    }


}
