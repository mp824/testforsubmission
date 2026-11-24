package Assessments;

public class AiProject extends Assessment {
    private double[] submarks;
    private String[] subassessments = {"FUNCTIONALITY_MARK","VERIFICATION_MARK"};

    public AiProject(String name, String cid, String type) {
        super(name, cid, type);
        super.submarks = new double[] {AssessmentFeed.getResult(cid,AssessmentFeed.AI_PROJECT,AssessmentFeed.FUNCTIONALITY_MARK),AssessmentFeed.getResult(cid,AssessmentFeed.AI_PROJECT,AssessmentFeed.VERIFICATION_MARK)};
    }

}