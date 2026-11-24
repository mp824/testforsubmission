import Assessments.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    static JFrame frame;
    static JPanel[] panels = new JPanel[AssessmentFeed.getCIDs().size()];
    static JLabel[] labels = new JLabel[AssessmentFeed.getCIDs().size()];



    public static void main(String[] args) {
        buildWindow();
        updateFrame();


    }
    static void buildWindow(){
        frame = new JFrame();
        frame.setSize(1000,1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(AssessmentFeed.getCIDs().size(),1));
        for (int i = 0; i < AssessmentFeed.getCIDs().size(); i++) {
            panels[i] = new JPanel();
            labels[i] = new JLabel();
            panels[i].add(labels[i]);
            frame.add(labels[i]);
        }
        frame.setVisible(true);
    }

    static void updateFrame() {
        for (int i = 0; i < AssessmentFeed.getCIDs().size(); i++) {
            String cid = AssessmentFeed.getCIDs().get(i);
            String name = AssessmentFeed.getStudentName(cid);
            String type = AssessmentFeed.getStudentType(cid);
            ProgrammingTest a = new ProgrammingTest(name,cid,type);
            AiProject b = new AiProject(name,cid,type);
            if(type.equals("MSc")) {
                DesignViva c = new DesignViva(name,cid,type);
                String t = "  Name: " + name + "  |  CID: " + cid + "  |  Type: " + type + "  |  " + AssessmentFeed.PROGRAMMING_TEST + ": " + (a.getMarks()[1] == 1.0 ? String.valueOf(a.getMarks()[0]) : "40") + "  |  " + AssessmentFeed.AI_PROJECT + ": " +  String.valueOf(0.4*b.getMarks()[0]+0.6*b.getMarks()[1]) + "  |  " + AssessmentFeed.DESIGN_VIVA + ": " +  String.valueOf(0.5*(c.getMarks()[0]+c.getMarks()[1]))+ "  |  Overall Weighted Mark: " + String.valueOf(0.25*Double.parseDouble((a.getMarks()[1] == 1.0 ? String.valueOf(a.getMarks()[0]) : "40")) + 0.45 *(0.4*b.getMarks()[0]+0.6*b.getMarks()[1]) + 0.3*(0.5*(c.getMarks()[0]+c.getMarks()[1])));
                labels[i].setText(t);
                if ((0.4*b.getMarks()[0]+0.6*b.getMarks()[1] >= (a.getMarks()[1] == 1.0 ? a.getMarks()[0] : 40) + 20) || (0.4*b.getMarks()[0]+0.6*b.getMarks()[1] >= 0.5*(c.getMarks()[0]+c.getMarks()[1]) +20)) {
                    panels[i].setBackground(Color.red);
                };
            }
            else {
                String t = "  Name: " + name + "  |  CID: " + cid + "  |  Type: " + type + "  |  " + AssessmentFeed.PROGRAMMING_TEST + ": " + (a.getMarks()[1] == 1.0 ? String.valueOf(a.getMarks()[0]) : "40") + "  |  " + AssessmentFeed.AI_PROJECT + ": " +  String.valueOf(0.4*b.getMarks()[0]+0.6*b.getMarks()[1]) + "  |  " + AssessmentFeed.DESIGN_VIVA + ": N/A" + "  |  Overall Weighted Mark: " + String.valueOf(0.3*Double.parseDouble((a.getMarks()[1] == 1.0 ? String.valueOf(a.getMarks()[0]) : "40")) + 0.7 *(0.4*b.getMarks()[0]+0.6*b.getMarks()[1]));
                labels[i].setText(t);
                if (0.4*b.getMarks()[0]+0.6*b.getMarks()[1] >= (a.getMarks()[1] == 1.0 ? a.getMarks()[0] : 40) + 20) {
                    panels[i].setBackground(Color.red);
                }
            }
        }
    }
}
