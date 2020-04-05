package menu.options;

public enum ExerciseOption {
    BACK("back"),
    ALEX("alex"),
    MAX("pidr");
   private String option;
   ExerciseOption(String option){
       this.option = option;
   }

    public String getOption() {
        return option;
    }
    @Override
    public String toString(){
       return option;
    }
}
