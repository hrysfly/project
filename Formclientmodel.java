package sample;

public class Formclientmodel {
    String Cid;
    String Cname;
    String Rnum;
    String Rlevel;
    String Stime;
    String Estime;
    String Cost;
    public Formclientmodel(String cid,String cname,String rnum,String rlevel,String stime,String estime,String cost){
        Cid=cid;
        Cname=cname;
        Rnum=rnum;
        Rlevel=rlevel;
        Stime=stime;
        Estime=estime;
        Cost=cost;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
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

    public String getStime() {
        return Stime;
    }

    public void setStime(String stime) {
        Stime = stime;
    }

    public String getEstime() {
        return Estime;
    }

    public void setEstime(String estime) {
        Estime = estime;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }
}
