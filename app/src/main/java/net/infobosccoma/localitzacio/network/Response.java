package net.infobosccoma.localitzacio.network;

/**
 * Created by Kevin on 25/03/2016.
 */
public class Response {

    private boolean estat;
    private String missatge;

    public Response() {
    }

    public Response(boolean estat, String missatge) {
        this.estat = estat;
        this.missatge = missatge;
    }

    public boolean isEstat() {
        return estat;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    public String getMissatge() {
        return missatge;
    }

    public void setMissatge(String missatge) {
        this.missatge = missatge;
    }
}
