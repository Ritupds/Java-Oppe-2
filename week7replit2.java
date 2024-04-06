import java.util.ArrayList;
import java.util.List;


class NoTeamMemberException extends Exception{
    public NoTeamMemberException(String s){
        super(s);
    }
}

class Project{
    String projectName;
    ArrayList<String> teamMembers= new ArrayList<String>();
  
    public Project(String projectName){
      this.projectName = projectName;
    }
    public void addTeamMember(String name){
      teamMembers.add(name);
    }
  
    public String toString(){
      return ("Project Name: "+projectName+"\nTeam Members: "+teamMembers);
    }
  
    public boolean hasTeamMember() throws NoTeamMemberException{
      if (!teamMembers.isEmpty()){
        return true;
      }
      else {
        throw new NoTeamMemberException("No team member found");
      }
    }
  }

public class week7replit2 {
    public static void updateProjectList(List<Project> projects){
       for (Project project : projects){
        try{
            project.hasTeamMember();
        }
        catch(NoTeamMemberException e){
            project.addTeamMember("default");
        }
       }
    }

    public static void displayProjectList(List<Project> projects){
        for(Project project : projects){
            System.out.println(project);
        }
    }
    
    
    
    
    public static void main(String[] args) {
      
      List<Project> projects = new ArrayList<>();

      
      projects.add(new Project("Project 1"));
      projects.add(new Project("Project 2"));
      projects.add(new Project("Project 3"));

      updateProjectList(projects);

   
      System.out.println("Updated Project List:");
      displayProjectList(projects);
  }
}
