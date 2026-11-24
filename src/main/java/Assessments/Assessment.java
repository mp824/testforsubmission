package Assessments;

public abstract class Assessment {
    protected String name;
    protected String cid;
    protected String type;
    protected double[] submarks;

    Assessment(String name, String cid, String type) {
        this.name = name;
        this.cid = cid;
        this.type = type;
        this.submarks = new double[2];
    }

    public double[] getMarks() {
        return this.submarks;
    }
}
