package Assessments;

public class DesignViva extends Assessment {
    private String[] subassessments = {"DESIGN_MARK","EXPLANATION_MARK"};

    public DesignViva(String name, String cid, String type) {
        super(name, cid, type);
        super.submarks = new double[] {AssessmentFeed.getResult(cid,AssessmentFeed.DESIGN_VIVA,AssessmentFeed.DESIGN_MARK),AssessmentFeed.getResult(cid,AssessmentFeed.DESIGN_VIVA,AssessmentFeed.EXPLANATION_MARK)};
    }
}
