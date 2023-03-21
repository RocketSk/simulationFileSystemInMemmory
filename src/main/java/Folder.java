import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Folder implements Data, Serializable {
    static final long serialVersionUID = 1;
    private final ArrayList<Data> folder = new ArrayList<>();
    private final String name;
    private String ident = "";

    Folder(String name) {
        this.name = name;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public boolean contains(Data data) {
        return folder.contains(data);
    }

    public Folder getNewCurrentFolder(Folder folder) {
        return (Folder) this.folder.get(this.folder.indexOf(folder));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Folder folder = (Folder) o;
        return name.equals(folder.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void addToFolder(Data data) {
        if (!folder.contains(data)) {
            folder.add(data);
        }
    }

    public void print() {
        System.out.println(ident + name + " contains " + folder.size()
                + " elements");
        for (Data data : folder) {
            data.setIdent(ident + "    ");
            data.print();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
