package Assessments;

public class ProgrammingTest extends Assessment {
    private String[] subassessments = {"PROGRAM_MARK","EXPLAINED_SUCESSFULLY"};

    public ProgrammingTest(String name, String cid, String type) {
        super(name, cid, type);
        super.submarks = new double[] {AssessmentFeed.getResult(cid,AssessmentFeed.PROGRAMMING_TEST,AssessmentFeed.PROGRAM_MARK),AssessmentFeed.getResult(cid,AssessmentFeed.PROGRAMMING_TEST,AssessmentFeed.EXPLAINED_SUCCESSFULLY)};
    }
}
