package sample;

public class Formroommodel {
    String Rnum;
    String Rlevel;
    String Rarea;
    String Rprice;
    String Rstate;
    public Formroommodel(String rnum,String rlevel,String rarea,String rprice,String rstate){
        Rnum=rnum;
        Rlevel=rlevel;
        Rarea=rarea;
        Rprice=rprice;
        Rstate=rstate;
    }

    public String getRnum() {
        return Rnum;
    }

    public void setRnum(String rnum) {
        Rnum = rnum;
    }

    public String getRlevel() {
        return Rlevel;
    }

    public void setRlevel(String rlevel) {
        Rlevel = rlevel;
    }

    public String getRarea() {
        return Rarea;
    }

    public void setRarea(String rarea) {
        Rarea = rarea;
    }

    public String getRprice() {
        return Rprice;
    }

    public void setRprice(String rprice) {
        Rprice = rprice;
    }

    public String getRstate() {
        return Rstate;
    }

    public void setRstate(String rstate) {
        Rstate = rstate;
    }
}
