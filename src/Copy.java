public class Copy {
    private int id;
    private CopyStatus status;
    Copy(int id, CopyStatus status){
        this.id=id;
        this.status=status;
    }

    public void setStatus(CopyStatus status){
        this.status=status;
    }

    public CopyStatus getStatus(){
        return status;
    }

    public int getId(){
        return id;
    }
}
